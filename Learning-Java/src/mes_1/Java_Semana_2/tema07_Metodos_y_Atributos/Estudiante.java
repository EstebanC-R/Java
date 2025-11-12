package mes_1.Java_Semana_2.tema07_Metodos_y_Atributos;

public class Estudiante {
    // 🔸 Atributos (variables que describen al objeto)
    String nombre;
    int edad;

    // 🔹 Constructor (se ejecuta al crear el objeto y asigna valores iniciales a los atributos)
    public Estudiante(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    // 🔸 Método (acción que puede realizar el objeto)
    public void datosDelEstudiante(){
        System.out.println("\nQue tal " + nombre + "? así que tienes " + edad + " años, eso es genial bienvenido a java :)");
    }
}
