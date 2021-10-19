package idiomas.modelos;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Idioma)) return false;
        Idioma idioma = (Idioma) o;
        return Objects.equals(nombre, idioma.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
