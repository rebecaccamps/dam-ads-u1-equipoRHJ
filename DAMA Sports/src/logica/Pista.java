package logica;

public class Pista {

    private final String idPista;
    private String deporte;
    private String descripcion;
    private boolean disponible;


    public Pista(String idPista, String deporte, String descripcion, boolean disponible) {
        this.idPista = idPista;
        this.deporte = deporte;
        this.descripcion = descripcion;
        this.disponible = disponible;
    }


    public String getIdPista() {
        return idPista;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
