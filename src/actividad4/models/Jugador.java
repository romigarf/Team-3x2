package actividad4.models;

public class Jugador {

    private String nombre;
    private String marca;

    public Jugador(String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }
}
