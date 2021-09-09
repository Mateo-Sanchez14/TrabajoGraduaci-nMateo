package idiomas.modelos;

public class Idioma {
    //Atributos de la clase
    private String nombre;

    //Constructores de la clase
    public Idioma() {
    }

    public Idioma(String nombre) {
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
        return "Idioma{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
