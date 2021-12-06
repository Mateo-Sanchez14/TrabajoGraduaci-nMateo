package autores.controladores;

import autores.modelos.*;
import autores.vistas.VentanaAMProfesor;
import interfaces.IControladorAMProfesor;
import interfaces.IGestorAutores;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ControladorAMProfesor implements IControladorAMProfesor {
    private VentanaAMProfesor ventana;
    private static ControladorAMProfesor controlador;
    private boolean modo; // False indica modo añadir profesor, true modificarlo
    private int dni = 0;

    public ControladorAMProfesor(javax.swing.JDialog ventanaPadre) {
        this.ventana = new VentanaAMProfesor(this, ventanaPadre, true);
        this.modo = false;

        this.ventana.setTitle(TITULO_NUEVO);

        this.ventana.verComboCargos().setModel(new ModeloComboCargos());
        this.ventana.verComboCargos().setSelectedIndex(-1);

        this.ventana.setLocationRelativeTo(null);
        this.ventana.setVisible(true);
    }

    public ControladorAMProfesor(javax.swing.JDialog ventanaPadre, int dni) {
        this.ventana = new VentanaAMProfesor(this, ventanaPadre, true);
        this.ventana.setTitle(TITULO_MODIFICAR);

        this.ventana.verComboCargos().setModel(new ModeloComboCargos());

        this.asignarTxtFields(dni);
        this.dni = dni;
        this.modo = true;

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
        Cargo cargo = ((ModeloComboCargos) ventana.verComboCargos().getModel()).obtenerCargo();

        IGestorAutores gestorAutores = GestorAutores.instanciar();
        String mensaje;
        if (modo == false) {
            mensaje = gestorAutores.nuevoAutor(dni, apellidos, nombres, cargo, clave, claveRepetida);
        } else {
            mensaje = gestorAutores.modificarAutor(gestorAutores.verAutor(dni), apellidos, nombres, cargo, clave, claveRepetida);
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

    private void handlerPresionarTeclaTexto(KeyEvent evt){
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c)) {
            switch (c) {
                case KeyEvent.VK_ENTER:
                    this.btnGuardarClic(null);
                    break;
                case KeyEvent.VK_DELETE:
                case KeyEvent.VK_BACK_SPACE:
                case KeyEvent.VK_SPACE:
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
    private void handlerPresionarTeclaPass(KeyEvent evt){
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
    private void asignarTxtFields(int dni) {
        IGestorAutores gestorAutores = GestorAutores.instanciar();
        Autor autorAux = gestorAutores.verAutor(dni);
        Profesor profesor = (Profesor) autorAux;

        this.ventana.verTxtDNI().setText(String.valueOf(dni));
        this.ventana.verTxtDNI().setEnabled(false);
        this.ventana.verTxtNombres().setText(profesor.verNombres());
        this.ventana.verTxtApellidos().setText(profesor.verApellidos());
        Cargo cargo = profesor.verCargo();
        int cargoEntero;
        switch (cargo) {
            case TITULAR:
                cargoEntero = 0;
                break;
            case ASOCIADO:
                cargoEntero = 1;
                break;
            case ADJUNTO:
                cargoEntero = 2;
                break;
            case JTP:
                cargoEntero = 3;
                break;
            case ADG:
                cargoEntero = 4;
                break;
            default:
                cargoEntero = -1;
                break;
        }
        this.ventana.verComboCargos().setSelectedIndex(cargoEntero);

//        TITULAR, ASOCIADO,
//                ADJUNTO, JTP, ADG;
    }
    //</editor-fold>
}
