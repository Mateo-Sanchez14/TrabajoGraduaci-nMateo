package interfaces;

import tipos.modelos.Tipo;

import java.util.ArrayList;

public interface IGestorTipos {
    //Constantes de mensajes
    public final String EXITO = "Tipo de publicación creado/borrado con éxito";
    public final String ERROR_NOMBRE = "El nombre del tipo de publicación no puede ser nulo";
    public final String TIPOS_DUPLICADOS = "Ya existe un tipo de publicación con ese nombre ";
    public final String TIPO_CON_PUBLICACION = "No se puede borrar el tipo de publicación porque hay publicaciones con ese nombre";
    public final String TIPO_INEXISTENTE = "No existe el tipo de publicación en específico";

    public String nuevoTipo(String nombre);
    public ArrayList<Tipo> verTipos();
    public Tipo verTipo(String nombre);
}
