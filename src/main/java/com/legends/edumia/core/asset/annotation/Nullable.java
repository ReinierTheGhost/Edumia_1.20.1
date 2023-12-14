package com.legends.edumia.core.asset.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.CheckForNull;
import javax.annotation.meta.TypeQualifierNickname;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@CheckForNull
@TypeQualifierNickname
public @interface Nullable {
}
