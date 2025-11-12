package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_1;

public class UtilidadDelEnum {
    public static void esLaboral(DiaSemana dia){
        switch (dia){
            case LUNES:
            case MARTES:
            case MIERCOLES:
            case JUEVES:
            case VIERNES:
                System.out.println("Día laboral.");
                break;
            case SABADO:
            case DOMINGO:
                System.out.println("Fin de semana.");
                break;
            default:
                System.out.println("Ese no es un día de la semana.");
                break;
        }
    }
}
