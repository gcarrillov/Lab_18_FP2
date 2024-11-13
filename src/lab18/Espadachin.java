package lab18;
import java.util.*;
public class Espadachin extends Soldado {
    private int longitudEspada;

    public Espadachin() {
        super();
        Random random = new Random();
        longitudEspada = random.nextInt(20) + 30; // longitud de espada entre 30 y 50 cm
    }

    public void crearMuroEscudos() {
        System.out.println("El espadachin crea un muro de escudos, aumentando su defensa temporalmente!");
        defensa += 2; // por ejemplo, aumentar temporalmente la defensa
    }

    public int getLongitudEspada() {
        return longitudEspada;
    }
}

