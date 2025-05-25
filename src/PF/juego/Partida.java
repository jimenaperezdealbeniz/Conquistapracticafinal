package PF.juego;
import PF.Logs.LoggerPartida;
import PF.IA.ControladorIA;
import PF.unidades.GeneradorUnidades;
import PF.jugadores.Jugador;
import PF.tablero.Tablero;
import PF.unidades.Ingeniero;
import PF.unidades.Poeta;

import java.util.List;

public class Partida {
    private Tablero tablero;
    private TurnoManager turnos;
    private List<Jugador> jugadores;
    private final int T = 5;
    private ControladorIA ia;
    private LoggerPartida logger;
// Agrega esto


    public Partida(Tablero tablero, List<Jugador> jugadores) {
        this.tablero = tablero;
        this.jugadores = jugadores;
        this.turnos = new TurnoManager(jugadores);
        this.ia = new ControladorIA(tablero, logger);
        // inicializa el controlador de IA
        this.logger = new LoggerPartida("registro_partida.txt");


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
            logger.log("Turno de: " + actual.getNombre());

            if (turnos.getTurnoGlobal() % T == 0) {
                System.out.println("¡Turno de refuerzo!");
                logger.log("¡Turno de refuerzo para " + actual.getNombre() + "!");
                actual.agregarUnidad(GeneradorUnidades.generarAleatoria(actual));
                logger.log("Se añadió una unidad de refuerzo a " + actual.getNombre());
            }

            // Aquí se llamaría a la IA o input del humano
            // Ejemplo:
            // ia.jugarTurno(actual);

            turnos.siguienteTurno();
        }

        System.out.println("Juego terminado");
        logger.log("Juego terminado");
        logger.cerrar();
    }



    private boolean hayGanador() {
        return jugadores.stream().anyMatch(j -> j.getUnidades().isEmpty());
    }
}
