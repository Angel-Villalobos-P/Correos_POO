package vista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Controller.Sistema;
import java.io.IOException;

public class EliminarCliente_Controller {

    @FXML
    private Button si;
    @FXML
    private Button no;
    private int index;

    Stage stage = new Stage();


    public void setIndex(int index) {
        this.index = index;
    }

    public void ventana() throws IOException {
        /*FXMLLoader cFxmlLoader = new FXMLLoader(getClass().getResource("EliminarCliente.fxml"));
        Parent parent = cFxmlLoader.load();
        Stage stageNuevo = new Stage();
        stageNuevo.initModality(Modality.APPLICATION_MODAL);
        stageNuevo.initStyle(StageStyle.DECORATED);
        stageNuevo.setScene(new Scene(parent));
        stageNuevo.fullScreenProperty();
        stageNuevo.show();*/

        Parent root = FXMLLoader.load(getClass().getResource("EliminarCliente.fxml"));
        //Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.show();
    }

    @FXML
    public void Si_eliminarCliente(ActionEvent event) throws IOException {

        int ced;
        if (Sistema.getInstance().getMiCounter().getRegistroCasilleros().get(index).getCliente() != null){
            //Sistema.getInstance().getMiCounter().getRegistroCasilleros().get(index).setCliente(null);
            ced = Sistema.getInstance().getMiCounter().getRegistroCasilleros().get(index).getCliente().getId();
            Sistema.getInstance().getMiCounter().eliminarCliente(ced);
            AdminController.getInstance().mostrarVentana();

            Stage st = (Stage) si.getScene().getWindow();
            st.hide();
        }
    }

    @FXML
    public void cancelar(ActionEvent event){
        //this.stage.hide();
        Stage st = (Stage) no.getScene().getWindow();
        st.hide();
    }
}
