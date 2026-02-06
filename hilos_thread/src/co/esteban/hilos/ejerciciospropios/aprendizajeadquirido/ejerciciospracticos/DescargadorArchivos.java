package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DescargadorArchivos {

    static void descargarArchivo(String nombre){
        System.out.println("Iniciando la descarga del archivo " + nombre);

        try{
            TimeUnit.SECONDS.sleep((int)(Math.random() * 5));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("✅ " + nombre + " descargado.");
    }

    public static void main(String[] args) throws Exception{
        String[] archivos = {
                "image1.jpg", "video.mp4", "documento.pdf", "audio.mp3", "presentacion.pptx"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> {
            for(int i = 0; i < archivos.length; i++) {
                descargarArchivo(archivos[i]);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        executor.shutdown();
        executor.awaitTermination(21, TimeUnit.SECONDS);
        System.out.println("\nSe han completado todas las descargar 🎉");
    }
}
