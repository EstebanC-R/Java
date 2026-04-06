public class Readme_Recursividad {
    // * =====================================================
    // * RECURSIVIDAD EN JAVA
    // * =====================================================


    // ? =====================================================
    // ? ¿QUÉ ES LA RECURSIVIDAD?
    // ? =====================================================

    // ? Es cuando un método se llama a sí mismo
    // ? para resolver un problema más pequeño.


    // ? Ejemplo mental:
    // ? Para subir una escalera:
    // ? Paso 1 → subo un escalón
    // ? Paso 2 → subo otro
    // ? Paso 3 → subo otro
    // ? Hasta llegar arriba


    // ! TODA RECURSIVIDAD NECESITA 3 COSAS:

    // ! 1. CASO BASE → cuándo parar
    // ! 2. LLAMADA RECURSIVA → el método se llama a sí mismo
    // ! 3. PROGRESO → cada llamada se acerca al final


    // # =====================================================
    // # EJEMPLO SIMPLE
    // # =====================================================

    /*
    public static void contar(int n){
        if(n == 0) return;   // caso base

        System.out.println(n);
        contar(n - 1);       // llamada recursiva
    }
    */


    // # =====================================================
    // # ¿POR QUÉ USAR RECURSIVIDAD?
    // # =====================================================

    // * Cuando trabajas con estructuras jerárquicas:
    // * - Árboles
    // * - Carpetas
    // * - HTML DOM
    // * - Componentes anidados


    // # =====================================================
    // # EJEMPLO REAL: COMPONENTES DE UN PC
    // # =====================================================

    // PC
    // ├── Fuente
    // ├── Placa
    // │   ├── CPU
    // │   │   └── Ventilador
    // │   └── RAM
    // └── Mouse


    // # =====================================================
    // # MÉTODO RECURSIVO CLÁSICO
    // # =====================================================

    /*
    public static void recorrer(Componente c, int nivel){

        System.out.println("\t".repeat(nivel) + c.getNombre());

        if(c.tieneHijos()){
            for(Componente hijo : c.getHijos()){
                recorrer(hijo, nivel + 1);
            }
        }
    }
    */


    // $ ¿Qué pasa aquí?

    // $ 1. Imprime el componente actual
    // $ 2. Si tiene hijos:
    // $    → llama al método otra vez
    // $ 3. Cada llamada baja un nivel más


    // # =====================================================
    // # CÓMO PIENSA LA RECURSIVIDAD
    // # =====================================================

    // ? La regla mental es:

    // ? "Yo me encargo de UN nivel"
    // ? "La recursividad se encarga del resto"


    // # =====================================================
    // # PASO A PASO MENTAL
    // # =====================================================

    // recorrer(PC)

    // imprime PC
    // llama recorrer(Fuente)
    // llama recorrer(Placa)
    // llama recorrer(Mouse)

    // recorrer(Placa)
    // imprime Placa
    // llama recorrer(CPU)


    // ! Observa:
    // ! Cada llamada solo se preocupa por su propio nodo


    // # =====================================================
    // # ERRORES COMUNES
    // # =====================================================

    // ! No tener caso base → StackOverflow
    // ! Modificar mal el parámetro → bucle infinito
    // ! Pensar en todas las llamadas al mismo tiempo


    // # =====================================================
    // # AHORA: RECURSIVIDAD CON STREAM
    // # =====================================================

    // ! Este método hace lo mismo
    // ! pero en vez de imprimir devuelve datos


    /*
    public static Stream<Componente> metodoRecursivoStreamJava8(Componente c, int nivel){
        c.setNivel(nivel);

        return Stream.concat(
            Stream.of(c),
            c.getHijos().stream()
                .flatMap(hijo -> metodoRecursivoStreamJava8(hijo, nivel + 1))
        );
    }
    */


    // $ Cómo entenderlo fácil:

    // $ Devuelve:
    // $ YO + MIS HIJOS + HIJOS DE MIS HIJOS


    // # =====================================================
    // # DESGLOSE SIMPLE
    // # =====================================================

    // Stream.of(c)
    // → stream con el componente actual

    // c.getHijos().stream()
    // → stream de los hijos

    // flatMap(...)
    // → convierte cada hijo en:
    //    hijo + descendientes

    // Stream.concat()
    // → une todo


    // # =====================================================
    // # DIFERENCIA CLAVE
    // # =====================================================

    // * Método clásico:
    // * imprime directamente

    // * Método con Stream:
    // * devuelve los datos


    // # =====================================================
    // # CUÁNDO USAR RECURSIVIDAD
    // # =====================================================

    // * Árboles
    // * Carpetas
    // * Estructuras jerárquicas
    // * Algoritmos DFS


    // # =====================================================
    // # RESUMEN PARA MEMORIZAR
    // # =====================================================

    // ! Recursividad = método que se llama a sí mismo
    // ! Necesita caso base
    // ! Cada llamada reduce el problema
    // ! Piensa en:
    // ! YO + EL RESTO

}
