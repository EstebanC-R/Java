package co.esteba.pruebas.nivel3;

import co.esteba.pruebas.nivel3.models.Venta;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Venta> ventas = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        String[] vendedores = {"Milton", "Yeison", "Daniel", "Mateo", "Yony"};
        String[] productos = {"Laptop", "Mouse", "Teclado", "Monitor",
                "Auriculares", "RTX 5600", "Mouse Pad", "Mesa Gamer"};

        // ===============================
        // GENERAR VENTAS
        // ===============================
        // $ Básicamente lo único que se esta haciendo es ingresar un producto aleatorio de la
        // $ lista, despues lo que se esta haciendo es poner la cantidad (También es aleatoria cantidad = 0 y 9 + 1), el
        // $ precio (También es aleatoria precio = entre 0 y 89000 + 1000) y una fecha aleatoria
        // $ auto generada apartir del día de hoy, esto significa que puede caer una fecha entre
        // $ el 4 de febrero hasta randomizando 90 días hacia atras.
        // $ al igual que con procuto el vendedor también es aleatorio de una lista de vendedores.
        //
        // * Puede ser new Venta("Laptop", 3, 56333, "2025-12-30", "Milton");

        for (int i = 0; i < 30; i++) {
            LocalDate fechaAleatoria = hoy.minusDays((int) (Math.random() * 90));
            String vendedor = vendedores[(int) (Math.random() * vendedores.length)];
            String producto = productos[(int) (Math.random() * productos.length)];
            int cantidad = (int) (Math.random() * 10) + 1;
            double precio = 10 + Math.random() * 6000;

            ventas.add(new Venta(producto, cantidad, precio, fechaAleatoria, vendedor));
        }

        // ===============================
        // MATRIZ 3D
        // ===============================

        // % Aquí lo que estamos haciendo es crear una matriz 3D la cual
        // % para ponerlo de una forma sencilla es como un almanaque el cual puedes
        // % pasar de hoja y por ende pasas de mes, es como [capa - hoja] primer corchete una "capas"
        // % la segunda [filas] filas del mes y la ultima son las columnas [columnas].
        // ! En este caso es 3 meses 30 días y 5 vendedores.

        double[][][] ventasPorDia = new double[3][30][5];

        // ? Se ingresa a la lista de ventas.
        for (Venta v : ventas) {

            // ? Se mira la diferencia de meses contando desde el día 1.
            // ? ejemplo: fecha 1 = "2025-12-1" y fecha 2 = "2026-2-1" la diferencia es de 2 meses.
            long diffMeses = ChronoUnit.MONTHS.between( v.getFecha().withDayOfMonth(1), hoy.withDayOfMonth(1));

            // ? Se esta validando si la diferencia de meses si es mayor o igual a cero
            // # ya que 0 = mes actual, 1 = mes anterior y 2 = hace 2 meses.
            if (diffMeses >= 0 && diffMeses < 3) {

                // ? diffMeses nos dice cuántos meses atrás está la venta respecto al mes actual:
                // ? 0 = mes actual, 1 = mes anterior, 2 = hace dos meses.
                //
                // ? Nuestra matriz está organizada al revés:
                // ? índice 0 = hace dos meses, índice 1 = mes anterior, índice 2 = mes actual.
                //
                // ? Por eso usamos (2 - diffMeses) para invertir el orden:
                // ? diffMeses = 0 → mesIndex = 2 (mes actual)
                // ? diffMeses = 1 → mesIndex = 1 (mes anterior)
                // ? diffMeses = 2 → mesIndex = 0 (hace dos meses)

                int mesIndex = (int) (2 - diffMeses);

                // ? El día del mes va de 1 a 31, pero los arrays empiezan en 0.
                // ? Restamos 1 para que el día 1 se guarde en la posición 0,
                // ? el día 2 en la posición 1, … y el día 31 en la posición 30.

                int diaIndex = v.getFecha().getDayOfMonth() - 1;

                // $ Aquí lo que pasa es que volvemos los vendedores de un Array
                // $ a una lista y por ello podemos acceder a sus métodos, utilizamos
                // $ indexOf del vendedor actual sobre el que estamos iterando y así
                // $ lo ubicamos en la lista.

                int vendedorIndex = Arrays.asList(vendedores).indexOf(v.getVendedor());

                // % Validamos dos cosas antes de acumular:
                // ? 1. Que el día no supere el tamaño de la matriz (máx. 31 → índice 0–30).
                // ?    Así evitamos un ArrayIndexOutOfBounds si llegara una fecha fuera de rango.
                // ? 2. Que el vendedor exista en la lista (indexOf devuelve -1 si no lo encuentra).
                // ?    Si es -1, significa que el vendedor no está en el array y no debemos usarlo.


                if (diaIndex < 30 && vendedorIndex >= 0) {
                    // ! Nota: si varias ventas ocurren el mismo día y para el mismo vendedor,
                    // ! no se sobrescribe el valor en la matriz ni se produce error.
                    // ! En lugar de eso, el monto se acumula con +=
                    // ! Ejemplo: dos ventas el día 12 para "Daniel" se suman en la misma celda.
                    // ! Así, ventasPorDia[mesIndex][diaIndex][vendedorIndex] guarda el total
                    // ! de ingresos de ese día y vendedor, no solo una venta.

                    ventasPorDia[mesIndex][diaIndex][vendedorIndex] += v.getIngreso();
                }
            }
        }

        // ===============================
        // A) ANALISIS POR FECHA
        // ===============================

        System.out.println("\n======================\n\tVENTAS POR MES \n======================");


        // # Aquí usamos el método collect() del Stream, que sirve para transformar
        // # la secuencia de ventas en una estructura de datos final (en este caso un Map).
        //
        // # Dentro de collect() invocamos a Collectors.groupingBy(), que agrupa los elementos
        // # según una clave (key) que nosotros definimos. En este caso la clave es el número
        // # del mes de la fecha de la venta (v.getFecha().getMonthValue()).
        //
        // # Luego definimos el valor (value) que queremos asociar a cada clave.
        // # Para eso usamos Collectors.summingDouble(Venta::getIngreso), que suma todos
        // # los ingresos de las ventas que caen en el mismo mes.
        //
        // % Resultado: obtenemos un Map<Integer, Double> donde:
        // % - La clave (Integer) es el mes (1 = enero, 2 = febrero, ...).
        // % - El valor (Double) es el total de ingresos acumulados en ese mes.
        //
        // ! Ejemplo: si en enero hubo ventas de 5000 y 3000, el Map tendrá {1 = 8000.0}.
        Map<Integer, Double> ventasPorMes = ventas.stream()
                .collect(Collectors.groupingBy(v -> v.getFecha().getMonthValue(), Collectors.summingDouble(Venta::getIngreso)));

        // $ Al no estar completo el mes actual (febrero o el que sea) este toma 90 días hacia atras por ello puede aparecer un 4 mes.
        ventasPorMes.forEach((mes, total) ->
                System.out.printf("%-5s %d : %.0f\n", "Mes", mes, total));

        // Día con mayores ingresos
        Map<LocalDate, Double> ventasPorDiaStream = ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getFecha,
                        Collectors.summingDouble(Venta::getIngreso)
                ));

        // % entrySet() convierte el Map en un conjunto de pares clave-valor.
        // % Al pasarlo a stream(), podemos aplicar operaciones funcionales.
        // % max(Map.Entry.comparingByValue()) busca el par con el mayor valor.
        // % El resultado es un Optional, por eso usamos ifPresent():
        // % ejecuta el bloque solo si existe un valor (evita null).

        ventasPorDiaStream.entrySet().stream().max(Map.Entry.comparingByValue())
                .ifPresent(e ->
                        System.out.println("\nMejor día: " + e.getKey() + " = " + e.getValue()));

        // ? Avarage = promedio.
        // ? Aquí lo unico que se hace es transformar los valores a double, osea solo toma esos valores.
        // ? y al ser optional se tiene que manejar un posible NullPointerException por lo que orElse lo
        // ? maneja con un 0.
        // Promedio diario
        double promedioDiario = ventasPorDiaStream.values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        System.out.printf("%-6s : %.2f\n", "Promedio diario", promedioDiario);

        // Último mes vs mes anterior
        int mesActual = hoy.getMonthValue();
        int mesAnterior = hoy.minusMonths(1).getMonthValue();

        // ! getOrDefault es un método de Map<K,V>.
        // ! Devuelve el valor asociado a la clave si existe,
        // ! y si no existe devuelve el valor por defecto que le pasemos.
        // ! Aquí lo usamos para evitar null cuando un mes no tiene ventas.
        // ! Luego calculamos el porcentaje de variación entre el mes actual y el anterior.

        double totalActual = ventasPorMes.getOrDefault(mesActual, 0.0);
        double totalAnterior = ventasPorMes.getOrDefault(mesAnterior, 0.0);

        if (totalAnterior > 0) {
            double cambio = ((totalActual - totalAnterior) / totalAnterior) * 100;

            if (cambio > 0) {
                System.out.printf("El último mes (%s) fue %.2f%% más rentable que el mes anterior (%s).\n",
                        Month.of(mesActual), cambio, Month.of(mesAnterior));
            } else if (cambio < 0) {
                System.out.printf("El último mes (%s) fue %.2f%% menos rentable que el mes anterior (%s).\n",
                        Month.of(mesActual), Math.abs(cambio), Month.of(mesAnterior));
            } else {
                System.out.printf("El último mes (%s) tuvo exactamente el mismo nivel de ventas que el mes anterior (%s).\n",
                        Month.of(mesActual), Month.of(mesAnterior));
            }
        }


        // ===============================
        // B) POR VENDEDOR
        // ===============================

        Map<String, Double> ingresosPorVendedor = ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getVendedor,
                        Collectors.summingDouble(Venta::getIngreso)
                ));

        System.out.println("\n========================\n\tTOP 3 VENDEDORES \n========================");

        ingresosPorVendedor.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n==========================================\n\tVENDEDOR CON MÁS VENTAS (cantidad) \n==========================================");

        ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getVendedor,
                        Collectors.summingInt(Venta::getCantidad)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        System.out.println("\n======================\n\tCOMISIONES 5% \n======================");

        ingresosPorVendedor.forEach((vendedor, total) ->
                System.out.println(vendedor + " -> " + total * 0.05));

        // ===============================
        // C) POR PRODUCTO
        // ===============================

        System.out.println("\n============================\n\tPRODUCTO MÁS VENDIDO \n============================");

        ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getProducto,
                        Collectors.summingInt(Venta::getCantidad)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        System.out.println("\n===================================\n\tPRODUCTO CON MÁS INGRESOS \n===================================");

        ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getProducto,
                        Collectors.summingDouble(Venta::getIngreso)
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);

        // Productos que no se vendieron el último mes
        LocalDate inicioUltimoMes = hoy.minusMonths(1).withDayOfMonth(1);
        LocalDate finUltimoMes = inicioUltimoMes.plusMonths(1).minusDays(1);

        Set<String> vendidosUltimoMes = ventas.stream()
                .filter(v -> !v.getFecha().isBefore(inicioUltimoMes) &&
                        !v.getFecha().isAfter(finUltimoMes))
                .map(Venta::getProducto)
                .collect(Collectors.toSet());

        System.out.println("\n============================================\n\tPRODUCTOS NO VENDIDOS EL ULTIMO MES \n============================================");

        Arrays.stream(productos)
                .filter(p -> !vendidosUltimoMes.contains(p))
                .forEach(System.out::println);

        // ===============================
        // D) ESTADISTICAS
        // ===============================

        DoubleSummaryStatistics stats = ventas.stream()
                .collect(Collectors.summarizingDouble(Venta::getPrecio));

        System.out.println("\n============================\n\tESTADISTICAS PRECIOS \n============================");
        System.out.println(stats);

        // Desviación estándar de ventas diarias
        List<Double> totalesDiarios = new ArrayList<>(ventasPorDiaStream.values());

        double promedio = totalesDiarios.stream().mapToDouble(Double::doubleValue).average().orElse(0);

        double varianza = totalesDiarios.stream()
                .mapToDouble(v -> Math.pow(v - promedio, 2))
                .average()
                .orElse(0);

        double desviacion = Math.sqrt(varianza);

        System.out.println("Desviación estándar diaria: " + desviacion);

        // Tendencia
        List<Venta> ordenadas = ventas.stream()
                .sorted(Comparator.comparing(Venta::getFecha))
                .toList();

        if (ordenadas.get(ordenadas.size() - 1).getIngreso() >
                ordenadas.get(0).getIngreso()) {
            System.out.println("Tendencia: SUBIENDO");
        } else {
            System.out.println("Tendencia: BAJANDO");
        }

        // ===============================
        // MATRIZ A STREAM
        // ===============================

        double totalMatriz = Arrays.stream(ventasPorDia)
                .flatMap(mes -> Arrays.stream(mes))
                .flatMapToDouble(dia -> Arrays.stream(dia))
                .sum();

        System.out.println("\nTOTAL MATRIZ: " + totalMatriz);

        // Mejor rendimiento en matriz
        double max = 0;
        int mejorMes = 0, mejorDia = 0, mejorVendedor = 0;

        for (int m = 0; m < 3; m++) {
            for (int d = 0; d < 30; d++) {
                for (int v = 0; v < 5; v++) {
                    if (ventasPorDia[m][d][v] > max) {
                        max = ventasPorDia[m][d][v];
                        mejorMes = m;
                        mejorDia = d;
                        mejorVendedor = v;
                    }
                }
            }
        }

        System.out.println("Mejor rendimiento matriz -> Mes: " +
                mejorMes + " Día: " + (mejorDia + 1) +
                " Vendedor: " + vendedores[mejorVendedor] +
                " Total: " + max);

        // ===============================
        // VALIDACION LOOP VS STREAM
        // ===============================

        double totalLoop = 0;
        for (Venta v : ventas) {
            totalLoop += v.getIngreso();
        }

        double totalStream = ventas.stream()
                .mapToDouble(Venta::getIngreso)
                .sum();

        System.out.println("\nValidación Loop: " + totalLoop);
        System.out.println("Validación Stream: " + totalStream);

        // ChronoUnit.DAYS ejemplo
        long diasEntre = ChronoUnit.DAYS.between(
                ventas.get(0).getFecha(),
                hoy
        );

        System.out.println("\nDias desde primera venta hasta hoy: " + diasEntre);
    }
}
