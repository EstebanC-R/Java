public class EjemploEjecutarSO {
    static void main() {
        Runtime rt = Runtime.getRuntime();
        Process proceso;

        try {
            if(System.getProperty("os.name").toLowerCase().startsWith("windows")){
                proceso = rt.exec("notepad");
                proceso = rt.exec("cmd /c start steam://rungameid/367520");
            } else if (System.getProperty("os.name").toLowerCase().startsWith("mac")){
                proceso = rt.exec("textedit");
            } else if (System.getProperty("os.name").toLowerCase().contains("nux") || System.getProperty("os.name").toLowerCase().contains("nix")){
                proceso = rt.exec("gedit");
            } else {
                proceso = rt.exec("gedit");
            }
            proceso.waitFor();
        }catch (Exception e){
            System.err.println("Mensaje = " + e.getMessage());
            System.exit(1);
        }

        System.out.println("Se ha cerrado el editor");
        System.exit(0);

    }
}
