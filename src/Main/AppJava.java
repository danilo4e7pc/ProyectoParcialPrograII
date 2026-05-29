package Main;

import controlador.EmpresaControlador;
import vista.VentanaEmpresa;

public class AppJava {
	public static void main(String[] args) {
        // Instanciamos la Vista (Frontend)
        VentanaEmpresa vista = new VentanaEmpresa();
        
        // Instanciamos el Controlador y le pasamos la vista
        EmpresaControlador controlador = new EmpresaControlador(vista);
        
        // Hacer visible la interfaz Swing
        vista.setVisible(true);
    }
}
