package co.esteban.ejemplos.EjercicioList;

public enum Origen {
    NEW_YORK("New York"),
    SAO_PAULO("Sao Paulo"),
    RIO_DE_JANEIRO("Rio De Janeiro"),
    ATLANTA("Atlanta"),
    BOGOTA("Bogota"),
    MEXICO_CITY("Mexico City"),
    LONDRES("Londres"),
    FRANKFURT("Frankfurt"),
    LIMA("Lima"),
    LOS_ANGELES("Los Ángeles"),
    GUAYAQUIL("Guayaquil"),
    PANAMA_CITY("Panama City"),
    MADRID("Madrid"),
    MIAMI("Miami"),
    BUENOS_AIRES("Buenos Aires"),
    CANCUN("Cancún"),
    BARCELONA("Barcelona"),
    DALLAS_FORT_WORTH("Dallas-Fort Worth"),
    PARIS("Paris"),
    MONTEVIDEO("Montevideo")
    ;

    private String ciudad;

    Origen(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }
}
