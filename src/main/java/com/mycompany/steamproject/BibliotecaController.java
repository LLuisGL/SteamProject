package com.mycompany.steamproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class BibliotecaController implements Initializable{
    @FXML
    private Button txtNombre;
    
    UsuarioController usuDB = new UsuarioController();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String nombreUsuario = usuDB.SesionIniciadaU();
        txtNombre.setText(nombreUsuario.toUpperCase());
    }
    
    
    
}
