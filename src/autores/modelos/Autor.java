package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Autor implements Comparable<Autor> {
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private ArrayList<MiembroEnGrupo> gruposAutor = new ArrayList<>();

    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }

    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">

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
        return gruposAutor;
    }

    public void asignarMiembroEnGrupo(ArrayList<MiembroEnGrupo> miembroEnGrupo) {
        this.gruposAutor = miembroEnGrupo;
    }

    //</editor-fold>

    public void agregarGrupo(Grupo grupo, Rol rol) {
        MiembroEnGrupo miembro = new MiembroEnGrupo(this, grupo, rol);
        if (!this.contieneGrupo(grupo)) {
            gruposAutor.add(miembro);
            grupo.agregarMiembro(this, rol);
        }
    }

    public boolean contieneGrupo(Grupo grupo) {
        for (MiembroEnGrupo a : gruposAutor) {
            if (a.verGrupo().equals(grupo)) {
                return true;
            }
        }
        return false;
    }

    public void quitarGrupo(Grupo grupo) {
        for (MiembroEnGrupo a : gruposAutor) {
            if (a.verGrupo().equals(grupo)) {
                gruposAutor.remove(a);
                grupo.quitarMiembro(this);
            }
        }
    }

    public boolean esSuperAdministrador() {
        for (MiembroEnGrupo a : gruposAutor) {
            if (a.verGrupo().verNombre().equals("Super Administradores")) {
                return true;
            }
        }
        return false;
    }

    public boolean tieneGrupos() {
        if (this.gruposAutor.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void mostrar() {
        System.out.println("[" + dni + "] " + apellidos + ", " + nombres);
        if(!gruposAutor.isEmpty()) {
            System.out.println("Grupos a los que pertenece: ");
            for (MiembroEnGrupo a : gruposAutor) {
                System.out.println("\t" + a.verGrupo().verNombre() + ", " + a.verRol());
            }
        }else
            System.out.println("No pertenece a ningún grupo");
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

    @Override
    public int compareTo(Autor o) {
        if (o.apellidos.equals(apellidos)) {
            return this.nombres.compareToIgnoreCase(o.nombres);
        }
        else {
            return this.apellidos.compareToIgnoreCase(o.apellidos);
        }
    }
}
