import java.util.Scanner;

public class EjemploArregloNotasAlumnos {
    public static void main(String[] args) {

        double[] claseMatematicas, claseHistoria, claseLenguaje;

        claseMatematicas = new double[7];
        claseHistoria = new double[7];
        claseLenguaje = new double[7];

        double sumNotasMatematicas = 0, sumNotasHistoria = 0, sumNotasLenguaje = 0;

        Scanner rl = new Scanner(System.in);

        System.out.println("Ingrese 7 notas de estudiantes para matemáticas: ");
        for(int i = 0; i < claseMatematicas.length; i++){
            claseMatematicas[i] = rl.nextDouble();
        }

        System.out.println("Ingrese 7 notas de estudiantes para historia: ");
        for(int i = 0; i < claseHistoria.length; i++){
            claseHistoria[i] = rl.nextDouble();
        }

        System.out.println("Ingrese 7 notas de estudiantes para lenguaje: ");
        for(int i = 0; i < claseLenguaje.length; i++){
            claseLenguaje[i] = rl.nextDouble();
        }


        for(int i = 0; i < 7; i++){
            sumNotasMatematicas += claseMatematicas[i];
            sumNotasHistoria += claseHistoria[i];
            sumNotasLenguaje += claseLenguaje[i];
        }

        double promedioMatematicas = (sumNotasMatematicas/claseMatematicas.length);
        double promedioHistoria = (sumNotasHistoria/claseMatematicas.length);
        double promedioLenguaje = (sumNotasLenguaje/claseMatematicas.length);
        double promedioTotalDelCurso = (promedioMatematicas + promedioHistoria + promedioLenguaje) / 3;

        System.out.printf("Promedio clase %-15s: %.2f\n", "Matemáticas", promedioMatematicas);
        System.out.printf("Promedio clase %-15s: %.2f\n", "Historia", promedioHistoria);
        System.out.printf("Promedio clase %-15s: %.2f\n", "Lenguaje", promedioLenguaje);
        System.out.printf("Promedio total del %-15s : %.2f\n", "curso", promedioTotalDelCurso);

        System.out.println("Ingrese el identificador del alumno (de 0 - 6): ");
        int id = rl.nextInt();

        double promedioAlumno = (claseMatematicas[id] + claseHistoria[id] + claseLenguaje[id])/3;
        System.out.printf("Promedio alumno Nro %-15s : %.2f", id, promedioAlumno);
    }
}
