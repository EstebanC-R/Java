

/*
     // $ (Rosa)        -> Conceptos principales
     // ! (Rojo)        -> Advertencias / errores comunes
     // ? (Azul)        -> Preguntas para reflexionar / Comparaciones
     // * (Verde)       -> Buenas prácticas / Optimizaciones
     // % (Amarillo)    -> Ejemplos prácticos / casos reales
     // # (Naranja)     -> Detalles técnicos internos / Resúmenes
*/

public class Readme_Streams {


// $ ============================================================================================================
// $ PARTE 1: FUNDAMENTOS DE STREAMS
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ ES UN STREAM?
// $ =====================================================
// $
// $ Stream es una SECUENCIA DE DATOS que permite procesar
// $ colecciones de forma:
// $
// $ ✔ DECLARATIVA    (dices QUÉ quieres, no CÓMO)
// $ ✔ FUNCIONAL      (sin bucles ni variables mutables)
// $ ✔ ENCADENADA     (múltiples operaciones en cadena)
// $ ✔ INMUTABLE      (NO modifica la fuente original)
// $
// $ Características clave:
// $ ───────────────────────
// $ • NO almacena datos (solo los procesa)
// $ • NO es una colección (es un flujo)
// $ • Se recorre UNA SOLA VEZ (luego se cierra)
// $ • Evaluación perezosa (lazy evaluation)
// $ • Puede ser paralelo (procesamiento concurrente)
*/

/*
// ? =====================================================
// ? ANTES vs DESPUÉS: Imperativo vs Streams
// ? =====================================================
// ?
// ? ANTES (Imperativo - con bucles):
// ? ─────────────────────────────────
// ? List<String> resultado = new ArrayList<>();
// ? for (String nombre : nombres) {
// ?     if (nombre.startsWith("P")) {
// ?         String mayuscula = nombre.toUpperCase();
// ?         resultado.add(mayuscula);
// ?     }
// ? }
// ?
// ? DESPUÉS (Declarativo - con Streams):
// ? ────────────────────────────────────
// ? List<String> resultado = nombres.stream()
// ?     .filter(n -> n.startsWith("P"))
// ?     .map(String::toUpperCase)
// ?     .collect(Collectors.toList());
// ?
// ? ¡Más corto, más claro, más expresivo!
*/

/*
// % =====================================================
// % ¿CUÁNDO USAR STREAMS?
// % =====================================================
// %
// % USA Streams cuando necesites:
// % ✓ Filtrar datos según condiciones
// % ✓ Transformar objetos de un tipo a otro
// % ✓ Buscar elementos específicos
// % ✓ Contar, sumar, promediar, estadísticas
// % ✓ Eliminar duplicados
// % ✓ Agrupar o clasificar datos
// % ✓ Evitar bucles for/while anidados
// % ✓ Procesar datos de forma más legible
// %
// % NO uses Streams cuando:
// % ✗ La operación es muy simple (1-2 líneas)
// % ✗ Necesitas modificar la colección original
// % ✗ Necesitas acceso por índice frecuente
// % ✗ El rendimiento es crítico en colecciones pequeñas
*/

/*
// ! =====================================================
// ! REGLA DE ORO: UN STREAM SE USA UNA SOLA VEZ
// ! =====================================================
// !
// ! ❌ INCORRECTO:
// ! Stream<String> nombres = lista.stream();
// ! nombres.forEach(System.out::println);  // Primera vez: OK
// ! nombres.count();                        // ERROR: Stream cerrado
// !
// ! ✓ CORRECTO:
// ! lista.stream().forEach(System.out::println);  // Crear y usar
// ! long total = lista.stream().count();          // Crear nuevo Stream
// !
// ! Una vez que ejecutas una OPERACIÓN TERMINAL,
// ! el Stream se cierra y no se puede reutilizar.
*/

// $ ============================================================================================================
// $ PARTE 2: CREACIÓN DE STREAMS
// $ ============================================================================================================

/*
// $ =====================================================
// $ FORMAS DE CREAR UN STREAM
// $ =====================================================
// $
// $ 1. Stream.of() - Desde valores directos
// $ ───────────────────────────────────────
// $ Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa");
// $
// $
// $ 2. Arrays.stream() - Desde un array
// $ ───────────────────────────────────────
// $ String[] arr = {"Pato", "Paco", "Pepa"};
// $ Stream<String> nombres = Arrays.stream(arr);
// $
// $
// $ 3. Collection.stream() - Desde colección
// $ ───────────────────────────────────────
// $ List<String> lista = Arrays.asList("Pato", "Paco", "Pepa");
// $ Stream<String> nombres = lista.stream();
// $
// $
// $ 4. Stream.builder() - Constructor fluido
// $ ───────────────────────────────────────
// $ Stream<String> nombres = Stream.<String>builder()
// $     .add("Pato")
// $     .add("Paco")
// $     .add("Pepa")
// $     .build();
// $
// $
// $ 5. Stream.generate() - Stream infinito con Supplier
// $ ───────────────────────────────────────
// $ Stream.generate(() -> "Hola")
// $     .limit(5)
// $     .forEach(System.out::println);
// $
// $
// $ 6. IntStream.range() / rangeClosed() - Rangos numéricos
// $ ───────────────────────────────────────
// $ IntStream.range(1, 10)       // 1, 2, 3, ... 9 (sin incluir 10)
// $ IntStream.rangeClosed(1, 10) // 1, 2, 3, ... 10 (incluye 10)
*/

/*
// % =====================================================
// % EJEMPLO PRÁCTICO: Diferentes formas de crear Streams
// % =====================================================
// %
// % // Forma 1: Desde valores
// % Stream.of("Ana", "Pedro", "Luis").forEach(System.out::println);
// %
// % // Forma 2: Desde lista
// % List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
// % numeros.stream().map(n -> n * 2).forEach(System.out::println);
// %
// % // Forma 3: Generar números
// % IntStream.range(1, 6).forEach(System.out::println);  // 1,2,3,4,5
*/

// $ ============================================================================================================
// $ PARTE 3: OPERACIONES INTERMEDIAS (Intermediate Operations)
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ SON LAS OPERACIONES INTERMEDIAS?
// $ =====================================================
// $
// $ Son operaciones que:
// $ • Retornan un NUEVO Stream
// $ • Permiten ENCADENAR más operaciones
// $ • Son LAZY (solo se ejecutan cuando hay terminal)
// $ • NO modifican la fuente original
// $
// $ Principales operaciones intermedias:
// $ • filter()      - Filtrar elementos
// $ • map()         - Transformar elementos
// $ • flatMap()     - Aplanar estructuras anidadas
// $ • distinct()    - Eliminar duplicados
// $ • sorted()      - Ordenar elementos
// $ • peek()        - Inspeccionar sin modificar
// $ • limit()       - Limitar cantidad
// $ • skip()        - Saltar elementos
*/

/*
// $ ──────────────────────────────────────────────────
// $ 1. filter() - FILTRAR elementos
// $ ──────────────────────────────────────────────────
// $
// $ Recibe: Predicate<T> (condición booleana)
// $ Retorna: Stream con elementos que cumplen la condición
// $ Uso: Seleccionar elementos según criterio
// $
// % EJEMPLOS:
// %
// % // Filtrar usuarios llamados "Pepe"
// % usuarios.stream()
// %     .filter(u -> u.getNombre().equals("Pepe"))
// %
// % // Filtrar números pares
// % numeros.stream()
// %     .filter(n -> n % 2 == 0)
// %
// % // Filtrar strings NO vacíos
// % textos.stream()
// %     .filter(s -> !s.isEmpty())
// %     // O más corto:
// %     .filter(String::isEmpty)  // Para contar vacíos
*/

/*
// * ──────────────────────────────────────────────────
// * BUENA PRÁCTICA: Filtrar lo antes posible
// * ──────────────────────────────────────────────────
// *
// * ✓ MEJOR: filter primero, luego map
// * usuarios.stream()
// *     .filter(u -> u.getEdad() > 18)  // Reduce elementos PRIMERO
// *     .map(Usuario::getNombre)         // Transforma menos elementos
// *
// * ✗ PEOR: map primero, luego filter
// * usuarios.stream()
// *     .map(Usuario::getNombre)         // Transforma TODOS
// *     .filter(n -> n.length() > 5)    // Filtra después (ineficiente)
// *
// * Razón: Filtrar primero reduce el número de elementos
// * que pasan por las operaciones posteriores.
*/

/*
// $ ──────────────────────────────────────────────────
// $ 2. map() - TRANSFORMAR elementos
// $ ──────────────────────────────────────────────────
// $
// $ Recibe: Function<T, R> (transforma T en R)
// $ Retorna: Stream<R> (nuevo tipo)
// $ Uso: Convertir cada elemento de un tipo a otro
// $
// $ Relación: 1 a 1 (un elemento genera un elemento)
// $
// % EJEMPLOS:
// %
// % // String → Usuario
// % Stream.of("Pato Guzman", "Paco Gonzales")
// %     .map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
// %
// % // Usuario → String (nombre completo)
// % usuarios.stream()
// %     .map(u -> u.getNombre() + " " + u.getApellido())
// %
// % // String → Integer (longitud)
// % palabras.stream()
// %     .map(String::length)
// %
// % // String → String (mayúsculas)
// % palabras.stream()
// %     .map(String::toUpperCase)
// %
// % // Usuario → String (solo nombre)
// % usuarios.stream()
// %     .map(Usuario::getNombre)
*/

/*
// ? ──────────────────────────────────────────────────
// ? map() ENCADENADO: Múltiples transformaciones
// ? ──────────────────────────────────────────────────
// ?
// ? Puedes encadenar múltiples maps:
// ?
// ? usuarios.stream()
// ?     .map(Usuario::getNombre)           // Usuario → String
// ?     .map(String::toUpperCase)          // String → String
// ?     .map(nombre -> "Sr. " + nombre)    // String → String
// ?
// ? Cada map transforma el resultado del anterior
*/

/*
// $ ──────────────────────────────────────────────────
// $ 3. flatMap() - APLANAR estructuras anidadas
// $ ──────────────────────────────────────────────────
// $
// $ REGLA SIMPLE:
// $
// $ map()     = Transformar UN elemento en OTRO elemento
// $             Ejemplo: Usuario → su nombre (String)
// $             Relación: 1 → 1
// $
// $ flatMap() = "Abrir" lo que hay DENTRO de cada elemento
// $             Ejemplo: Usuario → TODAS sus facturas
// $             Relación: 1 → muchos
// $
// $ ¿Cuándo usar cada uno?
// $
// $ Usa map() cuando:
// $ • Sacas UN dato de un objeto (nombre, edad, email)
// $ • Conviertes un tipo en otro (String → Integer)
// $ • Cada elemento se vuelve OTRO elemento
// $
// $ Usa flatMap() cuando:
// $ • El objeto tiene una LISTA/COLECCIÓN dentro
// $ • Quieres acceder a los elementos de esa lista
// $ • Cada elemento se "desdobla" en VARIOS elementos
// $
// % EJEMPLO VISUAL:
// %
// % Tienes 2 usuarios, cada uno con 2 facturas:
// %
// % Usuario1 → [Factura1, Factura2]
// % Usuario2 → [Factura3, Factura4]
// %
// % Con map():
// % usuarios.stream()
// %     .map(Usuario::getFacturas)
// %
// % Resultado: [[Factura1, Factura2], [Factura3, Factura4]]
// %            ↑ Stream de LISTAS (anidado) ❌
// %
// % Con flatMap():
// % usuarios.stream()
// %     .flatMap(u -> u.getFacturas().stream())
// %
// % Resultado: [Factura1, Factura2, Factura3, Factura4]
// %            ↑ Stream de FACTURAS (plano) ✓
// %
// % flatMap "aplana" o "desempaca" las listas internas
*/

/*
// ? ──────────────────────────────────────────────────
// ? map() vs flatMap() - LA DIFERENCIA CLAVE
// ? ──────────────────────────────────────────────────
// ?
// ? map():
// ? ─────
// ? • 1 elemento → 1 elemento
// ? • Transformación directa
// ? • Stream<T> → Stream<R>
// ?
// ? flatMap():
// ? ─────────
// ? • 1 elemento → 0 o más elementos
// ? • "Desenvuelve" colecciones
// ? • Stream<T> → Stream<R> (aplanado)
// ?
// ? EJEMPLO VISUAL:
// ? ──────────────
// ? Datos: [Usuario1, Usuario2]
// ? Cada Usuario tiene: [Factura1, Factura2]
// ?
// ? Con map():
// ? [[Factura1, Factura2], [Factura1, Factura2]]  ❌ Anidado
// ?
// ? Con flatMap():
// ? [Factura1, Factura2, Factura1, Factura2]      ✓ Plano
*/

/*
// % ──────────────────────────────────────────────────
// % EJEMPLO PRÁCTICO: flatMap con filtrado condicional
// % ──────────────────────────────────────────────────
// %
// % // Solo usuarios llamados "Pepe"
// % usuarios.stream()
// %     .flatMap(u -> {
// %         if (u.getNombre().equals("Pepe")) {
// %             return Stream.of(u);  // Incluir este usuario
// %         }
// %         return Stream.empty();     // Excluir este usuario
// %     })
// %
// % Esto es equivalente a filter(), pero muestra
// % la flexibilidad de flatMap para decidir cuántos
// % elementos generar (0, 1, o muchos).
*/

/*
// $ ──────────────────────────────────────────────────
// $ 4. distinct() - ELIMINAR duplicados
// $ ──────────────────────────────────────────────────
// $
// $ Elimina elementos duplicados basándose en equals()
// $
// $ NO recibe parámetros
// $ Retorna: Stream sin duplicados
// $
// % EJEMPLOS:
// %
// % // Eliminar strings duplicados
// % Stream.of("Pato", "Paco", "Pato", "Pepa", "Paco")
// %     .distinct()
// %     // Resultado: "Pato", "Paco", "Pepa"
// %
// % // Eliminar usuarios duplicados
// % usuarios.stream()
// %     .distinct()
// %     // Usa equals() y hashCode() de Usuario
*/

/*
// ! ──────────────────────────────────────────────────
// ! IMPORTANTE: distinct() y equals()/hashCode()
// ! ──────────────────────────────────────────────────
// !
// ! Para que distinct() funcione correctamente con objetos,
// ! la clase DEBE sobrescribir:
// !
// ! 1. equals()    - Determina si dos objetos son iguales
// ! 2. hashCode()  - Calcula hash para comparación eficiente
// !
// ! ❌ SIN equals/hashCode:
// ! class Usuario {
// !     String nombre;
// !     // NO sobrescribe equals/hashCode
// ! }
// ! // distinct() comparará por referencia, no por contenido
// !
// ! ✓ CON equals/hashCode:
// ! class Usuario {
// !     String nombre;
// !
// !     @Override
// !     public boolean equals(Object o) {
// !         if (o == null || getClass() != o.getClass()) return false;
// !         Usuario u = (Usuario) o;
// !         return Objects.equals(nombre, u.nombre);
// !     }
// !
// !     @Override
// !     public int hashCode() {
// !         return Objects.hash(nombre);
// !     }
// ! }
*/

/*
// $ ──────────────────────────────────────────────────
// $ 5. peek() - INSPECCIONAR elementos (debug)
// $ ──────────────────────────────────────────────────
// $
// $ Recibe: Consumer<T>
// $ Retorna: El mismo Stream (sin cambios)
// $ Uso: Ver qué datos pasan en cada etapa (debugging)
// $
// % EJEMPLO:
// %
// % usuarios.stream()
// %     .peek(u -> System.out.println("Original: " + u))
// %     .filter(u -> u.getEdad() > 18)
// %     .peek(u -> System.out.println("Después de filter: " + u))
// %     .map(Usuario::getNombre)
// %     .peek(n -> System.out.println("Después de map: " + n))
// %     .collect(Collectors.toList());
*/

/*
// ! ──────────────────────────────────────────────────
// ! ADVERTENCIA: peek() NO debe modificar datos
// ! ──────────────────────────────────────────────────
// !
// ! ❌ MAL USO:
// ! usuarios.stream()
// !     .peek(u -> u.setEdad(u.getEdad() + 1))  // Modificando ❌
// !
// ! ✓ BUEN USO:
// ! usuarios.stream()
// !     .peek(System.out::println)  // Solo observando ✓
// !
// ! peek() es para INSPECCIÓN, no para TRANSFORMACIÓN.
// ! Para transformar, usa map().
*/

/*
// $ ──────────────────────────────────────────────────
// $ 6. sorted() - ORDENAR elementos
// $ ──────────────────────────────────────────────────
// $
// $ Sin parámetros: orden natural (Comparable)
// $ Con Comparator: orden personalizado
// $
// % EJEMPLOS:
// %
// % // Ordenar strings (alfabético)
// % nombres.stream()
// %     .sorted()
// %
// % // Ordenar usuarios por nombre
// % usuarios.stream()
// %     .sorted((u1, u2) -> u1.getNombre().compareTo(u2.getNombre()))
// %     // O más corto:
// %     .sorted(Comparator.comparing(Usuario::getNombre))
// %
// % // Orden descendente
// % usuarios.stream()
// %     .sorted(Comparator.comparing(Usuario::getEdad).reversed())
*/

/*
// $ ──────────────────────────────────────────────────
// $ 7. limit() y skip() - LIMITAR y SALTAR elementos
// $ ──────────────────────────────────────────────────
// $
// $ limit(n): Toma solo los primeros N elementos
// $ skip(n):  Salta los primeros N elementos
// $
// % EJEMPLOS:
// %
// % // Primeros 5 elementos
// % usuarios.stream()
// %     .limit(5)
// %
// % // Paginación: página 2, 10 elementos por página
// % usuarios.stream()
// %     .skip(10)   // Salta los primeros 10
// %     .limit(10)  // Toma los siguientes 10
// %
// % // Generar 7 números y detenerse
// % Stream.generate(() -> contador.incrementAndGet())
// %     .limit(7)
*/

// $ ============================================================================================================
// $ PARTE 4: OPERACIONES TERMINALES (Terminal Operations)
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ SON LAS OPERACIONES TERMINALES?
// $ =====================================================
// $
// $ Son operaciones que:
// $ • EJECUTAN el pipeline del Stream
// $ • Producen un RESULTADO FINAL (no un Stream)
// $ • CIERRAN el Stream (no se puede reutilizar)
// $ • ACTIVAN las operaciones intermedias (lazy)
// $
// $ Principales operaciones terminales:
// $ • forEach()        - Ejecutar acción en cada elemento
// $ • collect()        - Acumular en colección
// $ • count()          - Contar elementos
// $ • findFirst()      - Buscar primero
// $ • findAny()        - Buscar cualquiera
// $ • anyMatch()       - ¿Alguno cumple?
// $ • allMatch()       - ¿Todos cumplen?
// $ • noneMatch()      - ¿Ninguno cumple?
// $ • reduce()         - Reducir a un valor
// $ • min() / max()    - Mínimo / Máximo
// $ • toArray()        - Convertir a array
*/

/*
// $ ──────────────────────────────────────────────────
// $ 1. forEach() - EJECUTAR acción en cada elemento
// $ ──────────────────────────────────────────────────
// $
// $ Recibe: Consumer<T>
// $ Retorna: void (no retorna nada)
// $ Uso: Imprimir, guardar, procesar sin retornar
// $
// % EJEMPLOS:
// %
// % // Imprimir cada nombre
// % nombres.stream()
// %     .forEach(System.out::println);
// %
// % // Guardar en base de datos
// % usuarios.stream()
// %     .forEach(usuarioRepository::save);
// %
// % // Procesar cada factura
// % facturas.stream()
// %     .forEach(f -> procesarFactura(f));
*/

/*
// ! ──────────────────────────────────────────────────
// ! forEach() vs forEachOrdered() en Streams Paralelos
// ! ──────────────────────────────────────────────────
// !
// ! forEach():
// ! - NO garantiza orden en paralelo
// ! - Más rápido
// !
// ! forEachOrdered():
// ! - SÍ garantiza orden
// ! - Más lento en paralelo
// !
// ! lista.parallelStream()
// !     .forEach(System.out::println);        // Orden aleatorio
// !
// ! lista.parallelStream()
// !     .forEachOrdered(System.out::println); // Orden garantizado
*/

/*
// $ ──────────────────────────────────────────────────
// $ 2. collect() - ACUMULAR en colección
// $ ──────────────────────────────────────────────────
// $
// $ Convierte el Stream en una colección
// $
// $ Collectors más usados:
// $ • toList()        - A List
// $ • toSet()         - A Set (sin duplicados)
// $ • toMap()         - A Map
// $ • joining()       - Concatenar strings
// $ • groupingBy()    - Agrupar por criterio
// $ • partitioningBy() - Dividir en dos grupos
// $
// % EJEMPLOS:
// %
// % // A List
// % List<String> nombres = stream.collect(Collectors.toList());
// %
// % // A Set
// % Set<Usuario> unicos = stream.collect(Collectors.toSet());
// %
// % // Concatenar strings
// % String resultado = nombres.stream()
// %     .collect(Collectors.joining(", "));
// %     // "Ana, Pedro, Luis"
// %
// % // Agrupar por nombre
// % Map<String, List<Usuario>> porNombre = usuarios.stream()
// %     .collect(Collectors.groupingBy(Usuario::getNombre));
*/

/*
// $ ──────────────────────────────────────────────────
// $ 3. count() - CONTAR elementos
// $ ──────────────────────────────────────────────────
// $
// $ Retorna: long (número de elementos)
// $ Uso: Saber cuántos elementos hay
// $
// % EJEMPLOS:
// %
// % // Contar todos
// % long total = usuarios.stream().count();
// %
// % // Contar después de filtrar
// % long mayoresDeEdad = usuarios.stream()
// %     .filter(u -> u.getEdad() >= 18)
// %     .count();
// %
// % // Contar strings vacíos
// % long vacios = textos.stream()
// %     .filter(String::isEmpty)
// %     .count();
*/

/*
// $ ──────────────────────────────────────────────────
// $ 4. findFirst() y findAny() - BUSCAR elementos
// $ ──────────────────────────────────────────────────
// $
// $ Retorna: Optional<T>
// $
// $ findFirst():
// $ - Retorna el PRIMER elemento
// $ - Respeta el orden
// $
// $ findAny():
// $ - Retorna CUALQUIER elemento
// $ - Optimizado para paralelo
// $ - Puede retornar diferente elemento cada vez
// $
// % EJEMPLOS:
// %
// % // Buscar primer usuario llamado "Pepe"
// % Optional<Usuario> primero = usuarios.stream()
// %     .filter(u -> u.getNombre().equals("Pepe"))
// %     .findFirst();
// %
// % // Buscar cualquier adulto (paralelo)
// % Optional<Usuario> cualquiera = usuarios.parallelStream()
// %     .filter(u -> u.getEdad() >= 18)
// %     .findAny();
*/

/*
// # ──────────────────────────────────────────────────
// # Optional<T> - MANEJO SEGURO DE VALORES NULOS
// # ──────────────────────────────────────────────────
// #
// # Optional es un contenedor que puede o no contener un valor
// #
// # Métodos principales:
// #
// # • isPresent()    - ¿Tiene valor?
// # • get()          - Obtener valor (lanza excepción si vacío)
// # • orElse(valor)  - Valor por defecto
// # • orElseGet(Supplier) - Valor por defecto con lambda
// # • orElseThrow()  - Lanzar excepción si vacío
// # • ifPresent(Consumer) - Ejecutar si tiene valor
// # • map()          - Transformar si presente
// # • filter()       - Filtrar si presente
// #
// # EJEMPLOS:
// #
// # // Forma 1: Verificar con isPresent
// # if (usuario.isPresent()) {
// #     System.out.println(usuario.get().getNombre());
// # } else {
// #     System.out.println("No encontrado");
// # }
// #
// # // Forma 2: Valor por defecto con orElse
// # Usuario u = usuario.orElse(new Usuario("John", "Doe"));
// #
// # // Forma 3: Valor por defecto lazy con orElseGet
// # Usuario u = usuario.orElseGet(() -> new Usuario("John", "Doe"));
// #
// # // Forma 4: Ejecutar acción si presente
// # usuario.ifPresent(u -> System.out.println(u.getNombre()));
*/

/*
// ! ──────────────────────────────────────────────────
// ! NUNCA uses get() sin verificar isPresent()
// ! ──────────────────────────────────────────────────
// !
// ! ❌ PELIGROSO:
// ! Optional<Usuario> opt = stream.findFirst();
// ! Usuario u = opt.get();  // Puede lanzar NoSuchElementException
// !
// ! ✓ SEGURO - Opción 1:
// ! if (opt.isPresent()) {
// !     Usuario u = opt.get();
// ! }
// !
// ! ✓ SEGURO - Opción 2:
// ! Usuario u = opt.orElse(defaultUser);
// !
// ! ✓ SEGURO - Opción 3:
// ! Usuario u = opt.orElseThrow(() -> new RuntimeException("No encontrado"));
*/

/*
// $ ──────────────────────────────────────────────────
// $ 5. anyMatch(), allMatch(), noneMatch() - VALIDACIONES
// $ ──────────────────────────────────────────────────
// $
// $ Reciben: Predicate<T>
// $ Retornan: boolean
// $
// $ anyMatch():  ¿Al menos UNO cumple?
// $ allMatch():  ¿TODOS cumplen?
// $ noneMatch(): ¿NINGUNO cumple?
// $
// % EJEMPLOS:
// %
// % // ¿Existe algún usuario con id 4?
// % boolean existe = usuarios.stream()
// %     .anyMatch(u -> u.getId().equals(4));
// %
// % // ¿Todos son mayores de edad?
// % boolean todosMayores = usuarios.stream()
// %     .allMatch(u -> u.getEdad() >= 18);
// %
// % // ¿Ninguno se llama "Admin"?
// % boolean ningunAdmin = usuarios.stream()
// %     .noneMatch(u -> u.getNombre().equals("Admin"));
*/

/*
// * ──────────────────────────────────────────────────
// * OPTIMIZACIÓN: Short-circuit evaluation
// * ──────────────────────────────────────────────────
// *
// * Estas operaciones se detienen en cuanto saben la respuesta:
// *
// * anyMatch(): Se detiene al encontrar el PRIMERO que cumple
// * allMatch(): Se detiene al encontrar el PRIMERO que NO cumple
// * noneMatch(): Se detiene al encontrar el PRIMERO que cumple
// *
// * Esto las hace muy eficientes en colecciones grandes.
*/

/*
// $ ──────────────────────────────────────────────────
// $ 6. reduce() - REDUCIR a un solo valor
// $ ──────────────────────────────────────────────────
// $
// $ Combina todos los elementos en uno solo
// $
// $ Recibe: BinaryOperator<T> (combina dos valores en uno)
// $ Retorna: Optional<T> o T (si hay valor inicial)
// $
// $ Formas:
// $ 1. reduce(BinaryOperator)        - Sin valor inicial
// $ 2. reduce(identidad, BinaryOperator) - Con valor inicial
// $
// % EJEMPLOS:
// %
// % // Sumar todos los números
// % Optional<Integer> suma = Stream.of(1, 2, 3, 4, 5)
// %     .reduce((a, b) -> a + b);
// %     // O más corto:
// %     .reduce(Integer::sum);
// %
// % // Sumar con valor inicial
// % Integer suma = Stream.of(1, 2, 3, 4, 5)
// %     .reduce(0, Integer::sum);  // Empieza en 0
// %
// % // Concatenar strings
// % String resultado = Stream.of("Hola", "Mundo", "Java")
// %     .reduce("", (a, b) -> a + " " + b);
// %     // Resultado: " Hola Mundo Java"
// %
// % // Encontrar el máximo
// % Optional<Integer> max = numeros.stream()
// %     .reduce((a, b) -> a > b ? a : b);
// %     // O más corto:
// %     .reduce(Integer::max);
*/

/*
// ? ──────────────────────────────────────────────────
// ? ¿CUÁNDO USAR reduce() vs métodos específicos?
// ? ──────────────────────────────────────────────────
// ?
// ? Para operaciones comunes, usa los métodos específicos:
// ?
// ? ✗ numeros.stream().reduce(0, Integer::sum)
// ? ✓ numeros.stream().mapToInt(Integer::intValue).sum()
// ?
// ? ✗ numeros.stream().reduce(Integer::max)
// ? ✓ numeros.stream().max(Integer::compare)
// ?
// ? ✗ stream.reduce((a, b) -> a)  // Primer elemento
// ? ✓ stream.findFirst()
// ?
// ? Usa reduce() solo cuando no hay alternativa más clara
*/

/*
// $ ──────────────────────────────────────────────────
// $ 7. min() y max() - MÍNIMO y MÁXIMO
// $ ──────────────────────────────────────────────────
// $
// $ Reciben: Comparator<T>
// $ Retornan: Optional<T>
// $
// % EJEMPLOS:
// %
// % // Usuario más joven
// % Optional<Usuario> masJoven = usuarios.stream()
// %     .min(Comparator.comparing(Usuario::getEdad));
// %
// % // Usuario mayor
// % Optional<Usuario> mayor = usuarios.stream()
// %     .max(Comparator.comparing(Usuario::getEdad));
// %
// % // Nombre más largo
// % Optional<String> masLargo = nombres.stream()
// %     .max(Comparator.comparing(String::length));
*/

// $ ============================================================================================================
// $ PARTE 5: STREAMS PRIMITIVOS (IntStream, LongStream, DoubleStream)
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ SON LOS STREAMS PRIMITIVOS?
// $ =====================================================
// $
// $ Streams especializados para tipos primitivos:
// $ • IntStream    - Para int
// $ • LongStream   - Para long
// $ • DoubleStream - Para double
// $
// $ Ventajas sobre Stream<Integer>:
// $ ✓ Mejor rendimiento (sin boxing/unboxing)
// $ ✓ Métodos especializados (sum, average, min, max)
// $ ✓ Métodos de rango (range, rangeClosed)
// $
// $ Conversión:
// $ • mapToInt()    - Stream<T> → IntStream
// $ • mapToLong()   - Stream<T> → LongStream
// $ • mapToDouble() - Stream<T> → DoubleStream
// $ • boxed()       - IntStream → Stream<Integer>
*/

/*
// $ ──────────────────────────────────────────────────
// $ IntStream.range() y rangeClosed()
// $ ──────────────────────────────────────────────────
// $
// $ range(inicio, fin):       [inicio, fin)  - NO incluye fin
// $ rangeClosed(inicio, fin): [inicio, fin]  - SÍ incluye fin
// $
// % EJEMPLOS:
// %
// % // 1, 2, 3, 4, 5, 6, 7, 8, 9 (sin 10)
// % IntStream.range(1, 10)
// %     .forEach(System.out::println);
// %
// % // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 (con 10)
// % IntStream.rangeClosed(1, 10)
// %     .forEach(System.out::println);
// %
// % // Generar índices
// % IntStream.range(0, lista.size())
// %     .forEach(i -> System.out.println(i + ": " + lista.get(i)));
*/

/*
// $ ──────────────────────────────────────────────────
// $ mapToInt() - Convertir a IntStream
// $ ──────────────────────────────────────────────────
// $
// % EJEMPLOS:
// %
// % // Longitud de cada nombre
// % IntStream longitudes = nombres.stream()
// %     .mapToInt(String::length);
// %
// % // Edad de cada usuario
// % IntStream edades = usuarios.stream()
// %     .mapToInt(Usuario::getEdad);
// %
// % // Convertir String a int
// % IntStream numeros = Stream.of("1", "2", "3")
// %     .mapToInt(Integer::parseInt);
*/

/*
// $ ──────────────────────────────────────────────────
// $ Métodos estadísticos en IntStream
// $ ──────────────────────────────────────────────────
// $
// $ • sum()       - Suma total
// $ • average()   - Promedio (retorna OptionalDouble)
// $ • min()       - Mínimo (retorna OptionalInt)
// $ • max()       - Máximo (retorna OptionalInt)
// $ • count()     - Cantidad de elementos
// $ • summaryStatistics() - Todas las anteriores juntas
// $
// % EJEMPLOS:
// %
// % IntStream edades = usuarios.stream()
// %     .mapToInt(Usuario::getEdad);
// %
// % // Suma
// % int total = edades.sum();
// %
// % // Promedio
// % OptionalDouble promedio = edades.average();
// % double prom = promedio.orElse(0.0);
// %
// % // Mínimo
// % OptionalInt minimo = edades.min();
// %
// % // Máximo
// % OptionalInt maximo = edades.max();
*/

/*
// $ ──────────────────────────────────────────────────
// $ summaryStatistics() - Todas las estadísticas juntas
// $ ──────────────────────────────────────────────────
// $
// $ Retorna: IntSummaryStatistics
// $ Contiene: max, min, sum, average, count
// $
// % EJEMPLO:
// %
// % IntSummaryStatistics stats = IntStream.range(1, 10)
// %     .summaryStatistics();
// %
// % System.out.println("Máximo: " + stats.getMax());      // 9
// % System.out.println("Mínimo: " + stats.getMin());      // 1
// % System.out.println("Suma: " + stats.getSum());        // 45
// % System.out.println("Promedio: " + stats.getAverage()); // 5.0
// % System.out.println("Total: " + stats.getCount());     // 9
// %
// % ¡Una sola operación para todas las estadísticas!
*/

// $ ============================================================================================================
// $ PARTE 6: STREAMS PARALELOS
// $ ============================================================================================================

/*
// $ =====================================================
// $ ¿QUÉ ES UN STREAM PARALELO?
// $ =====================================================
// $
// $ Stream paralelo ejecuta operaciones en múltiples hilos
// $ simultáneamente para mejorar el rendimiento.
// $
// $ Formas de crear:
// $ • lista.parallelStream()
// $ • lista.stream().parallel()
// $
// $ Características:
// $ ✓ Usa ForkJoinPool común
// $ ✓ Divide datos en chunks
// $ ✓ Procesa en paralelo
// $ ✓ Combina resultados
// $
// $ ⚠️ NO garantiza orden (a menos que uses forEachOrdered)
*/

/*
// % ──────────────────────────────────────────────────
// % EJEMPLO: Stream Paralelo
// % ──────────────────────────────────────────────────
// %
// % List<Usuario> usuarios = obtenerMuchosUsuarios();
// %
// % // Secuencial (un hilo)
// % usuarios.stream()
// %     .map(Usuario::procesar)
// %     .forEach(System.out::println);
// %
// % // Paralelo (múltiples hilos)
// % usuarios.parallelStream()
// %     .map(Usuario::procesar)
// %     .forEach(System.out::println);
// %
// % // Ver qué hilo procesa cada elemento
// % usuarios.parallelStream()
// %     .peek(u -> System.out.println("Thread: " + Thread.currentThread().getName()))
// %     .map(Usuario::getNombre)
// %     .forEach(System.out::println);
*/

/*
// * ──────────────────────────────────────────────────
// * ¿CUÁNDO USAR PARALLEL?
// * ──────────────────────────────────────────────────
// *
// * USA Parallel cuando:
// * ✓ Colección GRANDE (miles o millones de elementos)
// * ✓ Operaciones COSTOSAS por elemento
// * ✓ NO hay dependencias entre elementos
// * ✓ NO necesitas orden específico
// * ✓ Operaciones son STATELESS (sin estado compartido)
// *
// * NO uses Parallel cuando:
// * ✗ Colección pequeña (< 1000 elementos)
// * ✗ Operaciones muy rápidas (overhead no vale la pena)
// * ✗ Hay efectos secundarios (modificar variables externas)
// * ✗ Necesitas orden garantizado
// * ✗ Operaciones dependen del orden
*/

/*
// ! ──────────────────────────────────────────────────
// ! PELIGROS DEL PARALLEL
// ! ──────────────────────────────────────────────────
// !
// ! ❌ NO modifiques colecciones compartidas:
// ! List<String> resultado = new ArrayList<>();
// ! lista.parallelStream()
// !     .forEach(resultado::add);  // ¡RACE CONDITION!
// !
// ! ✓ Usa collect():
// ! List<String> resultado = lista.parallelStream()
// !     .collect(Collectors.toList());  // Thread-safe
// !
// ! ❌ NO uses variables externas mutables:
// ! int suma = 0;  // Variable externa
// ! numeros.parallelStream()
// !     .forEach(n -> suma += n);  // ¡ERROR! No se puede
// !
// ! ✓ Usa reduce() o sum():
// ! int suma = numeros.parallelStream()
// !     .mapToInt(Integer::intValue)
// !     .sum();  // Thread-safe
*/

/*
// % ──────────────────────────────────────────────────
// % EJEMPLO: Comparación de rendimiento
// % ──────────────────────────────────────────────────
// %
// % // Medir tiempo secuencial
// % long inicio = System.currentTimeMillis();
// % String resultado = usuarios.stream()
// %     .map(this::procesoLento)  // Simula operación costosa
// %     .filter(s -> s.contains("X"))
// %     .findAny()
// %     .orElse("No encontrado");
// % long fin = System.currentTimeMillis();
// % System.out.println("Secuencial: " + (fin - inicio) + "ms");
// %
// % // Medir tiempo paralelo
// % inicio = System.currentTimeMillis();
// % resultado = usuarios.parallelStream()
// %     .map(this::procesoLento)
// %     .filter(s -> s.contains("X"))
// %     .findAny()
// %     .orElse("No encontrado");
// % fin = System.currentTimeMillis();
// % System.out.println("Paralelo: " + (fin - inicio) + "ms");
// %
// % // Paralelo suele ser más rápido con operaciones costosas
*/

// $ ============================================================================================================
// $ PARTE 7: STREAMS INFINITOS
// $ ============================================================================================================

/*
// $ =====================================================
// $ Stream.generate() - Stream infinito con Supplier
// $ =====================================================
// $
// $ Genera elementos infinitamente usando un Supplier
// $
// $ ⚠️ SIEMPRE debe usarse con limit()
// $
// % EJEMPLOS:
// %
// % // Generar números incrementales
// % AtomicInteger contador = new AtomicInteger(0);
// % Stream.generate(() -> contador.incrementAndGet())
// %     .limit(10)
// %     .forEach(System.out::println);  // 1, 2, 3, ... 10
// %
// % // Generar valores constantes
// % Stream.generate(() -> "Hola")
// %     .limit(5)
// %     .forEach(System.out::println);  // Hola (5 veces)
// %
// % // Generar números aleatorios
// % Stream.generate(Math::random)
// %     .limit(5)
// %     .forEach(System.out::println);
// %
// % // Con delay (ejemplo del curso)
// % Stream.generate(() -> {
// %     try {
// %         TimeUnit.SECONDS.sleep(2);
// %     } catch (InterruptedException e) {
// %         throw new RuntimeException(e);
// %     }
// %     return contador.incrementAndGet();
// % }).limit(7).forEach(System.out::println);
*/

/*
// ! ──────────────────────────────────────────────────
// ! SIN limit(), el programa NO termina
// ! ──────────────────────────────────────────────────
// !
// ! ❌ NUNCA TERMINA:
// ! Stream.generate(() -> "Hola")
// !     .forEach(System.out::println);  // Loop infinito
// !
// ! ✓ CORRECTO:
// ! Stream.generate(() -> "Hola")
// !     .limit(100)
// !     .forEach(System.out::println);  // Se detiene en 100
*/

/*
// $ =====================================================
// $ Stream.iterate() - Stream infinito con función
// $ =====================================================
// $
// $ Similar a generate(), pero usa el valor anterior
// $
// % EJEMPLOS:
// %
// % // Números del 0 al 9
// % Stream.iterate(0, n -> n + 1)
// %     .limit(10)
// %     .forEach(System.out::println);
// %
// % // Fibonacci
// % Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
// %     .limit(10)
// %     .map(f -> f[0])
// %     .forEach(System.out::println);
// %
// % // Potencias de 2
// % Stream.iterate(1, n -> n * 2)
// %     .limit(10)
// %     .forEach(System.out::println);  // 1, 2, 4, 8, 16...
*/

// # ============================================================================================================
// # PARTE 8: PATRONES Y MEJORES PRÁCTICAS
// # ============================================================================================================

/*
// * =====================================================
// * PATRÓN 1: Pipeline típico de Stream
// * =====================================================
// *
// * Estructura común:
// *
// * fuente
// *   .filter()      // Filtrar primero (reduce elementos)
// *   .map()         // Transformar
// *   .sorted()      // Ordenar si necesario
// *   .distinct()    // Eliminar duplicados
// *   .limit()       // Limitar cantidad
// *   .collect()     // Recolectar resultado
// *
// * Ejemplo completo:
// * List<String> resultado = usuarios.stream()
// *     .filter(u -> u.getEdad() >= 18)           // Solo adultos
// *     .map(Usuario::getNombre)                   // Obtener nombres
// *     .map(String::toUpperCase)                  // A mayúsculas
// *     .sorted()                                   // Ordenar
// *     .distinct()                                 // Sin duplicados
// *     .limit(10)                                  // Máximo 10
// *     .collect(Collectors.toList());             // A lista
*/

/*
// * =====================================================
// * PATRÓN 2: Búsqueda con findFirst + orElse
// * =====================================================
// *
// * Buscar elemento que cumple condición con valor por defecto
// *
// * Usuario encontrado = usuarios.stream()
// *     .filter(u -> u.getId().equals(4))
// *     .findFirst()
// *     .orElse(new Usuario("Default", "User"));
// *
// * // O lanzar excepción si no existe
// * Usuario encontrado = usuarios.stream()
// *     .filter(u -> u.getId().equals(4))
// *     .findFirst()
// *     .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
*/

/*
// * =====================================================
// * PATRÓN 3: Validación rápida con anyMatch
// * =====================================================
// *
// * Reemplaza bucles con break:
// *
// * // ANTES (imperativo):
// * boolean existe = false;
// * for (Usuario u : usuarios) {
// *     if (u.getId().equals(4)) {
// *         existe = true;
// *         break;
// *     }
// * }
// *
// * // DESPUÉS (declarativo):
// * boolean existe = usuarios.stream()
// *     .anyMatch(u -> u.getId().equals(4));
*/

/*
// * =====================================================
// * PATRÓN 4: Transformación con map encadenado
// * =====================================================
// *
// * Múltiples transformaciones en cadena:
// *
// * List<String> procesados = usuarios.stream()
// *     .map(Usuario::getNombre)              // Usuario → String
// *     .map(String::trim)                    // Limpiar espacios
// *     .map(String::toUpperCase)             // A mayúsculas
// *     .map(n -> "Sr. " + n)                 // Agregar prefijo
// *     .collect(Collectors.toList());
*/

/*
// * =====================================================
// * PATRÓN 5: Aplanar con flatMap
// * =====================================================
// *
// * Relaciones 1 a N (Usuario → Facturas):
// *
// * List<Factura> todasLasFacturas = usuarios.stream()
// *     .flatMap(u -> u.getFacturas().stream())
// *     .collect(Collectors.toList());
// *
// * // Con filtro:
// * List<Factura> facturasCaras = usuarios.stream()
// *     .flatMap(u -> u.getFacturas().stream())
// *     .filter(f -> f.getMonto() > 1000)
// *     .collect(Collectors.toList());
*/

/*
// * =====================================================
// * PATRÓN 6: Estadísticas rápidas con summaryStatistics
// * =====================================================
// *
// * Obtener múltiples estadísticas en una sola pasada:
// *
// * IntSummaryStatistics stats = usuarios.stream()
// *     .mapToInt(Usuario::getEdad)
// *     .summaryStatistics();
// *
// * System.out.println("Edad promedio: " + stats.getAverage());
// * System.out.println("Edad máxima: " + stats.getMax());
// * System.out.println("Edad mínima: " + stats.getMin());
// * System.out.println("Total usuarios: " + stats.getCount());
*/

// ! ============================================================================================================
// ! PARTE 9: ERRORES COMUNES Y CÓMO EVITARLOS
// ! ============================================================================================================

/*
// ! =====================================================
// ! ERROR 1: Reutilizar un Stream
// ! =====================================================
// !
// ! ❌ INCORRECTO:
// ! Stream<String> nombres = lista.stream();
// ! nombres.forEach(System.out::println);  // Primera operación terminal
// ! long count = nombres.count();           // ERROR: Stream ya cerrado
// !
// ! ✓ CORRECTO:
// ! lista.stream().forEach(System.out::println);
// ! long count = lista.stream().count();  // Crear nuevo Stream
*/

/*
// ! =====================================================
// ! ERROR 2: No entender map vs flatMap
// ! =====================================================
// !
// ! ❌ INCORRECTO (cuando necesitas flatMap):
// ! Stream<List<Factura>> facturas = usuarios.stream()
// !     .map(Usuario::getFacturas);  // Retorna Stream<List<Factura>>
// !
// ! ✓ CORRECTO:
// ! Stream<Factura> facturas = usuarios.stream()
// !     .flatMap(u -> u.getFacturas().stream());  // Stream<Factura>
// !
// ! Regla: Si tu map retorna una colección/Stream, probablemente
// !        necesitas flatMap
*/

/*
// ! =====================================================
// ! ERROR 3: Olvidar la operación terminal
// ! =====================================================
// !
// ! ❌ INCORRECTO (no hace nada):
// ! lista.stream()
// !     .filter(s -> s.length() > 5)
// !     .map(String::toUpperCase);  // Sin operación terminal
// !     // ¡No se ejecuta nada!
// !
// ! ✓ CORRECTO:
// ! lista.stream()
// !     .filter(s -> s.length() > 5)
// !     .map(String::toUpperCase)
// !     .forEach(System.out::println);  // Operación terminal
*/

/*
// ! =====================================================
// ! ERROR 4: Usar get() sin verificar Optional
// ! =====================================================
// !
// ! ❌ PELIGROSO:
// ! Usuario u = usuarios.stream()
// !     .filter(u -> u.getId().equals(99))
// !     .findFirst()
// !     .get();  // Lanza excepción si no existe
// !
// ! ✓ SEGURO - Opción 1 (con verificación):
// ! Optional<Usuario> opt = usuarios.stream()
// !     .filter(u -> u.getId().equals(99))
// !     .findFirst();
// ! if (opt.isPresent()) {
// !     Usuario u = opt.get();
// ! }
// !
// ! ✓ SEGURO - Opción 2 (con valor por defecto):
// ! Usuario u = usuarios.stream()
// !     .filter(u -> u.getId().equals(99))
// !     .findFirst()
// !     .orElse(defaultUser);
*/

/*
// ! =====================================================
// ! ERROR 5: Modificar la colección fuente durante Stream
// ! =====================================================
// !
// ! ❌ INCORRECTO:
// ! lista.stream()
// !     .forEach(elemento -> lista.remove(elemento));
// !     // ConcurrentModificationException
// !
// ! ✓ CORRECTO:
// ! lista.removeIf(condicion);  // Método específico
// !
// ! // O crear nueva lista:
// ! List<String> nuevaLista = lista.stream()
// !     .filter(condicion)
// !     .collect(Collectors.toList());
*/

/*
// ! =====================================================
// ! ERROR 6: Usar parallel sin necesidad
// ! =====================================================
// !
// ! ❌ INEFICIENTE (colección pequeña):
// ! List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);
// ! int suma = numeros.parallelStream()  // Overhead innecesario
// !     .mapToInt(Integer::intValue)
// !     .sum();
// !
// ! ✓ CORRECTO (usa stream normal):
// ! int suma = numeros.stream()
// !     .mapToInt(Integer::intValue)
// !     .sum();
// !
// ! Regla: Solo usa parallel con colecciones grandes (miles+)
// !        y operaciones costosas
*/

/*
// ! =====================================================
// ! ERROR 7: Confundir filter con map
// ! =====================================================
// !
// ! ❌ INCORRECTO:
// ! // Intentar transformar Y filtrar con map
// ! stream.map(u -> u.getEdad() > 18 ? u : null)
// !     .filter(Objects::nonNull);  // Ineficiente
// !
// ! ✓ CORRECTO:
// ! stream.filter(u -> u.getEdad() > 18);  // Solo filtrar
// !
// ! Regla:
// ! - filter: Para SELECCIONAR elementos
// ! - map: Para TRANSFORMAR elementos
*/

// # ============================================================================================================
// # PARTE 10: CHEAT SHEET Y REFERENCIA RÁPIDA
// # ============================================================================================================

/*
// # =====================================================
// # OPERACIONES INTERMEDIAS (retornan Stream)
// # =====================================================
// #
// # OPERACIÓN          USO                           EJEMPLO
// # ─────────────────────────────────────────────────────────────────
// # filter()          Filtrar elementos              .filter(u -> u.getEdad() > 18)
// # map()             Transformar 1:1                .map(Usuario::getNombre)
// # flatMap()         Transformar 1:N y aplanar      .flatMap(u -> u.getFacturas().stream())
// # distinct()        Eliminar duplicados            .distinct()
// # sorted()          Ordenar                        .sorted(Comparator.comparing(...))
// # peek()            Inspeccionar (debug)           .peek(System.out::println)
// # limit()           Limitar cantidad               .limit(10)
// # skip()            Saltar elementos               .skip(5)
// # mapToInt()        Convertir a IntStream          .mapToInt(String::length)
// # mapToLong()       Convertir a LongStream         .mapToLong(...)
// # mapToDouble()     Convertir a DoubleStream       .mapToDouble(...)
*/

/*
// # =====================================================
// # OPERACIONES TERMINALES (cierran el Stream)
// # =====================================================
// #
// # OPERACIÓN          RETORNA         USO
// # ─────────────────────────────────────────────────────────────────
// # forEach()         void            Ejecutar acción
// # forEachOrdered()  void            Ejecutar con orden garantizado
// # collect()         Colección       Acumular en List/Set/Map
// # toArray()         Array           Convertir a array
// # count()           long            Contar elementos
// # findFirst()       Optional<T>     Primer elemento
// # findAny()         Optional<T>     Cualquier elemento
// # anyMatch()        boolean         ¿Alguno cumple?
// # allMatch()        boolean         ¿Todos cumplen?
// # noneMatch()       boolean         ¿Ninguno cumple?
// # min()             Optional<T>     Elemento mínimo
// # max()             Optional<T>     Elemento máximo
// # reduce()          Optional<T>/T   Reducir a un valor
// # sum()             int/long/double Sumar (solo primitivos)
// # average()         OptionalDouble  Promedio (solo primitivos)
// # summaryStatistics() XxxSummaryStats Todas las estadísticas
*/

/*
// # =====================================================
// # COLLECTORS COMUNES
// # =====================================================
// #
// # COLLECTOR              USO
// # ─────────────────────────────────────────────────────────
// # toList()              Convertir a List
// # toSet()               Convertir a Set
// # toMap()               Convertir a Map
// # joining()             Concatenar strings
// # groupingBy()          Agrupar por criterio
// # partitioningBy()      Dividir en dos grupos (true/false)
// # counting()            Contar elementos
// # summingInt()          Sumar valores int
// # averagingInt()        Promediar valores int
// # summarizingInt()      Estadísticas completas
*/

/*
// # =====================================================
// # OPTIONAL - MÉTODOS PRINCIPALES
// # =====================================================
// #
// # MÉTODO              RETORNA         USO
// # ─────────────────────────────────────────────────────────
// # isPresent()        boolean         ¿Tiene valor?
// # isEmpty()          boolean         ¿Está vacío?
// # get()              T               Obtener valor (lanza excepción si vacío)
// # orElse(T)          T               Valor por defecto
// # orElseGet(Supplier) T              Valor por defecto lazy
// # orElseThrow()      T               Lanzar excepción si vacío
// # ifPresent(Consumer) void           Ejecutar si presente
// # map(Function)      Optional<R>     Transformar si presente
// # flatMap(Function)  Optional<R>     Transformar y aplanar
// # filter(Predicate)  Optional<T>     Filtrar si cumple condición
*/

// # ============================================================================================================
// # PARTE 11: PREGUNTAS FRECUENTES Y CONCEPTOS CLAVE
// # ============================================================================================================

/*
// ? =====================================================
// ? PREGUNTAS DE EXAMEN / ENTREVISTA
// ? =====================================================
// ?
// ? 1. ¿Qué es un Stream y cómo se diferencia de una colección?
// ?    → Stream procesa datos, Collection los almacena
// ?    → Stream es lazy, Collection es eager
// ?    → Stream se usa una vez, Collection es reutilizable
// ?
// ? 2. ¿Cuál es la diferencia entre map() y flatMap()?
// ?    → map: 1 elemento → 1 elemento
// ?    → flatMap: 1 elemento → 0 o N elementos (y aplana)
// ?
// ? 3. ¿Por qué distinct() depende de equals() y hashCode()?
// ?    → Usa internamente HashSet para detectar duplicados
// ?    → Sin equals/hashCode bien implementados, falla
// ?
// ? 4. ¿Diferencia entre peek() y forEach()?
// ?    → peek: operación INTERMEDIA (para debug)
// ?    → forEach: operación TERMINAL (consume el stream)
// ?
// ? 5. ¿Diferencia entre findFirst() y findAny()?
// ?    → findFirst: garantiza el PRIMERO (respeta orden)
// ?    → findAny: puede retornar CUALQUIERA (optimizado para parallel)
// ?
// ? 6. ¿Qué pasa si reutilizas un Stream?
// ?    → Lanza IllegalStateException
// ?    → Streams solo se usan una vez
// ?
// ? 7. ¿Cuándo usar parallelStream()?
// ?    → Colecciones GRANDES (miles+)
// ?    → Operaciones COSTOSAS por elemento
// ?    → Sin efectos secundarios
// ?
// ? 8. ¿Por qué Optional evita NullPointerException?
// ?    → Obliga a manejar caso de ausencia de valor
// ?    → Proporciona métodos seguros (orElse, ifPresent)
// ?
// ? 9. ¿Por qué flatMap es clave en relaciones 1-N?
// ?    → Permite "aplanar" colecciones anidadas
// ?    → Usuario → List<Factura> se convierte en Stream<Factura>
// ?
// ? 10. ¿Qué es evaluación perezosa (lazy evaluation)?
// ?     → Las operaciones intermedias NO se ejecutan hasta
// ?       que hay una operación terminal
// ?     → Permite optimizaciones
*/

/*
// # =====================================================
// # CONCEPTOS CLAVE FINALES
// # =====================================================
// #
// # INMUTABILIDAD:
// # Stream NO modifica la colección original
// #
// # LAZY EVALUATION:
// # Operaciones intermedias solo se ejecutan cuando
// # hay una operación terminal
// #
// # SHORT-CIRCUIT:
// # anyMatch, allMatch, noneMatch, findFirst, findAny
// # se detienen en cuanto pueden determinar el resultado
// #
// # STATELESS vs STATEFUL:
// # Stateless: filter, map (no requieren saber del resto)
// # Stateful: distinct, sorted (necesitan ver todos los elementos)
// #
// # PIPELINE:
// # Secuencia de operaciones encadenadas:
// # fuente → intermedias → terminal
*/

// $ ============================================================================================================
// $ PARTE 12: RESUMEN Y MEJORES PRÁCTICAS FINALES
// $ ============================================================================================================

/*
// $ =====================================================
// $ RESUMEN EJECUTIVO
// $ =====================================================
// $
// $ Stream API permite procesar colecciones de forma:
// $ ✓ DECLARATIVA  (qué hacer, no cómo)
// $ ✓ FUNCIONAL    (sin bucles, sin variables mutables)
// $ ✓ CONCISA      (menos código, más expresivo)
// $ ✓ PARALELA     (fácil procesamiento concurrente)
// $
// $ Flujo típico:
// $ ────────────
// $ fuente
// $   → filter      (filtrar primero)
// $   → map/flatMap (transformar)
// $   → distinct    (sin duplicados)
// $   → sorted      (ordenar si necesario)
// $   → limit       (limitar cantidad)
// $   → terminal    (collect, forEach, count, etc.)
// $
// $ Recuerda:
// $ ─────────
// $ • Un Stream se usa UNA sola vez
// $ • Operaciones intermedias son LAZY
// $ • Siempre termina con operación TERMINAL
// $ • NO modifica la fuente original
// $ • Optional evita NullPointerException
*/

/*
// * =====================================================
// * MEJORES PRÁCTICAS (BEST PRACTICES)
// * =====================================================
// *
// * 1. ORDEN DE OPERACIONES
// *    ✓ filter primero (reduce elementos)
// *    ✓ map después (transforma menos elementos)
// *
// * 2. CLARIDAD
// *    ✓ Usa method references cuando sea más claro
// *    ✓ Nombres descriptivos en lambdas complejas
// *    ✗ No hagas pipelines de 10+ operaciones
// *
// * 3. OPTIONAL
// *    ✓ Siempre maneja el caso vacío
// *    ✓ Usa orElse/orElseGet en lugar de get()
// *    ✗ Nunca uses get() sin verificar isPresent()
// *
// * 4. PARALLEL
// *    ✓ Solo con colecciones grandes
// *    ✓ Solo con operaciones costosas
// *    ✗ Evita efectos secundarios
// *    ✗ No modifiques colecciones compartidas
// *
// * 5. DEBUGGING
// *    ✓ Usa peek() para inspeccionar
// *    ✓ Divide en pasos si no entiendes el resultado
// *
// * 6. RENDIMIENTO
// *    ✓ mapToInt/Long/Double para primitivos
// *    ✓ anyMatch en lugar de filter().count() > 0
// *    ✓ findFirst/findAny en lugar de collect + get(0)
// *
// * 7. REUSABILIDAD
// *    ✗ No guardes Streams en variables para reusar
// *    ✓ Guarda la colección fuente y crea Streams nuevos
*/

/*
// $ =====================================================
// $ CUÁNDO NO USAR STREAMS
// $ =====================================================
// $
// $ ✗ Operaciones muy simples (1-2 líneas)
// $   Lista.get(0) es mejor que lista.stream().findFirst()
// $
// $ ✗ Necesitas índices frecuentemente
// $   Un for tradicional con índice puede ser más claro
// $
// $ ✗ Modificar la colección original
// $   Usa métodos de Collection directamente
// $
// $ ✗ Debugging complejo
// $   A veces un bucle tradicional es más fácil de depurar
// $
// $ ✗ Rendimiento crítico en colecciones pequeñas
// $   El overhead de Streams puede no valer la pena
*/

/*
// # =====================================================
// # RECORDATORIOS FINALES
// # =====================================================
// #
// # ☑ Streams NO son siempre la mejor opción
// # ☑ Son una herramienta poderosa cuando se usan bien
// # ☑ La legibilidad es más importante que la concisión
// # ☑ Practica con ejemplos reales
// # ☑ Empieza simple, construye complejidad gradualmente
// # ☑ Consulta esta guía cuando tengas dudas
// #
// # ¡DOMINA STREAMS Y MEJORA TU CÓDIGO JAVA! 🚀
// #
// # Esta guía cubre TODO lo que viste en tus ejemplos
// # y mucho más. ¡Úsala como referencia constante!
*/
}
