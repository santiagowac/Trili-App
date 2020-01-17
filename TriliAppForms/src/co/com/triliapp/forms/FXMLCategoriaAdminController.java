/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import co.com.triliapp.bl.GestionDeProductos;
import co.com.triliapp.dto.Categoria;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yasuly
 */
public class FXMLCategoriaAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   //---------Instancia de la clase BC-------//
    GestionDeProductos getsProductos = new GestionDeProductos();
    Categoria catDTO = new Categoria();

    //================Alertas========================//
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Alert alertaError = new Alert(Alert.AlertType.ERROR);

    //Declaracion de cajas de textos//
    /**
     * Caja de texto donde se ingresa el id para porder actualizar el objeto
     * prueba de comentarios
     *
     * @param event
     */
    @FXML
    private TextField txtIdCategoria;
    @FXML
    private TextField txtNombreCategoria;
    @FXML
    private Text actiontarget;

    //=================================Funciones===============================//
    /**
     * Funcion Para Limpiar Los Campos Los Cuales Son (Nombre
     * Rango,Descripcion,Imagen).
     */
    @FXML
    public void limpiar(ActionEvent event) {
        txtIdCategoria.setText("");
        txtNombreCategoria.setText("");

    }

    /**
     * Funcion Para Mostrar mensaje de Categoria Ingresado seleccionando el
     * boton"Ingresar"
     *
     */
    @FXML
    public void mensajeCategoriaIngresoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Categoria Ingresada");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Categoria Ingresada Incorrectamente
     * (nombre Categoria)
     *
     */
    public void mensajeCategoriaIngresoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Categoria No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Categoria Actualizada seleccionando el
     * boton"Actualizar"
     *
     */
    @FXML
    public void mensajeCategoriaActualizadaCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Categoria Actualizado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Categoria Actualizada Incorrectamente
     * (nombre Categoria y colocar el id de la categgoria para referenciar)
     *
     */
    public void mensajeCategoriaActuaizadoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Categoria No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Categoria Eliminado seleccionando el
     * boton"Eliminar"
     *
     */
    @FXML
    public void mensajeCategoriaEliminadoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Categoria Eliminado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de Categoria Eliminada Incorrectamente
     * (nombre Categoria )
     *
     */
    public void mensajeCategoriaEliminadoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Categoria No Eliminado Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Agregar" prueba de
     * comentarios
     *
     * @param event
     */
    public void AgregarCategoria(ActionEvent event) throws Exception {
        catDTO.setNombreCategoria(txtNombreCategoria.getText());
        try {
            getsProductos.IngresarCategoria(catDTO);
            mensajeCategoriaIngresoCorrecto(event);
            limpiar(event);

        } catch (Exception e) {
            mensajeCategoriaIngresoInCorrecto(event);
            e.getMessage();
        }

    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Agregar" Funciona
     * para poder mostrar los objetos de esta clase en un combo box
     *
     * @param event
     */
    public void MostrarCategoria(ActionEvent event) {
        actiontarget.setText("Categoria");
    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Actualizar"
     * Actualiza los elementos de una categora ingresando el Nombre de la
     * categoria a ingresar
     *
     * @param event
     */
    public void ActualizacionCategoria(ActionEvent event) throws Exception {
        catDTO.setIdCategoria(Integer.parseInt(txtIdCategoria.getText()));
        catDTO.setNombreCategoria(txtNombreCategoria.getText());
        try {
            getsProductos.ActualizarCategoria(catDTO);
            mensajeCategoriaActualizadaCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeCategoriaIngresoInCorrecto(event);
            e.getMessage();
        }

    }

    /**
     * Método que realiza las acciones tras pulsar el boton "Eliminar" Función
     * de eliminar cateegorias dependiendo la id de la misma colocando en la
     * caja de texto de la categria el id de la categoria a eliminar
     *
     * @param event
     */
    public void EliminarCategoria(ActionEvent event) throws Exception {
        catDTO.setIdCategoria(Integer.parseInt(txtIdCategoria.getText()));
        try {
            getsProductos.EliminarCategoria(catDTO);
            mensajeCategoriaEliminadoCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeCategoriaEliminadoInCorrecto(event);
            e.getMessage();
        }
    }

    private void RegresarAVerCU(ActionEvent event) {
    }

    public void RegresarCat(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminAdministrar.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");

        stage.show();
    }

}
