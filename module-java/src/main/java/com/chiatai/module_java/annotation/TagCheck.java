package com.chiatai.module_java.annotation;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangqi61
 * @since 2021/10/13
 */

@IntDef({IntDefClazz.TAG_ONE, IntDefClazz.TAG_TWO})
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface TagCheck {
}
