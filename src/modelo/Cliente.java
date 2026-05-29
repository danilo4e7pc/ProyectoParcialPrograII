package modelo;

public class Cliente {
	private String RUC;
    private String razonSocial;
    private String email;
    private String contacto;
    private String telefono;
    private String clave;
    private Rubro rubro; 
    
    private Oferta[] ofertas;
    private int contadorOfertas;

    public Cliente(String RUC, String razonSocial, String email, String contacto, String telefono, String clave, Rubro rubro) {
        this.RUC = RUC;
        this.razonSocial = razonSocial;
        this.email = email;
        this.contacto = contacto;
        this.telefono = telefono;
        this.clave = clave;
        this.rubro = rubro;
        this.ofertas = new Oferta[100];
        this.contadorOfertas = 0;
    }

    public boolean agregarOferta(Oferta oferta) {
        if (contadorOfertas >= ofertas.length) return false;
        ofertas[contadorOfertas++] = oferta;
        return true;
    }

    public boolean eliminarOferta(Oferta oferta) {
        for (int i = 0; i < contadorOfertas; i++) {
            if (ofertas[i] == oferta) {
                for (int j = i; j < contadorOfertas - 1; j++) {
                    ofertas[j] = ofertas[j+1];
                }
                ofertas[--contadorOfertas] = null;
                return true;
            }
        }
        return false;
    }

    public Oferta[] getOfertas() {
        Oferta[] activas = new Oferta[contadorOfertas];
        System.arraycopy(ofertas, 0, activas, 0, contadorOfertas);
        return activas;
    }

    // Getters y Setters
    public String getRUC() { return RUC; }
    public String getClave() { return clave; }
    public String getRazonSocial() { return razonSocial; }
}
