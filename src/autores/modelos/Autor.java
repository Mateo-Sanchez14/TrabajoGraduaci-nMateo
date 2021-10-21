package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Autor {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private ArrayList<MiembroEnGrupo> miembroEnGrupo = new ArrayList<>();

    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }

    public int verDni() {
        return this.dni;
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

    public ArrayList<MiembroEnGrupo> verGrupo() {
        return miembroEnGrupo;
    }

    public void asignarMiembroEnGrupo(ArrayList<MiembroEnGrupo> miembroEnGrupo) {
        this.miembroEnGrupo = miembroEnGrupo;
    }

    public void agregarGrupo(Grupo grupo, Rol rol) {

    }

    public void mostrar(){
        System.out.print("["+dni+"]"+apellidos+","+nombres);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
        Autor autor = (Autor) o;
        return dni == autor.dni;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
