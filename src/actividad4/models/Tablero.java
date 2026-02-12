package actividad4.models;

public class Tablero {
    private String[][] tablero = new String[3][3];

    public Tablero() {
        reiniciar();
    }

    public void reiniciar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = "";
            }
        }
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

    public String verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (!tablero[i][0].equals("") &&
                    tablero[i][0].equals(tablero[i][1]) &&
                    tablero[i][1].equals(tablero[i][2])) {
                return tablero[i][0];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (!tablero[0][i].equals("") &&
                    tablero[0][i].equals(tablero[1][i]) &&
                    tablero[1][i].equals(tablero[2][i])) {
                return tablero[0][i];
            }
        }

        if (!tablero[0][0].equals("") &&
                tablero[0][0].equals(tablero[1][1]) &&
                tablero[1][1].equals(tablero[2][2])) {
            return tablero[0][0];
        }

        if (!tablero[0][2].equals("") &&
                tablero[0][2].equals(tablero[1][1]) &&
                tablero[1][1].equals(tablero[2][0])) {
            return tablero[0][2];
        }

        return null;
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

