package co.esteban.patrones.singleton;

public class EjemploSingleton {
    public static void main(String[] args) {

        // # Se llama getInstance() 10 veces seguidas.
        // @ Lo importante: el constructor ("Conectandose...") solo se imprime UNA vez,
        // # en la primera iteración. Las otras 9 devuelven el objeto ya existente.
        // # Si imprimes "con", verás que la dirección de memoria es siempre la misma.
        ConexionBDSingleton con = null;
        for (int i = 0; i < 10; i++) {
            con = ConexionBDSingleton.getInstance();
            System.out.println("con = " + con); // * misma dirección siempre
        }

        // $ Se crean dos variables más apuntando a la "misma" instancia.
        // $ con2 y con3 no son objetos nuevos — son referencias al único objeto existente.
        ConexionBDSingleton con2 = ConexionBDSingleton.getInstance();
        ConexionBDSingleton con3 = ConexionBDSingleton.getInstance();

        // $ Prueba definitiva: el operador == en objetos Java compara direcciones de memoria.
        // $ Si los tres apuntan al mismo objeto, las tres comparaciones dan true.
        // $ b1 = true confirma que el Singleton funcionó correctamente.
        boolean b1 = ((con == con2) && (con2 == con3) && (con == con3));
        System.out.println("b1 = " + b1); // ! imprime: b1 = true
    }
}
