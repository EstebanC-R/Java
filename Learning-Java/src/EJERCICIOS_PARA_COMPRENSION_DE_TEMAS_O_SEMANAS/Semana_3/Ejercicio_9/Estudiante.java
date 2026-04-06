package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_9;

import java.util.ArrayList;

public class Estudiante extends Persona{
    private String carrera;
    private double promedio;
    private ArrayList<String> materias;

    public Estudiante(String id, String nombre, int edad, String email, String carrera, double promedio, ArrayList<String> materias){
        super(id, nombre, edad, email);
        this.carrera = carrera;
        this.promedio = promedio;
        this.materias = materias;
    }

    void inscribirMateria(String materia){
        if(!materias.contains(materia)){
            materias.add(materia);
            System.out.println("\nMateria inscrita: " + materia);
        }else{
            System.out.println("Ya estás inscrito en la materia: " + materia);
        }
    }

    void mostrarMaterias(){
        System.out.println("\nMaterias inscritas: ");
        if(materias.isEmpty()){
            System.out.println("No hay materias inscritas. :(");
        }else{
            for(int i = 0; i < materias.size(); i++){
                System.out.printf("%d. %s\n", i + 1, materias.get(i));
            }
        }
    }

    @Override
    public String toString(){
        return String.format(
                "\n\n------------------ Estudiante ----------------\n\n%-15s: %s\n%-15s: %s\n%-15s: %d años\n%-15s: %s\n%-15s: %s\n%-15s: %.2f\n%-15s: %d inscritas\n%s",
                "ID", getId(),
                "Nombre", getNombre(),
                "Edad", getEdad(),
                "Email", getEmail(),
                "Carrera", carrera,
                "Promedio", promedio,
                "Materias", materias.size(),
                "---------------------------------------------"
        );
    }
}
