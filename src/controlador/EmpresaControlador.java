package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Rubro;
import vista.VentanaEmpresa;

public class EmpresaControlador implements ActionListener{
private VentanaEmpresa vista;
    
    // Nuestro "Arreglo de tipo clase" para simular la persistencia de datos en memoria
    private Cliente[] clientesDB;
    private int contadorClientes;

    public EmpresaControlador(VentanaEmpresa vista) {
        this.vista = vista;
        this.clientesDB = new Cliente[100]; // Soporta hasta 100 empresas registradas
        this.contadorClientes = 0;
        
        // Enlazar eventos de la vista
        this.vista.conectarControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistrar) {
            registrarEmpresa();
        }
    }

    private void registrarEmpresa() {
        // 1. Extraer los datos ingresados en el Frontend (Swing)
        String ruc = vista.txtRuc.getText();
        String razonSocial = vista.txtRazonSocial.getText();
        String email = vista.txtEmail.getText();
        String contacto = vista.txtContacto.getText();
        String telefono = vista.txtTelefono.getText();
        String rubroSeleccionado = (String) vista.cbRubro.getSelectedItem();

        // Validar que los campos no estén vacíos
        if (ruc.isEmpty() || razonSocial.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor complete los campos obligatorios (RUC, Razón Social y Email).");
            return;
        }

        // 2. Generar clave automática (Requerimiento del caso de estudio)
        String claveAutogenerada = "EMP" + (new Random().nextInt(9000) + 1000);

        // 3. Crear instancias de nuestro Modelo
        Rubro rubroObjeto = new Rubro(rubroSeleccionado, true);
        Cliente nuevoCliente = new Cliente(ruc, razonSocial, email, contacto, telefono, claveAutogenerada, rubroObjeto);

        // 4. Almacenar en nuestro arreglo simulado
        if (contadorClientes < clientesDB.length) {
            clientesDB[contadorClientes++] = nuevoCliente;
            
            // 5. Actualizar el Frontend con la respuesta
            actualizarListaVista();
            limpiarCampos();
            
            JOptionPane.showMessageDialog(vista, "Empresa registrada con éxito.\nContraseña de acceso: " + claveAutogenerada);
        } else {
            JOptionPane.showMessageDialog(vista, "Base de datos llena.");
        }
    }

    private void actualizarListaVista() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < contadorClientes; i++) {
            Cliente c = clientesDB[i];
            sb.append("RUC: ").append(c.getRUC())
              .append(" | Empresa: ").append(c.getRazonSocial())
              .append(" | Clave de acceso: ").append(c.getClave())
              .append("\n");
        }
        vista.txtResultado.setText(sb.toString());
    }

    private void limpiarCampos() {
        vista.txtRuc.setText("");
        vista.txtRazonSocial.setText("");
        vista.txtEmail.setText("");
        vista.txtContacto.setText("");
        vista.txtTelefono.setText("");
    }
}
