package vista;

import Model.Casillero;
import Model.Cliente;
import Model.TipoEstadoCasillero;
import Model.TipoRango;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import Controller.Sistema;
import org.w3c.dom.events.Event;

import java.io.IOException;

public class AdminController {
    public static AdminController gestion;

    //Parent Root = FXMLLoader.load(getClass().getResource("TablaCasilleros.fxml"));//FxmlLoader.load();
    //public Stage stage = new Stage();

    @FXML
    private Button agregarCliente;

    @FXML
    private TextField buscar;
    @FXML
    private TextField buscarCliente;

    @FXML
    private TableView<Casillero> tabla = new TableView<>();
    @FXML
    private TableView<Cliente> tablaClientes = new TableView<>();

    private ObservableList<Casillero> listaCasilleros = FXCollections.observableArrayList();
    private ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();

    @FXML
    private TableColumn clienteName = new TableColumn<>();
    @FXML
    private TableColumn numeroCasillero = new TableColumn<>();
    @FXML
    private TableColumn estadoCasillero = new TableColumn<>();
    @FXML
    private TableColumn clienteNombre = new TableColumn<>();//nombre del cliente de la tabla de clientes
    @FXML
    private TableColumn clienteCedula = new TableColumn<>();
    @FXML
    private TableColumn clienteTelefono = new TableColumn<>();
    @FXML
    private TableColumn clienteCorreo = new TableColumn<>();
    @FXML
    private TableColumn clienteFechaNac = new TableColumn<>();
    @FXML
    private TableColumn clienteRango = new TableColumn<>();
    @FXML
    private TableColumn clienteSexo = new TableColumn<>();
    @FXML
    private TableColumn clientePaqRetirados = new TableColumn<>();
    @FXML
    private TableColumn clienteDireccion = new TableColumn<>();

    private FilteredList<Casillero> filteredData = new FilteredList<>(listaCasilleros, p -> true);
    private FilteredList<Cliente> filteredDataTablaClientes = new FilteredList<>(listaClientes, p -> true);

    private Stage stage = new Stage();
    private Parent Root;

    public AdminController(){
    }
    public static AdminController getInstance(){
        if (gestion == null)
            gestion = new AdminController();
        return gestion;
    }

    public Stage getStage() {
        return stage;
    }
    public Parent getParent() throws IOException {
        Root = FXMLLoader.load(getClass().getResource("TablaCasilleros.fxml"));
        return Root;
    }


    @FXML
    public void initialize() {
        buscar.setPromptText("Nombre del cliente");
        tabla.setEditable(true);
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        listaCasilleros.addAll(Sistema.getInstance().getMiCounter().getRegistroCasilleros());
        clienteName.setCellValueFactory(new PropertyValueFactory<Casillero, String>("noAsignado"));
        numeroCasillero.setCellValueFactory(new PropertyValueFactory<Casillero, Integer>("numCasillero"));
        estadoCasillero.setCellValueFactory(new PropertyValueFactory<Casillero, TipoEstadoCasillero>("estado"));
        tabla.setItems(listaCasilleros);
        tabla.setItems(filteredData);

        //Filtro por nombre tabla de casilleros
        /*buscar.textProperty().addListener((prop, old, text) -> {
            filteredData.setPredicate(Casillero -> {
                if(text == null || text.isEmpty()) return true;

                String name = Casillero.getCliente().getNombre().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });*/
        buscar.textProperty().addListener((prop, old, text) -> {
            filteredData.setPredicate(Casillero -> {
                if(text == null || text.isEmpty()) return true;

                if (Casillero.getCliente() == null){return false;}
                if (isNumeric(text)){
                    String numero = Integer.toString(Casillero.getNumCasillero());
                    return numero.contains(text.toLowerCase());
                }
                String name = Casillero.getCliente().getNombre().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });

        //Configura el tooltip tabla de casilleros
        tabla.setRowFactory(tv -> new TableRow<>() {
            private Tooltip tooltip = new Tooltip();

            @Override
            public void updateItem(Casillero casillero, boolean empty) {
                super.updateItem(casillero, empty);
                if (casillero == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText("Doble click para editar");
                    setTooltip(tooltip);
                }
            }
        });

        //Tabla de clientes
        buscarCliente.setPromptText("Texto para filtrar");
        tablaClientes.setEditable(true);
        tablaClientes.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        for (Casillero casillero : listaCasilleros) {
            if (casillero.getCliente() != null){
                listaClientes.add(casillero.getCliente());
                //filteredDataTablaClientes = new FilteredList<>(listaClientes, p -> true);
            } //else {return;}
        }
        clienteNombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        clienteCedula.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
        clienteTelefono.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        clienteCorreo.setCellValueFactory(new PropertyValueFactory<Cliente, String>("correo"));
        clienteFechaNac.setCellValueFactory(new PropertyValueFactory<Cliente, String>("fechaNac"));
        clienteRango.setCellValueFactory(new PropertyValueFactory<Cliente, TipoRango>("tipo"));
        clienteSexo.setCellValueFactory(new PropertyValueFactory<Cliente, TipoRango>("sexo"));
        clientePaqRetirados.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("PaquetesRetirados"));
        clienteDireccion.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("direcc"));
        tablaClientes.setItems(listaClientes);

        //Filtro para tabla de clientes
       // filteredDataTablaClientes = new FilteredList<>(listaClientes, p -> true);
        buscarCliente.textProperty().addListener((prop, old, text) -> {
            filteredDataTablaClientes.setPredicate(Cliente -> {
                if(text == null || text.isEmpty()) return true;

                if (Cliente == null){return false;}
                if (isNumeric(text)){
                    String numero = Integer.toString(Cliente.getId());
                    return numero.contains(text.toLowerCase());
                }
                String name = Cliente.getNombre().toLowerCase();
                return name.contains(text.toLowerCase());
            });
        });

        //Configura el tooltip tabla de casilleros
        tablaClientes.setRowFactory(tv -> new TableRow<>() {
            private Tooltip tooltip = new Tooltip();

            @Override
            public void updateItem(Cliente cliente, boolean empty) {
                super.updateItem(cliente, empty);
                if (cliente == null) {
                    setTooltip(null);
                } else {
                    tooltip.setText(cliente.getNombre());
                    setTooltip(tooltip);
                }
            }
        });



    }

    public void mostrarVentana() throws IOException {

        //Parent Root = FXMLLoader.load(getClass().getResource("TablaCasilleros.fxml"));
        Root = FXMLLoader.load(getClass().getResource("TablaCasilleros.fxml"));
        //Stage stage = new Stage();
        //stage.initModality(Modality.APPLICATION_MODAL);
        //stage.initStyle(StageStyle.DECORATED);
        stage.setScene(new Scene(Root));
        stage.fullScreenProperty();
        stage.setResizable(false);
        //stage.setMinWidth(600);
        //stage.setMinHeight(400);
        //if (stage.isShowing()){stage.hide();}
        stage.show();


    }

    @FXML
    public void registrarCliente(TableColumn.CellEditEvent actionEvent) throws IOException {
        int columnaIndex = tabla.getSelectionModel().getSelectedIndex();
        //System.out.println(columnaIndex);

        if (listaCasilleros.get(columnaIndex).getCliente() != null){
            System.out.println(listaCasilleros.get(columnaIndex).getCliente().getNombre());
            EliminarCliente_Controller eliminarCliente = new EliminarCliente_Controller();
            eliminarCliente.setIndex(columnaIndex);
            eliminarCliente.ventana();
        }
        else {

            //stage.hide();
            NuevoClienteController nuevoClienteController = new NuevoClienteController();
            //nuevoClienteController.nuevoClienteVentana();
            //AdminController.getInstance().getStage().getScene().getWindow().hide();
            stage.setScene(new Scene(nuevoClienteController.getRootNuevo()));
            stage.show();

        }

    }
    @FXML
    public void eliminarCiente(TableColumn.CellEditEvent actionEvent) throws IOException {
        int columnaIndex = tabla.getSelectionModel().getSelectedIndex();
        if (listaCasilleros.get(columnaIndex).getCliente() != null){
            System.out.println(listaCasilleros.get(columnaIndex).getCliente().getNombre());
            EliminarCliente_Controller eliminarClienteController = new EliminarCliente_Controller();
            eliminarClienteController.setIndex(columnaIndex);
            eliminarClienteController.ventana();
        }
    }

    @FXML
    public void registrarClienteButton(javafx.event.ActionEvent actionEvent) throws IOException {

        NuevoClienteController nuevoClienteController = new NuevoClienteController();
        nuevoClienteController.nuevoClienteVentana();
    }

    private static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }


}
