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
public class FXMLUsuarioAdminAdministrarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void GestionarCategorias(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCategoriaAdmin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarProductos(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLProducto.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarPublicaciones(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLPublicacionDeProductoAdmin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarRangos(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRango.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarCalificaciones(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLCalificacionPublicacionProductoAdmin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarSugerencias(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLSugerenciaAdmin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarRoles(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRol.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    public void GestionarReportes(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLReporteAdmin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
        public void GestionarUsuarios(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdmin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
        public void regresarAdm(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminInicio.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
    
}
