package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPublicaciones implements IGestorPublicaciones {
    ArrayList<Publicacion> publicaciones = new ArrayList<>();

    private static GestorPublicaciones gestor;

    private GestorPublicaciones() {
    }

    public static GestorPublicaciones instanciar() {
        if (gestor == null) {
            gestor = new GestorPublicaciones();
        }
        return gestor;
    }

    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo,
                                   LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,
                                   List<PalabraClave> palabrasClaves, String enlace, String resumen) {

        if ((titulo == null) || titulo.trim().isEmpty())
            return ERROR_TITULO;
        if (miembroEnGrupo == null)
            return ERROR_MIEMBRO_EN_GRUPO;
        if (fechaPublicacion == null)
            return ERROR_FECHA;
        if (tipo == null)
            return ERROR_TIPO;
        if (idioma == null)
            return ERROR_IDIOMA;
        if (lugar == null)
            return ERROR_LUGAR;
        if (palabrasClaves == null)
            return ERROR_PALABRAS_CLAVES;
        if ((enlace == null) || enlace.trim().isEmpty())
            return ERROR_ENLACE;
        if ((resumen == null) || resumen.trim().isEmpty())
            return ERROR_RESUMEN;
        Publicacion unaPublicacion = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo,
                idioma, lugar, palabrasClaves, enlace, resumen);
        if (publicaciones.contains(unaPublicacion))
            return PUBLICACIONES_DUPLICADAS;
        publicaciones.add(unaPublicacion);
        return EXITO;
    }

    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo,
                                       LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,
                                       List<PalabraClave> palabrasClaves, String enlace, String resumen) {
        if (miembroEnGrupo == null)
            return ERROR_MIEMBRO_EN_GRUPO;
        if (fechaPublicacion == null)
            return ERROR_FECHA;
        if (tipo == null)
            return ERROR_TIPO;
        if (idioma == null)
            return ERROR_IDIOMA;
        if (lugar == null)
            return ERROR_LUGAR;
        if (palabrasClaves == null) //Consultar si puede ser una arraylist sin elementos
            return ERROR_PALABRAS_CLAVES;
        if ((enlace == null) || enlace.trim().isEmpty())
            return ERROR_ENLACE;
        if ((resumen == null) || resumen.trim().isEmpty())
            return ERROR_RESUMEN;
        if (publicacion == null)
            return PUBLICACION_INEXISTENTE;

        publicacion.asignarMiembroEnGrupo(miembroEnGrupo);
        publicacion.asignarFechaPublicacion(fechaPublicacion);
        publicacion.asignarTipo(tipo);
        publicacion.asignarIdioma(idioma);
        publicacion.asignarLugar(lugar);
        publicacion.asignarPalabrasClaves(palabrasClaves);
        publicacion.asignarEnlace(enlace);
        publicacion.asignarResumen(resumen);

        return EXITO;
    }

    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        for (Publicacion k : publicaciones) {
            if (k.verPalabrasClaves().contains(palabraClave))
                return true;
        }
        return false;
    }

    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        for (Publicacion k : publicaciones) {
            if (k.verLugar().equals(lugar))
                return true;
        }
        return false;
    }

    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        for (Publicacion k : publicaciones) {
            if (k.verIdioma().equals(idioma))
                return true;
        }
        return false;
    }

    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        for (Publicacion k : publicaciones) {
            if (k.verTipo().equals(tipo))
                return true;
        }
        return false;
    }

    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        for (Publicacion k : publicaciones) {
            if (k.verMiembroEnGrupo().verAutor().equals(autor))
                return true;
        }
        return false;
    }

    public boolean existeEstaPublicacion(Publicacion publicacion) {
        if (publicaciones.contains(publicacion))
            return true;
        return false;
    }

    public List<Publicacion> verPublicaciones() {
        Collections.sort(publicaciones);
        return publicaciones;
    }

    public Publicacion verPublicacion(String titulo) {
        for (Publicacion k : publicaciones) {
            if (k.verTitulo().equals(titulo)) {
                return k;
            }
        }
        return null;
    }

    @Override
    public String borrarPublicacion(Publicacion publicacion) {
        if (!this.existeEstaPublicacion(publicacion) || publicacion == null)
            return PUBLICACION_INEXISTENTE;

        publicaciones.remove(publicacion);
        return EXITO;
    }

    @Override
    public List<Publicacion> buscarPublicaciones(String titulo) {
        List<Publicacion> publicacionesEncontradas = new ArrayList<>();
        for (Publicacion x : this.publicaciones){
            if(x.verTitulo().equalsIgnoreCase(titulo)) {
                publicacionesEncontradas.add(x);
            }
        }
        Collections.sort(publicacionesEncontradas);
        return publicacionesEncontradas;
    }
}
