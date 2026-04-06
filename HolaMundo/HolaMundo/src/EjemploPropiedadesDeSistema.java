import java.util.Properties;

public class EjemploPropiedadesDeSistema {
    static void main() {
        String username = System.getProperty("user.name");
        System.out.println("username = " + username);

        String home = System.getProperty("user.home");
        System.out.println("home = " + home);
        
        String workSpace = System.getProperty("user.dir");
        System.out.println("workSpace = " + workSpace);

        String java = System.getProperty("java.version");
        System.out.println("java = " + java);

        String lineSeparator = System.getProperty("line.separator");
        String lineSeparator2 = System.lineSeparator();
        System.out.println("LineSeparator: " + lineSeparator2 + "Una línea nueva...");

        Properties p = System.getProperties();
        p.list(System.out);
    }
}
