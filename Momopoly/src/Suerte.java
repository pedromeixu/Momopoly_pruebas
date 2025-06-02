import java.util.ArrayList;

public class Suerte extends Casilla{
    private TipoSuerte tipo;

    public Suerte(String nombre, ArrayList<Integer> posicion, TipoSuerte tipo) {
        super(nombre, posicion);
        this.tipo = tipo;
    }

    public void triggerSuerte(Jugador jugador) {
        if (tipo == TipoSuerte.MOVER) {
            moverJugador(jugador);
        } else if (tipo == TipoSuerte.QUITARDINERO) {
            modificarDinero(jugador);
        }
    }

    public void moverJugador(Jugador jugador) {
        int movimiento = 3;
        jugador.moverseConParametros(movimiento);
    }

    public void modificarDinero(Jugador jugador) {
        int dinero = 200;
        int dineroJugador = jugador.getDinero();
        if (dineroJugador > dinero) {
            dineroJugador -= dinero;
            jugador.setDinero(dineroJugador);
        } // meter funcion perder la partida
    }
}
