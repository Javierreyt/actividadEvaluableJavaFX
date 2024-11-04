package org.pruebaevaluable.actividadevaluable.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.pruebaevaluable.actividadevaluable.model.User;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Spinner<Integer> versionSpinner;
    @FXML
    private CheckBox adminCheckBox;
    @FXML
    private TableColumn<User, String> cEmail;
    @FXML
    private TableColumn<User, String> cVersion;
    @FXML
    private TableColumn<User, String> cPlatform;
    @FXML
    private TextField txtEmail;
    @FXML
    private ChoiceBox<String> platformChoiceBox;
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, String> cAdmin;
    @FXML
    private TableColumn<User, String> cCreated;

    /**
     * Maneja el evento de agregar un nuevo usuario a la tabla.
     *
     * @param actionEvent el evento de acción que desencadena este método
     */
    @FXML
    public void add(ActionEvent actionEvent) {
        if (txtEmail.getText() == null || Objects.equals(txtEmail.getText(), "")) {
            new Alert(Alert.AlertType.WARNING, "Debes de rellenar todos los campos").showAndWait();
        } else {
            User user = new User(
                    txtEmail.getText(),
                    platformChoiceBox.getValue(),
                    adminCheckBox.isSelected(),
                    versionSpinner.getValue(),
                    LocalDateTime.now()
            );
            table.getItems().add(user);

            txtEmail.setText("");
            versionSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));
            versionSpinner.getValueFactory().setValue(1);
            platformChoiceBox.setValue("Windows");
            adminCheckBox.setSelected(false);
        }
    }

    /**
     * Maneja el evento de limpiar todos los elementos de la tabla.
     *
     * @param actionEvent el evento de acción que desencadena este método
     */
@FXML
public void clean(ActionEvent actionEvent) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmación");
    alert.setHeaderText(null);
    alert.setContentText("¿Estás seguro de que quieres limpiar la tabla?");

    ButtonType buttonTypeYes = new ButtonType("Sí");
    ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

    alert.getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

    alert.showAndWait().ifPresent(type -> {
        if (type == buttonTypeYes) {
            table.getItems().clear();
        }
    });
}

    /**
     * Inicializa los elementos de la interfaz gráfica y configura las columnas de la tabla.
     *
     * @param url            la URL utilizada para resolver rutas relativas para el objeto raíz, o null si no se conoce la URL
     * @param resourceBundle el conjunto de recursos utilizado para localizar el objeto raíz, o null si no se ha localizado
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cAdmin.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getIs_admin().toString());
        });
        cEmail.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getEmail());
        });
        cPlatform.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getPlatform());
        });
        cVersion.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getVersion().toString());
        });
        cCreated.setCellValueFactory((row) -> {
            return new SimpleStringProperty(row.getValue().getCreated_at().toString());
        });

        platformChoiceBox.getItems().addAll("Windows", "Linux", "Mac");
        platformChoiceBox.setValue("Windows");
        versionSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 5, 1));

        table.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) return;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Información del Usuario");
            alert.setHeaderText(null);
            alert.setContentText(newValue.toString());
            alert.showAndWait();
        });
    }
}