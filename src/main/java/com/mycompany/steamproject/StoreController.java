package com.mycompany.steamproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Juego;

public class StoreController implements Initializable{
    @FXML
    private Button btnStore;

    @FXML
    private HBox hboxJuegos;

    @FXML
    private Button txtNombre;
    
    UsuarioController usuDB = new UsuarioController();
    JuegoController juegoDB = new JuegoController();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hboxJuegos.setStyle("-fx-background-color: blue;");
        String nombreUsuario = usuDB.SesionIniciadaU();
        txtNombre.setText(nombreUsuario.toUpperCase());
        
        ArrayList<Juego> juegos = new ArrayList<>();
        juegos = juegoDB.readJuego();
        for(Juego juego: juegos){
            VBox vboxJuego = new VBox();
            vboxJuego.setStyle("-fx-background-color: red;");
            Label nombreJuego = new Label();
            Label precioJuego = new Label();
            Button botonComprar = new Button("Comprar");
            
            nombreJuego.setText(juego.getNombreJuego());
            precioJuego.setText(String.valueOf(juego.getPrecio()));
            
            vboxJuego.getChildren().addAll(nombreJuego, precioJuego, botonComprar);
            
            hboxJuegos.getChildren().add(vboxJuego);
        }
    }
    
}
