package EJERCICIOS_MES_1.Semana03_Sistema_de_Empleados_con_Jerarquias;

public class Gerente extends EmpleadoEjercicio {
    private String area;

    public Gerente(String nom, double salar, String ar){
        super(nom, salar);
        this.area = ar;
    }

    public String getArea(){
        return area;
    }

    public void supervisar(){
        System.out.println(super.getNombre() + " está supervisando.");
    }

    @Override
    public String toString(){
        return super.toString() + "\n- Área: " + area;
    }
}
