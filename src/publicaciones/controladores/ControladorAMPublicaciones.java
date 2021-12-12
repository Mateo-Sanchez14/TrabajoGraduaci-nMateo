/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.controladores;

import autores.modelos.GestorAutores;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.GestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IControladorAMPublicacion;
import interfaces.IControladorPrincipal;

import static interfaces.IControladorPublicaciones.TITULO;

import interfaces.IGestorAutores;
import interfaces.IGestorIdiomas;
import interfaces.IGestorLugares;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import lugares.modelos.GestorLugares;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.ModeloTablaPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.GestorPublicaciones;
import publicaciones.modelos.ModeloComboBoxPublicaciones;
import publicaciones.modelos.Publicacion;
import publicaciones.vistas.VentanaAMPublicaciones;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;


public class ControladorAMPublicaciones implements IControladorAMPublicacion {

    private VentanaAMPublicaciones ventanaAMPublicaciones;
    private boolean modoModifciar; //false para crear, true para modificar

    //Para crear
    public ControladorAMPublicaciones(javax.swing.JDialog ventanaPadre) {
        this.ventanaAMPublicaciones = new VentanaAMPublicaciones(this, ventanaPadre, true);
        this.ventanaAMPublicaciones.setLocationRelativeTo(null);
        this.configuracionTablas();
        this.configuraciondeComboBox();
        this.modoModifciar = false;

        this.ventanaAMPublicaciones.setTitle(TITULO_NUEVA);
        this.ventanaAMPublicaciones.setVisible(true);
    }

    //Para modificar
    public ControladorAMPublicaciones(javax.swing.JDialog ventanaPadre, String titulo) {
        this.ventanaAMPublicaciones = new VentanaAMPublicaciones(this, ventanaPadre, true);
        this.ventanaAMPublicaciones.setLocationRelativeTo(null);
        this.configuracionTablas();
        this.configuraciondeComboBox(titulo);
        this.asignarTxtFields(titulo);
        this.seleccionarPalabrasClave();
        this.modoModifciar = true;

        this.ventanaAMPublicaciones.setTitle(TITULO_MODIFICAR);
        this.ventanaAMPublicaciones.setVisible(true);
    }


    @Override
    public void btnGuardarClic(ActionEvent evt) {
        String mensaje = guardarPublicacion();
        JOptionPane.showMessageDialog(this.ventanaAMPublicaciones, mensaje, "Notificacion", 1);
        if (mensaje.equals(IGestorPublicaciones.EXITO)) {
            this.ventanaAMPublicaciones.dispose();
        }
    }

    @Override
    public void btnCancelarClic(ActionEvent evt) {
        int opcionEscogida = JOptionPane.showOptionDialog(this.ventanaAMPublicaciones, "¿Desea cancelar la operación? Los cambios no guardados se perderán", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (opcionEscogida == JOptionPane.YES_OPTION) {
            this.ventanaAMPublicaciones.dispose();
        }
    }

    @Override
    public void txtTituloPresionarTecla(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (c == KeyEvent.VK_ENTER) {
            this.btnGuardarClic(null);
        }
    }

    @Override
    public void btnTodasLasPalabrasClavesClic(ActionEvent evt) {
        ModeloTablaPalabrasClaves Modeloaux = (ModeloTablaPalabrasClaves) this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getModel();
        ListSelectionModel modeloSeleccion = this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getSelectionModel();
        modeloSeleccion.addSelectionInterval(0, Modeloaux.getRowCount() - 1);
    }

    @Override
    public void btnNingunaPalabraClaveClic(ActionEvent evt) {
        ListSelectionModel modeloSeleccion = this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getSelectionModel();
        modeloSeleccion.clearSelection();
    }

    //REVISAR
    @Override
    public void btnAbrirClic(ActionEvent evt) {
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.lookInLabelText", "Buscar en:");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo:");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Archivos del tipo:");
        UIManager.put("FileChooser.upFolderToolTipText", "Subir un nivel");
        UIManager.put("FileChooser.homeFolderToolTipText", "Inicio");
        UIManager.put("FileChooser.newFolderToolTipText", "Carpeta nueva");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Lista");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Detalles");
        JFileChooser selector = new JFileChooser();
        selector.setCurrentDirectory(new File(System.getProperty("user.home")));
        selector.setDialogTitle(IControladorPrincipal.TITULO);
        selector.setAcceptAllFileFilterUsed(false); //no se muestra el filtro de todos los archivos
        int resultado = selector.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) { //se selecciona un archivo
            File selectedFile = selector.getSelectedFile();
            this.ventanaAMPublicaciones.getTxtAMPublicacionesEnlace().setText(selectedFile.getAbsolutePath());
        }
    }

    private void asignarTxtFields(String titulo) {
        IGestorPublicaciones gestor = GestorPublicaciones.instanciar();
        Publicacion publicacion = gestor.verPublicacion(titulo);
        this.ventanaAMPublicaciones.getTxtAMPublicacionesTitulo().setText(titulo);
        this.ventanaAMPublicaciones.getTxtAMPublicacionesTitulo().setEditable(false); //Desactivo edicion
        this.ventanaAMPublicaciones.getComboAMPublicacionesGrupo().setSelectedItem(publicacion.verMiembroEnGrupo());
        this.ventanaAMPublicaciones.getComboAMPublicacionesIdioma().setSelectedItem(publicacion.verIdioma());
        this.ventanaAMPublicaciones.getComboAMPublicacionesLugar().setSelectedItem(publicacion.verLugar());
        this.ventanaAMPublicaciones.getComboAMPublicacionesTipo().setSelectedItem(publicacion.verTipo());
        this.ventanaAMPublicaciones.getTxtAMPublicacionesEnlace().setText(publicacion.verEnlace());
        this.ventanaAMPublicaciones.getDateChooserAMPublicaciones().setDate(Date.from(publicacion.verFechaPublicacion().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        this.ventanaAMPublicaciones.getTxtAMPublicacionesResumen().setText(publicacion.verResumen());

    }

    private void configuraciondeComboBox(String titulo) {
        IGestorIdiomas gestorIdioma = GestorIdiomas.instanciar();
        IGestorLugares gestorLugar = GestorLugares.instanciar();
        IGestorTipos gestortipo = GestorTipos.instanciar();
        this.ventanaAMPublicaciones.getComboAMPublicacionesIdioma().setModel(new ModeloComboBoxPublicaciones(gestorIdioma.verIdiomas()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesLugar().setModel(new ModeloComboBoxPublicaciones(gestorLugar.verLugares()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesTipo().setModel(new ModeloComboBoxPublicaciones(gestortipo.verTipos()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesGrupo().setModel(new ModeloComboBoxPublicaciones(obtenerGruposDelAutor(titulo)));
    }

    private void configuraciondeComboBox() {
        IGestorIdiomas gestorIdioma = GestorIdiomas.instanciar();
        IGestorLugares gestorLugar = GestorLugares.instanciar();
        IGestorTipos gestortipo = GestorTipos.instanciar();
        this.ventanaAMPublicaciones.getComboAMPublicacionesIdioma().setModel(new ModeloComboBoxPublicaciones(gestorIdioma.verIdiomas()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesLugar().setModel(new ModeloComboBoxPublicaciones(gestorLugar.verLugares()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesTipo().setModel(new ModeloComboBoxPublicaciones(gestortipo.verTipos()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesGrupo().setModel(new ModeloComboBoxPublicaciones(obtenergruposdelautor()));
        this.ventanaAMPublicaciones.getComboAMPublicacionesIdioma().setSelectedIndex(-1);
        this.ventanaAMPublicaciones.getComboAMPublicacionesLugar().setSelectedIndex(-1);
        this.ventanaAMPublicaciones.getComboAMPublicacionesTipo().setSelectedIndex(-1);
        this.ventanaAMPublicaciones.getComboAMPublicacionesGrupo().setSelectedIndex(-1);
    }

    private String guardarPublicacion() {
        IGestorPublicaciones gestor = GestorPublicaciones.instanciar();
        String Titulo = this.ventanaAMPublicaciones.getTxtAMPublicacionesTitulo().getText();
        Tipo tipo = (Tipo) this.ventanaAMPublicaciones.getComboAMPublicacionesTipo().getModel().getSelectedItem();
        Lugar lugar = (Lugar) this.ventanaAMPublicaciones.getComboAMPublicacionesLugar().getModel().getSelectedItem();
        Idioma idioma = (Idioma) this.ventanaAMPublicaciones.getComboAMPublicacionesIdioma().getModel().getSelectedItem();
        String enlace = this.ventanaAMPublicaciones.getTxtAMPublicacionesEnlace().getText();
        String resumen = this.ventanaAMPublicaciones.getTxtAMPublicacionesResumen().getText();
        LocalDate fechaPublicacion = this.definirFecha();
        //LocalDate fechaPublicacion = LocalDate.of(2000, Month.MARCH, 1);
        MiembroEnGrupo creador = (MiembroEnGrupo) this.ventanaAMPublicaciones.getComboAMPublicacionesGrupo().getSelectedItem();
        List<PalabraClave> palabrasClaves = obtenerpalabrasclaves();
        if (modoModifciar == false)
            return gestor.nuevaPublicacion(Titulo, creador, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);
        else
            return gestor.modificarPublicacion(gestor.verPublicacion(Titulo), creador, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen );
    }


    private List<PalabraClave> obtenerpalabrasclaves() {
        IGestorPalabrasClaves gestorpalabrasclaves = GestorPalabrasClaves.instanciar();
        int[] seleccionados = this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getSelectedRows();
        List<PalabraClave> palabrasclavesmarcadas = new ArrayList<>();
        for (int posicion : seleccionados) {
            palabrasclavesmarcadas.add(gestorpalabrasclaves.verPalabrasClaves().get(posicion));
        }
        return palabrasclavesmarcadas;
    }

    private List<MiembroEnGrupo> obtenerGruposDelAutor(String titulo) {
        IGestorPublicaciones gestorP = GestorPublicaciones.instanciar();
        return gestorP.verPublicacion(titulo).verMiembroEnGrupo().verAutor().verGrupo();
    }

    private List<MiembroEnGrupo> obtenergruposdelautor() {
        IGestorAutores gestorautor = GestorAutores.instanciar();
        return gestorautor.verAutores().get(0).verGrupo();
    }


    private void configuracionTablas() {
        this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().setModel(new ModeloTablaPalabrasClaves());
        this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getTableHeader().setReorderingAllowed(false);
        this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    private LocalDate definirFecha(){
        try{
            Date date = this.ventanaAMPublicaciones.getDateChooserAMPublicaciones().getCalendar().getTime();
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }catch(NullPointerException e){
            return null;
        }
    }

    private void seleccionarPalabrasClave() {
        ListSelectionModel modeloSeleccion = this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getSelectionModel();
        ModeloTablaPalabrasClaves mt = (ModeloTablaPalabrasClaves) this.ventanaAMPublicaciones.getTablaAMPublicacionesPalabrasClaves().getModel();
        IGestorPublicaciones gestor = GestorPublicaciones.instanciar();
        for (PalabraClave palabraClaveAux : gestor.verPublicacion(this.ventanaAMPublicaciones.getTxtAMPublicacionesTitulo().getText()).verPalabrasClaves()) {
            for (int fila = 0; fila < mt.getRowCount(); fila++) {
                PalabraClave pc = mt.verPalabraClave(fila);
                if (palabraClaveAux.equals(pc)) {
                    modeloSeleccion.addSelectionInterval(fila, fila);
                    break;
                }
            }
        }
    }
}
