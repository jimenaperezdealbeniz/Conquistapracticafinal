package PF.juego;

import PF.jugadores.Jugador;
import PF.tablero.Tablero;
import PF.unidades.Ingeniero;
import PF.unidades.Poeta;
import unidades.*;

import java.util.List;

public class Partida {
    private Tablero tablero;
    private TurnoManager turnos;
    private List<Jugador> jugadores;
    private final int T = 5;

    public Partida(Tablero tablero, List<Jugador> jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
        this.turnos = new TurnoManager(jugadores);

        // Inicializar con dos unidades por jugador
        Jugador jugador0 = jugadores.get(0);
        jugador0.agregarUnidad(new Ingeniero(jugador0));
        Jugador jugador1 = jugadores.get(1);
        jugador1.agregarUnidad(new Poeta(jugador1));

    }

    public void jugar() {
        while (!hayGanador()) {
            Jugador actual = turnos.getJugadorActual();
            System.out.println("Turno de: " + actual.getNombre());

            if (turnos.getTurnoGlobal() % T == 0) {
                System.out.println("¡Turno de refuerzo!");
                actual.agregarUnidad(GeneradorUnidades.generarAleatoria(actual));
            }

            // Aquí se llamaría a la IA o input del humano

            turnos.siguienteTurno();
        }

        System.out.println("Juego terminado");
    }

    private boolean hayGanador() {
        return jugadores.stream().anyMatch(j -> j.getUnidades().isEmpty());
    }
}
