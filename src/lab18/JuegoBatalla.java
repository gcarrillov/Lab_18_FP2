package lab18;
import java.util.*;

public class JuegoBatalla {
    private Tablero tablero;
    private Reino reinoNorte;
    private Reino reinoSur;
    private String mapa;
    private Random random;

    public JuegoBatalla() {
        random = new Random();
        mapa = seleccionarMapa();
        reinoNorte = new Reino("Norte", mapa);
        reinoSur = new Reino("Sur", mapa);
        tablero = new Tablero(reinoNorte, reinoSur);
    }

    public void iniciarJuego() {
        System.out.println("Comienza la batalla entre el Reino Norte y el Reino Sur!");
        System.out.println("Mapa seleccionado: " + mapa);
        tablero.mostrarTablero();

        Scanner scanner = new Scanner(System.in);
        while (reinoNorte.tieneEjercitos() && reinoSur.tieneEjercitos()) {
            System.out.println("\nTurno del jugador para mover ejercito del Reino Norte");
            tablero.moverEjercito(reinoNorte, scanner);
            tablero.mostrarTablero();
            if (!reinoSur.tieneEjercitos()) break;

            System.out.println("\nTurno del jugador para mover ejercito del Reino Sur");
            tablero.moverEjercito(reinoSur, scanner);
            tablero.mostrarTablero();
        }
        
        System.out.println("\nLa guerra ha terminado!");
        if (reinoNorte.tieneEjercitos()) {
            System.out.println("El Reino Norte ha ganado!");
        } else {
            System.out.println("El Reino Sur ha ganado!");
        }
    }

    private String seleccionarMapa() {
        String[] mapas = {"bosque", "campo abierto", "montanas", "pantanos"};
        return mapas[random.nextInt(mapas.length)];
    }
}

