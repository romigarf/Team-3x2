package actividad4.ui;

public class Language {

    private static String idioma = "ES";
    public static void setIdioma(String codigo) {
        idioma = codigo;
    }

    public static String get(String clave) {
        if (idioma.equals("EN")) {
// ingle'
            switch (clave) {
                case "TITLE": return "Tic Tac Toe";
                case "TURN": return "Turn: ";
                case "WINNER": return "Winner: ";
                case "DRAW": return "Draw!";
                case "PLAYER_1": return "Player 1";
                case "PLAYER_2": return "Player 2";
                case "CPU": return "Computer";
                case "MODE_TITLE": return "Select Mode";
                case "MODE_QUESTION": return "How do you want to play?";
                case "MODE_1P": return "1 Player (vs CPU)";
                case "MODE_2P": return "2 Players";
                case "LANG_TITLE": return "Language";
                case "LANG_QUESTION": return "Select a language / Selecciona idioma";
            }
        } else {
//epañol'
            switch (clave) {
                case "TITLE": return "Gato / Tres en Raya";
                case "TURN": return "Turno de: ";
                case "WINNER": return "Ganador: ";
                case "DRAW": return "¡Empate!";
                case "PLAYER_1": return "Jugador 1";
                case "PLAYER_2": return "Jugador 2";
                case "CPU": return "CPU";
                case "MODE_TITLE": return "Modo de Juego";
                case "MODE_QUESTION": return "¿Cómo quieres jugar?";
                case "MODE_1P": return "1 Jugador (vs CPU)";
                case "MODE_2P": return "2 Jugadores";
                case "LANG_TITLE": return "Idioma";
                case "LANG_QUESTION": return "Selecciona idioma / Select a language";
            }
        }
        return clave;
    }
}
