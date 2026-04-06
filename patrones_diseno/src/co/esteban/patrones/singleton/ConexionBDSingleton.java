package co.esteban.patrones.singleton;

/**
 * PATRÓN SINGLETON
 *
 * Propósito: garantizar que esta clase tenga UNA SOLA instancia en toda
 * la aplicación y proveer un punto global de acceso a ella.
 *
 * ¿Por qué aquí? Abrir una conexión a base de datos es costoso (tiempo,
 * memoria, recursos de red). Si cada parte del programa creara su propia
 * conexión, terminarías con decenas de conexiones abiertas innecesariamente.
 * Con Singleton, todos comparten la misma.
 */
public class ConexionBDSingleton {

    // % [1] La instancia se guarda aquí, dentro de la misma clase.
    // %    "static" significa que pertenece a la CLASE, no a un objeto.
    // %    Empieza en null porque aún no se ha creado ninguna conexión.
    private static ConexionBDSingleton instancia;

    // # [2] El constructor es PRIVATE.
    // #    Esto bloquea que alguien haga: new ConexionBDSingleton() desde afuera.
    // #    La única forma de obtener el objeto es a través de getInstance().
    // #    Sin este private el patrón no funciona — cualquiera podría crear
    // #    múltiples instancias y romper la regla del Singleton.
    private ConexionBDSingleton() {
        // $ Aquí iría la lógica real de conexión (usuario, contraseña, URL, etc.)
        System.out.println("Conectandose algún motor de base de datos.");
    }

    //  # [3] Único punto de acceso global a la instancia.
    //  #  "static" permite llamarlo sin tener un objeto: ConexionBDSingleton.getInstance()
    //
    //  $   Flujo:
    //  $     - Primera llamada  → instancia == null → se crea el objeto y se guarda.
    //  $     - Llamadas siguientes → instancia ya existe → se devuelve el MISMO objeto.
    //
    //  $   Resultado: sin importar cuántas veces lo llames o desde dónde,
    //  $   siempre recibes el mismo objeto en la misma dirección de memoria.
    public static ConexionBDSingleton getInstance() {
        if (instancia == null) {
            // % Solo entra aquí UNA vez en toda la vida del programa.
            instancia = new ConexionBDSingleton();
        }
        // % A partir de la segunda llamada, salta directo aquí y devuelve el existente.
        return instancia;
    }
}
