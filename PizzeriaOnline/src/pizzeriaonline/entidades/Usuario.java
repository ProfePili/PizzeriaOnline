
package pizzeriaonline.entidades;


public class Usuario {
    
    private String email;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Usuario() {
    }

    public Usuario(String email, String nombre, String apellido, Integer edad) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Usuario{" + "email=" + email + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
    
    
    
}
