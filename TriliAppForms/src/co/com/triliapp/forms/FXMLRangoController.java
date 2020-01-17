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
import co.com.triliapp.dto.Rango;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class FXMLRangoController {

    GestionDeUsuariosBL gestUsuario = new GestionDeUsuariosBL();
    Rango ranDto = new Rango();

    @FXML
    private TextField txtIdRango;
    @FXML
    private TextField txtNombreRango;
    @FXML
    private TextField txtDescripcionRango;
    @FXML
    private TextField txtImagenRango;
    @FXML
    private Text actiontarget;

    //================Alertas========================//
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Alert alertaError = new Alert(Alert.AlertType.ERROR);

    //=================================Funciones===============================//
    /**
     * Funcion Para Limpiar Los Campos Los Cuales Son (Nombre
     * Rango,Descripcion,Imagen).
     */
    @FXML
    public void limpiar(ActionEvent event) {
        txtIdRango.setText("");
        txtNombreRango.setText("");
        txtDescripcionRango.setText("");
        txtImagenRango.setText("");
    }

    /**
     * Funcion Para Mostrar mensaje de Rango Ingresado
     *
     */
    @FXML
    public void mensajeRangoIngresoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Rango Ingresado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rango Ingresado Incorrectamente (Nombre
     * Rango,Descripcion,Imagen).
     *
     */
    public void mensajeRangoIngresoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Rango No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rango Actualizado seleccionando el
     * boton"Actualizar"
     *
     */
    @FXML
    public void mensajeRangoActualizadaCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Rango Actualizado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rango Actualizada Incorrectamente (nombre
     * Rango)
     *
     */
    public void mensajeRolActuaizadoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Rango No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rango Eliminado seleccionando el
     * boton"Eliminar"
     *
     */
    @FXML
    public void mensajeRangoEliminadoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Rango Eliminado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Rango Eliminada Incorrectamente (nombre
     * Rango )
     *
     */
    public void mensajeRangoEliminadoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Rol No Eliminado Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Metodo Ingresar los campos requeridos son e(Nombre Rango, Imagen Rango y DescripcionRango), se ejecuta
     * despues de seleccionar e botton Ingresar
     */
    public void IngresarRango(ActionEvent event) throws Exception {
        ranDto.setNombreRango(txtNombreRango.getText());
        ranDto.setImagenRNG(txtImagenRango.getText());
        ranDto.setDescripcionRNG(txtDescripcionRango.getText());
        try {
            gestUsuario.IngresarRango(ranDto);
            limpiar(event);
            mensajeRangoIngresoCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeRangoIngresoInCorrecto(event);
        }
    }

    /**
     * Metodo Actualizar los campos requeridos son el ID del rango y el Nombre Del Rango, se ejecuta
     * despues de seleccionar e botton Actualizar
     */
    public void ActualizarRango(ActionEvent event) throws Exception {
        ranDto.setIdRango(Integer.parseInt(txtIdRango.getText()));
        ranDto.setNombreRango((txtNombreRango.getText()));
        try {
            gestUsuario.ActualizarRango(ranDto);
            mensajeRangoActualizadaCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeRolActuaizadoInCorrecto(event);
            e.getMessage();
        }
    }

    /**
     * Metodo eliminar los campos requeridos son el ID del rango, se ejecuta
     * despues de seleccionar e botton eliminar
     */
    public void EliminarRol(ActionEvent event) throws Exception {
        ranDto.setIdRango(Integer.parseInt(txtIdRango.getText()));
        try {
            gestUsuario.EliminarRango(ranDto);
            mensajeRangoEliminadoCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeRangoEliminadoInCorrecto(event);
            e.getMessage();
        }
    }

    @FXML
    public void RegresarRang(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminAdministrar.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");

        stage.show();
    }

}
