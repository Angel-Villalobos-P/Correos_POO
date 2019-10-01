/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casilleros_mains;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class HolaMundoCasilleros_FX extends Application {
     
    public static void main(String args[]) {
       Application.launch(args);
    }
    @Override
    public void start(Stage escenaPrincipal) {
        //Creamos un panel o raiz para agregar componentes
        StackPane panelPila = new StackPane();
        //Creamos el componente de tipo etiqueta(label)
        Label label = new Label("Hola Mundo desde JavaFX");
        //Lo agregamos al panel
        panelPila.getChildren().add(label);
        //Configuramos la ventana o escena
         Scene escena = new Scene(panelPila, 230, 40);
        //Establecemos las caracteristicas
        escenaPrincipal.setScene(escena);
        escenaPrincipal.setTitle("Hola mundo FX");
        //Mostramos la ventana
        escenaPrincipal.show();
    }    
}

