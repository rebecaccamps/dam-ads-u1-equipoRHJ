package vista.views;

import logica.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class BajaSocioView extends GridPane {

    public BajaSocioView(ClubDeportivo club) {
        setPadding(new Insets(12));
        setHgap(8); setVgap(8);

        ComboBox<String> id = new ComboBox<>();
        Button baja = new Button("Dar de baja");
        for (Socio socio : club.getSocios()) {
            id.getItems().add(socio.getIdSocio());
        }

        addRow(0, new Label("Socio"), id);
        add(baja, 1, 1);

        baja.setOnAction(e -> {

            if (id.getValue() != null) {
                boolean encontrado = false;

                //Antes de eliminar un socio, veo si tiene reservas activas
                for (Reserva r : club.getReservas()) {
                    if (r.getIdSocio().equals(id.getValue())) {
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    club.bajaSocio(id.getValue());
                    showInfo("Socio eliminado correctamente");
                } else {
                    showError("Este socio tiene reservas activas");
                }

            } else {
                showError("Seleccione un socio primero");
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
