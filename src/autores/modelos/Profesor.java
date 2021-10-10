package autores.modelos;

public class Profesor {
    //Atributos de la clase
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private String cargo;

    //Constructores de la clase
    public Profesor() {
    }

    public Profesor(int dni, String apellidos, String nombres, String clave, String cargo) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
        this.cargo = cargo;
    }

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Profesor{" +
                "dni=" + dni +
                ", apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                ", clave='" + clave + '\'' +
                ", cargo='" + cargo + '\'' +
                '}');
    }
    public int verDni() {
        return dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }

    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public String verCargo() {
        return cargo;
    }

    public void asignarCargo(String cargo) {
        this.cargo = cargo;
    }
}
