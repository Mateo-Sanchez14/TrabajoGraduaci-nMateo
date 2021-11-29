package interfaces;

import java.awt.event.ActionEvent;

public interface IControladorPrincipal {
    public static final String CONFIRMACION = "¿Desea terminar la sesión?";
    public static final String TITULO = "Repositorios";
    /**
     * Acción a ejecutar cuando se selecciona el botón Autores
     * @param evt evento
     */
    public void btnAutoresClic(ActionEvent evt);
    /**
     * Acción a ejecutar cuando se selecciona el botón Salir
     * @param evt evento
     */
    public void btnSalirClic(ActionEvent evt);
    public void btnPalabrasClaveClic(ActionEvent evt);
}