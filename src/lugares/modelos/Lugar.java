package lugares.modelos;

public class Lugar {
    //Atributos de la clase
    private String nombre;

    //Constructores de la clase
    public Lugar() {
    }
    public Lugar(String nombre) {
        this.nombre = nombre;
    }

    //Métodos de la clase
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
