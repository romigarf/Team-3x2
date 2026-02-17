package actividad4.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa el tablero de juego de Tres en Raya (3x3).
 */
public class Tablero {

    private String[][] celdas = new String[3][3];
    private int[][] lineaGanadora = null;

    /**
     * Crea un tablero nuevo y vacío.
     */
    public Tablero() {
        limpiar();
    }

    /**
     * Coloca una marca en la posición indicada si la celda está vacía.
     *
     * @param fila    índice de la fila (0-2)
     * @param columna índice de la columna (0-2)
     * @param marca   la marca a colocar ("X" o "O")
     * @return true si se pudo colocar la marca, false si la celda ya estaba ocupada
     */
    public boolean colocarMarca(int fila, int columna, String marca) {
        if (celdas[fila][columna].equals("")) {
            celdas[fila][columna] = marca;
            return true;
        }
        return false;
    }

    /**
     * Devuelve una lista con todas las casillas vacías del tablero.
     *
     * @return lista de arreglos int[] con [fila, columna] de cada casilla vacía
     */
    public List<int[]> obtenerCasillasVacias() {
        List<int[]> vacias = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (celdas[i][j].equals("")) vacias.add(new int[]{i, j});
            }
        }
        return vacias;
    }

    /**
     * Verifica si hay un ganador en el tablero.
     * Si existe ganador, guarda las coordenadas de la línea ganadora.
     *
     * @return la marca del ganador ("X" o "O"), o null si aún no hay ganador
     */
    public String verificarGanador() {
        // Filas
        for (int i = 0; i < 3; i++) {
            if (!celdas[i][0].equals("") && celdas[i][0].equals(celdas[i][1]) && celdas[i][1].equals(celdas[i][2])) {
                lineaGanadora = new int[][]{{i,0},{i,1},{i,2}};
                return celdas[i][0];
            }
        }
        // Columnas
        for (int j = 0; j < 3; j++) {
            if (!celdas[0][j].equals("") && celdas[0][j].equals(celdas[1][j]) && celdas[1][j].equals(celdas[2][j])) {
                lineaGanadora = new int[][]{{0,j},{1,j},{2,j}};
                return celdas[0][j];
            }
        }
        // Diagonal principal
        if (!celdas[0][0].equals("") && celdas[0][0].equals(celdas[1][1]) && celdas[1][1].equals(celdas[2][2])) {
            lineaGanadora = new int[][]{{0,0},{1,1},{2,2}};
            return celdas[0][0];
        }
        // Diagonal secundaria
        if (!celdas[0][2].equals("") && celdas[0][2].equals(celdas[1][1]) && celdas[1][1].equals(celdas[2][0])) {
            lineaGanadora = new int[][]{{0,2},{1,1},{2,0}};
            return celdas[0][2];
        }
        return null;
    }

    /**
     * Determina si el juego terminó en empate (tablero lleno sin ganador).
     *
     * @return true si es empate, false en caso contrario
     */
    public boolean hayEmpate() {
        if (verificarGanador() != null) return false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (celdas[i][j].equals("")) return false;
        return true;
    }

    /**
     * Devuelve las coordenadas de la línea ganadora (si existe).
     *
     * @return arreglo 2D con las tres posiciones ganadoras, o null si no hay ganador
     */
    public int[][] getLineaGanadora() {
        return lineaGanadora;
    }

    /**
     * Limpia el tablero y reinicia la línea ganadora.
     */
    public void limpiar() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                celdas[i][j] = "";
        lineaGanadora = null;
    }
}