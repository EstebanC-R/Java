package co.esteban.app.ejemplo;


import co.esteban.app.pooherencia.Alumno;
import co.esteban.app.pooherencia.AlumnoInternacional;
import co.esteban.app.pooherencia.Profesor;
import co.esteban.app.pooherencia.*;

public class EjemploHerencia {
    public static void main(String[] args) {

        // $ Cuando una clase hereda de otra, es porque tambien es del tipo del padre.
        // ! La cosa cambia cuando se quire invocar un método propio del hijo, al no estar
        // ! en el padre este automáticamente no deja ponerlo, por la razón dicha.
        // # Solo se puede hacer si se hace un cast, pero no es recomendado, haciendo
        // # ((Alumno)alumno).método, al igual que en su getInstituto, se tendría que
        // # castear la clase Alumno para poder usarla de esta forma ((Alumno)alumno).getMétodo();

        System.out.println();
        System.out.println("=============== Creando la instancia de la clase Alumno ===============");
        Alumno alumno = new Alumno();
        alumno.setNombre("Milton");
        alumno.setApellido("Castaño");
        alumno.setInstitucion("Instituto Nacional");
        alumno.setNotaSpanish(3.5);
        alumno.setNotaHistoria(4.9);
        alumno.setNotaMatematica(5);

        System.out.println("=============== Creando la instancia de la clase Alumno Internacional ===============");
        AlumnoInternacional alumnoInte = new AlumnoInternacional();
        alumnoInte.setNombre("Pepe");
        alumnoInte.setApellido("el Blanco");
        alumnoInte.setPais("Canadá");
        alumnoInte.setEdad(12);
        alumnoInte.setInstitucion("Instituto La Calle");
        alumnoInte.setNotaIdiomas(4.0);
        alumnoInte.setNotaSpanish(3.6);
        alumnoInte.setNotaMatematica(3.4);
        alumnoInte.setNotaHistoria(4.3);

        System.out.println("=============== Creando la instancia de la clase Profesor ===============");
        Profesor profesor = new Profesor();
        profesor.setNombre("Yeison");
        profesor.setApellido("Soto");
        profesor.setAsignatura("Matemáticas");


        System.out.println("======================================");
        System.out.println(alumno.getNombre()
                + " " + alumno.getApellido()
                + " - " + alumno.getInstitucion());

        System.out.println();

        System.out.println(alumnoInte.getNombre()
                + " " + alumnoInte.getApellido()
                + " - " + alumnoInte.getInstitucion()
                + "\n" + "País : " + alumnoInte.getPais()
        );

        System.out.println();

        System.out.println("Profesor de "
                + profesor.getAsignatura()
                + " : " + profesor.getNombre()
                + " " + profesor.getApellido());

        // ! Este ciclo while recorre la jerarquía de herencia de la clase,
        // ! mostrando cada relación hija-padre desde la clase actual
        // ! hasta llegar a la clase raíz Object.

        Class clase = alumnoInte.getClass();
        while(clase.getSuperclass() != null){
            String hija = clase.getName();
            String padre = clase.getSuperclass().getName();

            System.out.println("La clase Hija = (" + hija + "), es hija del Padre = (" + padre + ").");
            clase = clase.getSuperclass();
        }
    }
}
