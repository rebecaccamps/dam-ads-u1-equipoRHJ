package logica;

public class Socio {
    private final String idSocio;
    private String dni;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;


    public Socio(String idSocio, String dni, String nombre, String apellido, String telefono, String email) {
        this.idSocio = idSocio;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellido(String apellido) {
        this.apellidos = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
