package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_2;

public class Main {
    public static void main(String[] args) {

        ColorSemaforo color = ColorSemaforo.valueOf("VERDE");
        SemaforoMetodo.mostrarAccion(color);

        ColorSemaforo color2 = ColorSemaforo.valueOf("AMARILLO");
        SemaforoMetodo.mostrarAccion(color2);

        ColorSemaforo color3 = ColorSemaforo.valueOf("ROJO");
        SemaforoMetodo.mostrarAccion(color3);
    }
}
