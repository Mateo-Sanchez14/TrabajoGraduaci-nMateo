/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.controladores.ControladorAMProfesor;

import javax.swing.*;

public class VentanaAMProfesor extends JDialog {
    private ControladorAMProfesor controlador;

    /**
     * Constructor
     * @param ventanaPadre ventana padre
     */
    public VentanaAMProfesor(ControladorAMProfesor controlador,javax.swing.JDialog ventanaPadre, boolean modal) {
        super(ventanaPadre, true);
        initComponents();
        this.controlador = controlador;
    }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        passClave = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        comboCargos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        passClaveRepetida = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Profesores");
        setResizable(false);

        jLabel1.setText("Apellidos:");

        txtApellidos.setToolTipText("Ingrese el apellido del profesor, solo se permiten caracteres alfabéticos");
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });

        jLabel2.setText("Nombres:");

        txtNombres.setToolTipText("Ingrese el nombre del profesor, solo se permiten caracteres alfabéticos");
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });

        btnGuardar.setMnemonic('G');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Presione para guardar el profesor");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClic(evt);
            }
        });

        jLabel3.setText("Cargo:");

        jLabel4.setText("Documento:");

        txtDNI.setToolTipText("Ingrese el DNI del alumno, solamente se permiten caracteres numéricos");
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        passClave.setToolTipText("Ingrese la clave del profesor, solo se permiten caracteres alfanuméricos");
        passClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClaveKeyTyped(evt);
            }
        });

        jLabel6.setText("Clave:");

        comboCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCargos.setToolTipText("Seleccione el cargo del profesor");
        comboCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCargosActionPerformed(evt);
            }
        });

        jLabel5.setText("Repetir Clave:");

        passClaveRepetida.setToolTipText("Repita la clave del profesor, solo se permiten caracteres alfanuméricos");
        passClaveRepetida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClaveRepetidaKeyTyped(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClick(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passClaveRepetida)
                            .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                            .addComponent(txtDNI)
                            .addComponent(txtApellidos)
                            .addComponent(passClave)
                            .addComponent(comboCargos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passClaveRepetida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClic
        controlador.btnGuardarClic(evt);
    }//GEN-LAST:event_btnGuardarClic

    private void comboCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCargosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboCargosActionPerformed

    private void btnCancelarClick(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClick
        controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_btnCancelarClick

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        controlador.txtDocumentoPresionarTecla(evt);
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        controlador.txtApellidosPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        controlador.txtNombresPresionarTecla(evt);
    }//GEN-LAST:event_txtNombresKeyTyped

    private void passClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClaveKeyTyped
        controlador.passClavePresionarTecla(evt);
    }//GEN-LAST:event_passClaveKeyTyped

    private void passClaveRepetidaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClaveRepetidaKeyTyped
        controlador.passRepetirClavePresionarTecla(evt);
    }//GEN-LAST:event_passClaveRepetidaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboCargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField passClave;
    private javax.swing.JPasswordField passClaveRepetida;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables


    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">

    public ControladorAMProfesor verControlador() {
        return controlador;
    }

    public void asignarControlador(ControladorAMProfesor controlador) {
        this.controlador = controlador;
    }

    public JButton verBtnCancelar() {
        return btnCancelar;
    }

    public void asignarBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton verBtnGuardar() {
        return btnGuardar;
    }

    public void asignarBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JComboBox<String> verComboCargos() {
        return comboCargos;
    }

    public void asignarComboCargos(JComboBox<String> comboCargos) {
        this.comboCargos = comboCargos;
    }

    public JLabel verjLabel1() {
        return jLabel1;
    }

    public void asignarjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel verjLabel2() {
        return jLabel2;
    }

    public void asignarjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel verjLabel3() {
        return jLabel3;
    }

    public void asignarjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel verjLabel4() {
        return jLabel4;
    }

    public void asignarjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel verjLabel5() {
        return jLabel5;
    }

    public void asignarjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel verjLabel6() {
        return jLabel6;
    }

    public void asignarjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JPasswordField verPassClave() {
        return passClave;
    }

    public void asignarPassClave(JPasswordField passClave) {
        this.passClave = passClave;
    }

    public JPasswordField verPassClaveRepetida() {
        return passClaveRepetida;
    }

    public void asignarPassClaveRepetida(JPasswordField passClaveRepetida) {
        this.passClaveRepetida = passClaveRepetida;
    }

    public JTextField verTxtApellidos() {
        return txtApellidos;
    }

    public void asignarTxtApellidos(JTextField txtApellidos) {
        this.txtApellidos = txtApellidos;
    }

    public JTextField verTxtDNI() {
        return txtDNI;
    }

    public void asignarTxtDNI(JTextField txtDNI) {
        this.txtDNI = txtDNI;
    }

    public JTextField verTxtNombres() {
        return txtNombres;
    }

    public void asignarTxtNombres(JTextField txtNombres) {
        this.txtNombres = txtNombres;
    }


    //</editor-fold>
}
