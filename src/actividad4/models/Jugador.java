package actividad4.models;

/**
 * Representa a un jugador en el juego de Tres en Raya (Tic-Tac-Toe).
 */
public class Jugador {
    private String nombre;
    private String marca;

    /**
     * Crea un nuevo jugador con el nombre y la marca indicados.
     *
     * @param nombre el nombre del jugador
     * @param marca  la marca que usará el jugador ("X" o "O")
     */
    public Jugador(String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la marca que usa el jugador.
     *
     * @return la marca del jugador ("X" o "O")
     */
    public String getMarca() {
        return marca;
    }
}
