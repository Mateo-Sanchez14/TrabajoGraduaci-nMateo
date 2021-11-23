package interfaces;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.Publicacion;
import tipos.modelos.Tipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IGestorPublicaciones {
    //Constantes de mensajes
    public final String EXITO = "Publicación creada/borrada con éxito";
    public final String ERROR_TITULO = "El título de la publicación no puede ser nulo";
    public final String ERROR_MIEMBRO = "El miembro no puede ser nulo";
    public final String ERROR_FECHA = "La fecha no puede ser nula";
    public final String ERROR_TIPO = "El tipo no puede ser nulo";
    public final String ERROR_IDIOMA = "El idioma no puede ser nulo";
    public final String ERROR_LUGAR = "El lugar no puede ser nulo";
    public final String ERROR_PALABRAS = "Las palabras claves no pueden ser nulas";
    public final String ERROR_ENLACE = "El enlace no puede ser nulo";
    public final String ERROR_RESUMEN = "El resumen no puede ser nulo";
    public final String PUBLICACION_DUPLICADA = "Ya existe una palabra clave con ese nombre ";
    public final String PUBLICACION_INEXISTENTE = "No existe la publicación clave en específico";

    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo,
                                   LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,
                                   List<PalabraClave> palabrasClaves, String enlace, String resumen);
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo,
                                       LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,
                                       List<PalabraClave> palabrasClaves, String enlace, String resumen);
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave);
    public boolean hayPublicacionesConEsteLugar(Lugar lugar);
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma);
    public boolean hayPublicacionesConEsteTipo(Tipo tipo);
    public boolean hayPublicacionesConEsteAutor(Autor autor);
    public boolean existeEstaPublicacion(Publicacion publicacion);
    public List<Publicacion> verPublicaciones();
    public Publicacion verPublicacion(String titulo);
    public String borrarPublicacion(Publicacion publicacion);
    public List<Publicacion> buscarPublicaciones(String titulo);

}
