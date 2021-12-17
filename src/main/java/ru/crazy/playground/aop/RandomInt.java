package ru.crazy.playground.aop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RandomInt {
    int min();
    int max();
}
