package autores.controladores;

import autores.modelos.*;
import autores.vistas.VentanaAutores;
import interfaces.IControladorAMAlumno;
import interfaces.IControladorAMProfesor;
import interfaces.IControladorAutores;
import interfaces.IGestorAutores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class ControladorAutores implements IControladorAutores {
    private VentanaAutores ventana;
    private static ControladorAutores controlador;

    public ControladorAutores(java.awt.Frame ventanaPadre) {
        this.ventana = new VentanaAutores(this, ventanaPadre, true);
        this.ventana.setLocationRelativeTo(null);

        this.ventana.verTablaProfesores().setModel(new ModeloTablaProfesores());
        this.ventana.verTablaAlumnos().setModel(new ModeloTablaAlumnos());

        this.ventana.verTablaProfesores().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaAlumnos().getTableHeader().setReorderingAllowed(false);

        this.ventana.verTablaProfesores().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.ventana.verTablaAlumnos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.ventana.setTitle(TITULO);
        this.refrescarBotones();
        this.ventana.setVisible(true);
    }

    @Override
    public void btnNuevoProfesorClic(ActionEvent evt) {
        IControladorAMProfesor controladorProfesores = new ControladorAMProfesor(this.ventana);

        //Refresco los botones
        refrescarBotones();
        //Refresco la tabla luego de añadir un nuevo Profesor
        IGestorAutores gestor = GestorAutores.instanciar();
        ModeloTablaProfesores modeloTablaProfesores = (ModeloTablaProfesores) this.ventana.verTablaProfesores().getModel();
        modeloTablaProfesores.refrescarTabla(gestor.verProfesores());
    }

    @Override
    public void btnNuevoAlumnoClic(ActionEvent evt) {
        IControladorAMAlumno controladorAlumno = new ControladorAMAlumno(this.ventana);

        refrescarBotones();
        //Refresco la tabla luego de añadir un nuevo Alumno
        IGestorAutores gestor = GestorAutores.instanciar();
        ModeloTablaAlumnos modeloTablaAlumnos = (ModeloTablaAlumnos) this.ventana.verTablaAlumnos().getModel();
        modeloTablaAlumnos.refrescarTabla(gestor.verAlumnos());
    }

    @Override
    public void btnModificarProfesorClic(ActionEvent evt) {
        if (this.ventana.verTablaProfesores().getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(ventana, IControladorAutores.PROFESOR_NO_SELECCIONADO, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            int dniAux = (int) this.ventana.verTablaProfesores().getValueAt(this.ventana.verTablaProfesores().getSelectedRow(), 0);
            IControladorAMProfesor controladorProfesores = new ControladorAMProfesor(this.ventana, dniAux);
            IGestorAutores gestor = GestorAutores.instanciar();

            //Refresco la tabla luego de añadir un nuevo Profesor
            ModeloTablaProfesores modeloTablaProfesores = (ModeloTablaProfesores) this.ventana.verTablaProfesores().getModel();
            modeloTablaProfesores.refrescarTabla(gestor.verProfesores());
        }
    }

    @Override
    public void btnModificarAlumnoClic(ActionEvent evt) {
        if (this.ventana.verTablaAlumnos().getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(ventana, IControladorAutores.ALUMNO_NO_SELECCIONADO, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            int dniAux = (int) this.ventana.verTablaAlumnos().getValueAt(this.ventana.verTablaAlumnos().getSelectedRow(), 0);
            IControladorAMAlumno controladorAlumnos = new ControladorAMAlumno(this.ventana, dniAux);
            IGestorAutores gestor = GestorAutores.instanciar();

            //Refresco la tabla luego de añadir un nuevo Profesor
            ModeloTablaAlumnos modeloTablaAlumnos = (ModeloTablaAlumnos) this.ventana.verTablaAlumnos().getModel();
            modeloTablaAlumnos.refrescarTabla(gestor.verAlumnos());
        }
    }

    @Override
    public void btnBorrarProfesorClic(ActionEvent evt) {
        if (this.ventana.verTablaProfesores().getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(ventana, IControladorAutores.PROFESOR_NO_SELECCIONADO, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, ControladorAutores.CONFIRMACION_PROFESOR, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcionEscogida == JOptionPane.YES_OPTION) {
                //String mensaje = this.borrarProfesor();
                IGestorAutores gestor = GestorAutores.instanciar();
                Autor autorSeleccionado = gestor.verAutor((int) this.ventana.verTablaProfesores().getValueAt(this.ventana.verTablaProfesores().getSelectedRow(), 0));

                String estado = gestor.borrarAutor(autorSeleccionado);
                JOptionPane.showConfirmDialog(ventana, estado, "Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);

                refrescarBotones();

                //Refresco el ArrayList que se muestra en la tabla
                ModeloTablaProfesores modeloTablaProfesores = (ModeloTablaProfesores) this.ventana.verTablaProfesores().getModel();
                modeloTablaProfesores.refrescarTabla(gestor.verProfesores());
            }
        }
    }

    @Override
    public void btnBorrarAlumnoClic(ActionEvent evt) {
        if (this.ventana.verTablaAlumnos().getSelectedRow() == -1) {
            JOptionPane.showConfirmDialog(ventana, IControladorAutores.ALUMNO_NO_SELECCIONADO, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        } else {
            int opcionEscogida = JOptionPane.showOptionDialog(this.ventana, ControladorAutores.CONFIRMACION_ALUMNO, "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
            if (opcionEscogida == JOptionPane.YES_OPTION) {

                IGestorAutores gestor = GestorAutores.instanciar();
                Autor autorSeleccionado = gestor.verAutor((int) this.ventana.verTablaAlumnos().getValueAt(this.ventana.verTablaAlumnos().getSelectedRow(), 0));


                String estado = gestor.borrarAutor(autorSeleccionado);
                JOptionPane.showConfirmDialog(ventana, estado, "Información", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);


                refrescarBotones();
                //Refresco el ArrayList que se muestra en la tabla
                ModeloTablaAlumnos modeloTablaAlumnos = (ModeloTablaAlumnos) this.ventana.verTablaAlumnos().getModel();
                modeloTablaAlumnos.refrescarTabla(gestor.verAlumnos());
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
    public void btnBuscarProfesorClic(ActionEvent evt) {
        String busqueda = this.ventana.verTxtApellidoProfesor().getText();
        IGestorAutores gestor = GestorAutores.instanciar();
        List<Profesor> profesoresEncontrados = gestor.buscarProfesores(busqueda);

        ModeloTablaProfesores modeloTablaProfesores = (ModeloTablaProfesores) this.ventana.verTablaProfesores().getModel();
        modeloTablaProfesores.refrescarTabla(profesoresEncontrados);


        //Refresco la tabla luego de añadir un nuevo Profesor
        ModeloTablaAlumnos modeloTablaAlumnos = (ModeloTablaAlumnos) this.ventana.verTablaAlumnos().getModel();
        modeloTablaAlumnos.refrescarTabla(gestor.verAlumnos());
    }

    @Override
    public void btnBuscarAlumnoClic(ActionEvent evt) {
        String busqueda = this.ventana.verTxtApellidoAlumno().getText();
        IGestorAutores gestor = GestorAutores.instanciar();
        List<Alumno> alumnosEncontrados = gestor.buscarAlumnos(busqueda);

        ModeloTablaAlumnos modeloTablaAlumnos = (ModeloTablaAlumnos) this.ventana.verTablaAlumnos().getModel();
        modeloTablaAlumnos.refrescarTabla(alumnosEncontrados);

    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    @Override
    public void txtApellidosProfesorPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnBuscarProfesorClic(null);
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

    @Override
    public void txtApellidosAlumnoPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnBuscarAlumnoClic(null);
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

    private void refrescarBotones() {
        IGestorAutores gestor = GestorAutores.instanciar();
        if (gestor.verAlumnos().isEmpty()) {
            this.ventana.verBtnModificarAlumno().setEnabled(false);
            this.ventana.verBtnBorrarAlumno().setEnabled(false);
        } else {
            this.ventana.verBtnModificarAlumno().setEnabled(true);
            this.ventana.verBtnBorrarAlumno().setEnabled(true);
        }
        if (gestor.verProfesores().isEmpty()) {
            this.ventana.verBtnModificarProfesor().setEnabled(false);
            this.ventana.verBtnBorrarProfesor().setEnabled(false);
        } else {
            this.ventana.verBtnModificarProfesor().setEnabled(true);
            this.ventana.verBtnBorrarProfesor().setEnabled(true);
        }
    }
}
