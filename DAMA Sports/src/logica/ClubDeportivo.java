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
            if (r.getIdSocio().equals(idSocio)) {
                System.out.println("No se puede eliminar: el socio tiene reservas activas.");
                return;
            }
        }
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getIdSocio().equals(idSocio)) {
                socios.remove(i);
                System.out.println("Socio eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró el socio con ID: " + idSocio);
    }

    //Dar de alta una Pista
    public void altaPista(Pista pista) {
        for (Pista p : pistas) {
            if (p.getIdPista().equals(pista.getIdPista())) {
                System.out.println("La Pista con id " + p.getIdPista() + " ya existe");
                return;
            }
        }
        pistas.add(pista);
    }


    //Cambiar disponibilidad de Pista
    public void cambiarDisponibilidadPista(String idPista, boolean disponible) {
        for (Pista p : pistas) {
            if (p.getIdPista().equals(idPista)) {
                p.setDisponible(disponible);
                return;
            }
        }
        System.out.println("No se encontró la pista con ID " + idPista);
    }

    //Crear una Reserva
    public boolean crearReserva(Reserva r) {
        for (Pista p : pistas) {
            if (p.getIdPista().equals(r.getIdPista())) {
                if (!p.isDisponible()) {
                    System.out.println("La pista no está disponible.");
                    return false;
                }
                reservas.add(r);
                return true;
            }
        }
        System.out.println("No se encontró la pista indicada.");
        return false;
    }

    //Cancelar Reserva
    public void cancelarReserva(String idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdReserva().equals(idReserva)) {
                reservas.remove(i);
                System.out.println("Reserva cancelada correctamente.");
                return;
            }
        }
        System.out.println("No se encontró la reserva con ese ID.");
    }
}
