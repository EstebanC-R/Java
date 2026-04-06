package mes_1.Java_Semana_3.tema11_Modificadores_de_acceso.modelo;

public class Persona {
    private String documento;  // Solo accesible dentro de Persona
    protected String nombre;   // Accesible en subclases y mismo paquete
    public int edad;           // Accesible desde cualquier clase
    String ciudad;             // Sin modificador → solo mismo paquete

    public Persona(String doc, String nom, int ed, String ciu){
        this.documento = doc;
        this.nombre = nom;
        this.edad = ed;
        this.ciudad = ciu;
    }

    public void mostrarDatos(){
        System.out.println("Documento  : " + documento); // ✔️ Acceso interno
        System.out.println("Nombre     : " + nombre);
        System.out.println("Edad       : " + edad);
        System.out.println("Ciudad     : " + ciudad);
    }
}

