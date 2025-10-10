package logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private final String idReserva;
    private  String idSocio;
    private String idPista;
    private LocalDate fecha;
    private LocalTime horaIncio;
    private int duracion;
    private double precio;


    public Reserva(String idReserva, double precio, LocalTime horaIncio, int duracion, String idPista, String idSocio, LocalDate fecha) {
        this.idReserva = idReserva;
        this.precio = precio;
        this.horaIncio = horaIncio;
        this.duracion = duracion;
        this.idPista = idPista;
        this.idSocio = idSocio;
        this.fecha = fecha;
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

    public LocalTime getHoraIncio() {
        return horaIncio;
    }

    public void setHoraIncio(LocalTime horaIncio) {
        this.horaIncio = horaIncio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
