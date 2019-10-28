package vista;

import Controller.Sistema;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class AdminController {
    @FXML
    private Button agregarCliente;

    public AdminController(){
    }


    public void mostrarVentana() throws IOException {
        FXMLLoader FxmlLoader = new FXMLLoader(getClass().getResource("ventanaAdmin.fxml"));
        Parent Root = FxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(new Scene(Root));
        stage.fullScreenProperty();
        stage.show();

    }

    @FXML
    public void agregarCliente(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage st = (Stage) agregarCliente.getScene().getWindow();
        //st.hide();

        new NuevoClienteController().nuevoClienteVentana();

        Sistema.getInstance().test();

    }
}
