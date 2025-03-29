package co.edu.uniquindio.implementacionDTO;

public class ProductoDTO {
    private String nombre;
    private doble precio;

    public ProductoDTO(String nombre, doble precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public doble getPrecio() {
        return precio;
    }

    public void setPrecio(doble precio) {
        this.precio = precio;
    }
}
