
package Forms;

import geniusapp.Constants;
import geniusapp.Decryption;
import geniusapp.Encryption;
import geniusapp.Security;
import geniusapp.SqlConnection;
import geniusapp.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eng.Joseph Gitahi
 */
public class Users extends javax.swing.JDialog {

    /**
     * Creates new form Users
     */
    Constants _Constants=new Constants();
    static SqlConnection _SqlConnection =new SqlConnection();
     Connection con=_SqlConnection.connect();
      DefaultTableModel model = new DefaultTableModel(new String[]{ "UserName", "FullNames","IsActive","Email","Telephone"}, 0);
    public Users() {
        initComponents();
        LoadUsers();
         setLocationRelativeTo(null);
          setModal(true);
          UsersTable.setModel(model);
    }

   
    public void LoadUsers(){
        try {
            model.setRowCount(0);
           Statement pst=con.createStatement();
            ResultSet rs= pst.executeQuery("{call spSelectUsers}");
           
            while(rs.next()){
                String U=rs.getNString("UserName");
                String N=rs.getNString("FullNames");
                String Em=rs.getNString("Email");
                String T=rs.getNString("Telephone");
                  Boolean E= rs.getBoolean("IsActive") ;
                
                model.addRow(new Object[]{U, N,E,Em,T});
                              
            }
         
            rs.close();
            pst.close();
            
           // UsersTable.setModel(DbUtils.resultSetToTableModel(rs));
      
        } catch (Exception e) {
              Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Selecting users");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
             
        }
    }
    public void SearchUsers(String Id){
    try {

                 PreparedStatement pstmt = con.prepareStatement("{call SearchUser(?)}");
                  pstmt.setString(1, Id);
                  ResultSet rs=pstmt.executeQuery();
                   model.setRowCount(0);
                while(rs.next()){
                    
                txtUserName.setText(rs.getNString("UserName"));
                txtFullNames.setText(rs.getNString("FullNames"));
               Decryption de =new Decryption();
                               String decrypted= de.decrypt(rs.getNString("Password"));
               txtPassword1.setText(decrypted);
              txtConfirmPassword.setText(decrypted);
                txtQuestion.setText(rs.getNString("Question"));
                
                txtAnswer.setText(rs.getNString("Answer"));
                txtEmail1.setText(rs.getNString("Email"));
                txtTelephone.setText(rs.getNString("Telephone"));
                chkIsActive.setSelected(rs.getBoolean("IsActive"));
                   model.addRow(new Object[]{rs.getNString("UserName"), rs.getNString("FullNames"),rs.getBoolean("IsActive"),rs.getNString("Email"),rs.getNString("Telephone")});           
            }
                rs.close();
                pstmt.close();
    } catch (Exception e) {
         Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Searching user");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
    }
}

public void clearFields(){
                txtUserName.setText(" ");
                txtFullNames.setText(" ");
                
                txtPassword1.setText("");
                txtConfirmPassword.setText("");
                txtQuestion.setText(" ");
                
                txtAnswer.setText(" ");
                txtEmail1.setText(" ");
                txtTelephone.setText(" ");
               
}
public void getRowValue(){
    try {
        int column = 0;
        int row = UsersTable.getSelectedRow();
        String value = UsersTable.getModel().getValueAt(row, column).toString();
       // JOptionPane.showMessageDialog(null,value);
        fillFiields(value);
    } catch (Exception e) {
        System.out.println( e.getMessage() );
    }
}
public void fillFiields(String Id){
    try {

                 PreparedStatement pstmt = con.prepareStatement("{call SelectNewUser(?)}");
                  pstmt.setString(1, Id);
                  ResultSet rs=pstmt.executeQuery();
                while(rs.next()){
                    
                txtUserName.setText(rs.getNString("UserName"));
                txtFullNames.setText(rs.getNString("FullNames"));
             Decryption de =new Decryption();
                               String decrypted= de.decrypt(rs.getNString("Password"));
                txtPassword1.setText(decrypted);
                txtConfirmPassword.setText(decrypted);
                txtQuestion.setText(rs.getNString("Question"));
                
                txtAnswer.setText(rs.getNString("Answer"));
                txtEmail1.setText(rs.getNString("Email"));
                txtTelephone.setText(rs.getNString("Telephone"));
                chkIsActive.setSelected(rs.getBoolean("IsActive"));
                
                 txtUserName.setEnabled(false);
                txtFullNames.setEnabled(false);
                txtPassword1.setEnabled(false);
                txtConfirmPassword.setEnabled(false);
                txtQuestion.setEnabled(false);
                
                txtAnswer.setEnabled(false);
                txtEmail1.setEnabled(false);
                txtTelephone.setEnabled(false);
                            
            }
                rs.close();
                pstmt.close();
    } catch (Exception e) {
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        txtFullNames = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chkIsActive = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        txtEmail1 = new javax.swing.JTextField();
        txtAnswer = new javax.swing.JTextField();
        txtQuestion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsersTable = new javax.swing.JTable();
        txtPassword1 = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jButtonEdit = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSearchu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DEFINE NEW SYSTEM USERS");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD NEW SYSTEM USER", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel1.setText("UserName");

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Full Names");

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setText("IsActive");

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("ConfirmPassword");

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Security Question");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Answer");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Email");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel9.setText("Telephone");

        UsersTable.setFont(new java.awt.Font("Californian FB", 0, 12)); // NOI18N
        UsersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        UsersTable.setGridColor(new java.awt.Color(255, 255, 255));
        UsersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UsersTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(chkIsActive, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtFullNames, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword1)
                    .addComponent(txtConfirmPassword))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAnswer, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtQuestion, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFullNames, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkIsActive)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Trash_Can_35px.png"))); // NOI18N
        jButtonEdit.setText("Delete");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Compose_35px.png"))); // NOI18N
        btnPrint.setText("Edit");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Data_Recovery_35px.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSearchu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Forms/Images/icons8_Search_35px.png"))); // NOI18N
        btnSearchu.setText("Search");
        btnSearchu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSearchu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearchu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonEdit)
                            .addComponent(btnPrint)
                            .addComponent(jButton2))
                        .addGap(6, 6, 6)))
                .addGap(708, 708, 708))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       try {
            String UserName,Password,Email,FullNames,IdNo,EmpNo,Question,Answer,Telephone;
            Boolean IsActive;
            
            UserName=txtUserName.getText();
            Password=txtPassword1.getText();
            // JOptionPane.showMessageDialog(null,Password);
            String ConfirmPassword=txtConfirmPassword.getText();
            // JOptionPane.showMessageDialog(null,ConfirmPassword);
            if(UserName.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Username To Continue");
                return;
            }
            //CryptWithMD5 _CryptWithMD5 = new CryptWithMD5();

            if(Password.isEmpty() || ConfirmPassword.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Password To Continue");
                return;
            }
            if(ConfirmPassword.equals( Password)){
            Encryption en=new Encryption();
            Password=en.encrypt(txtPassword1.getText());
            }
            else{
                JOptionPane.showMessageDialog(null," Password Does Not Match");
                return;
            }

            Email=txtEmail1.getText();
            if(Email.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Email To Continue");
                return;
            }
            FullNames=txtFullNames.getText();
            if(FullNames.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter FullNames  To Continue");
                return;
            }
           
            Question=txtQuestion.getText();
            if(Question.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Question  To Continue");
                return;
            }
            Answer=txtAnswer.getText();
            if(Answer.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Securty Question  To Continue");
                return;
            }
            Telephone=txtTelephone.getText();
            if(Telephone.isEmpty()){
                JOptionPane.showMessageDialog(null,"Enter Telephone  To Continue");
                return;
            }
            IsActive=chkIsActive.isSelected();
       

            //  JOptionPane.showMessageDialog(null,DOB);
            User _User =  new User( UserName,  Password,  Email,  FullNames,  Question,  Answer,  Telephone,  IsActive) ;
            if(_User.SaveUser()){
                JOptionPane.showMessageDialog(null,"User Saved ");
                clearFields();
            }
        }catch (Exception e) {
            e.printStackTrace();
            Security sec=new Security();
            sec.setMessage(e.getMessage());
            sec.setModule("Saving Users");
            sec.setRegSource(_Constants.getRegSource());
            sec.setUserID(_Constants.getUserId());
            sec.SaveErrors();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void UsersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersTableMouseClicked
        // TODO add your handling code he
        getRowValue();
    }//GEN-LAST:event_UsersTableMouseClicked

    private void btnSearchuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchuActionPerformed
        SearchUsers(txtSearch.getText());
    }//GEN-LAST:event_btnSearchuActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        String Username=txtUserName.getText();   
        User _User=new User();
       if( _User.DeleteUser(Username)){
           JOptionPane.showMessageDialog(null,"User Deleted Succefully");
       }else{
           JOptionPane.showMessageDialog(null,"User could not be deleted ");
       }
         
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
                txtUserName.setEnabled(true);
                txtFullNames.setEnabled(true);
                txtPassword1.setEnabled(true);
                txtConfirmPassword.setEnabled(true);
                txtQuestion.setEnabled(true);
                
                txtAnswer.setEnabled(true);
                txtEmail1.setEnabled(true);
                txtTelephone.setEnabled(true);
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Users.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable UsersTable;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearchu;
    private javax.swing.JCheckBox chkIsActive;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtAnswer;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtFullNames;
    private javax.swing.JTextField txtPassword1;
    private javax.swing.JTextField txtQuestion;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
