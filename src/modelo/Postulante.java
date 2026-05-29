package modelo;

public class Postulante {
	private String email;
    private String nombres;
    private String apellidos;
    private String direccion;
    private java.util.Date nacimiento;
    private String clave;
    
    private GradoEstudio gradoEstudio;
    private Postulacion[] postulaciones;
    private int contadorPostulaciones;

    public Postulante(String email, String nombres, String apellidos, String direccion, java.util.Date nacimiento, String clave) {
        this.email = email;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.clave = clave;
        this.postulaciones = new Postulacion[200];
        this.contadorPostulaciones = 0;
    }

    public boolean asignargradoEstudio(GradoEstudio grado) {
        this.gradoEstudio = grado;
        return true;
    }

    public boolean postular(Oferta oferta) {
        if (contadorPostulaciones >= postulaciones.length) return false;
        Postulacion nueva = new Postulacion(oferta);
        postulaciones[contadorPostulaciones++] = nueva;
        return true;
    }

    public boolean anularPostulacion(Postulacion postulacion) {
        for (int i = 0; i < contadorPostulaciones; i++) {
            if (postulaciones[i] == postulacion) {
                postulaciones[i].setAnulado(true);
                postulaciones[i].setFechaAnulacion(new java.util.Date());
                return true;
            }
        }
        return false;
    }

    public Postulacion[] getPostulaciones() {
        Postulacion[] activas = new Postulacion[contadorPostulaciones];
        System.arraycopy(postulaciones, 0, activas, 0, contadorPostulaciones);
        return activas;
    }

    // Getters
    public String getEmail() { return email; }
    public String getClave() { return clave; }
}
