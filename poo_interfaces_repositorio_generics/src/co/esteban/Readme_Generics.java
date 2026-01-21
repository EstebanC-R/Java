package co.esteban;

public class Readme_Generics {
    // =====================================================================================
// $ ========================== MODELO MENTAL BASE ==========================
// =====================================================================================
//
// * ANTES DE PENSAR EN CÓDIGO, PIENSA ESTO:
//
// % Un genérico es una PROMESA de tipo.
//
// ? List<Electronico2>
//     → Prometo que SOLO habrá Electronico2
//
// ? List<Ropa2>
//     → Prometo que SOLO habrá Ropa2
//
// ? List<? extends Articulo2>
//     → Prometo que habrá ALGO que hereda de Articulo2
//       PERO NO te digo qué exactamente
//
// ! Ese “NO te digo qué exactamente” es LA CLAVE de TODO.
// ! Si no sabes exactamente qué tipo hay dentro,
// ! entonces NO puedes meter nada nuevo.
//
// =====================================================================================



// =====================================================================================
// $ ========================== ¿QUÉ SIGNIFICA ? extends ==========================
// =====================================================================================
//
// * ¿Qué significa realmente esto?
//
// ? List<? extends Articulo2> lista;
//
// % Significado CORRECTO:
// # lista apunta a una lista cuyo TIPO INTERNO EXACTO NO CONOZCO,
// # solo sé que hereda de Articulo2.
//
// % Puede ser:
// # - List<Electronico2>
// # - List<Ropa2>
// # - List<Libro2>
//
// ! OJO: tú NO decides cuál es.
// ! Eso lo decide quien LLAMA al método.
//
// =====================================================================================



// =====================================================================================
// $ ========== ¿POR QUÉ NO PUEDO HACER lista.add(new Electronico2())? ==========
// =====================================================================================
//
// * Esta es LA pregunta más importante.
//
// ? ¿Por qué Java NO permite esto?
//
// ! lista.add(new Electronico2(...));  // ❌
//
// % RESPUESTA:
// # Porque Java NO SABE qué subtipo real contiene la lista.
//
// public static void imprimir(List<? extends Articulo2> lista) {
//
//        for (Articulo2 art : lista) {
//            System.out.println("Nombre: " + art.getNombre());
//            System.out.println("Precio: " + art.getPrecio());
//            System.out.println("----------------------");
//        }
// }
//
// # Sería ilógico, NO tiene sentido por lo mismo de que NO SÉ QUÉ ES LO QUE ESTOY REFERENCIANDO
// # por ello directamente es mejor no hacerlo.
//
// -------------------------------------------------------------------------------------
// * EJEMPLO REAL DEL PROBLEMA (léelo despacio)
//
// % List<Ropa2> ropa = new ArrayList<>();
// % List<? extends Articulo2> lista = ropa; ✅ Esto está permitido!
//
// ! Ahora intenta esto:
//
// % lista.add(new Electronico2(...));  // ❌
//
// * ¿Qué pasó?
// # Metiste un Electronico2 dentro de una lista que en realidad es de Ropa2.
//
// ! Eso rompe la promesa original:
// ! List<Ropa2> → “solo habrá ropa”
//
// % Por eso el COMPILADOR lo prohíbe.
// % Prefiere fallar antes que romper la seguridad de tipos.
//
// =====================================================================================



// =====================================================================================
// $ ========================== ¿POR QUÉ SÍ PUEDO LEER? ==========================
// =====================================================================================
//
// * Entonces… ¿por qué ESTO sí funciona?
//
// % for (Articulo2 art : lista) {
// %     art.getNombre();
// %     art.getPrecio();
// % }
//
// % Porque TODOS los posibles tipos que puede haber dentro:
// # - Electronico2
// # - Ropa2
// # - Libro2
//
// * TODOS son Articulo2.
//
// ? Leer como Articulo2 es 100 % seguro.
// ! Escribir NO lo es.
//
// =====================================================================================



// =====================================================================================
// $ ========================== REGLA DE ORO (MEMORIZAR) ==========================
// =====================================================================================
//
// ! ? extends X
// ! ✔️ PUEDES LEER como X
// ! ❌ NO PUEDES ESCRIBIR X ni subclases, ME REFIERO A:
// !
// ! lista.add(...)
// ! lista.addAll(...)
// ! lista.set(0, ...)
//
//
// % Si NO sabes qué tipo exacto hay dentro,
// % NO puedes meter nada.
//
// =====================================================================================



// =====================================================================================
// $ ========================== DIFERENCIA CON T extends ==========================
// =====================================================================================
//
// * ¿Por qué con T extends Articulo2 SÍ puedo agregar?
//
// % class Inventario<T extends Articulo2> { }
//
// % Cuando haces:
// ? Inventario<Ropa2> inv = new Inventario<>();
//
// # Java YA SABE que:
// # T == Ropa2
//
// * Entonces esto es seguro:
//
// % inv.add(new Ropa2(...));  // ✔️
//
// ! Aquí NO hay incertidumbre.
// ! El tipo está totalmente definido.
//
// =====================================================================================



// =====================================================================================
// $ ========================== COMPARACIÓN FINAL ==========================
// =====================================================================================
//
// ? "T" extends Articulo2
// % - La CLASE controla el tipo -----> básicamente porque debe de ser hijo
// % - El tipo se fija al crear el objeto -----> se reconoce cual es el objeto, como por ejemplo "Ropa"
// % - Puedes LEER y ESCRIBIR ----> porque reconoce que este es "Ropa"
//
// ? "?" extends Articulo2
// % - El MÉTODO recibe el tipo ------> Recibe cualquier clase que extienda de una clase concreta como "Mueble".
// % - El tipo es DESCONOCIDO ------> pero no sabe cual subtipo va a ser, puede ser "Mesa" o "Silla", pero en realidad no sabe cual
// % - SOLO puedes LEER ---------> Al no saber prefiere no suponer y directamente no deja agregar nada ya que no sabe que tipo esta recibiendo
//
// -------------------------------------------------------------------------------------
// * Tabla mental:
//
// % T extends ClaseX
// # ✔️ leer
// # ✔️ escribir
//
// % ? extends ClaseX
// # ✔️ leer
// # ❌ escribir
//
// =====================================================================================



// =====================================================================================
// $ ========================== FRASE FINAL (NUNCA FALLA) ==========================
// =====================================================================================
//
// ! SI NO SABES QUÉ TIPO HAY DENTRO,
// ! NO PUEDES METER NADA.
//
// * Eso es TODO ? extends.
//
// =====================================================================================

}
