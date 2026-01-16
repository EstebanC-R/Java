package co.esteban.pooclasesabstractas.form.elementos.select;

public class Opcion {
    private String valor;
    private String nombre;
    private boolean selected;

    /* ? La lista 'opciones' guarda objetos de tipo Opcion.
        ! Cada Opcion tiene sus propios atributos: valor (lo que se envía al servidor),
        ! nombre (el texto visible en el <select>) y selected (si aparece marcada por defecto).
        ! Al inicializar 'opciones' en el constructor con new ArrayList<>(),
        ! evitamos que quede en null y podamos agregar opciones sin riesgo de NullPointerException.
        ! Ejemplo de uso:
    */

    // # SelectForm selectPais = new SelectForm("pais");
    // # selectPais.addOpcion(new Opcion("CO", "Colombia"));
    // # selectPais.addOpcion(new Opcion("MX", "México"));

    // $ -> Luego dibujarHtml() podría generar:
    // * <select name="pais">
    // ?     <option value="CO">Colombia</option>
    // ?     <option value="MX">México</option>
    // * </select>


    public Opcion() {
    }

    public Opcion(String valor, String nombre) {
        this.valor = valor;
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Opcion setSelected() {
        this.selected = true;
        return this;
    }
}
