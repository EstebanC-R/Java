package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_3;

public enum Talla {
    XS("Extra pequeña", 32),
    S("Pequeña", 34),
    M("Mediana", 36),
    L("Grande", 38),
    XL("Extra Grande", 40);

    private String descripcion;
    private int numero;

    Talla(String descripcion, int numero){
        this.descripcion = descripcion;
        this.numero = numero;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public int getNumero(){
        return numero;
    }

    @Override
    public String toString(){
        return String.format(
                "\n--------------------------------\n%-15s : %s\n%-15s : %d\n%s",
                "Descripción", getDescripcion(),
                "Numero de Talla", getNumero(),
                "--------------------------------\n"
        );
    }

}
