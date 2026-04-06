public class Readme_Annotation {
    // * =====================================================
    // * Anotaciones en Java (Annotations + Reflection)
    // * =====================================================
    // *
    // * OBJETIVO: Entender cómo crear y usar anotaciones personalizadas
    // * NIVEL: Intermedio a Avanzado
    // * TEMA: Metaprogramación, Reflection, Serialización
    // *
    // * =====================================================


    // ? =====================================================
    // ? 🤔 ¿QUÉ SON LAS ANOTACIONES?
    // ? =====================================================

    // ? Las anotaciones son ETIQUETAS o MARCAS que pones en tu código
    // ? para dar información extra (metadata) sobre clases, métodos o atributos.

    // ! IMPORTANTE: Las anotaciones NO hacen nada por sí solas
    // ! Necesitan que alguien (otro código) las LEA y actúe según ellas

    // ? 💡 Piensa en ellas como "stickers" en tu código:
    // ? - El sticker no hace nada
    // ? - Pero alguien puede ver el sticker y hacer algo especial


    // ? =====================================================
    // ? 📌 EJEMPLOS DE ANOTACIONES QUE YA CONOCES
    // ? =====================================================

    // ? @Override
    // ? → Le dice al compilador: "Este método está sobrescribiendo otro"

    // ? @Deprecated
    // ? → Marca código viejo que ya no se debe usar

    // ? @SuppressWarnings
    // ? → Le dice al compilador que no muestre ciertos warnings

    // ? @Entity (Hibernate/JPA)
    // ? → Marca una clase como tabla de base de datos

    // ? @Autowired (Spring)
    // ? → Inyección automática de dependencias

    // ? @RestController (Spring)
    // ? → Marca una clase como controlador REST


    // # =====================================================
    // # 🎯 ¿PARA QUÉ SE USAN LAS ANOTACIONES?
    // # =====================================================

    // # ✅ Configuración sin archivos XML
    // # → Antes: XML gigantes para configurar todo
    // # → Ahora: Anotaciones directas en el código

    // # ✅ Serialización automática (JSON, XML)
    // # → Jackson, Gson usan anotaciones para convertir objetos

    // # ✅ Validaciones
    // # → @NotNull, @Email, @Min, @Max (Bean Validation)

    // # ✅ Frameworks modernos
    // # → Spring, Hibernate, JPA dependen de anotaciones

    // # ✅ Inicialización automática
    // # → Ejecutar métodos antes/después de algo

    // # ✅ Metaprogramación
    // # → Código que se escribe a sí mismo o se modifica


    // # =====================================================
    // # 🧩 LAS 3 PIEZAS DE UN SISTEMA DE ANOTACIONES
    // # =====================================================

    // ! SIEMPRE necesitas estas 3 cosas:

    // # 1️⃣ LA ANOTACIÓN
    // #    → Se crea con @interface
    // #    → Define qué información guarda

    // # 2️⃣ CÓDIGO QUE LA USA
    // #    → Clases, métodos o atributos marcados con la anotación

    // # 3️⃣ CÓDIGO QUE LA LEE
    // #    → Usa REFLECTION para detectar y procesar las anotaciones


    // ? Analogía:
    // ? 1. Stickers (anotaciones)
    // ? 2. Cajas con stickers (código marcado)
    // ? 3. Inspector que busca stickers (Reflection)


    // # =====================================================
    // # 📝 CREANDO TU PRIMERA ANOTACIÓN: @JsonAtributo
    // # =====================================================

    // * --------------------------------------------------
    // * META-ANOTACIONES (Anotaciones para anotaciones)
    // * --------------------------------------------------

    // * @Documented
    // * → Hace que la anotación aparezca en la documentación JavaDoc

    // * @Target(ElementType.FIELD)
    // * → Define DÓNDE se puede usar la anotación
    // * → ElementType.FIELD = solo en atributos/variables
    // * → Otras opciones: METHOD, TYPE, CONSTRUCTOR, PARAMETER

    // * @Retention(RetentionPolicy.RUNTIME)
    // * → Define CUÁNDO está disponible la anotación
    // * → RUNTIME = disponible durante la ejecución (necesario para Reflection)
    // * → Otras opciones: SOURCE (solo compilación), CLASS (en bytecode)


    // * --------------------------------------------------
    // * DEFINICIÓN DE LA ANOTACIÓN @JsonAtributo
    // * --------------------------------------------------

    // @Documented
    // @Target(ElementType.FIELD)
    // @Retention(RetentionPolicy.RUNTIME)
    // public @interface JsonAtributo {
    //
    //     // Parámetros de la anotación (son como "opciones")
    //     String nombre() default "";
    //     boolean capitalizar() default false;
    // }


    // $ ¿Qué permite esta anotación?

    // $ 1. Marcar qué atributos deben aparecer en JSON
    // $ 2. Cambiar el nombre del atributo en el JSON
    // $    → Si nombre = "", usa el nombre original del atributo
    // $    → Si nombre = "costo", aparece como "costo" en JSON
    // $ 3. Indicar si se debe capitalizar el texto


    // * --------------------------------------------------
    // * EJEMPLO DE USO DE @JsonAtributo
    // * --------------------------------------------------

    // @JsonAtributo
    // private String nombre;
    // % → Aparecerá como "nombre" en JSON

    // @JsonAtributo(nombre = "costo")
    // private long precio;
    // % → Aparecerá como "costo" en JSON (no "precio")

    // @JsonAtributo(capitalizar = true)
    // private String descripcion;
    // % → Se capitalizará automáticamente

    // private LocalDate fecha;
    // % → NO aparecerá en JSON (no tiene la anotación)


    // # =====================================================
    // # 🔧 SEGUNDA ANOTACIÓN: @Init
    // # =====================================================

    // * --------------------------------------------------
    // * DEFINICIÓN DE @Init
    // * --------------------------------------------------

    // @Retention(RetentionPolicy.RUNTIME)
    // @Target(ElementType.METHOD)
    // public @interface Init {
    //     // Sin parámetros, solo marca el método
    // }


    // $ ¿Para qué sirve?

    // $ Marca métodos que deben ejecutarse AUTOMÁTICAMENTE
    // $ antes de serializar el objeto

    // $ Es como un "constructor secundario" que se ejecuta
    // $ justo antes de convertir a JSON


    // * --------------------------------------------------
    // * EJEMPLO DE USO DE @Init
    // * --------------------------------------------------

    // @Init
    // private void init(){
    //     // Capitalizar el nombre automáticamente
    //     this.nombre = Arrays.stream(nombre.split(" "))
    //         .map(palabra -> palabra.substring(0, 1).toUpperCase()
    //                       + palabra.substring(1).toLowerCase())
    //         .collect(Collectors.joining(" "));
    // }

    // ! Esto es una forma de hacer inicialización automática
    // ! sin llamar manualmente al método


    // # =====================================================
    // # 📦 CLASE PRODUCTO - USANDO LAS ANOTACIONES
    // # =====================================================

    // * --------------------------------------------------
    // * ESTRUCTURA COMPLETA
    // * --------------------------------------------------

    // public class Producto {
    //
    //     @JsonAtributo
    //     private String nombre;
    //
    //     @JsonAtributo(nombre = "costo")
    //     private long precio;
    //
    //     private LocalDate fecha;
    //
    //     @Init
    //     private void init(){
    //         this.nombre = Arrays.stream(nombre.split(" "))
    //             .map(palabra -> palabra.substring(0, 1).toUpperCase()
    //                           + palabra.substring(1).toLowerCase())
    //             .collect(Collectors.joining(" "));
    //     }
    //
    //     // getters y setters...
    // }


    // % =====================================================
    // % 📊 SIGNIFICADO DE CADA CAMPO
    // % =====================================================

    // % nombre → Tiene @JsonAtributo
    // %        → Aparecerá en JSON como "nombre"
    // %        → Se capitalizará automáticamente con @Init

    // % precio → Tiene @JsonAtributo(nombre = "costo")
    // %        → Aparecerá en JSON como "costo" (no "precio")

    // % fecha → NO tiene @JsonAtributo
    // %       → NO aparecerá en el JSON final


    // # =====================================================
    // # ⚙️ MÉTODO @Init - CAPITALIZACIÓN AUTOMÁTICA
    // # =====================================================

    // * --------------------------------------------------
    // * ¿CÓMO FUNCIONA LA CAPITALIZACIÓN?
    // * --------------------------------------------------

    // $ Entrada:
    // $ "mesa centro ROBLE"

    // $ Proceso:
    // $ 1. Split por espacios → ["mesa", "centro", "ROBLE"]
    // $ 2. Map cada palabra:
    // $    - Primera letra mayúscula
    // $    - Resto minúsculas
    // $ 3. Join con espacios

    // $ Salida:
    // $ "Mesa Centro Roble"


    // * Código del método:

    // this.nombre = Arrays.stream(nombre.split(" "))
    //     .map(palabra -> palabra.substring(0, 1).toUpperCase()
    //                   + palabra.substring(1).toLowerCase())
    //     .collect(Collectors.joining(" "));


    // # =====================================================
    // # 🔍 CLASE JsonSerializador - EL CEREBRO DEL SISTEMA
    // # =====================================================

    // ! Esta clase usa REFLECTION para:
    // ! 1. Detectar métodos con @Init
    // ! 2. Ejecutarlos automáticamente
    // ! 3. Leer atributos con @JsonAtributo
    // ! 4. Construir el JSON


    // * --------------------------------------------------
    // * MÉTODO 1: inicializarObjeto()
    // * --------------------------------------------------

    // public static void inicializarObjeto(Object object){
    //
    //     // Validar que no sea null
    //     if(object == null){
    //         throw new JsonSerializadorException(
    //             "El objeto a serializar no puede ser null!!"
    //         );
    //     }
    //
    //     // 1. Obtener todos los métodos de la clase
    //     Method[] metodos = object.getClass().getDeclaredMethods();
    //
    //     // 2. Filtrar solo los que tienen @Init
    //     Arrays.stream(metodos)
    //         .filter(m -> m.isAnnotationPresent(Init.class))
    //         .forEach(m -> {
    //
    //             // 3. Permitir acceso a métodos privados
    //             m.setAccessible(true);
    //
    //             try {
    //                 // 4. Ejecutar el método automáticamente
    //                 m.invoke(object);
    //
    //             } catch (IllegalAccessException | InvocationTargetException e) {
    //                 throw new JsonSerializadorException(
    //                     "Error al serializar, no se puede inicializar el objeto! "
    //                     + e.getMessage()
    //                 );
    //             }
    //         });
    // }


    // $ ¿Qué hace cada línea?

    // $ object.getClass().getDeclaredMethods()
    // $ → Obtiene TODOS los métodos (públicos, privados, protegidos)

    // $ m.isAnnotationPresent(Init.class)
    // $ → Pregunta: "¿Este método tiene la anotación @Init?"

    // $ m.setAccessible(true)
    // $ → Permite acceder a métodos privados

    // $ m.invoke(object)
    // $ → Ejecuta el método dinámicamente


    // * --------------------------------------------------
    // * MÉTODO 2: convertirJson()
    // * --------------------------------------------------

    // public static String convertirJson(Object object){
    //
    //     // 1. Validar que no sea null
    //     if(object == null){
    //         throw new JsonSerializadorException(
    //             "El objeto a serializar no puede ser null!!"
    //         );
    //     }
    //
    //     // 2. Ejecutar métodos @Init primero
    //     inicializarObjeto(object);
    //
    //     // 3. Obtener todos los atributos
    //     Field[] atributos = object.getClass().getDeclaredFields();
    //
    //     // 4. Procesar solo los que tienen @JsonAtributo
    //     return Arrays.stream(atributos)
    //         .filter(f -> f.isAnnotationPresent(JsonAtributo.class))
    //         .map(f -> {
    //
    //             // Permitir acceso a atributos privados
    //             f.setAccessible(true);
    //
    //             // Determinar el nombre en JSON
    //             String nombre = f.getAnnotation(JsonAtributo.class)
    //                 .nombre().equals("")
    //                 ? f.getName()
    //                 : f.getAnnotation(JsonAtributo.class).nombre();
    //
    //             try {
    //                 // Obtener el valor del atributo
    //                 Object valor = f.get(object);
    //
    //                 // Si debe capitalizarse
    //                 if(f.getAnnotation(JsonAtributo.class).capitalizar()
    //                    && valor instanceof String){
    //
    //                     String nuevoValor = (String) valor;
    //                     nuevoValor = Arrays.stream(nuevoValor.split(" "))
    //                         .map(palabra -> palabra.substring(0, 1).toUpperCase()
    //                                       + palabra.substring(1).toLowerCase())
    //                         .collect(Collectors.joining(" "));
    //
    //                     f.set(object, nuevoValor);
    //                 }
    //
    //                 // Construir el par "nombre":"valor"
    //                 return "\"" + nombre + "\":\"" + f.get(object) + "\"";
    //
    //             } catch (IllegalAccessException e) {
    //                 throw new JsonSerializadorException(
    //                     "Error al serializar a json: " + e.getMessage()
    //                 );
    //             }
    //         })
    //         // 5. Unir todo en formato JSON
    //         .reduce("{", (a, b) -> {
    //             if("{".equals(a)){
    //                 return a + b;
    //             }
    //             return a + ", " + b;
    //         }).concat("}");
    // }


    // # =====================================================
    // # 🔬 REFLECTION API - MÉTODOS CLAVE
    // # =====================================================

    // * --------------------------------------------------
    // * OBTENER INFORMACIÓN DE LA CLASE
    // * --------------------------------------------------

    // $ object.getClass()
    // $ → Obtiene la clase del objeto

    // $ .getDeclaredFields()
    // $ → Obtiene todos los atributos (public, private, protected)

    // $ .getDeclaredMethods()
    // $ → Obtiene todos los métodos


    // * --------------------------------------------------
    // * TRABAJAR CON ANOTACIONES
    // * --------------------------------------------------

    // $ f.isAnnotationPresent(JsonAtributo.class)
    // $ → Pregunta: "¿Tiene esta anotación?"
    // $ → Devuelve true o false

    // $ f.getAnnotation(JsonAtributo.class)
    // $ → Obtiene la anotación para leer sus parámetros

    // $ .nombre()
    // $ → Lee el parámetro "nombre" de la anotación


    // * --------------------------------------------------
    // * ACCEDER A MIEMBROS PRIVADOS
    // * --------------------------------------------------

    // $ f.setAccessible(true)
    // $ → Permite acceder a atributos/métodos privados
    // $ → Sin esto, da IllegalAccessException


    // * --------------------------------------------------
    // * LEER Y MODIFICAR VALORES
    // * --------------------------------------------------

    // $ f.get(object)
    // $ → Obtiene el valor del atributo

    // $ f.set(object, nuevoValor)
    // $ → Modifica el valor del atributo

    // $ m.invoke(object)
    // $ → Ejecuta un método dinámicamente


    // # =====================================================
    // # 📝 CONSTRUCCIÓN DEL JSON CON reduce()
    // # =====================================================

    // * --------------------------------------------------
    // * ¿CÓMO FUNCIONA EL reduce()?
    // * --------------------------------------------------

    // $ Stream de pares:
    // $ "nombre":"Mesa Centro Roble"
    // $ "costo":"1000"

    // $ reduce("{", (a, b) -> {
    // $     if("{".equals(a)){
    // $         return a + b;
    // $     }
    // $     return a + ", " + b;
    // $ }).concat("}");


    // % Paso a paso:

    // % a = acumulador (lo que llevamos construido)
    // % b = siguiente elemento

    // % Iteración 1:
    // % a = "{"
    // % b = "\"nombre\":\"Mesa Centro Roble\""
    // % resultado = "{\"nombre\":\"Mesa Centro Roble\""

    // % Iteración 2:
    // % a = "{\"nombre\":\"Mesa Centro Roble\""
    // % b = "\"costo\":\"1000\""
    // % resultado = "{\"nombre\":\"Mesa Centro Roble\", \"costo\":\"1000\""

    // % Al final:
    // % .concat("}")
    // % resultado = "{\"nombre\":\"Mesa Centro Roble\", \"costo\":\"1000\"}"


    // # =====================================================
    // # ⚠️ EXCEPCIÓN PERSONALIZADA
    // # =====================================================

    // * --------------------------------------------------
    // * JsonSerializadorException
    // * --------------------------------------------------

    // public class JsonSerializadorException extends RuntimeException {
    //     public JsonSerializadorException(String message) {
    //         super(message);
    //     }
    // }


    // $ ¿Por qué usar una excepción personalizada?

    // $ ✅ Mensajes de error claros y específicos
    // $ ✅ Fácil identificar problemas de serialización
    // $ ✅ Mejor control de errores
    // $ ✅ Código más mantenible


    // # =====================================================
    // # 🎬 FLUJO COMPLETO DEL PROGRAMA
    // # =====================================================

    // % --------------------------------------------------
    // % PASO A PASO COMPLETO
    // % --------------------------------------------------

    // % 1. CREAR OBJETO
    // Producto p = new Producto();
    // p.setFecha(LocalDate.now());
    // p.setNombre("mesa centro ROBLE");
    // p.setPrecio(1000L);

    // % 2. LLAMAR SERIALIZADOR
    // JsonSerializador.convertirJson(p);

    // % 3. VALIDAR OBJETO NO NULL
    // if(object == null){ throw... }

    // % 4. EJECUTAR MÉTODOS @Init
    // inicializarObjeto(object)
    //     → Busca método init()
    //     → Lo ejecuta
    //     → "mesa centro ROBLE" → "Mesa Centro Roble"

    // % 5. OBTENER ATRIBUTOS
    // getDeclaredFields()
    //     → nombre, precio, fecha

    // % 6. FILTRAR POR @JsonAtributo
    //     → nombre ✅
    //     → precio ✅
    //     → fecha ❌ (no tiene la anotación)

    // % 7. CONSTRUIR PARES JSON
    //     → "nombre":"Mesa Centro Roble"
    //     → "costo":"1000"

    // % 8. UNIR CON reduce()
    //     → {"nombre":"Mesa Centro Roble", "costo":"1000"}

    // % 9. IMPRIMIR RESULTADO
    // json = {"nombre":"Mesa Centro Roble", "costo":"1000"}


    // # =====================================================
    // # 💡 IDEA CLAVE PARA ENTENDER TODO
    // # =====================================================

    // ! Anotación = ETIQUETA/MARCA en el código
    // ! Reflection = DETECTOR DE ETIQUETAS
    // ! Serializador = USA LAS ETIQUETAS para hacer su trabajo

    // ? Analogía completa:

    // ? 📌 Anotación (@JsonAtributo)
    // ?    = Sticker que dice "INCLUIR EN JSON"

    // ? 🔍 Reflection
    // ?    = Inspector que busca stickers

    // ? 🏭 Serializador
    // ?    = Fábrica que procesa solo lo que tiene sticker


    // # =====================================================
    // # 🌍 EJEMPLOS REALES DONDE SE USA ESTO
    // # =====================================================

    // # Spring Boot
    // # → @RestController, @Service, @Autowired
    // # → Inyección de dependencias automática

    // # Hibernate / JPA
    // # → @Entity, @Table, @Column, @Id
    // # → Mapeo objeto-relacional automático

    // # Jackson (Serialización JSON)
    // # → @JsonProperty, @JsonIgnore
    // # → Conversión automática a JSON (como nuestro ejemplo)

    // # Lombok
    // # → @Getter, @Setter, @Data
    // # → Genera código automáticamente

    // # Bean Validation
    // # → @NotNull, @Email, @Min, @Max
    // # → Validaciones automáticas


    // ! De hecho, Jackson hace exactamente lo que hicimos,
    // ! pero mucho más avanzado y optimizado


    // # =====================================================
    // # 📋 TIPOS DE @Target MÁS COMUNES
    // # =====================================================

    // * ElementType.TYPE
    // * → Clases, interfaces, enums

    // * ElementType.FIELD
    // * → Atributos/variables

    // * ElementType.METHOD
    // * → Métodos

    // * ElementType.PARAMETER
    // * → Parámetros de métodos

    // * ElementType.CONSTRUCTOR
    // * → Constructores

    // * ElementType.LOCAL_VARIABLE
    // * → Variables locales

    // * ElementType.ANNOTATION_TYPE
    // * → Otras anotaciones (meta-anotaciones)


    // # =====================================================
    // # 📋 TIPOS DE @Retention
    // # =====================================================

    // * RetentionPolicy.SOURCE
    // * → Solo en código fuente
    // * → Descartada al compilar
    // * → Ejemplo: @Override

    // * RetentionPolicy.CLASS
    // * → En bytecode (.class)
    // * → NO disponible en runtime
    // * → Valor por defecto

    // * RetentionPolicy.RUNTIME
    // * → Disponible en ejecución
    // * → Necesario para Reflection
    // * → Usamos este en nuestro ejemplo


    // ! Para usar Reflection, SIEMPRE necesitas RUNTIME


    // * =====================================================
    // * ✅ RESUMEN RÁPIDO PARA MEMORIZAR
    // * =====================================================

    // $ @interface
    // $ → Crea una anotación personalizada

    // $ @Retention(RetentionPolicy.RUNTIME)
    // $ → Hace que esté disponible en ejecución

    // $ @Target(ElementType.FIELD)
    // $ → Define dónde se puede usar

    // $ isAnnotationPresent(Anotacion.class)
    // $ → Detecta si tiene la anotación

    // $ getAnnotation(Anotacion.class)
    // $ → Obtiene la anotación para leer sus valores

    // $ setAccessible(true)
    // $ → Permite acceder a miembros privados

    // $ invoke(object)
    // $ → Ejecuta métodos dinámicamente

    // $ reduce()
    // $ → Acumula/une elementos


    // ? =====================================================
    // ? 🧠 REGLA MENTAL SÚPER FÁCIL
    // ? =====================================================

    // ? 1. Anotación = MARCA/STICKER
    // ?    "Este campo es especial"

    // ? 2. Reflection = DETECTOR
    // ?    "¿Dónde están las marcas?"

    // ? 3. Procesador = EJECUTOR
    // ?    "Haz algo con lo marcado"


    // * =====================================================
    // * 🎯 CASOS DE USO PRÁCTICOS
    // * =====================================================

    // * ¿Convertir objetos a JSON/XML?
    // * → Anotaciones + Reflection (como nuestro ejemplo)

    // * ¿Validar datos automáticamente?
    // * → @NotNull, @Email, @Min

    // * ¿Mapear tablas de BD?
    // * → @Entity, @Table, @Column

    // * ¿Inyectar dependencias?
    // * → @Autowired, @Inject

    // * ¿Ejecutar código antes/después?
    // * → @PostConstruct, @PreDestroy

    // * ¿Generar código automáticamente?
    // * → @Getter, @Setter (Lombok)


    // * =====================================================
    // * 🔗 CONCEPTOS RELACIONADOS
    // * =====================================================

    // * Reflection API
    // * → Inspeccionar y modificar código en runtime

    // * Introspección
    // * → Examinar la estructura del código

    // * Metaprogramación
    // * → Código que manipula código

    // * Decoradores/Annotations
    // * → Añadir funcionalidad sin modificar código original


    // * =====================================================
    // * ⚡ VENTAJAS Y DESVENTAJAS
    // * =====================================================

    // $ VENTAJAS:

    // $ ✅ Código más limpio y legible
    // $ ✅ Menos configuración manual
    // $ ✅ Menos errores (automatización)
    // $ ✅ Fácil mantenimiento
    // $ ✅ Reutilización de lógica


    // $ DESVENTAJAS:

    // $ ❌ Más difícil de debuggear
    // $ ❌ Reflection es lento
    // $ ❌ Curva de aprendizaje
    // $ ❌ Puede ocultar complejidad


    // ! Usa anotaciones cuando:
    // ! - Tienes lógica repetitiva
    // ! - Necesitas configuración declarativa
    // ! - Quieres frameworks (Spring, Hibernate)

}
