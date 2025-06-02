import java.util.ArrayList;

public abstract class Casilla {
    private String nombre;
    protected ArrayList<Integer> posicion;

    public Casilla(String nombre, ArrayList<Integer> posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public String printearPosicion() {
        StringBuilder sc = new StringBuilder();
        sc.append(posicion.get(0));
        sc.append(posicion.get(1));

        String posicion = sc.toString();
        return posicion;
    }
}
