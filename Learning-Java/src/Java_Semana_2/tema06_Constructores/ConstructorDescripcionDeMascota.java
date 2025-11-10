package Java_Semana_2.tema06_Constructores;

// Los constructores se definen dentro de las clases, porque su función es crear objetos de esa clase
// e inicializar sus variables (atributos) al momento de la creación, como en el siguiente ejemplo:

public class ConstructorDescripcionDeMascota {
    String nombre;
    int edad;
    int estatura;
    String colorDeLaMascota;
    String descripcionDeLaMascota;

    // Constructor, --> se inicializa las variables(atributos)

    public ConstructorDescripcionDeMascota(String nombre, String colorDeLaMascota, String descripcionDeLaMascota, int edad, int estatura){
        this.nombre = nombre;
        this.colorDeLaMascota = colorDeLaMascota;
        this.descripcionDeLaMascota = descripcionDeLaMascota;
        this.edad = edad;
        this.estatura = estatura;
    }

    void mensajeCompleto(){
        System.out.println("\n===================== Datos Básicos de la Mascota =====================");
        System.out.printf("\n- Nombre      : %-10s ", nombre);
        System.out.printf("\n- Edad        : %02d Años", edad);
        System.out.printf("\n- Estatura    : %02d centímetros", estatura);
        System.out.printf("\n- Color       : %-10s ", colorDeLaMascota);
        System.out.printf("\n- Descripción : %-10s \n", descripcionDeLaMascota);
    }
}


