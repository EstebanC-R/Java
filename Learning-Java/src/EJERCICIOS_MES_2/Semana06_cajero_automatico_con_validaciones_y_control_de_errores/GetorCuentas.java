package EJERCICIOS_MES_2.Semana06_cajero_automatico_con_validaciones_y_control_de_errores;

import java.util.ArrayList;

public class GetorCuentas {
    private ArrayList<Cajero> cuentas;

    public GetorCuentas(){
        this.cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cajero nuevaCuenta){
        this.cuentas.add(nuevaCuenta);
        System.out.println("\nCuenta registrada exitosamente!! Bienvenid@ " + nuevaCuenta.getNombre());
    }

    public Cajero buscarCuentaPorCedula(long cedula) {
        for (Cajero cuenta : cuentas) {
            if (cuenta.getCedula() == cedula) {
                System.out.println("\nCargando datos...");
                return cuenta;
            }
        }
        System.out.println("Cuanta no encontrada :(");
        return null;
    }

    public Cajero autenticarUsuario(long cedula, String codigoIngresado) {
        Cajero cuentaEncontrada = buscarCuentaPorCedula(cedula);

        if (cuentaEncontrada == null) {
            return null;
        }

        if (cuentaEncontrada.getCodigoAcceso().equals(codigoIngresado)) {
            return cuentaEncontrada;
        } else {
            System.out.println("Código de acceso incorrecto.");
            return null;
        }
    }
}
