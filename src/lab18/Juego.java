package lab18;
import java.util.*;

public class Juego {
    private Tablero tablero;
    private Scanner sc;
    private List<Soldado> ejercito1;
    private List<Soldado> ejercito2;

    public Juego(int dimension) {
        this.tablero = new Tablero(dimension);
        this.sc = new Scanner(System.in);
        this.ejercito1 = new ArrayList<>();
        this.ejercito2 = new ArrayList<>();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1) Crear Soldado");
            System.out.println("2) Eliminar Soldado");
            System.out.println("3) Clonar Soldado");
            System.out.println("4) Modificar Soldado");
            System.out.println("5) Comparar Soldados");
            System.out.println("6) Intercambiar Soldados");
            System.out.println("7) Ver Soldado");
            System.out.println("8) Ver Ejército");
            System.out.println("9) Sumar Niveles");
            System.out.println("10) Jugar");
            System.out.println("11) Juego Rápido");
            System.out.println("0) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> crearSoldado();
                case 2 -> eliminarSoldado();
                case 3 -> clonarSoldado();
                case 4 -> modificarSoldado();
                case 5 -> compararSoldados();
                case 6 -> intercambiarSoldados();
                case 7 -> verSoldado();
                case 8 -> verEjercito();
                case 9 -> sumarNiveles();
                case 10 -> iniciarJuego();
                case 11 -> juegoRapido();
                case 0 -> System.out.println("Saliendo del juego.");
                default -> System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 0);
    }

    // 1. Crear Soldado
    private void crearSoldado() {
        if (ejercito1.size() >= 10 || ejercito2.size() >= 10) {
            System.out.println("Límite de soldados alcanzado en uno de los ejércitos.");
            return;
        }
        System.out.print("Ingrese el nombre del soldado: ");
        String nombre = sc.nextLine();
        System.out.print("Seleccione el ejército (1 o 2): ");
        int ejercito = sc.nextInt();
        sc.nextLine();

        Soldado soldado = new Soldado(nombre);
        if (ejercito == 1) {
            ejercito1.add(soldado);
        } else if (ejercito == 2) {
            ejercito2.add(soldado);
        } else {
            System.out.println("Ejército inválido.");
        }
    }

    // 2. Eliminar Soldado
    private void eliminarSoldado() {
        System.out.print("Seleccione el ejército (1 o 2): ");
        int ejercito = sc.nextInt();
        sc.nextLine();

        List<Soldado> ejercitoSeleccionado = ejercito == 1 ? ejercito1 : ejercito2;
        if (ejercitoSeleccionado.size() <= 1) {
            System.out.println("No se puede eliminar, el ejército no puede quedar vacío.");
            return;
        }

        System.out.print("Ingrese el índice del soldado a eliminar: ");
        int indice = sc.nextInt();
        if (indice >= 0 && indice < ejercitoSeleccionado.size()) {
            ejercitoSeleccionado.remove(indice);
            System.out.println("Soldado eliminado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // 3. Clonar Soldado
    private void clonarSoldado() {
        System.out.print("Seleccione el ejército (1 o 2): ");
        int ejercito = sc.nextInt();
        sc.nextLine();

        List<Soldado> ejercitoSeleccionado = ejercito == 1 ? ejercito1 : ejercito2;
        if (ejercitoSeleccionado.size() >= 10) {
            System.out.println("Límite de soldados alcanzado.");
            return;
        }

        System.out.print("Ingrese el índice del soldado a clonar: ");
        int indice = sc.nextInt();
        if (indice >= 0 && indice < ejercitoSeleccionado.size()) {
            Soldado soldadoOriginal = ejercitoSeleccionado.get(indice);
            Soldado clon = new Soldado(soldadoOriginal.getNombre());
            ejercitoSeleccionado.add(clon);
            System.out.println("Soldado clonado.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // 4. Modificar Soldado
    private void modificarSoldado() {
        System.out.print("Seleccione el ejército (1 o 2): ");
        int ejercito = sc.nextInt();
        sc.nextLine();

        List<Soldado> ejercitoSeleccionado = ejercito == 1 ? ejercito1 : ejercito2;
        System.out.print("Ingrese el índice del soldado a modificar: ");
        int indice = sc.nextInt();
        if (indice >= 0 && indice < ejercitoSeleccionado.size()) {
            Soldado soldado = ejercitoSeleccionado.get(indice);
            System.out.println("1) Modificar nivel de ataque");
            System.out.println("2) Modificar nivel de defensa");
            System.out.println("3) Modificar vida actual");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            System.out.print("Ingrese el nuevo valor: ");
            int nuevoValor = sc.nextInt();

            switch (opcion) {
                case 1 -> soldado.setNivelAtaque(nuevoValor);
                case 2 -> soldado.setNivelDefensa(nuevoValor);
                case 3 -> soldado.setVidaActual(nuevoValor);
                default -> System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // 5. Comparar Soldados
    private void compararSoldados() {
        // Implementación de comparación entre dos soldados en base a atributos específicos
    }

    // 6. Intercambiar Soldados
    private void intercambiarSoldados() {
        // Implementación de intercambio de posiciones de soldados en el ejército
    }

    // 7. Ver Soldado (por nombre)
    private void verSoldado() {
        // Implementación para buscar y mostrar un soldado por su nombre
    }

    // 8. Ver Ejército
    private void verEjercito() {
        // Mostrar todos los soldados de un ejército
    }

    // 9. Sumar Niveles
    private void sumarNiveles() {
        // Implementación de la suma de niveles con Method-Call Chaining
    }

    // 10. Jugar
    public void iniciarJuego() {
        inicializarSoldados();
        // Código para iniciar el juego con los ejércitos personalizados
    }

    // 11. Juego Rápido
    private void juegoRapido() {
        // Configuración rápida del juego con soldados aleatorios
        iniciarJuego();
    }

    // Método adicional para inicializar soldados en posiciones iniciales
    private void inicializarSoldados() {
        // Implementación de la inicialización de soldados para el juego
    }
// 5. Comparar Soldados
private void compararSoldados() {
    System.out.print("Seleccione el ejército (1 o 2): ");
    int ejercito = sc.nextInt();
    List<Soldado> ejercitoSeleccionado = (ejercito == 1) ? ejercito1 : ejercito2;

    System.out.print("Ingrese el índice del primer soldado: ");
    int indice1 = sc.nextInt();
    System.out.print("Ingrese el índice del segundo soldado: ");
    int indice2 = sc.nextInt();

    if (indice1 >= 0 && indice1 < ejercitoSeleccionado.size() && indice2 >= 0 && indice2 < ejercitoSeleccionado.size()) {
        Soldado s1 = ejercitoSeleccionado.get(indice1);
        Soldado s2 = ejercitoSeleccionado.get(indice2);

        boolean iguales = s1.getNombre().equals(s2.getNombre()) &&
                          s1.getNivelAtaque() == s2.getNivelAtaque() &&
                          s1.getNivelDefensa() == s2.getNivelDefensa() &&
                          s1.getVidaActual() == s2.getVidaActual() &&
                          s1.isVivo() == s2.isVivo();

        System.out.println(iguales ? "Los soldados son iguales en los atributos seleccionados." : "Los soldados son diferentes en alguno de los atributos.");
    } else {
        System.out.println("Índices no válidos.");
    }
}

// 6. Intercambiar Soldados
private void intercambiarSoldados() {
    System.out.print("Seleccione el ejército (1 o 2): ");
    int ejercito = sc.nextInt();
    List<Soldado> ejercitoSeleccionado = (ejercito == 1) ? ejercito1 : ejercito2;

    System.out.print("Ingrese el índice del primer soldado: ");
    int indice1 = sc.nextInt();
    System.out.print("Ingrese el índice del segundo soldado: ");
    int indice2 = sc.nextInt();

    if (indice1 >= 0 && indice1 < ejercitoSeleccionado.size() && indice2 >= 0 && indice2 < ejercitoSeleccionado.size() && indice1 != indice2) {
        Collections.swap(ejercitoSeleccionado, indice1, indice2);
        System.out.println("Soldados intercambiados.");
    } else {
        System.out.println("Índices no válidos o iguales.");
    }
}

// 7. Ver Soldado (por nombre)
private void verSoldado() {
    System.out.print("Seleccione el ejército (1 o 2): ");
    int ejercito = sc.nextInt();
    sc.nextLine();
    List<Soldado> ejercitoSeleccionado = (ejercito == 1) ? ejercito1 : ejercito2;

    System.out.print("Ingrese el nombre del soldado: ");
    String nombre = sc.nextLine();

    for (Soldado soldado : ejercitoSeleccionado) {
        if (soldado.getNombre().equals(nombre)) {
            System.out.println(soldado);
            return;
        }
    }
    System.out.println("Soldado no encontrado.");
}

// 8. Ver Ejército
private void verEjercito() {
    System.out.print("Seleccione el ejército (1 o 2): ");
    int ejercito = sc.nextInt();
    List<Soldado> ejercitoSeleccionado = (ejercito == 1) ? ejercito1 : ejercito2;

    if (ejercitoSeleccionado.isEmpty()) {
        System.out.println("El ejército está vacío.");
    } else {
        for (Soldado soldado : ejercitoSeleccionado) {
            System.out.println(soldado);
        }
    }
}

// 9. Sumar Niveles
private void sumarNiveles() {
    System.out.print("Seleccione el ejército (1 o 2): ");
    int ejercito = sc.nextInt();
    List<Soldado> ejercitoSeleccionado = (ejercito == 1) ? ejercito1 : ejercito2;

    if (ejercitoSeleccionado.isEmpty()) {
        System.out.println("El ejército está vacío.");
        return;
    }

    Soldado suma = new Soldado("Suma");
    for (Soldado soldado : ejercitoSeleccionado) {
        suma = suma.sumar(soldado);  // Se asume que existe un método sumar en la clase Soldado que implementa la suma de atributos
    }

    System.out.println("Suma de niveles del ejército:");
    System.out.println(suma);
}

// 10. Jugar
public void iniciarJuego() {
    inicializarSoldados();  // Configura las posiciones iniciales
    System.out.println("¡Inicia el juego!");
    while (tablero.haySoldados()) {
        tablero.mostrarTablero();
        ejecutarTurno(1);
        if (!tablero.haySoldados()) break;
        ejecutarTurno(2);
    }
    System.out.println("Fin del juego.");
}

// 11. Juego Rápido
private void juegoRapido() {
    ejercito1.clear();
    ejercito2.clear();
    for (int i = 0; i < 10; i++) {
        ejercito1.add(new Soldado("E1S" + i));
        ejercito2.add(new Soldado("E2S" + i));
    }
    iniciarJuego();
}

// Método adicional para inicializar soldados en posiciones iniciales
private void inicializarSoldados() {
    Random rand = new Random();
    for (Soldado soldado : ejercito1) {
        int x, y;
        do {
            x = rand.nextInt(tablero.getDimension());
            y = rand.nextInt(tablero.getDimension());
        } while (!tablero.colocarSoldado(soldado, x, y));
    }
    for (Soldado soldado : ejercito2) {
        int x, y;
        do {
            x = rand.nextInt(tablero.getDimension());
            y = rand.nextInt(tablero.getDimension());
        } while (!tablero.colocarSoldado(soldado, x, y));
    }
}
}