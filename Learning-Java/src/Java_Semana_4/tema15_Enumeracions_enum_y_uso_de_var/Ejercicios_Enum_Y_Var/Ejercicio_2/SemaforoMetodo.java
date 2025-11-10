package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_2;

public class SemaforoMetodo {
    public static void mostrarAccion(ColorSemaforo color){
        switch (color){
            case ROJO:
                System.out.println("\nDetente ❤️");
                break;
            case AMARILLO:
                System.out.println("\nPrecaución 💛");
                break;
            case VERDE:
                System.out.println("\nAvanza 💚");
                break;
        }
    }
}
