public class Automovil implements Comparable<Automovil>{

    private int id;
    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS;
    private Motor motor;
    private Tanque tanque;
    private Persona conductor;
    private Rueda[] ruedas;
    private int indiceRuedas = 0;

    private TipoAutomovil tipo;

    // * Para aclarar el static es propio de la clase y no del objeto, esto quiere decir que cualquier instancia de
    // * Automovil va a tener el colorPatente ya definido y no se podrá cambiar para uno en específico.
    

    // # Es importante mencionar que los statics no pueden trabajar con un atributo/objeto de la clase ya que como se mencionó
    // # este hace parte directamente de la clase y no sería acorde a su jerarquía por asi decirlo, entonces estos solo pueden
    // # trabajar con otros de su mismo método, como por ejemplo capacidadTanqueEstatico, este en el método que se le creó

    // $ calcularConsumoEstatico, Es el mismo a calcularConsumo, pero si se hace la prueba de intentarlo con el atributo normal llamado
    /* $ capacidadTanque no va a funcionar y dirá algo como */ // # 'capacidadTanque' cannot be referenced from a static context
    // ! O lo que se traduciría a que un contexto estático no puede referenciarse con otro del tipo Atributo

    private static Color colorPatente = Color.NARANJA;
    private static int capacidadTanqueEstatico = 30;
    private static int ultimoId;

    // ? Aquí lo que vemos es que básicamente el final puede ir en cualquier lado, me explico a continuación:
    /* #
        - Da lo mismo public final static
        - qué final public static
        - y por último public static final.

        En realidad son lo mismo, se puede poner donde se desee,
        La explicación de lo que genera esto en el código es tener una variable
        o constante por asi decirlo que nunca va a cambiar, y aunque se intente cambiar
        el mismo JAVA te va a decir que no se puede debido a la naturaleza de este.
    */

    // ? ADEMAS SE LE TIENE QUE PONER UN VALOR SI O SI, YA QUE SE INICIALIZA Y DECLARA.

    public static final Integer VELOCIDAD_MAXIMA_CARRETERA = 120;
    public static final int VELOCIDAD_MAXIMA_EN_CIUDAD = 50;

    public static final String COLOR_ROJO = "Rojo";
    public static final String COLOR_AMARILLO= "Amarillo";
    public static final String COLOR_AZUL = "Azul";
    public static final String COLOR_BLANCO = "Blanco";
    public static final String COLOR_GRIS = "Gris";



    public Automovil(){
        this.id = ++ultimoId;
        this.ruedas = new Rueda[5];
    }

    public Automovil(String fabricante, String modelo){
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color){
        this(fabricante, modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante, modelo, color);
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanque) {
        this(fabricante, modelo, color, motor);
        this.tanque = tanque;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanque, Persona conductor, Rueda[] ruedas) {
        this(fabricante, modelo, color, motor, tanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFabricante(){
        return fabricante;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Tanque getTanque() {
        if(tanque == null){
            this.tanque = new Tanque();
        }
        return tanque;
    }

    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public Automovil addRueda(Rueda rueda){
        if(indiceRuedas < this.ruedas.length){
            this.ruedas[indiceRuedas++] = rueda;
        }
        return this;
    }

    public static int getCapacidadTanqueEstatico() {
        return capacidadTanqueEstatico;
    }

    public static void setCapacidadTanqueEstatico(int capacidadTanqueEstatico) {
        Automovil.capacidadTanqueEstatico = capacidadTanqueEstatico;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    // ! /////////////\\\\\\\\\\\\\\\\\\\\\\\////////////////\\\\\\\\\\\\\\\//////////////\\

    // # Aquí vemos una peculiaridad y es que cualquier método static debe tener sus getter and setters con su
    // # Método static. Al igual que no se puede utilizar this. ya que eso sería para el objeto y al no
    // $ pertenecer al objeto sino a la clase lo que necesita es invocar a su propia clase siendo = Automovil.colorPatente

    public static Color getColorPatente() {
        return colorPatente;
    }

    public static void setColorPatente(Color colorPatente) {
        Automovil.colorPatente = colorPatente;
    }

    /*public void detalle(){
        System.out.printf(" -------------------- %s --------------------\n", this.fabricante);
        System.out.printf("- %-15s : %d\n", "Auto-ID = ", this.id);
        System.out.printf("- %-15s : %s\n", "Modelo", this.modelo);
        System.out.printf("- %-15s : %s\n", "Tipo", this.tipo.getNombre());
        System.out.printf("- %-15s : %s\n", "Color", this.color);
        System.out.printf("- %-15s : %s\n", "Color Patente", colorPatente);
        System.out.printf("- %-15s : %.2f\n\n", "Cilindraje", this.motor.getCilindrada());
    }*/

    // ! Lo mismo que el ver detalle anterior, pero este tiene la diferencia de que es con String directamente.
    public String detalle(){
        String info = "\n ------------------ " + this.fabricante + " ------------------" +
                "\n- Auto-ID : " + this.id +
                "\n- Modelo : " + this.modelo;

        if(this.tipo != null){
            info += "\n- Tipo : " + this.tipo.getDescripcion();
        }

        info += "\n- Color : " + this.color +
                "\n- Color Patente : " + colorPatente;

        if(this.getMotor() != null){
            info += "\n- Cilindraje : " + this.motor.getCilindrada();
        }

        if(conductor != null){
            info += "\nConductor Subaru: " + this.getConductor();
        }

        if(getRuedas() != null){

            info += "\n\n--- Ruedas del automóvil  --- ";

            for(Rueda r: this.getRuedas()){
                info += "\n" + r.getFabricante() + ", Aro: " + r.getAro() + ", Ancho: " + r.getAncho();
            }
        }

        return info;
    }

    public String acelarar(int rpm){
        return "el auto " + fabricante + " acelerando a " + rpm + "rpm";
    }

    public String frenar(){
        return fabricante + " " + modelo + " frenando!";
    }


    public String acelerarFrenar(int rpm){
        String acelerar = this.acelarar(rpm);
        String frenar = this.frenar();

        return acelerar + "\n" + frenar;
    }

    public float calcularConsumo(int km, float porcentajeBencina){
        return km/(this.getTanque().getCapacidad() * porcentajeBencina);
    }

    public float calcularConsumo(int km, int porcentajeBencina){
        return km/(this.getTanque().getCapacidad() * (porcentajeBencina/100f));
    }

    public static float calcularConsumoEstatico(int km, int porcentajeBencina){
        return km/(capacidadTanqueEstatico * (porcentajeBencina / 100f));
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if(!(obj instanceof Automovil)){
            return false;
        }

        Automovil a = (Automovil) obj;
        return (this.fabricante != null && this.modelo != null && this.fabricante.equals(a.getFabricante()) && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return this.id + " : " + fabricante + " - " + modelo;
    }

    @Override
    public int compareTo(Automovil a) {
        return this.fabricante.compareTo(a.fabricante);
    }
}
