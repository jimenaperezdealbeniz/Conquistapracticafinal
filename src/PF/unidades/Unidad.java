package PF.unidades;
import PF.jugadores.Jugador;


public abstract class Unidad {
    protected String nombre;
    protected int hp;
    protected int ataque;
    protected int defensa;
    protected int rangoMovimiento;
    protected int rangoAtaque;
    protected Jugador jugador;

    public Unidad(String nombre, int hp, int ataque, int defensa, int rangoMovimiento, int rangoAtaque, Jugador jugador) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataque = ataque;
        this.defensa = defensa;
        this.rangoMovimiento = rangoMovimiento;
        this.rangoAtaque = rangoAtaque;
        this.jugador = jugador;
    }

    public String getNombre() { return nombre; }
    public int getHP() { return hp; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getRangoMovimiento() { return rangoMovimiento; }
    public int getRangoAtaque() { return rangoAtaque; }
    public Jugador getJugador() {
        return jugador;
    }

    public void recibirDanio(int danio) {
        hp -= Math.max(danio - defensa, 0);
    }

    public boolean estaMuerta() {
        return hp <= 0;
    }
}
