package VISTA;

import Conexion.ConexionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuAdministrador extends javax.swing.JFrame {

    public MenuAdministrador() {
        initComponents();
        
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);
        cargarDatos();

        // Agregar listener para actualizar rol directamente desde la tabla
        TablaUsuarios.getModel().addTableModelListener(e -> {
            if (e.getType() == javax.swing.event.TableModelEvent.UPDATE) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                if (column == 6) { // Asumiendo que la columna de rol es la séptima columna (índice 6)
                    int id = (int) TablaUsuarios.getValueAt(row, 0);
                    String nuevoRol = (String) TablaUsuarios.getValueAt(row, 6);
                    actualizarRolUsuario(id, nuevoRol);
                }
            }
        });
    }
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        Cerrar = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        TITULO = new javax.swing.JTextField();
        SUBTITULO = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "correo", "contraseña", "Fecha De Registro", "Rol", "Estado"
            }
        ));
        jScrollPane1.setViewportView(TablaUsuarios);

        Cerrar.setText("Cerrar");
        Cerrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TITULO.setEditable(false);
        TITULO.setBackground(new java.awt.Color(0, 153, 153));
        TITULO.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        TITULO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TITULO.setText("Sastrería Wialkaeli");
        TITULO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TITULO.setFocusable(false);
        TITULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TITULOActionPerformed(evt);
            }
        });

        SUBTITULO.setEditable(false);
        SUBTITULO.setBackground(new java.awt.Color(0, 153, 153));
        SUBTITULO.setFont(new java.awt.Font("Monospac821 BT", 1, 14)); // NOI18N
        SUBTITULO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SUBTITULO.setText("USUARIOS");
        SUBTITULO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SUBTITULO.setFocusable(false);
        SUBTITULO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBTITULOActionPerformed(evt);
            }
        });

        jLayeredPane1.setLayer(TITULO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(SUBTITULO, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(SUBTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TITULO, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SUBTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarRolActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = TablaUsuarios.getSelectedRow();
        if (selectedRow != -1) {
            int id = (int) TablaUsuarios.getValueAt(selectedRow, 0);
            String nuevoRol = JOptionPane.showInputDialog(this, "Ingrese el nuevo rol para el usuario con ID " + id + ":");
            if (nuevoRol != null && !nuevoRol.trim().isEmpty()) {
                actualizarRolUsuario(id, nuevoRol);
            } else {
                JOptionPane.showMessageDialog(this, "El rol no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione un usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void TITULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TITULOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TITULOActionPerformed

    private void SUBTITULOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBTITULOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUBTITULOActionPerformed

    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed

        this.dispose(); // Cerrar el formulario actual (opcional, dependiendo de tu flujo de la aplicación
    }//GEN-LAST:event_CerrarActionPerformed

    /**
     * @param args the command line arguments
     */
private void cargarDatos() {
    DefaultTableModel model = (DefaultTableModel) TablaUsuarios.getModel();
    model.setRowCount(0);

    try (Connection conn = ConexionMysql.getConexion();
         PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios")) {

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("correo"),
                rs.getString("contrasena"),
                rs.getDate("fecha_registro"),
                rs.getString("rol"),
                rs.getString("estado_cuenta") // Aquí se usa 'estado_cuenta' en lugar de 'estado'
            });
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al cargar los datos de los usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void actualizarRolUsuario(int id, String nuevoRol) {
        try (Connection conn = ConexionMysql.getConexion();
             PreparedStatement ps = conn.prepareStatement("UPDATE usuarios SET rol = ? WHERE id = ?")) {

            ps.setString(1, nuevoRol);
            ps.setInt(2, id);
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Rol actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarDatos();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el rol del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar el rol del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cerrar;
    private static javax.swing.JTextField SUBTITULO;
    private static javax.swing.JTextField TITULO;
    public javax.swing.JTable TablaUsuarios;
    private javax.swing.JLayeredPane jLayeredPane1;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
