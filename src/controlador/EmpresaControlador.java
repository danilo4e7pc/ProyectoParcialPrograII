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
    
    
    private Cliente[] clientesDB;
    private int contadorClientes;

    public EmpresaControlador(VentanaEmpresa vista) {
        this.vista = vista;
        this.clientesDB = new Cliente[100]; // Soporta hasta 100 empresas registradas
        this.contadorClientes = 0;
        
        this.vista.conectarControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnRegistrar) {
            registrarEmpresa();
        }
    }

    private void registrarEmpresa() {
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
        
        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(vista, "ERROR: El correo electrónico ingresado no tiene un formato válido (ejemplo@empresa.com).", "Error de Email", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        for (int i = 0; i < contadorClientes; i++) {
            if (clientesDB[i].getRUC().equals(ruc)) {
                JOptionPane.showMessageDialog(vista, "ERROR: Ya existe una empresa registrada con este número de RUC.", "Empresa Duplicada", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // Generar clave automática 
        String claveAutogenerada = "EMP" + (new Random().nextInt(9000) + 1000);

        Rubro rubroObjeto = new Rubro(rubroSeleccionado, true);
        Cliente nuevoCliente = new Cliente(ruc, razonSocial, email, contacto, telefono, claveAutogenerada, rubroObjeto);

        if (contadorClientes < clientesDB.length) {
            clientesDB[contadorClientes++] = nuevoCliente;
            
            //Actualizar el Frontend con la respuesta
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
