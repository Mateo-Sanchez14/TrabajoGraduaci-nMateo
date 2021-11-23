package autores.modelos;

import interfaces.IGestorAutores;

import javax.xml.crypto.AlgorithmMethod;
import java.util.ArrayList;

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
    public ArrayList<Autor> verAutores() {
        return autores;
    }
    public ArrayList<Profesor> verProfesores() {
        ArrayList<Profesor> profesores = new ArrayList<>();
        for (Autor k : autores) {
            if (k instanceof Profesor)
                profesores.add((Profesor) k);
        }
        return profesores;
    }
    public ArrayList<Alumno> verAlumnos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        for (Autor k : autores) {
            if (k instanceof Alumno)
                alumnos.add((Alumno) k);
        }
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
        if(existeEsteAutor(autor)) {
            autores.remove(autor);
            return EXITO;
        }
        return AUTOR_INEXISTENTE;
    }
    public ArrayList<Profesor> buscarProfesor (String busqueda) {
        ArrayList<Profesor> ocurrencias = new ArrayList<>();
        for (Profesor p : this.verProfesores()) {
            if (p.verApellidos().toLowerCase().contains(busqueda.toLowerCase())) {
                ocurrencias.add(p);
            }
        }
        return ocurrencias;
    }
    public ArrayList<Alumno> buscarAlumnos (String busqueda) {
        ArrayList<Alumno> ocurrencias = new ArrayList<>();
        for (Alumno a : this.verAlumnos()) {
            if (a.verApellidos().toLowerCase().contains(busqueda.toLowerCase())) {
                ocurrencias.add(a);
            }
        }
        return ocurrencias;
    }
}
