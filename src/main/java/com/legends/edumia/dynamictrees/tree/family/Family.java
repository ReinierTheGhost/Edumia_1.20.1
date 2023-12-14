package com.legends.edumia.dynamictrees.tree.family;

import com.google.common.io.Files;
import com.legends.edumia.dynamictrees.api.TreeHelper;
import com.legends.edumia.dynamictrees.api.registry.RegistryEntry;
import com.legends.edumia.dynamictrees.api.registry.TypedRegistry;
import com.legends.edumia.dynamictrees.block.branch.BranchBlock;
import com.legends.edumia.dynamictrees.block.leaves.DynamicLeavesBlock;
import com.legends.edumia.dynamictrees.block.leaves.LeavesProperties;
import com.legends.edumia.dynamictrees.compat.waila.WailaOther;
import com.legends.edumia.dynamictrees.init.DTTrees;
import com.legends.edumia.dynamictrees.tree.Resettable;
import com.legends.edumia.dynamictrees.tree.species.Species;
import com.legends.edumia.dynamictrees.util.BlockBounds;
import com.legends.edumia.dynamictrees.util.Optionals;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.apache.logging.log4j.LogManager;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Supplier;

/**
 * This structure describes a Family whose member Species all have a common branch.
 * <p>
 * A {@link Family} is more or less just a definition of {@link BranchBlock} blocks. It also defines the cellular
 * automata function of the {@link BranchBlock}.  It defines the type of wood that the tree is made of and consequently
 * what kind of log you get when you cut it down.
 * <p>
 * A DynamicTree does not contain a reference to a Seed, Leaves, Sapling, or how it should grow(how fast, how tall,
 * etc). It does not control what drops it produces or what fruit it grows.  It does not control where it should grow.
 * All of these capabilities lie in the Species class for which a DynamicTree should always contain one default
 * species(the common species).
 *
 * @author ferreusveritas
 */
public class Family extends RegistryEntry<Family> implements Resettable<Family> {


    public static final TypedRegistry.EntryType<Family> TYPE = TypedRegistry.newType(Family::new);

    //Branches
    /**
     * The dynamic branch used by this tree family
     */
    private Supplier<BranchBlock> branch;
    /**
     * The stripped variant of the branch used by this tree family
     */
    private Supplier<BranchBlock> strippedBranch;
    protected boolean hasStrippedBranch = true;

    /**
     * The primitive (vanilla) log to base the texture, drops, and other behavior from
     */
    private Block primitiveLog = Blocks.AIR;
    /**
     * The primitive stripped log to base the texture, drops, and other behavior from
     */
    private Block primitiveStrippedLog = Blocks.AIR;

    /**
     * A list of branches the tree accepts as its own. Used for the falling tree renderer
     */
    private final List<BranchBlock> validBranches = new LinkedList<>();

    public final static Family NULL_FAMILY = new Family() {

    };

    /**
     * A list of child species, added to when tree family is set for species.
     */
    private final Set<Species> species = new HashSet<>();

    /**
     * The dynamic branch's block item
     */
    private Supplier<Item> branchItem;

    private Family() {
        this.setRegistryName(DTTrees.NULL);
    }

    /**
     * Constructor suitable for derivative mods
     *
     * @param name The ResourceLocation of the tree e.g. "mymod:poplar"
     */
    public Family(ResourceLocation name) {
        this.setRegistryName(name);
        this.commonSpecies = Species.NULL_SPECIES;
    }

    /**
     * Central registry for all {@link Family} objects.
     */
    public static final TypedRegistry<Family> REGISTRY = new TypedRegistry<>(Family.class, NULL_FAMILY, TYPE);

    protected Species commonSpecies;
    protected LeavesProperties commonLeaves = LeavesProperties.NULL;

    /**
     * Gets the primitive full block (vanilla)log that represents this tree's material. Chiefly used to determine the
     * wood hardness for harvesting behavior.
     *
     * @return Block of the primitive log.
     */
    public Optional<Block> getPrimitiveLog() {
        return Optionals.ofBlock(primitiveLog);
    }

    public Optional<Block> getPrimitiveStrippedLog() {
        return Optionals.ofBlock(primitiveStrippedLog);
    }

    public Optional<BranchBlock> getStrippedBranch() {
        return Optionals.ofBlock(this.strippedBranch);
    }

    public Optional<Item> getBranchItem() {
        return Optionals.ofItem(this.branchItem);
    }

    public Species getCommonSpecies() {
        return commonSpecies;
    }

    ///////////////////////////////////////////
    // LEAVES HANDLING
    ///////////////////////////////////////////

    /**
     * When destroying leaves, an area is created from the branch endpoints to look for leaves blocks and destroy them.
     * This area is then expanded by a certain size to make sure it covers all the leaves in the canopy.
     *
     * @return the expanded block bounds.
     */
    public BlockBounds expandLeavesBlockBounds(BlockBounds bounds) {
        return bounds.expand(3);
    }

    private int primaryThickness = 1;
    private int secondaryThickness = 2;

    /**
     * Thickness of a twig [default = 1]
     */
    public int getPrimaryThickness() {
        return primaryThickness;
    }

    public boolean isCompatibleDynamicLeaves(Species species, BlockState blockState, BlockGetter blockAccess, BlockPos pos) {
        final DynamicLeavesBlock leaves = TreeHelper.getLeaves(blockState);
        return (leaves != null) && (this == leaves.getFamily(blockState, blockAccess, pos)
                || species.isValidLeafBlock(leaves));
    }
    public boolean isCompatibleGenericLeaves(final Species species, BlockState blockState, LevelAccessor blockAccess, BlockPos pos) {
        return this.isCompatibleDynamicLeaves(species, blockState, blockAccess, pos);
    }

    ///////////////////////////////////////////
    // INTERACTION
    ///////////////////////////////////////////

    public static class TreeActivationContext {
        public final Level level;
        public final BlockPos rootPos;
        public final BlockPos hitPos;
        public final BlockState hitState;
        public final Player player;
        public final InteractionHand hand;
        @Nullable
        public final ItemStack heldItem;
        public final BlockHitResult hitResult;

        public TreeActivationContext(Level level, BlockPos rootPos, BlockPos hitPos, BlockState hitState,
                                     Player player, InteractionHand hand, @Nullable ItemStack heldItem,
                                     BlockHitResult hitResult) {
            this.level = level;
            this.rootPos = rootPos;
            this.hitPos = hitPos;
            this.hitState = hitState;
            this.player = player;
            this.hand = hand;
            this.heldItem = heldItem;
            this.hitResult = hitResult;
        }
    }

    public boolean hasStrippedBranch() {
        return this.hasStrippedBranch;
    }

    public boolean onTreeActivated(TreeActivationContext context) {
        if (canStripBranch(context.hitState, context.level, context.hitPos, context.player, context.heldItem)) {
            return stripBranch(context.hitState, context.level, context.hitPos, context.player, context.heldItem);
        }

        if (context.rootPos != BlockPos.ZERO) {
            return TreeHelper.getExactSpecies(context.level, context.hitPos).onTreeActivated(context);
        }

        return false;
    }

    public boolean stripBranch(BlockState state, Level level, BlockPos pos, Player player, ItemStack heldItem) {
        if (this.hasStrippedBranch()) {
            this.getBranch().ifPresent(branch -> {
                branch.stripBranch(state, level, pos, player, heldItem);
                if (level.isClientSide) {
                    level.playSound(player, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
                    WailaOther.invalidateWailaPosition();
                }
            });
            return this.getBranch().isPresent();
        } else {
            return false;
        }
    }

    public boolean canStripBranch(BlockState state, Level level, BlockPos pos, Player player, ItemStack heldItem) {
        BranchBlock branchBlock = TreeHelper.getBranch(state);
        if (branchBlock == null) {
            return false;
        }
        return branchBlock.canBeStripped(state, level, pos, player, heldItem);
    }

    public int getBranchBlockIndex(BranchBlock block) {
        int index = this.validBranches.indexOf(block);
        if (index < 0) {
            LogManager.getLogger().warn("Block {} not valid branch for {}.", block, this);
            return 0;
        }
        return index;
    }

    public LeavesProperties getCommonLeaves() {
        return this.commonLeaves;
    }

    public Family addSpecies(final Species species) {
        this.species.add(species);
        return this;
    }

    private boolean isFireProof = false;

    public boolean isFireProof() {
        return isFireProof;
    }

    public Optional<BranchBlock> getBranch() {
        return Optionals.ofBlock(this.branch);
    }

    ///////////////////////////////////////////
    // SPECIES LOCATION OVERRIDES
    ///////////////////////////////////////////

    public Species getSpeciesForLocation(LevelAccessor level, BlockPos trunkPos) {
        return this.getSpeciesForLocation(level, trunkPos, this.commonSpecies);
    }


    public Species getSpeciesForLocation(BlockGetter level, BlockPos trunkPos, Species defaultSpecies) {
        for (final Species species : this.species) {
            if (species.shouldOverrideCommon(level, trunkPos)) {
                return species;
            }
        }

        return defaultSpecies;
    }


}
