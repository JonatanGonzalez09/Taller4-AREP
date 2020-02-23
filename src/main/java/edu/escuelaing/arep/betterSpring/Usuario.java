package edu.escuelaing.arep.betterSpring;

public class Usuario{
    int id_Usuario;
    String correo;
    String nombre;
    String apellido;

    /**
     * Constructor de la clase Usuario.
     * @param id el identificador del usuario.
     * @param correo correo del usuario.
     * @param nombre nombre del usuario.
     * @param apellido apellido del usuario.
     */
    public Usuario(int id, String correo, String nombre, String apellido) {
        this.id_Usuario=id;
        this.correo=correo;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    
    /**
     * Devuelve el identificador del usuario.
     * @return identificador del usuario.
     */
    public int getId(){
        return this.id_Usuario;
    }

    /**
     * Devuelve el correo del usuario.
     * @return correo del usuario.
     */
    public String getCorreo(){
        return this.correo;
    }

    /**
     * Devuelve el nombre del usuario.
     * @return nombre del usuario.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Devuelve el apellido del usuario.
     * @return apellido del usuario.
     */
    public String getApellido(){
        return this.apellido;
    }

    /**
     * Modifica el identificador del usuario.
     * @param id nuevo identificador del usuario.
     */
    public void setId(int id){
         this.id_Usuario = id;
    }

    /**
     * Modifica el correo del usuario.
     * @param correo nuevo correo del usuario.
     */
    public void setCorreo(String correo){
        this.correo = correo;
    }

    /**
     * Modifica el nombre del usuario.
     * @param nombre nuevo nombre del usuario.
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Modifica el apellido del usuario.
     * @param apellido nuevo apellido del usuario.
     */
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
}