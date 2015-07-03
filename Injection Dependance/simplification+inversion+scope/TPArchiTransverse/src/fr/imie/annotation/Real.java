package fr.imie.annotation;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD,METHOD,TYPE})
public @interface Real {

}
