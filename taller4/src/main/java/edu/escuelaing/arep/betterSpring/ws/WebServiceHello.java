package edu.escuelaing.arep.betterSpring.ws;

import edu.escuelaing.arep.betterSpring.annotations.Web;

public class WebServiceHello {

    @Web
    // HACER ESTO PERO RECIBIENDO PARAMETROS
    public static String hello(){
        String cad = "<!DOCTYPE html>"
                    + "<html>"
                    + " <body style=\"background-color:red\";>"
                    + "     <h1><center>My Web Page</center></h1>"
                    + " </body>"
                    + "</html>";
        return cad;
    }

}