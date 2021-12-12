package grupos.controladores;

import grupos.modelos.GestorGrupos;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.ModeloTablaMiembros;
import grupos.vistas.VentanaAMGrupo;
import interfaces.IControladorAMGrupo;
import interfaces.IControladorModificarMiembros;
import interfaces.IGestorGrupos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorAMGrupo implements IControladorAMGrupo {
    private VentanaAMGrupo ventana;
    private static IControladorAMGrupo controlador;
    private String nombreGrupo = null;
    private List<MiembroEnGrupo> miembrosAux = new ArrayList<>();

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
    public ControladorAMGrupo (java.awt.Dialog ventanaPadre, String nombreGrupo) {
        this.ventana = new VentanaAMGrupo(this, ventanaPadre, true);
        this.ventana.setLocationRelativeTo(null);

        //Iniciar tabla
        this.ventana.verTablaMiembros().setModel(new ModeloTablaMiembros(nombreGrupo));
        this.ventana.verTablaMiembros().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaMiembros().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        IGestorGrupos gestorGrupos = GestorGrupos.instanciar();
        this.nombreGrupo = nombreGrupo;
        this.ventana.verTxtNombre().setText(nombreGrupo);
        this.ventana.verTxtNombre().setEnabled(false);
        this.ventana.verTxtDescripcion().setText(gestorGrupos.verGrupo(nombreGrupo).verDescripcion());

        this.guardarMiembros();

        this.ventana.setTitle(TITULO_MODIFICAR);
        //this.refrescarBotones();
        this.ventana.setVisible(true);


    }

    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String nombre = ventana.verTxtNombre().getText().trim();
        String descripcion = ventana.verTxtDescripcion().getText().trim();

        IGestorGrupos gestorGrupos = GestorGrupos.instanciar();
        String mensaje;

        if (nombreGrupo == null) {
            mensaje = gestorGrupos.nuevoGrupo(nombre, descripcion);
        } else {
            mensaje = gestorGrupos.modificarGrupo(gestorGrupos.verGrupo(nombreGrupo),descripcion);
        }

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
            this.cargarMiembros();
            this.ventana.dispose();
        }
    }

    @Override
    public void btnModificarMiembrosClic(ActionEvent evt) {
        IControladorModificarMiembros controladorModificarMiembros = new ControladorModificarMiembros(this.ventana,nombreGrupo);

        //Refresco la tabla
        IGestorGrupos gg = GestorGrupos.instanciar();
        ModeloTablaMiembros modeloTablaMiembros = (ModeloTablaMiembros) this.ventana.verTablaMiembros().getModel();
        modeloTablaMiembros.refrescarTabla(gg.verGrupo(nombreGrupo).verMiembros());
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
    private void guardarMiembros() {
        IGestorGrupos gg = GestorGrupos.instanciar();
        for (MiembroEnGrupo x : gg.verGrupo(this.nombreGrupo).verMiembros()) {
            this.miembrosAux.add(x);
        }
    }
    private void cargarMiembros(){
        IGestorGrupos gg = GestorGrupos.instanciar();
        gg.verGrupo(nombreGrupo).verMiembros().clear(); //Elimino todos los miembros
        gg.agregarMiembros(gg.verGrupo(nombreGrupo), miembrosAux); //Cargo los miembros previos a la modificación
    }
}
