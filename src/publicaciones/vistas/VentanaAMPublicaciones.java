/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.vistas;





import interfaces.IControladorAMPublicacion;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Pichi
 */
public class VentanaAMPublicaciones extends javax.swing.JDialog {

  private IControladorAMPublicacion controlador;

    public VentanaAMPublicaciones(IControladorAMPublicacion controlador, javax.swing.JDialog padre, boolean modal) {
        super(padre, modal);
        this.controlador=controlador;
        initComponents();
    }

    public JButton getBtnAMPublicacionAbrir() {
        return BtnAMPublicacionAbrir;
    }

    public JComboBox<String> getComboAMPublicacionesGrupo() {
        return ComboAMPublicacionesGrupo;
    }

    public JComboBox<String> getComboAMPublicacionesIdioma() {
        return ComboAMPublicacionesIdioma;
    }

    public JComboBox<String> getComboAMPublicacionesLugar() {
        return ComboAMPublicacionesLugar;
    }

    public JComboBox<String> getComboAMPublicacionesTipo() {
        return ComboAMPublicacionesTipo;
    }

    public JTable getTablaAMPublicacionesPalabrasClaves() {
        return TablaAMPublicacionesPalabrasClaves;
    }

    public JTextField getTxtAMPublicacionesEnlace() {
        return TxtAMPublicacionesEnlace;
    }

//    public JDateChooser getDateChooserAMPublicaciones() {
//        return DateChooserAMPublicaciones;
//    }

    public JTextArea getTxtAMPublicacionesResumen() {
        return TxtAMPublicacionesResumen;
    }

    public JTextField getTxtAMPublicacionesTitulo() {
        return TxtAMPublicacionesTitulo;
    }

    public JButton getBtnAMPublicacionesNinguna() {
        return btnAMPublicacionesNinguna;
    }

    public JButton getBtnAMPublicacionesTodas() {
        return btnAMPublicacionesTodas;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAMPublicacionesPalabrasClaves = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtAMPublicacionesTitulo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TxtAMPublicacionesEnlace = new javax.swing.JTextField();
        BtnAMPublicacionAbrir = new javax.swing.JButton();
        ComboAMPublicacionesGrupo = new javax.swing.JComboBox<>();
        ComboAMPublicacionesLugar = new javax.swing.JComboBox<>();
        ComboAMPublicacionesTipo = new javax.swing.JComboBox<>();
        ComboAMPublicacionesIdioma = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtAMPublicacionesResumen = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        btnAMPublicacionesTodas = new javax.swing.JButton();
        btnAMPublicacionesNinguna = new javax.swing.JButton();
        btnAMPublicacionesGuardar = new javax.swing.JButton();
        btnAMPublicacionesCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        TablaAMPublicacionesPalabrasClaves.setModel(new javax.swing.table.DefaultTableModel(
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
        TablaAMPublicacionesPalabrasClaves.setMinimumSize(new java.awt.Dimension(250, 64));
        TablaAMPublicacionesPalabrasClaves.setPreferredSize(new java.awt.Dimension(250, 64));
        jScrollPane1.setViewportView(TablaAMPublicacionesPalabrasClaves);

        jLabel1.setText("Titulo:");

        jLabel2.setText("Fecha:");

        jLabel3.setText("Grupo:");

        jLabel4.setText("Lugar:");

        jLabel5.setText("Tipo:");

        jLabel6.setText("Idioma:");

        TxtAMPublicacionesTitulo.setPreferredSize(new java.awt.Dimension(396, 20));
        TxtAMPublicacionesTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtAMPublicacionesTituloKeyTyped(evt);
            }
        });

        jLabel7.setText("Enlace: ");

        TxtAMPublicacionesEnlace.setMaximumSize(new java.awt.Dimension(180, 2147483647));
        TxtAMPublicacionesEnlace.setMinimumSize(new java.awt.Dimension(180, 20));
        TxtAMPublicacionesEnlace.setPreferredSize(new java.awt.Dimension(180, 20));

        BtnAMPublicacionAbrir.setText("...");
        BtnAMPublicacionAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAMPublicacionAbrirActionPerformed(evt);
            }
        });

        ComboAMPublicacionesGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAMPublicacionesGrupo.setPreferredSize(new java.awt.Dimension(120, 20));

        ComboAMPublicacionesLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAMPublicacionesLugar.setMinimumSize(new java.awt.Dimension(120, 20));
        ComboAMPublicacionesLugar.setPreferredSize(new java.awt.Dimension(120, 20));

        ComboAMPublicacionesTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAMPublicacionesTipo.setPreferredSize(new java.awt.Dimension(120, 20));

        ComboAMPublicacionesIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboAMPublicacionesIdioma.setPreferredSize(new java.awt.Dimension(120, 20));

        jLabel8.setText("Palabras Claves:");

        TxtAMPublicacionesResumen.setColumns(20);
        TxtAMPublicacionesResumen.setRows(5);
        jScrollPane2.setViewportView(TxtAMPublicacionesResumen);

        jLabel9.setText("Resumen: ");

        btnAMPublicacionesTodas.setText("Todas");
        btnAMPublicacionesTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAMPublicacionesTodasActionPerformed(evt);
            }
        });

        btnAMPublicacionesNinguna.setText("Ninguna");
        btnAMPublicacionesNinguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAMPublicacionesNingunaActionPerformed(evt);
            }
        });

        btnAMPublicacionesGuardar.setText("Guardar");
        btnAMPublicacionesGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAMPublicacionesGuardarActionPerformed(evt);
            }
        });

        btnAMPublicacionesCancelar.setText("Cancelar");
        btnAMPublicacionesCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAMPublicacionesCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAMPublicacionesGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAMPublicacionesCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TxtAMPublicacionesTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ComboAMPublicacionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(ComboAMPublicacionesIdioma, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ComboAMPublicacionesLugar, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(ComboAMPublicacionesTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TxtAMPublicacionesEnlace, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BtnAMPublicacionAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAMPublicacionesTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAMPublicacionesNinguna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addComponent(jLabel9))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtAMPublicacionesTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(ComboAMPublicacionesGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ComboAMPublicacionesLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ComboAMPublicacionesTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ComboAMPublicacionesIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtAMPublicacionesEnlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAMPublicacionAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAMPublicacionesTodas)
                    .addComponent(btnAMPublicacionesNinguna))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAMPublicacionesGuardar)
                    .addComponent(btnAMPublicacionesCancelar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtAMPublicacionesTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtAMPublicacionesTituloKeyTyped
        this.controlador.txtTituloPresionarTecla(evt);
    }//GEN-LAST:event_TxtAMPublicacionesTituloKeyTyped

    private void btnAMPublicacionesTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAMPublicacionesTodasActionPerformed
       this.controlador.btnTodasLasPalabrasClavesClic(evt);
    }//GEN-LAST:event_btnAMPublicacionesTodasActionPerformed

    private void btnAMPublicacionesNingunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAMPublicacionesNingunaActionPerformed
        this.controlador.btnNingunaPalabraClaveClic(evt);
    }//GEN-LAST:event_btnAMPublicacionesNingunaActionPerformed

    private void btnAMPublicacionesGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAMPublicacionesGuardarActionPerformed
        this.controlador.btnGuardarClic(evt);
    }//GEN-LAST:event_btnAMPublicacionesGuardarActionPerformed

    private void BtnAMPublicacionAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAMPublicacionAbrirActionPerformed
        this.controlador.btnAbrirClic(evt);
    }//GEN-LAST:event_BtnAMPublicacionAbrirActionPerformed

    private void btnAMPublicacionesCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAMPublicacionesCancelarActionPerformed
        this.controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_btnAMPublicacionesCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAMPublicacionAbrir;
    private javax.swing.JComboBox<String> ComboAMPublicacionesGrupo;
    private javax.swing.JComboBox<String> ComboAMPublicacionesIdioma;
    private javax.swing.JComboBox<String> ComboAMPublicacionesLugar;
    private javax.swing.JComboBox<String> ComboAMPublicacionesTipo;
    private javax.swing.JTable TablaAMPublicacionesPalabrasClaves;
    private javax.swing.JTextField TxtAMPublicacionesEnlace;
    private javax.swing.JTextArea TxtAMPublicacionesResumen;
    private javax.swing.JTextField TxtAMPublicacionesTitulo;
    private javax.swing.JButton btnAMPublicacionesCancelar;
    private javax.swing.JButton btnAMPublicacionesGuardar;
    private javax.swing.JButton btnAMPublicacionesNinguna;
    private javax.swing.JButton btnAMPublicacionesTodas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
