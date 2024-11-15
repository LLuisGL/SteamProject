package com.mycompany.steamproject;

import com.mycompany.steamproject.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioController {
    DBConnection connection = new DBConnection();
    public int readByUserActive(){
        connection.conectar();
        String req = "SELECT * FROM usuario WHERE activo = 1";
        int id = 0;
        PreparedStatement stmt;
        try {
            stmt = this.connection.getConnection().prepareStatement(req);
            ResultSet rss = stmt.executeQuery();
            while(rss.next()){
                id = rss.getInt("id");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            connection.desconectar();
        }
        return id;
    }
    public boolean ValidacionRegistro(String user){
        this.connection.conectar();
        String req = "SELECT username FROM usuario WHERE username = ?";

        try{
            PreparedStatement stmt = this.connection.getConnection().prepareStatement(req);
            stmt.setString(1, user );
            ResultSet result = stmt.executeQuery();
            System.out.println(" retorno");

            return result.next();

        }catch(SQLException e){
              e.printStackTrace();
              return false;
        }finally {
            connection.desconectar();
        }
    }
    public boolean Registro(String user, String password){
        String req = "INSERT INTO usuario (username, contrasena) VALUES (?, ?)";
         try{
            this.connection.conectar();
            PreparedStatement  stmt = this.connection.getConnection().prepareStatement(req);
            stmt.setString(1, user.trim());
            stmt.setString(2, password.trim());
            stmt.executeUpdate();
       
            return true;  
        } catch (Exception e) {
        e.printStackTrace();
        System.out.println("no");
        }finally {
            connection.desconectar();
        }
        return false;
    }
    public boolean Validacion(String user, String password){
        String req = "SELECT * FROM Usuario WHERE nombreUsuario = ? AND  password = ?";
        try{
            this.connection.conectar();
            PreparedStatement  stmt = this.connection.getConnection().prepareStatement(req);
            stmt.setString(1, user);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next();  
        } catch (Exception e) {
        e.printStackTrace();
        } finally {
            connection.desconectar();
        }
        return false;
    }
    public String SesionIniciadaU(){
        this.connection.conectar();
        String nombreUsuaI = "";
        String req = "SELECT nombreUsuario FROM Usuario WHERE activo = 1";
        
        try{
            PreparedStatement stmt = this.connection.getConnection().prepareStatement(req);
            ResultSet result = stmt.executeQuery();
            
            if(result.next()){
                nombreUsuaI = result.getString("nombreUsuario");
            }
            
        }catch(SQLException e){
              throw new RuntimeException();
        }finally {
            connection.desconectar();
        }
        System.out.println(nombreUsuaI);
        return nombreUsuaI;
    }
}
