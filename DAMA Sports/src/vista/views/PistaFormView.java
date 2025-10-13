package vista.views;

import logica.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class PistaFormView extends GridPane {
    public PistaFormView(ClubDeportivo club) {
        setPadding(new Insets(12));
        setHgap(8); setVgap(8);

        TextField id = new TextField();
        TextField deporte = new TextField();
        TextField descripcion = new TextField();
        CheckBox disponible = new CheckBox("Disponible");
        Button crear = new Button("Crear");

        addRow(0, new Label("idPista*"), id);
        addRow(1, new Label("Deporte"), deporte);
        addRow(2, new Label("Descripción"), descripcion);
        addRow(3, new Label("Operativa"), disponible);
        add(crear, 1, 4);

        crear.setOnAction(e -> {


                if (id.getText().equals("") || deporte.getText().equals("") || descripcion.getText().equals("")) {
                    showError("Todos los campos son obligatorios. Asegúrese de haber rellenado todos");
                } else {
                    try {
                        club.altaPista(new Pista(id.getText(), deporte.getText(), descripcion.getText(), disponible.isSelected()));
                        showInfo("Pista dada de alta correctamente");

                    } catch (Exception ex) {
                        showError(ex.getMessage());
                    }
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
