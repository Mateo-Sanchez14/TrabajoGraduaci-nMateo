package grupos.controladores;


import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.ModeloTablaGrupos;
import grupos.vistas.VentanaGrupos;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorGrupos;
import interfaces.IGestorGrupos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;

public class ControladorGrupos implements IControladorGrupos {
    private VentanaGrupos ventana;
    private static ControladorGrupos controlador;

    public ControladorGrupos (java.awt.Frame ventanaPadre) {
        this.ventana = new VentanaGrupos(this, ventanaPadre, true);
        this.ventana.setLocationRelativeTo(null);

        //Iniciar tabla
        this.ventana.verTablaGrupos().setModel(new ModeloTablaGrupos());
        this.ventana.verTablaGrupos().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaGrupos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.ventana.setTitle(TITULO);
        //this.refrescarBotones();
        this.ventana.setVisible(true);
    }

    @Override
    public void btnNuevoClic(ActionEvent evt) {
        IControladorAMGrupo controladorAMGrupo = new ControladorAMGrupo(this.ventana);

        IGestorGrupos gestor = GestorGrupos.instanciar();
        ModeloTablaGrupos modeloTablaGrupos = (ModeloTablaGrupos) this.ventana.verTablaGrupos().getModel();
        modeloTablaGrupos.refrescarTabla(gestor.verGrupos());
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
        //ControladorAMGrupos instanciar
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        if (this.ventana.verTablaGrupos().getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(ventana, IControladorGrupos.GRUPO_NO_SELECCIONADO, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, IControladorGrupos.CONFIRMACION, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcionEscogida == JOptionPane.YES_OPTION) {
                //String mensaje = this.borrarProfesor();
                IGestorGrupos gestor = GestorGrupos.instanciar();
                Grupo grupoSeleccionado = gestor.verGrupo((String) this.ventana.verTablaGrupos().getValueAt(this.ventana.verTablaGrupos().getSelectedRow(), 0));

                String estado = gestor.borrarGrupo(grupoSeleccionado);
                JOptionPane.showConfirmDialog(ventana, estado, "Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

                //refrescarBotones();

                //Refresco el ArrayList que se muestra en la tabla
                ModeloTablaGrupos modeloTablaGrupos = (ModeloTablaGrupos) this.ventana.verTablaGrupos().getModel();
                modeloTablaGrupos.refrescarTabla(gestor.verGrupos());
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
        IGestorGrupos gestor = GestorGrupos.instanciar();
        List<Grupo> gruposEncontrados = gestor.buscarGrupos(busqueda);

        ModeloTablaGrupos modeloTablaGrupos = (ModeloTablaGrupos) this.ventana.verTablaGrupos().getModel();
        modeloTablaGrupos.refrescarTabla(gruposEncontrados);
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

}
