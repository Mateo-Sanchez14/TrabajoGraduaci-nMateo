package lugares.modelos;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lugar)) return false;
        Lugar lugar = (Lugar) o;
        return Objects.equals(nombre, lugar.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
