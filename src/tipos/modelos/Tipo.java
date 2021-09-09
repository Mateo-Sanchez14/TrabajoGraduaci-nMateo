package tipos.modelos;

public class Tipo {
    //Atributos de la clase
    private String nombre;

    //Constructores de la clase

    public Tipo() {
    }

    public Tipo(String nombre) {
        this.nombre = nombre;
    }

    //Métodos de la clase
    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
