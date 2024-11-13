package lab18;
import java.util.*;

class Reino {
    private String nombre;
    private ArrayList<Ejercito> ejercitos;

    public Reino(String nombre, String mapa) {
        this.nombre = nombre;
        ejercitos = new ArrayList<>();
        int numEjercitos = new Random().nextInt(10) + 1;
        for (int i = 1; i <= numEjercitos; i++) {
            ejercitos.add(new Ejercito(nombre.charAt(0) + "_E" + i, mapa, nombre));
        }
    }

    public boolean tieneEjercitos() {
        return !ejercitos.isEmpty();
    }

    public ArrayList<Ejercito> getEjercitos() {
        return ejercitos;
    }

    public void removerEjercito(Ejercito ejercito) {
        ejercitos.remove(ejercito);
    }
}

