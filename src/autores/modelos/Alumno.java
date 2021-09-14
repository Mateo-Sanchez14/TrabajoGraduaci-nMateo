package autores.modelos;

public class Alumno {
    //Atributos de la clase
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private String cx;

    //Constructores de la clase
    public Alumno() {
    }

    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
        this.cx = cx;
    }

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Alumno{" +
                "dni=" + dni +
                ", apellidos='" + apellidos + '\'' +
                ", nombres='" + nombres + '\'' +
                ", clave='" + clave + '\'' +
                ", cx='" + cx + '\'' +
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

    public String verCx() {
        return cx;
    }

    public void asignarCx(String cx) {
        this.cx = cx;
    }
}
