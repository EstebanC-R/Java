package co.esteban.hilos;

public class Readme_Executors {

/*
|--------------------------------------------------------------------------
|  GUÍA DEFINITIVA SUPREMA - EXECUTORS, THREADS Y CONCURRENCIA EN JAVA
|--------------------------------------------------------------------------
|  Colores de comentarios:
    // ? Azul     -> Conceptos fundamentales / ¿Qué es?
    // ! Rojo     -> Advertencias / Errores comunes / IMPORTANTE
    // % Amarillo -> Diferencias / Comparaciones
    // # Naranja  -> Detalles técnicos / Cómo funciona internamente
    // * Verde    -> Buenas prácticas / Recomendaciones
    // $ Rosa     -> Ejemplos de código / Tips rápidos
|--------------------------------------------------------------------------
*/


    // ============================================================
    // 1. THREAD vs RUNNABLE - FUNDAMENTOS
    // ============================================================

    // ? Thread: representa un hilo de ejecución en Java.
    // ? Dos formas de crear hilos:
    // ?   1. Extendiendo la clase Thread
    // ?   2. Implementando la interfaz Runnable (RECOMENDADO)

    // % Extender Thread:
    // % - Limita herencia (Java solo permite heredar de UNA clase)
    // % - Acopla la tarea al hilo
    // % - Menos flexible

    // % Implementar Runnable:
    // % - Permite heredar de otra clase simultáneamente
    // % - Separa la lógica de la tarea del mecanismo del hilo
    // % - Más reutilizable y flexible

    // ! NUNCA llamar directamente al método run()
    // ! SIEMPRE usar start() que crea el nuevo hilo

    // # Flujo interno: start() → JVM crea hilo → ejecuta run()

    // * Preferir SIEMPRE Runnable sobre extender Thread

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 1: Extendiendo Thread (NO RECOMENDADO)
    // $ ════════════════════════════════════════════════════════
    // $ class MiHilo extends Thread {
    // $     @Override
    // $     public void run() {
    // $         for (int i = 0; i < 5; i++) {
    // $             System.out.println("Hilo: " + i);
    // $         }
    // $     }
    // $ }
    // $
    // $ // Uso:
    // $ MiHilo hilo = new MiHilo();
    // $ hilo.start(); // ✅ Correcto
    // $ hilo.run();   // ❌ MAL - ejecuta en el hilo actual, no crea nuevo hilo

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 2: Implementando Runnable (RECOMENDADO)
    // $ ════════════════════════════════════════════════════════
    // $ class MiTarea implements Runnable {
    // $     @Override
    // $     public void run() {
    // $         for (int i = 0; i < 5; i++) {
    // $             System.out.println("Tarea: " + i);
    // $         }
    // $     }
    // $ }
    // $
    // $ // Uso:
    // $ Thread hilo = new Thread(new MiTarea());
    // $ hilo.start();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 3: Con Lambda (Java 8+) - MÁS LIMPIO
    // $ ════════════════════════════════════════════════════════
    // $ Runnable tarea = () -> {
    // $     for (int i = 0; i < 5; i++) {
    // $         System.out.println(Thread.currentThread().getName() + ": " + i);
    // $     }
    // $ };
    // $
    // $ Thread hilo1 = new Thread(tarea, "Hilo-1");
    // $ Thread hilo2 = new Thread(tarea, "Hilo-2");
    // $ hilo1.start();
    // $ hilo2.start();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 4: Forma ultra-compacta
    // $ ════════════════════════════════════════════════════════
    // $ new Thread(() -> System.out.println("Hola desde hilo"), "MiHilo").start();


    // ============================================================
    // 2. MÉTODOS CLAVE: SLEEP Y JOIN
    // ============================================================

    // ? Thread.sleep(milisegundos):
    // ? - Pausa la ejecución del hilo actual
    // ? - Puede lanzar InterruptedException

    // ! Thread.sleep() es un método ESTÁTICO
    // ! Duerme el hilo ACTUAL, NO el objeto Thread sobre el que se llama

    // ? thread.join():
    // ? - Método de INSTANCIA (no estático)
    // ? - Hace que el hilo actual espere a que "thread" termine
    // ? - Útil para asegurar orden de ejecución

    // * Usar join() cuando el hilo principal depende del resultado de otros hilos

    // % Estados de un Thread:
    // % NEW → RUNNABLE → RUNNING → (BLOCKED/WAITING) → TERMINATED
    // % Consultar con: thread.getState()

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 5: Thread.sleep() - Método ESTÁTICO
    // $ ════════════════════════════════════════════════════════
    // $ Thread hilo = new Thread(() -> {
    // $     try {
    // $         System.out.println("Voy a dormir 2 segundos...");
    // $         Thread.sleep(2000); // Duerme EL HILO ACTUAL (este lambda)
    // $         System.out.println("Desperté!");
    // $     } catch (InterruptedException e) {
    // $         e.printStackTrace();
    // $     }
    // $ });
    // $ hilo.start();
    // $
    // $ // ❌ ERROR COMÚN:
    // $ // hilo.sleep(2000); // NO duerme "hilo", duerme el hilo ACTUAL (main)

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 6: join() - Esperar a que termine otro hilo
    // $ ════════════════════════════════════════════════════════
    // $ Thread descargador = new Thread(() -> {
    // $     System.out.println("Descargando archivo...");
    // $     try {
    // $         Thread.sleep(3000); // Simula descarga de 3 seg
    // $     } catch (InterruptedException e) {
    // $         e.printStackTrace();
    // $     }
    // $     System.out.println("Descarga completa!");
    // $ });
    // $
    // $ descargador.start();
    // $ System.out.println("Esperando a que termine la descarga...");
    // $
    // $ try {
    // $     descargador.join(); // Main espera aquí hasta que descargador termine
    // $ } catch (InterruptedException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ System.out.println("Ahora puedo procesar el archivo descargado");

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 7: join() con múltiples hilos
    // $ ════════════════════════════════════════════════════════
    // $ Thread h1 = new Thread(() -> {
    // $     System.out.println("Tarea 1 ejecutándose...");
    // $     try { Thread.sleep(2000); } catch (InterruptedException e) {}
    // $     System.out.println("Tarea 1 terminada");
    // $ });
    // $
    // $ Thread h2 = new Thread(() -> {
    // $     System.out.println("Tarea 2 ejecutándose...");
    // $     try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // $     System.out.println("Tarea 2 terminada");
    // $ });
    // $
    // $ h1.start();
    // $ h2.start();
    // $
    // $ try {
    // $     h1.join(); // Espera h1
    // $     h2.join(); // Espera h2
    // $ } catch (InterruptedException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ System.out.println("Todas las tareas terminaron");

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 8: Estados de un Thread
    // $ ════════════════════════════════════════════════════════
    // $ Thread hilo = new Thread(() -> {
    // $     try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // $ });
    // $
    // $ System.out.println(hilo.getState()); // NEW
    // $ hilo.start();
    // $ System.out.println(hilo.getState()); // RUNNABLE
    // $ Thread.sleep(100);
    // $ System.out.println(hilo.getState()); // TIMED_WAITING (por el sleep)
    // $ hilo.join();
    // $ System.out.println(hilo.getState()); // TERMINATED


    // ============================================================
    // 3. SINCRONIZACIÓN - synchronized
    // ============================================================

    // ? synchronized: evita que múltiples hilos accedan simultáneamente
    // ? al mismo recurso crítico (evita race conditions)

    // % Puede aplicarse a:
    // % 1. Métodos completos: public synchronized void metodo()
    // % 2. Bloques de código: synchronized(objeto) { ... }

    // # Métodos synchronized de INSTANCIA:
    // # - Bloquean el monitor del objeto (this)

    // # Métodos static synchronized:
    // # - Bloquean el monitor de la CLASE, no de instancias
    // # - Dos hilos no pueden ejecutar NINGÚN método static synchronized simultáneamente

    // ! Solo un hilo puede ejecutar código synchronized del mismo objeto a la vez
    // ! Los demás hilos esperan hasta que se libere el bloqueo

    // * Usar synchronized SOLO en la zona crítica (sección mínima necesaria)
    // * Evitar sincronizar métodos completos si no es necesario

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 9: Problema SIN sincronización (Race Condition)
    // $ ════════════════════════════════════════════════════════
    // $ class Contador {
    // $     private int valor = 0;
    // $
    // $     public void incrementar() {
    // $         valor++; // ❌ NO es atómico: lee, incrementa, escribe
    // $     }
    // $
    // $     public int getValor() {
    // $         return valor;
    // $     }
    // $ }
    // $
    // $ Contador contador = new Contador();
    // $
    // $ // Creamos 1000 hilos que incrementan
    // $ for (int i = 0; i < 1000; i++) {
    // $     new Thread(() -> contador.incrementar()).start();
    // $ }
    // $
    // $ Thread.sleep(2000);
    // $ System.out.println(contador.getValor()); // ❌ NO será 1000 (race condition)

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 10: SOLUCIÓN con synchronized en método
    // $ ════════════════════════════════════════════════════════
    // $ class ContadorSeguro {
    // $     private int valor = 0;
    // $
    // $     public synchronized void incrementar() {
    // $         valor++; // ✅ Ahora es thread-safe
    // $     }
    // $
    // $     public synchronized int getValor() {
    // $         return valor;
    // $     }
    // $ }
    // $
    // $ ContadorSeguro contador = new ContadorSeguro();
    // $
    // $ for (int i = 0; i < 1000; i++) {
    // $     new Thread(() -> contador.incrementar()).start();
    // $ }
    // $
    // $ Thread.sleep(2000);
    // $ System.out.println(contador.getValor()); // ✅ Será exactamente 1000

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 11: synchronized en bloque (más eficiente)
    // $ ════════════════════════════════════════════════════════
    // $ class ContadorOptimizado {
    // $     private int valor = 0;
    // $     private final Object lock = new Object();
    // $
    // $     public void incrementar() {
    // $         // Código no crítico aquí (sin lock)
    // $         System.out.println("Preparando incremento...");
    // $
    // $         synchronized(lock) { // Solo la zona crítica
    // $             valor++;
    // $         }
    // $
    // $         // Más código no crítico (sin lock)
    // $         System.out.println("Incremento completo");
    // $     }
    // $ }

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 12: synchronized static (bloquea la CLASE)
    // $ ════════════════════════════════════════════════════════
    // $ class Configuracion {
    // $     private static int instancias = 0;
    // $
    // $     public static synchronized void incrementarInstancias() {
    // $         instancias++; // Bloquea la clase Configuracion
    // $     }
    // $
    // $     public static synchronized int getInstancias() {
    // $         return instancias;
    // $     }
    // $ }
    // $
    // $ // Múltiples hilos accediendo
    // $ for (int i = 0; i < 100; i++) {
    // $     new Thread(() -> Configuracion.incrementarInstancias()).start();
    // $ }


    // ============================================================
    // 4. WAIT / NOTIFY - PATRÓN PRODUCTOR-CONSUMIDOR
    // ============================================================

    // ? wait():
    // ? - Libera el monitor del objeto
    // ? - Suspende el hilo hasta recibir notify() o notifyAll()
    // ? - Debe estar en bloque synchronized

    // ? notify():
    // ? - Despierta UN hilo que esté esperando (aleatorio)

    // ? notifyAll():
    // ? - Despierta TODOS los hilos en espera

    // ! wait(), notify() y notifyAll() SOLO pueden llamarse dentro de synchronized
    // ! Si no, lanza IllegalMonitorStateException

    // # SIEMPRE usar wait() dentro de un bucle while, NUNCA con if
    // # Razón: evita "spurious wakeups" (despertares espurios)

    // * Patrón Productor-Consumidor clásico:
    // * - Productor: produce datos → notify() → wait() si está lleno
    // * - Consumidor: consume datos → notify() → wait() si está vacío
    // * - Variable booleana para controlar disponibilidad

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 13: Productor-Consumidor COMPLETO
    // $ ════════════════════════════════════════════════════════
    // $ class Almacen {
    // $     private String producto;
    // $     private boolean disponible = false;
    // $
    // $     public synchronized void producir(String nuevoProducto) {
    // $         // Espera mientras haya producto disponible
    // $         while (disponible) {
    // $             try {
    // $                 wait(); // Libera el lock y espera
    // $             } catch (InterruptedException e) {
    // $                 e.printStackTrace();
    // $             }
    // $         }
    // $
    // $         // Produce
    // $         this.producto = nuevoProducto;
    // $         System.out.println("Producido: " + producto);
    // $         disponible = true;
    // $         notify(); // Despierta al consumidor
    // $     }
    // $
    // $     public synchronized String consumir() {
    // $         // Espera mientras NO haya producto
    // $         while (!disponible) {
    // $             try {
    // $                 wait();
    // $             } catch (InterruptedException e) {
    // $                 e.printStackTrace();
    // $             }
    // $         }
    // $
    // $         // Consume
    // $         System.out.println("Consumido: " + producto);
    // $         disponible = false;
    // $         notify(); // Despierta al productor
    // $         return producto;
    // $     }
    // $ }
    // $
    // $ // Uso:
    // $ Almacen almacen = new Almacen();
    // $
    // $ // Hilo Productor
    // $ new Thread(() -> {
    // $     for (int i = 1; i <= 5; i++) {
    // $         almacen.producir("Producto-" + i);
    // $         try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // $     }
    // $ }).start();
    // $
    // $ // Hilo Consumidor
    // $ new Thread(() -> {
    // $     for (int i = 1; i <= 5; i++) {
    // $         almacen.consumir();
    // $         try { Thread.sleep(1500); } catch (InterruptedException e) {}
    // $     }
    // $ }).start();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 14: ¿Por qué while y no if?
    // $ ════════════════════════════════════════════════════════
    // $ // ❌ MAL - con if:
    // $ public synchronized void consumir() {
    // $     if (!disponible) {
    // $         wait(); // Si hay spurious wakeup, NO vuelve a verificar
    // $     }
    // $     // Puede ejecutarse aunque disponible sea false!
    // $ }
    // $
    // $ // ✅ BIEN - con while:
    // $ public synchronized void consumir() {
    // $     while (!disponible) {
    // $         wait(); // Si hay spurious wakeup, vuelve a verificar la condición
    // $     }
    // $     // Solo ejecuta si disponible == true
    // $ }


    // ============================================================
    // 5. TIMER vs SCHEDULED EXECUTOR
    // ============================================================

    // ? Timer (clase legacy - NO recomendada):
    // ? - Usa UN SOLO hilo para todas las tareas
    // ? - Si una tarea falla, TODO el Timer muere
    // ? - No maneja bien excepciones

    // ! Timer NO es robusto para producción
    // ! Una sola excepción no capturada termina el Timer completo

    // ? ScheduledExecutorService (RECOMENDADO):
    // ? - Usa pool de hilos configurable
    // ? - Tareas independientes entre sí
    // ? - Manejo robusto de errores (una tarea fallida no afecta otras)

    // % schedule(tarea, delay, unidad):
    // % - Ejecuta UNA sola vez después del delay

    // % scheduleAtFixedRate(tarea, initialDelay, period, unidad):
    // % - Ejecuta periódicamente
    // % - El periodo se calcula desde el INICIO de cada ejecución
    // % - Si tarea tarda más que el periodo, la siguiente espera

    // % scheduleWithFixedDelay(tarea, initialDelay, delay, unidad):
    // % - El delay se cuenta DESPUÉS de que termine cada ejecución

    // * SIEMPRE preferir ScheduledExecutorService sobre Timer

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 15: Timer básico (LEGACY - solo para entender)
    // $ ════════════════════════════════════════════════════════
    // $ Timer timer = new Timer();
    // $
    // $ // Ejecuta una vez después de 3 segundos
    // $ timer.schedule(new TimerTask() {
    // $     @Override
    // $     public void run() {
    // $         System.out.println("Tarea ejecutada!");
    // $         timer.cancel(); // Detiene el timer
    // $     }
    // $ }, 3000);

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 16: ScheduledExecutorService - Tarea única
    // $ ════════════════════════════════════════════════════════
    // $ ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    // $
    // $ // Ejecuta después de 3 segundos
    // $ scheduler.schedule(() -> {
    // $     System.out.println("Tarea ejecutada!");
    // $ }, 3, TimeUnit.SECONDS);
    // $
    // $ scheduler.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 17: scheduleAtFixedRate - Tarea periódica
    // $ ════════════════════════════════════════════════════════
    // $ ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    // $
    // $ // Empieza después de 0 segundos, se repite cada 2 segundos
    // $ ScheduledFuture<?> future = scheduler.scheduleAtFixedRate(() -> {
    // $     System.out.println("Tick: " + System.currentTimeMillis());
    // $ }, 0, 2, TimeUnit.SECONDS);
    // $
    // $ // Cancelar después de 10 segundos
    // $ scheduler.schedule(() -> {
    // $     future.cancel(false);
    // $     scheduler.shutdown();
    // $ }, 10, TimeUnit.SECONDS);

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 18: scheduleWithFixedDelay
    // $ ════════════════════════════════════════════════════════
    // $ ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    // $
    // $ // Espera 1 seg después de que termine cada ejecución
    // $ scheduler.scheduleWithFixedDelay(() -> {
    // $     System.out.println("Inicio: " + System.currentTimeMillis());
    // $     try {
    // $         Thread.sleep(3000); // La tarea dura 3 segundos
    // $     } catch (InterruptedException e) {}
    // $     System.out.println("Fin: " + System.currentTimeMillis());
    // $     // Esperará 1 segundo DESPUÉS de este println antes de volver a ejecutar
    // $ }, 0, 1, TimeUnit.SECONDS);

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 19: Diferencia scheduleAtFixedRate vs WithFixedDelay
    // $ ════════════════════════════════════════════════════════
    // $ // scheduleAtFixedRate: período desde el INICIO
    // $ // T=0s: inicia tarea (dura 3s)
    // $ // T=2s: debería iniciar otra, pero espera a que termine la primera
    // $ // T=3s: termina primera
    // $ // T=3s: inicia segunda inmediatamente
    // $
    // $ // scheduleWithFixedDelay: delay DESPUÉS de terminar
    // $ // T=0s: inicia tarea (dura 3s)
    // $ // T=3s: termina tarea
    // $ // T=5s: inicia siguiente (3s de tarea + 2s de delay)


    // ============================================================
    // 6. EXECUTORS Y EXECUTORSERVICE - FUNDAMENTOS
    // ============================================================

    // ? ExecutorService: interfaz para administrar hilos automáticamente
    // ? Ventajas sobre Thread manual:
    // ?   - Gestión automática del pool de hilos
    // ?   - Reutilización de hilos (mejor rendimiento)
    // ?   - Código más limpio y mantenible
    // ?   - Control centralizado de concurrencia

    // ? Executors.newSingleThreadExecutor():
    // ? - Crea executor con UN SOLO hilo reutilizable
    // ? - Tareas se ejecutan secuencialmente
    // ? - Las tareas en espera van a una cola

    // ? Executors.newFixedThreadPool(n):
    // ? - Crea pool con n hilos FIJOS
    // ? - Si llegan más de n tareas, las extra van a cola
    // ? - Los hilos se reutilizan al terminar tareas

    // ! SIEMPRE cerrar el executor con shutdown() o shutdownNow()
    // ! Sin shutdown(), el programa NO termina (hilos activos quedan en memoria)

    // # shutdown() vs shutdownNow():
    // # - shutdown(): NO acepta nuevas tareas, espera a que terminen las actuales
    // # - shutdownNow(): Intenta DETENER todas las tareas inmediatamente

    // # awaitTermination(tiempo, unidad):
    // # - Bloquea el hilo actual hasta que:
    // #   a) Todas las tareas terminen
    // #   b) Se cumpla el timeout
    // #   c) El hilo sea interrumpido
    // # - NO detiene las tareas, solo ESPERA

    // * Usar ExecutorService en lugar de gestionar Thread manualmente
    // * Patrón recomendado:
    // * 1. Crear executor
    // * 2. Submit tareas
    // * 3. shutdown()
    // * 4. awaitTermination() si necesitas esperar

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 20: newSingleThreadExecutor - Un solo hilo
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ // Enviar 3 tareas (se ejecutan una tras otra)
    // $ executor.submit(() -> {
    // $     System.out.println("Tarea 1: " + Thread.currentThread().getName());
    // $     try { Thread.sleep(2000); } catch (InterruptedException e) {}
    // $ });
    // $
    // $ executor.submit(() -> {
    // $     System.out.println("Tarea 2: " + Thread.currentThread().getName());
    // $     try { Thread.sleep(2000); } catch (InterruptedException e) {}
    // $ });
    // $
    // $ executor.submit(() -> {
    // $     System.out.println("Tarea 3: " + Thread.currentThread().getName());
    // $ });
    // $
    // $ executor.shutdown(); // NO acepta más tareas
    // $ // Las 3 tareas usan el MISMO hilo secuencialmente

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 21: newFixedThreadPool - Múltiples hilos
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newFixedThreadPool(2);
    // $
    // $ // Enviar 5 tareas (2 en paralelo, 3 esperan en cola)
    // $ for (int i = 1; i <= 5; i++) {
    // $     final int taskNum = i;
    // $     executor.submit(() -> {
    // $         System.out.println("Tarea " + taskNum + " en " +
    // $                            Thread.currentThread().getName());
    // $         try { Thread.sleep(2000); } catch (InterruptedException e) {}
    // $         System.out.println("Tarea " + taskNum + " terminó");
    // $     });
    // $ }
    // $
    // $ executor.shutdown();
    // $
    // $ // Salida típica:
    // $ // Tarea 1 en pool-1-thread-1
    // $ // Tarea 2 en pool-1-thread-2  (estas 2 en paralelo)
    // $ // Tarea 1 terminó
    // $ // Tarea 3 en pool-1-thread-1  (reutiliza thread-1)
    // $ // Tarea 2 terminó
    // $ // Tarea 4 en pool-1-thread-2  (reutiliza thread-2)
    // $ // ...

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 22: shutdown() vs shutdownNow()
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newFixedThreadPool(2);
    // $
    // $ for (int i = 1; i <= 5; i++) {
    // $     final int taskNum = i;
    // $     executor.submit(() -> {
    // $         System.out.println("Tarea " + taskNum + " iniciada");
    // $         try { Thread.sleep(5000); } catch (InterruptedException e) {
    // $             System.out.println("Tarea " + taskNum + " interrumpida!");
    // $         }
    // $         System.out.println("Tarea " + taskNum + " terminada");
    // $     });
    // $ }
    // $
    // $ Thread.sleep(1000);
    // $
    // $ // Opción 1: shutdown() - espera a que terminen
    // $ executor.shutdown();
    // $ // Todas las 5 tareas terminarán
    // $
    // $ // Opción 2: shutdownNow() - intenta detener
    // $ List<Runnable> pendientes = executor.shutdownNow();
    // $ System.out.println("Tareas que no empezaron: " + pendientes.size());
    // $ // Las tareas en ejecución reciben InterruptedException
    // $ // Las que están en cola NO se ejecutan

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 23: awaitTermination - Esperar a que terminen
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newFixedThreadPool(3);
    // $
    // $ for (int i = 1; i <= 10; i++) {
    // $     final int num = i;
    // $     executor.submit(() -> {
    // $         try { Thread.sleep(2000); } catch (InterruptedException e) {}
    // $         System.out.println("Tarea " + num + " completa");
    // $     });
    // $ }
    // $
    // $ System.out.println("Todas las tareas enviadas");
    // $ executor.shutdown();
    // $
    // $ try {
    // $     // Espera máximo 15 segundos a que terminen todas
    // $     boolean terminaron = executor.awaitTermination(15, TimeUnit.SECONDS);
    // $
    // $     if (terminaron) {
    // $         System.out.println("Todas terminaron a tiempo");
    // $     } else {
    // $         System.out.println("Timeout! Algunas no terminaron");
    // $     }
    // $ } catch (InterruptedException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ System.out.println("Programa continúa...");

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 24: Patrón completo try-finally
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newFixedThreadPool(2);
    // $
    // $ try {
    // $     for (int i = 0; i < 10; i++) {
    // $         executor.submit(() -> {
    // $             // Código de la tarea
    // $             System.out.println("Procesando...");
    // $         });
    // $     }
    // $ } finally {
    // $     executor.shutdown(); // ✅ Siempre se ejecuta
    // $     try {
    // $         if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
    // $             executor.shutdownNow();
    // $         }
    // $     } catch (InterruptedException e) {
    // $         executor.shutdownNow();
    // $     }
    // $ }


    // ============================================================
    // 7. RUNNABLE vs CALLABLE
    // ============================================================

    // % Runnable:
    // % - Método: void run()
    // % - NO devuelve resultado
    // % - NO puede lanzar checked exceptions
    // % - Para tareas sin valor de retorno

    // % Callable<T>:
    // % - Método: T call() throws Exception
    // % - SÍ devuelve resultado de tipo T
    // % - PUEDE lanzar checked exceptions
    // % - Para tareas que calculan un valor

    // * Usar Callable cuando necesitas obtener un resultado
    // * Usar Runnable para acciones sin retorno (imprimir, guardar, etc)

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 25: Runnable - Sin retorno
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Runnable tarea = () -> {
    // $     System.out.println("Guardando datos en DB...");
    // $     try { Thread.sleep(2000); } catch (InterruptedException e) {}
    // $     System.out.println("Datos guardados");
    // $     // NO retorna nada
    // $ };
    // $
    // $ executor.submit(tarea);
    // $ executor.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 26: Callable - Con retorno
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Callable<Integer> tarea = () -> {
    // $     System.out.println("Calculando suma...");
    // $     Thread.sleep(2000);
    // $     int resultado = 10 + 20;
    // $     return resultado; // ✅ Retorna un valor
    // $ };
    // $
    // $ Future<Integer> future = executor.submit(tarea);
    // $ Integer resultado = future.get(); // Obtiene el resultado
    // $ System.out.println("La suma es: " + resultado);
    // $
    // $ executor.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 27: Callable con Exception
    // $ ════════════════════════════════════════════════════════
    // $ Callable<String> tarea = () -> {
    // $     if (Math.random() > 0.5) {
    // $         throw new Exception("Error aleatorio!"); // ✅ Puede lanzar checked exception
    // $     }
    // $     return "Éxito";
    // $ };
    // $
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $ Future<String> future = executor.submit(tarea);
    // $
    // $ try {
    // $     String resultado = future.get();
    // $     System.out.println(resultado);
    // $ } catch (ExecutionException e) {
    // $     System.out.println("La tarea lanzó excepción: " + e.getCause().getMessage());
    // $ } catch (InterruptedException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ executor.shutdown();


    // ============================================================
    // 8. FUTURE - RESULTADOS ASÍNCRONOS
    // ============================================================

    // ? Future<T>: representa el resultado FUTURO de una tarea asíncrona
    // ? Permite consultar estado y obtener resultado cuando esté listo

    // ? Métodos principales:
    // ? - get()                    → Espera y retorna el resultado (BLOQUEANTE)
    // ? - get(timeout, unidad)     → Espera con límite de tiempo
    // ? - isDone()                 → true si la tarea terminó
    // ? - isCancelled()            → true si fue cancelada
    // ? - cancel(mayInterrupt)     → Intenta cancelar la tarea

    // ! future.get() BLOQUEA el hilo actual hasta que la tarea termine
    // ! Puede lanzar InterruptedException, ExecutionException, TimeoutException

    // # cancel(true) vs cancel(false):
    // # - true: intenta interrumpir la tarea en ejecución
    // # - false: solo cancela si aún no empezó

    // * Usar isDone() en un while para verificar sin bloquear completamente
    // * Siempre capturar las excepciones de get()

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 28: Future básico con get()
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Future<String> future = executor.submit(() -> {
    // $     Thread.sleep(3000);
    // $     return "Resultado después de 3 segundos";
    // $ });
    // $
    // $ System.out.println("Haciendo otras cosas mientras se ejecuta...");
    // $
    // $ try {
    // $     String resultado = future.get(); // ⏸️ Se BLOQUEA aquí hasta que termine
    // $     System.out.println(resultado);
    // $ } catch (InterruptedException | ExecutionException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ executor.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 29: get() con timeout
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Future<String> future = executor.submit(() -> {
    // $     Thread.sleep(10000); // Tarea que tarda 10 segundos
    // $     return "Terminé";
    // $ });
    // $
    // $ try {
    // $     // Espera máximo 3 segundos
    // $     String resultado = future.get(3, TimeUnit.SECONDS);
    // $     System.out.println(resultado);
    // $ } catch (TimeoutException e) {
    // $     System.out.println("La tarea tardó demasiado!");
    // $     future.cancel(true); // Intenta cancelarla
    // $ } catch (InterruptedException | ExecutionException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ executor.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 30: isDone() - Polling sin bloquear
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Future<Integer> future = executor.submit(() -> {
    // $     Thread.sleep(5000);
    // $     return 42;
    // $ });
    // $
    // $ // Mientras no termine, hacer otras cosas
    // $ while (!future.isDone()) {
    // $     System.out.println("Aún procesando...");
    // $     Thread.sleep(1000); // Verifica cada segundo
    // $ }
    // $
    // $ try {
    // $     Integer resultado = future.get(); // Ya sabemos que terminó
    // $     System.out.println("Resultado: " + resultado);
    // $ } catch (InterruptedException | ExecutionException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ executor.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 31: cancel() - Cancelar tarea
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Future<String> future = executor.submit(() -> {
    // $     for (int i = 0; i < 10; i++) {
    // $         if (Thread.currentThread().isInterrupted()) {
    // $             System.out.println("Tarea interrumpida!");
    // $             return "Cancelado";
    // $         }
    // $         System.out.println("Iteración " + i);
    // $         Thread.sleep(1000);
    // $     }
    // $     return "Completado";
    // $ });
    // $
    // $ Thread.sleep(3000); // Espera 3 segundos
    // $ future.cancel(true); // Cancela e interrumpe
    // $
    // $ System.out.println("¿Cancelado? " + future.isCancelled());
    // $ System.out.println("¿Terminado? " + future.isDone());
    // $
    // $ executor.shutdown();

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 32: Múltiples Futures
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newFixedThreadPool(3);
    // $
    // $ Future<Integer> f1 = executor.submit(() -> {
    // $     Thread.sleep(2000);
    // $     return 10;
    // $ });
    // $
    // $ Future<Integer> f2 = executor.submit(() -> {
    // $     Thread.sleep(1000);
    // $     return 20;
    // $ });
    // $
    // $ Future<Integer> f3 = executor.submit(() -> {
    // $     Thread.sleep(3000);
    // $     return 30;
    // $ });
    // $
    // $ try {
    // $     // Obtiene resultados en orden (puede no ser el orden de finalización)
    // $     Integer r1 = f1.get(); // Espera hasta 2 segundos
    // $     Integer r2 = f2.get(); // Ya terminó (espera 0)
    // $     Integer r3 = f3.get(); // Espera 1 segundo más (total 3)
    // $
    // $     int suma = r1 + r2 + r3;
    // $     System.out.println("Suma total: " + suma); // 60
    // $ } catch (InterruptedException | ExecutionException e) {
    // $     e.printStackTrace();
    // $ }
    // $
    // $ executor.shutdown();


    // ============================================================
    // 9. THREADPOOLEXECUTOR - CONTROL AVANZADO
    // ============================================================

    // ? ThreadPoolExecutor: implementación concreta con más control
    // ? Permite monitorear y configurar el pool de hilos

    // ? Información de monitoreo:
    // ? - getPoolSize()       → Número de hilos activos actualmente
    // ? - getQueue().size()   → Tareas esperando en cola
    // ? - getActiveCount()    → Hilos ejecutando tareas ahora
    // ? - getCompletedTaskCount() → Tareas completadas en total

    // # Cast necesario:
    // # ThreadPoolExecutor exec = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

    // % FixedThreadPool(n):
    // % - n hilos fijos pre-creados
    // % - Cola de tareas ilimitada (LinkedBlockingQueue)
    // % - Si hay 3 hilos y 5 tareas: 3 ejecutan, 2 esperan en cola

    // ! Cola ilimitada puede causar OutOfMemoryError con muchas tareas
    // ! Monitorear getQueue().size() en producción

    // * Ideal para carga predecible y controlada
    // * Configurar límites de cola en escenarios de alta demanda

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 33: Monitoreo de ThreadPoolExecutor
    // $ ════════════════════════════════════════════════════════
    // $ ThreadPoolExecutor executor = (ThreadPoolExecutor)
    // $     Executors.newFixedThreadPool(2);
    // $
    // $ System.out.println("Tamaño del pool: " + executor.getPoolSize());
    // $ System.out.println("Tareas en cola: " + executor.getQueue().size());
    // $
    // $ // Enviar 5 tareas
    // $ for (int i = 1; i <= 5; i++) {
    // $     final int taskNum = i;
    // $     executor.submit(() -> {
    // $         System.out.println("Tarea " + taskNum + " iniciada");
    // $         try { Thread.sleep(3000); } catch (InterruptedException e) {}
    // $         System.out.println("Tarea " + taskNum + " terminada");
    // $     });
    // $ }
    // $
    // $ System.out.println("Tamaño del pool: " + executor.getPoolSize()); // 2
    // $ System.out.println("Tareas en cola: " + executor.getQueue().size()); // 3
    // $ System.out.println("Hilos activos: " + executor.getActiveCount()); // 2
    // $
    // $ executor.shutdown();
    // $
    // $ executor.awaitTermination(20, TimeUnit.SECONDS);
    // $ System.out.println("Tareas completadas: " +
    // $                    executor.getCompletedTaskCount()); // 5

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 34: newCachedThreadPool - Pool dinámico
    // $ ════════════════════════════════════════════════════════
    // $ // Crea hilos según demanda, reutiliza hilos idle
    // $ ExecutorService executor = Executors.newCachedThreadPool();
    // $
    // $ for (int i = 1; i <= 10; i++) {
    // $     final int num = i;
    // $     executor.submit(() -> {
    // $         System.out.println("Tarea " + num + " en " +
    // $                            Thread.currentThread().getName());
    // $         try { Thread.sleep(100); } catch (InterruptedException e) {}
    // $     });
    // $ }
    // $
    // $ executor.shutdown();
    // $ // Puede crear hasta 10 hilos si todos están ocupados
    // $ // Reutiliza hilos que terminaron

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 35: Crear ThreadPoolExecutor personalizado
    // $ ════════════════════════════════════════════════════════
    // $ ThreadPoolExecutor executor = new ThreadPoolExecutor(
    // $     2,                      // corePoolSize: hilos mínimos
    // $     4,                      // maximumPoolSize: hilos máximos
    // $     60,                     // keepAliveTime
    // $     TimeUnit.SECONDS,       // unidad de tiempo
    // $     new ArrayBlockingQueue<>(10) // cola limitada a 10 tareas
    // $ );
    // $
    // $ // Comportamiento:
    // $ // 1. Hasta 2 tareas: usa corePoolSize (2 hilos)
    // $ // 2. Más de 2 tareas: van a cola (hasta 10)
    // $ // 3. Cola llena + más tareas: crea hilos hasta maximumPoolSize (4)
    // $ // 4. Todo lleno: rechaza nuevas tareas (RejectedExecutionException)


    // ============================================================
    // 10. EXECUTOR + PRODUCTOR CONSUMIDOR
    // ============================================================

    // ? ExecutorService puede ejecutar tareas sincronizadas existentes
    // ? Combina la gestión de hilos del executor con sincronización manual

    // * Ventajas:
    // * - Reutiliza lógica Runnable existente
    // * - Pool administrado automáticamente
    // * - Mantiene control de sincronización (wait/notify)

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 36: Productor-Consumidor con Executor
    // $ ════════════════════════════════════════════════════════
    // $ class Buffer {
    // $     private Queue<Integer> cola = new LinkedList<>();
    // $     private int capacidad = 5;
    // $
    // $     public synchronized void producir(int valor) throws InterruptedException {
    // $         while (cola.size() == capacidad) {
    // $             wait();
    // $         }
    // $         cola.add(valor);
    // $         System.out.println("Producido: " + valor + " | Cola: " + cola.size());
    // $         notifyAll();
    // $     }
    // $
    // $     public synchronized int consumir() throws InterruptedException {
    // $         while (cola.isEmpty()) {
    // $             wait();
    // $         }
    // $         int valor = cola.poll();
    // $         System.out.println("Consumido: " + valor + " | Cola: " + cola.size());
    // $         notifyAll();
    // $         return valor;
    // $     }
    // $ }
    // $
    // $ Buffer buffer = new Buffer();
    // $ ExecutorService executor = Executors.newFixedThreadPool(3);
    // $
    // $ // 1 Productor
    // $ executor.submit(() -> {
    // $     for (int i = 0; i < 10; i++) {
    // $         try {
    // $             buffer.producir(i);
    // $             Thread.sleep(500);
    // $         } catch (InterruptedException e) {
    // $             e.printStackTrace();
    // $         }
    // $     }
    // $ });
    // $
    // $ // 2 Consumidores
    // $ for (int c = 0; c < 2; c++) {
    // $     executor.submit(() -> {
    // $         for (int i = 0; i < 5; i++) {
    // $             try {
    // $                 buffer.consumir();
    // $                 Thread.sleep(1000);
    // $             } catch (InterruptedException e) {
    // $                 e.printStackTrace();
    // $             }
    // $         }
    // $     });
    // $ }
    // $
    // $ executor.shutdown();


    // ============================================================
    // 11. CLASES ATÓMICAS
    // ============================================================

    // ? AtomicInteger: entero con operaciones thread-safe SIN synchronized
    // ? Usa operaciones atómicas a nivel de CPU (CAS - Compare-And-Swap)

    // ? Métodos comunes:
    // ? - get()                 → Obtiene valor actual
    // ? - set(valor)            → Establece nuevo valor
    // ? - getAndIncrement()     → Retorna valor actual y luego incrementa
    // ? - incrementAndGet()     → Incrementa y luego retorna nuevo valor
    // ? - getAndDecrement()     → Retorna y luego decrementa
    // ? - compareAndSet(expect, update) → Actualiza solo si valor == expect

    // % AtomicInteger vs synchronized:
    // % - AtomicInteger: más rápido, sin bloqueos, para operaciones simples
    // % - synchronized: para operaciones complejas con múltiples pasos

    // * Ideal para contadores, flags y variables compartidas simples
    // * Familia completa: AtomicLong, AtomicBoolean, AtomicReference

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 37: AtomicInteger como contador
    // $ ════════════════════════════════════════════════════════
    // $ AtomicInteger contador = new AtomicInteger(0);
    // $
    // $ ExecutorService executor = Executors.newFixedThreadPool(10);
    // $
    // $ for (int i = 0; i < 1000; i++) {
    // $     executor.submit(() -> {
    // $         contador.incrementAndGet(); // ✅ Thread-safe sin synchronized
    // $     });
    // $ }
    // $
    // $ executor.shutdown();
    // $ executor.awaitTermination(10, TimeUnit.SECONDS);
    // $
    // $ System.out.println("Contador final: " + contador.get()); // Exactamente 1000

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 38: compareAndSet - Actualización condicional
    // $ ════════════════════════════════════════════════════════
    // $ AtomicInteger saldo = new AtomicInteger(100);
    // $
    // $ // Intenta retirar 50 solo si el saldo es 100
    // $ boolean exito = saldo.compareAndSet(100, 50);
    // $ System.out.println("Retiro exitoso: " + exito); // true
    // $ System.out.println("Saldo: " + saldo.get()); // 50
    // $
    // $ // Intenta retirar otros 50, pero espera saldo de 100
    // $ boolean exito2 = saldo.compareAndSet(100, 0);
    // $ System.out.println("Retiro exitoso: " + exito2); // false (saldo es 50, no 100)
    // $ System.out.println("Saldo: " + saldo.get()); // 50 (sin cambios)

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 39: AtomicBoolean como flag
    // $ ════════════════════════════════════════════════════════
    // $ AtomicBoolean activo = new AtomicBoolean(true);
    // $
    // $ new Thread(() -> {
    // $     while (activo.get()) {
    // $         System.out.println("Trabajando...");
    // $         try { Thread.sleep(1000); } catch (InterruptedException e) {}
    // $     }
    // $     System.out.println("Detenido");
    // $ }).start();
    // $
    // $ Thread.sleep(5000);
    // $ activo.set(false); // Detiene el otro hilo

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 40: getAndIncrement vs incrementAndGet
    // $ ════════════════════════════════════════════════════════
    // $ AtomicInteger num = new AtomicInteger(5);
    // $
    // $ int antes = num.getAndIncrement();
    // $ System.out.println("Valor antes: " + antes);      // 5
    // $ System.out.println("Valor ahora: " + num.get());  // 6
    // $
    // $ int despues = num.incrementAndGet();
    // $ System.out.println("Valor después: " + despues);  // 7
    // $ System.out.println("Valor ahora: " + num.get());  // 7


    // ============================================================
    // 12. TIMEUNIT - MANEJO DE TIEMPO
    // ============================================================

    // ? TimeUnit: enum para trabajar con unidades de tiempo de forma legible

    // ? Valores: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS

    // * Hace el código más expresivo y menos propenso a errores

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 41: TimeUnit para sleep
    // $ ════════════════════════════════════════════════════════
    // $ // ❌ Poco legible:
    // $ Thread.sleep(5000);
    // $
    // $ // ✅ Mucho más claro:
    // $ TimeUnit.SECONDS.sleep(5);
    // $ TimeUnit.MINUTES.sleep(2);
    // $ TimeUnit.HOURS.sleep(1);

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 42: Conversiones de tiempo
    // $ ════════════════════════════════════════════════════════
    // $ long milisegundos = TimeUnit.HOURS.toMillis(2);
    // $ System.out.println("2 horas = " + milisegundos + " ms"); // 7200000
    // $
    // $ long segundos = TimeUnit.DAYS.toSeconds(1);
    // $ System.out.println("1 día = " + segundos + " seg"); // 86400
    // $
    // $ long minutos = TimeUnit.MILLISECONDS.toMinutes(180000);
    // $ System.out.println("180000 ms = " + minutos + " min"); // 3

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 43: TimeUnit con ExecutorService
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ executor.submit(() -> {
    // $     try {
    // $         TimeUnit.SECONDS.sleep(3);
    // $         System.out.println("Tarea completada");
    // $     } catch (InterruptedException e) {
    // $         e.printStackTrace();
    // $     }
    // $ });
    // $
    // $ executor.shutdown();
    // $ boolean terminado = executor.awaitTermination(5, TimeUnit.SECONDS);
    // $ System.out.println("¿Terminó a tiempo? " + terminado);


    // ============================================================
    // 13. ERRORES COMUNES Y CÓMO EVITARLOS
    // ============================================================

    // ! ERROR 1: Olvidar shutdown()
    // ! CONSECUENCIA: El programa no termina, hilos activos en memoria

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 44: Programa que NO termina
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $ executor.submit(() -> System.out.println("Hola"));
    // $ // ❌ Falta executor.shutdown();
    // $ // El programa se queda ejecutando indefinidamente

    // * SOLUCIÓN: Siempre usar try-finally
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $ try {
    // $     executor.submit(() -> System.out.println("Hola"));
    // $ } finally {
    // $     executor.shutdown(); // ✅ Siempre se ejecuta
    // $ }


    // ! ERROR 2: wait/notify fuera de synchronized
    // ! CONSECUENCIA: IllegalMonitorStateException

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 45: Error de wait/notify
    // $ ════════════════════════════════════════════════════════
    // $ Object lock = new Object();
    // $
    // $ // ❌ MAL:
    // $ lock.wait(); // IllegalMonitorStateException
    // $
    // $ // ✅ BIEN:
    // $ synchronized(lock) {
    // $     lock.wait(); // Funciona correctamente
    // $ }


    // ! ERROR 3: No manejar InterruptedException correctamente
    // ! CONSECUENCIA: Estado de interrupción se pierde

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 46: Manejo correcto de InterruptedException
    // $ ════════════════════════════════════════════════════════
    // $ // ❌ MAL:
    // $ try {
    // $     Thread.sleep(1000);
    // $ } catch (InterruptedException e) {
    // $     // Ignorar o solo imprimir
    // $ }
    // $
    // $ // ✅ BIEN:
    // $ try {
    // $     Thread.sleep(1000);
    // $ } catch (InterruptedException e) {
    // $     Thread.currentThread().interrupt(); // Restaura el flag de interrupción
    // $     // Opcionalmente: lanzar RuntimeException o retornar
    // $ }


    // ! ERROR 4: Bloquear el hilo principal con get() sin verificar
    // ! CONSECUENCIA: Interfaz congelada esperando resultado

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 47: No bloquear la UI
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newSingleThreadExecutor();
    // $
    // $ Future<String> future = executor.submit(() -> {
    // $     Thread.sleep(10000); // Tarea larga
    // $     return "Listo";
    // $ });
    // $
    // $ // ❌ MAL en el main/UI thread:
    // $ String resultado = future.get(); // Congela 10 segundos
    // $
    // $ // ✅ BIEN - opción 1: usar timeout
    // $ try {
    // $     String resultado = future.get(5, TimeUnit.SECONDS);
    // $ } catch (TimeoutException e) {
    // $     System.out.println("Tardó mucho");
    // $ }
    // $
    // $ // ✅ BIEN - opción 2: polling con isDone()
    // $ while (!future.isDone()) {
    // $     System.out.println("Aún procesando...");
    // $     Thread.sleep(500);
    // $ }
    // $ String resultado = future.get();


    // ! ERROR 5: Crear nuevos Thread en lugar de usar Executors
    // ! CONSECUENCIA: Desperdicio de recursos, peor rendimiento

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 48: Threads vs Executor
    // $ ════════════════════════════════════════════════════════
    // $ // ❌ MAL - crea 1000 threads:
    // $ for (int i = 0; i < 1000; i++) {
    // $     new Thread(() -> {
    // $         // tarea
    // $     }).start();
    // $ }
    // $ // Costoso: crear thread tarda ~1ms, mucha memoria
    // $
    // $ // ✅ BIEN - reutiliza hilos:
    // $ ExecutorService executor = Executors.newFixedThreadPool(10);
    // $ for (int i = 0; i < 1000; i++) {
    // $     executor.submit(() -> {
    // $         // tarea
    // $     });
    // $ }
    // $ executor.shutdown();
    // $ // Solo 10 hilos creados, reutilizados 100 veces cada uno


    // ! ERROR 6: Usar if en lugar de while con wait()
    // ! CONSECUENCIA: Spurious wakeups rompen la lógica

    // $ ════════════════════════════════════════════════════════
    // $ EJEMPLO 49: if vs while con wait()
    // $ ════════════════════════════════════════════════════════
    // $ // ❌ MAL:
    // $ synchronized(lock) {
    // $     if (!condicion) {
    // $         wait(); // Si hay spurious wakeup, NO re-verifica
    // $     }
    // $     // Puede ejecutarse aunque condicion sea false
    // $ }
    // $
    // $ // ✅ BIEN:
    // $ synchronized(lock) {
    // $     while (!condicion) {
    // $         wait(); // Si hay spurious wakeup, vuelve a verificar
    // $     }
    // $     // Solo ejecuta si condicion es true
    // $ }


    // ============================================================
    // 14. ORDEN DE APRENDIZAJE RECOMENDADO
    // ============================================================

    // * NIVEL 1 - FUNDAMENTOS:
    // * 1. Thread básico (start, sleep, estados)
    // * 2. Runnable vs extender Thread
    // * 3. join() para esperar hilos

    // * NIVEL 2 - SINCRONIZACIÓN:
    // * 4. synchronized (métodos y bloques)
    // * 5. wait/notify básico
    // * 6. Productor-Consumidor simple

    // * NIVEL 3 - EXECUTORS:
    // * 7. ExecutorService básico (single + fixed)
    // * 8. Callable y Future
    // * 9. shutdown() y awaitTermination()

    // * NIVEL 4 - AVANZADO:
    // * 10. ScheduledExecutorService
    // * 11. ThreadPoolExecutor y monitoreo
    // * 12. AtomicInteger y clases atómicas

    // * NIVEL 5 - PATRONES:
    // * 13. Productor-Consumidor con Executor
    // * 14. Manejo de errores y excepciones
    // * 15. Optimizaciones y best practices


    // ============================================================
    // 15. REFERENCIAS RÁPIDAS - CHEAT SHEET
    // ============================================================

    // $ ════════════════════════════════════════════════════════
    // $ CREAR EXECUTOR
    // $ ════════════════════════════════════════════════════════
    // $ Executors.newSingleThreadExecutor()           // 1 hilo
    // $ Executors.newFixedThreadPool(n)               // n hilos fijos
    // $ Executors.newCachedThreadPool()               // Dinámico
    // $ Executors.newScheduledThreadPool(n)           // Para tareas programadas

    // $ ════════════════════════════════════════════════════════
    // $ SUBMIT TAREAS
    // $ ════════════════════════════════════════════════════════
    // $ executor.submit(runnable)                     // Sin retorno
    // $ Future<T> f = executor.submit(callable)       // Con retorno
    // $ executor.execute(runnable)                    // Sin Future (fire and forget)

    // $ ════════════════════════════════════════════════════════
    // $ DETENER EXECUTOR
    // $ ════════════════════════════════════════════════════════
    // $ executor.shutdown()                           // No acepta más tareas
    // $ executor.shutdownNow()                        // Intenta detener todo
    // $ executor.awaitTermination(time, unit)         // Espera con timeout
    // $ executor.isShutdown()                         // ¿Ya llamó shutdown?
    // $ executor.isTerminated()                       // ¿Ya terminó todo?

    // $ ════════════════════════════════════════════════════════
    // $ FUTURE - TRABAJAR CON RESULTADOS
    // $ ════════════════════════════════════════════════════════
    // $ T resultado = future.get()                    // Bloquea hasta terminar
    // $ T resultado = future.get(time, unit)          // Con timeout
    // $ boolean done = future.isDone()                // ¿Ya terminó?
    // $ boolean cancelled = future.isCancelled()      // ¿Fue cancelado?
    // $ future.cancel(true)                           // Cancela e interrumpe
    // $ future.cancel(false)                          // Cancela si no empezó

    // $ ════════════════════════════════════════════════════════
    // $ SCHEDULED EXECUTOR - TAREAS PROGRAMADAS
    // $ ════════════════════════════════════════════════════════
    // $ scheduled.schedule(task, delay, unit)                     // Una vez
    // $ scheduled.scheduleAtFixedRate(task, init, period, unit)   // Período fijo
    // $ scheduled.scheduleWithFixedDelay(task, init, delay, unit) // Delay fijo

    // $ ════════════════════════════════════════════════════════
    // $ THREAD BÁSICO
    // $ ════════════════════════════════════════════════════════
    // $ Thread.sleep(ms)                              // Duerme hilo actual
    // $ TimeUnit.SECONDS.sleep(n)                     // Más legible
    // $ thread.start()                                // Inicia hilo
    // $ thread.join()                                 // Espera a que termine
    // $ thread.interrupt()                            // Interrumpe hilo
    // $ thread.isInterrupted()                        // ¿Está interrumpido?
    // $ thread.getState()                             // Estado actual
    // $ Thread.currentThread()                        // Hilo actual
    // $ Thread.currentThread().getName()              // Nombre del hilo actual

    // $ ════════════════════════════════════════════════════════
    // $ SINCRONIZACIÓN
    // $ ════════════════════════════════════════════════════════
    // $ synchronized(objeto) { ... }                  // Bloque sincronizado
    // $ public synchronized void metodo() { ... }     // Método sincronizado
    // $ objeto.wait()                                 // Libera lock y espera
    // $ objeto.notify()                               // Despierta 1 hilo
    // $ objeto.notifyAll()                            // Despierta todos

    // $ ════════════════════════════════════════════════════════
    // $ ATOMIC - OPERACIONES ATÓMICAS
    // $ ════════════════════════════════════════════════════════
    // $ AtomicInteger num = new AtomicInteger(0)
    // $ num.get()                                     // Obtiene valor
    // $ num.set(valor)                                // Establece valor
    // $ num.getAndIncrement()                         // Retorna y luego ++
    // $ num.incrementAndGet()                         // ++ y luego retorna
    // $ num.getAndDecrement()                         // Retorna y luego --
    // $ num.decrementAndGet()                         // -- y luego retorna
    // $ num.compareAndSet(expected, update)           // CAS operation
    // $ num.addAndGet(delta)                          // Suma y retorna

    // $ ════════════════════════════════════════════════════════
    // $ TIMEUNIT - CONVERSIONES
    // $ ════════════════════════════════════════════════════════
    // $ TimeUnit.HOURS.toMinutes(2)                   // 2 horas = 120 min
    // $ TimeUnit.DAYS.toSeconds(1)                    // 1 día = 86400 seg
    // $ TimeUnit.MILLISECONDS.toSeconds(5000)         // 5000ms = 5 seg

    // $ ════════════════════════════════════════════════════════
    // $ THREADPOOLEXECUTOR - MONITOREO
    // $ ════════════════════════════════════════════════════════
    // $ ThreadPoolExecutor pool = (ThreadPoolExecutor) executor
    // $ pool.getPoolSize()                            // Hilos activos
    // $ pool.getActiveCount()                         // Hilos trabajando
    // $ pool.getQueue().size()                        // Tareas en cola
    // $ pool.getCompletedTaskCount()                  // Tareas completadas
    // $ pool.getTaskCount()                           // Total de tareas

    // $ ════════════════════════════════════════════════════════
    // $ PATRÓN TRY-FINALLY RECOMENDADO
    // $ ════════════════════════════════════════════════════════
    // $ ExecutorService executor = Executors.newFixedThreadPool(n);
    // $ try {
    // $     // Submit tareas
    // $     executor.submit(() -> { ... });
    // $ } finally {
    // $     executor.shutdown();
    // $     try {
    // $         if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
    // $             executor.shutdownNow();
    // $             if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
    // $                 System.err.println("Executor no terminó");
    // $             }
    // $         }
    // $     } catch (InterruptedException e) {
    // $         executor.shutdownNow();
    // $         Thread.currentThread().interrupt();
    // $     }
    // $ }

    // $ ════════════════════════════════════════════════════════
    // $ DECISIONES RÁPIDAS - ¿QUÉ USAR?
    // $ ════════════════════════════════════════════════════════
    // $ ¿Necesitas retorno?           → Callable en vez de Runnable
    // $ ¿Tarea única sin retorno?     → Runnable
    // $ ¿1 tarea a la vez?             → newSingleThreadExecutor()
    // $ ¿N tareas en paralelo?         → newFixedThreadPool(n)
    // $ ¿Tareas dinámicas?             → newCachedThreadPool()
    // $ ¿Tareas programadas?           → newScheduledThreadPool(n)
    // $ ¿Contador compartido simple?   → AtomicInteger
    // $ ¿Lógica compleja compartida?   → synchronized
    // $ ¿Esperar múltiples hilos?      → join() o awaitTermination()
    // $ ¿Cancelar tarea en progreso?   → Future.cancel(true)

}