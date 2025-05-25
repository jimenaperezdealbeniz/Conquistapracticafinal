package PF.unidades;

import PF.jugadores.Jugador;

public class GeneradorUnidades {

    public static Unidad generarAleatoria(Jugador jugador) {
        String faccion = jugador.getFaccion();

        if (faccion.equalsIgnoreCase("Ciencias")) {
            return new Ingeniero(jugador);
        } else if (faccion.equalsIgnoreCase("Letras")) {
            return new Poeta(jugador);
        } else {
            throw new IllegalArgumentException("Facción desconocida: " + faccion);
        }
    }
}
