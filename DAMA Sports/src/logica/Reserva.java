package logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private final String idReserva;
    private  String idSocio;
    private String idPista;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private int duracionMin;
    private double precio;


    public Reserva(String idReserva, double precio, LocalTime horaIncio, int duracion, String idPista, String idSocio, LocalDate fecha) {
        this.idReserva = idReserva;
        this.precio = precio;
        this.horaInicio = horaIncio;
        this.idPista = idPista;
        this.idSocio = idSocio;
        this.fecha = fecha;

        try{
            setDuracionMin(duracion);
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public String getIdReserva() {
        return idReserva;
    }

    public String getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

    public String getIdPista() {
        return idPista;
    }

    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        if (duracionMin > 0 ) {
            this.duracionMin = duracionMin;
        }else {
            throw new RuntimeException("La duración debe de ser mayor a 0");
        }
        ;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
