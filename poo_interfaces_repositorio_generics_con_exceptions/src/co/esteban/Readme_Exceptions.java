

public class Readme_Exceptions {
/*
 // $ (Rosa)        -> Conceptos base / definiciones importantes
 // ! (Rojo)        -> Advertencias / errores comunes
 // ? (Azul)        -> Preguntas clave para reflexionar
 // * (Verde)       -> Buenas prácticas
 // % (Amarillo)    -> Ejemplos y relaciones con tu código
 // # (Naranja)     -> Detalles técnicos internos de Java
*/

/*
 // $ ==============================
 // $ ¿QUÉ SON LAS EXCEPCIONES?
 // $ ==============================
 // $ Una excepción en Java es un evento que ocurre durante la ejecución
 // $ del programa y que interrumpe el flujo normal de la aplicación.
 // $
 // $ Las excepciones permiten manejar errores de forma controlada,
 // $ evitando que el programa termine abruptamente.
*/

/*
 // $ ==============================
 // $ JERARQUÍA DE EXCEPCIONES EN JAVA
 // $ ==============================
 // $
 // $              Object
 // $                 |
 // $             Throwable
 // $              /      \
 // $           Error   Exception
 // $
 // $ Toda excepción o error en Java SE DESPRENDE de la clase Throwable.
*/

/*
 // # ==============================
 // # CLASE Throwable
 // # ==============================
 // # Es la superclase de todos los errores y excepciones en Java.
 // # Proporciona métodos importantes como:
 // # - getMessage()
 // # - printStackTrace()
 // # - getCause()
 // #
 // # Solo los objetos que heredan de Throwable pueden ser lanzados con "throw".
*/

/*
 // ! ==============================
 // ! CLASE Error
 // ! ==============================
 // ! Representa errores graves del sistema.
 // !
 // ! Normalmente NO se manejan con try-catch.
 // !
 // ! Ejemplos:
 // ! - OutOfMemoryError
 // ! - StackOverflowError
 // !
 // ! Son problemas que el programa NO debería intentar recuperar.
*/

/*
 // $ ==============================
 // $ CLASE Exception
 // $ ==============================
 // $ Representa condiciones que una aplicación SÍ puede manejar.
 // $
 // $ Aquí es donde entran tus excepciones personalizadas:
 // $ - DivisionPorCeroException
 // $ - FormatoNumeroException
*/

/*
 // $ ==============================
 // $ CHECKED vs UNCHECKED EXCEPTIONS
 // $ ==============================
*/

/*
 // $ CHECKED EXCEPTIONS
 // $
 // $ - Heredan de Exception
 // $ - NO heredan de RuntimeException
 // $ - El compilador OBLIGA a manejarlas
 // $
 // $ Se deben:
 // $ 1. Capturar con try-catch
 // $ 2. O declarar con throws
 // $
 // % En tu código:
 // % DivisionPorCeroException
 // % FormatoNumeroException
 // %
 // % Ambas son CHECKED porque extienden directamente de Exception
*/

/*
 // $ UNCHECKED EXCEPTIONS
 // $
 // $ - Heredan de RuntimeException
 // $ - NO es obligatorio capturarlas
 // $
 // $ Ejemplos:
 // $ - NullPointerException
 // $ - ArithmeticException
 // $ - NumberFormatException
 // $
 // % En tu código:
 // % NumberFormatException aparece al convertir String a int
 // % pero tú la CAPTURAS y la CONVIERTES en una excepción propia
*/

/*
 // * ===========================================
 // * ¿POR QUÉ CREAR EXCEPCIONES PERSONALIZADAS?
 // * ===========================================
 // *
 // * - Hacen el código más legible
 // * - Expresan mejor el error del dominio del problema
 // * - Evitan mostrar mensajes técnicos al usuario
 // *
 // % Ejemplo:
 // % "No se puede dividir por cero"
 // % es más claro que un ArithmeticException genérico
*/

/*
 // % ==============================
 // % DivisionPorCeroException
 // % ==============================
 // %
 // % public class DivisionPorCeroException extends Exception
 // %
 // % - Extiende Exception → CHECKED
 // % - Usa super(mensaje) para pasar el mensaje a Throwable
 // % - Se lanza manualmente con throw
*/

/*
 // % ==============================
 // % FormatoNumeroException
 // % ==============================
 // %
 // % Se lanza cuando el usuario no ingresa números válidos
 // % Reemplaza el NumberFormatException por una excepción más clara
*/

/*
 // $ ==============================
 // $ throw vs throws
 // $ ==============================
*/

/*
 // $ throw
 // $
 // $ - Se usa para LANZAR una excepción
 // $
 // % Ejemplo en tu código:
 // % throw new DivisionPorCeroException("No se puede dividir por cero!");
*/

/*
 // $ throws
 // $
 // $ - Se usa en la firma del método
 // $ - Indica que el método PUEDE lanzar una excepción
 // $ - Delegas la responsabilidad al método que lo llama
 // $
 // % Ejemplo:
 // % public double dividir(int n, int d) throws DivisionPorCeroException
*/

/*
 // $ ==============================
 // $ try - catch - finally
 // $ ==============================
*/

/*
 // $ try
 // $
 // $ Contiene el código que puede generar una excepción
*/

/*
 // $ catch
 // $
 // $ Captura la excepción y permite manejarla
 // $ Puedes tener múltiples catch
 // $
 // ! El orden importa:
 // ! Se debe capturar primero la excepción MÁS ESPECÍFICA
*/

/*
 // $ finally
 // $
 // $ - Se ejecuta SIEMPRE
 // $ - Haya o no excepción
 // $
 // % Ideal para cerrar recursos (archivos, conexiones, etc.)
*/

/*
 // ? ==============================
 // ? FLUJO DE EJECUCIÓN
 // ? ==============================
 // ?
 // ? 1. Se ejecuta el try
 // ? 2. Si ocurre excepción → se salta al catch correspondiente
 // ? 3. Se ejecuta finally
 // ? 4. El programa CONTINÚA su ejecución
*/

/*
 // * ==============================
 // * BUENAS PRÁCTICAS
 // * ==============================
 // *
 // * - No capturar Exception genérico si no es necesario
 // * - Usar mensajes claros
 // * - Crear excepciones personalizadas
 // * - No abusar de try-catch para control de flujo
*/

/*
 // $ ==============================
 // $ CONCLUSIÓN
 // $ ==============================
 // $
 // $ Las excepciones:
 // $ - Se desprenden de Throwable
 // $ - Se dividen en Error y Exception
 // $ - Pueden ser CHECKED o UNCHECKED
 // $ - Permiten manejar errores sin romper el programa
 // $
 // $ Tu ejemplo de Calculadora es un CASO IDEAL de uso correcto
 // $ de excepciones personalizadas y manejo de errores.
*/

}
