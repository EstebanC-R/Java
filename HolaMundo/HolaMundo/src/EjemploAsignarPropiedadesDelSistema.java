import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EjemploAsignarPropiedadesDelSistema {
    static void main() {
        try {
            FileInputStream archivo = new FileInputStream("src/config.properties");


            Properties p = new Properties(System.getProperties());
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada", "Mi valor guardado en el objeto properties");
            System.setProperties(p);


            Properties ps = System.getProperties();
            System.out.println("ps.getProperty(...) = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("config.puerto.servidor"));
            System.out.println(System.getProperty("config.texto.ambiente"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.autor.email"));
            ps.list(System.out);
        }catch (FileNotFoundException e){
            System.err.println("Mensaje: " + e.getMessage());
            System.exit(1);
        }catch (IOException e){
            System.err.println("Mensaje: " + e.getMessage());
            System.exit(1);
        }

    }
}
