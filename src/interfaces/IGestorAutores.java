package interfaces;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.Profesor;

import java.util.ArrayList;

public interface IGestorAutores {
    //Constantes de mensajes
    public final String EXITO = "Autor creado/borrado con éxito";
    public final String ERROR_NOMBRE = "El nombre del autor no puede ser nulo";
    public final String ERROR_APELLIDO = "El apellido del autor no puede ser nulo";
    public final String ERROR_DNI = "El DNI del autor no puede ser nulo, ni negativo, ni contener un carácter alfabético";
    public final String ERROR_CLAVE = "La clave ingresada debe coincidir con la clave repetida y debe ser no nula";
    public final String ERROR_CARGO = "El cargo del profesor no puede ser nulo";
    public final String ERROR_CX = "El CX del alumno no puede ser nulo";
    public final String AUTOR_DUPLICADO = "Ya existe un autor con ese DNI o CX";
    public final String AUTOR_CON_PUBLICACION = "No se puede borrar el autor porque hay publicaciones con ese autor";
    public final String AUTOR_INEXISTENTE = "No existe el autor en específico";

    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public boolean existeEsteAutor(Autor autor);
    public ArrayList<Autor> verAutores();
    public ArrayList<Profesor> verProfesores();
    public ArrayList<Alumno> verAlumnos();
    public Autor verAutor(int dni);
    public String borrarAutor(Autor autor);
    public ArrayList<Profesor> buscarProfesor (String busqueda);
    public ArrayList<Alumno> buscarAlumnos (String busqueda);
}
