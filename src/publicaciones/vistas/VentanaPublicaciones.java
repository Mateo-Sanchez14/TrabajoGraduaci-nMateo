/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.vistas;

import interfaces.IControladorPublicaciones;
import interfaces.IGestorPublicaciones;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Pichi
 */
public class VentanaPublicaciones extends javax.swing.JDialog{
    IControladorPublicaciones controladorVentanaPublicacion;
    
    //IControladorGrupos controlador, java.awt.Frame parent, boolean modal
    public VentanaPublicaciones(IControladorPublicaciones controlador, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.controladorVentanaPublicacion=controlador;
        initComponents();
    }

    
    public JTable getTablaPublicaciones() {
        return TablaPublicaciones;
    }

    public JTextField getTxtPublicacionesTitulo() {
        return TxtPublicacionesTitulo;
    }

    public JButton getBtnPublicacionesBorrar() {
        return btnPublicacionesBorrar;
    }

    public JButton getBtnPublicacionesModificar() {
        return btnPublicacionesModificar;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TxtPublicacionesTitulo = new javax.swing.JTextField();
        btnPublicacionesBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPublicaciones = new javax.swing.JTable();
        btnPublicacionesNuevo = new javax.swing.JButton();
        btnPublicacionesBorrar = new javax.swing.JButton();
        btnPublicacionesVolver = new javax.swing.JButton();
        btnPublicacionesModificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Idiomas");
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Titulo:");

        TxtPublicacionesTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPublicacionesTituloKeyTyped(evt);
            }
        });

        btnPublicacionesBuscar.setText("Buscar");
        btnPublicacionesBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicacionesBuscarActionPerformed(evt);
            }
        });

        TablaPublicaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaPublicaciones);

        btnPublicacionesNuevo.setText("Nuevo");
        btnPublicacionesNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicacionesNuevoActionPerformed(evt);
            }
        });

        btnPublicacionesBorrar.setText("Borrar");
        btnPublicacionesBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicacionesBorrarActionPerformed(evt);
            }
        });

        btnPublicacionesVolver.setText("Volver");
        btnPublicacionesVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicacionesVolverActionPerformed(evt);
            }
        });

        btnPublicacionesModificar.setText("Modificar");
        btnPublicacionesModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublicacionesModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPublicacionesVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtPublicacionesTitulo))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPublicacionesNuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPublicacionesBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPublicacionesBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPublicacionesModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtPublicacionesTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPublicacionesBuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPublicacionesNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPublicacionesModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPublicacionesBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPublicacionesVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnPublicacionesBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicacionesBorrarActionPerformed
       this.controladorVentanaPublicacion.btnBorrarClic(evt);
    }//GEN-LAST:event_btnPublicacionesBorrarActionPerformed

    private void btnPublicacionesNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicacionesNuevoActionPerformed
        this.controladorVentanaPublicacion.btnNuevaClic(evt);
    }//GEN-LAST:event_btnPublicacionesNuevoActionPerformed

    private void btnPublicacionesBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicacionesBuscarActionPerformed
        this.controladorVentanaPublicacion.btnBuscarClic(evt);
    }//GEN-LAST:event_btnPublicacionesBuscarActionPerformed

    private void btnPublicacionesVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicacionesVolverActionPerformed
        this.controladorVentanaPublicacion.btnVolverClic(evt);
    }//GEN-LAST:event_btnPublicacionesVolverActionPerformed

    private void TxtPublicacionesTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPublicacionesTituloKeyTyped
       this.controladorVentanaPublicacion.txtTituloPresionarTecla(evt);
    }//GEN-LAST:event_TxtPublicacionesTituloKeyTyped

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       this.controladorVentanaPublicacion.ventanaObtenerFoco(evt);
    }//GEN-LAST:event_formWindowGainedFocus

    private void btnPublicacionesModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublicacionesModificarActionPerformed
       this.controladorVentanaPublicacion.btnModificarClic(evt);
    }//GEN-LAST:event_btnPublicacionesModificarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPublicaciones;
    private javax.swing.JTextField TxtPublicacionesTitulo;
    private javax.swing.JButton btnPublicacionesBorrar;
    private javax.swing.JButton btnPublicacionesBuscar;
    private javax.swing.JButton btnPublicacionesModificar;
    private javax.swing.JButton btnPublicacionesNuevo;
    private javax.swing.JButton btnPublicacionesVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
