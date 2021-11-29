package interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public interface IControladorAPalabraClave {

    public static final String TITULO = "Nueva palabra clave";

    /**
     * Acción a ejecutar cuando se selecciona el botón Guardar
     *
     * @param evt evento
     */
    public void btnGuardarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se selecciona el botón Cancelar
     *
     * @param evt evento
     */
    public void btnCancelarClic(ActionEvent evt);

    /**
     * Acción a ejecutar cuando se presiona una tecla en el campo txtNombre
     *
     * @param evt evento
     */
    public void txtNombrePresionarTecla(KeyEvent evt);
}
