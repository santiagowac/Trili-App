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

public class FXMLReporteController {

    private Text actiontarget;

    public void handleSubmitButtonAction(ActionEvent event) {
        actiontarget.setText("Ingreso exictoso");
    }

    public void handleMostrartButtonAction(ActionEvent event) {
        actiontarget.setText("Mostar");
    }

    public void handleActualizarButtonAction(ActionEvent event) {
        actiontarget.setText("Sea Actualizado");
    }

    public void handleEliminarButtonAction(ActionEvent event) {
        actiontarget.setText("Sea Eliminado");
    }
    @FXML
        public void RegresarAVerUR(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLVerPublicacionesParaUsu.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }
}
