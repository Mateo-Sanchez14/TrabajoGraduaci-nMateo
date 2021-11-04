package interfaces;

import palabrasclaves.modelos.PalabraClave;

import java.util.ArrayList;

public interface IGestorPalabrasClaves {
    //Constantes de mensajes
    public final String EXITO = "Palabra clave creada/borrada con éxito";
    public final String ERROR_NOMBRE = "El nombre de la palabra clave no puede ser nulo";
    public final String PALABRA_DUPLICADA = "Ya existe una palabra clave con ese nombre ";
    public final String PALABRA_CON_PUBLICACION = "No se puede borrar la palabra clave porque hay publicaciones con esa palabra clave";
    public final String PALABRA_INEXISTENTE = "No existe la palabra clave en específico";

    public String nuevaPalabraClave(String nombre);
    public ArrayList<PalabraClave> verPalabrasClaves();
    public PalabraClave verPalabraClave(String nombre);
}
