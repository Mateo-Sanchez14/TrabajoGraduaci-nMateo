package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import autores.modelos.Profesor;
import idiomas.modelos.Idioma;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import grupos.modelos.Grupo;
import interfaces.IGestorPublicaciones;
import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import publicaciones.modelos.GestorPublicaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorGrupos implements IGestorGrupos {
    List<Grupo> grupos = new ArrayList<>();

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

    public List<Grupo> verGrupos(){
        Collections.sort(this.grupos);
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

    @Override
    public String borrarGrupo(Grupo grupo) {
        if (!existeEsteGrupo(grupo))
            return GRUPO_INEXISTENTE;

        if (!grupo.verMiembros().isEmpty())
            return GRUPO_CON_AUTORES;

        this.grupos.remove(grupo);
        return EXITO;
    }

    @Override
    public List<Grupo> buscarGrupos(String nombre) {
        List<Grupo> gruposEncontrados = new ArrayList<>();
        for (Grupo x : this.grupos){
            if (x.verNombre().toLowerCase().contains(nombre.toLowerCase()))
                gruposEncontrados.add(x);
        }
        Collections.sort(gruposEncontrados);
        return gruposEncontrados;
    }
}
