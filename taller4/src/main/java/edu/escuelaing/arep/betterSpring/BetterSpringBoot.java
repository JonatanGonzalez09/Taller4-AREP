package edu.escuelaing.arep.betterSpring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.arep.betterSpring.annotations.Web;

public class BetterSpringBoot {

    public static void main(String[] args) {
        String className = "edu.escuelaing.arep.betterSpring.ws.WebServiceHello";
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
        
    }
}
