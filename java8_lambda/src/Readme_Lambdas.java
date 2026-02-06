


public class Readme_Lambdas {
    /*
     // $ (Rosa)        -> Conceptos principales
     // ! (Rojo)        -> Advertencias / errores comunes
     // ? (Azul)        -> Preguntas para reflexionar / Sintaxis
     // * (Verde)       -> Buenas prácticas / Method References
     // % (Amarillo)    -> Ejemplos prácticos / casos reales / Cuándo usar
     // # (Naranja)     -> Detalles técnicos internos / Resúmenes
   */

// $ ============================================================================================================
// $ PARTE 1: FUNDAMENTOS DE LAMBDAS
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ SON LAS LAMBDAS?
// $ =====================================================
// $
// $ Las lambdas son funciones anónimas (sin nombre) que permiten:
// $ - Escribir código más limpio y conciso
// $ - Implementar INTERFACES FUNCIONALES de forma rápida
// $ - Introducir programación funcional en Java
// $
// $ Sintaxis básica: (parámetros) -> expresión o bloque de código
// $ Ejemplo: (a, b) -> a + b
// $
// $ Objetivos principales:
// $ - Reducir código boilerplate
// $ - Hacer el código más legible
// $ - Pasar comportamiento como parámetro
// $ - Facilitar el uso de Streams y APIs modernas
*/

/*
// ? =====================================================
// ? SINTAXIS DE UNA LAMBDA
// ? =====================================================
// ?
// ? Forma general:
// ? (parámetros) -> expresión
// ?
// ? Variaciones válidas:
// ? 1. (a, b) -> a + b                        // Una sola expresión
// ? 2. a -> a * 2                             // Un solo parámetro (sin paréntesis)
// ? 3. () -> "Hola"                           // Sin parámetros
// ? 4. (a, b) -> { return a + b; }            // Con bloque y return
// ?
// ? Reglas importantes:
// ? - Tipos se infieren (no es obligatorio declararlos)
// ? - Si hay UN solo parámetro, paréntesis son opcionales
// ? - Si hay UNA sola línea, return es implícito
// ? - Si hay bloque {}, se DEBE usar return explícitamente
*/

/*
// # =====================================================
// # EQUIVALENCIA: Lambda vs Código tradicional
// # =====================================================
// #
// # ANTES (Clase anónima):
// # Aritmetica suma = new Aritmetica() {
// #     public double operacion(double a, double b) {
// #         return a + b;
// #     }
// # };
// #
// # DESPUÉS (Lambda):
// # Aritmetica suma = (a, b) -> a + b;
// #
// # ¡Pasamos de 5 líneas a 1!
*/

// $ ============================================================================================================
// $ PARTE 2: INTERFACES FUNCIONALES
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ ES UNA INTERFAZ FUNCIONAL?
// $ =====================================================
// $
// $ Una INTERFAZ FUNCIONAL es aquella que tiene:
// $ - UN SOLO método abstracto
// $
// $ Puede tener adicionalmente:
// $ - Métodos default (con implementación)
// $ - Métodos static
// $ - Múltiples métodos heredados de Object
// $
// $ Se marca con @FunctionalInterface (opcional pero recomendado):
// $ - Obliga al compilador a verificar la regla
// $ - Lanza error si hay más de un método abstracto
// $ - Documenta la intención del diseñador
// $
// $ Las lambdas implementan estas interfaces de forma implícita.
*/

/*
// % =====================================================
// % EJEMPLO DE INTERFAZ FUNCIONAL PERSONALIZADA
// % =====================================================
// %
// % @FunctionalInterface
// % public interface Aritmetica {
// %     double operacion(double a, double b);  // Un solo método abstracto
// %
// %     // Estos SÍ están permitidos:
// %     default double abs(double n) {
// %         return Math.abs(n);
// %     }
// %
// %     static double pi() {
// %         return 3.14159;
// %     }
// % }
// %
// % USO:
// % Aritmetica suma = (a, b) -> a + b;
// % Aritmetica resta = (a, b) -> a - b;
// % Aritmetica multiplicacion = (a, b) -> a * b;
*/

/*
// ! =====================================================
// ! ERROR COMÚN: MÁS DE UN MÉTODO ABSTRACTO
// ! =====================================================
// !
// ! @FunctionalInterface
// ! public interface Aritmetica {
// !     double operacion(double a, double b);      // Método 1
// !     double otraOperacion(double x);            // Método 2 - ❌ ERROR
// ! }
// !
// ! Esto rompe la definición de interfaz funcional
// ! El compilador lanzará un error
*/

// $ ============================================================================================================
// $ PARTE 3: INTERFACES FUNCIONALES PRINCIPALES DE JAVA
// $ ============================================================================================================

/*
// $ =====================================================
// $ PAQUETE: java.util.function
// $ =====================================================
// $
// $ Java proporciona interfaces funcionales listas para usar.
// $ Las 7 más importantes son:
// $
// $ 1. Consumer<T>        -> Recibe 1 argumento, NO retorna nada (void)
// $ 2. BiConsumer<T,U>    -> Recibe 2 argumentos, NO retorna nada (void)
// $ 3. Supplier<T>        -> NO recibe argumentos, SÍ retorna algo
// $ 4. Function<T,R>      -> Recibe 1 argumento, retorna 1 valor
// $ 5. BiFunction<T,U,R>  -> Recibe 2 argumentos, retorna 1 valor
// $ 6. Predicate<T>       -> Recibe 1 argumento, retorna boolean
// $ 7. BiPredicate<T,U>   -> Recibe 2 argumentos, retorna boolean
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 1. CONSUMER<T> - Consume pero no devuelve
// $ ─────────────────────────────────────────────────────
// $
// $ Método: void accept(T t)
// $ Sintaxis lambda: (T t) -> { acción }
// $ Ejemplo: (String s) -> System.out.println(s)
// $
// % USO: Cuando quieres HACER ALGO con un valor pero NO necesitas retornar nada
// %
// % Ejemplos reales:
// % - Imprimir en consola
// % - Guardar en base de datos
// % - Enviar correo electrónico
// % - Modificar un objeto (setters)
// % - Logging
// % - Mostrar mensajes en UI
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 2. BiConsumer<T, U> - Consume DOS valores pero no devuelve
// $ ─────────────────────────────────────────────────────
// $
// $ Método: void accept(T t, U u)
// $ Ejemplo: (String nombre, Integer edad) -> System.out.println(nombre + " tiene " + edad)
// $
// % USO: Igual que Consumer pero con DOS parámetros
// %
// % Ejemplos reales:
// % - Imprimir nombre y edad de una persona
// % - Insertar clave-valor en un mapa
// % - Asignar un valor a un objeto (setter)
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 3. SUPPLIER<T> - Provee/Crea pero no recibe
// $ ─────────────────────────────────────────────────────
// $
// $ Método: T get()
// $ Ejemplo: () -> "Hola mundo"
// $ Ejemplo: () -> new Usuario()
// $
// % USO: Para CREAR o PROVEER objetos sin recibir parámetros
// %
// % Muy parecido a:
// % - Factory pattern
// % - Callable (pero más simple)
// %
// % Ejemplos reales:
// % - Crear objetos (factories)
// % - Generar valores por defecto
// % - Obtener configuraciones
// % - Generadores aleatorios
// % - Lazy initialization
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 4. FUNCTION<T, R> - Transforma/Convierte
// $ ─────────────────────────────────────────────────────
// $
// $ Método: R apply(T t)
// $ Ejemplo: (String s) -> s.toUpperCase()
// $ Ejemplo: (Integer n) -> n * 2
// $
// % USO: Para TRANSFORMAR un valor de un tipo a otro
// %
// % Ejemplos reales:
// % - Convertir String a Integer
// % - Convertir String a mayúsculas
// % - Aplicar operaciones matemáticas
// % - Mapear un objeto a otro
// % - Extraer propiedades de objetos
// % - Calcular valores derivados
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 5. BiFunction<T, U, R> - Combina DOS valores en UNO
// $ ─────────────────────────────────────────────────────
// $
// $ Método: R apply(T t, U u)
// $ Ejemplo: (String a, String b) -> a + b
// $ Ejemplo: (Integer a, Integer b) -> a + b
// $
// # Recordatorio de genéricos:
// # BiFunction<T, U, R>
// #     ↓      ↓   ↓
// # parámetro1 parámetro2 retorno
// #
// % Ejemplos reales:
// % - Sumar dos números
// % - Concatenar dos strings
// % - Comparar dos valores
// % - Combinar dos objetos en uno
// % - Operaciones matemáticas con dos operandos
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 6. PREDICATE<T> - Valida/Evalúa una condición
// $ ─────────────────────────────────────────────────────
// $
// $ Método: boolean test(T t)
// $ Ejemplo: (Integer n) -> n > 10
// $ Ejemplo: (String s) -> s.length() > 5
// $
// % USO: Para VALIDAR o FILTRAR basándose en condiciones
// %
// % Ejemplos reales:
// % - Validar si un número es par
// % - Verificar si un string cumple un patrón
// % - Filtrar listas
// % - Comparaciones
// % - Validaciones de negocio
// % - Permisos y roles
// % - Reglas de negocio
*/

/*
// $ ─────────────────────────────────────────────────────
// $ 7. BiPredicate<T, U> - Valida DOS valores
// $ ─────────────────────────────────────────────────────
// $
// $ Método: boolean test(T t, U u)
// $ Ejemplo: (Integer a, Integer b) -> a > b
// $ Ejemplo: (String a, String b) -> a.equals(b)
// $
// % USO: Para validar condiciones que involucran DOS valores
// %
// % Ejemplos reales:
// % - Comparar dos strings
// % - Verificar si un número es mayor que otro
// % - Validar permisos entre usuario y recurso
*/

// * ============================================================================================================
// * PARTE 4: METHOD REFERENCES (REFERENCIAS A MÉTODOS)
// * ============================================================================================================

/*
// * =====================================================
// * ¿QUÉ SON LAS METHOD REFERENCES?
// * =====================================================
// *
// * Son una forma MÁS CORTA de escribir lambdas
// * cuando la lambda solo llama a un método existente.
// *
// * Sintaxis: Clase::metodo
// *
// * Se usan cuando:
// * - La lambda SOLO llama a un método
// * - No hay lógica adicional
// *
// * Ventajas:
// * - Código más limpio
// * - Más legible
// * - Menos verboso
*/

/*
// * =====================================================
// * TIPOS DE METHOD REFERENCES
// * =====================================================
// *
// * 1. Referencia a método ESTÁTICO
// *    Sintaxis: Clase::metodoEstatico
// *    Lambda equivalente: (a, b) -> Math.max(a, b)
// *    Method reference: Math::max
// *
// * 2. Referencia a método de INSTANCIA de una clase
// *    Sintaxis: Clase::metodoInstancia
// *    Lambda equivalente: s -> s.toUpperCase()
// *    Method reference: String::toUpperCase
// *
// * 3. Referencia a método de OBJETO PARTICULAR
// *    Sintaxis: objeto::metodoInstancia
// *    Lambda equivalente: s -> System.out.println(s)
// *    Method reference: System.out::println
// *
// * 4. Referencia a CONSTRUCTOR
// *    Sintaxis: Clase::new
// *    Lambda equivalente: () -> new Usuario()
// *    Method reference: Usuario::new
*/

/*
// % =====================================================
// % EJEMPLOS DE CONVERSIÓN: Lambda → Method Reference
// % =====================================================
// %
// % Consumer<String> c1 = s -> System.out.println(s);
// % Consumer<String> c2 = System.out::println;         // ✓ Más corto
// %
// % Function<String, Integer> f1 = s -> s.length();
// % Function<String, Integer> f2 = String::length;     // ✓ Más corto
// %
// % Supplier<Usuario> s1 = () -> new Usuario();
// % Supplier<Usuario> s2 = Usuario::new;               // ✓ Más corto
// %
// % BiPredicate<String, String> p1 = (a, b) -> a.equals(b);
// % BiPredicate<String, String> p2 = String::equals;   // ✓ Más corto
// %
// % BiConsumer<Usuario, String> bc1 = (u, n) -> u.setNombre(n);
// % BiConsumer<Usuario, String> bc2 = Usuario::setNombre; // ✓ Más corto
*/

/*
// ! =====================================================
// ! LIMITACIÓN DE METHOD REFERENCES
// ! =====================================================
// !
// ! Si la firma del método NO coincide exactamente,
// ! Java NO permite usar method reference
// !
// ! Ejemplo que NO funciona:
// ! Function<String, String> f = String::substring;  // ❌ substring necesita parámetros
// !
// ! Debes usar lambda:
// ! Function<String, String> f = s -> s.substring(0, 3); // ✓
*/

// % ============================================================================================================
// % PARTE 5: CUÁNDO USAR CADA INTERFAZ FUNCIONAL
// % ============================================================================================================

/*
// % =====================================================
// % GUÍA RÁPIDA: ¿QUÉ INTERFAZ USAR?
// % =====================================================
// %
// % Pregúntate 3 cosas:
// %
// % 1️⃣ ¿Devuelve algo?
// %    NO → Consumer/BiConsumer
// %    SÍ → Continúa a pregunta 2
// %
// % 2️⃣ ¿Qué tipo devuelve?
// %    Boolean → Predicate/BiPredicate
// %    Otro tipo → Function/BiFunction o Supplier
// %
// % 3️⃣ ¿Cuántos parámetros recibe?
// %    0 parámetros → Supplier
// %    1 parámetro → Consumer, Function, o Predicate
// %    2 parámetros → BiConsumer, BiFunction, o BiPredicate
*/

/*
// % =====================================================
// % ESCENARIOS DE USO POR INTERFAZ
// % =====================================================
// %
// % Consumer/BiConsumer:
// % ─────────────────────
// % ✓ Imprimir en consola
// % ✓ Guardar en base de datos
// % ✓ Modificar un objeto (setters)
// % ✓ Logging
// % ✓ Enviar notificaciones
// % ✓ Actualizar UI
// %
// % Supplier:
// % ─────────
// % ✓ Factories (crear objetos)
// % ✓ Valores por defecto
// % ✓ Generadores aleatorios
// % ✓ Configuración lazy
// % ✓ Proveer datos sin contexto
// %
// % Function/BiFunction:
// % ───────────────────
// % ✓ Convertir String a Integer
// % ✓ Aplicar operaciones matemáticas
// % ✓ Mapear un objeto a otro
// % ✓ Concatenar, modificar strings
// % ✓ Transformaciones de datos
// % ✓ Cálculos derivados
// %
// % Predicate/BiPredicate:
// % ─────────────────────
// % ✓ Validar si un número es par
// % ✓ Verificar si un string cumple patrón
// % ✓ Filtrar listas
// % ✓ Comparaciones
// % ✓ Validaciones de negocio
// % ✓ Control de acceso
*/

// ! ============================================================================================================
// ! PARTE 6: ERRORES COMUNES Y CÓMO EVITARLOS
// ! ============================================================================================================

/*
// ! =====================================================
// ! ERROR 1: Confundir Consumer con Function
// ! =====================================================
// !
// ! ❌ INCORRECTO:
// ! Function<String, Void> mal = s -> System.out.println(s); // Void no es void!
// !
// ! ✓ CORRECTO:
// ! Consumer<String> bien = s -> System.out.println(s);
// !
// ! Recuerda:
// ! - Consumer NO devuelve nada (void)
// ! - Function SÍ devuelve algo
*/

/*
// ! =====================================================
// ! ERROR 2: No entender cuándo usar llaves {}
// ! =====================================================
// !
// ! ✓ Una sola expresión (sin llaves, return implícito):
// ! (a, b) -> a + b
// !
// ! ✓ Varias líneas (con llaves, return EXPLÍCITO):
// ! (a, b) -> {
// !     int suma = a + b;
// !     return suma;
// ! }
// !
// ! ❌ INCORRECTO (olvidar el return):
// ! (a, b) -> { a + b }  // ERROR! Falta return
*/

/*
// ! =====================================================
// ! ERROR 3: Confundir el orden de tipos genéricos
// ! =====================================================
// !
// ! BiFunction<String, Integer, Boolean> ejemplo;
// !            ↓          ↓        ↓
// !        parámetro1  parámetro2  tipo de retorno
// !
// ! Siempre: <Entrada1, Entrada2, Salida>
// !
// ! ❌ INCORRECTO:
// ! BiFunction<Boolean, String, Integer> mal;  // Orden confuso
*/

/*
// ! =====================================================
// ! ERROR 4: Modificar variables externas
// ! =====================================================
// !
// ! Las variables usadas en lambdas deben ser:
// ! - final (explícitamente)
// ! - o "effectively final" (no modificadas después de inicializadas)
// !
// ! ❌ INCORRECTO:
// ! int contador = 0;
// ! Consumer<String> mal = s -> contador++;  // ERROR! contador no es final
// !
// ! ✓ SOLUCIÓN 1: Usar estructuras mutables
// ! List<Integer> contador = new ArrayList<>();
// ! contador.add(0);
// ! Consumer<String> bien = s -> contador.set(0, contador.get(0) + 1);
// !
// ! ✓ SOLUCIÓN 2: Usar AtomicInteger
// ! AtomicInteger contador = new AtomicInteger(0);
// ! Consumer<String> bien = s -> contador.incrementAndGet();
*/

/*
// ! =====================================================
// ! ERROR 5: Lambdas demasiado largas o complejas
// ! =====================================================
// !
// ! ❌ INCORRECTO:
// ! Function<String, String> procesarTexto = texto -> {
// !     String limpio = texto.trim();
// !     String minusculas = limpio.toLowerCase();
// !     String sinEspacios = minusculas.replace(" ", "");
// !     String resultado = sinEspacios.substring(0, 10);
// !     return resultado.toUpperCase();
// ! };
// !
// ! ✓ MEJOR: Extraer a un método
// ! Function<String, String> procesarTexto = this::procesarTextoMetodo;
// !
// ! private String procesarTextoMetodo(String texto) {
// !     // ... lógica compleja aquí
// ! }
// !
// ! Regla general: Si tu lambda tiene más de 3 líneas, considera extraerla
*/

// ? ============================================================================================================
// ? PARTE 7: PATRONES ÚTILES Y TÉCNICAS AVANZADAS
// ? ============================================================================================================

/*
// ? =====================================================
// ? PATRÓN 1: Composición de funciones
// ? =====================================================
// ?
// ? Function tiene métodos para combinar funciones:
// ? - andThen(): Ejecuta esta función, LUEGO la otra
// ? - compose(): Ejecuta la otra función, LUEGO esta
// ?
// ? Ejemplo con andThen:
// ? Function<String, String> mayusculas = String::toUpperCase;
// ? Function<String, String> agregarHola = s -> "Hola " + s;
// ? Function<String, String> compuesta = mayusculas.andThen(agregarHola);
// ?
// ? String resultado = compuesta.apply("mundo");
// ? // Resultado: "Hola MUNDO"
// ? // Primero mayúsculas: "MUNDO"
// ? // Luego agregarHola: "Hola MUNDO"
*/

/*
// ? =====================================================
// ? PATRÓN 2: Predicados compuestos
// ? =====================================================
// ?
// ? Predicate tiene métodos para combinar condiciones:
// ? - and(): Ambas condiciones deben ser true
// ? - or(): Al menos una condición debe ser true
// ? - negate(): Invierte el resultado
// ?
// ? Ejemplo:
// ? Predicate<Integer> mayorQue10 = n -> n > 10;
// ? Predicate<Integer> menorQue20 = n -> n < 20;
// ? Predicate<Integer> entre10y20 = mayorQue10.and(menorQue20);
// ?
// ? boolean resultado = entre10y20.test(15);  // true
// ? boolean resultado2 = entre10y20.test(25); // false
// ?
// ? Predicate<Integer> noMayorQue10 = mayorQue10.negate();
// ? boolean resultado3 = noMayorQue10.test(5); // true
*/

/*
// ? =====================================================
// ? PATRÓN 3: Optional con lambdas
// ? =====================================================
// ?
// ? Optional se combina muy bien con lambdas:
// ?
// ? Optional<String> valor = Optional.ofNullable(obtenerValor());
// ?
// ? // Ejecutar acción si está presente
// ? valor.ifPresent(System.out::println);
// ?
// ? // Transformar el valor si existe
// ? Optional<Integer> longitud = valor.map(String::length);
// ?
// ? // Proveer valor por defecto
// ? String resultado = valor.orElseGet(() -> "Valor por defecto");
// ?
// ? // Filtrar basado en condición
// ? Optional<String> filtrado = valor.filter(s -> s.length() > 5);
*/

// # ============================================================================================================
// # PARTE 8: GUÍA DE ESTRATEGIAS PARA RESOLVER EJERCICIOS
// # ============================================================================================================

/*
// # =====================================================
// # MÉTODO DE LOS 5 PASOS
// # =====================================================
// #
// # Cuando te enfrentes a CUALQUIER ejercicio:
// #
// # PASO 1: ¿QUÉ RECIBO? ¿QUÉ DEVUELVO?
// # ────────────────────────────────────
// # Identifica claramente inputs y outputs
// #
// # Ejemplo: "Cuenta cuántas veces aparece cada palabra"
// # ✓ RECIBO: String (la frase)
// # ✓ DEVUELVO: Map<String, Integer> (palabra -> cantidad)
// #
// # Con esto sabes qué interfaz usar:
// # - Devuelve void → Consumer/BiConsumer
// # - Devuelve boolean → Predicate/BiPredicate
// # - Devuelve otra cosa → Function/BiFunction/Supplier
// #
// #
// # PASO 2: DIVIDE EN PASOS PEQUEÑOS
// # ──────────────────────────────────
// # NO intentes resolver todo de una vez
// #
// # Mini-tareas:
// # a. Limpiar la frase
// # b. Dividir en palabras
// # c. Contar cada palabra
// # d. Encontrar cuál tiene el máximo
// # e. Retornar resultado
// #
// #
// # PASO 3: EMPIEZA CON LO QUE SÍ SABES
// # ────────────────────────────────────
// # Siempre hay algo que puedes hacer
// # Escribe ese código primero
// # El código parcial es mejor que ningún código
// #
// #
// # PASO 4: USA ESTRUCTURAS CONOCIDAS
// # ──────────────────────────────────
// # Aprende los 3 patrones básicos de HashMap:
// #
// # A) Contar elementos
// # B) Agrupar elementos
// # C) Encontrar el máximo
// #
// # (Ver sección siguiente)
// #
// #
// # PASO 5: PRUEBA Y AJUSTA
// # ───────────────────────
// # No esperes perfección
// # Ejecuta → Ve qué pasa → Ajusta
*/

/*
// # =====================================================
// # 3 PATRONES BÁSICOS DE HASHMAP
// # =====================================================
// #
// # PATRÓN A: Contar elementos
// # ─────────────────────────
// # Map<String, Integer> conteo = new HashMap<>();
// # for (String elemento : arreglo) {
// #     if (conteo.containsKey(elemento)) {
// #         conteo.put(elemento, conteo.get(elemento) + 1);
// #     } else {
// #         conteo.put(elemento, 1);
// #     }
// # }
// #
// # // O más corto con getOrDefault:
// # conteo.put(elemento, conteo.getOrDefault(elemento, 0) + 1);
// #
// #
// # PATRÓN B: Agrupar elementos
// # ───────────────────────────
// # Map<String, List<String>> grupos = new HashMap<>();
// # for (String elemento : arreglo) {
// #     String categoria = determinarCategoria(elemento);
// #
// #     if (!grupos.containsKey(categoria)) {
// #         grupos.put(categoria, new ArrayList<>());
// #     }
// #     grupos.get(categoria).add(elemento);
// # }
// #
// #
// # PATRÓN C: Encontrar el máximo
// # ─────────────────────────────
// # String elementoMax = null;
// # int valorMax = 0;
// #
// # for (Map.Entry<String, Integer> entry : map.entrySet()) {
// #     if (entry.getValue() > valorMax) {
// #         valorMax = entry.getValue();
// #         elementoMax = entry.getKey();
// #     }
// # }
*/

/*
// # =====================================================
// # RECETAS RÁPIDAS PARA PROBLEMAS COMUNES
// # =====================================================
// #
// # RECETA 1: Limpiar/preparar texto
// # ────────────────────────────────
// # String limpio = texto.toLowerCase()
// #                      .replace(".", "")
// #                      .replace(",", "")
// #                      .replace("!", "");
// # String[] palabras = limpio.split(" ");
// #
// #
// # RECETA 2: Ordenar un Map por valores
// # ─────────────────────────────────────
// # List<Map.Entry<String, Integer>> lista = new ArrayList<>(map.entrySet());
// # Collections.sort(lista, (e1, e2) -> e2.getValue() - e1.getValue());
// # // e2 - e1 = descendente (mayor a menor)
// # // e1 - e2 = ascendente (menor a mayor)
// #
// #
// # RECETA 3: HashMap con valores por defecto
// # ─────────────────────────────────────────
// # // En lugar de:
// # if (!map.containsKey(clave)) {
// #     map.put(clave, new ArrayList<>());
// # }
// # map.get(clave).add(elemento);
// #
// # // Usa computeIfAbsent:
// # map.computeIfAbsent(clave, k -> new ArrayList<>()).add(elemento);
*/

// # ============================================================================================================
// # PARTE 9: CHEAT SHEET Y RESUMEN RÁPIDO
// # ============================================================================================================

/*
// # =====================================================
// # CHEAT SHEET COMPLETO
// # =====================================================
// #
// # INTERFAZ          MÉTODO      RECIBE        DEVUELVE      EJEMPLO
// # ──────────────────────────────────────────────────────────────────────────────
// # Consumer<T>       accept      T             void          s -> System.out.println(s)
// # BiConsumer<T,U>   accept      T, U          void          (a,b) -> System.out.println(a+b)
// # Supplier<T>       get         nada          T             () -> "Hola"
// # Function<T,R>     apply       T             R             s -> s.length()
// # BiFunction<T,U,R> apply       T, U          R             (a,b) -> a + b
// # Predicate<T>      test        T             boolean       n -> n > 0
// # BiPredicate<T,U>  test        T, U          boolean       (a,b) -> a.equals(b)
// #
// #
// # MÉTODOS ÚTILES:
// # ───────────────
// # Function:  andThen(), compose()
// # Predicate: and(), or(), negate()
// # Map:       getOrDefault(), computeIfAbsent(), forEach()
// # Optional:  ifPresent(), map(), filter(), orElseGet()
*/

/*
// # =====================================================
// # REGLAS DE ORO
// # =====================================================
// #
// # 1. ¿Devuelve algo? NO → Consumer
// #                    SÍ → ¿Boolean? → Predicate
// #                         ¿Otro? → Function o Supplier
// #
// # 2. Lambdas cortas (máximo 3 líneas)
// #    Si es más largo → Extraer a método
// #
// # 3. Variables en lambdas deben ser final o effectively final
// #
// # 4. Method reference cuando sea posible
// #    s -> s.toUpperCase()  →  String::toUpperCase
// #
// # 5. Con HashMap, usa getOrDefault() para contadores
// #
// # 6. Divide problemas complejos en pasos pequeños
// #
// # 7. Prueba frecuentemente, no esperes a terminar todo
*/

// ? ============================================================================================================
// ? PARTE 10: PREGUNTAS FRECUENTES Y CASOS ESPECIALES
// ? ============================================================================================================

/*
// ? =====================================================
// ? CUÁNDO USAR LAMBDAS VS CLASES NORMALES
// ? =====================================================
// ?
// ? USA LAMBDAS cuando:
// ? ✓ La lógica es simple (1-3 líneas)
// ? ✓ Solo se usa en un lugar
// ? ✓ Es una operación puntual
// ? ✓ No necesitas estado complejo
// ?
// ? USA CLASES cuando:
// ? ✓ La lógica es compleja (más de 5 líneas)
// ? ✓ Se reutiliza en varios lugares
// ? ✓ Necesitas mantener estado
// ? ✓ Requieres múltiples métodos
// ? ✓ Necesitas mejor testabilidad
*/

/*
// ? =====================================================
// ? ¿CUÁNDO USAR QUÉ TIPO DE MAP?
// ? =====================================================
// ?
// ? HashMap:
// ? - Uso general
// ? - Sin orden específico
// ? - Mejor rendimiento
// ? ✓ Úsalo por defecto
// ?
// ? LinkedHashMap:
// ? - Mantiene orden de inserción
// ? - Útil para preservar secuencia
// ?
// ? TreeMap:
// ? - Ordena claves automáticamente
// ? - Útil cuando necesitas orden alfabético/numérico
// ?
// ? Para ejercicios básicos: siempre HashMap
*/

/*
// ? =====================================================
// ? PREGUNTAS TÍPICAS DE EXAMEN/ENTREVISTA
// ? =====================================================
// ?
// ? 1. ¿Qué es una interfaz funcional?
// ?    → Interfaz con UN SOLO método abstracto
// ?
// ? 2. ¿Cuántos métodos abstractos puede tener?
// ?    → Uno solo (pero puede tener default y static)
// ?
// ? 3. ¿Para qué sirve @FunctionalInterface?
// ?    → Validar en tiempo de compilación
// ?
// ? 4. ¿Diferencia entre Consumer y Supplier?
// ?    → Consumer recibe pero no devuelve
// ?    → Supplier no recibe pero sí devuelve
// ?
// ? 5. ¿Cuándo usar Predicate?
// ?    → Para validaciones que retornan boolean
// ?
// ? 6. ¿Qué es un method reference?
// ?    → Forma corta de lambda que solo llama un método
// ?
// ? 7. ¿Puede una lambda modificar variables externas?
// ?    → No, deben ser final o effectively final
// ?
// ? 8. ¿Diferencia entre map() y flatMap() en Streams?
// ?    → map() transforma 1 a 1
// ?    → flatMap() transforma 1 a muchos y aplana
// ?
// ? 9. ¿Por qué las lambdas mejoran la legibilidad?
// ?    → Reducen boilerplate y expresan intención claramente
// ?
// ? 10. ¿Cuándo NO usar lambdas?
// ?     → Cuando la lógica es compleja o se reutiliza mucho
*/

// # ============================================================================================================
// # PARTE 11: EJERCICIOS MENTALES
// # ============================================================================================================

/*
// # =====================================================
// # EJERCICIO MENTAL 1: ¿Qué interfaz usarías para...?
// # =====================================================
// #
// # • Validar si un email es válido
// #   → Predicate<String>
// #
// # • Crear un objeto Usuario
// #   → Supplier<Usuario>
// #
// # • Sumar dos números
// #   → BiFunction<Integer, Integer, Integer>
// #
// # • Imprimir un nombre en consola
// #   → Consumer<String>
// #
// # • Comparar dos strings
// #   → BiPredicate<String, String> o BiFunction<String, String, Integer>
// #
// # • Convertir String a Integer
// #   → Function<String, Integer>
// #
// # • Generar un número aleatorio
// #   → Supplier<Integer>
// #
// # • Guardar usuario en base de datos
// #   → Consumer<Usuario>
// #
// # • Verificar si un número es par
// #   → Predicate<Integer>
// #
// # • Asignar nombre a un usuario
// #   → BiConsumer<Usuario, String>
*/

/*
// # =====================================================
// # EJERCICIO MENTAL 2: Convierte a method reference
// # =====================================================
// #
// # (s) -> s.toUpperCase()
// # → String::toUpperCase
// #
// # (u) -> u.getNombre()
// # → Usuario::getNombre
// #
// # () -> new Usuario()
// # → Usuario::new
// #
// # (s) -> System.out.println(s)
// # → System.out::println
// #
// # (a, b) -> Math.max(a, b)
// # → Math::max
// #
// # (s) -> s.length()
// # → String::length
// #
// # (a, b) -> a.equals(b)
// # → String::equals
// #
// # (a, b) -> Integer.sum(a, b)
// # → Integer::sum
*/

// $ ============================================================================================================
// $ PARTE 12: RESUMEN FINAL Y MEJORES PRÁCTICAS
// $ ============================================================================================================

/*
// $ =====================================================
// $ RESUMEN FINAL
// $ =====================================================
// $
// $ Lambda = Implementación concisa de interfaces funcionales
// $
// $ Beneficios:
// $ ✓ Menos código boilerplate
// $ ✓ Más expresivo y legible
// $ ✓ Más flexible
// $ ✓ Facilita programación funcional
// $
// $ Base para:
// $ ✓ Streams API
// $ ✓ Optional
// $ ✓ APIs modernas de Java
// $ ✓ Programación reactiva
// $
// $ Recuerda:
// $ - Mantén lambdas simples
// $ - Usa method references cuando sea posible
// $ - Conoce las interfaces funcionales estándar
// $ - Practica con HashMap y colecciones
// $ - Divide problemas complejos en pasos pequeños
*/

/*
// * =====================================================
// * MEJORES PRÁCTICAS (BEST PRACTICES)
// * =====================================================
// *
// * 1. SIMPLICIDAD
// *    ✓ Lambdas cortas (máximo 3 líneas)
// *    ✗ Evita lógica compleja dentro de lambdas
// *
// * 2. LEGIBILIDAD
// *    ✓ Usa method references cuando sea más claro
// *    ✓ Nombres descriptivos en variables lambda
// *    ✗ No sacrifiques claridad por brevedad extrema
// *
// * 3. EFECTOS SECUNDARIOS
// *    ✓ Lambdas deben ser puras (sin side effects)
// *    ✗ Evita modificar estado externo
// *    ✗ No cambies variables fuera de la lambda
// *
// * 4. EXCEPCIONES
// *    ✓ Maneja excepciones apropiadamente
// *    ✓ Considera envolver en RuntimeException si es necesario
// *
// * 5. REUTILIZACIÓN
// *    ✓ Lambdas complejas → Métodos separados
// *    ✓ Lógica reutilizable → Clases o métodos utilitarios
// *
// * 6. TIPOS
// *    ✓ Confía en inferencia de tipos
// *    ✓ Declara tipos solo si mejora claridad
// *
// * 7. TESTING
// *    ✓ Lambdas simples son fáciles de testear
// *    ✓ Lógica compleja debe estar en métodos testeables
*/

/*
// $ =====================================================
// $ CASOS DE USO REALES EN PROYECTOS
// $ =====================================================
// $
// $ ✔ Validación de datos de entrada
// $ ✔ Transformación de DTOs a entidades
// $ ✔ Filtrado de colecciones
// $ ✔ Procesamiento de archivos
// $ ✔ Manejo de eventos
// $ ✔ Callbacks asíncronos
// $ ✔ Configuración condicional
// $ ✔ Builders y factories
// $ ✔ Estrategias intercambiables
// $ ✔ Pipeline de transformaciones
*/

/*
// # =====================================================
// # RECORDATORIOS FINALES
// # =====================================================
// #
// # ☑ Las lambdas NO reemplazan todo
// # ☑ Son una herramienta más en tu arsenal
// # ☑ Úsalas donde aporten valor
// # ☑ La práctica hace al maestro
// # ☑ Empieza con ejemplos simples
// # ☑ Construye complejidad gradualmente
// # ☑ Consulta esta guía cuando tengas dudas
// #
// # ¡ÉXITO EN TU APRENDIZAJE! 🚀
*/
}
