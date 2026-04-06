package EJERCICIOS_PARA_COMPRENSION_DE_TEMAS_O_SEMANAS.Semana_3.Ejercicio_9;

public class Administrativo extends Persona{
    private String area;
    private String horario;


    public Administrativo(String id, String nombre, int edad, String email, String area, String horario){
        super(id, nombre, edad, email);
        this.area = area;
        this.horario = horario;
    }

    @Override
    public String toString(){
        return String.format(
                "\n\n--------------- Administrativo --------------\n\n%-15s : %s\n%-15s : %s\n%-15s : %d años\n%-15s : %s\n%-15s : %s\n%-15s : %s\n%s",
                "Administrativo ID", getId(),
                "Nombre", getNombre(),
                "Edad", getEdad(),
                "Email", getEmail(),
                "Área", area,
                "Horario", horario,
                "-----------------------------------------------"
        );
    }

}
