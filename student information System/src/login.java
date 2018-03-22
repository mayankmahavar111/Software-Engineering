/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */ 
 
    public Connection cn;
    public Statement st;
    public login() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student information?zeroDateTimeBehavior=convertToNull","root","");
            st=cn.createStatement();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TF1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        PF1 = new javax.swing.JPasswordField();
        CB1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);
        jPanel1.add(TF1);
        TF1.setBounds(166, 59, 90, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Username");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 62, 80, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(12, 115, 80, 17);

        jButton1.setText(" Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(90, 220, 80, 30);
        jPanel1.add(PF1);
        PF1.setBounds(166, 112, 90, 30);

        CB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Teacher", "Student" }));
        CB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB1ActionPerformed(evt);
            }
        });
        jPanel1.add(CB1);
        CB1.setBounds(90, 160, 80, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Login");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(80, 11, 120, 40);

        jButton5.setText("exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(310, 280, 51, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon("G:\\6th sem\\Software-Engineering\\images\\index.jpg")); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-6, -6, 380, 320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void test(String tf1, String tf2, String type){
    System.out.println("username: "+tf1+"\npassword: "+tf2+"\nType: "+type);
try{
    String sql = "select * from user where username = '"+tf1+"' and password ='"+tf2+"' and type ='"+type+"';";
    System.out.print(sql);
    ResultSet res = st.executeQuery(sql);
    if (res.next()){
        //System.out.print(res.getString(1)+"\n"+res.getString(2));
        if (type.equalsIgnoreCase("admin")){
            AdminHome home = new AdminHome() ;
            home.setVisible(true);
        }
        else{
            if (type.equalsIgnoreCase("teacher")){
                TeacherHome home = new TeacherHome(res.getString("username"));
                home.setVisible(true);
            }
            else{
                StudentHome home = new StudentHome(res.getString("username"));
                home.setVisible(true);
            }  
        }
        
        this.dispose();
    }
    else{
        JOptionPane.showMessageDialog(null,"You entered wrong username or password or type");
    }
}
catch(Exception e){
    System.out.print(e);
}
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
String tf1 = TF1.getText();
String tf2 = String.valueOf(PF1.getPassword());
String type= CB1.getSelectedItem().toString();

test(tf1,tf2,type);
/*
System.out.println("username: "+tf1+"\npassword: "+tf2+"\nType: "+type);
try{
    String sql = "select * from user where username = '"+tf1+"' and password ='"+tf2+"' and type ='"+type+"';";
    System.out.print(sql);
    ResultSet res = st.executeQuery(sql);
    if (res.next()){
        //System.out.print(res.getString(1)+"\n"+res.getString(2));
        if (type.equalsIgnoreCase("admin")){
            AdminHome home = new AdminHome() ;
            home.setVisible(true);
        }
        else{
            if (type.equalsIgnoreCase("teacher")){
                TeacherHome home = new TeacherHome(res.getString("username"));
                home.setVisible(true);
            }
            else{
                StudentHome home = new StudentHome(res.getString("username"));
                home.setVisible(true);
            }  
        }
        
        this.dispose();
    }
    else{
        JOptionPane.showMessageDialog(null,"You entered wrong username or password");
    }
}
catch(Exception e){
    System.out.print(e);
}*/
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB1;
    private javax.swing.JPasswordField PF1;
    private javax.swing.JTextField TF1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
