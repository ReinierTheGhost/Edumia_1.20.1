package com.legends.edumia.core.asset.annotation;

import com.legends.edumia.core.util.RenderLayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Render {
    RenderLayer value();
}
