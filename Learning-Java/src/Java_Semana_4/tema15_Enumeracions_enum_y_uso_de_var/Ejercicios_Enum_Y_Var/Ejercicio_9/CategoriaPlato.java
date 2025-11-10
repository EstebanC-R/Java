package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_9;

public enum CategoriaPlato {
    ENTRADA("Entradas", "🥞🍘"),
    PLATO_FUERTE("Platos Fuertes", "🍖"),
    POSTRE("Postres", "🎂🍰"),
    BEBIDA("Bebidas", "🍸🍺");


    private String nombreCategoria;
    private String iconoCategoria;

    CategoriaPlato(String nombreCategoria, String iconoCategoria){
        this.nombreCategoria = nombreCategoria;
        this.iconoCategoria = iconoCategoria;
    }

    public String getNombreCategoria(){
        return nombreCategoria;
    }

    public String getIconoCategoria(){
        return iconoCategoria;
    }
}
