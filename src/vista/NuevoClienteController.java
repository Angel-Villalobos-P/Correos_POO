package vista;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;

public class NuevoClienteControler {

    @FXML
    private TextField cedula;

    @FXML
    private TextField nombre;

    @FXML
    private TextField correo;

    @FXML
    private TextField provincia;

    @FXML
    private TextField canton;

    @FXML
    private TextField distrito;

    @FXML
    private TextField senias;

    @FXML
    private TextField dia;

    @FXML
    private TextField mes;

    @FXML
    private TextField year;

    @FXML
    private ChoiceBox tipo;

    @FXML
    private ChoiceBox sexo;

    public void nueoClienteVentana() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clienteNuevo.fxml"));
        Parent rootNuevo = fxmlLoader.load();
        Stage stageNuevo = new Stage();
        stageNuevo.initModality(Modality.WINDOW_MODAL);
        stageNuevo.initStyle(StageStyle.DECORATED);
        stageNuevo.setScene(new Scene(rootNuevo));
        stageNuevo.fullScreenProperty();
        stageNuevo.show();
    }
    @FXML
    private void handleButton(javafx.event.ActionEvent event) throws Exception{

    }
}
