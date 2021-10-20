package autores.modelos;

import java.util.Objects;

public class Profesor extends Autor {
    //Atributos de la clase
    private Cargo cargo;

    //Constructores de la clase

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
        super(dni,apellidos,nombres,clave);
        this.cargo = cargo;
    }

    //Métodos de la clase
    public void mostrar() {
        super.mostrar();
        System.out.println("," + cargo);
    }

    public Cargo verCargo() {
        return cargo;
    }

    public void asignarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profesor)) return false;
        Profesor profesor = (Profesor) o;
        return dni == profesor.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }*/
}
