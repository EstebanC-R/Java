package co.esteban.hilos.ejerciciospropios.aprendizajeadquirido.ejerciciospracticos.finalproyect;


import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


public class ProyectoFinal {
    public static void main(String[] args) throws InterruptedException {
        List<Pedido> listPedidos = new CopyOnWriteArrayList<>();

        SistemaPedidos pedidos = new SistemaPedidos();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

        for(int i = 0; i < 20; i++){
            executor.submit(() -> {
                try {
                    Pedido p = new Pedido();
                    pedidos.procesarPedido(p);
                    listPedidos.add(p);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();

        while(!executor.isTerminated()){
            System.out.println("------- Estado -------");
            System.out.println("Pedidos procesados: " + pedidos.getPedidosProcesados());
            System.out.println("Completados: " + executor.getCompletedTaskCount());

            Thread.sleep(2000);
        }
        System.out.println("\n---------- Lista de Compras --------");

        listPedidos.sort(Comparator.comparing(Pedido::getId));

        for(Pedido p : listPedidos){
            System.out.println("ID: " + p.getId());
            System.out.println("Producto: " + p.getProducto());
            System.out.println("------------------------------");
        }

    }
}
