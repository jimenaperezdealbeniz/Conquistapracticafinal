package PF.tablero;

import PF.unidades.Unidad;

public class Casilla {
    private int costeMovimiento;
    private int modificadorDefensa;
    private Unidad unidad;

    public Casilla(int costeMovimiento, int modificadorDefensa) {
        this.costeMovimiento = costeMovimiento;
        this.modificadorDefensa = modificadorDefensa;
        this.unidad = null;
    }

    public int getCosteMovimiento() { return costeMovimiento; }
    public int getModificadorDefensa() { return modificadorDefensa; }

    public Unidad getUnidad() { return unidad; }
    public void setUnidad(Unidad unidad) { this.unidad = unidad; }

    public boolean estaLibre() {
        return unidad == null;
    }
}
