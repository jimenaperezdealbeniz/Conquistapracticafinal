package PF.jugadores;

import PF.unidades.Unidad;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private boolean esIA;
    private List<Unidad> unidades;
    private String faccion;

    public Jugador(String nombre, boolean esIA) {
        this.nombre = nombre;
        this.esIA = esIA;
        this.unidades = new ArrayList<>();
        this.faccion = faccion;
    }

    public String getFaccion() {
        return faccion;
    }



    public String getNombre() { return nombre; }
    public boolean esIA() { return esIA; }

    public List<Unidad> getUnidades() { return unidades; }
    public void agregarUnidad(Unidad unidad) {
        unidades.add(unidad);
    }

    public void eliminarUnidad(Unidad unidad) {
        unidades.remove(unidad);
    }
}
