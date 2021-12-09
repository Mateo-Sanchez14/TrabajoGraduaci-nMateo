package autores.controladores;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import autores.vistas.VentanaAMAlumno;
import grupos.modelos.ModeloTablaMiembros;
import interfaces.IControladorAMAlumno;
import interfaces.IGestorAutores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAMAlumno implements IControladorAMAlumno {
    private VentanaAMAlumno ventana;
    private static ControladorAMAlumno controlador;
    private boolean modo;
    int dni;

    public ControladorAMAlumno(javax.swing.JDialog ventanaPadre) {
        this.ventana = new VentanaAMAlumno(this, ventanaPadre, true);
        this.modo = false;
        this.ventana.setTitle(TITULO_NUEVO);

        this.ventana.verTablaMiembro().setModel(new ModeloTablaMiembros());
        this.ventana.verTablaMiembro().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaMiembro().setEnabled(false);

        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    public ControladorAMAlumno(javax.swing.JDialog ventanaPadre, int dni) {
        this.ventana = new VentanaAMAlumno(this, ventanaPadre, true);
        this.modo = true;
        this.ventana.setTitle(TITULO_MODIFICAR);

        this.asignarTxtFields(dni);
        this.dni = dni;

        this.ventana.verTablaMiembro().setModel(new ModeloTablaMiembros());
        this.ventana.verTablaMiembro().getTableHeader().setReorderingAllowed(false);
        this.ventana.verTablaMiembro().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    @Override
    public void btnGuardarClic(ActionEvent evt) {
        if (!ventana.verTxtDNI().getText().trim().isEmpty() && ventana.verTxtDNI().getText().trim().matches("[+-]?\\d*(\\.\\d+)?") && modo == false)
            dni = Integer.parseInt(ventana.verTxtDNI().getText().trim());
        String apellidos = ventana.verTxtApellidos().getText().trim();
        String nombres = ventana.verTxtNombres().getText().trim();
        String clave = new String(ventana.verPassClave().getPassword());
        String claveRepetida = new String(ventana.verPassClaveRepetida().getPassword());
        String cx = ventana.verTxtCX().getText().trim();

        IGestorAutores gestorAutores = GestorAutores.instanciar();
        String mensaje;
        if (modo == false) {
            mensaje = gestorAutores.nuevoAutor(dni, apellidos, nombres, cx, clave, claveRepetida);
        } else {
            mensaje = gestorAutores.modificarAutor(gestorAutores.verAutor(dni), apellidos, nombres, cx, clave, claveRepetida);
        }
        if (mensaje.equals(IGestorAutores.EXITO)) {
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
    public void txtApellidosPresionarTecla(KeyEvent evt) {
        this.handlerPresionarTeclaTexto(evt);
    }

    @Override
    public void txtNombresPresionarTecla(KeyEvent evt) {
        this.handlerPresionarTeclaTexto(evt);
    }

    @Override
    public void txtDocumentoPresionarTecla(KeyEvent evt) {
        this.handlerPresionarTeclaNum(evt);
    }

    @Override
    public void txtCXPresionarTecla(KeyEvent evt) {
        this.handlerPresionarTeclaNum(evt);
    }

    @Override
    public void passClavePresionarTecla(KeyEvent evt) {
        this.handlerPresionarTeclaPass(evt);
    }

    @Override
    public void passRepetirClavePresionarTecla(KeyEvent evt) {
        this.handlerPresionarTeclaPass(evt);
    }

    @Override
    public void ventanaObtenerFoco(WindowEvent evt) {

    }

    private void asignarTxtFields(int dni) {
        IGestorAutores gestorAutores = GestorAutores.instanciar();
        Autor autorAux = gestorAutores.verAutor(dni);
        Alumno alumno = (Alumno) autorAux;

        this.ventana.verTxtDNI().setText(String.valueOf(dni));
        this.ventana.verTxtDNI().setEnabled(false);
        this.ventana.verTxtNombres().setText(alumno.verNombres());
        this.ventana.verTxtApellidos().setText(alumno.verApellidos());
        this.ventana.verTxtCX().setText(alumno.verCx());
    }

    private void handlerPresionarTeclaTexto(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
                    break;
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_SPACE:
                case KeyEvent.VK_BACK_SPACE:
                    break;
                default:
                    JOptionPane.showConfirmDialog(ventana, "Solamente está permitido el ingreso de caracteres alfabéticos", "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                    evt.consume();
                    break;
            }
        }
    }

    private void handlerPresionarTeclaNum(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
                    break;
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_BACK_SPACE:
                    break;
                default:
                    JOptionPane.showConfirmDialog(ventana, "Solamente está permitido el ingreso de caracteres numéricos", "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                    evt.consume();
                    break;
            }
        }
    }

    private void handlerPresionarTeclaPass(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
                    break;
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_BACK_SPACE:
                    break;
                default:
                    JOptionPane.showConfirmDialog(ventana, "Solamente está permitido el ingreso de caracteres alfanuméricos", "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                    evt.consume();
                    break;
            }
        }
    }
    //</editor-fold>
}
