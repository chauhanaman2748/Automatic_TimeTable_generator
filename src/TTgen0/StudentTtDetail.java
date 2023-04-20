/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTgen0;

import static TTgen0.Other.Days;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ragha
 */
public class StudentTtDetail extends javax.swing.JFrame {

    /**
     * Creates new form StudentTT
     */
    Connection myCon=null;
    Statement myStat=null;
    ResultSet myResult=null;
    String TableName1=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_classes").toUpperCase();
    String[] ClassIds=new String[0];

    public StudentTtDetail() {
        initComponents();
        StudentCourse.setText(Other.CourseName.getText());
        StudentBranch.setText(Other.Branch.getText());
        addClassID();
        
        
    }
    
    public void addClassID(){
        try{
        myCon=DriverManager.getConnection("jdbc:derby://localhost:1527/TTgen","rg","1234");
        myStat=myCon.createStatement();   
        
        
        myResult=myStat.executeQuery("Select CLASSID from "+TableName1);
        StudentClass.setModel(new DefaultComboBoxModel<>(new String[] {"Select"}));
        while(myResult.next())
        {
        StudentClass.addItem(myResult.getString("CLASSID"));
        }
        }
        catch(SQLException e){
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        Cross = new javax.swing.JLabel();
        StudentCourse = new javax.swing.JTextField();
        StudentBranch = new javax.swing.JTextField();
        StudentClass = new javax.swing.JComboBox<>();
        ViewTt = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cross.png"))); // NOI18N
        Cross.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cross.setOpaque(true);
        Cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrossMouseClicked(evt);
            }
        });
        jPanel1.add(Cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 35, 25, 28));

        StudentCourse.setEditable(false);
        StudentCourse.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentCourse.setForeground(new java.awt.Color(255, 255, 255));
        StudentCourse.setBorder(null);
        StudentCourse.setOpaque(false);
        jPanel1.add(StudentCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 125, 200, 20));

        StudentBranch.setEditable(false);
        StudentBranch.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StudentBranch.setForeground(new java.awt.Color(255, 255, 255));
        StudentBranch.setBorder(null);
        StudentBranch.setOpaque(false);
        jPanel1.add(StudentBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 200, 20));

        StudentClass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(StudentClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 273, 220, 20));

        ViewTt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ViewTt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViewTtMouseClicked(evt);
            }
        });
        jPanel1.add(ViewTt, new org.netbeans.lib.awtextra.AbsoluteConstraints(394, 350, 110, 30));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Student preview.png"))); // NOI18N
        jPanel1.add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CrossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrossMouseClicked
    this.dispose();
    new Dashboard().setVisible(true);// TODO add your handling code here:
    }//GEN-LAST:event_CrossMouseClicked

    private void ViewTtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViewTtMouseClicked
    if("Select".equals(StudentClass.getSelectedItem().toString())){
    JOptionPane.showMessageDialog(this, "ENTER COPLETE DATA","Error",JOptionPane.WARNING_MESSAGE);
    }
    else{
    this.dispose();
    new StudentT().setVisible(true);
    
    }// TODO add your handling code here:
    }//GEN-LAST:event_ViewTtMouseClicked
    
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
            java.util.logging.Logger.getLogger(StudentTtDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentTtDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentTtDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentTtDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentTtDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Cross;
    public static javax.swing.JTextField StudentBranch;
    public static javax.swing.JComboBox<String> StudentClass;
    public static javax.swing.JTextField StudentCourse;
    private javax.swing.JLabel ViewTt;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
