package co.esteban.ejercicio3.modelo;

import co.esteban.ejercicio2.modelo.Articulo;

public class Libro2 extends Articulo2 {
    private String autor;
    private int paginas;

    public Libro2(String nombre, double precio, String autor, int paginas) {
        super(nombre, precio);
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }
}
