/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.triliapp.forms;

import co.com.triliapp.bl.GestionDeUsuariosBL;
import co.com.triliapp.dto.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author yasuly
 */
public class FXMLRecuperarUsuarioController implements Initializable {
    
     GestionDeUsuariosBL gestionUsuarios = new GestionDeUsuariosBL();
     Usuario usuDTO = new Usuario();
    
    @FXML private TextField textFielCorreoUsu;
    @FXML private  TextField textFielContraseniaUsu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    /**
     * Metodo Para La navegacion entre formularios 
     * lo redirijira al formulario de login
     * @param event
     * @throws Exception 
     */

    public void RegresarLogRU(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLJoin.fxml"));
        Scene scene = new Scene(root, 466, 832);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setTitle("TriliAplicativo - Ingreso de sesion");
        stage.show();
    }
    /**
     * Metodo Para la recuperacion del NickName Del Usuario
     * los valores necesitados son 
     * correo del Usuario Registrado y contraseña del mismo
     * se buscara un usuario que coincida con estos dos datos
     * y se mostrará el Nickname del usuario correspondiente
     * @param event
     * @throws Exception 
     */
    
    public  void  RecuperarNickNameUsuario (ActionEvent event) throws  Exception {
        usuDTO.setCorreoUsu(textFielCorreoUsu.getText());
        usuDTO.setContraseniaUsu(textFielContraseniaUsu.getText());
        
        try {
            gestionUsuarios.RecuperarNickNameUsuario(usuDTO);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
