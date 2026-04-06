import java.lang.reflect.Method;

public class EjemploMetodoGetClass {
    static void main() {
        String texto = "Hola que tal!!";
        
        Class strClass = texto.getClass();
        System.out.println("strClass.getName() = " + strClass.getName());
        System.out.println("strClass.getSimpleName() = " + strClass.getSimpleName());
        System.out.println("strClass.getPackageName() = " + strClass.getPackageName());
        System.out.println("strClass = " + strClass);
        
        for(Method metodos : strClass.getMethods()){
            System.out.println("metodos.getName() = " + metodos.getName());
        }
        // ? ------------------------------------------------------------------------------
        Integer num = 34;
        Class intClass = num.getClass();
        Class objClass = intClass.getSuperclass().getSuperclass();

        System.out.println("intClass = " + intClass.getSuperclass());
        System.out.println("objClass = " + objClass);

        for(Method metodos : objClass.getMethods()){
            System.out.println("metodos.getName() = " + metodos.getName());
        }
    }
}
