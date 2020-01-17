/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class FXMLSugerenciaController {
   @FXML private Text actiontarget;
    
    @FXML public void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Ingreso exictoso");
    }   
@FXML public void handleMostrartButtonAction(ActionEvent event) {
        actiontarget.setText("Mostar");
    } 
 
@FXML public void handleActualizarButtonAction(ActionEvent event) {
        actiontarget.setText("Sea Actualizado");
    } 

 @FXML public void handleEliminarButtonAction(ActionEvent event) {
        actiontarget.setText("Sea Eliminado");
    } 
}
