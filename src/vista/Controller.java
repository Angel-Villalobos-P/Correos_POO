package vista;

import Controller.Sistema;
import Model.Direccion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    private Sistema sistema = Sistema.getInstance();

    @FXML
    private TextField name;

    @FXML
    private TextField cedula;

    @FXML
    private TextField provincia;

    @FXML
    private TextField canton;

    @FXML
    private TextField distrito;

    @FXML
    private TextArea senas;

    @FXML
    private TextField cantidadCasilleros;

    @FXML
    private Button crear, agregarCliente;

    //private Stage primaryStage = new Stage();

    /**
     * Crea la ventana del counter
     * @param primaryStage
     * @throws IOException
     */
  /*  public void CrearCounter(Stage primaryStage) throws IOException {
        //this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Counter.fxml"));
        this.primaryStage.setTitle("Counter");
        this.primaryStage.setScene(new Scene(root, 350, 700));
        this.primaryStage.show();

    }*/

    /**
     * Manejadores de evento para los botones
     * @param event ...
     * @throws Exception ..
     */

    @FXML // boton que crea el counter
    private void crearCounter(javafx.event.ActionEvent event) throws Exception {
        Direccion direccion = sistema.crearDireccion(provincia.getText(), canton.getText(), distrito.getText(), senas.getText());

        sistema.crearCounter(name.getText(), cedula.getText(), direccion, Integer.parseInt(cantidadCasilleros.getText()));

        /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popUp.fxml"));
        Parent root1 = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        //stage.setTitle("ABC");
        stage.setScene(new Scene(root1));
        stage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished( pevent -> stage.close() );
        delay.play();*/


        //oculta la ventana
        Stage st = (Stage) crear.getScene().getWindow();
        st.hide();

        //aviso
        PopUpAlert.display("Counter creado", "Counter creado");

        /**
         * Muestra la ventana de gestion del Counter
         */
        /*FXMLLoader lLoader = new FXMLLoader(getClass().getResource("ventanaAdmin.fxml"));
        Parent pRoot = lLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initStyle(StageStyle.DECORATED);
        stage.setScene(new Scene(pRoot));
        stage.fullScreenProperty();
        stage.show();*/

        new AdminController().mostrarVentana();
        //adminController.mostrarVentana();


    }

}
