import java.util.ArrayList;
import java.util.Random;

public class Jugador {
    private static ArrayList<Integer> posicion;
    private String nombre;
    private int dinero;


    static {
        posicion = new ArrayList<>();
        posicion.add(0);
        posicion.add(0);
    }

    public Jugador(ArrayList<Integer> posicion, String nombre) {

    }

    public int posicionInt() {
        String coordenadas = "";
        for (int i = 0; i < posicion.size(); i++) {
            coordenadas += posicion.get(i);
        }
        return Integer.parseInt(coordenadas);
    }

    public void moverse() {
        Random rand = new Random();
        int random1 = rand.nextInt(6) + 1;
        int random2 = rand.nextInt(6) + 1;
        int movimiento = random1 + random2 + posicionInt();

        if (movimiento > 36) {
            movimiento = movimiento - 36;
        }
        if (movimiento < 10) {
            posicion.set(0, 0);
            posicion.set(1, movimiento);
        } else {
            int filas = movimiento / 10;
            int columnas = movimiento % 10;
            posicion.set(0, filas);
            posicion.set(1, columnas);
        }
    }

    public void moverseConParametros(int movimiento) {
        movimiento = movimiento + posicionInt();
        if (movimiento > 36) {
            movimiento = movimiento - 36;
        }
        if (movimiento < 10) {
            posicion.set(0, 0);
            posicion.set(1, movimiento);
        } else {
            int filas = movimiento / 10;
            int columnas = movimiento % 10;
            posicion.set(0, filas);
            posicion.set(1, columnas);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
}
