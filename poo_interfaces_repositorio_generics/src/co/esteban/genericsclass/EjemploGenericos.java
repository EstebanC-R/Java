package co.esteban.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion){
        for(T o : camion){
            if(o instanceof Animal){
                System.out.println("- Nombre: " + ((Animal) o).getNombre() + "\n- Tipo: " + ((Animal) o).getTipo());
            }

            if(o instanceof Automovil){
                System.out.println("- Marca: " + ((Automovil) o).getMarca());
            }

            if(o instanceof Maquinaria){
                System.out.println("- Tipo: " + ((Maquinaria) o).getTipo());
            }
            System.out.println("--------------------");
        }

        System.out.println("===============================================");
    }
    public static void main(String[] args) {

        Camion<Animal> transporteDeGatos = new Camion<>(5);
        transporteDeGatos.addObjeto(new Animal("Pepe", "Gato"));
        transporteDeGatos.addObjeto(new Animal("Tom", "Gato"));
        transporteDeGatos.addObjeto(new Animal("Jerry", "Gato"));
        transporteDeGatos.addObjeto(new Animal("Negro", "Gato"));
        transporteDeGatos.addObjeto(new Animal("Blanco", "Gato"));

        System.out.println();

        imprimirCamion(transporteDeGatos);

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.addObjeto(new Maquinaria("Bulldozer"));
        transMaquinas.addObjeto(new Maquinaria("Grúa Horquilla"));
        transMaquinas.addObjeto(new Maquinaria("Perforadora"));

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto = new Camion<>(3);

        transAuto.addObjeto(new Automovil("Toyota"));
        transAuto.addObjeto(new Automovil("Mitsubishi"));
        transAuto.addObjeto(new Automovil("Chevrolet"));

        imprimirCamion(transAuto);

    }
}
