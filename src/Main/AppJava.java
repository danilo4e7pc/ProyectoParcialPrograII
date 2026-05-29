package Main;

import controlador.EmpresaControlador;
import vista.VentanaEmpresa;

public class AppJava {
	public static void main(String[] args) {
        // Instanciamos la Vista
        VentanaEmpresa vista = new VentanaEmpresa();
        EmpresaControlador controlador = new EmpresaControlador(vista);
        
        // Hacer visible la interfaz
        vista.setVisible(true);
    }
}
