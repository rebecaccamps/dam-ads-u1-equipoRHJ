package vista.views;

import logica.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.function.Consumer;

public class SocioFormView extends GridPane {
    public SocioFormView(ClubDeportivo club) {
        setPadding(new Insets(12));
        setHgap(8);
        setVgap(8);

        TextField id = new TextField();
        TextField dni = new TextField();
        TextField nombre = new TextField();
        TextField apellidos = new TextField();
        TextField tel = new TextField();
        TextField email = new TextField();
        Button crear = new Button("Crear");

        addRow(0, new Label("idSocio*"), id);
        addRow(1, new Label("DNI"), dni);
        addRow(2, new Label("Nombre"), nombre);
        addRow(3, new Label("Apellidos"), apellidos);
        addRow(4, new Label("Teléfono"), tel);
        addRow(5, new Label("Email"), email);
        add(crear, 1, 6);

        crear.setOnAction(e -> {

            if (id.getText().equals("")) {
                showError("Rellene los campos obligatorios (idSocio)");
            } else {
                try {
                    boolean encontrado = false;

                    //Compruebo que el id introducido del socio nuevo a crear es válido (no está repetido)
                    for (Socio s : club.getSocios()) {
                        if (s.getIdSocio().equals(id.getText())) {
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        club.altaSocio(new Socio((!id.getText().isEmpty() ? id.getText() : "null"),(!dni.getText().isEmpty() ? dni.getText() : "null"), (!nombre.getText().isEmpty() ? nombre.getText() : "null"),
                                (!apellidos.getText().isEmpty() ? apellidos.getText() : "null"), (!tel.getText().isEmpty() ? tel.getText() : "null"), (!email.getText().isEmpty() ? email.getText() : "null")));
                        showInfo("Socio dado de alta con éxito");
                    } else {
                        showError("Ya existe un socio con este id asignado");
                    }

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
