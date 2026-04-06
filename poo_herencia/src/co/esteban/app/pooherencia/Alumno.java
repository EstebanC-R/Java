package co.esteban.app.pooherencia;

public class Alumno extends Persona {

    private String institucion;
    private double notaMatematica;
    private double notaSpanish;
    private double notaHistoria;

    public Alumno(){
        System.out.println("Alumno: inicializando constructor...");
    }

    public Alumno(String nombre, String apellido){
        super(nombre, apellido);
    }

    public Alumno(String nombre, String apellido, int edad){
        super(nombre, apellido, edad);
    }

    public Alumno(String nombre, String apellido, int edad, String institucion){
        // $ Si ponemos this. en vez de super también va a
        // $ funcionar debido a que son lo mismo o apuntan a la misma partre
        super(nombre, apellido, edad);
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion, double notaMatematica, double notaSpanish, double notaHistoria){
        this(nombre, apellido, edad, institucion);
        this.notaMatematica = notaMatematica;
        this.notaSpanish = notaSpanish;
        this.notaHistoria = notaHistoria;
    }


    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaSpanish() {
        return notaSpanish;
    }

    public void setNotaSpanish(double notaSpanish) {
        this.notaSpanish = notaSpanish;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }


    @Override
    public String saludar(){
        String saludar = super.saludar();
        return saludar + " soy alumno y mi nombre es " + getNombre();
    }

    public double calcularPromedio(){
        System.out.println("Calcular Promedio " + Alumno.class.getCanonicalName());
        return (notaHistoria + notaSpanish + notaMatematica) / 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- institución='" + institucion + '\'' +
                "\n- notaMatematica=" + notaMatematica +
                "\n- notaSpanish=" + notaSpanish +
                "\n- notaHistoria=" + notaHistoria +
                "\n- promedio = " + calcularPromedio()
                ;
    }
}
