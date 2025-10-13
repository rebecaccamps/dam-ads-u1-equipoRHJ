package vista.views;

import logica.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class CambiarDisponibilidadView extends GridPane {
    public CambiarDisponibilidadView(ClubDeportivo club) {
        setPadding(new Insets(12));
        setHgap(8); setVgap(8);

        ComboBox<String> id = new ComboBox();
        CheckBox disponible = new CheckBox("Disponible");
        Button cambiar = new Button("Aplicar");
        for (Pista pista : club.getPistas()) {
            id.getItems().addAll(pista.getIdPista());
        }

        addRow(0, new Label("idPista"), id);
        addRow(1, new Label("Estado"), disponible);
        add(cambiar, 1, 2);

        cambiar.setOnAction(e -> {

            if (id.getValue() != null) {

                try {

                    club.cambiarDisponibilidadPista(id.getValue(), disponible.isSelected());
                    showInfo("Disponibilidad de la pista cambiada correctamente");

                } catch (Exception ex) {
                    showError(ex.getMessage());
                }

            } else {
                showError("Seleccione una pista primero");
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
