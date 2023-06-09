/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TTgen0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DatabaseMetaData;
import javax.swing.DefaultComboBoxModel;
import net.proteanit.sql.DbUtils;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author 91870
 */
public class ClassSub extends javax.swing.JFrame {

    /**
     * Creates new form ClsSub
     */
    Connection myCon=null;
    Statement myStat=null;
    ResultSet myResult=null;
    String TableName=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_classes").toUpperCase();
    String TableName1,TableName2;
    
    public ClassSub() {
        initComponents();
        try{
        TableName1=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_subjects").toUpperCase();}
        catch(NullPointerException e){
        TableName1="btech_cse_1_subjects".toUpperCase();
        }
        try{
        TableName2=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_").toUpperCase();}
        catch(NullPointerException e){  
        }
        
        addSubId();
        ViewClassId();
    }
    
    public void addSubId(){
        try{
        myCon=DriverManager.getConnection("jdbc:derby://localhost:1527/TTgen","rg","1234");
        myStat=myCon.createStatement();   
        
        
        myResult=myStat.executeQuery("Select SUBJECTID from "+TableName1);
        SubId.setModel(new DefaultComboBoxModel<>(new String[] {"Select"}));
        while(myResult.next())
        {
        SubId.addItem(myResult.getString("SUBJECTID"));
        }
        
        
       
        
    }
        catch(SQLException e){
            e.printStackTrace();
                }
    
    }
    
   public void ViewData()
    {
        try{
        myCon=DriverManager.getConnection("jdbc:derby://localhost:1527/TTgen","rg","1234");
        myStat=myCon.createStatement();
        String CId=((String) ClassId.getSelectedItem()).toUpperCase();
        DatabaseMetaData dbm = myCon.getMetaData();
        ResultSet tables = dbm.getTables(null, null,TableName2+CId+"_SUBJECTS",null);
        
        if(tables.next())
        {
        myResult=myStat.executeQuery("Select * from "+TableName2+CId+"_SUBJECTS");
        SubTable.setModel(DbUtils.resultSetToTableModel(myResult));
        }
        else
        {
        DefaultTableModel dm = (DefaultTableModel) SubTable.getModel();
        dm.setRowCount(0);}
    }
        catch(Exception e){
            e.printStackTrace();
                }
       
    }
   
   public void ViewClassId()
   {    try{
        myCon=DriverManager.getConnection("jdbc:derby://localhost:1527/TTgen","rg","1234");
        myStat=myCon.createStatement();   
        myResult=myStat.executeQuery("Select ClassId from "+TableName);
        ClassId.setModel(new DefaultComboBoxModel<>(new String[] {"Select"}));
        while(myResult.next())
        {
        ClassId.addItem(myResult.getString("ClassId"));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        SubTable = new javax.swing.JTable();
        ClassId = new javax.swing.JComboBox<>();
        SubId = new javax.swing.JComboBox<>();
        Load = new javax.swing.JTextField();
        Back = new javax.swing.JLabel();
        Add = new javax.swing.JLabel();
        Edit = new javax.swing.JLabel();
        Delete = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cross.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrossMouseClicked(evt);
            }
        });
        jPanel1.add(Cross, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 10, 15, 15));

        SubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "SubID", "Load"
            }
        ));
        jScrollPane1.setViewportView(SubTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 400, 210));

        ClassId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ClassIdItemStateChanged(evt);
            }
        });
        ClassId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClassIdMouseClicked(evt);
            }
        });
        jPanel1.add(ClassId, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 440, 100, -1));

        jPanel1.add(SubId, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 130, 30));

        Load.setBorder(null);
        Load.setOpaque(false);
        jPanel1.add(Load, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 440, 90, 20));

        Back.setBackground(new java.awt.Color(255, 255, 204));
        Back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Back.setText("Back");
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.setOpaque(true);
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 60, 20));

        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
        });
        jPanel1.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 60, 20));

        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
        });
        jPanel1.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 60, 20));

        Delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });
        jPanel1.add(Delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, 60, 20));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ClsSub.jpg"))); // NOI18N
        BG.setToolTipText("");
        jPanel1.add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
     this.dispose();
        new ClassesDatabase().setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_BackMouseClicked

    private void CrossMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrossMouseClicked
     this.dispose();
        new Dashboard().setVisible(true);   // TODO add your handling code here:
    }//GEN-LAST:event_CrossMouseClicked

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        if("".equals(SubId.getSelectedItem().toString())||"".equals(Load.getText()) )
    {JOptionPane.showMessageDialog(this, "ENTER COPLETE DATA","Error",JOptionPane.WARNING_MESSAGE);
    }
        else{   
        try{
        String CId=ClassId.getSelectedItem().toString();    
        String q1="Create table "+TableName2+CId+"_SUBJECTS (SubId Varchar(100) ,Load Varchar(100))";
        String query="Insert into "+TableName2+CId+"_SUBJECTS values(?,?)";
            
        myCon=DriverManager.getConnection("jdbc:derby://localhost:1527/TTgen","rg","1234");
        DatabaseMetaData dbm = myCon.getMetaData();
        ResultSet tables = dbm.getTables(null, null,(TableName2+CId+"_SUBJECTS").toUpperCase(),null);
        
        if(tables.next())
        {
            String sid=SubId.getSelectedItem().toString();
            String load=Load.getText();
            PreparedStatement insert=(PreparedStatement) myCon.prepareStatement(query);
            insert.setString(1,sid);
            insert.setString(2, load);
            int row=insert.executeUpdate();
        }
        else{
            myStat=myCon.createStatement();
            myStat.executeUpdate(q1);
            String sid=SubId.getSelectedItem().toString();
            String load=Load.getText();
            PreparedStatement insert=(PreparedStatement) myCon.prepareStatement(query);
            insert.setString(1,sid);
            insert.setString(2, load);
            int row=insert.executeUpdate();
            
        }
    }
        catch(SQLException e){
            e.printStackTrace();
                }try{
                    
            String sid=SubId.getSelectedItem().toString();
            int ld=Integer.parseInt(Load.getText());
            String TableName5=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_SUBJECTS").toUpperCase();
            String query4="select LOAD from "+TableName5+" where SUBJECTID='"+sid+"'";
            myResult=myStat.executeQuery(query4);
            int LInitial=0;
            while (myResult.next()){
                LInitial=Integer.parseInt(myResult.getString("LOAD"));}
            
            String query5="update "+TableName5+" set LOAD="+(LInitial+ld)+" where SUBJECTID='"+sid+"'";
            Statement update=myCon.createStatement();
            update.executeUpdate(query5);
            SubId.setSelectedItem("Select");
            Load.setText("");
            
                }
        catch(SQLException e){
            e.printStackTrace();
                }            // TODO add your handling code here:
        ViewData();
        }
    }//GEN-LAST:event_AddMouseClicked

    private void ClassIdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassIdMouseClicked
           // TODO add your handling code here:
    }//GEN-LAST:event_ClassIdMouseClicked

    private void ClassIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ClassIdItemStateChanged
          ViewData();  // TODO add your handling code here:
    }//GEN-LAST:event_ClassIdItemStateChanged

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
    if("".equals(SubId.getSelectedItem().toString())||"".equals(Load.getText()) )
    {JOptionPane.showMessageDialog(this, "ENTER COPLETE DATA","Error",JOptionPane.WARNING_MESSAGE);
    }
    
    else{   
    
        try{
        String CId=ClassId.getSelectedItem().toString(); 
        String sid=SubId.getSelectedItem().toString();
        
        String TableName4=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_"+CId+"_SUBJECTS").toUpperCase();
            String query4="select LOAD from "+TableName4+" where SUBID='"+sid+"'";
            myResult=myStat.executeQuery(query4);
            int LInitial=0;
            while (myResult.next()){
                LInitial=Integer.parseInt(myResult.getString("LOAD"));}
        int LFinal=Integer.parseInt(Load.getText());
        
        String query="update "+TableName2+CId+"_SUBJECTS set SubId ='"+SubId.getSelectedItem().toString()+"' "+",load='"+Load.getText()+"' "+"where SubId ='"+SubId.getSelectedItem().toString()+"'";       
        Statement update=myCon.createStatement();
        update.executeUpdate(query);
        
        String TableName6=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_SUBJECTS").toUpperCase();
            String query6="select LOAD from "+TableName6+" where SUBJECTID='"+sid+"'";
            myResult=myStat.executeQuery(query6);
            int L=0;
            while (myResult.next()){
                L=Integer.parseInt(myResult.getString("LOAD"));}
        
        
        System.out.println(L+""+LInitial+""+LFinal);
        String query5="update "+TableName6+" set LOAD="+(L-LInitial+LFinal)+" where SUBJECTID='"+sid+"'";
            Statement update1=myCon.createStatement();
            update1.executeUpdate(query5);
            SubId.setSelectedItem("Select");
            Load.setText("");
       
    }                                   
   catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        
        
    ViewData();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_EditMouseClicked

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
    if("".equals(SubId.getSelectedItem().toString()))
    {JOptionPane.showMessageDialog(this, "ENTER Subject Id","Error",JOptionPane.WARNING_MESSAGE);
    }       
        else{   
        try{
        String CId=ClassId.getSelectedItem().toString(); 
        
        String TableName4=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_"+CId+"_SUBJECTS").toUpperCase();
        String sid=SubId.getSelectedItem().toString();

        String query4="select LOAD from "+TableName4+" where SUBID='"+sid+"'";
            myResult=myStat.executeQuery(query4);
            int LInitial=0;
            while (myResult.next()){
                LInitial=Integer.parseInt(myResult.getString("LOAD"));}
        
        
        String query="DELETE from "+TableName2+CId+"_SUBJECTS where SubId ='"+SubId.getSelectedItem().toString()+"'";
        Statement add=myCon.createStatement();
        add.executeUpdate(query);
        String TableName6=(Other.CourseName.getText()+"_"+Other.Branch.getText()+"_"+Other.Year.getText()+"_SUBJECTS").toUpperCase();
            String query6="select LOAD from "+TableName6+" where SUBJECTID='"+sid+"'";
            myResult=myStat.executeQuery(query6);
            int L=0;
            while (myResult.next()){
                L=Integer.parseInt(myResult.getString("LOAD"));}
        
        
        String query5="update "+TableName6+" set LOAD="+(L-LInitial)+" where SUBJECTID='"+sid+"'";
            Statement update1=myCon.createStatement();
            update1.executeUpdate(query5);
            SubId.setSelectedItem("Select");
            Load.setText("");
    }                                   
   catch(SQLException e)
        {
            e.printStackTrace();
        }
    ViewData();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteMouseClicked

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
            java.util.logging.Logger.getLogger(ClassSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClassSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClassSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClassSub.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClassSub().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add;
    private javax.swing.JLabel BG;
    private javax.swing.JLabel Back;
    private javax.swing.JComboBox<String> ClassId;
    private javax.swing.JLabel Cross;
    private javax.swing.JLabel Delete;
    private javax.swing.JLabel Edit;
    private javax.swing.JTextField Load;
    private javax.swing.JComboBox<String> SubId;
    private javax.swing.JTable SubTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
