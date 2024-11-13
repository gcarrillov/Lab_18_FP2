package lab18;
import java.util.*;

class Ejercito {
    private String id;
    private ArrayList<Soldado> soldados;
    private double promedioAtaque;
    private double promedioDefensa;
    private double promedioVida;

    public Ejercito(String id, String mapa, String reino) {
        this.id = id;
        soldados = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            soldados.add(generarSoldadoAleatorio());
        }
        calcularPromedios();
        ajustarPorMapa(mapa, reino);
    }

    private Soldado generarSoldadoAleatorio() {
        Random random = new Random();
        int tipo = random.nextInt(3);
        switch (tipo) {
            case 0: return new Espadachin();
            case 1: return new Caballero();
            default: return new Arquero();
        }
    }

    private void calcularPromedios() {
        promedioAtaque = soldados.stream().mapToDouble(Soldado::getAtaque).average().orElse(0);
        promedioDefensa = soldados.stream().mapToDouble(Soldado::getDefensa).average().orElse(0);
        promedioVida = soldados.stream().mapToDouble(Soldado::getVida).average().orElse(0);
    }

    private void ajustarPorMapa(String mapa, String reino) {
        if ((mapa.equals("montanas") || mapa.equals("pantanos")) && reino.equals("Norte")) {
            promedioAtaque++;
            promedioDefensa++;
            promedioVida++;
        } else if ((mapa.equals("campo abierto") || mapa.equals("bosque")) && reino.equals("Sur")) {
            promedioAtaque++;
            promedioDefensa++;
            promedioVida++;
        }
    }

    public String getId() {
        return id;
    }

    public double getPromedioEstadisticas() {
        return (promedioAtaque + promedioDefensa + promedioVida) / 3;
    }

    public ArrayList<Soldado> getSoldados() {
        return soldados;
    }
}
