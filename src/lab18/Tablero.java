package lab18;
public class Tablero {
    private Soldado[][] tablero;
    private int dimension;

    public Tablero(int dimension) {
        this.dimension = dimension;
        this.tablero = new Soldado[dimension][dimension];
    }
    public int getDimension() {
        return dimension;
    }

    public boolean colocarSoldado(Soldado soldado, int x, int y) {
        if (esPosicionValida(x, y) && tablero[x][y] == null) {
            tablero[x][y] = soldado;
            return true;
        }
        return false;
    }

    public boolean moverSoldado(int x, int y, int direccion) {
        if (!esPosicionValida(x, y) || tablero[x][y] == null || !tablero[x][y].isVivo()) {
            return false;
        }

        int nuevoX = x, nuevoY = y;

        switch (direccion) {
            case 1: nuevoX -= 1; break; // Arriba
            case 2: nuevoX += 1; break; // Abajo
            case 3: nuevoY -= 1; break; // Izquierda
            case 4: nuevoY += 1; break; // Derecha
            default: return false;
        }

        if (!esPosicionValida(nuevoX, nuevoY)) {
            return false;
        }

        Soldado soldadoActual = tablero[x][y];

        // Si hay un enemigo en la posición de destino, se produce una batalla
        if (tablero[nuevoX][nuevoY] != null && tablero[nuevoX][nuevoY].isVivo()) {
            Soldado enemigo = tablero[nuevoX][nuevoY];
            resolverBatalla(soldadoActual, enemigo);
            // Si el enemigo muere, el soldado actual toma la posición
            if (!enemigo.isVivo()) {
                tablero[nuevoX][nuevoY] = soldadoActual;
                tablero[x][y] = null;
            }
        } else {
            // Movimiento normal si la posición está vacía
            tablero[nuevoX][nuevoY] = soldadoActual;
            tablero[x][y] = null;
        }

        return true;
    }


    private void resolverBatalla(Soldado soldado1, Soldado soldado2) {
        System.out.println("Batalla entre " + soldado1.getNombre() + " y " + soldado2.getNombre() + " !");
        if (soldado1.getVidaActual() > soldado2.getVidaActual()) {
            System.out.println(soldado1.getNombre() + " gana la batalla");
            soldado2.morir();
        } else {
            System.out.println(soldado2.getNombre() + " gana la batalla");
            soldado1.morir();
        }
    }
    
    private boolean esPosicionValida(int x, int y) {
        return x >= 0 && x < dimension && y >= 0 && y < dimension;
    }

    public void mostrarTablero() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (tablero[i][j] == null) {
                    System.out.print("[   ] ");
                } else {
                    System.out.print("[" + tablero[i][j].toString() + "] ");
                }
            }
            System.out.println();
        }
    }

    public boolean haySoldados() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (tablero[i][j] != null && tablero[i][j].isVivo()) {
                    return true;
                }
            }
        }
        return false;
    }
}
