package actividad4.process;
import actividad4.models.*;
import actividad4.ui.Language;
import java.util.List;
import java.util.Random;

public class JuegoController {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private boolean juegoTerminado = false;
    private boolean modoContraCPU = false;
    private Random random = new Random();

    public JuegoController() {
        tablero = new Tablero();
        // Usamos Language.get() para los nombres
        jugador1 = new Jugador(Language.get("PLAYER_1"), "X");
        jugador2 = new Jugador(Language.get("PLAYER_2"), "O");
        jugadorActual = jugador1;
    }

    public void setModoContraCPU(boolean activo) {
        this.modoContraCPU = activo;
        if (activo) {
            // Si es CPU, usamos el nombre traducido para la CPU
            jugador2 = new Jugador(Language.get("CPU"), "O");
        }
    }

    public boolean esModoContraCPU() {
        return modoContraCPU;
    }

    public String jugar(int fila, int columna) {
        if (juegoTerminado) return null;

        boolean movimientoValido = tablero.colocarMarca(fila, columna, jugadorActual.getMarca());
        if (!movimientoValido) return null;

        return verificarEstadoJuego();
    }

    public int[] obtenerMovimientoCPU() {
        List<int[]> vacias = tablero.obtenerCasillasVacias();
        if (vacias.isEmpty()) return null;
        int indiceAleatorio = random.nextInt(vacias.size());
        return vacias.get(indiceAleatorio);
    }

    private String verificarEstadoJuego() {
        String ganador = tablero.verificarGanador();

        if (ganador != null) {
            juegoTerminado = true;
            // Mensaje traducido
            return Language.get("WINNER") + jugadorActual.getNombre();
        }

        if (tablero.hayEmpate()) {
            juegoTerminado = true;
            // Mensaje traducido
            return Language.get("DRAW");
        }

        cambiarTurno();
        return Language.get("TURN") + jugadorActual.getNombre();
    }

    private void cambiarTurno() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }

    public String getMarcaActual() {
        return jugadorActual.getMarca();
    }

    public String getMensajeInicial() {
        return Language.get("TURN") + jugadorActual.getNombre();
    }

    public boolean estaTerminado() {
        return juegoTerminado;
    }

    public int[][] obtenerLineaGanadora() {
        return tablero.getLineaGanadora();
    }
}