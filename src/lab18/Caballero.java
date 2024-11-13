package lab18;

public class Caballero extends Soldado {
    private boolean montado;
    private String arma;

    public Caballero() {
        super();
        montado = true; // comienza montado por defecto
        arma = "lanza"; // comienza con la lanza
    }

    public void montar() {
        if (!montado) {
            montado = true;
            arma = "lanza";
            System.out.println("El caballero monta y se prepara para envestir con su " + arma + "!");
        }
    }

    public void desmontar() {
        if (montado) {
            montado = false;
            arma = "espada";
            System.out.println("El caballero desmonta, defiende y cambia su arma a " + arma + ".");
            defensa += 1; // aumentar defensa al desmontar
        }
    }

    public void envestir() {
        if (montado) {
            System.out.println("El caballero envestido montado, ataca 3 veces con su " + arma + "!");
            ataque *= 3; // ataca 3 veces
        } else {
            System.out.println("El caballero envestido desmontado, ataca 2 veces con su " + arma + "!");
            ataque *= 2; // ataca 2 veces
        }
    }

    public void alternarArma() {
        arma = arma.equals("lanza") ? "espada" : "lanza";
        System.out.println("El caballero cambia su arma a " + arma + ".");
    }

    public String getArma() {
        return arma;
    }

    public boolean isMontado() {
        return montado;
    }
}

