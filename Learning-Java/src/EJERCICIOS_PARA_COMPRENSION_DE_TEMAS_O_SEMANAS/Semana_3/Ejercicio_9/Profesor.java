package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_9;

import java.util.ArrayList;

public class Profesor extends Persona{
    private String departamento;
    private double salario;
    private ArrayList<String> materiasQueDicta;

    private static int contadorProfesores = 0;

    public Profesor(String id, String nombre, int edad, String email, String departamento, double salario, ArrayList<String> materiasQueDicta){
        super(id, nombre, edad, email);
        this.departamento = departamento;
        this.salario = salario;
        this.materiasQueDicta = materiasQueDicta;
        contadorProfesores++;
        System.out.println("Profesor creado: " + nombre);
    }


    void asignarMateria(String materia){
        if(!materiasQueDicta.contains(materia)){
            materiasQueDicta.add(materia);
            System.out.println("Materia asignada con éxito: " + materia);
        }else{
            System.out.println("Esta materia ya esta asignada al profesor: " + getNombre());
        }
    }

    public static int getContadorProfesores(){
        return contadorProfesores;
    }


    @Override
    public String toString(){
        StringBuilder materiasTexto = new StringBuilder();

        for(int i = 0; i < materiasQueDicta.size(); i++){
            materiasTexto.append(String.format("%d. %s\n", i + 1, materiasQueDicta.get(i)));
        }

        return String.format(
                "\n\n------------------ Profesor --------------------\n\n%-15s : %s\n%-15s : %s\n%-15s : %d años\n%-15s : %s\n%-15s : %s\n%-15s : %.2f\n%-15s : %d\n\n%-15s \n%s\n%s",
                "Profesor ID", getId(),
                "Nombre", getNombre(),
                "Edad", getEdad(),
                "Email", getEmail(),
                "Departamento", departamento,
                "Salario", salario,
                "Num. Materias", materiasQueDicta.size(),
                "---- Materias que imparte ----", materiasTexto.toString(),
                "------------------------------------------------"
        );
    }

    public String getDepartamento(){
        return departamento;
    }

}
