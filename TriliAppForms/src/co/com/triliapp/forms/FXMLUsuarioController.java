/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import co.com.triliapp.bl.GestionDeUsuariosBL;
import co.com.triliapp.dao.UsuarioDAO;
import co.com.triliapp.dto.Usuario;
import co.com.triliapp.dto.Rango;
import co.com.triliapp.dto.Rol;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
//=================================Funciones==================================//
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.SelectionMode;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author cerqu
 */
public class FXMLUsuarioController implements Initializable {

    GestionDeUsuariosBL gestUsuarios = new GestionDeUsuariosBL();
    Usuario usuDTO = new Usuario();
    Rango rangDTO = new Rango();
    Rol rolDTO = new Rol();

    //=============================Cajas de textos=======================//
    @FXML
    private TextField txtDisplayName;
    @FXML
    private TextField txtContraseniaUsuario;
    @FXML
    private TextField txtCorreoUsuario;
    @FXML
    private TextField txtImagenUsuario;
    @FXML
    private Text actiontarget;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    //================Alertas========================//
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Alert alertaError = new Alert(Alert.AlertType.ERROR);

    /**
     * Funcion Para Limpiar Los Campos Los Cuales Son (Nombre
     * Rango,Descripcion,Imagen).
     */
    @FXML
    public void limpiar(ActionEvent event) {
        txtDisplayName.setText("");
        txtContraseniaUsuario.setText("");
        txtCorreoUsuario.setText("");
        txtImagenUsuario.setText("");
    }

    /**
     * Funcion Para Mostrar mensaje de Registro Usuarios Ingresado correctamente
     * Valores A necesitar son (DyspalyName,Imagen,Correo y contraseña De
     * Usuario)
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
     * Funcion Para Mostrar mensaje de Registro Usuarios Ingresado
     * Incorrectamente (DyspalyName,Imagen,Correo y contraseña De Usuario)
     *
     */
    public void mensajeRegistroInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Registro No Realizado Faltan Campos");
        alertaError.showAndWait();
    }

    //=================================Funciones===============================//
    public void RegistroUsuario(ActionEvent event) throws Exception {

//        Integer RANGOVARIABLE = 1;
//        Integer ROLVARIABLE = 2;

        usuDTO.setDisplayName(txtDisplayName.getText());
        usuDTO.setImagenUsu(txtImagenUsuario.getText());
        usuDTO.setContraseniaUsu(txtContraseniaUsuario.getText());
        usuDTO.setCorreoUsu(txtCorreoUsuario.getText());
        //--------------------------------------------------------------------//
        rangDTO.setIdRango(1);
        rolDTO.setIdRol(1);
        
        usuDTO.setRango(rangDTO);
        usuDTO.setRol(rolDTO);

        try {
        gestUsuarios.IngresarUsuario(usuDTO);
        mensajeCategoriaIngresoCorrecto(event);
        limpiar(event);

        } catch (Exception e) {
        mensajeRegistroInCorrecto(event);
            e.getMessage();
        }

    }

    @FXML
    public void regresarMenu(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenuInicial.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Ingreso de sesion");

        stage.show();
    }
}
