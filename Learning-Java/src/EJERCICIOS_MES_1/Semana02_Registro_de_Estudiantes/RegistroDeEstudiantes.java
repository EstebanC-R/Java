package EJERCICIOS_MES_1.Semana02_Registro_de_Estudiantes;

public class RegistroDeEstudiantes {
    // Atributos
    private String nombre;
    private int edad;
    private String curso;

    // Constructor
    public RegistroDeEstudiantes(String nombre, int edad, String curso){
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }


    public void datosDelEstudiante(){
        System.out.printf("\n- Nombre  : %s ", nombre);
        System.out.printf("\n- Edad    : %02d ", edad);
        System.out.printf("\n- Curso   : %s ", curso);
    }

    @Override
    public String toString(){
        return String.format("\n- Nombre  : " + nombre + "\n- Edad  : " + edad + "\n- Curso  : " + curso);
    }
}
