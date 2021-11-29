package palabrasclaves.controladores;

import interfaces.IControladorAPalabraClave;
import interfaces.IGestorPalabrasClaves;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.vistas.VentanaAPalabraClave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ControladorAPalabraClave implements IControladorAPalabraClave {

    private VentanaAPalabraClave ventana;
    private static IControladorAPalabraClave controlador;


    public ControladorAPalabraClave(javax.swing.JDialog ventanaPadre) {
        this.ventana = new VentanaAPalabraClave(this, ventanaPadre, true);

        this.ventana.setLocationRelativeTo(null);
        this.ventana.setTitle(TITULO);
        this.ventana.setVisible(true);
    }


    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String nombre = ventana.verTxtNombre().getText().trim();
        IGestorPalabrasClaves gestorPalabrasClaves = GestorPalabrasClaves.instanciar();
        String mensaje = gestorPalabrasClaves.nuevaPalabraClave(nombre);
        if (mensaje.equals("Palabra clave creada/borrada con éxito")) {
            JOptionPane.showConfirmDialog(ventana, mensaje, "Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            this.ventana.dispose();
        } else {
            JOptionPane.showConfirmDialog(ventana, mensaje, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, "¿Desea cancelar la operación? Los cambios no guardados se perderán", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventana.dispose();
        }
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
                    break;
                case KeyEvent.VK_BACK_SPACE:
                    break;
                case KeyEvent.VK_DELETE:
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }
}
