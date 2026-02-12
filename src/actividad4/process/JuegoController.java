package actividad4.process;
import actividad4.models.*;

public class JuegoController {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private boolean juegoTerminado = false;

    public JuegoController() {
        tablero = new Tablero();
        jugador1 = new Jugador("Jugador 1", "X");
        jugador2 = new Jugador("Jugador 2", "O");
        jugadorActual = jugador1;
    }

    public String jugar(int fila, int columna) {

        if (juegoTerminado) return null;

        boolean movimientoValido = tablero.colocarMarca(fila, columna, jugadorActual.getMarca());

        if (!movimientoValido) return null;

        String ganador = tablero.verificarGanador();

        if (ganador != null) {
            juegoTerminado = true;
            return "Ganador: " + jugadorActual.getNombre();
        }

        if (tablero.hayEmpate()) {
            juegoTerminado = true;
            return "Empate";
        }

        cambiarTurno();
        return "Turno de " + jugadorActual.getNombre();
    }

    private void cambiarTurno() {
        if (jugadorActual == jugador1) {
            jugadorActual = jugador2;
        } else {
            jugadorActual = jugador1;
        }
    }

    public String getMarcaActual() {
        return jugadorActual.getMarca();
    }

    public boolean estaTerminado() {
        return juegoTerminado;
    }
}
