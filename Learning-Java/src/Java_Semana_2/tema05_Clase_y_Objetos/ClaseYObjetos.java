package Java_Semana_2.tema05_Clase_y_Objetos;

// Se crea el objeto aquí, llamando a la clase Estudiante ubicada en otro documento
public class ClaseYObjetos {
    public static void main(String[] args){
        //Aquí se está llamando la clase estudiante para poder ser utilizada como objeto
        Estudiante alumno = new Estudiante();
        alumno.nombre = "Milton";
        alumno.edad = 21;

        System.out.println("\n" + alumno.nombre + " tiene " + alumno.edad + " Años");


        Mascota pet = new Mascota();
        pet.nombreDeMascota = "Pepe";
        pet.edadDeLaMascota = 11;
        pet.mensajeMascota();
    }

    // Si se quiere utilizar en el mismo documento sería asi, es menos recomendable porque si se necesita en varios
    // documentos lo que vamos a hacer es crear y crear, en vez de solo crear un documento y utilizarlo como plantilla por asi decirlo.
    static class Mascota{
        String nombreDeMascota;
        int edadDeLaMascota;

        void mensajeMascota(){
            System.out.println("\nEl nombre de sú mascota es: " + nombreDeMascota + " y tiene " + edadDeLaMascota + " años.");
        }
    }
}


