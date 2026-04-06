package co.esteban.ejerciciopractico.felino;

public class Leon extends Felino {
    private int numManada;
    private float potenciaRugidoDecibel;
    private final static int MAX_RUGIDO = 110;

    public Leon(String habitat, float altura, float largo, float peso, String nombreCientifico, float largoGarras, int velocidad, int numManada, float potenciaRugidoDecibel) {
        super(habitat, altura, largo, peso, nombreCientifico, largoGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugidoDecibel = potenciaRugidoDecibel;
    }

    public int getNumManada() {
        return numManada;
    }

    public float getPotenciaRugidoDecibel() {
        return potenciaRugidoDecibel;
    }

    @Override
    public String comer() {
        return "El león (" + nombreCientifico + ") caza en el " + habitat +
                " junto a su manada de " + numManada + " individuos.";
    }

    @Override
    public String dormir() {
        return "El león duerme largas horas en el " + habitat +
                " para conservar energía, con un peso de " + peso + " kg.";
    }

    @Override
    public String correr() {
        return "El león corre a " + velocidad + " km/h usando sus garras de " +
                largoGarras + " cm y un cuerpo de " + largo + " metros de largo.";
    }

    @Override
    public String comunicarse() {
        if (potenciaRugidoDecibel > MAX_RUGIDO) {
            return "El rugido supera el máximo permitido de " + MAX_RUGIDO +
                    " dB, alcanzando " + potenciaRugidoDecibel + " dB.";
        }
        return "El rugido de un león puede llegar a " + MAX_RUGIDO +
                " dB y en este caso es de " + potenciaRugidoDecibel + " dB.";
    }

    @Override
    public String toString() {
        String mensajeRugido;

        if (potenciaRugidoDecibel > MAX_RUGIDO) {
            mensajeRugido = "Advertencia: el rugido supera el máximo permitido (" + MAX_RUGIDO + " dB), alcanzando " + potenciaRugidoDecibel + " dB.";
        } else {
            mensajeRugido = "dB: " + potenciaRugidoDecibel;
        }

        return super.toString() +
                "\n- Número de Manada: " + numManada +
                "\n- Potencia del Rugido " + mensajeRugido;
    }
}
