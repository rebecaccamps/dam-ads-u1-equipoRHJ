package logica;

import java.time.LocalDate;
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

    //Dar de baja a un Socio

    public void bajaSocio(String idSocio) {
        for (Reserva r : reservas) {
            if (r.getIdSocio().equals(idSocio) && r.getFecha().isAfter(LocalDate.now())) {
                System.out.println("No se puede eliminar, tiene reservas futuras");
                return;
            }
        }
        socios.removeIf(s -> s.getIdSocio().equals(idSocio));
    }

    //Dar de alta una Pista

    //Cambiar disponibilidad de Pista

    //Crear una Reserva

    //Cancelar Reserva

    


}
