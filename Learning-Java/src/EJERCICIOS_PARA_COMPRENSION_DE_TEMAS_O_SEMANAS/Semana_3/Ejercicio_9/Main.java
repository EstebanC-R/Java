package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Universidad uni = new Universidad("TdeA");

        // ---------------------------------------- Estudiante 1 --------------------------------------
        ArrayList<String> materiasMilton = new ArrayList<>();

        Estudiante milton = new Estudiante("283", "Milton", 21, "milton@gmail.com", "Programación", 4.3, materiasMilton);

        milton.inscribirMateria("Matemáticas");
        milton.inscribirMateria("Sociales");
        milton.inscribirMateria("Religión");
        milton.inscribirMateria("Física");

        milton.mostrarMaterias();
        uni.agregarMiembro(milton);

        // ---------------------------------------- Estudiante 2 --------------------------------------

        ArrayList<String> materiasYony = new ArrayList<>();

        Estudiante yony = new Estudiante("123", "Yony", 25, "yony@gmail.com", "Agroambiental", 4.6, materiasYony);

        yony.inscribirMateria("Química");
        yony.inscribirMateria("Laboratorio");
        yony.inscribirMateria("Suelos");
        yony.inscribirMateria("Hidráulica");


        yony.mostrarMaterias();
        uni.agregarMiembro(yony);

        // ---------------------------------------- Estudiante 3 --------------------------------------

        ArrayList<String> materiasYeison = new ArrayList<>();

        Estudiante yeison = new Estudiante("135", "Yeison", 23, "soto@gmail.com", "Developer", 4.5, materiasYeison);

        yeison.inscribirMateria("Sensores");
        yeison.inscribirMateria("Sintaxis");
        yeison.inscribirMateria("Java");
        yeison.inscribirMateria("Angular");


        yeison.mostrarMaterias();
        uni.agregarMiembro(yeison);

        // ---------------------------------------- Estudiante 4 --------------------------------------

        ArrayList<String> materiasMateo = new ArrayList<>();

        Estudiante mateo = new Estudiante("13", "mateo", 23, "teo@gmail.com", "Masas 2", 5, materiasMateo);

        mateo.inscribirMateria("Panes 2");
        mateo.inscribirMateria("Masa decorada");
        mateo.inscribirMateria("Levaduras");
        mateo.inscribirMateria("Horno 1");


        mateo.mostrarMaterias();
        uni.agregarMiembro(mateo);

        // ---------------------------------------- Profesor 1 --------------------------------------
        ArrayList<String> materiasProfesor1 = new ArrayList<>();

        Profesor profesor1 = new Profesor("P34", "Mauricio", 34, "profesor1@gmail.com", "Tecnología", 2000000.00, materiasProfesor1);

        profesor1.asignarMateria("Sensores");
        profesor1.asignarMateria("Angular");
        profesor1.asignarMateria("Sintaxis");
        profesor1.asignarMateria("Java");
        profesor1.asignarMateria("Matemática");

        uni.agregarMiembro(profesor1);

        // ---------------------------------------- Profesor 2 --------------------------------------

        ArrayList<String> materiasProfesor2 = new ArrayList<>();

        Profesor profesor2 = new Profesor("P12", "Juliana", 28, "profesor2@gmail.com", "Panadería", 2100000.00, materiasProfesor2);

        profesor2.asignarMateria("Levaduras");
        profesor2.asignarMateria("Panes");
        profesor2.asignarMateria("Masa");
        profesor2.asignarMateria("Religión");

        uni.agregarMiembro(profesor2);


        // ---------------------------------------- Administrativo --------------------------------------

        Administrativo admin1 = new Administrativo("A-12", "Manuel", 54, "manu@gmail.com", "Finanzas", "8am - 2pm");


        uni.agregarMiembro(admin1);


        // ---------------------------------------- Listar ----------------------------------------------

        uni.listarAdministrativos();
        uni.listarProfesores();
        uni.listarEstudiantes();

        // ---------------------------------------- Buscar ----------------------------------------------
        uni.buscarPorId("P12");

        // -------------------------------------- Polimorfismo ------------------------------------------

        uni.demostrarPolimorfismo();
    }
}
