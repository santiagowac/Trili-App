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
 * @author Estudiante 2018
 */
public class FXMLCalificacionPublicacionProductoController {
    @FXML private Text actiontarget;
    
    @FXML public void handleSubmitButtonActionCPI(ActionEvent event) {
        actiontarget.setText("CalificaionPublicacionProducto Ingresado");
    }   
    
@FXML public void handleMostrartButtonActionCPM(ActionEvent event) {
        actiontarget.setText("Mostar");
    } 
 
@FXML public void handleActualizarButtonActionCPA(ActionEvent event) {
        actiontarget.setText("CalificaionPublicacionProducto Actualizado");
    } 

 @FXML public void handleEliminarButtonActionCPE(ActionEvent event) {
        actiontarget.setText("CalificaionPublicacionProducto Eliminado");
    } 
    public void RegresarAVerCU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLVerPublicacionesParaUsu.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
}
