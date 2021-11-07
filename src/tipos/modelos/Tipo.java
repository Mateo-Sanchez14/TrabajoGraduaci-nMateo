package tipos.modelos;

import java.util.Objects;

public class Tipo {
    //Atributos de la clase
    private String nombre;

    //Constructores de la clase

    public Tipo() {
    }

    public Tipo(String nombre) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tipo)) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(nombre, tipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        if (this.nombre != null || !this.nombre.trim().isEmpty())
            return this.nombre;
        return "Tipo nulo o no ingresado";
    }

}
