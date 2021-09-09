package palabrasclaves.modelos;

public class PalabraClave {
    //Atributos de la Clase
    private String nombre;

    //Constructores de la clase
    public PalabraClave() {
    }

    public PalabraClave(String nombre) {
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
        return "PalabraClave{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
