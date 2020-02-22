package edu.escuelaing.arep.betterSpring.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import edu.escuelaing.arep.betterSpring.annotations.Web;

public class BetterSpringBoot {

    private HashMap<String, Method> listURL;

    public BetterSpringBoot() {
        listURL = new HashMap<>();
	}

    public void inicializar(){
        //System.out.println("Entro a BetterSpringBoot");
        String className="edu.escuelaing.arep.ws.WebServices";
        Reflections reflections = new Reflections(className, new SubTypesScanner(false));
        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
        for (Class cls : allClasses) {
            for (Method m : cls.getMethods()){
                if (m.isAnnotationPresent(Web.class)){
                    System.out.println("Ejecutando metodo: "+ m.getName());
                    System.out.println("en clase: "+ cls.getName());
                    listURL.put(m.getAnnotation(Web.class).value(), m);
                }
            }
        }
    }
    
}
