package com.mycompany.steamproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    
    UsuarioController usuController = new UsuarioController();
    
    @FXML
    private Button btnCerrar;

    @FXML
    private Button btnSignIn;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtUsuario;

    
    @FXML
    private void close(){
        System.exit(0);
    }
    
    @FXML
    private void login(ActionEvent event){
        
        String nombreUsuario = txtUsuario.getText();
        String passwordUsuario = txtContrasenia.getText();
        
        boolean validacion = usuController.Validacion(nombreUsuario, passwordUsuario);
        
        if(validacion == true){
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Biblioteca.fxml"));
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root, 1400, 800);
                window.setTitle("Steam.exe");
                window.setX(300);
                window.setScene(scene);
                window.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else{
            System.out.println("No inicia sesion");
        }
        
        
        
    }
}
