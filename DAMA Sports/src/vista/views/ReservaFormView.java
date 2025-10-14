package vista.views;

import logica.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.time.LocalTime;


public class ReservaFormView extends GridPane {
    public ReservaFormView(ClubDeportivo club) {
        setPadding(new Insets(12));
        setHgap(8); setVgap(8);

        TextField id = new TextField();
        ComboBox<String> idSocio = new ComboBox();
        ComboBox<String> idPista = new ComboBox();
        DatePicker fecha = new DatePicker(LocalDate.now());
        TextField hora = new TextField("10:00");
        Spinner<Integer> duracion = new Spinner<>(30, 300, 60, 30);
        TextField precio = new TextField("10.0");
        Button crear = new Button("Reservar");

        addRow(0, new Label("idReserva*"), id);
        addRow(1, new Label("Socio*"), idSocio);
        addRow(2, new Label("Pista*"), idPista);
        addRow(3, new Label("Fecha*"), fecha);
        addRow(4, new Label("Hora inicio* (HH:mm)"), hora);
        addRow(5, new Label("Duración (min)"), duracion);
        addRow(6, new Label("Precio (€)"), precio);
        add(crear, 1, 7);

        for (Socio s :  club.getSocios()) {
            idSocio.getItems().add(s.getIdSocio());
        }

        for (Pista pista : club.getPistas()) {
            idPista.getItems().add(pista.getIdPista());
        }

        crear.setOnAction(e -> {
            try {
                LocalTime t = LocalTime.parse(hora.getText());

              Reserva r = new Reserva(id.getText(), idSocio.getValue(), idPista.getValue(),
                      fecha.getValue(), t, duracion.getValue(), Double.parseDouble(precio.getText()));
                club.crearReserva(r);
                showInfo("Reserva realizada com éxito");
            } catch (Exception ex) {
                showError(ex.getMessage());
            }
        });
    }

    private void showError(String msg) {
        Alert a = new Alert(Alert.AlertType.ERROR, msg, ButtonType.OK);
        a.setHeaderText("Error");
        a.showAndWait();
    }
    private void showInfo(String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        a.setHeaderText(null);
        a.showAndWait();
    }
}
