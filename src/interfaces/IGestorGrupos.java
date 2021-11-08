package interfaces;

import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Grupo;
import grupos.modelos.Rol;
import java.util.ArrayList;

public interface IGestorGrupos {

    public final String EXITO = "Grupo cread/boorrado con éxito";
    public final String ERROR_NOMBRE = "El nombre grupo no puede ser nulo";
    public final String ERROR_DESCRIPCION = "La descripcion no puede ser nula";
    public final String GRUPO_DUPLICADO = "Ya existe un grupo con ese nombre ";
    public final String GRUPO_CON_PUBLICACION = "No se puede borrar el grupo porque hay publicaciones con ese grupo";
    public final String GRUPO_INEXISTENTE = "No existe el grupo específicado";

    public String nuevoGrupo(String nombre, String descripcion);
    public String modificarGrupo(Grupo grupo, String descripcion);
    public ArrayList<Grupo> verGrupos();
    public Grupo verGrupo(String nombre);
    public boolean existeEsteGrupo(Grupo grupo);
}