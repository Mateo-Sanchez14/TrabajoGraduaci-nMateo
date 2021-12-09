package grupos.controladores;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.modelos.ModeloTablaProfesores;
import grupos.modelos.*;
import grupos.vistas.VentanaGrupos;
import grupos.vistas.VentanaModificarMiembros;
import interfaces.IControladorModificarMiembros;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ControladorModificarMiembros implements IControladorModificarMiembros {

    private VentanaModificarMiembros ventana;
    private ControladorModificarMiembros controlador;

    public ControladorModificarMiembros (javax.swing.JDialog ventanaPadre) {
        this.ventana = new VentanaModificarMiembros(this, ventanaPadre, true);
        this.ventana.setLocationRelativeTo(null);

        //Iniciar tabla
        this.ventana.verTablaMiembros().setModel(new ModeloTablaMiembrosYAutores());
        this.ventana.verTablaMiembros().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaMiembros().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //this.seleccionarMiembros();

        this.ventana.setTitle(TITULO);
        //this.refrescarBotones();
        this.ventana.setVisible(true);
    }

    @Override
    public void btnTodosClic(ActionEvent evt) {
        ModeloTablaMiembrosYAutores modeloTablaMiembros = (ModeloTablaMiembrosYAutores) ventana.verTablaMiembros().getModel();
        ListSelectionModel modeloSeleccion = ventana.verTablaMiembros().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, modeloTablaMiembros.getRowCount() - 1);
    }

    @Override
    public void btnNingunoClic(ActionEvent evt) {
        ListSelectionModel modeloSeleccion = ventana.verTablaMiembros().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    @Override
    public void btnAceptarClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, IControladorModificarMiembros.CONFIRMACION, "Advertencia",0, JOptionPane.WARNING_MESSAGE,null,new Object[] {"si","no"},"si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            String mensajeAgregar = this.agregarMiembrosSeleccionados();
            String mensajeQuitar = this.quitarMiembrosNoSeleccionados();
            if (mensajeAgregar.equals(IGestorGrupos.EXITO_MIEMBROS) && mensajeQuitar.equals(IGestorGrupos.EXITO_MIEMBROS)) {
                JOptionPane.showMessageDialog(this.ventana, mensajeQuitar, "Notificacion", 1);
                this.ventana.dispose();
            } else if (mensajeAgregar.equals(IGestorGrupos.EXITO_MIEMBROS) && !mensajeQuitar.equals(IGestorGrupos.EXITO_MIEMBROS)) {
                JOptionPane.showMessageDialog(this.ventana, mensajeQuitar, "Notificacion", 1);
            } else if (!mensajeAgregar.equals(IGestorGrupos.EXITO_MIEMBROS) && mensajeQuitar.equals(IGestorGrupos.EXITO_MIEMBROS)) {
                JOptionPane.showMessageDialog(this.ventana, mensajeAgregar, "Notificacion", 1);
            } else if (!mensajeAgregar.equals(IGestorGrupos.EXITO_MIEMBROS) && !mensajeQuitar.equals(IGestorGrupos.EXITO_MIEMBROS)) {
                JOptionPane.showMessageDialog(this.ventana, mensajeAgregar + " y " + mensajeQuitar, "Notificacion", 1);
            }
        }

    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, "¿Desea cancelar la operación? Los cambios no guardados se perderán", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventana.dispose();
        }
    }

    private String quitarMiembrosNoSeleccionados() {
        IGestorGrupos gestorG = GestorGrupos.instanciar();
        List<MiembroEnGrupo> listaParaQuitar = new ArrayList<>();
        List<Integer> NoSeleccionados = new ArrayList<>();
        ModeloTablaMiembros mt = (ModeloTablaMiembros) this.ventana.verTablaMiembros().getModel();

        List<MiembroEnGrupo> listaMiembrosAux=gestorG.verGrupo(this.ventana.getTitle()).verMiembros();

        for (int fila = 0; fila < mt.getRowCount(); fila++) {
            if (!this.ventana.verTablaMiembros().isRowSelected(fila) && listaMiembrosAux.contains(new MiembroEnGrupo((Autor) this.ventana.verTablaMiembros().getValueAt(fila, 0), gestorG.verGrupo(this.ventana.getTitle()), (Rol) this.ventana.verTablaMiembros().getValueAt(fila, 1)))) {
                NoSeleccionados.add(fila);
            }
        }

        for (Integer fila : NoSeleccionados) {
            MiembroEnGrupo miembroAux = new MiembroEnGrupo((Autor) this.ventana.verTablaMiembros().getValueAt(fila, 0), gestorG.verGrupo(this.ventana.getTitle()), (Rol) this.ventana.verTablaMiembros().getValueAt(fila, 1));
            listaParaQuitar.add(miembroAux);
        }

        Grupo grupoAux = gestorG.verGrupo(this.ventana.getTitle());
        return gestorG.quitarMiembros(grupoAux, listaParaQuitar);
    }

    private String agregarMiembrosSeleccionados() {
        IGestorGrupos gestorG = GestorGrupos.instanciar();
        List<MiembroEnGrupo> listaParaAgregar = new ArrayList<>();

        int[] seleccionados = this.ventana.verTablaMiembros().getSelectedRows();

        for (int fila : seleccionados) {
            MiembroEnGrupo miembroAux = new MiembroEnGrupo((Autor) this.ventana.verTablaMiembros().getValueAt(fila, 0), gestorG.verGrupo(this.ventana.getTitle()), (Rol) this.ventana.verTablaMiembros().getValueAt(fila, 1));
            if(gestorG.verGrupo(this.ventana.getTitle()).verMiembros().contains(miembroAux)){
                int posicionMiembros=gestorG.verGrupo(this.ventana.getTitle()).verMiembros().indexOf(miembroAux);
                gestorG.verGrupo(this.ventana.getTitle()).verMiembros().get(posicionMiembros).asignarRol(miembroAux.verRol());
                int posicionGrupo=gestorG.verGrupo(this.ventana.getTitle()).verMiembros().get(posicionMiembros).verAutor().verGrupo().indexOf(miembroAux);
                gestorG.verGrupo(this.ventana.getTitle()).verMiembros().get(posicionMiembros).verAutor().verGrupo().get(posicionGrupo).asignarRol(miembroAux.verRol());
            }

            listaParaAgregar.add(miembroAux);
        }
        if (seleccionados.length != 0) {
            Grupo grupoAux = gestorG.verGrupo(this.ventana.getTitle());
            return gestorG.agregarMiembros(grupoAux, listaParaAgregar);
        }
        return IGestorGrupos.EXITO_MIEMBROS;
    }

    private void seleccionarMiembros() {
        ListSelectionModel modeloSeleccion = this.ventana.verTablaMiembros().getSelectionModel();
        ModeloTablaMiembros mt = (ModeloTablaMiembros) this.ventana.verTablaMiembros().getModel();
        IGestorGrupos gestor = GestorGrupos.instanciar();
        for (MiembroEnGrupo miembroEnGrupo : gestor.verGrupo(this.ventana.getTitle()).verMiembros()) {
            for (int fila = 0; fila < mt.getRowCount(); fila++) {
                Autor mb = mt.verAutor(fila);
                if (miembroEnGrupo.verAutor().equals(mb)) {
                    mt.setValueAt(miembroEnGrupo.verRol(), fila, 1);
                    modeloSeleccion.addSelectionInterval(fila, fila);
                    break;
                }
            }
        }
    }
    private void ConfigurarTabla() {
        this.ventana.verTablaMiembros().setModel(new ModeloTablaMiembrosYAutores());
        this.ventana.verTablaMiembros().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaMiembros().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //JComboBox comboRol = new JComboBox();
        //comboRol.setModel(new ModeloComboBoxRol());
        //this.ventana.getTablaMMiembrosGrupo().getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboRol));
    }
}
