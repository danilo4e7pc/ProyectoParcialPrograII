package modelo;

public class Oferta {
	private String puesto;
    private String descripcion;
    private String area;
    private java.util.Date fechaInicio;
    private java.util.Date fechaTermino;
    
    private Requisito[] requisitos;
    private int contadorRequisitos;

    public Oferta(String puesto, String descripcion, String area, java.util.Date fechaInicio, java.util.Date fechaTermino) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.area = area;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
        this.requisitos = new Requisito[50]; 
        this.contadorRequisitos = 0;
    }

    public boolean agregarRequisito(int orden, String descripcion) {
        if (contadorRequisitos >= requisitos.length) return false;
        Requisito nuevo = new Requisito(orden, descripcion, true);
        requisitos[contadorRequisitos++] = nuevo;
        for (int i = 0; i < contadorRequisitos - 1; i++) {
            for (int j = 0; j < contadorRequisitos - i - 1; j++) {
                if (requisitos[j].getOrden() > requisitos[j+1].getOrden()) {
                    Requisito temp = requisitos[j];
                    requisitos[j] = requisitos[j+1];
                    requisitos[j+1] = temp;
                }
            }
        }
        return true;
    }

    public Requisito[] getRequisitos() {
        Requisito[] activos = new Requisito[contadorRequisitos];
        System.arraycopy(requisitos, 0, activos, 0, contadorRequisitos);
        return activos;
    }

    public boolean eliminarRequisito(int orden) {
        for (int i = 0; i < contadorRequisitos; i++) {
            if (requisitos[i].getOrden() == orden) {
                
                for (int j = i; j < contadorRequisitos - 1; j++) {
                    requisitos[j] = requisitos[j+1];
                }
                requisitos[--contadorRequisitos] = null;
                return true;
            }
        }
        return false;
    }

    // Getters y Setters 
    public String getPuesto() { return puesto; }
    public String getDescripcion() { return descripcion; }
    public String getArea() { return area; }
    public java.util.Date getFechaInicio() { return fechaInicio; }
    public java.util.Date getFechaTermino() { return fechaTermino;
}
}
