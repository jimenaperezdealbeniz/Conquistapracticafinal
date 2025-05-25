package tablero;

public class Tablero {
    private Casilla[][] casillas;

    public Tablero(int filas, int columnas) {
        casillas = new Casilla[filas][columnas];
        inicializar();
    }

    private void inicializar() {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[0].length; j++) {
                casillas[i][j] = new Casilla(1, 0); // terreno básico
            }
        }
    }

    public Casilla getCasilla(int fila, int columna) {
        return casillas[fila][columna];
    }

    public int getFilas() { return casillas.length; }
    public int getColumnas() { return casillas[0].length; }
}
