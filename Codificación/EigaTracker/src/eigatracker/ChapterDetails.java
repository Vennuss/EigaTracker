package eigatracker;

import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vennuss
 */
public class ChapterDetails extends javax.swing.JFrame {
    
    private BD bd = new BD();
    private int ID;
    private int sRow = -1;
    
    /**
     * Creates new form MovieDetails
     * @param _chapter
     */
    public ChapterDetails(final int _chapter) {
        initComponents();
        ID = _chapter;
        String nombre = "CHAPTER " + consultarInt("select capitulo from capitulos where id = " + ID + ";", "capitulo") 
                + ", SEASSON " + consultarInt("select temporada from capitulos where id = " + ID + ";", "temporada")
                + " FROM " + consultarString("select serie from capitulos where id = " + ID + ";", "serie");
        Name.setText(nombre);
        start();
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
        jLabel2 = new javax.swing.JLabel();
        Known = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Notes = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        Add = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        AvgC = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        AvgF = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MostC = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        MostF = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Last = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Movie Details");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Known");

        Known.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Known.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Known.setMaximumSize(new java.awt.Dimension(25, 25));
        Known.setMinimumSize(new java.awt.Dimension(25, 25));
        Known.setPreferredSize(new java.awt.Dimension(25, 25));
        Known.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KnownActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Notes");

        Notes.setColumns(20);
        Notes.setRows(5);
        Notes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Notes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NotesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(Notes);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Records");

        Table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Comprehesion", "Fun", "Date Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Table.setRowHeight(40);
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table);

        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Avg Comprehension");

        AvgC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AvgC.setText("00%");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Avg Fun");

        AvgF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AvgF.setText("00%");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Most Comprehension");

        MostC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MostC.setText("00%");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Most Fun");

        MostF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MostF.setText("00%");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Last View");

        Last.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Last.setText("000/00/00");

        Name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name.setText("Error");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Known, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(AvgF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(MostF))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(AvgC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 263, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(Last)
                        .addGap(250, 250, 250)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(MostC)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Known, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(Name)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(Last))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(MostC))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(AvgC)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(AvgF)
                    .addComponent(jLabel11)
                    .addComponent(MostF))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KnownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KnownActionPerformed
        bd.sentencia("update capitulos set conocida = " + Known.isSelected() + " where id = " + ID + ";");
    }//GEN-LAST:event_KnownActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        ChapterRecord cr = new ChapterRecord(ID);
        cr.setVisible(true);
    }//GEN-LAST:event_AddActionPerformed

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
        if(Table.getSelectedRow() != -1){
            String id = String.valueOf(Table.getValueAt(Table.getSelectedRow(), 0));
            int conf = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete the record '" + id + "'?", "Delete", JOptionPane.OK_CANCEL_OPTION);
            if(conf == 0){
                bd.sentencia("delete from registros_capitulos where id = " + id + ";");
                start();
            }
        }else JOptionPane.showMessageDialog(rootPane, "Select a row to delete.");
    }//GEN-LAST:event_DeleteActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void NotesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NotesKeyTyped
        bd.sentencia("update capitulos set notas = '" + Notes.getText() + "' where id = '" + ID + "';");
    }//GEN-LAST:event_NotesKeyTyped

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        if(sRow == Table.getSelectedRow()){
            ChapterRecord cr = new ChapterRecord(ID, Integer.valueOf(String.valueOf(Table.getValueAt(Table.getSelectedRow(), 0))));
            cr.setVisible(true);
            sRow = -1;
        }else sRow = Table.getSelectedRow();
    }//GEN-LAST:event_TableMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        start();
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChapterDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChapterDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChapterDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChapterDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChapterDetails(2).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JLabel AvgC;
    private javax.swing.JLabel AvgF;
    private javax.swing.JButton Delete;
    private javax.swing.JCheckBox Known;
    private javax.swing.JLabel Last;
    private javax.swing.JLabel MostC;
    private javax.swing.JLabel MostF;
    private javax.swing.JLabel Name;
    private javax.swing.JTextArea Notes;
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    final void setImagenes(){
        cargarIMG("..\\Images\\add.png", Add, 30);
        cargarIMG("..\\Images\\delete.png", Delete, 30);
    }
    
    
    private void cargarIMG(final String _url, final JButton _boton, final int _size) {
        ImageIcon icon = new ImageIcon(getClass().getResource(_url));
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(_size, _size, Image.SCALE_DEFAULT));
        _boton.setIcon(icono);
    }
    
    private void start() {
        setImagenes();
        Notes.setText(consultarString("select notas from capitulos where id = " + ID + ";", "notas"));
        refreshTable();
        AvgC.setText(Double.toString(consultarDouble("select avg(comprension) as 'comp' from registros_capitulos where capitulo_ref = " + ID + ";", "comp")) + "%");
        AvgF.setText(Double.toString(consultarDouble("select avg(diversion) as 'fun' from registros_capitulos where capitulo_ref = " + ID + ";", "fun")) + "%");
        MostC.setText(Double.toString(consultarDouble("select max(comprension) as 'comp' from registros_capitulos where capitulo_ref = " + ID + ";", "comp")) + "%");
        MostF.setText(Double.toString(consultarDouble("select max(diversion) as 'fun' from registros_capitulos where capitulo_ref = " + ID + ";", "fun")) + "%");
        Last.setText(consultarString("select fecha from registros_capitulos where capitulo_ref = " + ID + " order by fecha desc limit 1 ;", "fecha"));
        Known.setSelected(consultarBool("select conocida from capitulos where id = " + ID + ";", "conocida"));
    }
    
    private void refreshTable(){
        try {
            DefaultTableModel tm = (DefaultTableModel) Table.getModel();
            Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            tm.setRowCount(0);
            
            String sql = "select * from registros_capitulos where capitulo_ref = " + ID + ";";
            ResultSet rs = bd.consulta(sql);
            while(rs.next()){
                int id = rs.getInt("id");
                int comp = rs.getInt("comprension");
                int fun = rs.getInt("diversion");
                String time = rs.getString("fecha");
                Object nuev[] = {id, comp, fun, time};
                tm.addRow(nuev);
            }
            bd.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(ChapterDetails.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }
    
    private double consultarDouble(final String _sql, final String _valor){
        ResultSet rs = bd.consulta(_sql);
        try {
            double r = 0.0;
            while(rs.next()){
                r = rs.getDouble(_valor);
                break;
            }
            bd.cerrarConexion();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return 0.0;
        }
    }
    
    private String consultarString(final String _sql, final String _valor){
        ResultSet rs = bd.consulta(_sql);
        try {
            String r = "";
            while(rs.next()){
                r = rs.getString(_valor);
                break;
            }
            bd.cerrarConexion();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return "Error";
        }
    }
    
    private int consultarInt(final String _sql, final String _valor){
        ResultSet rs = bd.consulta(_sql);
        try {
            int r = 0;
            while(rs.next()){
                r = rs.getInt(_valor);
                break;
            }
            bd.cerrarConexion();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    private boolean consultarBool(final String _sql, final String _valor){
        ResultSet rs = bd.consulta(_sql);
        try {
            boolean r = false;
            while(rs.next()){
                r = rs.getBoolean(_valor);
                break;
            }
            bd.cerrarConexion();
            return r;
        } catch (SQLException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
