package grupos.modelos;

import autores.modelos.Profesor;

public class MiembroEnGrupo {
    private Grupo grupo;
    private Rol rol;
    private Profesor profesor;

    public MiembroEnGrupo(Grupo grupo, Rol rol, Profesor profesor) {
        this.grupo = grupo;
        this.rol = rol;
        this.profesor = profesor;
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

    public Profesor verProfesor() {
        return profesor;
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
