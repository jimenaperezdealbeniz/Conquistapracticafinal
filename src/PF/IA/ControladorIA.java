package PF.IA;

import PF.jugadores.Jugador;
import PF.tablero.Casilla;
import PF.tablero.Tablero;
import PF.unidades.Unidad;
import PF.Logs.LoggerPartida;
import java.util.Random;

public class ControladorIA {
    private Tablero tablero;
    private LoggerPartida logger;
    private Random random = new Random();

    public ControladorIA(Tablero tablero, LoggerPartida logger) {
        this.tablero = tablero;
        this.logger = logger;
    }


    public void jugarTurnoIA(Jugador jugador) {
        for (Unidad unidad : jugador.getUnidades()) {
            // Buscar un movimiento aleatorio simple
            moverUnidadAleatoriamente(unidad);

            // Buscar un enemigo al alcance y atacarlo
            atacarSiPuede(unidad);
        }
    }

    private void moverUnidadAleatoriamente(Unidad unidad) {
        int filas = tablero.getFilas();
        int columnas = tablero.getColumnas();

        for (int intentos = 0; intentos < 10; intentos++) {
            int fila = random.nextInt(filas);
            int col = random.nextInt(columnas);
            Casilla destino = tablero.getCasilla(fila, col);

            if (destino.estaLibre()) {
                destino.setUnidad(unidad);
                System.out.println(unidad.getNombre() + " se mueve a (" + fila + "," + col + ")");
                break;
            }
        }
    }

    private void atacarSiPuede(Unidad unidad) {
        int rango = unidad.getRangoAtaque();
        for (int i = 0; i < tablero.getFilas(); i++) {
            for (int j = 0; j < tablero.getColumnas(); j++) {
                Casilla casilla = tablero.getCasilla(i, j);
                Unidad objetivo = casilla.getUnidad();
                if (objetivo != null && objetivo != unidad && objetivo.getJugador() != unidad.getJugador()) {
                    objetivo.recibirDanio(unidad.getAtaque());
                    System.out.println(unidad.getNombre() + " ataca a " + objetivo.getNombre());

                    if (objetivo.estaMuerta()) {
                        casilla.setUnidad(null);
                        objetivo.getJugador().eliminarUnidad(objetivo);
                        System.out.println(objetivo.getNombre() + " ha muerto.");
                    }
                    return;
                }
            }
        }
    }
}
