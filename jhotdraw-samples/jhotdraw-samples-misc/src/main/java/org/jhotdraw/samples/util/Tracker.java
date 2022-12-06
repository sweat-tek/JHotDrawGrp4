package org.jhotdraw.samples.util;
/**
 * author: Stped18
 * email: stped18@student.sdu.dk
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target (ElementType.METHOD)
@Retention (RetentionPolicy.RUNTIME)
public @interface Tracker {
  String name() default "None";
}
