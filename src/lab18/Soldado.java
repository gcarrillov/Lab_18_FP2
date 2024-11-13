package lab18;
import java.util.*;
abstract class Soldado {
    protected int vida;
    protected int defensa;
    protected int ataque;

    public Soldado() {
        Random random = new Random();
        vida = random.nextInt(6) + 5;
        defensa = random.nextInt(6) + 5;
        ataque = random.nextInt(6) + 5;
    }

    public double getPromedioEstadisticas() {
        return (vida + defensa + ataque) / 3.0;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getVida() {
        return vida;
    }
}
