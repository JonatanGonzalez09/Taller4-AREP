package edu.escuelaing.arep.betterSpring.ws;

import java.util.List;

import edu.escuelaing.arep.betterSpring.Usuario;
import edu.escuelaing.arep.betterSpring.annotations.Web;
import edu.escuelaing.arep.betterSpring.imp.UsuarioImpl;

public class WebServices {

    public static UsuarioImpl usuario = new UsuarioImpl();

	/**
	 * Retorna el html de la pagina del hello.
	 * @return el string con el html del recurso hello.html
	 */
    @Web("/hello.html")
    public static String hello(){
		String cad = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "\r\n" 
					+"<!DOCTYPE html>"
					+ "<html>"
					+"<head>"
					+"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">"
					+"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>"
					+"</head>"
					+ " <body>"
					+"<div class=\"row\">"
					+"	<div class=\"card-panel red accent-4 col l6 m6 s6 offset-l3 offset-s3 offset-m3\">"
                    + "     	<h1 class=\"center-align white-text serif-text\">Hello :D</h1>"
                    + " </div>"
                    + " </div>"
                    + " </body>"
                    + "</html>";
        return cad;
    }

	/**
	 * Retorna el html de la pagina del users traido de la base de datos.
	 * @return el string con el html del recurso users.bd
	 */
    @Web("/users.bd")
    public static String UserDataBase(){
        return "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "\r\n" + "<!DOCTYPE html>"
				+ "<html lang=\"es\">" + "<head>"
				+ "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
				+ "    <title>Usuarios</title>"
				+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">"
				+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js\" itegrity=\"sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=\" crossorigin=\"anonymous\"></script>"
				+ "</head>" + "<body>" + "    <header>" + "        <div class=\"row\">"
				+ "            <div class =\"col l8 m8 s12 offset-l2 offset-m2 center\">"
				+ "                <h1>Usuarios registrados en la base de datos</h1>" + "            </div>"
				+ "        </div>" + "        <div class=\"row\">"
				+ "            <div class=\"col l8 m8 s12 offset-l2 offset-m2\">" + "                <table>"
				+ "                    <thead>"
				+ "                        <tr class=\"card-panel red accent-4 white-text\">"
				+ "                            <th class=\"center-align\">ID Usuario</th>"
				+ "                            <th class=\"center-align\">Nombre</th>"
				+ "                            <th class=\"center-align\">Correo</th>"
				+ "                            <th class=\"center-align\">Apellido</th>"
				+ "                        </tr>" + "                    </thead>" + "                    <tbody>"
				+ datosUsuarios() + "                    </tbody>" + "                </table>" + "            </div>"
                + "        </div>" + "    </header>" + "</body>"
                + "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>"
                + "</html>";
    }

	/**
	 * Devuelve los datos del usuario traidos de la base de datos.
	 * @return la informacion de los usuarios.
	 */
    private static String datosUsuarios() {
		String usuarioInfo = "";
		List<Usuario> allUsuarios = usuario.getUsuarios();

		for (int i = 0; i < allUsuarios.size(); i++) {
			Usuario c = allUsuarios.get(i);
			usuarioInfo += "<tr>" + "<td class=\"center-align\">" + c.getId() + "</td>" + "<td class=\"center-align\">"
					+ c.getNombre() + "</td>" + "<td class=\"center-align\">" + c.getCorreo() + "</td>"
					+ "<td class=\"center-align\">" + c.getApellido() + "</td>" + "</tr>";
		}
		return usuarioInfo;
    }
	
	/**
	 * Retorna la pagina web con las imagenes.
	 * @return el string con el html del recurso webPage.img
	 */
    @Web("/webPage.img")
    public static String webPage(){
        return "HTTP/1.1 200 \r\n\r\n<html><head><title>HTML con Imagen</title></head>"
				+ "<body style = \"background-color:rgb(150,206,209);\"><h1><center> HttpServer </center></h1>"
				+ "<div align = \"center\"><h2 style = \"color:darkred;\"> Imagen Iron Man </h2>"
                + "<img src = \"https://vignette.wikia.nocookie.net/disney/images/9/96/Iron-Man-AOU-Render.png/revision/latest?cb=20180410032118&path-prefix=es\" width = \"500px\" height = \"500px\"></div></html></body>";
    }
}