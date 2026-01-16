package co.esteban.pooclasesabstractas.form.elementos;

import co.esteban.pooclasesabstractas.form.elementos.select.Opcion;

import java.util.ArrayList;
import java.util.List;

public class SelectForm extends ElementoForm{

    private List<Opcion> opciones;


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


    public SelectForm(String nombre) {
        super(nombre);
        this.opciones = new ArrayList<Opcion>();
    }

    public SelectForm(String nombre, List<Opcion> opciones) {
        super(nombre);
        this.opciones = opciones;
    }

    public SelectForm addOpcion(Opcion opcion){
        this.opciones.add(opcion);
        return this;
    }

    @Override
    public String dibujarHtml() {
        StringBuilder sb = new StringBuilder("<select ");
        sb.append("name='").append(this.nombre).append("'>");

        for(Opcion o: this.opciones){
            sb.append("\n   <option value='")
                    .append(o.getValor())
                    .append("'");

            if(o.isSelected()){
                sb.append(" selected ✅");
                this.valor = o.getValor();
            }

            sb.append(">")
                    .append(o.getNombre())
                    .append("</option>");
        }

        sb.append("\n</select>");
        return sb.toString();
    }
}
