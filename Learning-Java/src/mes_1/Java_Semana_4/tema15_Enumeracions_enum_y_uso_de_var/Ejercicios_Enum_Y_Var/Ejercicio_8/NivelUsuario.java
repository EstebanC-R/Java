package mes_1.Java_Semana_4.tema15_Enumeracions_enum_y_uso_de_var.Ejercicios_Enum_Y_Var.Ejercicio_8;

public enum NivelUsuario {
    INVITADO("Invitado", 0, false, false, false),
    USUARIO("Usuario", 1, true, false, false),
    MODERADOR("Moderador", 2, true, true, false),
    ADMINISTRADOR("Admin", 3, true, true, true);

    private String nombre;
    private int nivel;
    private boolean puedeLeer;
    private boolean puedeEditar;
    private boolean puedeEliminar;


    NivelUsuario(String nombre, int nivel, boolean puedeLeer, boolean puedeEditar, boolean puedeEliminar){
        this.nombre = nombre;
        this.nivel = nivel;
        this.puedeLeer = puedeLeer;
        this.puedeEditar = puedeEditar;
        this.puedeEliminar = puedeEliminar;
    }


    public void tienePermiso(String accion){
        if(accion.equalsIgnoreCase("leer")){
            if(nivel == 0){
                System.out.println("Lo siento, la área de lectura esta bloqueada para ti - " + nombre + ".");
            }else if(nivel == 1 || nivel == 2 || nivel == 3){
                System.out.println("Si puedes leer el contenido - " + nombre +".");
            }
        }

        if(accion.equalsIgnoreCase("editar")){
            if(nivel == 0 || nivel == 1){
                System.out.println("Lo siento, la área de edición esta bloqueada para ti - " + nombre + ".");
            }else if(nivel == 2 || nivel == 3){
                System.out.println("Si puedes editar - " + nombre + ".");
            }
        }

        if(accion.equalsIgnoreCase("eliminar")){
            if(nivel == 0 || nivel == 1 || nivel == 2){
                System.out.println("Lo siento, la área de eliminar esta bloqueada para ti - " + nombre + ".");
            }else if(nivel == 3){
                System.out.println("Si puedes eliminar - " + nombre + ".");
            }
        }
    }

    public String getNombre(){
        return nombre;
    }

    public int getNivel(){
        return nivel;
    }
}
