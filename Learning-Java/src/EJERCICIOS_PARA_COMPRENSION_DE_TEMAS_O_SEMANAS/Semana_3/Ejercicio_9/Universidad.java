package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_9;

import java.util.ArrayList;

public class Universidad {

    static String nombreUniversidad;
    ArrayList<Persona> comunidadUniversitaria;

    public Universidad(String nombre){
        nombreUniversidad = nombre;
        comunidadUniversitaria = new ArrayList<>();
    }

    void agregarMiembro(Persona p){
        if (comunidadUniversitaria == null) {
            comunidadUniversitaria = new ArrayList<>();
        }

        if (!comunidadUniversitaria.contains(p)) {
            comunidadUniversitaria.add(p);
            System.out.println("\nSe ha añadido correctamente. ¡¡¡Bienvenido!!! " + p + "\n");
        } else {
            System.out.println("\nEl ID de esta persona ya está registrado.");
        }
    }


    void listarEstudiantes(){
        if(comunidadUniversitaria == null || comunidadUniversitaria.isEmpty()){
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.println("\n\n\n=================== Lista de Estudiantes ===================");
        for(Persona p : comunidadUniversitaria){
            if(p instanceof Estudiante){
                System.out.println(p);
            }
        }
    }


    void listarProfesores(){
        if(comunidadUniversitaria == null || comunidadUniversitaria.isEmpty()){
            System.out.println("No hay profesores registrados.");
            return;
        }

        System.out.println("\n\n\n=================== Lista de Profesores ===================");
        for(Persona p : comunidadUniversitaria){
            if(p instanceof Profesor){
                System.out.println(p);
            }
        }
    }

    void listarAdministrativos(){
        if(comunidadUniversitaria == null || comunidadUniversitaria.isEmpty()){
            System.out.println("No hay administrativos.");
            return;
        }

        System.out.println("\n\n\n=================== Lista de Administrativos ===================");
        for(Persona p : comunidadUniversitaria){
            if(p instanceof Administrativo){
                System.out.println(p);
            }
        }
    }


    void buscarPorId(String id){
        if(comunidadUniversitaria == null || comunidadUniversitaria.isEmpty()){
            System.out.println("No hay personas registradas.");
            return;
        }

        boolean encontrado = false;

        for(Persona p : comunidadUniversitaria){
            if(p.getId().equalsIgnoreCase(id)){
                System.out.println("\n\n ========= Persona encontrada: ========");
                System.out.println(p);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ninguna persona con el ID: " + id);
        }

    }

    void demostrarPolimorfismo() {
        System.out.println("\n\n\n=================== DEMOSTRACIÓN DE POLIMORFISMO ===================");
        System.out.println("Recorriendo la comunidad universitaria como objetos 'Persona':\n");

        for (Persona p : comunidadUniversitaria) {
            // Polimorfismo: cada objeto usa su propia versión de toString()
            System.out.println(p.toString());

            // También podemos hacer casting para acceder a métodos específicos
            if (p instanceof Estudiante) {
                Estudiante est = (Estudiante) p;
                System.out.println("   → Este es un ESTUDIANTE");
                est.mostrarMaterias();
            } else if (p instanceof Profesor) {
                Profesor prof = (Profesor) p;
                System.out.println("   → Este es un PROFESOR del departamento: " + prof.getDepartamento());
            } else if (p instanceof Administrativo) {
                System.out.println("   → Este es un ADMINISTRATIVO");
            }

            System.out.println();
        }

        System.out.println("Total de miembros en la comunidad: " + comunidadUniversitaria.size());
        System.out.println("Total profesores en la comunidad: " + Profesor.getContadorProfesores());
    }

}
