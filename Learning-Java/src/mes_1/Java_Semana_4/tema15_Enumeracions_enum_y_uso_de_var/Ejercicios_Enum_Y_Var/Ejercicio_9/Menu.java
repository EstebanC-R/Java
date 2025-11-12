package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_9;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Plato> platos = new ArrayList<>();


    public void agregarPlato(Plato plato){
        platos.add(plato);
    }


    public void mostrarMenuPorCategoria(CategoriaPlato categoria){
        System.out.printf("\n\n---------------------- Menu %s %s -----------------------\n", categoria.getNombreCategoria(), categoria.getIconoCategoria());

        for(var plato : platos){
            if(plato.getCategoria() == categoria){
                System.out.println("- " + plato.getNombre() + " - " + "$" + plato.getPrecio());
            }
        }
        System.out.printf("\n- Precio prom en %s : %.1f", categoria.getNombreCategoria(), precioPorCategoria(categoria));
        System.out.println("\n------------------------------------------------------------");
    }

    public double precioPorCategoria(CategoriaPlato categoria){
        var suma = 0.0;
        var contador = 0;

        for(var p : platos){
            if(p.getCategoria() == categoria){
                suma += p.getPrecio();
                contador++;
            }
        }

        return contador > 0 ? suma / contador : 0;
    }

    public void rangoPrecio(double precio){

        boolean encontrado = false;

        System.out.println("\n\n--------------- Buscando ---------------\n");
        for(var p : platos){
            if(p.getPrecio() <= precio){
                System.out.printf("- %-25s : $%.1f.\n", p.getNombre(), p.getPrecio());
                encontrado = true;
            }
        }

        if(!encontrado){
            System.out.println("Lo sentimos, no tenemos comidas en ese rango de precio. ");
        }
    }

    public void filtroDePresio(){

        System.out.println("\n------------------- Filtrando Platos --------------------");

        boolean encontrado = false;

        for(var plato : platos){
            if(plato.getPrecio() >= 5000 && plato.getPrecio() <= 15000){
                System.out.println(plato);
                encontrado = true;
            }
        }

        if(!encontrado){
            System.out.println("En el momento no tenemos filtros de comida con ese rango de precio.");
        }
    }

    public static void menu() {
        var m = new Menu();
        Plato plato1 = new Plato("Bandeja Paisa", 36000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato1);

        Plato plato2 = new Plato("Ajiaco", 20000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato2);

        Plato plato3 = new Plato("Sancocho de Gallina", 18000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato3);

        Plato plato4 = new Plato("Empanada", 3000, CategoriaPlato.ENTRADA);
        m.agregarPlato(plato4);

        Plato plato5 = new Plato("Patacones con Hogao", 9000, CategoriaPlato.ENTRADA);
        m.agregarPlato(plato5);

        Plato plato6 = new Plato("Postre de Natas", 7000, CategoriaPlato.POSTRE);
        m.agregarPlato(plato6);

        Plato plato7 = new Plato("Tacos al pastor", 12000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato7);

        Plato plato8 = new Plato("Ceviche", 50000, CategoriaPlato.ENTRADA);
        m.agregarPlato(plato8);

        Plato plato9 = new Plato("Churros",  10000, CategoriaPlato.POSTRE);
        m.agregarPlato(plato9);

        Plato plato10 = new Plato("Cazuela de Mariscos", 40000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato10);

        Plato plato11 = new Plato("Coca cola", 6000, CategoriaPlato.BEBIDA);
        m.agregarPlato(plato11);

        Plato plato12 = new Plato("Pepsi", 5000, CategoriaPlato.BEBIDA);
        m.agregarPlato(plato12);

        Plato plato13 = new Plato("Fanta", 7000, CategoriaPlato.BEBIDA);
        m.agregarPlato(plato13);

        Plato plato14 = new Plato("Postre Oreo", 15000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato14);

        Plato plato15 = new Plato("Tres leches", 20000, CategoriaPlato.PLATO_FUERTE);
        m.agregarPlato(plato15);

        Plato plato16 = new Plato("Galleta de la Fortuna", 2000, CategoriaPlato.POSTRE);
        m.agregarPlato(plato16);

        Plato plato17 = new Plato("Pancakes", 8000, CategoriaPlato.ENTRADA);
        m.agregarPlato(plato17);

        Plato plato18 = new Plato("Helado de chocolate", 12000, CategoriaPlato.POSTRE);
        m.agregarPlato(plato18);


        m.mostrarMenuPorCategoria(CategoriaPlato.ENTRADA);
        m.mostrarMenuPorCategoria(CategoriaPlato.PLATO_FUERTE);
        m.mostrarMenuPorCategoria(CategoriaPlato.POSTRE);
        m.mostrarMenuPorCategoria(CategoriaPlato.BEBIDA);

        m.rangoPrecio(20000);
        m.filtroDePresio();
    }


}
