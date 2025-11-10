package EJERCICIOS_MES_1.Semana03_Sistema_de_Empleados_con_Jerarquias;

public class Asistente extends EmpleadoEjercicio {
    int numeroDeEscritorio;

    public Asistente(String nom, double salar, int numEscr){
        super(nom, salar);
        this.numeroDeEscritorio = numEscr;
    }

    public int getNumeroDeEscritorio(){
        return numeroDeEscritorio;
    }

    public void anotando(){
        System.out.println(super.getNombre() + " está anotando y documentando archivos.");
    }

    @Override
    public String toString(){
        return super.toString() + " - Número de Escritorio: " + numeroDeEscritorio;
    }
}
