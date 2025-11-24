import javax.swing.*;

public class OperadorAritmetico {
    static void main(String[] args) {
        int i = 5, j = 4, suma = i + j;

        System.out.println("suma = " + suma);

        System.out.println(" (i + j) = " +  (i + j));
        
        int resta = i - j;

        System.out.println("resta = " + resta);
        System.out.println("(i - j) = " + (i - j)); // si no tiene los parentesis la prioridad la va a tener el string
        
        int multi = i * j;
        System.out.println("Multiplicación = " + multi);
        
        int div = i / j;
        float div2 = (float) i / j; // Se hace el casteo para que pueda manejar bien el decimal
        System.out.println("División = " + div);
        System.out.println("Float = " + div2);
        
        int resto = i % j;
        System.out.println("resto = " + resto);

        resto = 8 % 5;
        System.out.println("resto = " + resto);

        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número"));
        if(numero  % 2 == 0){
            System.out.println("numero par = " + numero);
        }else{
            System.out.println("numero impar = " + numero);
        }


    }
}
