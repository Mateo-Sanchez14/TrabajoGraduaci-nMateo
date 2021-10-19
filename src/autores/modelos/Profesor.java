package autores.modelos;

import java.util.Objects;

public class Profesor {
    //Atributos de la clase
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private Cargo cargo;

    //Constructores de la clase
    public Profesor() {
    }

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
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

    public Cargo verCargo() {
        return cargo;
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor)) return false;
        Profesor profesor = (Profesor) o;
        return dni == profesor.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
