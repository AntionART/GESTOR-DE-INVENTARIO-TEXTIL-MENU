package Main;

import CONTROLADOR.Controlador_Frm_Registrar_Producto;
import MODELO.ListarProductos;
import VISTA.frm_RegistrarProducto;
import VISTA.MenuPrincipal;

public class Principal {
    private static frm_RegistrarProducto frm_rp;
    private static Controlador_Frm_Registrar_Producto c_frm_rp;
    private static ListarProductos lp;

    public static void main(String[] args) {
        mostrarFrmRegistrarProducto();
    }

    public static void mostrarFrmRegistrarProducto() {
        frm_rp = new frm_RegistrarProducto();
        frm_rp.setVisible(true);
        frm_rp.setLocationRelativeTo(null);

        c_frm_rp = new Controlador_Frm_Registrar_Producto(frm_rp);
        lp = new ListarProductos();
        lp.MostrarTable(frm_rp.TablaProductos);

        frm_rp.btn_actualizar.setEnabled(false);
        frm_rp.btn_cancelar.setEnabled(false);
    }
}
