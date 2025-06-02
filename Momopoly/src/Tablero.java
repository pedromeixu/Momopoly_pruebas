import java.util.ArrayList;

public class Tablero {
    private ArrayList<Casilla> casillas;

    public Tablero(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public void desplegarTablero(ArrayList<Integer> posJug) {
        for (int i = 0; i < casillas.size(); i++) {
            if (casillas.get(i).posicion.equals(posJug)) {
                System.out.print("0X");
                System.out.print(" ");
            } else {
                System.out.print(casillas.get(i).printearPosicion());
                System.out.print(" ");
            }
        }
    }
}
