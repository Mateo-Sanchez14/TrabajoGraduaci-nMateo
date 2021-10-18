package publicaciones.modelos;

import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private String titulo;
    private LocalDate fechaPublicacion;
    private String enlace;
    private String resumen;
    private Tipo tipo;
    private Idioma idioma;
    private Lugar lugar;
    private MiembroEnGrupo miembroEnGrupo;
    private ArrayList<PalabraClave> palabrasClaves;

    public Publicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.enlace = enlace;
        this.resumen = resumen;
        this.tipo = tipo;
        this.idioma = idioma;
        this.lugar = lugar;
        this.miembroEnGrupo = miembroEnGrupo;
        this.palabrasClaves = palabrasClaves;
    }

    public void mostrar() {
        System.out.println("Titulo : " + titulo);
        System.out.println("Autor : " + miembroEnGrupo.verProfesor().verApellidos() + ", " + miembroEnGrupo.verProfesor().verNombres());
        System.out.println("Grupo : " + miembroEnGrupo.verGrupo().verNombre());
        System.out.println("Rol : " + miembroEnGrupo.verRol());
        System.out.println("Fecha de publicación : " + fechaPublicacion);
        System.out.println("Tipo : " + tipo);
        System.out.println("Idioma : " + idioma);
        System.out.println("Lugar : " + lugar);
        System.out.println("Palabras claves \n---------------");
        verPalabrasClaves().forEach(x -> System.out.println("\t" + x.verNombre()));
        System.out.println("Enlace : " + enlace);
        System.out.println("Resumen = " + resumen);
    }

    public String verTitulo() {
        return titulo;
    }

    public void asignarTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate verFechaPublicacion() {
        return fechaPublicacion;
    }

    public void asignarFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String verEnlace() {
        return enlace;
    }

    public void asignarEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String verResumen() {
        return resumen;
    }

    public void asignarResumen(String resumen) {
        this.resumen = resumen;
    }

    public Tipo verTipo() {
        return tipo;
    }

    public void asignarTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Idioma verIdioma() {
        return idioma;
    }

    public void asignarIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Lugar verLugar() {
        return lugar;
    }

    public void asignarLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public MiembroEnGrupo verMiembroEnGrupo() {
        return miembroEnGrupo;
    }

    public void asignarMiembroEnGrupo(MiembroEnGrupo miembroEnGrupo) {
        this.miembroEnGrupo = miembroEnGrupo;
    }

    public ArrayList<PalabraClave> verPalabrasClaves() {
        return palabrasClaves;
    }

    public void asignarPalabrasClaves(ArrayList<PalabraClave> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
}
