package actividad4.process;

import actividad4.models.*;
import actividad4.ui.Language;
import java.util.List;
import java.util.Random;

/**
 * Controla la lógica principal del juego Tres en Raya, incluyendo turnos,
 * condiciones de victoria y movimientos de la CPU.
 */
public class JuegoController {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private boolean juegoTerminado = false;
    private boolean modoContraCPU = false;
    private Random random = new Random();
    private Language idioma;

    /**
     * Crea un nuevo controlador de juego con el idioma especificado.
     *
     * @param idioma objeto con las cadenas de texto según el idioma elegido
     */
    public JuegoController(Language idioma) {
        this.idioma = idioma;
        tablero = new Tablero();
        jugador1 = new Jugador(idioma.J1, "X");
        jugador2 = new Jugador(idioma.J2, "O");
        jugadorActual = jugador1;
    }

    /**
     * Configura si el juego se juega contra la computadora.
     *
     * @param activo true para activar modo contra CPU, false para dos jugadores
     */
    public void setModoContraCPU(boolean activo) {
        this.modoContraCPU = activo;
        if (activo) {
            jugador2 = new Jugador(idioma.CPU, "O");
        }
    }

    /**
     * Indica si el juego está en modo contra la computadora.
     *
     * @return true si se juega contra CPU
     */
    public boolean esModoContraCPU() {
        return modoContraCPU;
    }

    /**
     * Intenta realizar un movimiento para el jugador actual.
     *
     * @param fila    índice de fila (0-2)
     * @param columna índice de columna (0-2)
     * @return mensaje de estado o null si el movimiento no fue válido
     */
    public String jugar(int fila, int columna) {
        if (juegoTerminado) return null;
        boolean movimientoValido = tablero.colocarMarca(fila, columna, jugadorActual.getMarca());
        if (!movimientoValido) return null;
        return verificarEstadoJuego();
    }

    /**
     * Genera un movimiento aleatorio para la CPU.
     *
     * @return arreglo [fila, columna] del movimiento elegido, o null si no hay casillas libres
     */
    public int[] obtenerMovimientoCPU() {
        List<int[]> vacias = tablero.obtenerCasillasVacias();
        if (vacias.isEmpty()) return null;
        int indice = random.nextInt(vacias.size());
        return vacias.get(indice);
    }

    /**
     * Verifica el estado del juego después de un movimiento y genera el mensaje correspondiente.
     *
     * @return mensaje que describe el estado actual del juego
     */
    private String verificarEstadoJuego() {
        String ganador = tablero.verificarGanador();
        if (ganador != null) {
            juegoTerminado = true;
            return idioma.GANADOR + jugadorActual.getNombre();
        }
        if (tablero.hayEmpate()) {
            juegoTerminado = true;
            return idioma.EMPATE;
        }
        cambiarTurno();
        return idioma.JUGADOR1 + jugadorActual.getNombre();
    }

    /**
     * Cambia el turno al siguiente jugador.
     */
    private void cambiarTurno() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    /**
     * Obtiene la marca del jugador que tiene el turno actual.
     *
     * @return "X" o "O"
     */
    public String getMarcaActual() {
        return jugadorActual.getMarca();
    }

    /**
     * Obtiene el mensaje inicial que indica quién comienza.
     *
     * @return mensaje de turno inicial
     */
    public String getMensajeInicial() {
        return idioma.JUGADOR1 + jugadorActual.getNombre();
    }

    /**
     * Indica si el juego ya terminó (por victoria o empate).
     *
     * @return true si el juego ha finalizado
     */
    public boolean estaTerminado() {
        return juegoTerminado;
    }

    /**
     * Devuelve las coordenadas de la línea ganadora si existe un ganador.
     *
     * @return coordenadas de la línea ganadora o null
     */
    public int[][] obtenerLineaGanadora() {
        return tablero.getLineaGanadora();
    }

    /**
     * Reinicia el juego al estado inicial.
     */
    public void reiniciar() {
        tablero.limpiar();
        juegoTerminado = false;
        jugadorActual = jugador1;
        if (modoContraCPU) jugador2 = new Jugador(idioma.CPU, "O");
        else jugador2 = new Jugador(idioma.J2, "O");
    }
}