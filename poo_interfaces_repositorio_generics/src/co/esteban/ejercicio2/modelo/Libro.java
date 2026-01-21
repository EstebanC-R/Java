package co.esteban.ejercicio2.modelo;

public class Libro extends Articulo{
    private String autor;
    private int paginas;

    public Libro(String nombre, double precio, String autor, int paginas) {
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
