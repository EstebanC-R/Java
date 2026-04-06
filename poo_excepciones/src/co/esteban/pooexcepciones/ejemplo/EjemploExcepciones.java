package co.esteban.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();

        String numerador = JOptionPane.showInputDialog(null, "Ingrese un entero numerador: ");
        String denominador = JOptionPane.showInputDialog(null, "Ingrese un entero denominador: ");

        try {
            double division2 = cal.dividir(numerador, denominador);
            System.out.println("Division2: " + division2);
        } catch (FormatoNumeroException e){
            System.out.println("Mensaje: " + e.getMessage());
            e.printStackTrace(System.out);
        } catch (DivisionPorCeroException e){
            System.out.println("Mensaje: " + e.getMessage());
        }
        finally {
            System.out.println("Es opcional, pero se ejecuta siempre con o sin excepción.");
        }
        System.out.println("¡¡Se continua con el flujo de nuestra aplicación!!");

    }
}
