package edu.escuelaing.arep.betterSpring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import edu.escuelaing.arep.betterSpring.framework.BetterSpringBoot;
import edu.escuelaing.arep.betterSpring.ws.WebServices;

public class Server {
	
	private int puerto=getPort();
	private Socket clientSocket;
	private static ServerSocket servSocket;
    private String serverMessage;
    private BetterSpringBoot spring;

    /**
     * Constructor de la clase Servidor.
     */
    public Server() {
        this.spring = new BetterSpringBoot();
        this.clientSocket = null;
        try {
            this.servSocket = new ServerSocket(this.puerto);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * El metodo empieza el servidor.
     */
    public void start() {
        this.spring.inicializar();
        while (true) {
            try {
                System.out.println("Estableciendo la conexión...");
                this.clientSocket = this.servSocket.accept();

                System.out.println("Cliente establecido...");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));

                String path = this.handleRequest(entrada);
                System.out.println("Path:"+ path);

                OutputStream os = clientSocket.getOutputStream();

                if(path != null) {
                    if(path.equals("/hello.html")){
						prueba(clientSocket, os);
					}else if(path.equals("/users.bd")){
                        usersBD(clientSocket, os);
                    }else if (path.equals("/webPage.img")){
                        webPage(clientSocket, os);
                    }else{
                        pageNotFound(os);
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Retorna el requerimiento de la base de datos.
     * @param clientSocket2 cliente Socket.
     * @param os Output Stream.
     */
    private void usersBD(Socket clientSocket2, OutputStream os) {
        PrintWriter res = new PrintWriter(os, true);
        String outputLine = WebServices.UserDataBase();
        setOutput(res, outputLine, os);
    }

    /**
     * Retorna el requerimiento del hello.
     * @param clientSocket2 cliente Socket.
     * @param os Output Stream.
     */
    private void prueba(Socket clientSocket2, OutputStream os) {
        PrintWriter res = new PrintWriter(os, true);
        String outputLine = WebServices.hello();
        setOutput(res, outputLine, os);
    }

    /**
     * Retorna el requerimiento del webPage.
     * @param clientSocket2 cliente Socket.
     * @param os Output Stream.
     */
    private void webPage(Socket clientSocket2, OutputStream os) {
        PrintWriter res = new PrintWriter(os, true);
        String outputLine = WebServices.webPage();
        setOutput(res, outputLine, os);
    }

    /**
     * Retorna el requerimiento del pageNotFound.
     * @param os Output Stream.
     */
    private void pageNotFound(OutputStream os) {
        PrintWriter res = new PrintWriter(os, true);
        String outputLine = "HTTP/1.1 404 \r\n\r\n<html><body><h1>Page Not Found</h1></body></html>";
        setOutput(res, outputLine, os);
    }

    /**
     * Atiende la solicitud del cliente.
     * @param entrada la URL del cliente.
     * @return devuelve la cadena de la url de la entrada.
     */
    public String handleRequest(BufferedReader entrada) {
		boolean notExit=true;
		String path=null;
		try {
			while((this.serverMessage=entrada.readLine())!=null && notExit) {
				
				if(this.serverMessage.contains("GET")) {
					String[]dir=this.serverMessage.split(" ");
					path=dir[1];
					notExit=false;
				}
			}
		} 
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return path;
	}

    /**
     * Devuelve la salida de la pagina que se mostrara al cliente.
     * @param res Response
     * @param outputLine la pagina que se mostrara.
     * @param os Output Stream.
     */
    private void setOutput(PrintWriter res, String outputLine, OutputStream os) {
        res.println(outputLine);
        res.flush();
        res.close();
        try {
            os.flush();
            os.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Devuelve el puerto por el que se correra la aplicacion.
     * @return
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return new Integer(System.getenv("PORT"));
        }
        return 4567;
    }

    /**
     * Metdodo principal para ejecutar el programa.
     * @param args parametros que necesite el programa principal.
     */
    public static void main(String args[]) {
        Server server = new Server();
        System.out.println("Iniciando servidor");
        server.start();
        try {
            servSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
}