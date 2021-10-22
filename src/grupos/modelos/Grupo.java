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
        System.out.print("Grupo{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\''
                );
        if(tieneMiembros()) {
            System.out.print(", miembros y sus roles= ");
            for (MiembroEnGrupo a : miembros) {
                System.out.print(a.verAutor().verNombres() + " es " + a.verRol() + ", ");
            }
        }
        else System.out.print(", No tiene miembros");
        System.out.println("}");
    }

   public ArrayList<MiembroEnGrupo> verMiembros(){
        return miembros;
    }
    public void agregarMiembro(Autor autor, Rol rol){
        if(this.esSuperAdministradores()){
            rol=Rol.ADMINISTRADOR;
        }
        MiembroEnGrupo nuevoMiembro= new MiembroEnGrupo(autor,this,rol);
        if(!miembros.contains(nuevoMiembro)){
            miembros.add(nuevoMiembro);
        }
    }
    public void quitarMiembro(Autor miembro){
        for(MiembroEnGrupo a : miembros){
            if(a.verAutor().equals(miembro)){
                miembros.remove(a);
            }
        }
    }
    public boolean esSuperAdministradores(){
        if(this.nombre.equals("Super Administradores")){
            return true;
        }else{
            return false;
        }
    }
    public boolean tieneMiembros(){
        if(this.miembros.isEmpty()){
            return false;
        }else{
            return true;
        }
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
