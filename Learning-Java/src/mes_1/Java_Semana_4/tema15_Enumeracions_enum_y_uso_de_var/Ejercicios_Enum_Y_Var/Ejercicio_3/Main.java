package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_3;

public class Main {
    public static void main(String[] args) {
        for(Talla t : Talla.values()){
            System.out.println(t);
        }


        for(Talla t: Talla.values()){
            if(t.equals(Talla.L)){
                System.out.println("----- Buscando exactamente -----");
                System.out.println(t);
            }
        }

        // O simplemente:

        Talla grande = Talla.valueOf("S");
        System.out.println(grande);

    }
}
