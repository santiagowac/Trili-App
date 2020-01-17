/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import co.com.triliapp.bl.GestionDeUsuariosBL;
import co.com.triliapp.dto.Rango;
import co.com.triliapp.dto.Rol;
import co.com.triliapp.dto.Usuario;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yasuly
 */
public class FXMLUsuarioAdminController implements Initializable {

    //    /**
//     * Initializes the controller class.
//     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }
    GestionDeUsuariosBL gestUsuarios = new GestionDeUsuariosBL();
    Usuario usuDTO = new Usuario();
    Rango rangDTO = new Rango();
    Rol rolDTO = new Rol();

    //=============================Cajas de textos y cb=======================//
    @FXML
    private TextField txtIdUsuario;
    @FXML
    private TextField txtDisplayName;
    @FXML
    private TextField txtContraseniaUsuario;
    @FXML
    private TextField txtCorreoUsuario;
    @FXML
    private TextField txtExperienciaUsuario;
    @FXML
    private TextField txtImagenUsuario;
    @FXML
    private TextField txtEstadoUsuario;

    //==========================Combo Box=====================================//
    @FXML
    private ComboBox<?> cbbfkRangoUsuario;
    @FXML
    private ComboBox<?> cbbFkRolUsuario;
    @FXML
    private Text actiontarget;

    //================Alertas========================//
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Alert alertaError = new Alert(Alert.AlertType.ERROR);

    //===================LLamar objetos externos y mostrarlos en CB===========//
    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resourses) {

        GestionDeUsuariosBL gestUsuarios = new GestionDeUsuariosBL();
        //===========================Rango Objetos============================//
        List listaRangos = new ArrayList<String>();
        for (Rango r : gestUsuarios.listarRangos()) {
            listaRangos.add((r.getIdRango() + "-" + r.getNombreRNG()));
            Integer A = r.getIdRango();
            String B = r.getNombreRNG();
            String string = (A + "-" + B);
            String[] parts = string.split("-");
            String part1 = parts[0]; // ID
            String part2 = parts[1]; // Rango

        }
        cbbfkRangoUsuario.getItems().clear();
        cbbfkRangoUsuario.getItems().addAll(listaRangos);

        List listaRoles = new ArrayList<String>();
        for (Rol rol : gestUsuarios.listarRoles()) {
            listaRoles.add(rol.getIdRol() + "-" + rol.getNombreRL());
            cbbFkRolUsuario.getItems().clear();
            cbbFkRolUsuario.getItems().addAll(listaRoles);
        }

    }

    //=================================Funciones===============================//
    /**
     * Funcion Para Limpiar Los Campos Los Cuales Son
     * (DisPlay,Contrasenia,Correo,Imagen,Experiencia).
     */
    @FXML
    public void limpiar(ActionEvent event) {
        txtDisplayName.setText("");
        txtContraseniaUsuario.setText("");
        txtCorreoUsuario.setText("");
        txtImagenUsuario.setText("");
        txtExperienciaUsuario.setText("");
    }

    /**
     * Funcion Para Mostrar mensaje de usuarioIngreso
     *
     */
    @FXML
    public void mensajeIngresoCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Usuario Ingresado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de usuarioIngreso Incorrecto
     *
     */
    public void mensajeIngresoInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Usuario No Ingresasdo Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de usuario Eliminado Correctamente (Campos
     * DisplayName)
     *
     */
    @FXML
    public void mensajeEliminacionUsuarioCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Usuario Eliminado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de usuario Eliminado Incorrecto (Campos
     * DisplayName)
     *
     */
    @FXML
    public void mensajeEliminacionUsuarioInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Usuario No Eliminado Falta Campos");
        alertaError.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de usuario Actualizado Correctamente (Imagen
     * DisplayName,Contraseña,CorreoUsu,ExperienciaUsu y colocar el id Usuario
     * para referenciar cual usuario actualizar)
     *
     */
    @FXML
    public void mensajeActualizacionUsuarioCorrecto(ActionEvent event) {
        alerta.setTitle("Information Dialog");
        alerta.setHeaderText(null);
        alerta.setContentText("Usuario Actualizado");
        alerta.showAndWait();
    }

    /**
     * Funcion Para Mostrar mensaje de usuario Actualizado InCorrectamente
     * Faltan campos(Imagen DisplayName,Contraseña,CorreoUsu,ExperienciaUsu y
     * colocar el id Usuario para referenciar cual usuario actualizar)
     *
     */
    @FXML
    public void mensajeActualizarUsuarioInCorrecto(ActionEvent event) {
        alertaError.setTitle("Error Dialog");
        alertaError.setContentText("Usuario No Actualizado Falta Campos");
        alertaError.showAndWait();
    }

    @FXML
    public void IngresarUsuario(ActionEvent event) throws Exception {

        usuDTO.setDisplayName(txtDisplayName.getText());
        usuDTO.setContraseniaUsu(txtContraseniaUsuario.getText());
        usuDTO.setCorreoUsu(txtCorreoUsuario.getText());
//        usuDTO.setExperienciaUsu(Integer.parseInt(txtExperienciaUsuario.getText()));

        //============================Ingresar objetos rol y rango============//
        String comboRol = cbbFkRolUsuario.getSelectionModel().getSelectedItem().toString();
        String comboRango = cbbfkRangoUsuario.getSelectionModel().getSelectedItem().toString();

        rolDTO.setIdRol(Integer.parseInt(comboRol.split("-")[0].trim()));
        usuDTO.setRol(rolDTO);
        rangDTO.setIdRango(Integer.parseInt(comboRango.split("-")[0].trim()));
        usuDTO.setRango(rangDTO);

        //====================================================================//
        usuDTO.setImagenUsu(txtImagenUsuario.getText());

        //================Para Imprimir el valor el combobox===================//
//        String rol = ((cbbFkRolUsuario.getSelectionModel().getSelectedItem().toString()));
//      usuDTO.setRol(rol);
//        String rango = ((cbbfkRangoUsuario.getSelectionModel().getSelectedItem().toString()));
//        rangDTO.setIdRango(Integer.parseInt(cbbfkRangoUsuario.getSelectionModel().getSelectedItem().toString()));
//        usuDTO.setRango(rangDTO);
//        rolDTO.setIdRol(Integer.parseInt(cbbfkRangoUsuario.getSelectionModel().getSelectedItem().toString()));
//        usuDTO.setRol(rolDTO);
//        actiontarget.setText(a);
        //====================================================================//
//        usuDTO.setRol(rolCBB);
//        usuDTO.setRango(rangCBB);
//        usuDTO.setRango((Rango) cbbfkRangoUsuario.getItems());
//        usuDTO.setRol((Rol) cbbFkRolUsuario.getItems());
//        //usuDTO.setRang0(cbbFkRolUsuario.getItems(cbbFkRolUsuario.getSelectionModel().select(c);
        try {
            gestUsuarios.IngresarUsuario(usuDTO);
            mensajeIngresoCorrecto(event);
            limpiar(event);
//            actiontarget.setText("Usuario Ingresado");
        } catch (Exception e) {
            mensajeIngresoInCorrecto(event);
            e.getMessage();
        }

    }

    @FXML
    public void MostrarUsuario(ActionEvent event) throws Exception {
        usuDTO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
        usuDTO.setDisplayName(txtDisplayName.getText());
        usuDTO.setContraseniaUsu(txtContraseniaUsuario.getText());
        usuDTO.setCorreoUsu(txtCorreoUsuario.getText());
        usuDTO.setExperienciaUsu(Integer.parseInt(txtExperienciaUsuario.getText()));

        String rolCBB = cbbFkRolUsuario.getSelectionModel().getSelectedItem().toString();
        String rangCBB = cbbfkRangoUsuario.getSelectionModel().getSelectedItem().toString();

        //================================Fk==================================//
        //  usuDTO.getRango().setIdRango(Integer.parseInt(cbbfkRangoUsuario.select()));
        try {

        } catch (Exception e) {
        }

    }

    @FXML
    public void ActualizarUsuario(ActionEvent event) throws Exception {
        usuDTO.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
        usuDTO.setDisplayName(txtDisplayName.getText());
        usuDTO.setContraseniaUsu(txtContraseniaUsuario.getText());
        usuDTO.setCorreoUsu(txtCorreoUsuario.getText());
        usuDTO.setExperienciaUsu(Integer.parseInt(txtExperienciaUsuario.getText()));
        usuDTO.setImagenUsu(txtImagenUsuario.getText());
        usuDTO.setEstadoUsuario(txtEstadoUsuario.getText());

        if (txtContraseniaUsuario.getText().equals("") && txtCorreoUsuario.getText().equals("") && txtImagenUsuario.getText().equals("") && txtEstadoUsuario.getText().equals("")) {

            try {
                gestUsuarios.ActualizarNombreUsuario(usuDTO);
                mensajeActualizacionUsuarioCorrecto(event);
                limpiar(event);
            } catch (Exception e) {
                mensajeActualizarUsuarioInCorrecto(event);
                e.getMessage();
            }

        } else if (txtEstadoUsuario.getText().equals("") && txtDisplayName.getText().equals("") && txtContraseniaUsuario.getText().equals("") && txtCorreoUsuario.getText().equals("") && txtExperienciaUsuario.getText().equals(0) && txtImagenUsuario.getText().equals("")) {
            try {
                gestUsuarios.ActualizarExperienciaUsuario(usuDTO);
                mensajeActualizacionUsuarioCorrecto(event);
                limpiar(event);
            } catch (Exception e) {
                mensajeActualizarUsuarioInCorrecto(event);
                e.getMessage();
            }
        } else {
            try {
                gestUsuarios.ActualizarUsuario(usuDTO);
                mensajeActualizacionUsuarioCorrecto(event);
                limpiar(event);
            } catch (Exception e) {
                mensajeActualizarUsuarioInCorrecto(event);
                e.getMessage();
            }
        }

    }

    @FXML
    public void EliminarUsuarioPorNombre(ActionEvent event) throws Exception {
        usuDTO.setDisplayName(txtDisplayName.getText());
        try {
            gestUsuarios.EliminarUsuarioPorNombre(usuDTO);
            mensajeEliminacionUsuarioCorrecto(event);
            limpiar(event);
        } catch (Exception e) {
            mensajeEliminacionUsuarioInCorrecto(event);
            e.getMessage();
        }
    }

    public void RegresarUsu(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminAdministrar.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Administrar");

        stage.show();
    }
}
