package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaEmpresa extends JFrame {

	private static final long serialVersionUID = 1L;
	public JTextField txtRuc, txtRazonSocial, txtEmail, txtContacto, txtTelefono;
    public JComboBox<String> cbRubro;
    public JButton btnRegistrar;
    public JTextArea txtResultado;

    public VentanaEmpresa() {
        // Ventana un poco más grande para que todo entre cómodo con letra grande
        setTitle("Sistema de Reclutamiento TI");
        setSize(700, 661); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(10, 10));

        // 1. TÍTULO EN LA PARTE SUPERIOR (Para dejar claro el propósito)
        JLabel lblTitulo = new JLabel("Formulario de Registro de Empresas", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24)); // Letra grande y clara
        lblTitulo.setPreferredSize(new Dimension(150,50));
        getContentPane().add(lblTitulo, BorderLayout.NORTH);

        // 2. PANEL DEL FORMULARIO (GridLayout simple)
        JPanel panelForm = new JPanel(new GridLayout(6, 2, 10, 15));
        
        // Fila 1
        JLabel lblRuc = new JLabel(" RUC:");
        lblRuc.setFont(new Font("Arial", Font.BOLD, 16));
        txtRuc = new JTextField();
        txtRuc.setFont(new Font("Arial", Font.PLAIN, 16));
        panelForm.add(lblRuc);
        panelForm.add(txtRuc);

        // Fila 2
        JLabel lblRazon = new JLabel(" Razón Social:");
        lblRazon.setFont(new Font("Arial", Font.BOLD, 16));
        txtRazonSocial = new JTextField();
        txtRazonSocial.setFont(new Font("Arial", Font.PLAIN, 16));
        panelForm.add(lblRazon);
        panelForm.add(txtRazonSocial);

        // Fila 3
        JLabel lblEmail = new JLabel(" Correo Institucional:");
        lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        panelForm.add(lblEmail);
        panelForm.add(txtEmail);

        // Fila 4
        JLabel lblContacto = new JLabel(" Persona de Contacto:");
        lblContacto.setFont(new Font("Arial", Font.BOLD, 16));
        txtContacto = new JTextField();
        txtContacto.setFont(new Font("Arial", Font.PLAIN, 16));
        panelForm.add(lblContacto);
        panelForm.add(txtContacto);

        // Fila 5
        JLabel lblTelefono = new JLabel(" Teléfono:");
        lblTelefono.setFont(new Font("Arial", Font.BOLD, 16));
        txtTelefono = new JTextField();
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
        panelForm.add(lblTelefono);
        panelForm.add(txtTelefono);

        // Fila 6
        JLabel lblRubro = new JLabel(" Rubro o Sector:");
        lblRubro.setFont(new Font("Arial", Font.BOLD, 16));
        cbRubro = new JComboBox<>(new String[]{"Tecnología", "Banca", "Retail", "Educación"});
        cbRubro.setFont(new Font("Arial", Font.PLAIN, 16));
        panelForm.add(lblRubro);
        panelForm.add(cbRubro);

        // 3. BOTÓN DE ACCIÓN (Abajo del formulario)
        btnRegistrar = new JButton("Registrar Empresa y Generar Contraseña");
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegistrar.setPreferredSize(new Dimension(150,70));
        
        // Agrupamos el formulario y el botón en la zona central
        JPanel panelCentral = new JPanel(new BorderLayout(10, 10));
        panelCentral.add(panelForm, BorderLayout.CENTER);
        panelCentral.add(btnRegistrar, BorderLayout.SOUTH);
        
        getContentPane().add(panelCentral, BorderLayout.CENTER);

        // 4. ÁREA DE RESULTADOS (Sección inferior)
        txtResultado = new JTextArea(8, 20);
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 14)); // Letra legible para datos
        txtResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Empresas Registradas en el Sistema"));
        
        getContentPane().add(scroll, BorderLayout.SOUTH);
    }

    // Método de conexión para el controlador (No cambia)
    public void conectarControlador(ActionListener listener) {
        btnRegistrar.addActionListener(listener);
    }
}
