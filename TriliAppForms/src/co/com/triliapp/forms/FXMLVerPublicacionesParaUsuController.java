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
public class FXMLVerPublicacionesParaUsuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void irAReportarU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLReporte.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Reportar");
        
        stage.show();
    }
        public void irACalificarU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCalificacionPublicacionProducto.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Calificar");
        
        stage.show();
    }
        public void RegresarVPU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioInicio.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Menu");
        
        stage.show();
    }
}
