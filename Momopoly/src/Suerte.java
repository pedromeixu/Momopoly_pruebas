import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;

public class Suerte extends Casilla{
    private TipoCasilla tipo;

    public Suerte(String nombre, ArrayList<Integer> posicion, TipoCasilla tipo) {
        super(nombre, posicion);
        this.tipo = tipo;
    }

    public void triggerSuerte(Jugador jugador) {
        if (tipo == TipoCasilla.MOVER) {
            moverJugador(jugador);
        } else if (tipo == TipoCasilla.QUITARDINERO) {
            modificarDinero(jugador);
        }
    }

    public void moverJugador(Jugador jugador) {
        int movimiento = 3;
        jugador.moverseConParametros(movimiento);

    }

    public void modificarDinero(Jugador jugador) {
        int dinero = 200;
        if (jugador.dinero > dinero) {
            jugador.dinero -= dinero;
        } // meter funcion perder la partida
    }
}
