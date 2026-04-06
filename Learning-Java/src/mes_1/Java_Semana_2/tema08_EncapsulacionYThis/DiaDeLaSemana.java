package mes_1.Java_Semana_2.tema08_EncapsulacionYThis;

public class DiaDeLaSemana {
    // Atributos
    private String dia;
    private int fechaDelMes;

    // Constructor
    public DiaDeLaSemana(String dia, int fechaDelMes){
        this.dia = dia;
        this.fechaDelMes = fechaDelMes;
    }

    // Métodos para acceder y modificar los datos
    public String getDia(){
        return dia;
    }

    public void setDia(String dia){
        this.dia = dia;
    }


    public int getFechaDelMes(){
        return fechaDelMes;
    }

    public void setFechaDelMes(int fechaDelMes){
        this.fechaDelMes = fechaDelMes;
    }
}
