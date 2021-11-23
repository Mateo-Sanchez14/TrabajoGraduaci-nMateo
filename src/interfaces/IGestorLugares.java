package interfaces;

import lugares.modelos.Lugar;
import java.util.ArrayList;
import java.util.List;

public interface IGestorLugares {

    //Constantes de mensajes
    public final String EXITO = "Lugar cread/boorrado con éxito";
    public final String ERROR_NOMBRE = "El nombre lugar no puede ser nulo";
    public final String LUGAR_DUPLICADO = "Ya existe un lugar con ese nombre ";
    public final String LUGAR_CON_PUBLICACION = "No se puede borrar el lugar porque hay publicaciones con ese lugar";
    public final String LUGAR_INEXISTENTE = "No existe el lugar específicado";

    public String borrarLugar(Lugar lugar);
    public List<Lugar> buscarLugares(String nombre);
    public String nuevoLugar(String nombre);
    public List<Lugar> verLugares();
    public Lugar verLugar(String nombre);
    public boolean existeEsteLugar(Lugar lugar);

}
