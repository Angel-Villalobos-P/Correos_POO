package vista;

import Controller.Sistema;
import Model.Cliente;
import Model.Direccion;
import Model.TipoRango;
import Model.TipoSexo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class NuevoClienteController {

    @FXML
    private TextField cedula;

    @FXML
    private TextField nombre;

    @FXML
    private TextField correo;

    @FXML
    private TextField telefono;

    @FXML
    private TextField provincia;

    @FXML
    private TextField canton;

    @FXML
    private TextField distrito;

    @FXML
    private TextField senias;
/*
    @FXML
    private TextField dia;

    @FXML
    private TextField mes;

    @FXML
    private TextField year;*/

    @FXML
    private ChoiceBox<TipoRango> tipo = new ChoiceBox<>();

    @FXML
    private ChoiceBox<TipoSexo> sexo = new ChoiceBox<>();

    @FXML
    private Button aceptar;

    @FXML
    private DatePicker datePicker;

    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private TableView tablaClientes;

    private Stage stageNuevo = new Stage();

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clienteNuevo.fxml"));
    Parent rootNuevo;

    public Parent getRootNuevo() throws IOException {
        rootNuevo = fxmlLoader.load();
        return rootNuevo;
    }

    @FXML
    public void initialize() {
        sexo.getItems().addAll(TipoSexo.values());

        tipo.getItems().addAll(TipoRango.values());

    }

    public void nuevoClienteVentana() throws IOException {
        datePicker = new DatePicker();
        //this.tablaClientes = tableView;

        rootNuevo = fxmlLoader.load();
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("clienteNuevo.fxml"));
        //Parent rootNuevo = fxmlLoader.load();
        //Stage stageNuevo = new Stage();
        stageNuevo.initModality(Modality.APPLICATION_MODAL);
        stageNuevo.initStyle(StageStyle.DECORATED);
        stageNuevo.setScene(new Scene(rootNuevo));
        //stageNuevo.fullScreenProperty();
        stageNuevo.show();

    }

    @FXML
    private void handleButton(javafx.event.ActionEvent event) throws Exception{
        Direccion direccion = new Direccion();
        direccion.setProvincia(provincia.getText());
        direccion.setCanton(canton.getText());
        direccion.setDistrito(distrito.getText());
        direccion.setSenias(senias.getText());

        //datePicker = new DatePicker();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, datePicker.getValue().getYear()-1900);
        calendar.set(Calendar.MONTH, datePicker.getValue().getMonth().getValue());
        calendar.set(Calendar.DATE, datePicker.getValue().getDayOfMonth());


        Date fecha = new Date(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));

        Cliente cliente = new Cliente(Integer.parseInt(cedula.getText()), nombre.getText(), correo.getText(), telefono.getText(), direccion, fecha, sexo.getValue());

        System.out.println(cliente.getFechaNacimiento().toString());
        //Sistema.getInstance().getMiCounter().registrarClient(cliente);
        Sistema.getInstance().registrarCliente(cliente);
        System.out.print("Cliente: " + Sistema.sistema.getMiCounter().consultarCliente(Integer.parseInt(cedula.getText())));


        //listaClientes.add(cliente);

        //AdminController.getInstance().mostrarVentana();
        stageNuevo.setScene(new Scene(AdminController.getInstance().getParent()));
        stageNuevo.show();
        Stage st = (Stage) aceptar.getScene().getWindow();
        st.hide();

       /* Stage stage = (Stage) aceptar.getScene().getWindow();
        stage.setScene(AdminController.getInstance().getParent().getScene());
        stage.toFront();
        stage.show();*/

       /* Parent root = FXMLLoader.load(getClass().getResource("cMenuTutor.fxml"));
        Scene scene = new Scene(root);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(scene);
        appStage.toFront();
        appStage.show();*/


    }

    public ObservableList<Cliente> returnClientes(){
        return listaClientes;
    }
}
