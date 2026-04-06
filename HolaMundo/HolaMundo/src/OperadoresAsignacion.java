public class OperadoresAsignacion {
    static void main(String[] args) {
        int i = 5;
        int k = i + 4;
        System.out.println("i = " + i);
        System.out.println("k = " + k);

        i += 2; // i = i + 2

        i += 5; // i = i + 5
        System.out.println("i = " + i);
        
        k -= 4; // k = k - 4
        System.out.println("k = " + k);

        k *= 3; // k = k * 3;
        System.out.println("k = " + k);

        String sqlString = "SELECT * FROM clientes as c";
        sqlString += " where c.nombre = 'Milton'";
        sqlString += " and c.activo=1";
        System.out.println("sqlString = " + sqlString);
    }
}
