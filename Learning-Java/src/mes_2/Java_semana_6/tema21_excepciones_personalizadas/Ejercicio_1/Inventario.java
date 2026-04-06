package mes_2.Java_semana_6.tema21_excepciones_personalizadas.Ejercicio_1;

public class Inventario {
    private static int contador = 1;
    private int ID;
    private String producto;
    private double precio;
    private int cantidad;

    public Inventario(String producto, double precio, int cantidad){
        this.ID = contador++;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void descontarStock(int cantidadADescontar) throws StockInsuficienteException{
        int stockActual = this.getCantidad();

        if(cantidadADescontar > stockActual){
            throw new StockInsuficienteException(
                    this.getProducto(),
                    cantidadADescontar,
                    stockActual
            );
        }

        this.cantidad -= cantidadADescontar;
        System.out.println("Se ha descontado del stock");
    }

    @Override
    public String toString(){
        return String.format("--------------------------------------------------\n%-19s : %d\n%-19s : %s\n%-19s : %.2f\n%-19s : %d\n%s",
                "ID", ID,
                "Nombre del Producto", producto,
                "Precio", precio,
                "Cantidad", cantidad,
                "--------------------------------------------------\n"
                );
    }
}
