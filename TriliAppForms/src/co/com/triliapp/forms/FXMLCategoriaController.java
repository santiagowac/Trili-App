/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
//=========================Proyectos==========================================//
import co.com.triliapp.bl.GestionDeProductos;
import co.com.triliapp.dto.Categoria;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//=========================Cajas de textos y funciones========================//
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLCategoriaController {

    //---------Instancia de la clase BC-------//
    GestionDeProductos getsProductos = new GestionDeProductos();
    Categoria catDTO = new Categoria();


    //Declaracion de cajas de textos//
    /**
     * Caja de texto donde se ingresa el id para porder actualizar el objeto
     * prueba de comentarios
     *
     * @param event
     */
    private TextField txtIdCategoria;

    private TextField txtNombreCategoria;

    private Text actiontarget;

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
            txtNombreCategoria.setText("");
            actiontarget.setText("Categoria Ingresada");
        } catch (Exception e) {
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
            actiontarget.setText("Categoria Actualizada");
        } catch (Exception e) {
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
            actiontarget.setText("Categoria Eliminada");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void RegresarCategoria(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuario.fxml"));
        Scene scene = new Scene(root, 550, 550);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("Usuario");
        
        stage.show();
    }

    @FXML
    private void RegresarAVerCU(ActionEvent event) {
    }

}
