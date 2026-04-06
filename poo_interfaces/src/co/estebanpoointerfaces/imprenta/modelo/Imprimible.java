package co.estebanpoointerfaces.imprenta.modelo;

public interface Imprimible {

    String TEXTO_DEFECTO = "Imprimiendo un valor por defecto";

    // ! Cuando ponemos o no un modificador publico da igual, porque en realidad
    // ! por defecto ya este es publico asi que termina siendo redundante si lo ponemos,
    // ! es recomendable quitarlo ya que su valor default es public.

    default String imprimir() {
        return TEXTO_DEFECTO;
    }

    static void imprimir(Imprimible imprimible){
        System.out.println(imprimible.imprimir());
    }


}
