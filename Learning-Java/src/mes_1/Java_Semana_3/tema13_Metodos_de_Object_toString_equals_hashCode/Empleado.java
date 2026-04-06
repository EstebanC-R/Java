package mes_1.Java_Semana_3.tema13_Metodos_de_Object_toString_equals_hashCode;

public class Empleado {
    private String nombre;
    private double salario;

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    // 🔶 1. toString() → Representación textual del objeto
    @Override
    public String toString() {
        return "Empleado: " + nombre + ", Salario: " + salario;
    }

    // 🔷 2. equals() → Comparación de contenido entre objetos
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true; // misma referencia

        if (obj == null || getClass() != obj.getClass()) return false;

        Empleado otro = (Empleado) obj;
        return nombre.equals(otro.nombre) && salario == otro.salario;
    }

    // ♦️ 3. hashCode() → Genera un código único para identificar al objeto
    @Override
    public int hashCode() {

        // 1️⃣ Tomamos el hashCode del nombre (cada String ya tiene uno propio)
        int resultado = nombre.hashCode();

        // 2️⃣ Convertimos el salario (double) a su representación binaria larga (long)
        long salarioBits = Double.doubleToLongBits(salario);

        // 3️⃣ Mezclamos los valores del nombre y el salario para generar un hash único
        //    - 31 * resultado → usa un número primo para distribuir mejor los valores
        //    - (salarioBits ^ (salarioBits >>> 32)) → mezcla los bits altos y bajos
        //    - (int) convierte el resultado final a un número entero
        resultado = 31 * resultado + (int)(salarioBits ^ (salarioBits >>> 32));

        // 4️⃣ Devolvemos el número final, que es el hash del empleado
        return resultado;
    }

}

