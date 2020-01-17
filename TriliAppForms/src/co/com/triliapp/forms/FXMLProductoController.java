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


public class FXMLProductoController {
    private Text actiontarget;
  
    public void AgregarUsuario(ActionEvent event) {
        actiontarget.setText("Calificacion Ingresada");
    }
    public void MostrarUsuario(ActionEvent event) {
        actiontarget.setText("Calificaciones");
    }
    public void ActualizacionUsuario(ActionEvent event) {
        actiontarget.setText("Calificacion Actualizada");
    }
    public void EliminarUsuario(ActionEvent event) {
        actiontarget.setText("Calificacion Eliminada");
    }
    @FXML
    public void RegresarProd(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminAdministrar.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");
        
        stage.show();
    }

}
