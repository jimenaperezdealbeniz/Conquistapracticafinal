package PF.juego;

import PF.jugadores.Jugador;
import java.util.List;

public class TurnoManager {
    private List<Jugador> jugadores;
    private int turnoActual = 0;

    public TurnoManager(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(turnoActual % jugadores.size());
    }

    public void siguienteTurno() {
        turnoActual++;
    }

    public int getTurnoGlobal() {
        return turnoActual;
    }
}
