package interfaces;

import palabrasclaves.modelos.PalabraClave;

import java.util.ArrayList;
import java.util.List;

public interface IGestorPalabrasClaves {
    //Constantes de mensajes
    public final String EXITO = "Palabra clave creada/borrada con éxito";
    public final String ERROR_NOMBRE = "El nombre de la palabra clave no puede ser nulo";
    public final String PALABRA_DUPLICADA = "Ya existe una palabra clave con ese nombre ";
    public final String PALABRA_CON_PUBLICACION = "No se puede borrar la palabra clave porque hay publicaciones con esa palabra clave";
    public final String PALABRA_INEXISTENTE = "No existe la palabra clave en específico";
    public final String TEXTO = "./PalabrasClave.txt";

    //Métodos
    public String borrarPalabraClave(PalabraClave palabraClave);
    public List<PalabraClave> buscarPalabrasClaves(String nombre);
    public String nuevaPalabraClave(String nombre);
    public List<PalabraClave> verPalabrasClaves();
    public PalabraClave verPalabraClave(String nombre);
    public boolean existeEstaPalabraClave(PalabraClave palabraClave);

}
