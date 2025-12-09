package EJERCICIOS_MES_2.Semana06_cajero_automatico_con_validaciones_y_control_de_errores;

import java.util.Scanner;

public class Menu {
    public static void menu(Scanner rl, GetorCuentas gestor) {
        while(true){
            System.out.println("\n------------ Menu ------------");
            System.out.println("------LOGIN -----\n1. - Ingresar.\n2. - Registrar cuenta.\n3. - Salir.\n- Respuesta: ");
            int respuesta = rl.nextInt();
            boolean sesionIniciada = false;
            rl.nextLine();
            switch (respuesta){
                case 1:
                    System.out.println("Ingresa tu nombre: ");
                    String nombre = rl.nextLine();
                    Validaciones.validarTexto(nombre);

                    System.out.println("Ingresa tu código de acceso.");
                    String codigoAcceso = rl.nextLine();

                    System.out.println("Ingresa tu cédula: ");
                    long cedula = 0;
                    try{
                        cedula = rl.nextLong();
                        rl.nextLine();
                        Validaciones.revisarCedula(cedula);
                    }catch (Exception e){
                        System.out.println("**ERROR**\n- Mensaje: " + e.getMessage());
                        return;
                    }

                    Cajero usuarioActivo = gestor.autenticarUsuario(cedula, codigoAcceso);
                    sesionIniciada = (usuarioActivo != null);

                    while(sesionIniciada) {
                        System.out.println("----------------------\n1. - Ingresar Saldo.\n2. - Retirar.\n3. - Mostrar saldo.\n4. - Salir de la sesion.\n----------------------\n- Respuesta: ");
                        int respuestaLogin = rl.nextInt();
                        rl.nextLine();
                        switch (respuestaLogin){
                            case 1:
                                System.out.println("Cuanto quieres ingresar a tú cuenta?: ");
                                double precio = 0;
                                try{
                                    precio = Validaciones.validarPrecio(rl);
                                }catch (NumberFormatException e){
                                    System.out.println("**ERROR**\n- Mensaje: " + e.getMessage());
                                    return;
                                }
                                usuarioActivo.ingresarDinero(precio);
                                break;
                            case 2:
                                System.out.println("¿Cuanto quieres retirar?: ");
                                double retirar = 0;
                                try{
                                    retirar = Validaciones.validarPrecio(rl);
                                }catch (NumberFormatException e) {
                                    System.out.println("**ERROR**\n- Mensaje: " + e.getMessage());
                                    return;
                                }

                                System.out.println("Ingresa tu clave: ");
                                String codigo = rl.nextLine();
                                if(usuarioActivo.getCodigoAcceso() == codigo){
                                    usuarioActivo.retirar(retirar, codigo);
                                }
                                break;
                            case 3:
                                usuarioActivo.mostrarSaldo();
                                break;
                            case 4:
                                sesionIniciada = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean datosCorrectos = false;
                    do {
                        System.out.println("Ingresa tu nombre: ");
                        String nombreRegistro = rl.nextLine();

                        System.out.println("Ingresa tu código de acceso: ");
                        String codigoAccesoRegistro = rl.nextLine();

                        System.out.println("Ingresa tu cédula: ");
                        long cedulaRegistro = rl.nextLong();
                        rl.nextLine();
                        System.out.println();
                        try {
                            datosCorrectos = Validaciones.validarTexto(nombreRegistro) && Validaciones.validarClaveSencilla(codigoAccesoRegistro) && Validaciones.revisarCedula(cedulaRegistro) ? true : false;
                        }catch (Exception e){
                            System.out.println("**ERROR**\n- Mensaje: " + e.getMessage());
                            return;
                        }

                        if(datosCorrectos){
                            Cajero userResgiter = new Cajero(nombreRegistro, codigoAccesoRegistro, cedulaRegistro);
                            gestor.agregarCuenta(userResgiter);
                        }else {
                            System.out.println("\n¡Atención! Uno o más datos ingresados son inválidos. Inténtelo de nuevo.\n");
                        }
                    } while (!datosCorrectos);
                    break;
            }
        }
    }
}
