package autores.modelos;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import interfaces.IGestorAutores;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;

import javax.xml.crypto.AlgorithmMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorAutores implements IGestorAutores {
    ArrayList<Autor> autores = new ArrayList<>();

    private static GestorAutores gestor;

    private GestorAutores () {
    }

    public static GestorAutores instanciar () {
        if (gestor == null) {
            gestor = new GestorAutores();
        }
        return gestor;
    }

    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida){
        if ((dni <= 0))
            return ERROR_DNI;
        if ((apellidos == null) || apellidos.trim().isEmpty())
            return ERROR_APELLIDO;
        if ((nombres == null) || nombres.trim().isEmpty())
            return ERROR_NOMBRE;
        if ((cargo == null))
            return ERROR_CARGO;
        if (!clave.equals(claveRepetida) || clave == null || clave.trim().isEmpty())
            return ERROR_CLAVE;

        Autor unProfesor = new Profesor(dni, apellidos, nombres, clave, cargo);
        if (autores.contains(unProfesor)){
            return AUTOR_DUPLICADO;
        }

        this.autores.add(unProfesor);
        return EXITO;
    }
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida){
        if ((dni <= 0))
            return ERROR_DNI;
        if ((apellidos == null) || apellidos.trim().isEmpty())
            return ERROR_APELLIDO;
        if ((nombres == null) || nombres.trim().isEmpty())
            return ERROR_NOMBRE;
        if ((cx == null))
            return ERROR_CX;
        if (!clave.equals(claveRepetida) || clave == null || clave.trim().isEmpty())
            return ERROR_CLAVE;

        Autor unAlumno = new Alumno(dni, apellidos, nombres, clave, cx);
        if (autores.contains(unAlumno)){
            return AUTOR_DUPLICADO;
        }
        this.autores.add(unAlumno);
        return EXITO;
    }
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida){
        if ((apellidos == null) || apellidos.trim().isEmpty())
            return ERROR_APELLIDO;
        if ((nombres == null) || nombres.trim().isEmpty())
            return ERROR_NOMBRE;
        if ((cargo == null))
            return ERROR_CARGO;
        if (!clave.equals(claveRepetida) || clave == null || clave.trim().isEmpty())
            return ERROR_CLAVE;
        if (autor == null)
            return AUTOR_INEXISTENTE;
        Profesor profesor = (Profesor) autor;

        if (!autores.contains(profesor))
            return AUTOR_INEXISTENTE;

        profesor.asignarApellidos(apellidos);
        profesor.asignarNombres(nombres);
        profesor.asignarCargo(cargo);
        profesor.asignarClave(clave);
        return EXITO;
    }
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida){
        if ((apellidos == null) || apellidos.trim().isEmpty())
            return ERROR_APELLIDO;
        if ((nombres == null) || nombres.trim().isEmpty())
            return ERROR_NOMBRE;
        if ((cx == null))
            return ERROR_CX;
        if (!clave.equals(claveRepetida) || clave == null || clave.trim().isEmpty())
            return ERROR_CLAVE;
        if (autor == null)
            return AUTOR_INEXISTENTE;

        Alumno alumno = (Alumno) autor;
        alumno.asignarApellidos(apellidos);
        alumno.asignarNombres(nombres);
        alumno.asignarCx(cx);
        alumno.asignarClave(clave);
        return EXITO;
    }
    public boolean existeEsteAutor(Autor autor){
        if (autores.contains(autor))
            return true;
        return false;
    }
    public List<Autor> verAutores() {
        Collections.sort(autores);
        return autores;
    }
    public List<Profesor> verProfesores() {
        List<Profesor> profesores = new ArrayList<>();
        for (Autor k : autores) {
            if (k instanceof Profesor)
                profesores.add((Profesor) k);
        }
        Collections.sort(profesores);
        return profesores;
    }
    public List<Alumno> verAlumnos() {
        List<Alumno> alumnos = new ArrayList<>();
        for (Autor k : autores) {
            if (k instanceof Alumno)
                alumnos.add((Alumno) k);
        }
        Collections.sort(alumnos);
        return alumnos;
    }

    public Autor verAutor(int dni){
        for (Autor k : autores) {
            if (k.verDni() == dni)
                return k;
        }
        return null;
    }

    public String borrarAutor(Autor autor) {
        if(!existeEsteAutor(autor)) {
            return AUTOR_INEXISTENTE;
        }
        IGestorPublicaciones gestorPublicaciones = GestorPublicaciones.instanciar();
        if (gestorPublicaciones.hayPublicacionesConEsteAutor(autor))
            return AUTOR_CON_PUBLICACION;

        autores.remove(autor);

        return EXITO;
    }

    public List<Alumno> buscarAlumnos (String apellidos) {
        List<Alumno> ocurrencias = new ArrayList<>();
        for (Alumno a : this.verAlumnos()) {
            if (a.verApellidos().toLowerCase().contains(apellidos.toLowerCase())) {
                ocurrencias.add(a);
            }
        }
        Collections.sort(ocurrencias);
        return ocurrencias;
    }

    @Override
    public List<Profesor> buscarProfesores(String apellidos) {
        List<Profesor> ocurrencias = new ArrayList<>();
        for (Profesor a : this.verProfesores()) {
            if (a.verApellidos().toLowerCase().contains(apellidos.toLowerCase())) {
                ocurrencias.add(a);
            }
        }
        Collections.sort(ocurrencias);
        return ocurrencias;
    }

    @Override
    public boolean hayAutoresConEsteGrupo(Grupo grupo) {
        for (Autor x : autores){
            if (x.contieneGrupo(grupo))
                return true;
        }
        return false;
    }
}
