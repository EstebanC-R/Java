
// ? =====================================================
// ? 📋 TABLA DE CONTENIDO
// ? =====================================================
// ? 1. LocalDate      -> Trabajar solo con fechas
// ? 2. LocalTime      -> Trabajar solo con horas
// ? 3. LocalDateTime  -> Fecha y hora juntas
// ? 4. Duration       -> Diferencia entre horas/tiempos
// ? 5. Instant        -> Punto exacto en el tiempo (timestamp)
// ? 6. Period         -> Diferencia entre fechas
// ? 7. ZonedDateTime  -> Manejar zonas horarias
// ? 8. Patrones de formato comunes


// # =====================================================
// # 1️⃣ LOCALDATE - TRABAJANDO SOLO CON FECHAS
// # =====================================================
// # ¿Cuándo usar? Fechas de nacimiento, vencimientos,
// # eventos, cualquier cosa donde NO importa la hora
// # =====================================================

// * --------------------------------------------------
// * CREAR FECHAS
// * --------------------------------------------------

// % → Obtener la fecha actual (HOY)
// LocalDate fechaActual = LocalDate.now();
// Salida: 2026-02-06

// % → Crear fecha específica: of(año, mes, día)
// LocalDate miFecha = LocalDate.of(2026, 2, 4);
// Salida: 2026-02-04

// % → Crear fecha con el enum Month (más legible)
// LocalDate miFecha2 = LocalDate.of(2026, Month.FEBRUARY, 4);
// Salida: 2026-02-04

// % → Convertir un String a fecha
// LocalDate miFecha3 = LocalDate.parse("2026-02-04");
// Formato esperado: yyyy-MM-dd


// * --------------------------------------------------
// * OBTENER INFORMACIÓN DE UNA FECHA
// * --------------------------------------------------

// % → Día del mes (1-31)
// int dia = fechaActual.getDayOfMonth();

// % → Mes como enum
// Month mes = fechaActual.getMonth();
// Salida: FEBRUARY

// % → Número del mes (1-12)
// int numeroMes = mes.getValue();
// Salida: 2

// ! IMPORTANTE: Mostrar mes en español
// ! new Locale("es", "ES") está obsoleto desde Java 19
// ! Usar: Locale.forLanguageTag("es-CO")
// String mesEspañol = mes.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-CO"));
// Salida: "febrero"

// % → Día de la semana
// DayOfWeek diaSemana = fechaActual.getDayOfWeek();
// Salida: THURSDAY

// % → Número del día (1=Lunes, 7=Domingo)
// int numeroDia = diaSemana.getValue();

// % → Día en español
// String diaEspañol = diaSemana.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("es-CO"));
// Salida: "jueves"

// % → Año
// int año = fechaActual.getYear();

// % → Día del año (1-365 o 366)
// int diaDelAño = fechaActual.getDayOfYear();

// % → Era (CE o BCE)
// fechaActual.getEra();


// * --------------------------------------------------
// * OPERACIONES CON FECHAS (SUMAR/RESTAR)
// * --------------------------------------------------

// % → Sumar días
// LocalDate mañana = LocalDate.now().plusDays(1);

// % → Restar meses
// LocalDate mesAnterior = LocalDate.now().minusMonths(1);

// % → Forma alternativa usando ChronoUnit
// LocalDate mesAnterior2 = LocalDate.now().minus(1, ChronoUnit.MONTHS);

// $ NOTA: Todos los métodos devuelven NUEVA instancia
// $ La fecha original NO se modifica (inmutabilidad)


// * --------------------------------------------------
// * COMPARACIONES ENTRE FECHAS
// * --------------------------------------------------

// % → ¿Esta fecha es ANTES que otra?
// boolean esAntes = LocalDate.of(2026, 2, 4)
//                            .isBefore(LocalDate.parse("2026-02-05"));
// true (4 de feb es antes que 5 de feb)

// % → ¿Esta fecha es DESPUÉS que otra?
// boolean esDespues = LocalDate.of(2026, 2, 4)
//                              .isAfter(LocalDate.parse("2026-02-02"));
// true (4 de feb es después que 2 de feb)

// % → ¿Hoy es después que ayer?
// boolean hoyDespuesDeAyer = LocalDate.now()
//                                     .isAfter(LocalDate.now().minusDays(1));
// true


// * --------------------------------------------------
// * VALIDACIONES ÚTILES
// * --------------------------------------------------

// % → ¿El año es bisiesto?
// boolean esBisiesto = LocalDate.now().isLeapYear();

// → Extraer el día de la semana de una fecha específica
// DayOfWeek queDiaEs = LocalDate.parse("2026-02-02").getDayOfWeek();
// MONDAY


// # =====================================================
// # 2️⃣ LOCALTIME - TRABAJANDO SOLO CON HORAS
// # =====================================================
// # ¿Cuándo usar? Horarios, alarmas, duraciones,
// # cualquier cosa donde NO importa la fecha
// # =====================================================

// * --------------------------------------------------
// * CREAR HORAS
// * --------------------------------------------------

// % → Hora actual (AHORA)
// LocalTime ahora = LocalTime.now();
// Salida: 14:35:22.123456789

// % → Crear hora específica: of(hora, minuto, segundo)
// LocalTime hora1 = LocalTime.of(6, 30, 26);
// Salida: 06:30:26

// % → Convertir String a hora
// LocalTime hora2 = LocalTime.parse("18:30");
// Formato esperado: HH:mm


// * --------------------------------------------------
// * OBTENER INFORMACIÓN DE LA HORA
// * --------------------------------------------------

// % → Hora (0-23)
// int hora = ahora.getHour();

// % → Minutos (0-59)
// int minutos = ahora.getMinute();

// % → Segundos (0-59)
// int segundos = ahora.getSecond();


// * --------------------------------------------------
// * OPERACIONES CON HORAS
// * --------------------------------------------------

// % → Sumar horas
// LocalTime unaHoraMas = LocalTime.of(6, 30).plusHours(1);
// Salida: 07:30


// * --------------------------------------------------
// * COMPARACIONES ENTRE HORAS
// * --------------------------------------------------

// % → ¿Esta hora es antes que otra?
// boolean esAnterior = LocalTime.of(4, 50)
//                               .isBefore(LocalTime.parse("07:30"));
// true


// * --------------------------------------------------
// * FORMATEAR HORAS (MUY IMPORTANTE)
// * --------------------------------------------------

// ! CONCEPTOS CLAVE DE FORMATEO:
// ! HH = Formato 24 horas (00-23)
// ! hh = Formato 12 horas (01-12)
// ! a  = Indicador AM/PM

// % → Crear un formateador personalizado
// DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss a");

// % → Formatear hora
// String horaFormateada = LocalTime.of(18, 30).format(df);
// Salida: "06:30:00 PM"

// → Forma alternativa
// String horaFormateada2 = df.format(ahora);


// * --------------------------------------------------
// * VALORES EXTREMOS
// * --------------------------------------------------

// % → Hora máxima del día
// LocalTime max = LocalTime.MAX;
// 23:59:59.999999999

// % → Hora mínima del día
// LocalTime min = LocalTime.MIN;
// 00:00


// # =====================================================
// # 3️⃣ LOCALDATETIME - FECHA Y HORA JUNTAS
// # =====================================================
// # ¿Cuándo usar? Registro de eventos, timestamps,
// # logs del sistema, cualquier cosa con fecha Y hora
// # =====================================================

// * --------------------------------------------------
// * CREAR FECHA-HORA
// * --------------------------------------------------

// → Fecha y hora actual
// LocalDateTime fechaTiempo = LocalDateTime.now();
// Salida: 2026-02-06T14:35:22.123456789

// → Crear manualmente: of(año, mes, día, hora, min, seg)
// LocalDateTime dt1 = LocalDateTime.of(2026, Month.FEBRUARY, 4, 20, 45, 59);
// Salida: 2026-02-04T20:45:59

// → Convertir desde String
// LocalDateTime dt2 = LocalDateTime.parse("2026-02-25T21:45:59");
// ! Formato esperado: yyyy-MM-ddTHH:mm:ss
// ! La "T" separa fecha de hora

// → También puede incluir nanosegundos
// LocalDateTime dt3 = LocalDateTime.parse("2026-02-25T21:45:59.4533333");


// * --------------------------------------------------
// * OPERACIONES CON FECHA-HORA
// * --------------------------------------------------

// $ IMPORTANTE: Las operaciones NO modifican el original
// $ Siempre devuelven una NUEVA instancia

// LocalDateTime original = LocalDateTime.now();

// → Sumar múltiples unidades (encadenado)
// LocalDateTime modificado = original.plusDays(1).plusHours(3);

// → Restar horas
// LocalDateTime menosCinco = original.minusHours(5);

// $ Verificar que el original NO cambió
// System.out.println(original);     // Sin cambios
// System.out.println(modificado);   // Con los cambios


// * --------------------------------------------------
// * OBTENER INFORMACIÓN
// * --------------------------------------------------

// → Mes
// Month mes = fechaTiempo.getMonth();

// → Día del mes
// int dia = fechaTiempo.getDayOfMonth();

// → Año
// int año = fechaTiempo.getYear();


// * --------------------------------------------------
// * FORMATEAR FECHA-HORA
// * --------------------------------------------------

// → Formato ISO estándar
// String formato1 = fechaTiempo.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
// Salida: "2026-02-06T14:35:22.123"

// → Formato personalizado
// String formato2 = fechaTiempo.format(
//     DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a")
// );
// Salida: "2026/02/06 02:35:22 PM"

// → Crear formateador reutilizable
// DateTimeFormatter miFormato = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
// String formato3 = miFormato.format(fechaTiempo);


// # =====================================================
// # 4️⃣ DURATION - MEDIR TIEMPO ENTRE HORAS
// # =====================================================
// # ¿Cuándo usar? Calcular cuánto tiempo pasó entre
// # dos momentos (horas, minutos, segundos)
// # Ejemplo: ¿Cuánto duró la película?
// # =====================================================

// * --------------------------------------------------
// * CALCULAR DURACIÓN ENTRE DOS MOMENTOS
// * --------------------------------------------------

// → Crear dos puntos en el tiempo
// LocalDateTime inicio = LocalDateTime.now();
// LocalDateTime fin = LocalDateTime.now()
//                                  .plusHours(3)
//                                  .plusMinutes(20)
//                                  .plusDays(1);

// → Calcular la diferencia
// Duration lapsus = Duration.between(inicio, fin);
// Salida: PT27H20M (27 horas y 20 minutos)


// * --------------------------------------------------
// * OBTENER VALORES DE LA DURACIÓN
// * --------------------------------------------------

// → Convertir a minutos
// long minutos = lapsus.toMinutes();
// Salida: 1640 minutos

// → Convertir a horas
// long horas = lapsus.toHours();

// → Convertir a segundos
// long segundos = lapsus.getSeconds();


// * --------------------------------------------------
// * MODIFICAR DURACIONES
// * --------------------------------------------------

// → Sumar tiempo a una duración
// Duration nueva = lapsus.plusHours(5);
// Salida: PT32H20M


// ! =====================================================
// ! ⚠️ IMPORTANTE: Duration vs Period
// ! =====================================================
// ! Duration → Para HORAS, MINUTOS, SEGUNDOS
// ! Period   → Para AÑOS, MESES, DÍAS
// ! 
// ! Usa Duration cuando trabajes con LocalTime/LocalDateTime
// ! Usa Period cuando trabajes con LocalDate
// ! =====================================================


// # =====================================================
// # 5️⃣ INSTANT - PUNTO EXACTO EN EL TIEMPO
// # =====================================================
// # ¿Cuándo usar? Medir rendimiento, timestamps,
// # operaciones que requieren precisión exacta
// # =====================================================

// * --------------------------------------------------
// * MEDIR CUÁNTO TARDA ALGO EN EJECUTARSE
// * --------------------------------------------------

// → Capturar momento inicial
// Instant inicio = Instant.now();

// → Hacer algo que tarda tiempo
// try {
//     TimeUnit.SECONDS.sleep(3);  // Esperar 3 segundos
// } catch (InterruptedException e) {
//     System.out.println("Error: " + e.getMessage());
// }

// → Capturar momento final
// Instant fin = Instant.now();

// → Calcular cuánto tardó
// Duration tiempoTranscurrido = Duration.between(inicio, fin);
// System.out.println("Tiempo: " + tiempoTranscurrido);
// Salida: PT3.001S (3 segundos aprox)


// ? =====================================================
// ? 💡 CONSEJO: Instant es perfecto para:
// ? - Medir performance de algoritmos
// ? - Registrar timestamps en bases de datos
// ? - Calcular tiempo de respuesta de APIs
// ? =====================================================


// # =====================================================
// # 6️⃣ PERIOD - MEDIR TIEMPO ENTRE FECHAS
// # =====================================================
// # ¿Cuándo usar? Calcular edad, diferencia entre fechas
// # en términos de años, meses y días
// # Ejemplo: ¿Cuántos años tengo?
// # =====================================================

// * --------------------------------------------------
// * CALCULAR DIFERENCIA ENTRE FECHAS
// * --------------------------------------------------

// % → Fecha de nacimiento
// LocalDate nacimiento = LocalDate.of(2004, 2, 4);

// % → Fecha actual
// LocalDate hoy = LocalDate.of(2026, 2, 4);

// % → Calcular la diferencia
// Period periodo = Period.between(nacimiento, hoy);
// Salida: P22Y (22 años)


// * --------------------------------------------------
// * MODIFICAR FECHAS SIN ALTERAR LA ORIGINAL
// * --------------------------------------------------

// # IMPORTANTE: withMonth() y withDayOfMonth() 
// # devuelven NUEVA instancia sin modificar la original

// LocalDate fecha = LocalDate.of(2026, 2, 4);

// → Cambiar el mes (devuelve nueva instancia)
// LocalDate nuevaFecha = fecha.withMonth(12);

// → Cambiar el día
// nuevaFecha = nuevaFecha.withDayOfMonth(28);

// → Calcular período
// Period p = Period.between(nacimiento, nuevaFecha);


// * --------------------------------------------------
// * OBTENER VALORES DEL PERÍODO
// * --------------------------------------------------

// → Años completos
// int años = periodo.getYears();

// → Meses completos
// int meses = periodo.getMonths();

// → Días completos
// int dias = periodo.getDays();


// * --------------------------------------------------
// * EJEMPLO PRÁCTICO: CALCULAR EDAD
// * --------------------------------------------------

// LocalDate fechaNacimiento = LocalDate.of(2004, 2, 4);
// LocalDate fechaActual = LocalDate.of(2026, 12, 28);

// Period edad = Period.between(fechaNacimiento, fechaActual);

// System.out.printf("Periodo entre %s y %s es: %d años %d meses y %d días",
//     fechaNacimiento,
//     fechaActual,
//     edad.getYears(),
//     edad.getMonths(),
//     edad.getDays()
// );
// Salida: "Periodo entre 2004-02-04 y 2026-12-28 es: 22 años 10 meses y 24 días"


// # =====================================================
// # 7️⃣ ZONEDDATETIME - MANEJAR ZONAS HORARIAS
// # =====================================================
// # ¿Cuándo usar? Vuelos internacionales, aplicaciones
// # globales, coordinar eventos en diferentes países
// # =====================================================

// * --------------------------------------------------
// * CREAR FECHA-HORA CON ZONA HORARIA
// * --------------------------------------------------

// → Primero crear fecha-hora local
// LocalDateTime fechaLocal = LocalDateTime.parse(
//     "2026/09/23 12:45",
//     DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")
// );

// → Asignar zona horaria (New York, UTC-4)
// ZonedDateTime zonaNY = fechaLocal.atZone(ZoneOffset.of("-04:00"));
// System.out.println("Horario de partida en New York: " + zonaNY);
// Salida: 2026-09-23T12:45-04:00


// * --------------------------------------------------
// * CONVERTIR ENTRE ZONAS HORARIAS
// * --------------------------------------------------

// → Cambiar a zona de Madrid (UTC+2) manteniendo el instante real
// ZonedDateTime zonaMadrid = zonaNY
//     .withZoneSameInstant(ZoneOffset.of("+02:00"))
//     .plusHours(8);  // Duración del vuelo

// System.out.println("Hora de llegada en Madrid: " + zonaMadrid);
// Salida: 2026-09-24T02:45+02:00


// * --------------------------------------------------
// * FORMATEAR ZONAS HORARIAS
// * --------------------------------------------------

// DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd - MMM - yyyy | hh:mm:ss a");

// System.out.println("Detalles del viaje a España:");
// System.out.println("Partida de NY: " + formato.format(zonaNY));
// System.out.println("Llegada Madrid: " + formato.format(zonaMadrid));


// * --------------------------------------------------
// * LISTAR TODAS LAS ZONAS DISPONIBLES
// * --------------------------------------------------

// → Forma 1: Guardar en Set
// Set<String> zonas = ZoneId.getAvailableZoneIds();
// zonas.forEach(System.out::println);

// → Forma 2: Directamente (más concisa)
// ZoneId.getAvailableZoneIds().forEach(System.out::println);

// ? Ejemplos de zonas:
// ? "America/New_York"
// ? "Europe/Madrid"
// ? "America/Bogota"
// ? "Asia/Tokyo"


// * =====================================================
// * 📝 PATRONES DE FORMATO COMUNES
// * =====================================================

// ? Para FECHAS:
// ? yyyy = Año completo (2026)
// ? MM   = Mes con 2 dígitos (02)
// ? MMM  = Mes abreviado (Feb)
// ? MMMM = Mes completo (February)
// ? dd   = Día con 2 dígitos (04)
// ? E    = Día de semana abreviado (Thu)
// ? EEEE = Día de semana completo (Thursday)

// ? Para HORAS:
// ? HH   = Hora 24h (14)
// ? hh   = Hora 12h (02)
// ? mm   = Minutos (35)
// ? ss   = Segundos (22)
// ? a    = AM/PM

// ? Ejemplos completos:
// ? "yyyy-MM-dd"              -> 2026-02-06
// ? "dd/MM/yyyy"              -> 06/02/2026
// ? "EEEE, dd MMMM yyyy"      -> Thursday, 06 February 2026
// ? "HH:mm:ss"                -> 14:35:22
// ? "hh:mm a"                 -> 02:35 PM
// ? "yyyy/MM/dd hh:mm:ss a"   -> 2026/02/06 02:35:22 PM


// * =====================================================
// * ✅ RESUMEN RÁPIDO (PARA MEMORIZAR)
// * =====================================================

// LocalDate      -> Solo fecha (cumpleaños, eventos)
// LocalTime      -> Solo hora (alarmas, horarios)
// LocalDateTime  -> Fecha + hora (logs, timestamps)
// Duration       -> Diferencia entre horas (¿cuánto tardó?)
// Period         -> Diferencia entre fechas (¿cuántos años?)
// Instant        -> Punto exacto (medir performance)
// ZonedDateTime  -> Con zona horaria (vuelos, eventos globales)


// ! =====================================================
// ! ⚠️ CONCEPTOS CLAVE QUE DEBES RECORDAR
// ! =====================================================

// 1. INMUTABILIDAD:
//    Todos los objetos de java.time son INMUTABLES
//    Los métodos SIEMPRE devuelven nuevas instancias
//    
//    LocalDate fecha = LocalDate.now();
//    fecha.plusDays(1);  // ❌ Esto NO modifica 'fecha'
//    
//    LocalDate mañana = fecha.plusDays(1);  // ✅ Correcto

// 2. LOCALE OBSOLETO:
//    new Locale("es", "ES") está @Deprecated desde Java 19
//    Usar: Locale.forLanguageTag("es-CO")

// 3. DURATION vs PERIOD:
//    Duration → Horas, minutos, segundos (tiempo preciso)
//    Period   → Años, meses, días (tiempo calendario)

// 4. FORMATO DE HORAS:
//    HH = 24 horas (00-23)
//    hh = 12 horas (01-12) + necesitas 'a' para AM/PM

// 5. PARSING:
//    LocalDate.parse() espera "yyyy-MM-dd"
//    LocalTime.parse() espera "HH:mm" o "HH:mm:ss"
//    LocalDateTime.parse() espera "yyyy-MM-ddTHH:mm:ss"
//    
//    Para formatos custom usa:
//    .parse(texto, DateTimeFormatter.ofPattern("tu-formato"))


// ? =====================================================
// ? 🎯 CASOS DE USO COMUNES
// ? =====================================================

// ¿Calcular edad de una persona?
// → LocalDate + Period

// ¿Registrar cuando algo sucedió?
// → LocalDateTime o Instant

// ¿Medir cuánto tarda un proceso?
// → Instant + Duration

// ¿Agendar reunión internacional?
// → ZonedDateTime

// ¿Calcular fecha de vencimiento?
// → LocalDate + plusDays/plusMonths

// ¿Horario de apertura de tienda?
// → LocalTime


// * =====================================================
// * 🔗 RECURSOS ADICIONALES
// * =====================================================
// * Documentación oficial:
// * https://docs.oracle.com/javase/8/docs/api/java/time/package-summary.html
// * 
// * ¡Practica con ejemplos reales para dominar el tema!
// * =====================================================