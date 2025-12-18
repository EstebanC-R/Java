public class ArgumentosLineaComandoCalculadora {
    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("Por favor ingresar una operación " +
                    "(suma, resta, multiplicación o división) y 2 números enteros.");
            System.exit(-1);
        }

        String operacion = args[0];
        int a = 0;
        int b =0;
        try{
            a = Integer.parseInt(args[1]);
            b = Integer.parseInt(args[2]);
        }catch (NumberFormatException e){
            System.out.println("Mensaje: " + e.getMessage());
            System.exit(-1);
        }

        double resultado = 0.00;

        switch (operacion){
            case "suma":
                resultado = a+b;
                break;
            case "resta":
                resultado = a-b;
                break;
            case "multiplicación":
                resultado = a*b;
                break;
            case "division":
                if(a == 0){
                    System.out.println("No se puede dividir por cero");
                    System.exit(-1);
                }
                resultado = (double) a/b;
                break;
            default:
                resultado = a+b;
        }

        System.out.println("Resultado de la operación es '" + operacion + "' es = " + resultado);
    }
}
