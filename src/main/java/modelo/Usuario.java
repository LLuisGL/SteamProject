package modelo;
public class Usuario {
    private int id;
    private String nombreU;
    private String passwordU;
    private int activo;
    
    public Usuario(int id, String nombreU, String passwordU, int activo){
        this.id = id;
        this.nombreU = nombreU;
        this.passwordU = passwordU;
        this.activo = activo;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreU() {
        return nombreU;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }
    
    
}
