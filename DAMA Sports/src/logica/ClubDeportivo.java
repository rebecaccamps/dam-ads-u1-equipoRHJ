package logica;

import java.util.ArrayList;

public class ClubDeportivo {

    ArrayList<Pista> pistas;
    ArrayList<Socio> socios;
    ArrayList<Reserva> reservas;



    //para agregar
    public void agregarSocio(Socio socio) {
        socios.add(socio);
    }

    public void agregarPista(Pista pista) {
        pistas.add(pista);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }


    //Retorna las listas
    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public ArrayList<Pista> getPistas() {
        return pistas;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }


    //carga de datos y guardado
    public void cargarDatos() {

    }

    public void guardarDatos() {


    }


    //Dar de alta a un Socio
    public boolean altaSocio(Socio socio) {
        for (Socio s : socios) {
            if (s.getIdSocio().equals(socio.getIdSocio())) {
                return false;
            }
        }
        socios.add(socio);
        return true;
    }

    



}
