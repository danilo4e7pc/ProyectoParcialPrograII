package modelo;
import java.util.Date;

public class Postulacion {
	
	private Date fecha;
    private boolean anulado;
    private Date fechaAnulacion;
    private Oferta oferta; // Asociación con Oferta

    public Postulacion(Oferta oferta) {
        this.fecha = new Date(); 
        this.anulado = false;
        this.oferta = oferta;
    }

    // Getters y Setters
    public Date getFecha() { return fecha; }
    public boolean isAnulado() { return anulado; }
    public void setAnulado(boolean anulado) { this.anulado = anulado; }
    public Date getFechaAnulacion() { return fechaAnulacion; }
    public void setFechaAnulacion(Date fechaAnulacion) { this.fechaAnulacion = fechaAnulacion; }
    public Oferta getOferta() { return oferta; }
}
