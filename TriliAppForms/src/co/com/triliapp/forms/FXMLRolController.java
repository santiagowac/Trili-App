/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;

//============================================================================//
import co.com.triliapp.bl.GestionDeUsuariosBL;
import co.com.triliapp.dto.Rol;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class FXMLRolController {

    GestionDeUsuariosBL gestUsuarios = new GestionDeUsuariosBL();
    Rol rolDTO = new Rol();
    //================Alertas========================//
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Alert alertaError = new Alert(Alert.AlertType.ERROR);

    //================================Cajas De Texto==========================//
    @FXML
    private TextField txtIdRol;
    @FXML
    private TextField txtNombreRol;
    @FXML
    private Text actiontarget;

    //=================================Funciones===============================//
    /**
     * Funcion Para Limpiar Los Campos Los Cuales Son (Nombre
     * Rango,Descripcion,Imagen).
     */
    @FXML
    public void limpiar(ActionEvent event) {
        txtIdRol.setText("");
        txtNombreRol.setText("");
    }

    /**
     * Funcion Para Mostrar mensaje de Rolr Ingresado seleccionando el
     * boton"Ingresar"
     *
     */
    @FXML
    public void mensajeTRonlIngresoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Rol Ingresado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rol Ingresado Incorrectamente (nombre
     * Rol)
     *
     */
    public void mensajeRolIngresoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Rol No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rol Actualizado seleccionando el
     * boton"Actualizar"
     *
     */
    @FXML
    public void mensajeRolActualizadaCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Rol Actualizado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rol Actualizada Incorrectamente (nombre
     * Rol)
     *
     */
    public void mensajeRolActuaizadoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Rol No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rol Eliminado seleccionando el
     * boton"Eliminar"
     *
     */
    @FXML
    public void mensajeRolEliminadoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Rol Eliminado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rol Eliminada Incorrectamente (nombre Rol
     * )
     *
     */
    public void mensajeRolEliminadoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Rol No Eliminado Falta Campos");
        alertaError.showAndWait();
    }

    public void IngresarRol(ActionEvent event) throws Exception {
        rolDTO.setNombreRL((txtNombreRol.getText()));
        try {
            gestUsuarios.IngresarRol(rolDTO);
            mensajeTRonlIngresoCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeRolIngresoInCorrecto(event);
            e.getMessage();
        }

    }

    public void MostrarRol(ActionEvent event) throws Exception {
        rolDTO.setNombreRL((txtNombreRol.getText()));
        try {
            gestUsuarios.listarRoles();
            actiontarget.setText("Mostrar");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void ActualizarRol(ActionEvent event) throws Exception {
        rolDTO.setIdRol(Integer.parseInt(txtIdRol.getText()));
        rolDTO.setNombreRL((txtNombreRol.getText()));
        try {
            gestUsuarios.ActualizarRol(rolDTO);
            mensajeRolActualizadaCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeRolActuaizadoInCorrecto(event);
            e.getMessage();
        }
    }

    public void EliminarRol(ActionEvent event) throws Exception {
        rolDTO.setIdRol(Integer.parseInt(txtIdRol.getText()));
        try {
            gestUsuarios.EliminarRol(rolDTO);
            mensajeRolEliminadoCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeRolEliminadoInCorrecto(event);
            e.getMessage();
        }
    }

    @FXML
    public void RegresarRol(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminAdministrar.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");

        stage.show();
    }
}
