package co.esteban.app.ejemplo;


import co.esteban.app.pooherencia.Alumno;
import co.esteban.app.pooherencia.AlumnoInternacional;
import co.esteban.app.pooherencia.Persona;
import co.esteban.app.pooherencia.Profesor;
import co.esteban.app.pooherencia.*;

public class EjemploHerenciaConstructores {
    public static void main(String[] args) {

        // $ Cuando una clase hereda de otra, es porque tambien es del tipo  del padre.
        // ! La cosa cambia cuando se quire invocar un método propio del hijo, al no estar
        // ! en el padre este automáticamente no deja ponerlo, por la razón dicha.
        // # Solo se puede hacer si se hace un cast, pero no es recomendado, haciendo
        // # ((Alumno)alumno).método, al igual que en su getInstituto, se tendría que
        // # castear la clase Alumno para poder usarla de esta forma ((Alumno)alumno).getMétodo();

        System.out.println();
        System.out.println("=============== Creando la instancia de la clase Alumno ===============");
        Alumno alumno = new Alumno("Milton", "Castaño", 21, "Maria Cano");
        alumno.setNotaSpanish(3.5);
        alumno.setNotaHistoria(4.9);
        alumno.setNotaMatematica(5);
        alumno.setEmail("alumno@gmail.com");

        System.out.println("=============== Creando la instancia de la clase Alumno Internacional ===============");
        AlumnoInternacional alumnoInte = new AlumnoInternacional("Pepe", "el Blanco", "Canada");
        alumnoInte.setEdad(12);
        alumnoInte.setInstitucion("Instituto La Calle");
        alumnoInte.setNotaIdiomas(4.0);
        alumnoInte.setNotaSpanish(3.6);
        alumnoInte.setNotaMatematica(3.4);
        alumnoInte.setNotaHistoria(4.3);
        alumnoInte.setEmail("alumnoInternacional@gmail.com");

        System.out.println("=============== Creando la instancia de la clase Profesor ===============");
        Profesor profesor = new Profesor("Yeison", "Soto","Matemáticas");
        profesor.setEdad(25);
        profesor.setEmail("profesor@gmail.com");

        imprimir(alumno);
        imprimir(alumnoInte);
        imprimir(profesor);

    }

    public static void imprimir(Persona persona){
        System.out.println("==========================================================");
        System.out.println(" ------ Datos en Común del tipo Persona ------");
        System.out.println("- Nombre: " + persona.getNombre()
                + "\n- Apellido: " + persona.getApellido()
                + "\n- Edad: " + persona.getEdad()
                + "\n- Email: " + persona.getEmail());

        if(persona instanceof Alumno){
            System.out.println("------ Datos del Alumno ------");
            System.out.println("- Institución: " + ((Alumno) persona).getInstitucion());
            System.out.println("- Nota Matemáticas: " + ((Alumno) persona).getNotaMatematica());
            System.out.println("- Nota Español: " + ((Alumno) persona).getNotaSpanish());
            System.out.println("- Nota Historia: " + ((Alumno) persona).getNotaHistoria());

            if(persona instanceof AlumnoInternacional){
                System.out.println("------ Datos del Alumno Internacional ------");
                System.out.println("- Nota Idioma: " + ((AlumnoInternacional) persona).getNotaIdiomas());
                System.out.println("- País: " + ((AlumnoInternacional) persona).getPais());
            }

            System.out.println("============================== Sobre escritura promedio ============================");
            System.out.println("Promedio: " + ((Alumno) persona).calcularPromedio());
            System.out.println("===================================================================");
        }

        if(persona instanceof Profesor){
            System.out.println("------ Datos del Profesor ------");
            System.out.println("- Asignatura: " + ((Profesor) persona).getAsignatura());
        }

        System.out.println("============================== Sobre escritura saludar ============================");
        System.out.println(persona.saludar());
        System.out.println("==========================================================");


    }
}
