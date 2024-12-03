package modelo;
public class Juego {
    private int idJuego;
    private String nombreJuego;
    private double precio;

    public Juego(int idJuego, String nombreJuego, double precio) {
        this.idJuego = idJuego;
        this.nombreJuego = nombreJuego;
        this.precio = precio;
    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombreJuego() {
        return nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Juego{" + "idJuego=" + idJuego + ", nombreJuego=" + nombreJuego + ", precio=" + precio + '}';
    }
    
    
}
