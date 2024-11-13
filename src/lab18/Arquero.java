package lab18;
import java.util.*;
public class Arquero extends Soldado {
    private int numFlechas;

    public Arquero() {
        super();
        Random random = new Random();
        numFlechas = random.nextInt(21) + 10; // numero de flechas entre 10 y 30
    }

    public void disparar() {
        if (numFlechas > 0) {
            numFlechas--;
            System.out.println("El arquero dispara una flecha! Flechas restantes: " + numFlechas);
        } else {
            System.out.println("El arquero se ha quedado sin flechas!");
        }
    }

    public int getNumFlechas() {
        return numFlechas;
    }
}

