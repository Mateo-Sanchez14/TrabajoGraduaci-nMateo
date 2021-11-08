package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.Profesor;
import interfaces.IGestorGrupos;
import grupos.modelos.Grupo;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;

import java.util.ArrayList;

public class GestorGrupos implements IGestorGrupos {
    ArrayList<Grupo> grupos = new ArrayList<>();

    private static GestorGrupos gestor;
    public static GestorGrupos instanciar() {
        if (gestor == null)
            gestor = new GestorGrupos();
        return gestor;
    }
    public String nuevoGrupo(String nombre, String descripcion){
        Grupo unGrupo = new Grupo(nombre,descripcion);
        if ((nombre == null) || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        if (this.grupos.contains(unGrupo))
            return GRUPO_DUPLICADO;
        if ((descripcion == null) || descripcion.trim().isEmpty())
            return ERROR_DESCRIPCION;
        this.grupos.add(unGrupo);
        return EXITO;
    }

    public ArrayList<Grupo> verGrupos(){
        return this.grupos;
    }

    public Grupo verGrupo(String nombre){
        for (Grupo x : grupos) {
            if (x.verNombre().equals(nombre)){
                return x;
            }
        }
        return null;
    }

    public String modificarGrupo(Grupo grupo, String descripcion) {

        if ((grupo == null))
            return GRUPO_INEXISTENTE;
        if ((descripcion == null) || descripcion.trim().isEmpty())
            return ERROR_DESCRIPCION;

        grupo.asignarDescripcion(descripcion);

        return EXITO;
    }

    public boolean existeEsteGrupo(Grupo grupo){
        if (grupos.contains(grupo))
            return true;
        return false;
    }
}
