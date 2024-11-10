package lab18;
import java.util.*; 
class Soldado {
    private String nombre;
    private int nivelAtaque;
    private int nivelDefensa;
    private int nivelVida;
    private int vidaActual;
    private int velocidad;
    private String actitud;
    private boolean vive;

    public Soldado(String nombre) {
        this.nombre = nombre;
        Random rand = new Random();
        this.nivelAtaque = rand.nextInt(5) + 1;
        this.nivelDefensa = rand.nextInt(5) + 1;
        this.nivelVida = rand.nextInt(5) + 1;
        this.vidaActual = nivelVida;
        this.velocidad = 0;
        this.actitud = "defensiva";
        this.vive = true;
    }

    public void serAtacado(int damage) {
        if (vive) {
            vidaActual -= damage;
            if (vidaActual <= 0) {
                morir();
            }
        }
    }

    public void morir() {
        vive = false;
        vidaActual = 0;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isVivo() {
        return vive;
    }

    @Override
    public String toString() {
        return nombre + (vive ? " (V)" : " (X)");
    }
}
