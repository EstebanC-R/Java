package mes_1.Java_Semana_1.tema03_Condicionales_y_Bucles;

public class CondicionalesYBucles {
    public static void main(String[] args){
        System.out.println("\n========================CONDICIONALES Y BUCLES========================");
        // IF - ELSE IF - ELSE
        int edad = 60;
        if(edad < 18){
            System.out.println("\nEres menor de Edad :(");
        }else if(edad >= 60){
            System.out.println("\nFelicidades entraste a la tercera edad, puedes relajarte lo que quieras");
        }else{
            System.out.println("\nEres mayor de edad, listo para afrontar la adultez?");
        }

        // SWITCH
        int dia = 3;
        switch (dia){
            case 1:
                System.out.println("\nEs primero del mes");
                break;
            case 2:
                System.out.println("\nEs el segundo día del mes");
                break;
            case 3:
                System.out.println("\nYa es el tercer día del mes? va pasando rapido\n");
                break;
        }

        // BUCLES FOR - WHILE
        String saludo = "Hola que tal? Como has estado?";
        String deNuevo = "Quieres un abrazo?";
        String despedida = "Hasta la proxima amigo :)\n";
        for(int i = 1; i <= 3; i++){
            if(i == 1){
                System.out.println(saludo);
            }else if(i == 3){
                System.out.println(despedida);
            }else{
                System.out.println(deNuevo);
            }
        }

        int contador = 0;
        while (contador <= 5){
            System.out.println("Sigo contando, vamos por el: " + contador);
            contador++;
        }
    }
}
