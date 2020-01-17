/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import co.com.triliapp.bl.GestionDeUsuariosBL;
import co.com.triliapp.dto.Usuario;
import java.sql.SQLException;
import javafx.scene.control.TextField;

//============================================================================//
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Alejandro
 */
public class FXMLJoinController {

    GestionDeUsuariosBL gestUsuarios = new GestionDeUsuariosBL();
    Usuario usuDTO = new Usuario();

    //================Alertas========================//
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    Alert alertaError = new Alert(AlertType.ERROR);

    //=============================Cajas de textos y cb=======================//
    @FXML
    private TextField txtLoginNickName;
    @FXML
    private PasswordField PSSWContrasenia;

    @FXML
    private Text actiontarget;

    @FXML
    private void Logearse(ActionEvent event) throws IOException, SQLException {

        usuDTO.setDisplayName(txtLoginNickName.getText());
        usuDTO.setContraseniaUsu((PSSWContrasenia.getText()));
        //====================================================================//

//        if(gestUsuarios.login(usuDTO)) {
        try {
            gestUsuarios.login(usuDTO);
            alerta.setTitle("Information Dialog");
            alerta.setHeaderText(null);
            alerta.setContentText("Ingreso correctamente");
            alerta.showAndWait();

//            actiontarget.setText("Usuario Ingresado");
            Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuarioAdminInicio.fxml"));
            Scene scene = new Scene(root, 466, 832);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.hide();
            stage.setScene(scene);
            stage.setTitle("Usuario");

            stage.show();
            return;

        } catch (Exception e) {
            alertaError.setTitle("Error Dialog");
            alertaError.setContentText("usuario o clave incorrecto");
            alertaError.showAndWait();
        }
    }

    @FXML
    public void regresarMenu(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenuInicial.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Menu");
        stage.close();
        stage.show();
    }

    public void registrarse(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLUsuario.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Registro");

        stage.show();
    }

    public void irARecuperarU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRecuperarUsuario.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Proseso de Recuperacion");

        stage.show();
    }

    public void irARecuperarC(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLRecuperarContraseña.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Proseso de Recuperacion");

        stage.show();
    }
}
