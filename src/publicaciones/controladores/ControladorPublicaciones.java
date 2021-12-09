/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import grupos.modelos.ModeloTablaGrupos;
import interfaces.IControladorAMPublicacion;
import static interfaces.IControladorGrupos.TITULO;
import interfaces.IControladorPublicaciones;
import interfaces.IGestorPublicaciones;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloTablaPublicaciones;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaAMPublicaciones;
import publicaciones.vistas.VentanaPublicaciones;




public class ControladorPublicaciones implements IControladorPublicaciones {
   private VentanaPublicaciones ventanaPublicaciones;
    
    public ControladorPublicaciones(java.awt.Frame ventanaPadre){
        this.ventanaPublicaciones = new VentanaPublicaciones(this,ventanaPadre,true);
        this.ventanaPublicaciones.setLocationRelativeTo(null);

        this.configuracionTablas();
        this.refrescarBotones();
        this.ventanaPublicaciones.setTitle(TITULO);
        this.ventanaPublicaciones.setVisible(true);
             
    }
    
    
    //javax.swing.JDialog padre, boolean modal,IControladorAMPublicacion controlador
    
    
    @Override
    public void btnNuevaClic(ActionEvent evt) {
       IControladorAMPublicacion controladorAMPublicacion= new ControladorAMPublicaciones(ventanaPublicaciones);
       this.refrescarBotones();
             
    }

    @Override
    public void btnModificarClic(ActionEvent evt) {
         if (this.ventanaPublicaciones.getTablaPublicaciones().getSelectedRow() != -1) {
             //Obtener titulo de la publicacion
            String titulo=(String) this.ventanaPublicaciones.getTablaPublicaciones().getValueAt(this.ventanaPublicaciones.getTablaPublicaciones().getSelectedRow(), 0);
            //Crear ventana
            IControladorAMPublicacion controladorAMPublicacion= new ControladorAMPublicaciones(ventanaPublicaciones,titulo);
        } else {
             //Advertencia si no se selecciono nada
            JOptionPane.showConfirmDialog(ventanaPublicaciones, "No se selecciono ninguna publicación", "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }
         
    }

    @Override
    public void btnBorrarClic(ActionEvent evt) {
        IGestorPublicaciones gestor = GestorPublicaciones.instanciar();
        if (this.ventanaPublicaciones.getTablaPublicaciones().getSelectedRow() != -1) {
            int opcionEscogida =JOptionPane.showOptionDialog(ventanaPublicaciones, IControladorPublicaciones.CONFIRMACION, "Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE,null,new Object[]{"Si","No"},"Si");
            if (opcionEscogida == JOptionPane.YES_OPTION) {
                String titulo= (String) this.ventanaPublicaciones.getTablaPublicaciones().getValueAt(this.ventanaPublicaciones.getTablaPublicaciones().getSelectedRow(), 0);
                Publicacion PublicacionEliminada = gestor.verPublicacion(titulo); //PREGUNTAR
                gestor.borrarPublicacion(PublicacionEliminada);
                this.refrescarBotones();

            }
        } else {
            JOptionPane.showConfirmDialog(ventanaPublicaciones, "No se selecciono ninguna publicación", "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }

    }

    @Override
    public void btnVolverClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaPublicaciones, "¿Desea volver al menu principal?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventanaPublicaciones.dispose();
        }
    }

    @Override
    public void btnBuscarClic(ActionEvent evt) {
        IGestorPublicaciones gestor = GestorPublicaciones.instanciar();
        String busquedaRealizada = this.ventanaPublicaciones.getTxtPublicacionesTitulo().getText();
        List<Publicacion> PublicacionesEncontrados = gestor.buscarPublicaciones(busquedaRealizada);
        ModeloTablaPublicaciones aux = (ModeloTablaPublicaciones) this.ventanaPublicaciones.getTablaPublicaciones().getModel();
        aux.refrescarDatosDeTabla(PublicacionesEncontrados);
        this.refrescarBotones();
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {
        this.ventanaPublicaciones.getTxtPublicacionesTitulo().setText(null);
        this.actualizarDatos();
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        //Al presionar enter busca
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            this.btnBuscarClic(null);
        }
    }
    
//Metodos auxiliares    
    private void actualizarDatos() {
        AbstractTableModel modeloTablaAux = (AbstractTableModel) this.ventanaPublicaciones.getTablaPublicaciones().getModel();
        ((ModeloTablaPublicaciones) (modeloTablaAux)).refrescarDatosDeTabla();
    }
    
    
    private void configuracionTablas() {
        this.ventanaPublicaciones.getTablaPublicaciones().setModel(new ModeloTablaPublicaciones());
        this.ventanaPublicaciones.getTablaPublicaciones().getTableHeader().setReorderingAllowed(false);
        this.ventanaPublicaciones.getTablaPublicaciones().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void refrescarBotones(){
        
    }
}
