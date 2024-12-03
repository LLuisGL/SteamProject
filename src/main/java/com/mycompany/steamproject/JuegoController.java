package com.mycompany.steamproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Juego;

public class JuegoController {
    DBConnection connection = new DBConnection();
    public ArrayList<Juego> readJuego(){
        connection.conectar();
        String req = "SELECT * FROM Juego";
        PreparedStatement stmt;
        ArrayList<Juego> juegos = new ArrayList<>();
        try {
            stmt = this.connection.getConnection().prepareStatement(req);
            ResultSet rss = stmt.executeQuery();
            while(rss.next()){
                int idJuego = rss.getInt("IDJuego");
                String nombreJuego = rss.getString("Descripcion");
                double precio = rss.getDouble("Precio");
                Juego juego = new Juego(idJuego, nombreJuego, precio);
                juegos.add(juego);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.desconectar();
        }
        return juegos;
    }
}
