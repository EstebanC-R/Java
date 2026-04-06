package co.estebanpoointerfaces.imprenta;

import co.estebanpoointerfaces.imprenta.modelo.*;
import static co.estebanpoointerfaces.imprenta.modelo.Genero.*;
import static co.estebanpoointerfaces.imprenta.modelo.Imprimible.*;

public class EjemploImprenta {
    public static void main(String[] args) {
        /*
            % ===========================================================
            % RESUMEN: Clases Abstractas vs Interfaces en Java
            % ===========================================================

            $ 1. CLASE ABSTRACTA
            * - Puede tener atributos (ej: protected String contenido).
            * - Puede tener constructores (para inicializar atributos).
            * - Puede tener métodos abstractos (sin implementación) y métodos con implementación.
            * - Se usa cuando hay una relación lógica fuerte entre las clases hijas.
            * - Ejemplo: Hoja → Curriculo, Informe, Pagina.

            $ 2. INTERFACE
            * - No tiene atributos de instancia (solo constantes public static final).
            * - No tiene constructores.
            * - Define únicamente un contrato (qué métodos deben existir).
            * - Se usa cuando cualquier clase, sin importar su jerarquía, debe cumplir ese contrato.
            * - Ejemplo: Imprimible → Curriculo, Informe, Pagina, Libro.

            $ 3. POR QUÉ USAR AMBAS
            * - Hoja (abstracta): agrupa atributos y lógica común para tipos de hoja.
            * - Imprimible (interface): permite que otros objetos (como Libro) también sean imprimibles,
            * aunque no sean hojas.

            $ 4. ANALOGÍA
            ? - Clase abstracta → Un molde parcial: trae atributos y parte de la lógica, obliga a completar lo que falta.
            ! - Interface → Un contrato: “Si quieres ser considerado Imprimible, debes implementar este método”.

            $ 5. APLICACIÓN EN EL EJEMPLO
            ? - Curriculo, Informe, Pagina → Son hojas, heredan de Hoja y cumplen el contrato imprimir().
            ! - Libro → No es una hoja, pero sí necesita ser imprimible. Implementa directamente la interface Imprimible.

            $ 6. CONCLUSIÓN
            ? - Clases abstractas: comparten atributos y lógica común entre clases con relación fuerte.
            ! - Interfaces: definen contratos flexibles que cualquier clase puede implementar.
            * - En este diseño:
                # - Hoja = base común para documentos tipo hoja.
                # - Imprimible = contrato general para todo lo que pueda imprimirse.
                # - Libro demuestra la utilidad de la interface, porque no necesita heredar de Hoja para ser imprimible.

            $ IDEA CLAVE:
            % "Las clases abstractas son moldes con atributos y lógica común;
            % las interfaces son contratos flexibles que cualquier clase puede firmar."
            %===========================================================
            */


        Curriculo cv = new Curriculo(new Persona("Milton", "Castaño"), "Programador", "Resumen laboral...");
        cv.addExperiencia("Java")
                .addExperiencia("Oracle DBA")
                .addExperiencia("Spring Framework")
                .addExperiencia("Desarrollador fullstack")
                .addExperiencia("Angular");

        Libro libro = new Libro(new Persona("Milton", "Castaño"), "Cuervos en el Cielo", LITERATURA);
        libro.addPagina(new Pagina("El comienzo."))
                .addPagina(new Pagina("Saliendo a flote"))
                .addPagina(new Pagina("Lo que siempre soñe"))
                .addPagina(new Pagina("Todo pasa por algo"));

        Informe informe = new Informe(new Persona("Milton", "Castaño"), new Persona("Yeison", "Soto"), "Estudio sobre microservicios");
        imprimir(cv);
        imprimir(informe);
        imprimir(libro);

        imprimir(new Imprimible() {
            @Override
            public String imprimir() {
                return "Hola que tal, imprimiendo un objeto genérico de una clase anónima!";
            }
        });

        System.out.println(TEXTO_DEFECTO);
    }


}
