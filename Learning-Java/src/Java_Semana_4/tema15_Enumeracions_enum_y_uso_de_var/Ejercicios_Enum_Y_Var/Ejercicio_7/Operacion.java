package Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_7;

public enum Operacion {
    SUMA("+", "Suma") {
        @Override
        public double calcular(double a, double b) {
            return a + b;
        }
    },
    RESTA("-", "Resta") {
        @Override
        public double calcular(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICACION("*", "Multiplicación") {
        @Override
        public double calcular(double a, double b) {
            return a * b;
        }
    },
    DIVISION("/", "División") {
        @Override
        public double calcular(double a, double b) {
            if (b == 0) {
                System.out.println("⚠️ No se puede dividir entre cero.");
                return Double.NaN;
            }
            return a / b;
        }
    };

    private final String sign;
    private final String metodo;

    Operacion(String sign, String metodo) {
        this.sign = sign;
        this.metodo = metodo;
    }

    public String getSign() {
        return sign;
    }

    public String getMetodo() {
        return metodo;
    }

    // Metodo abstracto que cada constante implementa a su manera
    public abstract double calcular(double a, double b);
}
