import java.util.ArrayList;
import java.util.Map;

public class Distrito extends Casilla{
    private int precio;
    private Map<Integer, Integer> alquiler;
    private Jugador dono;
    private Color color;
    private int casas;
    private int precioCasa;

    public Distrito(String nombre, ArrayList<Integer> posicion, int precio, Map<Integer, Integer> alquiler, Jugador duenho, Color color, int casas, int precioCasa) {
        super(nombre, posicion);
        this.precio = precio;
        this.alquiler = alquiler;
        this.dono = null;
        this.color = color;
        this.casas = 0;
        this.precioCasa = precioCasa;
    }

    public void comprarDistrito(Jugador dono) {
        if (dono.dinero < precio) {
            this.dono = dono;
            dono.dinero -= precio;
        }
    }

    public void construirEnDistrito(int numeroCasas) {
        if (dono.dinero >= precioCasa * numeroCasas && numeroCasas <= 3) {
            dono.dinero -= precioCasa * numeroCasas;
            casas += numeroCasas;
        }
    }
}
