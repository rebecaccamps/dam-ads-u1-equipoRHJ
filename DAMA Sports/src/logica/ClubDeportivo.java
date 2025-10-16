package logica;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ClubDeportivo {

    ArrayList<Pista> pistas;
    ArrayList<Socio> socios;
    ArrayList<Reserva> reservas;


    public ClubDeportivo() {
        socios = new ArrayList<>();
        pistas = new ArrayList<>();
        reservas = new ArrayList<>();
    }


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


    //carga de datos y guardado de socios
    public void cargarDatosSocio() throws IOException {

        FileReader fr = new FileReader("socios.txt");
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        while (linea != null) {

                String[] datos = linea.split(",");

                if (datos.length == 6) {
                    try {
                        Socio s = new Socio(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);
                        socios.add(s);
                    } catch (Exception e) {
                        System.out.println("Error al procesar el socio: " + linea + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Error: Formato incorrecto en línea de socio: " + linea);
                }

            linea = br.readLine();
        }

        br.close();
        fr.close();

    }

    public void guardarDatosSocio(Socio s) throws IOException {

        FileWriter fw = new FileWriter("socios.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(s.getIdSocio() + "," + s.getDni() + "," + s.getNombre() + "," + s.getApellidos()
                + "," + s.getTelefono() + "," + s.getEmail() + "\n");

        bw.flush();
        bw.close();
        fw.close();

    }

    //carga de datos y guardado de pistas
    public void cargarDatosPista() throws IOException {

        FileReader fr = new FileReader("pistas.txt");
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        while (linea != null) {


                String[] datos = linea.split(",");

                if (datos.length == 4) {
                    try {
                        Pista p = new Pista(datos[0], datos[1], datos[2], Boolean.valueOf(datos[3]));
                        pistas.add(p);
                    } catch (Exception e) {
                        System.out.println("Error al procesar la pista: " + linea + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Error: Formato incorrecto en línea de pista: " + linea);
                }

            linea = br.readLine();
        }

        br.close();
        fr.close();

    }

    public void guardarDatosPista(Pista p) throws IOException {

        FileWriter fw = new FileWriter("pistas.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(p.getIdPista() + "," + p.getDeporte() + "," + p.getDescripcion() + "," + p.isDisponible() + "\n");

        bw.flush();
        bw.close();
        fw.close();

    }

    //carga de datos y guardado reservas
    public void cargarDatosReserva() throws IOException {

        FileReader fr = new FileReader("reservas.txt");
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        while (linea != null) {


                String[] datos = linea.split(",");

                if (datos.length == 7) {
                    try {
                        Reserva r = new Reserva(datos[0], datos[1], datos[2], LocalDate.parse(datos[3]),
                                LocalTime.parse(datos[4]), Integer.parseInt(datos[5]), Double.parseDouble(datos[6]));
                        reservas.add(r);
                    } catch (Exception e) {
                        System.out.println("Error al procesar la reserva: " + linea + " - " + e.getMessage());
                    }
                } else {
                    System.out.println("Error: Formato incorrecto en línea de reserva: " + linea);
                }

            linea = br.readLine();
        }

        br.close();
        fr.close();
    }

    public void guardarDatosReserva(Reserva r) throws IOException {

        FileWriter fw = new FileWriter("reservas.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(r.getIdReserva() + "," + r.getIdSocio() + "," + r.getIdPista() + "," + r.getFecha()
                + "," + r.getHoraInicio() + "," + r.getDuracionMin() + "," + r.getPrecio() + "\n");

        bw.flush();
        bw.close();
        fw.close();

    }

    public void guardarDatosGlobales() throws IOException {



        FileWriter fws = new FileWriter("socios.txt", false);
        BufferedWriter bws = new BufferedWriter(fws);

        bws.write("");

        bws.flush();
        bws.close();
        fws.close();

        FileWriter fwp = new FileWriter("pistas.txt", false);
        BufferedWriter bwp = new BufferedWriter(fwp);

        bwp.write("");

        bwp.flush();
        bwp.close();
        fwp.close();

        FileWriter fwr = new FileWriter("reservas.txt", false);
        BufferedWriter bwr = new BufferedWriter(fwr);

        bwr.write("");

        bwr.flush();
        bwr.close();
        fwr.close();


        for (Socio s : this.getSocios()){
            this.guardarDatosSocio(s);
        }

        for (Pista p : this.getPistas()){
            this.guardarDatosPista(p);
        }

        for (Reserva r : this.getReservas()){
            this.guardarDatosReserva(r);
        }
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
            }
        }
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
