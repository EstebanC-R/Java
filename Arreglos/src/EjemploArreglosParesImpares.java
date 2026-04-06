import java.util.Scanner;

public class EjemploArreglosParesImpares {
    public static void main(String[] args) {
        int[] a, pares, impares;
        int totalPares = 0, totalImpares = 0;

        Scanner rl = new Scanner(System.in);
        a = new int[10];

        System.out.println("Ingrese 10 números enteros: ");
        for(int i = 0; i < a.length; i++){
            a[i] = rl.nextInt();
        }

        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                totalPares++;
            }else {
                totalImpares++;
            }
        }

        pares = new int[totalPares];
        impares = new int[totalImpares];

        int auxiliarPar = 0;
        int auxiliarImpar = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 == 0){
                pares[auxiliarPar++] = a[i];
            }else {
                impares[auxiliarImpar++] = a[i];
            }
        }


        System.out.println("Pares: ");
        for(int i = 0; i < pares.length; i++){
            System.out.print(pares[i] + " ");
        }

        System.out.println("\n\nImpares: ");
        for(int i = 0; i < impares.length; i++){
            System.out.print(impares[i] + " ");
        }

        System.out.println();

    }
}
