
package pizzeriaonline.entidades;


public class Pizza {
    
    private String nombre;
    private String precio;

    public Pizza() {
    }

    public Pizza(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pizza{" + "nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
    
}
