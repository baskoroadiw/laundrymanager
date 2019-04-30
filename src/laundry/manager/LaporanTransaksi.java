/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry.manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Baskoro Adi
 */
public class LaporanTransaksi extends javax.swing.JFrame {

    /**
     * Creates new form LaporanTransaksi
     */
    DefaultTableModel model;
    Connection conn = Koneksi.getConnection();
    public LaporanTransaksi() {
        initComponents();
        this.setTitle("Laporan Transaksi");
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        TableData.setModel(model);
        model.addColumn("ID Pelanggan");
        model.addColumn("ID Cucian");
        model.addColumn("Nama");
        model.addColumn("No HP");
        model.addColumn("Alamat");
        model.addColumn("JK");
        model.addColumn("Berat (kg)");
        model.addColumn("Tanggal Masuk");
        model.addColumn("Harga");
        model.addColumn("Status Bayar");
        model.addColumn("Status Transaksi");
        model.addColumn("Tanggal Keluar");
        jDateChooser.setDateFormatString("dd/MM/yyyy");
        tampil();
    }

    private void sortDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        jDateChooser.setDateFormatString("dd/MM/yyyy");
        String date = sdf.format(jDateChooser.getDate());
        String sql = "SELECT * FROM cucian JOIN pelanggan WHERE cucian.id_pelanggan = pelanggan.id_pelanggan AND tanggal_masuk LIKE'"+date+"%'";
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()){
            Object[] o = new Object[14];
                o[0] = result.getString("id_pelanggan");
                o[1] = result.getString("id_cucian");
                o[2] = result.getString("nama_pelanggan");
                o[3] = result.getString("nomer_hp");
                o[4] = result.getString("alamat_pelanggan");
                o[5] = result.getString("jenis_kelamin");
                o[6] = result.getInt("berat");
                o[7] = result.getString("tanggal_masuk");
                o[8] = result.getInt("harga");
                o[9] = result.getString("statuspembayaran");
                o[10] = result.getString("statustransaksi");
                o[11] = result.getString("tanggal_keluar");
                        
                model.addRow(o);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    private void search(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM cucian JOIN pelanggan WHERE cucian.id_pelanggan = pelanggan.id_pelanggan AND nama_pelanggan LIKE'"+txtSearch.getText()+"%'";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
            while(result.next()){
            Object[] o = new Object[14];
                o[0] = result.getString("id_pelanggan");
                o[1] = result.getString("id_cucian");
                o[2] = result.getString("nama_pelanggan");
                o[3] = result.getString("nomer_hp");
                o[4] = result.getString("alamat_pelanggan");
                o[5] = result.getString("jenis_kelamin");
                o[6] = result.getInt("berat");
                o[7] = result.getString("tanggal_masuk");
                o[8] = result.getInt("harga");
                o[9] = result.getString("statuspembayaran");
                o[10] = result.getString("statustransaksi");
                o[11] = result.getString("tanggal_keluar");
                        
                model.addRow(o);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }
    private void tampil(){
            try{
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                String query = "SELECT * FROM cucian JOIN pelanggan WHERE cucian.id_pelanggan = pelanggan.id_pelanggan";
                Statement statement = (Statement) conn.createStatement();
                ResultSet result = statement.executeQuery(query);
                if (!result.next()) {
                    JOptionPane.showMessageDialog(this,"Data Kosong!","Notification",JOptionPane.WARNING_MESSAGE);
                }else{
                    while(result.next()){
                        Object[] o = new Object[14];
                        o[0] = result.getString("id_pelanggan");
                        o[1] = result.getString("id_cucian");
                        o[2] = result.getString("nama_pelanggan");
                        o[3] = result.getString("nomer_hp");
                        o[4] = result.getString("alamat_pelanggan");
                        o[5] = result.getString("jenis_kelamin");
                        o[6] = result.getInt("berat");
                        o[7] = result.getString("tanggal_masuk");
                        o[8] = result.getInt("harga");
                        o[9] = result.getString("statuspembayaran");
                        o[10] = result.getString("statustransaksi");
                        o[11] = result.getString("tanggal_keluar");
                        
                        model.addRow(o);
                    }
                }
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, ex);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        btnSbd = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 36)); // NOI18N
        jLabel1.setText("Laporan Transaksi");

        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TableData);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel2.setText("Search");

        btnSbd.setText("SBD");
        btnSbd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSbdActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnBack.setText("Back to Homepage");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSbd))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(239, 239, 239))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSbd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.getText().isEmpty()) {
            tampil();
        }else{
            search();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnSbdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSbdActionPerformed
        // TODO add your handling code here:
        if (jDateChooser.getDate().equals("")) {
            tampil();
        }else{
            sortDate();
        }
    }//GEN-LAST:event_btnSbdActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MessageFormat header = new MessageFormat("Data Transaksi");
                MessageFormat footer = new MessageFormat("Page{0,number,integer}");
                try {
                    TableData.print(JTable.PrintMode.FIT_WIDTH, header, footer);
                } catch (PrinterException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableData;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSbd;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
