package co.estebanpoointerfaces.ejercicio;

import co.estebanpoointerfaces.ejercicio.modelo.*;

import java.util.Date;

public class ProyectoCatalogo {
    public static void main(String[] args) {

        IProducto[] productos = new Producto[8];

        productos[0] = new IPhone(2000000, "Foxconn", "Blanco", "13 Pro Max");
        productos[1] = new IPhone(8000000, "Foxconn", "Negro", "16 Pro Max");
        productos[2] = new TvLcd(2300000, "LG", 50);
        productos[3] = new TvLcd(4000000, "Samsung", 54);
        productos[4] = new Libro(54000, new Date(), "Milton Castaño", "Cuervos en el Cielo", "ESTB");
        productos[5] = new Libro(30000, new Date(), "Ratatui", "Resetas de cocina", "MTR");
        productos[6] = new Comics(100000, new Date(), "Yeison Soto", "Wrong Program", "STO", "Valeria");
        productos[7] = new Comics(70000, new Date(), "Mateo", "Pan", "Toquica", "Arina");

        for(IProducto producto : productos){
            System.out.println();
            if(producto instanceof IPhone){
                System.out.println("Modelo: " + ((IPhone) producto).getModelo());
                System.out.println("Color: " + ((IPhone) producto).getColor());
                System.out.println("Fabricante: " + ((IPhone) producto).getFabricante());
            }
            if(producto instanceof TvLcd){
                System.out.println("Fabricante: " + ((TvLcd) producto).getFabricante());
                System.out.println("Pulgadas: " + ((TvLcd) producto).getPulgada());
            }
            if(producto instanceof Libro){
                System.out.println("Titulo: " + ((Libro) producto).getTitulo());
                System.out.println("Autor: "+ ((Libro) producto).getAutor());
                System.out.println("Editorial: " + ((Libro) producto).getEditorial());
                System.out.println("Fecha de Publicación: " + ((Libro) producto).getFechaPublicacion());
                if(producto instanceof Comics){
                    System.out.println("Personaje Principal: " + ((Comics) producto).getPersonaje());
                }
            }
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println();
        }
    }
}
