package grupos.modelos;

public class Grupo {
    //Atributos de la clase
    private String nombre;
    private String descripcion;

    //Constructores de la Clase
    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Grupo() {
    }

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Grupo: \nNombre: " + this.nombre + "\nDescripción: " + this.descripcion );
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
