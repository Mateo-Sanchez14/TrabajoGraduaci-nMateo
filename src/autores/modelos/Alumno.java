package autores.modelos;

import java.util.Objects;

public class Alumno extends Autor {
    //Atributos de la clase
    private String cx;

    //Constructores de la clase


    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        super(dni,apellidos,nombres,clave);
        this.cx = cx;
    }

    //Métodos de la clase
    public void mostrar() {
        super.mostrar();
        System.out.println("," + cx);
    }

    public String verCx() {
        return cx;
    }

    public void asignarCx(String cx) {
        this.cx = cx;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alumno)) return false;
        Alumno alumno = (Alumno) o;
        return dni == alumno.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }*/
}
