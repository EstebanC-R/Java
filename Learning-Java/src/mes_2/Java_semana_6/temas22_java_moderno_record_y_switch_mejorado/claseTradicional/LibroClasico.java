package mes_2.Java_semana_6.temas22_java_moderno_record_y_switch_mejorado.claseTradicional;

public final class LibroClasico {

    // **1. Atributos Privados e Inmutables (final)**
    private final String titulo;
    private final String autor;
    private final String isbn;

    // **2. Constructor Canónico**
    public LibroClasico(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }

    // **3. Métodos Getters (Acceso a los datos)**
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    // **4. Metodo equals() (Comparación por valor de todos los campos)**
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibroClasico that = (LibroClasico) o;
        return java.util.Objects.equals(titulo, that.titulo) &&
                java.util.Objects.equals(autor, that.autor) &&
                java.util.Objects.equals(isbn, that.isbn);
    }

    // **5. Metodo hashCode() (Para usar en colecciones como HashMap)**
    @Override
    public int hashCode() {
        return java.util.Objects.hash(titulo, autor, isbn);
    }

    // **6. Metodo toString() (Representación legible)**
    @Override
    public String toString() {
        return "LibroClasico[" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ']';
    }
}
