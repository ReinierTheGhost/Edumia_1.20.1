package com.legends.edumia.resources;

import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public interface PostServerLoadedValidator {
    List<PostServerLoadedValidator> validators = new ArrayList();

    void performPostServerLoadValidation(Level var1);
}
