package grupos.modelos;

public class Grupo {
    //Atributos de la clase
    private String nombre;
    private String descripcion;

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Grupo: \nNombre: " + this.nombre + "\nDescripción: " + this.descripcion );
    }
}
