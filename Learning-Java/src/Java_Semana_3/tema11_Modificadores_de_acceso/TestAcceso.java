package Java_Semana_3.tema11_Modificadores_de_acceso;

import Java_Semana_3.tema11_Modificadores_de_acceso.modelo.Persona;

public class TestAcceso {
    public static void main(String[] args){
        Persona p = new Persona("123", "Esteban", 21, "Medellín");

        // System.out.println(p.documento); ❌ No se puede (private)
        // System.out.println(p.nombre);    ❌ No se puede (protected fuera del paquete)
        System.out.println(p.edad);         // ✔️ public
        // System.out.println(p.ciudad);    ❌ No se puede (sin modificador, fuera del paquete)
    }
}
