package interfaces;

import idiomas.modelos.Idioma;
import java.util.ArrayList;
import java.util.List;

public interface IGestorIdiomas {

    //Constantes de mensajes
    public final String EXITO = "Lugar cread/boorrado con éxito";
    public final String ERROR_NOMBRE = "El nombre idioma no puede ser nulo";
    public final String IDIOMA_DUPLICADO = "Ya existe un idioma con ese nombre ";
    public final String IDIOMA_CON_PUBLICACION = "No se puede borrar el idioma porque hay publicaciones con ese idioma";
    public final String IDIOMA_INEXISTENTE = "No existe el idioma específicado";

    public String borrarIdioma(Idioma idioma);
    public String nuevoIdioma(String nombre);
    public List<Idioma> buscarIdiomas(String nombre);
    public List<Idioma> verIdiomas();
    public Idioma verIdioma(String nombre);
    public boolean existeEsteIdioma(Idioma idioma);

}
