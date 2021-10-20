package grupos.modelos;

import autores.modelos.Autor;

import java.util.Objects;

public class MiembroEnGrupo {
    private Grupo grupo;
    private Rol rol;
    private Autor autor;

    public MiembroEnGrupo(Autor autor, Grupo grupo, Rol rol) {
        this.grupo = grupo;
        this.rol = rol;
        this.autor = autor;
    }

    public Grupo verGrupo() {
        return grupo;
    }

    public void asignarGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Rol verRol() {
        return rol;
    }

    public void asignarRol(Rol rol) {
        this.rol = rol;
    }

    public Autor verAutor() {
        return autor;
    }

    public void asignarAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass().getSuperclass() != o.getClass().getSuperclass()) return false;
        MiembroEnGrupo that = (MiembroEnGrupo) o;
        return Objects.equals(autor, that.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor);
    }
}
