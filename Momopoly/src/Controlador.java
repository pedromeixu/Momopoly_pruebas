import java.util.ArrayList;
import java.util.HashMap;

public class Controlador {

    private Jugador jugador;
    private Tablero tablero;
    private ArrayList<Casilla> casillas;

    public Controlador() {
        this.casillas = new ArrayList<>();

        casillas.add(new Distrito("Distrito A", crearPos(0, 0), 200, alquilerSimple(), null, Color.ROJO, 0, 50));
        casillas.add(new Suerte("Suerte 1", crearPos(0, 1), TipoSuerte.MOVER));
        casillas.add(new Distrito("Distrito B", crearPos(0, 2), 250, alquilerSimple(), null, Color.ROJO, 0, 50));
        casillas.add(new Suerte("Suerte 2", crearPos(0, 3), TipoSuerte.QUITARDINERO));
        casillas.add(new Distrito("Distrito C", crearPos(0, 4), 300, alquilerSimple(), null, Color.ROJO, 0, 50));
        casillas.add(new Distrito("Distrito D", crearPos(0, 5), 280, alquilerSimple(), null, Color.AZUL_CELESTE, 0, 50));
        casillas.add(new Suerte("Suerte 3", crearPos(0, 6), TipoSuerte.MOVER));
        casillas.add(new Distrito("Distrito E", crearPos(0, 7), 320, alquilerSimple(), null, Color.AZUL_CELESTE, 0, 50));
        casillas.add(new Suerte("Suerte 4", crearPos(0, 8), TipoSuerte.QUITARDINERO));
        casillas.add(new Distrito("Distrito F", crearPos(0, 9), 350, alquilerSimple(), null, Color.AZUL_MARINO, 0, 50));

        this.tablero = new Tablero(casillas);

        jugador = new Jugador("Jugador 1", 1500, new ArrayList<>());
    }

    public void iniciarJuego() {
        System.out.println("Empieza el juego con " + jugador.getNombre());
        System.out.println("Tu dinero: " + jugador.getDinero());

        for (int turno = 1; turno <= 15; turno++) {
            System.out.println("\nTurno " + turno);
            int[] dados = jugador.moverse();
            System.out.println("Tirada: " + dados[0] + " + " + dados[1] + " = " + (dados[0] + dados[1]));


            int posJugador = jugador.posicionInt();
            Casilla casillaActual = obtenerCasillaPorPosicion(posJugador);

            if (casillaActual == null) {
                System.out.println("No hay casilla en esta posición.");
                continue;
            }

            System.out.println("Estás en: " + casillaActual.printearPosicion() + " → " + casillaActual.getClass().getSimpleName());

            if (casillaActual instanceof Suerte) {
                ((Suerte) casillaActual).triggerSuerte(jugador);
            } else if (casillaActual instanceof Distrito) {
                Distrito distrito = (Distrito) casillaActual;
                if (distrito.getDono() == null) {
                    jugador.comprarDistrito(distrito);
                    System.out.println("Compraste " + distrito.getClass().getSimpleName() + " por " + distrito.getPrecio() + "€");
                } else if (distrito.getDono() != jugador) {
                    distrito.cobrarAlquiler(distrito.getDono(), jugador);
                    System.out.println("Pagaste el alquiler de " + distrito.getClass().getSimpleName());
                }
            }

            tablero.desplegarTablero(crearPos(posJugador / 10, posJugador % 10));
            System.out.println("Dinero restante: " + jugador.getDinero());

            if (jugador.getDinero() <= 0) {
                System.out.println("\nBancarrota, perdiste la partida");
                return;
            }
        }

        System.out.println("\nTurno 15. Fin del juego.");
    }

    private Casilla obtenerCasillaPorPosicion(int pos) {
        for (int i = 0; i < casillas.size(); i++) {
            Casilla c = casillas.get(i);
            int fila = c.posicion.get(0);
            int col = c.posicion.get(1);
            if ((fila * 10 + col) == pos) {
                return c;
            }
        }
        return null;
    }

    private ArrayList<Integer> crearPos(int fila, int col) {
        ArrayList<Integer> pos = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (i == 0) pos.add(fila);
            else pos.add(col);
        }
        return pos;
    }

    private HashMap<Integer, Integer> alquilerSimple() {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] keys = {0, 1, 2};
        int[] values = {50, 100, 150};
        for (int i = 0; i < keys.length; i++) {
            map.put(keys[i], values[i]);
        }
        return map;
    }
}
