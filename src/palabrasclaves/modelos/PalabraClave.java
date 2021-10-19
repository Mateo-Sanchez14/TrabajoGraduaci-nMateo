package palabrasclaves.modelos;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PalabraClave)) return false;
        PalabraClave that = (PalabraClave) o;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
