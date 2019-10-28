package vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
       Parent root = FXMLLoader.load(getClass().getResource("Counter.fxml"));
        primaryStage.setTitle("Counter");
        primaryStage.setScene(new Scene(root, 350, 700));
        primaryStage.show();

        /*Controller controller = new Controller();
        controller.CrearCounter(primaryStage);*/

    }


    public static void main(String[] args) {
        launch(args);
    }
}
