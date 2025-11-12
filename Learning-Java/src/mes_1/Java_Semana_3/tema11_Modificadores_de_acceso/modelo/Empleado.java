package mes_1.Java_Semana_3.tema11_Modificadores_de_acceso.modelo;

public class Empleado extends Persona {
    public Empleado(String doc, String nom, int ed, String ciu) {
        super(doc, nom, ed, ciu);
    }

    public void mostrarEmpleado(){
        // System.out.println(documento); ❌ No se puede acceder (private)
        System.out.println("Nombre: " + nombre);   // ✔️ protected
        System.out.println("Edad: " + edad);       // ✔️ public
        System.out.println("Ciudad: " + ciudad);   // ✔️ sin modificador (mismo paquete)
    }
}
