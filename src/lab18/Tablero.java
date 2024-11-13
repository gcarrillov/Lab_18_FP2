package lab18;
import java.util.*;

class Tablero {
    private String[][] tablero;
    private Random random;
    private Reino reinoNorte;
    private Reino reinoSur;

    public Tablero(Reino norte, Reino sur) {
        this.reinoNorte = norte;
        this.reinoSur = sur;
        tablero = new String[10][10];
        random = new Random();
        colocarEjercitos(norte);
        colocarEjercitos(sur);
    }

    private void colocarEjercitos(Reino reino) {
        for (Ejercito ejercito : reino.getEjercitos()) {
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (tablero[x][y] != null);
            tablero[x][y] = ejercito.getId();
        }
    }

    public void mostrarTablero() {
        for (String[] fila : tablero) {
            for (String celda : fila) {
                System.out.print((celda != null ? celda : " . ") + " ");
            }
            System.out.println();
        }
    }

    public void moverEjercito(Reino reino, Scanner scanner) {
        System.out.println("Selecciona el ejercito que quieres mover:");
        ArrayList<Ejercito> ejercitos = reino.getEjercitos();
        for (int i = 0; i < ejercitos.size(); i++) {
            System.out.println(i + ": " + ejercitos.get(i).getId());
        }
        int opcion = scanner.nextInt();
        Ejercito ejercito = ejercitos.get(opcion);

        System.out.println("Selecciona la direccion (1: arriba, 2: abajo, 3: izquierda, 4: derecha):");
        int direccion = scanner.nextInt();

        moverEjercitoEnTablero(ejercito, direccion, reino);
    }

    private void moverEjercitoEnTablero(Ejercito ejercito, int direccion, Reino reino) {
        int[] posicion = encontrarPosicion(ejercito.getId());
        if (posicion == null) return;

        int x = posicion[0];
        int y = posicion[1];
        tablero[x][y] = null; // quitamos el ejercito de su posicion actual

        switch (direccion) {
            case 1 -> x = Math.max(x - 1, 0);
            case 2 -> x = Math.min(x + 1, 9);
            case 3 -> y = Math.max(y - 1, 0);
            case 4 -> y = Math.min(y + 1, 9);
        }

        if (tablero[x][y] != null) {
            String idEnPosicion = tablero[x][y];
            Reino reinoEnemigo = (reino == reinoNorte) ? reinoSur : reinoNorte;
            Ejercito enemigo = encontrarEjercito(idEnPosicion, reinoEnemigo);
            if (enemigo != null) {
                resolverBatalla(ejercito, enemigo, reino);
            } else {
                System.out.println("Movimiento invalido: no se puede mover a una posicion ocupada por un ejercito aliado.");
                tablero[posicion[0]][posicion[1]] = ejercito.getId();
                return;
            }
        } else {
            tablero[x][y] = ejercito.getId();
        }
    }

    private void resolverBatalla(Ejercito ejercito, Ejercito enemigo, Reino reino) {
        System.out.println("Batalla entre " + ejercito.getId() + " y " + enemigo.getId());
        double promedioEjercito = ejercito.getPromedioEstadisticas();
        double promedioEnemigo = enemigo.getPromedioEstadisticas();

        if (promedioEjercito > promedioEnemigo) {
            System.out.println(ejercito.getId() + " gana la batalla contra " + enemigo.getId() +
                               " porque tiene mayores estadisticas (" + promedioEjercito + " vs " + promedioEnemigo + ")");
            int[] posicionEnemigo = encontrarPosicion(enemigo.getId());
            if (posicionEnemigo != null) {
                tablero[posicionEnemigo[0]][posicionEnemigo[1]] = null;
            }
            (reino == reinoNorte ? reinoSur : reinoNorte).removerEjercito(enemigo);
        } else if (promedioEnemigo > promedioEjercito) {
            System.out.println(enemigo.getId() + " gana la batalla contra " + ejercito.getId() +
                               " porque tiene mayores estadisticas (" + promedioEnemigo + " vs " + promedioEjercito + ")");
            int[] posicionEjercito = encontrarPosicion(ejercito.getId());
            if (posicionEjercito != null) {
                tablero[posicionEjercito[0]][posicionEjercito[1]] = null;
            }
            reino.removerEjercito(ejercito);
        } else {
            System.out.println("La batalla entre " + ejercito.getId() + " y " + enemigo.getId() + 
                               " ha terminado en empate. Ambos ejercitos permanecen en el tablero.");
        }
    }

    private int[] encontrarPosicion(String id) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (id.equals(tablero[i][j])) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private Ejercito encontrarEjercito(String id, Reino reino) {
        for (Ejercito ejercito : reino.getEjercitos()) {
            if (ejercito.getId().equals(id)) {
                return ejercito;
            }
        }
        return null;
    }
}