
import juego.Partida;
import jugadores.Jugador;
import tablero.Tablero;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tablero tablero = new Tablero(10, 10);
        Jugador j1 = new Jugador("Ciencias", false);
        Jugador j2 = new Jugador("Letras", true);
        Partida partida = new Partida(tablero, List.of(j1, j2));
        partida.jugar();
    }
}
