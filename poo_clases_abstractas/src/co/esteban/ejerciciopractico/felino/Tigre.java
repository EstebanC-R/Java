package co.esteban.ejerciciopractico.felino;

public class Tigre extends Felino {

    private String especieTigre;

    public Tigre(String habitat, float altura, float largo, float peso, String nombreCientifico, float largoGarras, int velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, largoGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    public String getEspecieTigre() {
        return especieTigre;
    }

    @Override
    public String comer() {
        return "La especie " + especieTigre + " o dicho de otra forma " + nombreCientifico;
    }

    @Override
    public String dormir() {
        return "Los " + especieTigre + " suelen cazar de noche por lo que son nocturnos.";
    }

    @Override
    public String correr() {
        return "Los " + especieTigre + " alcanzan una velocidad de " + velocidad + " Km/h";
    }

    @Override
    public String comunicarse() {
        return "Normalmente los " + especieTigre + " se comunican con gestos o rugidos\n" +
                "Hay que tener en cuenta que el habitat de estos es normalmente " + habitat
                + ".\nSu altura puede llegar a ser de " + altura + "cm, también su largo es de " + largo + "cm y un peso de " + peso + "Kg";
    }

    @Override
    public String toString() {
        return super.toString() + "\n- Especie de Tigre: " + especieTigre;
    }
}
