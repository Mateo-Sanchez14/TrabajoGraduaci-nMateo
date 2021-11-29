package palabrasclaves.controladores;

import interfaces.IControladorAPalabraClave;
import interfaces.IControladorPalabrasClaves;
import interfaces.IGestorPalabrasClaves;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import palabrasclaves.vistas.VentanaPalabraClave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class ControladorPalabrasClaves implements IControladorPalabrasClaves {
    private VentanaPalabraClave ventana;
    private static ControladorPalabrasClaves controlador;


    public ControladorPalabrasClaves(java.awt.Frame ventanaPadre) {
        this.ventana = new VentanaPalabraClave(this, ventanaPadre, true);
        this.ventana.setLocationRelativeTo(null);

        this.ventana.verTablaPalabrasClave().setModel(new ModeloTablaPalabrasClaves());

        this.ventana.verTablaPalabrasClave().getTableHeader().setReorderingAllowed(false);

        this.ventana.verTablaPalabrasClave().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.ventana.setTitle(TITULO);
        this.refrescarBotones();
        this.ventana.setVisible(true);
    }

    @Override
    public void btnNuevaClic(ActionEvent evt) {
        IControladorAPalabraClave controladorAPalabraClave = new ControladorAPalabraClave(this.ventana);

        //Refresco los botones
        refrescarBotones();
        //Refresco la tabla luego de añadir un nuevo Profesor
        IGestorPalabrasClaves gestor = GestorPalabrasClaves.instanciar();
        ModeloTablaPalabrasClaves modeloTablaProfesores = (ModeloTablaPalabrasClaves) this.ventana.verTablaPalabrasClave().getModel();
        modeloTablaProfesores.refrescarTabla(gestor.verPalabrasClaves());
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (this.ventana.verTablaPalabrasClave().getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(ventana, IControladorPalabrasClaves.PALABRA_NO_SELECCIONADA, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, IControladorPalabrasClaves.CONFIRMACION, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcionEscogida == JOptionPane.YES_OPTION) {
                //String mensaje = this.borrarProfesor();
                IGestorPalabrasClaves gestor = GestorPalabrasClaves.instanciar();
                PalabraClave palabraSeleccionada = gestor.verPalabraClave((String) this.ventana.verTablaPalabrasClave().getValueAt(this.ventana.verTablaPalabrasClave().getSelectedRow(), 0));

                String estado = gestor.borrarPalabraClave(palabraSeleccionada);
                JOptionPane.showConfirmDialog(ventana, estado, "Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

                refrescarBotones();

                //Refresco el ArrayList que se muestra en la tabla
                ModeloTablaPalabrasClaves modeloTablaProfesores = (ModeloTablaPalabrasClaves) this.ventana.verTablaPalabrasClave().getModel();
                modeloTablaProfesores.refrescarTabla(gestor.verPalabrasClaves());
            }
        }
    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, "¿Desea volver al menu principal?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventana.dispose();
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        String busqueda = this.ventana.verTxtNombre().getText();
        IGestorPalabrasClaves gestor = GestorPalabrasClaves.instanciar();
        List<PalabraClave> palabrasEncontradas = gestor.buscarPalabrasClaves(busqueda);

        ModeloTablaPalabrasClaves modeloTablaProfesores = (ModeloTablaPalabrasClaves) this.ventana.verTablaPalabrasClave().getModel();
        modeloTablaProfesores.refrescarTabla(palabrasEncontradas);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnBuscarClic(null);
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

    public void refrescarBotones() {
        IGestorPalabrasClaves gestor = GestorPalabrasClaves.instanciar();
        if (gestor.verPalabrasClaves().isEmpty()) {
            this.ventana.verBtnBorrar().setEnabled(false);
        } else {
            this.ventana.verBtnBorrar().setEnabled(true);
        }
    }
}
