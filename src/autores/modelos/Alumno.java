package autores.modelos;

import java.util.Objects;

public class Alumno extends Autor {
    //Atributos de la clase
    private String cx;

    //Constructores de la clase

    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        super(dni, apellidos, nombres, clave);
        this.cx = cx;
    }

    //Métodos de la clase
    public void mostrar() {
        super.mostrar();
        System.out.println("CX: " + cx);
    }

    public String verCx() {
        return cx;
    }

    public void asignarCx(String cx) {
        this.cx = cx;
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            if (obj instanceof Alumno) {
                Alumno other = (Alumno) obj;
                if (!this.cx.equals(other.cx)) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode() + Objects.hashCode(this.cx);
    }
}
