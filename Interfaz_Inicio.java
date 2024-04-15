
package Interfaces;

import Reglas_Negocio.RN_Tipo_Alimento;
import Objetos_Negocio.Tipo_Alimento;
import Objetos_Negocio.Usuario;
import Reglas_Negocio.Conexion;
import Reglas_Negocio.RN_Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
/**
 *
 * @author nisit
 */
public class Interfaz_Inicio extends javax.swing.JFrame {

    RN_Tipo_Alimento RN_Tipo_Alimento = new RN_Tipo_Alimento();
    RN_Usuario RN_Usuario = new RN_Usuario();
    
    Conexion inst = new Conexion();
    Connection connect;
    DefaultTableModel modelo;
    Statement statement;
    ResultSet set;
    int idk;
    
    
    public Interfaz_Inicio() {
        initComponents();
        Consultar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        Nombre_Text = new javax.swing.JTextField();
        Nombre_Alimento_Text = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Id_Alimento_Text = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        Id_Usuario_Text = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Contraseña_Text = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Id_Alimento");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        Nombre_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_TextActionPerformed(evt);
            }
        });
        Nombre_Text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Nombre_TextKeyTyped(evt);
            }
        });
        getContentPane().add(Nombre_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 160, -1));
        getContentPane().add(Nombre_Alimento_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 160, -1));

        jButton1.setText("Consultar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 90, 40));
        getContentPane().add(Id_Alimento_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 160, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 160, -1));

        jLabel4.setText("Nombre_Alimento");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jButton3.setText("Crear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 70, 40));

        jButton4.setText("Editar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 70, 40));

        jButton5.setText("Borrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 80, 40));

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id_Alimento", "Nombre del alimento", "Activo", "Usuario que lo creó", "Fecha de creación", "Usuario_Modificó", "Fecha de modif.", "Usuario_Eliminó", "Fecha_Eliminó"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 740, 250));

        jLabel3.setText("Id_Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        Id_Usuario_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_Usuario_TextActionPerformed(evt);
            }
        });
        getContentPane().add(Id_Usuario_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 160, -1));

        jLabel5.setText("Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));

        Contraseña_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contraseña_TextActionPerformed(evt);
            }
        });
        getContentPane().add(Contraseña_Text, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 160, -1));

        jButton6.setText("Crear Usuario");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 170, 40));

        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nombre_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_TextActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Crear_Tipo_Alimento();
        //Crear();
        Consultar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void Id_Usuario_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_Usuario_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_Usuario_TextActionPerformed

    private void Contraseña_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contraseña_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Contraseña_TextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Consultar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //CrearUsuario();
        Crear_Usuario();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        // TODO add your handling code here:
        int fila = Tabla.getSelectedRow();
        if (fila == -1) {
            System.out.println("No se seleccionó una fila");
        } else {
            idk = Integer.parseInt(Tabla.getValueAt(fila, 0).toString());
            int Id_Usuario = Integer.parseInt(Tabla.getValueAt(fila, 3).toString());
            String Nombre_Alimento = (String)Tabla.getValueAt(fila, 1);
            
            this.Id_Usuario_Text.setText("" +Id_Usuario);
            this.Id_Alimento_Text.setText("" +idk);
            this.Nombre_Alimento_Text.setText(Nombre_Alimento);
        }
        
        
    }//GEN-LAST:event_TablaMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Modificar();
        Consultar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.out.println("Se presionó el boton eliminar");
        Eliminar();
        Consultar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Nombre_TextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Nombre_TextKeyTyped
        // TODO add your handling code here:
        if (Nombre_Text.getText().length() > 250) 

         evt.consume(); 
    }//GEN-LAST:event_Nombre_TextKeyTyped

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
            java.util.logging.Logger.getLogger(Interfaz_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz_Inicio().setVisible(true);
            }
        });
    }
    
    void Consultar () {
        System.out.println("Se inició el método consultar");
        try {
            if (this.modelo != null) {
                LimpiarTabla();
            }
            String query = "select * from cat_Tipo_Alimento";
            this.connect = this.inst.Conectar();
            statement = this.connect.createStatement();
            set = statement.executeQuery(query);
            Object[] cliente = new Object[9];
            modelo = (DefaultTableModel) Tabla.getModel();
            
            while (set.next()) {
                cliente[0] = set.getInt("Id_Tipo_Alimento");
                cliente[1] = set.getString("Tipo_Alimento");
                cliente[2] = set.getBoolean("Activo");
                cliente[3] = set.getInt("Id_Usuario_Alta");
                cliente[4] = set.getDate("Fecha_Alta");
                cliente[5] = set.getInt("Id_Usuario_Modif");
                cliente[6] = set.getDate("Fecha_Modif");
                cliente[7] = set.getInt("Id_Usuario_Baja");
                cliente[8] = set.getDate("Fecha_Baja");
                
                modelo.addRow(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    void Crear() {
        System.out.println("Se inició el método Crear");
        int Id_Tipo_Alimento = Integer.parseInt(this.Id_Alimento_Text.getText());
        String Tipo_Alimento = this.Nombre_Alimento_Text.getText();
        
        int Activo = 1;
        int Id_Usuario_Alta = Integer.parseInt(this.Id_Usuario_Text.getText());
        Date fechaActual = new Date();
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp Fecha_Alta = new java.sql.Timestamp(millis1);
        
        try {
            if (this.Id_Usuario_Text.getText() == "" || this.Id_Alimento_Text.getText().equals("") || this.Nombre_Alimento_Text.getText().equals("")) {
                System.out.println("Faltan ingresar datos");
            } else {
                String query = "insert into "
                        + "cat_Tipo_Alimento(Id_Tipo_Alimento, Tipo_Alimento, Activo, "
                        + "Id_Usuario_Alta, Fecha_Alta, Id_Usuario_Modif, Fecha_Modif, "
                        + "Id_Usuario_Baja, Fecha_Baja) "
                        + "values ('"+Id_Tipo_Alimento+"','"+Tipo_Alimento+"','"+Activo+"','"
                        + Id_Usuario_Alta + "','"+Fecha_Alta+"',NULL,NULL,NULL,NULL)";
                
                connect = this.inst.Conectar();
                statement = connect.createStatement();
                statement.executeUpdate(query);
                System.out.println("Nuevo cliente registrado");
                LimpiarTabla();
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void CrearUsuario() {
        System.out.println("Se inició el método Crear");
        //int Id_Usuario = Integer.parseInt(this.Id_Usuario_Text.getText());
        String Nombre_Usuario = this.Nombre_Text.getText();
        String Contraseña = this.Contraseña_Text.getText();
        
        try {
            if (this.Id_Usuario_Text.getText() == "") {
                System.out.println("Faltan ingresar datos");
            } else {
                String query = "insert into "
                        + "Usuario(Nombre_Usuario, Contrasenia) "
                        + "values ('"+Nombre_Usuario+"', '"+Contraseña+"')";
                
                connect = this.inst.Conectar();
                statement = connect.createStatement();
                statement.executeUpdate(query);
                System.out.println("Nuevo usuario registrado");
                //LimpiarTabla();
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Crear_Usuario() {
        System.out.println("Se inició el método Crear");
        //int Id_Usuario = Integer.parseInt(this.Id_Usuario_Text.getText());
        String Nombre_Usuario = this.Nombre_Text.getText();
        String Contraseña = this.Contraseña_Text.getText();
        Usuario usuario = new Usuario (Nombre_Usuario, Contraseña);
        
        RN_Usuario.Crear_Usuario(usuario);
        
    }
    
    void LimpiarTabla() {
        for (int i = 0; i < Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
        }
    }
    
    void Modificar () {
        
        System.out.println("Se inició el método Crear");
        int Id_Tipo_Alimento = Integer.parseInt(this.Id_Alimento_Text.getText());
        String Tipo_Alimento = this.Nombre_Alimento_Text.getText();
        
        int Activo = 1;
        int Id_Usuario_Modif = Integer.parseInt(this.Id_Usuario_Text.getText());
        Date fechaActual = new Date();
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp Fecha_Modif = new java.sql.Timestamp(millis1);
        
        try {
            if (this.Id_Usuario_Text.getText() == "" || this.Id_Alimento_Text.getText().equals("") || this.Nombre_Alimento_Text.getText().equals("")) {
                System.out.println("Faltan ingresar datos");
            } else {
                String query = "update cat_Tipo_Alimento set Id_Tipo_Alimento='"+idk+"', "
                        + "Tipo_Alimento='"+Tipo_Alimento+"', Id_Usuario_Modif='"+Id_Usuario_Modif+"',"
                        + "Fecha_Modif='"+Fecha_Modif+"' where Id_Tipo_Alimento="+idk;
                
                connect = this.inst.Conectar();
                statement = connect.createStatement();
                statement.executeUpdate(query);
                System.out.println("Datos modificados");
                LimpiarTabla();
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void Eliminar() {
        int fila = Tabla.getSelectedRow();
        if (fila < 0) {
                System.out.println("Cliente no seleccionado");
            } else {
            try {
                String query = "delete from cat_Tipo_Alimento where Id_Tipo_Alimento=" + idk;
                connect = this.inst.Conectar();
                statement = connect.createStatement();
                statement.executeUpdate(query);
                System.out.println("Datos eliminados");
                LimpiarTabla();
            } catch (SQLException ex) {
                Logger.getLogger(Interfaz_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
    }
    
    void Crear_Tipo_Alimento () {
        Tipo_Alimento tipo_alimento;
        //int Id_Tipo_Alimento = Integer.parseInt(this.Id_Alimento_Text.getText());
        String Tipo_Alimento = this.Nombre_Alimento_Text.getText();
        boolean Activo = true;
        //int Id_Usuario_Alta = Integer.parseInt(this.Id_Usuario_Text.getText());
        Date fechaActual = new Date();
        long millis1 =  new java.util.Date().getTime();
        java.sql.Timestamp Fecha_Alta = new java.sql.Timestamp(millis1);

        tipo_alimento = new Tipo_Alimento(Tipo_Alimento, Activo, Fecha_Alta);
        
        RN_Tipo_Alimento.Crear_Tipo_Alimento(tipo_alimento);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Contraseña_Text;
    private javax.swing.JTextField Id_Alimento_Text;
    private javax.swing.JTextField Id_Usuario_Text;
    private javax.swing.JTextField Nombre_Alimento_Text;
    private javax.swing.JTextField Nombre_Text;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}