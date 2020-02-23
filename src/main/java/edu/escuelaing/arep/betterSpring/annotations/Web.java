package edu.escuelaing.arep.betterSpring.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;;

/**
 * Nueva anotacion creada.
 */
@Retention(RetentionPolicy.RUNTIME) //Queda en el codigo fuente pero no llega hasta la clase ... Para eso se pone la anotacion !
@Target(ElementType.METHOD) // Indica que la anotación se aplica a métodos
public @interface Web{
    String value();
}