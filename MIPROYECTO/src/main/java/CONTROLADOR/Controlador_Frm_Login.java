package CONTROLADOR;

import MODELO.RegistroUsuario;
import MODELO.Usuario;
import VISTA.frm_Login;
import VISTA.frm_RegistrarUsuario;
import VISTA.MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador_Frm_Login {
    private frm_Login vista;
    private RegistroUsuario modelo;

    public Controlador_Frm_Login(frm_Login vista) {
        this.vista = vista;
        this.modelo = new RegistroUsuario();
        this.vista.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        this.vista.btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioRegistro();
            }
        });
    }

    private void login() {
        String correo = vista.txtCorreo.getText();
        String contrasena = new String(vista.txtContrasena.getPassword());
        
        // Realizar la autenticación utilizando el modelo
        Usuario usuario = modelo.login(correo, contrasena);
        
        if (usuario != null) {
            JOptionPane.showMessageDialog(vista, "¡Login exitoso!");
            
            // Abrir la ventana MenuPrincipal (o la ventana principal de tu aplicación)
            MenuPrincipal menuPrincipal = new MenuPrincipal(usuario); // Puedes pasar el usuario autenticado si es necesario
            menuPrincipal.setVisible(true);
            
            // Cerrar la ventana de login
            vista.dispose();
        } else {
            JOptionPane.showMessageDialog(vista, "Correo o contraseña incorrectos", "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirFormularioRegistro() {
        frm_RegistrarUsuario registroVista = new frm_RegistrarUsuario();
        registroVista.setVisible(true);
        vista.dispose();
    }
}
