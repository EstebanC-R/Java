package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos.finalproyect;

import java.util.concurrent.atomic.AtomicInteger;

public class SistemaPedidos {
    private AtomicInteger pedidosProcesados = new AtomicInteger(0);

    public void procesarPedido(Pedido pedido) throws InterruptedException{
        System.out.println("Procesando pedido #" + pedido.getId() + " - " + pedido.getProducto());
        Thread.sleep((int)(Math.random() * 2000) + 1000);
        pedidosProcesados.incrementAndGet();
        System.out.println("✅ Pedido #" + pedido.getId() + " completado");
    }

    public int getPedidosProcesados(){
        return pedidosProcesados.get();
    }
}
