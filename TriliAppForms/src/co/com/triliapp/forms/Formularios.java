/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author cerqu
 */
public class Formularios extends Application {

    @Override
    public void start(Stage stage) throws Exception {                                   /* OJO CON LA SIGUIENTE ANOTACION */
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenuInicial.fxml")); /*AQUI FALTA UNA CONDICIONAL PARA LOGIN (INGRESAR) //SI ES TAL ROL A TAL INTERFAZ// ADEMAS EL ENVIAR DEBE TENER SI CUMPLE CON TODOS LOS CAMBIOS Y SON VALIDOS ENTONCES AVISAR QUE SE INSERTO Y PASARLO AL MENU A LA INTERFAZ CORRESPONTIENTE// */
                                                                                       /*HAY 3 MENUS FXMLMenuInicial.fxml --- UsuarioInicio.fxml ---- UsuarioAdminInicio.fxml (TODOS CON NAVEGABILIDAD COMPLETA */
        Scene scene = new Scene(root, 466, 632);
        stage.setTitle("TriliAplicativo - Menu");
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
