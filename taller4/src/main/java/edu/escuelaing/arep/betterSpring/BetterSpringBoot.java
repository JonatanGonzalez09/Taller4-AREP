package edu.escuelaing.arep.betterSpring;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Set;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import edu.escuelaing.arep.betterSpring.annotations.Web;

public class BetterSpringBoot {

    public HashMap<String, Method> listURL;

    public BetterSpringBoot() {
        this.listURL = new HashMap<String, Method>();
	}

    public void inicializar(){
        String className="edu.escuelaing.arep.ws.WebServices";
        Reflections reflections = new Reflections(className, new SubTypesScanner(false));
        Set<Class<? extends Object>> allClasses = reflections.getSubTypesOf(Object.class);
        for (Class cls : allClasses) {
            //Method methods[] = cls.getMethods();
            for (Method m : cls.getMethods()){
                if (m.isAnnotationPresent(Web.class)){
                    System.out.println("Ejecutando metodo: "+ m.getName());
                    System.out.println("en clase: "+ cls.getName());
                    listURL.put(m.getAnnotation(Web.class).value(), m);
                }
            }
        }
    }

    /* public static void main(String[] args) {
        String className = "edu.escuelaing.arep.betterSpring.ws.WebServices";
        try {
            Class c = Class.forName(className);
            Method methods[] = c.getMethods();
            for (Method m : methods){
                if (m.isAnnotationPresent(Web.class)){
                    System.out.println("Ejecutando metodo: "+ m.getName());
                    System.out.println("en clase: "+ c.getName());
                    try{
                        System.out.println(m.invoke(null));
                    }catch(IllegalAccessException e){
                        Logger.getLogger(BetterSpringBoot.class.getName()).log(Level.SEVERE,null,e);
                    }catch(IllegalArgumentException e){
                        Logger.getLogger(BetterSpringBoot.class.getName()).log(Level.SEVERE,null,e);
                    }catch(InvocationTargetException e){
                        Logger.getLogger(BetterSpringBoot.class.getName()).log(Level.SEVERE,null,e);
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            Logger.getLogger(BetterSpringBoot.class.getName()).log(Level.SEVERE,null,e);
        }
        
    } */
}
