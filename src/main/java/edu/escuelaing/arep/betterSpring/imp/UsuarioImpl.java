package edu.escuelaing.arep.betterSpring.imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.escuelaing.arep.betterSpring.Usuario;

public class UsuarioImpl {

	private String user;
	private String password;
	private String url;
	private Connection connection;

	/**
	 * Constructor de la clase UsuarioImpl.
	 */
	public UsuarioImpl() {
		this.user = "lyhunmlllpldmn";
		this.password = "6bc2dddb0d633465a996cf68bc8132fd94cc27cf16d828ba2cb44a130d24468b";
		this.url = "jdbc:postgresql://ec2-34-192-30-15.compute-1.amazonaws.com:5432/d8qdsnov0ocl4f";
		try {
			this.connection = DriverManager.getConnection(this.url, this.user, this.password);
			this.connection.setAutoCommit(false);
		} catch (SQLException e) {
			Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Inserta un usuario .
	 * @param usr usuario a insertat .
	 */
	public void insertUsuario(Usuario usr) {
		String consulta = "INSERT INTO \"Usuario\" (id, correo, nombre, apellido) VALUES (?,?,?,?)";
        try {
            PreparedStatement pS = connection.prepareStatement(consulta);
            pS.setInt(1,usr.getId());
            pS.setString(2,usr.getCorreo());
            pS.setString(3,usr.getNombre());
            pS.setString(4,usr.getApellido());
			pS.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Devuelve todos los usuarios en la base de datos.
	 * @return una lista con los usuarios.
	 */
	public ArrayList<Usuario> getUsuarios() {
		String consulta = "SELECT * FROM \"Usuario\"";
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            PreparedStatement pS = connection.prepareStatement(consulta);
            ResultSet rSet = pS.executeQuery();
            while (rSet.next()) {
                int id = rSet.getInt("id_usuario");
                String correo = rSet.getString("correo");
                String nombre = rSet.getString("nombre");
				String apellido = rSet.getString("apellido");
				Usuario usuario = new Usuario(id, correo, nombre, apellido);
                usuario.setId(id);
                usuario.setCorreo(correo);
                usuario.setNombre(nombre);
                usuario.setApellido(apellido);
                usuarios.add(usuario);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return usuarios;
	}
}