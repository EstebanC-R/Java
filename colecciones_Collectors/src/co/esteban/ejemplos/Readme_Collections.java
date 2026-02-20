package co.esteban.ejemplos;

public class Readme_Collections {

/*
// $ (Rosa)        -> Conceptos principales
// ! (Rojo)        -> Advertencias / errores comunes
// ? (Azul)        -> Preguntas para reflexionar
// * (Verde)       -> Buenas prácticas
// % (Amarillo)    -> Ejemplos prácticos / casos reales
// # (Naranja)     -> Detalles técnicos internos (cómo funciona Java)
*/

/*
// $ =====================================================
// $ JAVA COLLECTIONS FRAMEWORK
// $ =====================================================
// $
// $ Es un conjunto de interfaces y clases que permiten
// $ almacenar, manipular y recorrer grupos de objetos.
// $
// $ Objetivo principal:
// $ - Reutilizar código
// $ - Usar estructuras de datos ya probadas y optimizadas
// $ - Evitar errores comunes al manejar arreglos manuales
// $ - Proporcionar algoritmos estándar (sort, search, etc.)
// $
// % Ejemplo real:
// % Listas de usuarios, productos, notas, registros, etc.
// % Carritos de compra, historiales, configuraciones
*/

/*
// $ =====================================================
// $ JERARQUÍA GENERAL
// $ =====================================================
// $
// $           Iterable<E>
// $               |
// $           Collection<E>
// $           /    |    \
// $        List   Set   Queue
// $
// $           Map<K,V> (NO hereda de Collection)
// $
// # Iterable permite recorrer con for-each
// # <E> indica que son genéricos (tipo parametrizado)
// # <K,V> en Map indica Clave (Key) y Valor (Value)
*/

/*
// ! =====================================================
// ! MAP NO HEREDA DE COLLECTION
// ! =====================================================
// !
// ! Collection almacena ELEMENTOS individuales
// ! Ejemplo: Alumno, String, Integer
// !
// ! Map almacena PARES CLAVE–VALOR
// ! Ejemplo: "email" → "juan@mail.com"
// !
// ! Por eso tienen APIs diferentes:
// ! - Collection usa add(elemento)
// ! - Map usa put(clave, valor)
// !
// # Map tampoco implementa Iterable directamente
// # Para iterar usamos: keySet(), values(), entrySet()
*/

/*
// $ =====================================================
// $ INTERFACE Collection<E>
// $ =====================================================
// $
// $ Es la base común de List, Set y Queue.
// $
// $ Define operaciones que TODAS las colecciones comparten:
// $
// $ • add(E elemento)           - Agregar elemento
// $ • remove(Object o)           - Eliminar elemento
// $ • contains(Object o)         - Verificar si existe
// $ • size()                     - Cantidad de elementos
// $ • isEmpty()                  - Verificar si está vacía
// $ • clear()                    - Eliminar todos los elementos
// $ • iterator()                 - Obtener iterador para recorrer
// $ • toArray()                  - Convertir a arreglo
// $ • addAll(Collection c)       - Agregar otra colección
// $ • removeAll(Collection c)    - Eliminar elementos de otra colección
// $ • retainAll(Collection c)    - Mantener solo elementos comunes
// $
// * Todas estas operaciones están disponibles en List y Set
*/

/*
// $ =====================================================
// $ LIST (INTERFACE)
// $ =====================================================
// $
// $ Características:
// $ - Permite elementos duplicados
// $ - Mantiene orden de inserción
// $ - Acceso por índice (get, set)
// $ - Permite elementos null
// $
// $ Métodos adicionales de List (además de Collection):
// $ • get(int index)             - Obtener elemento en posición
// $ • set(int index, E elemento) - Reemplazar elemento
// $ • add(int index, E elemento) - Insertar en posición
// $ • remove(int index)          - Eliminar por posición
// $ • indexOf(Object o)          - Primera posición del elemento
// $ • lastIndexOf(Object o)      - Última posición del elemento
// $ • subList(int from, int to)  - Sublista
// $
// % Ejemplo real:
// % - Historial de acciones (deshacer/rehacer)
// % - Lista de estudiantes (mantiene orden de inscripción)
// % - Carrito de compras (puede haber productos repetidos)
// % - Playlist de música
// $
// ? ¿Cuándo usar List?
// ? - Cuando el ORDEN importa
// ? - Cuando necesitas acceso por índice
// ? - Cuando puedes tener duplicados
*/

/*
// % =====================================================
// % ArrayList<E>
// % =====================================================
// %
// % Implementación más común de List
// % Internamente usa un ARREGLO dinámico
// %
// % List<Alumno> lista = new ArrayList<>();
// % lista.add(new Alumno("Mateo", 5.1));
// % lista.add(new Alumno("Pepe", 4.0));
// % lista.get(0);  // Acceso rápido por índice
*/

/*
// # Funcionamiento interno de ArrayList:
// #
// # - Usa un arreglo interno Object[] elementData
// # - Capacidad inicial por defecto: 10 elementos
// # - Cuando se llena, crea un nuevo arreglo más grande
// # - Nueva capacidad = capacidad_actual * 1.5
// # - Copia todos los elementos al nuevo arreglo
// #
// # Ejemplo:
// # [1,2,3,4,5,_,_,_,_,_] capacidad=10, size=5
// # Al agregar 6 más elementos:
// # [1,2,3,4,5,6,7,8,9,10,11,_,_,_,_] capacidad=15, size=11
*/

/*
// * Ventajas de ArrayList:
// * - Acceso rápido por índice O(1)
// * - Ideal para lectura frecuente y recorridos
// * - Muy usado en la práctica (90% de los casos)
// * - Bajo consumo de memoria
// * - Métodos eficientes: get(), size(), iterator()
*/

/*
// ! Desventajas de ArrayList:
// ! - Insertar en el medio es costoso O(n)
// ! - Eliminar en el medio es costoso O(n)
// ! - Se deben mover todos los elementos posteriores
// !
// ! Ejemplo del costo:
// ! lista = [A, B, C, D, E]
// ! lista.add(2, X);  // Insertar X en posición 2
// ! Resultado: [A, B, X, C, D, E]
// ! Java debe mover C, D, E una posición a la derecha
// !
// ! Si tienes 10,000 elementos y insertas al inicio,
// ! Java debe mover los 10,000 elementos = LENTO
*/

/*
// % =====================================================
// % LinkedList<E>
// % =====================================================
// %
// % Lista basada en NODOS enlazados (doubly-linked list)
// %
// % LinkedList<Alumno> enlazada = new LinkedList<>();
// % enlazada.addFirst(new Alumno("Kratos", 5.0));
// % enlazada.addLast(new Alumno("Zeus", 2.0));
// % enlazada.getFirst();  // Obtener primero
// % enlazada.getLast();   // Obtener último
*/

/*
// # Funcionamiento interno de LinkedList:
// #
// # Cada elemento es un NODO con 3 partes:
// # - dato (el objeto almacenado)
// # - enlace al nodo anterior (prev)
// # - enlace al nodo siguiente (next)
// #
// # Estructura en memoria:
// # null <- [Kratos] <-> [Zeus] <-> [Mateo] -> null
// #          ^first                   ^last
// #
// # NO hay índices reales en memoria
// # Para acceder al índice 5, Java debe recorrer
// # desde el inicio (o fin) hasta llegar al nodo 5
*/

/*
// % ¿Para qué sirve LinkedList?
// % - Cuando insertas/eliminas frecuentemente al inicio o fin
// % - Cuando necesitas trabajar como COLA (Queue)
// % - Cuando necesitas trabajar como PILA (Stack)
// % - Cuando NO necesitas acceso aleatorio por índice
// %
// % Ejemplos reales:
// % - Cola de atención en banco (FIFO - First In First Out)
// % - Historial deshacer/rehacer de editor de texto
// % - Buffer de impresión
// % - Lista de reproducción con inserción frecuente
*/

/*
// * Ventajas de LinkedList:
// * - Inserciones y eliminaciones al inicio/fin rápidas O(1)
// * - No necesita redimensionar arreglos
// * - Implementa List, Queue y Deque
// *
// * Métodos especiales de LinkedList:
// * • addFirst(E)  / addLast(E)    - Agregar al inicio/fin
// * • getFirst()   / getLast()     - Obtener inicio/fin
// * • removeFirst()/ removeLast()  - Eliminar inicio/fin
// * • peekFirst()  / peekLast()    - Ver sin eliminar (null si vacío)
// * • pollFirst()  / pollLast()    - Eliminar y obtener (null si vacío)
// * • pop()                        - Equivalente a removeFirst()
// * • push(E)                      - Equivalente a addFirst()
*/

/*
// ! Desventajas de LinkedList:
// ! - Acceso por índice lento O(n)
// ! - Mayor consumo de memoria (cada nodo guarda 2 referencias)
// ! - Rendimiento general inferior a ArrayList en la mayoría de casos
// !
// ! Diferencia get() vs peek() vs poll():
// ! - get(index): Lanza excepción si índice inválido
// ! - peek():     Retorna null si lista vacía (NO elimina)
// ! - poll():     Retorna null si lista vacía (SÍ elimina)
// !
// ! Diferencia remove() vs poll():
// ! - remove():   Lanza NoSuchElementException si vacío
// ! - poll():     Retorna null si vacío (más seguro)
*/

/*
// ? Pregunta típica de entrevista:
// ? ¿ArrayList o LinkedList?
// ?
// ? Usa ArrayList SI:
// ? - Lees/accedes frecuentemente por índice
// ? - Agregas elementos solo al final
// ? - No insertas/eliminas en el medio frecuentemente
// ? - La mayoría de operaciones son: get(), size(), recorridos
// ?
// ? Usa LinkedList SI:
// ? - Insertas/eliminas frecuentemente al inicio o medio
// ? - Necesitas funcionalidad de Queue o Deque
// ? - Usas addFirst(), removeFirst() frecuentemente
// ? - NO necesitas acceso aleatorio por índice
// ?
// ? En la práctica: ArrayList gana en el 95% de casos
*/

/*
// $ =====================================================
// $ ITERADORES (Iterator y ListIterator)
// $ =====================================================
// $
// $ Iterator<E> - Recorre CUALQUIER Collection
// $ - Dirección: Solo hacia adelante (->)
// $ - Métodos: hasNext(), next(), remove()
// $ - Funciona con: List, Set, Queue
// $
// $ ListIterator<E> - Solo para LISTAS
// $ - Dirección: Adelante y atrás (<->)
// $ - Métodos adicionales:
// $   • hasPrevious() / previous()  - Recorrer atrás
// $   • nextIndex() / previousIndex() - Índices
// $   • set(E)                       - Modificar elemento actual
// $   • add(E)                       - Insertar elemento
// $
// % Ejemplo de Iterator:
// % Iterator<Alumno> it = lista.iterator();
// % while(it.hasNext()) {
// %     Alumno a = it.next();
// %     System.out.println(a);
// %     if(a.getNota() < 3) it.remove(); // Eliminar durante iteración
// % }
// %
// % Ejemplo de ListIterator:
// % ListIterator<Alumno> li = enlazada.listIterator();
// % while(li.hasNext()) {
// %     Alumno a = li.next();
// %     System.out.println(a);
// % }
// % // Ahora recorrer hacia atrás
// % while(li.hasPrevious()) {
// %     Alumno a = li.previous();
// %     System.out.println(a);
// % }
*/

/*
// $ =====================================================
// $ SET (INTERFACE)
// $ =====================================================
// $
// $ Características:
// $ - NO permite duplicados
// $ - El orden depende de la implementación
// $ - Modelado matemático de conjuntos
// $
// $ ¿Cómo detecta duplicados?
// $ Depende de equals() y hashCode()
// $
// % Ejemplo real:
// % - Emails únicos en sistema
// % - IDs únicos de productos
// % - Tags o etiquetas sin repetir
// % - Detectar elementos duplicados en listas
*/

/*
// % =====================================================
// % HashSet<E>
// % =====================================================
// %
// % Implementación más rápida de Set
// % NO mantiene ningún orden
// %
// % Set<String> unicos = new HashSet<>();
// % unicos.add("Corvina");
// % unicos.add("Lenguado");
// % unicos.add("Lenguado"); // NO se agrega (duplicado)
// % System.out.println(unicos); // [Corvina, Lenguado]
*/

/*
// # Funcionamiento interno de HashSet:
// #
// # Usa una tabla hash (HashMap internamente)
// # Cada elemento se almacena según su hashCode()
// #
// # Proceso de inserción:
// # 1. Calcula hashCode() del objeto
// # 2. Determina la posición en la tabla hash
// # 3. Si hay otro objeto en esa posición (colisión):
// #    - Usa equals() para comparar
// #    - Si equals() retorna true = DUPLICADO (no agrega)
// #    - Si equals() retorna false = agrega en cadena
// #
// # Ejemplo:
// # "Lenguado".hashCode() = 123456
// # posición = 123456 % tamaño_tabla
*/

/*
// * Ventajas de HashSet:
// * - Muy rápido O(1) para add, remove, contains
// * - Ideal para validar duplicados
// * - Rendimiento constante independiente del tamaño
// *
// * Uso común para detectar duplicados:
// * Set<String> unicos = new HashSet<>();
// * Set<String> duplicados = new HashSet<>();
// * for(String elemento : array) {
// *     if(!unicos.add(elemento)) {
// *         duplicados.add(elemento);
// *     }
// * }
*/

/*
// ! Error común con HashSet:
// ! No sobrescribir hashCode() y equals() en clases personalizadas
// !
// ! Sin equals() y hashCode() sobrescritos:
// ! Set<Alumno> set = new HashSet<>();
// ! set.add(new Alumno("Pepe", 4.0));
// ! set.add(new Alumno("Pepe", 4.0)); // Se agrega como DIFERENTE!
// !
// ! Java compara por referencia, no por contenido
// ! Solución: Sobrescribir equals() y hashCode() en Clase como Alumno
// !
// ! @Override
// ! public boolean equals(Object o) {
// !     if(this == o) return true;
// !     if(o == null || getClass() != o.getClass()) return false;
// !     Alumno alumno = (Alumno) o;
// !     return Objects.equals(nombre, alumno.nombre) &&
// !            Objects.equals(nota, alumno.nota);
// ! }
// !
// ! @Override
// ! public int hashCode() {
// !     return Objects.hash(nombre, nota);
// ! }
// !
// ! Regla de oro: Si sobrescribes equals(), DEBES sobrescribir hashCode()
*/

/*
// % =====================================================
// % LinkedHashSet<E>
// % =====================================================
// %
// % HashSet que MANTIENE el orden de inserción
// %
// % Set<String> ordenado = new LinkedHashSet<>();
// % ordenado.add("tres");
// % ordenado.add("uno");
// % ordenado.add("dos");
// % System.out.println(ordenado); // [tres, uno, dos]
*/

/*
// # Funcionamiento interno:
// # - HashSet + lista doblemente enlazada
// # - Cada elemento tiene enlace al siguiente insertado
// #
// * Ventajas:
// * - Sin duplicados
// * - Mantiene orden de inserción
// * - Útil cuando el orden de llegada es importante
// *
// ! Desventajas:
// ! - Más memoria que HashSet (por los enlaces)
// ! - Ligeramente más lento que HashSet
*/

/*
// % =====================================================
// % TreeSet<E>
// % =====================================================
// %
// % Set que mantiene elementos ORDENADOS automáticamente
// %
// % Set<Integer> numeros = new TreeSet<>();
// % numeros.add(5);
// % numeros.add(1);
// % numeros.add(3);
// % System.out.println(numeros); // [1, 3, 5] - Ordenados!
// %
// % // Con Comparator personalizado:
// % Set<String> palabras = new TreeSet<>(Comparator.reverseOrder());
// % palabras.add("uno");
// % palabras.add("dos");
// % palabras.add("tres");
// % System.out.println(palabras); // [uno, tres, dos] - Orden inverso
*/

/*
// # Funcionamiento interno de TreeSet:
// #
// # - Árbol binario balanceado (Red-Black Tree)
// # - Cada inserción mantiene el árbol ordenado
// # - Complejidad O(log n) para add, remove, contains
// #
// # Requiere que los elementos sean COMPARABLES:
// # Opción 1: Clase implementa Comparable<T>
// # Opción 2: Proveer un Comparator al constructor
*/

/*
// * TreeSet con objetos personalizados:
// *
// * Opción 1 - Implementar Comparable en la clase:
// * public class Alumno implements Comparable<Alumno> {
// *     @Override
// *     public int compareTo(Alumno otro) {
// *         return this.nombre.compareTo(otro.nombre);
// *     }
// * }
// * Set<Alumno> alumnos = new TreeSet<>();
// *
// * Opción 2 - Usar Comparator:
// * Set<Alumno> alumnos = new TreeSet<>(
// *     Comparator.comparing(Alumno::getNota).reversed()
// * );
*/

/*
// ! ERROR GRAVE con TreeSet y compareTo():
// !
// ! Si compareTo() devuelve 0, TreeSet considera duplicado
// ! Aunque equals() diga que son diferentes!
// !
// ! Ejemplo del error:
// ! Set<Alumno> set = new TreeSet<>(
// !     Comparator.comparing(Alumno::getNota)
// ! );
// ! set.add(new Alumno("Mateo", 5.0));
// ! set.add(new Alumno("Pepe", 5.0));  // NO SE AGREGA!
// !
// ! Ambos tienen nota 5.0, compareTo() retorna 0
// ! TreeSet los considera duplicados
// ! Solo queda el primero en el conjunto
// !
// ! Solución: Comparar por múltiples campos
// ! Comparator.comparing(Alumno::getNota)
// !           .thenComparing(Alumno::getNombre)
*/

/*
// $ =====================================================
// $ MAP (INTERFACE)
// $ =====================================================
// $
// $ Almacena pares CLAVE → VALOR
// $ - Cada clave es única (como Set de claves)
// $ - Valores pueden repetirse
// $ - NO implementa Collection
// $
// $ Métodos principales:
// $ • put(K clave, V valor)      - Insertar/actualizar
// $ • get(K clave)               - Obtener valor
// $ • remove(K clave)            - Eliminar por clave
// $ • containsKey(K clave)       - Verificar si existe clave
// $ • containsValue(V valor)     - Verificar si existe valor
// $ • keySet()                   - Set de todas las claves
// $ • values()                   - Collection de todos los valores
// $ • entrySet()                 - Set de pares Entry<K,V>
// $ • getOrDefault(K, V default) - Obtener o valor por defecto
// $ • replace(K, V)              - Reemplazar valor
// $ • size()                     - Cantidad de pares
// $ • isEmpty()                  - Verificar si está vacío
// $ • clear()                    - Eliminar todos los pares
// $
// % Ejemplo real:
// % - Configuraciones de aplicación: "theme" → "dark"
// % - Datos de usuario: "email" → "user@mail.com"
// % - Diccionarios: "hello" → "hola"
// % - Caché de resultados: clave → resultado calculado
*/

/*
// % =====================================================
// % HashMap<K, V>
// % =====================================================
// %
// % El Map más utilizado (95% de los casos)
// % NO mantiene orden
// %
// % Map<String, Object> persona = new HashMap<>();
// % persona.put("nombre", "John");
// % persona.put("apellido", "Doe");
// % persona.put("edad", 30);
// % persona.put(null, "1234"); // Permite UNA clave null
// %
// % String nombre = (String) persona.get("nombre");
// % System.out.println(nombre); // John
*/

/*
// # Funcionamiento interno de HashMap:
// #
// # - Tabla hash sobre las CLAVES
// # - Usa hashCode() de la clave
// # - Usa equals() para comparar claves
// #
// # Proceso put(clave, valor):
// # 1. Calcula clave.hashCode()
// # 2. Determina posición en tabla
// # 3. Si existe otra clave en esa posición:
// #    - Compara con equals()
// #    - Si equals() true: REEMPLAZA el valor
// #    - Si equals() false: agrega en cadena (colisión)
// #
// # Permite:
// # - Una clave null (en posición especial)
// # - Múltiples valores null
*/

/*
// * Formas de recorrer un HashMap:
// *
// * 1. Recorrer solo claves:
// * for(String clave : mapa.keySet()) {
// *     Object valor = mapa.get(clave);
// *     System.out.println(clave + " => " + valor);
// * }
// *
// * 2. Recorrer solo valores:
// * for(Object valor : mapa.values()) {
// *     System.out.println(valor);
// * }
// *
// * 3. Recorrer pares clave-valor (RECOMENDADO):
// * for(Map.Entry<String, Object> entry : mapa.entrySet()) {
// *     String clave = entry.getKey();
// *     Object valor = entry.getValue();
// *     System.out.println(clave + " => " + valor);
// * }
// *
// * 4. Java 8+ forEach:
// * mapa.forEach((clave, valor) ->
// *     System.out.println(clave + " => " + valor)
// * );
*/

/*
// ! Error común con HashMap:
// ! Usar claves MUTABLES (que pueden cambiar)
// !
// ! class Persona {
// !     String nombre; // Sin final, puede cambiar!
// ! }
// !
// ! Map<Persona, String> mapa = new HashMap<>();
// ! Persona p = new Persona("John");
// ! mapa.put(p, "Dato importante");
// ! p.nombre = "Jane"; // CAMBIÓ LA CLAVE!
// ! mapa.get(p); // Puede retornar null! hashCode() cambió
// !
// ! Solución: Usar claves INMUTABLES
// ! - String (ya es inmutable)
// ! - Integer, Long (inmutables)
// ! - Clases con campos final
// !
// ! * Nota importante sobre claves null:
// ! * HashMap permite UNA clave null, pero si intentas poner otra,
// ! * simplemente REEMPLAZA el valor de la clave null anterior:
// ! * persona.put(null, "1234");
// ! * persona.put(null, "12345"); // Reemplaza, solo queda "12345"
*/

/*
// * Método útil getOrDefault():
// *
// * Map<String, String> direccion = persona.get("direccion");
// * String barrio = direccion.getOrDefault("barrio", "Desconocido");
// *
// * Si "barrio" no existe, retorna "Desconocido"
// * Evita verificar con if(direccion.containsKey("barrio"))
*/

/*
// % =====================================================
// % LinkedHashMap<K, V>
// % =====================================================
// %
// % HashMap que MANTIENE orden de inserción
// %
// % Map<String, Integer> mapa = new LinkedHashMap<>();
// % mapa.put("c", 3);
// % mapa.put("a", 1);
// % mapa.put("b", 2);
// % System.out.println(mapa); // {c=3, a=1, b=2} - Orden insertado
*/

/*
// # Funcionamiento interno:
// # - HashMap + lista doblemente enlazada
// # - Cada entrada tiene enlace a la siguiente insertada
// #
// * Ventajas:
// * - Ideal para cachés LRU (Least Recently Used)
// * - Útil cuando el orden de inserción importa
// * - Recorridos predecibles
// *
// % Ejemplo de uso:
// % Mantener orden de preferencias de usuario
// % Historial de búsquedas (orden cronológico)
*/

/*
// % =====================================================
// % TreeMap<K, V>
// % =====================================================
// %
// % Map ordenado AUTOMÁTICAMENTE por la CLAVE
// %
// % Map<Integer, String> notas = new TreeMap<>();
// % notas.put(3, "Tres");
// % notas.put(1, "Uno");
// % notas.put(2, "Dos");
// % System.out.println(notas); // {1=Uno, 2=Dos, 3=Tres}
// %
// % // Con Comparator personalizado:
// % Map<String, Object> persona = new TreeMap<>(
// %     Comparator.comparing(String::length).reversed()
// % );
*/

/*
// # Funcionamiento interno:
// # - Árbol Red-Black balanceado
// # - Ordenamiento basado en las CLAVES
// # - Complejidad O(log n)
// #
// # Requiere claves comparables:
// # - Implementan Comparable<T>
// # - O proveer Comparator al constructor
*/

/*
// ! Restricción importante de TreeMap:
// ! NO permite claves null (lanza NullPointerException)
// !
// ! Map<String, Object> mapa = new TreeMap<>();
// ! mapa.put(null, "valor"); // ERROR! NullPointerException
// !
// ! Razón: TreeMap necesita comparar claves
// ! null.compareTo(otra) causaría error
// !
// ! HashMap sí permite null porque usa posición especial
*/

/*
// $ =====================================================
// $ COMPARABLE vs COMPARATOR
// $ =====================================================
// $
// $ Comparable<T> - Orden NATURAL de la clase
// $ - Se implementa EN la clase misma
// $ - Método: int compareTo(T otro)
// $ - Define UNA única forma de ordenar
// $
// $ Comparator<T> - Orden PERSONALIZADO
// $ - Se define FUERA de la clase
// $ - Método: int compare(T o1, T o2)
// $ - Permite MÚLTIPLES formas de ordenar
// $
// % Ejemplo Comparable:
// % public class Alumno implements Comparable<Alumno> {
// %     @Override
// %     public int compareTo(Alumno otro) {
// %         return this.nombre.compareTo(otro.nombre);
// %     }
// % }
// % // Usar:
// % Collections.sort(listaAlumnos); // Ordena por nombre
// %
// % Ejemplo Comparator:
// % Comparator<Alumno> porNota = (a1, a2) ->
// %     a1.getNota().compareTo(a2.getNota());
// %
// % Collections.sort(listaAlumnos, porNota); // Ordena por nota
// %
// % // Java 8+ con método reference:
// % listaAlumnos.sort(Comparator.comparing(Alumno::getNombre));
// % listaAlumnos.sort(Comparator.comparing(Alumno::getNota).reversed());
*/

/*
// # Valores de retorno de compareTo() y compare():
// #
// # • Retornar NEGATIVO (-1): this < otro (o1 < o2)
// # • Retornar CERO (0):      this == otro (o1 == o2)
// # • Retornar POSITIVO (+1): this > otro (o1 > o2)
// #
// # Ejemplo:
// # public int compareTo(Alumno otro) {
// #     if(this.nota < otro.nota) return -1;
// #     if(this.nota > otro.nota) return 1;
// #     return 0;
// # }
// #
// # Forma simplificada (para Comparable como Double):
// # return this.nota.compareTo(otro.nota);
*/

/*
// * Comparator con múltiples criterios:
// *
// * // Ordenar por nota (descendente), luego por nombre
// * Comparator<Alumno> comparador = Comparator
// *     .comparing(Alumno::getNota).reversed()
// *     .thenComparing(Alumno::getNombre);
// *
// * listaAlumnos.sort(comparador);
*/

/*
// $ =====================================================
// $ COLLECTIONS (CLASE UTILITARIA)
// $ =====================================================
// $
// $ Clase con métodos estáticos útiles para colecciones
// $
// $ Métodos principales:
// $ • Collections.sort(List)              - Ordenar lista
// $ • Collections.sort(List, Comparator)  - Ordenar con criterio
// $ • Collections.reverse(List)           - Invertir orden
// $ • Collections.shuffle(List)           - Mezclar aleatoriamente
// $ • Collections.max(Collection)         - Elemento máximo
// $ • Collections.min(Collection)         - Elemento mínimo
// $ • Collections.frequency(Collection, Object) - Contar ocurrencias
// $ • Collections.addAll(Collection, elementos...) - Agregar varios
// $
// % Ejemplo:
// % List<Integer> nums = new ArrayList<>(Arrays.asList(3,1,4,1,5));
// % Collections.sort(nums);        // [1, 1, 3, 4, 5]
// % Collections.reverse(nums);     // [5, 4, 3, 1, 1]
// % int freq = Collections.frequency(nums, 1); // 2
*/

/*
// $ =====================================================
// $ CONVERSIÓN ENTRE TIPOS
// $ =====================================================
// $
// $ Collection a Array:
// $ List<String> lista = new ArrayList<>();
// $ Object[] array = lista.toArray();
// $ String[] arrayTipado = lista.toArray(new String[0]);
// $
// $ Array a List:
// $ String[] array = {"a", "b", "c"};
// $ List<String> lista = Arrays.asList(array); // TAMAÑO FIJO
// $ List<String> lista = new ArrayList<>(Arrays.asList(array)); // MODIFICABLE
// $
// $ List a Set (eliminar duplicados):
// $ List<String> lista = Arrays.asList("a", "b", "a", "c");
// $ Set<String> sinDuplicados = new HashSet<>(lista);
// $ // sinDuplicados = [a, b, c]
// $
// $ Map.values() a List:
// $ Map<String, Integer> mapa = new HashMap<>();
// $ List<Integer> valores = new ArrayList<>(mapa.values());
// $
// $ Map.keySet() a List:
// $ List<String> claves = new ArrayList<>(mapa.keySet());
*/

/*
// $ =====================================================
// $ EQUALS() Y HASHCODE() - CONTRATO
// $ =====================================================
// $
// $ REGLA DE ORO:
// $ Si sobrescribes equals(), DEBES sobrescribir hashCode()
// $
// $ Contrato equals():
// $ • Reflexivo: x.equals(x) debe ser true
// $ • Simétrico: x.equals(y) == y.equals(x)
// $ • Transitivo: si x.equals(y) y y.equals(z), entonces x.equals(z)
// $ • Consistente: múltiples llamadas retornan el mismo valor
// $ • x.equals(null) debe ser false
// $
// $ Contrato hashCode():
// $ • Si x.equals(y) es true, x.hashCode() == y.hashCode()
// $ • Si x.equals(y) es false, hashCode() PUEDE ser igual o diferente
// $ • Debe ser consistente (mismo objeto, mismo hash)
// $
// ! VIOLACIÓN DEL CONTRATO:
// ! Si dos objetos son equals() pero tienen diferente hashCode()
// ! HashMap/HashSet NO funcionarán correctamente
// !
// ! Ejemplo del problema:
// ! Set<Alumno> set = new HashSet<>();
// ! set.add(new Alumno("Pepe", 4.0));
// ! set.contains(new Alumno("Pepe", 4.0)); // FALSE!
// !
// ! Aunque equals() retorne true, si hashCode() es diferente,
// ! HashSet los busca en diferentes posiciones de la tabla hash
*/

/*
// * Implementación correcta de equals() y hashCode():
// *
// * @Override
// * public boolean equals(Object o) {
// *     // 1. Comparar referencias (optimización)
// *     if(this == o) return true;
// *
// *     // 2. Verificar null y clase
// *     if(o == null || getClass() != o.getClass()) return false;
// *
// *     // 3. Castear y comparar campos
// *     Alumno alumno = (Alumno) o;
// *     return Objects.equals(nombre, alumno.nombre) &&
// *            Objects.equals(nota, alumno.nota);
// * }
// *
// * @Override
// * public int hashCode() {
// *     return Objects.hash(nombre, nota);
// * }
// *
// * // Objects.hash() combina los hash de todos los campos
// * // Usa el mismo algoritmo que HashMap internamente
*/

/*
// $ =====================================================
// $ RESUMEN Y GUÍA DE DECISIÓN
// $ =====================================================
// $
// $ ¿Qué estructura usar?
// $
// $ Necesitas LISTA (orden y duplicados permitidos):
// $ ├─ Acceso frecuente por índice → ArrayList
// $ ├─ Inserciones/eliminaciones frecuentes → LinkedList
// $ └─ Cola (FIFO) o Pila (LIFO) → LinkedList
// $
// $ Necesitas CONJUNTO (sin duplicados):
// $ ├─ Máxima velocidad → HashSet
// $ ├─ Mantener orden de inserción → LinkedHashSet
// $ └─ Orden automático → TreeSet
// $
// $ Necesitas MAPA (clave-valor):
// $ ├─ Máxima velocidad → HashMap
// $ ├─ Mantener orden de inserción → LinkedHashMap
// $ └─ Orden automático por clave → TreeMap
// $
// $ Tabla comparativa:
// $
// $ | Estructura      | Duplicados | Orden          | Null   | Velocidad |
// $ |-----------------|------------|----------------|--------|-----------|
// $ | ArrayList       | Sí         | Inserción      | Sí     | O(1) get  |
// $ | LinkedList      | Sí         | Inserción      | Sí     | O(n) get  |
// $ | HashSet         | No         | Sin orden      | Sí     | O(1)      |
// $ | LinkedHashSet   | No         | Inserción      | Sí     | O(1)      |
// $ | TreeSet         | No         | Ordenado       | No     | O(log n)  |
// $ | HashMap         | Valores Sí | Sin orden      | Sí     | O(1)      |
// $ | LinkedHashMap   | Valores Sí | Inserción      | Sí     | O(1)      |
// $ | TreeMap         | Valores Sí | Ordenado       | No     | O(log n)  |
*/

/*
// ? =====================================================
// ? PREGUNTAS TÍPICAS DE EXAMEN
// ? =====================================================
// ?
// ? 1. ¿Cuál ordena automáticamente?
// ?    → TreeSet / TreeMap
// ?
// ? 2. ¿Cuál usa hashCode() y equals()?
// ?    → HashSet / HashMap / LinkedHashSet / LinkedHashMap
// ?
// ? 3. ¿Cuál permite claves null?
// ?    → HashMap: una clave null
// ?    → TreeMap: ninguna clave null (NullPointerException)
// ?
// ? 4. ¿Cuál es más rápido para búsquedas?
// ?    → HashMap/HashSet O(1)
// ?    → TreeMap/TreeSet O(log n)
// ?    → ArrayList O(n)
// ?
// ? 5. ¿Cuándo usar ArrayList vs LinkedList?
// ?    → ArrayList: lectura frecuente
// ?    → LinkedList: inserción/eliminación frecuente
// ?
// ? 6. ¿Qué pasa si no sobrescribes hashCode()?
// ?    → HashSet/HashMap no detectarán duplicados correctamente
// ?
// ? 7. ¿Por qué Map no hereda de Collection?
// ?    → Porque almacena pares, no elementos individuales
// ?
// ? 8. ¿Qué retorna compareTo() para indicar igualdad?
// ?    → 0 (cero)
// ?
// ? 9. ¿Diferencia entre Iterator y ListIterator?
// ?    → Iterator: solo adelante, cualquier Collection
// ?    → ListIterator: bidireccional, solo List
// ?
// ? 10. ¿Cómo iterar un Map?
// ?     → keySet() - solo claves
// ?     → values() - solo valores
// ?     → entrySet() - pares clave-valor (recomendado)
*/

/*
// * =====================================================
// * BUENAS PRÁCTICAS GENERALES
// * =====================================================
// *
// * 1. Programa hacia la interfaz, no la implementación:
// *    List<String> lista = new ArrayList<>();  // BIEN
// *    ArrayList<String> lista = new ArrayList<>(); // EVITAR
// *
// * 2. Especifica capacidad inicial si conoces el tamaño:
// *    List<String> lista = new ArrayList<>(1000);
// *    // Evita redimensionamientos costosos
// *
// * 3. Usa forEach de Java 8+ cuando sea apropiado:
// *    lista.forEach(System.out::println);
// *    mapa.forEach((k, v) -> System.out.println(k + "=" + v));
// *
// * 4. Para clases personalizadas en Set/Map:
// *    - Siempre sobrescribe equals() y hashCode()
// *    - Usa Objects.equals() y Objects.hash()
// *
// * 5. Para ordenamiento:
// *    - Si hay UN orden natural: implementa Comparable
// *    - Si hay MÚLTIPLES formas de ordenar: usa Comparator
// *
// * 6. Evita modificar claves de Map después de insertarlas
// *
// * 7. Prefiere ArrayList sobre LinkedList (95% casos)
// *
// * 8. Usa TreeSet/TreeMap solo si necesitas orden automático
// *
// * 9. No uses == para comparar objetos, usa equals()
// *
// * 10. Maneja null con cuidado:
// *     - TreeSet/TreeMap no aceptan null
// *     - Usa getOrDefault() en Map para evitar null
*/

/*
// ! =====================================================
// ! ERRORES COMUNES A EVITAR
// ! =====================================================
// !
// ! 1. No sobrescribir equals() y hashCode()
// !    → Set/Map no funcionarán correctamente
// !
// ! 2. Modificar objetos después de agregarlos a Set/Map
// !    → No se encontrarán por cambio en hashCode()
// !
// ! 3. Usar == en lugar de equals() para comparar
// !    → Compara referencias, no contenido
// !
// ! 4. Olvidar que remove() de Iterator es seguro
// !    → Nunca usar lista.remove() dentro de for-each
// !
// ! 5. Usar get() con índices en LinkedList frecuentemente
// !    → Rendimiento pésimo O(n)
// !
// ! 6. Asumir que HashSet mantiene orden
// !    → No hay garantía de orden
// !
// ! 7. Poner null en TreeSet/TreeMap
// !    → NullPointerException
// !
// ! 8. Comparar solo un campo en compareTo() con TreeSet
// !    → Elementos con mismo valor se consideran duplicados
// !
// ! 9. No manejar ConcurrentModificationException
// !    → Al modificar colección durante iteración
// !
// ! 10. Usar Arrays.asList() y pensar que es modificable
// !     → Retorna lista de TAMAÑO FIJO
*/

/*
// # =====================================================
// # COMPLEJIDAD TEMPORAL (BIG O)
// # =====================================================
// #
// # ArrayList:
// # - get(index)           O(1)
// # - add(elemento)        O(1) amortizado
// # - add(index, elemento) O(n)
// # - remove(index)        O(n)
// # - contains(elemento)   O(n)
// #
// # LinkedList:
// # - get(index)           O(n)
// # - addFirst/addLast     O(1)
// # - removeFirst/Last     O(1)
// # - add(index, elemento) O(n)
// # - contains(elemento)   O(n)
// #
// # HashSet/HashMap:
// # - add/put              O(1)
// # - remove               O(1)
// # - contains/get         O(1)
// # - (Peor caso con colisiones: O(n))
// #
// # TreeSet/TreeMap:
// # - add/put              O(log n)
// # - remove               O(log n)
// # - contains/get         O(log n)
// #
// # Conclusión:
// # - Hash: Más rápido (si no necesitas orden)
// # - Tree: Ordenado automáticamente (más lento)
// # - ArrayList: Mejor para lectura
// # - LinkedList: Mejor para modificaciones al inicio/fin
*/

}