package EJERCICIOS_MES_1.Semana04_lista_de_contactos_CRUD;

public class Contacto {
    private int ID;
    private String nombre;
    private int numero;
    private EstadoDeContacto categoria;
    static int contador = 1;

    public Contacto(String nombre, int numero, EstadoDeContacto categoria){
        this.ID = contador++;
        this.nombre = nombre;
        this.numero = numero;
        this.categoria = categoria;
    }

    public int getID(){
        return ID;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public EstadoDeContacto getCategoria(){
        return categoria;
    }

    public void setCategoria(EstadoDeContacto categoria){
        this.categoria = categoria;
    }


    @Override
    public String toString(){
        return String.format(
                "\n-------------------------------------\n%-15s : %d\n%-15s : %s\n%-15s : %d\n%-15s : %s\n%s",
                "#ID", ID,
                "Nombre", nombre,
                "Número", numero,
                "Categoría", categoria,
                "-------------------------------------\n"
        );
    }
}
