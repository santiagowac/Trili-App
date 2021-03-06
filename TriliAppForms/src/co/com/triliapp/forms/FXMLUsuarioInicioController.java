/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yasuly
 */
public class FXMLUsuarioInicioController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void irAPublicar(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPublicacionDeProducto.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Publicacion");
        
        stage.show();
    }
    public void irAMiCuenta(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioMiCuenta.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Mi Cuenta");
        
        stage.show();
    }
    public void verPCUSU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLVerPublicacionesParaUsu.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Publicacion");
        
        stage.show();
    }
    
}
