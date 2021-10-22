package grupos.modelos;

import autores.modelos.Autor;

import java.util.ArrayList;
import java.util.Objects;

public class Grupo {
    //Atributos de la clase
    private String nombre;
    private String descripcion;
    private ArrayList<MiembroEnGrupo> miembros = new ArrayList<>();

    //Constructores de la Clase
    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Grupo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}');
    }

   public ArrayList<MiembroEnGrupo> verMienbros(){
        return miembros;
    }

    public void quitarMiembro(Autor miembro){

    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grupo)) return false;
        Grupo grupo = (Grupo) o;
        return Objects.equals(nombre, grupo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
