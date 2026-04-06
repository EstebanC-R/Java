package co.esteban.ejerciciopractico.felino;

public class Guepardo extends Felino {

    public Guepardo(String habitat, float altura, float largo, float peso, String nombreCientifico, float largoGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, largoGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El guepardo (" + nombreCientifico + ") caza en el " + habitat + " y se alimenta de gacelas.";
    }

    @Override
    public String dormir() {
        return "El guepardo descansa en el " + habitat + " después de correr a gran velocidad.";
    }

    @Override
    public String correr() {
        return "El guepardo alcanza hasta " + velocidad + " km/h gracias a sus garras de " + largoGarras + " cm.";
    }

    @Override
    public String comunicarse() {
        return "El guepardo se comunica con chillidos y ronroneos, pesando alrededor de " + peso + " kg.";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
