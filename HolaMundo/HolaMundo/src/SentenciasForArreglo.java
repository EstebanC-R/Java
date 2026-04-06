import javax.swing.*;

public class SentenciasForArreglo {
    static void main() {
        String[] nombres = {"Milton", "Pepe", "Mateo", "Yeison", "Yony", "Daniel"};

        int count = nombres.length;

        for(var i = 0; i < count; i++){
            if(nombres[i].equalsIgnoreCase("milton") || nombres[i].equalsIgnoreCase("daniel")){
                continue;
            }
            System.out.println(i + ".- " + nombres[i]);
        }

        String buscar = JOptionPane.showInputDialog("Ingrese un nombre, ejemplo \"Pepe\" o \"Maria\": ");
        System.out.println("Buscar = " + buscar);

        boolean encontrado = false;
        for(int i = 0; i < count; i++){
            if(nombres[i].equalsIgnoreCase(buscar)){
                encontrado = true;
                break;
            }
        }

        if(encontrado){
            JOptionPane.showMessageDialog(null, "Se ha encontrado la búsqueda!!\n" + buscar);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha encontrado!!");
        }
    }
}
