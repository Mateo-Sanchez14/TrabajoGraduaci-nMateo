package principal.controladores;

//import autores.controladores.ControladorAutores;
//import interfaces.IControladorAutores;
import interfaces.IControladorAPalabraClave;
import interfaces.IControladorPalabrasClaves;
import interfaces.IControladorPrincipal;
import palabrasclaves.controladores.ControladorPalabrasClaves;
import principal.vistas.VentanaPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ControladorPrincipal implements IControladorPrincipal {
    private VentanaPrincipal ventana;
    private static ControladorPrincipal controlador;

    public ControladorPrincipal() {
        this.ventana = new VentanaPrincipal(this);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setTitle(ControladorPrincipal.TITULO);

    }

    public static ControladorPrincipal instanciar() {
        if (controlador == null)
            controlador = new ControladorPrincipal();
        return controlador;
    }

    @Override
    public void btnAutoresClic(ActionEvent evt) {
        //IControladorAutores controladorAutores = new ControladorAutores(this.ventana);
    }

    @Override
    public void btnSalirClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventana,  ControladorPrincipal.CONFIRMACION, "Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,null,new Object[] {"Si","No"},"Si");
        if(opcionEscogida==JOptionPane.YES_OPTION){
            this.ventana.dispose();
        }
    }

    @Override
    public void btnPalabrasClavesClic(ActionEvent evt){
        IControladorPalabrasClaves controladorPalabrasClaves = new ControladorPalabrasClaves(this.ventana);
    }

    public static void main(String[] args) {

        ControladorPrincipal cp = new ControladorPrincipal();

    }

    @Override
    public void btnLugaresClic(ActionEvent evt) {

    }

    @Override
    public void btnIdiomasClic(ActionEvent evt) {

    }

    @Override
    public void btnTiposClic(ActionEvent evt) {

    }

    @Override
    public void btnGruposClic(ActionEvent evt) {

    }

    @Override
    public void btnPublicacionesClic(ActionEvent evt) {

    }
}
