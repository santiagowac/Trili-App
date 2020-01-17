/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author cerqu
 */
public class FXMLPublicacionDeProductoController {
private Text actiontarget;
    
public void handleSubmitButtonActionPUI(ActionEvent event) {
        actiontarget.setText("PublicacionDeProductoController Ingresado");
    }   
public void handleMostrartButtonActionPUM(ActionEvent event) {
        actiontarget.setText("Mostar");
    } 
 
public void handleActualizarButtonActionPUA(ActionEvent event) {
        actiontarget.setText("PublicacionDeProductoController Actualizado");
    } 

 public void handleEliminarButtonActionPUE(ActionEvent event) {
        actiontarget.setText("PublicacionDeProductoController Eliminado");
    } 
@FXML

 public void irAMenu(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioInicio.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Menu");
        
        stage.show();
    }
 
}



