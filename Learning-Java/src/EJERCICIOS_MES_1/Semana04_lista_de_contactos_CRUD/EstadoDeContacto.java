package EJERCICIOS_MES_1.Semana04_lista_de_contactos_CRUD;

public enum EstadoDeContacto {
    FAMILIAR("👨‍👩‍👧‍👦"),
    AMIGO("🧑🏻‍🤝‍👩🏼"),
    TRABAJO("🏢"),
    CONOCIDO("🧍🏻"),
    EMERGENCIA("🚑");

    private String icono;

    EstadoDeContacto(String icono){
        this.icono = icono;
    }

    public String getIcono(){
        return icono;
    }
}
