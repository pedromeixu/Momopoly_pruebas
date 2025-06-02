import java.util.ArrayList;
import java.util.Iterator;
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

    public void cobrarAlquiler(Jugador propietario, Jugador inquilino) {
        Iterator<Integer> it = alquiler.keySet().iterator();
        int dineroJugadorPropietario = propietario.getDinero();
        int dineroInquilino = inquilino.getDinero();

        while (it.hasNext()) {
            if (it.next() == this.casas) {
                dineroInquilino -= alquiler.get(it.next());
                inquilino.setDinero(dineroInquilino);
                dineroJugadorPropietario += alquiler.get(it.next());
                propietario.setDinero(dineroJugadorPropietario);
            }
        }
    }

    public int getPrecio() {
        return precio;
    }

    public int getCasas() {
        return casas;
    }

    public int getPrecioCasa() {
        return precioCasa;
    }

    public Jugador getDono() {
        return dono;
    }

    public void setDono(Jugador dono) {
        this.dono = dono;
    }

    public void setCasas(int casas) {
        this.casas = casas;
    }
}
