package com.legends.edumia.datafix;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public class ModStructureTemplatePool extends StructureTemplatePool {
    public ModStructureTemplatePool(Holder<StructureTemplatePool> p_255747_, List<Pair<StructurePoolElement, Integer>> p_255919_, List<Pair<StructurePoolElement, Integer>> rawTemplates, ObjectArrayList<StructurePoolElement> templates) {
        super(p_255747_, p_255919_);
        this.rawTemplates = rawTemplates;
        this.templates = templates;
    }

    public final List<Pair<StructurePoolElement, Integer>> rawTemplates;
    public final ObjectArrayList<StructurePoolElement> templates;
}
