package com.mycompany.steamproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BibliotecaController implements Initializable{
    @FXML
    private Button txtNombre;
    
    @FXML
    private Button btnStore;
    
    UsuarioController usuDB = new UsuarioController();
    
    public void switchToStore(ActionEvent event) throws IOException{
         Parent root = FXMLLoader.load(getClass().getResource("Store.fxml"));
         Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
         Scene scene = new Scene(root, 1400, 800);
         window.setTitle("Steam.exe");
         window.setX(300);
         window.setScene(scene);
         window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String nombreUsuario = usuDB.SesionIniciadaU();
        txtNombre.setText(nombreUsuario.toUpperCase());
    }
    
    
    
}
