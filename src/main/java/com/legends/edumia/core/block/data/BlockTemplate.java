package com.legends.edumia.core.block.data;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.legends.edumia.core.asset.annotation.*;
import com.legends.edumia.core.asset.pack.VirtualResourcepack;
import com.legends.edumia.core.block.builder.BlockName;
import com.legends.edumia.core.block.builder.Props;
import com.legends.edumia.core.util.RenderLayer;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import org.jline.utils.Log;

import javax.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BlockTemplate {

    private final State state;
    private final Model itemModel;
    private final Model[] blockModels;
    private final Recipe[] recipes;
    private final Render render;
    private final boolean plural;

    BlockTemplate(Class<?> type) {
        Assets assets = (Assets)type.getAnnotation(Assets.class);
        this.state = assets != null ? assets.state() : null;
        this.itemModel = assets != null ? assets.item() : null;
        this.blockModels = assets != null ? assets.block() : null;
        this.recipes = assets != null ? assets.recipe() : null;
        this.render = getRender(type, assets);
        this.plural = this.state != null && this.state.plural();
    }

    public RenderLayer getRenderLayer() {
        return this.render == null ? RenderLayer.UNDEFINED : this.render.value();
    }

    public ResourceLocation getRegistryName(BlockName name) {
        return this.state == null ? new ResourceLocation(name.getNamespace(), name.format("%s", this.plural))
                : new ResourceLocation(name.getNamespace(), name.format(this.state.name(), this.plural));
    }

//    public void addClientResources(VirtualResourcepack.Builder builder, BlockName name, Textures textures, ResourceLocation regName) {
//        this.addState(builder, name, regName);
//        this.addItem(builder, name, regName);
//        this.addModel(builder, name, textures, regName);
//    }
//
//    public void registerRenders(Block block, Props props) {
//        if (props.getRenderLayer() != RenderLayer.UNDEFINED) {
//            RenderLayerHelper.register(block, props.getRenderLayer());
//        } else {
//            if (this.render != null) {
//                RenderLayer layer = this.render.value();
//                RenderLayerHelper.register(block, layer);
//            }
//
//        }
//    }
//
//    public void addServerResources(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
//        this.addRecipe(builder, name, regName);
//    }
//
//    private void addState(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
//        if (this.state == null) {
//            Log.debug("No state template for {}", new Object[]{regName});
//        } else {
//            Log.debug("Generating state for {}", new Object[]{regName});
//            String templateName = this.state.template();
//            String virtualName = name.namespaceFormat(this.state.name(), this.state.plural());
//            String templatePath = Locations.statePath(new ResourceLocation(templateName));
//            String virtualPath = Locations.statePath(new ResourceLocation(virtualName));
//            JsonTemplate template = (JsonTemplate)TemplateCache.getInstance().get(templatePath);
//            JsonOverride overrides = this.getOverrides(name, this.blockModels);
//            builder.add(TemplateResource.asset(name.getNamespace(), virtualPath, overrides, template));
//        }
//    }
//
//    private void addModel(VirtualResourcepack.Builder builder, BlockName name, Textures textures, ResourceLocation regName) {
//        if (this.blockModels == null) {
//            Log.debug("No model template for {}", new Object[]{regName});
//        } else {
//            Log.debug("Generating model(s) for {}", new Object[]{regName});
//            Model[] var5 = this.blockModels;
//            int var6 = var5.length;
//
//            for(int var7 = 0; var7 < var6; ++var7) {
//                Model model = var5[var7];
//                String templateName = model.template();
//                String virtualName = name.namespaceFormat(model.name(), model.plural());
//                String templatePath = Locations.modelPath(new ModelResourceLocation(templateName));
//                String virtualPath = Locations.modelPath(new ModelResourceLocation(virtualName));
//                JsonTemplate template = (JsonTemplate)TemplateCache.getInstance().get(templatePath);
//                builder.add(TemplateResource.asset(name.getNamespace(), virtualPath, textures, template));
//            }
//
//        }
//    }
//
//    private void addItem(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
//        if (this.itemModel == null) {
//            Log.debug("No item model template for {}", new Object[]{regName});
//        } else {
//            Log.debug("Generating item model for {}", new Object[]{regName});
//            String templateName = this.itemModel.template();
//            String itemModelName = name.namespaceFormat(this.itemModel.name(), this.plural);
//            String parentModelName = name.namespaceFormat(this.itemModel.parent(), this.plural);
//            String templatePath = Locations.modelPath(new ModelResourceLocation(templateName));
//            String virtualPath = Locations.modelPath(new ModelResourceLocation(itemModelName));
//            JsonOverride overrides = new SingleOverride("parent", new JsonPrimitive(parentModelName));
//            JsonTemplate template = (JsonTemplate)TemplateCache.getInstance().get(templatePath);
//            builder.add(TemplateResource.asset(name.getNamespace(), virtualPath, overrides, template));
//        }
//    }
//
//    private void addRecipe(VirtualResourcepack.Builder builder, BlockName name, ResourceLocation regName) {
//        if (this.recipes != null && this.recipes.length == 1) {
//            Recipe recipe = this.recipes[0];
//            String templateName = recipe.template();
//            String recipeName = name.namespaceFormat(recipe.name(), this.plural);
//            String output = recipe.output().isEmpty() ? recipe.template() : recipe.output();
//            String item = (new ResourceLocation(output)).toString();
//            Ingredient result = createIngredient(recipe.name(), item, this.plural);
//            Ingredient[] ingredients = (Ingredient[])this.push(recipe.ingredients(), result);
//            String templatePath = Locations.recipePath(new ResourceLocation(templateName));
//            String virtualPath = Locations.recipePath(new ResourceLocation(recipeName));
//            JsonOverride overrides = this.getOverrides(name, ingredients);
//            if (overrides == EmptyOverride.EMPTY) {
//                Log.error("Unable to generate recipe for {} (invalid ingredients)", new Object[]{regName});
//            } else {
//                Log.debug("Generating recipe for {}", new Object[]{regName});
//                JsonTemplate template = (JsonTemplate)TemplateCache.getInstance().get(templatePath);
//                builder.add(TemplateResource.data(name.getNamespace(), virtualPath, overrides, template));
//            }
//        } else {
//            Log.debug("No recipe template for {}", new Object[]{regName});
//        }
//    }
//
//    private JsonOverride getOverrides(BlockName name, Model[] replacements) {
//        if (replacements.length == 0) {
//            return EmptyOverride.EMPTY;
//        } else if (replacements.length == 1) {
//            String find = replacements[0].template();
//            String replace = name.namespaceFormat(replacements[0].name(), this.plural);
//            return new SingleOverride("model", new JsonPrimitive(find), new JsonPrimitive(replace));
//        } else {
//            Map<JsonElement, JsonElement> overrides = new HashMap(replacements.length);
//            Model[] var4 = replacements;
//            int var5 = replacements.length;
//
//            for(int var6 = 0; var6 < var5; ++var6) {
//                Model model = var4[var6];
//                String find = model.template();
//                String replace = name.namespaceFormat(model.name(), model.plural());
//                overrides.put(new JsonPrimitive(find), new JsonPrimitive(replace));
//            }
//
//            return new MapOverride("model", overrides);
//        }
//    }
//
//    private JsonOverride getOverrides(BlockName name, Ingredient[] ingredients) {
//        if (ingredients.length == 0) {
//            return EmptyOverride.EMPTY;
//        } else if (ingredients.length == 1) {
//            String find = ingredients[0].template();
//            String replace = this.getIngredient(name, ingredients[0]);
//            return (JsonOverride)(replace.isEmpty() ? EmptyOverride.EMPTY : new SingleOverride("item", new JsonPrimitive(find), new JsonPrimitive(replace)));
//        } else {
//            Map<JsonElement, JsonElement> overrides = new HashMap(ingredients.length);
//            Ingredient[] var4 = ingredients;
//            int var5 = ingredients.length;
//
//            for(int var6 = 0; var6 < var5; ++var6) {
//                Ingredient ingredient = var4[var6];
//                String find = (new ResourceLocation(ingredient.template())).toString();
//                String replace = this.getIngredient(name, ingredient);
//                if (replace.isEmpty()) {
//                    return EmptyOverride.EMPTY;
//                }
//
//                overrides.put(new JsonPrimitive(find), new JsonPrimitive(replace));
//            }
//
//            return new MapOverride("item", overrides);
//        }
//    }

    private String getIngredient(BlockName name, Ingredient ingredient) {
        String itemName = name.format(ingredient.name(), ingredient.plural());
        if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(name.getNamespace(), itemName))) {
            Log.debug(" Found ingredient {}:{}", new Object[]{name.getNamespace(), itemName});
            String var10000 = name.getNamespace();
            return var10000 + ":" + itemName;
        } else if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName))) {
            Log.debug(" Found vanilla ingredient minecraft:{}", new Object[]{itemName});
            return "minecraft:" + itemName;
        } else {
            Log.error(" Unknown ingredient {}", new Object[]{itemName});
            return "";
        }
    }

    private <T> T[] push(T[] t, T value) {
        T[] array = Arrays.copyOf(t, t.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    private static Render getRender(Class<?> type, @Nullable Assets assets) {
        while(type != Object.class) {
            Render render = (Render)type.getAnnotation(Render.class);
            if (render != null) {
                return render;
            }

            if (assets != null && assets.render().value() != RenderLayer.UNDEFINED) {
                return assets.render();
            }

            type = type.getSuperclass();
            assets = (Assets)type.getAnnotation(Assets.class);
        }

        return null;
    }

    private static Ingredient createIngredient(final String name, final String template, final boolean plrual) {
        return new Ingredient() {
            public Class<? extends Annotation> annotationType() {
                return Ingredient.class;
            }

            public String name() {
                return name;
            }

            public String template() {
                return template;
            }

            public boolean plural() {
                return plrual;
            }
        };
    }
}
