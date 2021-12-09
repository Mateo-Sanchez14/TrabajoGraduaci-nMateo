package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.ModeloTablaGrupos;
import grupos.modelos.ModeloTablaMiembros;
import grupos.vistas.VentanaAMGrupo;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorModificarMiembros;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAMGrupo implements IControladorAMGrupo {
    private VentanaAMGrupo ventana;
    private static IControladorAMGrupo controlador;

    public ControladorAMGrupo (java.awt.Dialog ventanaPadre) {
        this.ventana = new VentanaAMGrupo(this, ventanaPadre, true);
        this.ventana.setLocationRelativeTo(null);

        //Iniciar tabla
        this.ventana.verTablaMiembros().setModel(new ModeloTablaMiembros());
        this.ventana.verTablaMiembros().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaMiembros().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        this.ventana.setTitle(TITULO_NUEVO);
        //this.refrescarBotones();
        this.ventana.setVisible(true);


    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String nombre = ventana.verTxtNombre().getText().trim();
        String descripcion = ventana.verTxtDescripcion().getText().trim();

        IGestorGrupos gestorGrupos = GestorGrupos.instanciar();
        String mensaje;

        mensaje = gestorGrupos.nuevoGrupo(nombre,descripcion);

        if (mensaje.equals(IGestorGrupos.EXITO)) {
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
    public void btnModificarMiembrosClic(ActionEvent evt) {
        IControladorModificarMiembros controladorModificarMiembros = new ControladorModificarMiembros(this.ventana);
    }

    @Override
    public void txtNombrePresionarTecla(KeyEvent evt) {

    }

    @Override
    public void txtDescripcionPresionarTecla(KeyEvent evt) {

    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }
}
