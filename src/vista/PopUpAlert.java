package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PopUpAlert {

    public static void display(String tile, String message) throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.UNDECORATED);
        window.setTitle(tile);
        window.setMinWidth(200);
        window.setMinHeight(100);

        Label label = new Label();
        label.setText(message);

        Button button = new Button("Aceptar");
        button.setOnAction(actionEvent -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);

        scene.getStylesheets().add("vista/Stylesheet.css");
        button.setOnAction(actionEvent -> window.close());
        window.showAndWait();

    }
}
