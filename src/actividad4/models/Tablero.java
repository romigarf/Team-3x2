package actividad4.models;
import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private String[][] tablero = new String[3][3];
    private int[][] lineaGanadora = null;

    public Tablero() {reiniciar();
    }

    public void reiniciar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "";
            }
        }
        lineaGanadora = null;
    }

    public boolean colocarMarca(int fila, int columna, String marca) {
        if (tablero[fila][columna].equals("")) {
            tablero[fila][columna] = marca;
            return true;
        }
        return false;
    }

    public String getMarca(int fila, int columna) {
        return tablero[fila][columna];
    }

    public List<int[]> obtenerCasillasVacias() {
        List<int[]> vacias = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("")) {
                    vacias.add(new int[]{i, j});
                }
            }
        }
        return vacias;
    }

    public String verificarGanador() {
        // Verificar Filas
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("") &&
                    tablero[i][0].equals(tablero[i][1]) &&
                    tablero[i][1].equals(tablero[i][2])) {
                lineaGanadora = new int[][]{{i,0}, {i,1}, {i,2}};
                return tablero[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!tablero[0][i].equals("") &&
                    tablero[0][i].equals(tablero[1][i]) &&
                    tablero[1][i].equals(tablero[2][i])) {
                lineaGanadora = new int[][]{{0,i}, {1,i}, {2,i}};
                return tablero[0][i];
            }
        }

        if (!tablero[0][0].equals("") &&
                tablero[0][0].equals(tablero[1][1]) &&
                tablero[1][1].equals(tablero[2][2])) {
            lineaGanadora = new int[][]{{0,0}, {1,1}, {2,2}};
            return tablero[0][0];
        }

        if (!tablero[0][2].equals("") &&
                tablero[0][2].equals(tablero[1][1]) &&
                tablero[1][1].equals(tablero[2][0])) {
            lineaGanadora = new int[][]{{0,2}, {1,1}, {2,0}};
            return tablero[0][2];
        }

        return null;
    }

    public int[][] getLineaGanadora() {
        return lineaGanadora;
    }

    public boolean hayEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
}

