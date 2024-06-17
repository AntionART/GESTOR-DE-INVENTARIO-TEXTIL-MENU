package VISTA;

import Conexion.ConexionMysql;
import MODELO.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuPerfil extends javax.swing.JFrame {

    private Connection conexion;
    
    public MenuPerfil(Usuario usuarioActual) {
        initComponents();
        conexion = ConexionMysql.getConexion();
        mostrarInformacionUsuario(usuarioActual.getCorreo());
    }

    MenuPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void mostrarInformacionUsuario(String correo) {
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String fechaRegistro = rs.getString("fecha_registro");
                String ultimoAcceso = rs.getString("ultimo_acceso");
                String rol = rs.getString("rol");
                String estadoCuenta = rs.getString("estado_cuenta");

                mostrarInformacion(id, nombre, apellido, correo, fechaRegistro, ultimoAcceso, rol, estadoCuenta, estadoCuenta);
            } else {
                System.out.println("Usuario no encontrado para el correo: " + correo);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar consulta: " + e);
        }
    }

    public void mostrarInformacion(int id, String nombre, String apellido, String correo, String fechaRegistro, String ultimoAcceso, String rol, String estadoCuenta, String estadoCuenta1) {
        lblId.setText("ID: " + id);
        lblNombre.setText("Nombre: " + nombre);
        lblApellido.setText("Apellido: " + apellido);
        lblCorreo.setText("Correo: " + correo);
        lblFechaRegistro.setText("Fecha de Registro: " + fechaRegistro);
        lblUltimoAcceso.setText("Último Acceso: " + ultimoAcceso);
        lblRol.setText("Rol: " + rol);
        lblEstadoCuenta.setText("Estado de Cuenta: " + estadoCuenta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblFechaRegistro = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblUltimoAcceso = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblEstadoCuenta = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Danii\\Documents\\NetBeansProjects\\MIPROYECTO\\src\\main\\java\\imagenes\\SASTRERIA FONDO A 640 PIXELES.jpg")); // NOI18N

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 153, 153));
        jTextField2.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("PERFIL USUARIO");
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField2.setFocusable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnSalir.setFont(new java.awt.Font("Monospac821 BT", 1, 12)); // NOI18N
        btnSalir.setText("Cerrar sesion");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        lblId.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblId.setText("lblId");

        lblNombre.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblNombre.setText("lblNombre");

        lblApellido.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblApellido.setText("lblApellido");

        lblFechaRegistro.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblFechaRegistro.setText("lblFechaRegistro");

        lblContrasena.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblContrasena.setText("lblContrasena");

        lblCorreo.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblCorreo.setText("lblCorreo");

        lblUltimoAcceso.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblUltimoAcceso.setText("lblUltimoAcceso");

        lblRol.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblRol.setText("lblRol");

        lblEstadoCuenta.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        lblEstadoCuenta.setText("lblEstadoCuenta");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEstadoCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUltimoAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblFechaRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(lblContrasena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(lblId)
                .addGap(18, 18, 18)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(lblApellido)
                .addGap(18, 18, 18)
                .addComponent(lblCorreo)
                .addGap(18, 18, 18)
                .addComponent(lblContrasena)
                .addGap(18, 18, 18)
                .addComponent(lblFechaRegistro)
                .addGap(18, 18, 18)
                .addComponent(lblUltimoAcceso)
                .addGap(18, 18, 18)
                .addComponent(lblRol)
                .addGap(18, 18, 18)
                .addComponent(lblEstadoCuenta)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Danii\\Documents\\NetBeansProjects\\MIPROYECTO\\src\\main\\java\\imagenes\\SASTRERIA FONDO A 640 PIXELES.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0); // Ejemplo básico de salir de la aplicación
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            Usuario usuarioActual = new Usuario(); // Debes asignar los datos del usuario actual aquí
            new MenuPerfil(usuarioActual).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private static javax.swing.JTextField jTextField2;
    public javax.swing.JLabel lblApellido;
    public javax.swing.JLabel lblContrasena;
    public javax.swing.JLabel lblCorreo;
    public javax.swing.JLabel lblEstadoCuenta;
    public javax.swing.JLabel lblFechaRegistro;
    public javax.swing.JLabel lblId;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblRol;
    public javax.swing.JLabel lblUltimoAcceso;
    // End of variables declaration//GEN-END:variables
}
