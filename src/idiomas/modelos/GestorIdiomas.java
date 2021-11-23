package idiomas.modelos;
import interfaces.IGestorIdiomas;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import lugares.modelos.Lugar;
import publicaciones.modelos.GestorPublicaciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorIdiomas implements IGestorIdiomas {
    ArrayList<Idioma> idiomas = new ArrayList<>();
    private static GestorIdiomas gestor;

    public static GestorIdiomas instanciar() {
        if (gestor == null)
            gestor = new GestorIdiomas();
        return gestor;
    }

    public String nuevoIdioma(String nombre){
        Idioma unIdioma = new Idioma(nombre);
        if ((nombre == null) || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        if (this.idiomas.contains(unIdioma))
            return IDIOMA_DUPLICADO;
        this.idiomas.add(unIdioma);
        return EXITO;
    }

    public List<Idioma> verIdiomas(){
        Collections.sort(idiomas);
        return this.idiomas;
    }

    public Idioma verIdioma(String nombre){
        for (Idioma x : idiomas) {
            if (x.verNombre().equals(nombre)){
                return x;
            }
        }
        return null;
    }

    @Override
    public String borrarIdioma(Idioma idioma) {
        if (!existeEsteIdioma(idioma))
            return IDIOMA_INEXISTENTE;
        IGestorPublicaciones gestorPublicaciones = GestorPublicaciones.instanciar();
        if (gestorPublicaciones.hayPublicacionesConEsteIdioma(idioma))
            return IDIOMA_CON_PUBLICACION;

        this.idiomas.remove(idioma);
        return EXITO;
    }

    @Override
    public List<Idioma> buscarIdiomas(String nombre) {
        List<Idioma> idiomasEncontrados = new ArrayList<>();
        for (Idioma x : this.idiomas){
            if (x.verNombre().toLowerCase().contains(nombre.toLowerCase()))
                idiomasEncontrados.add(x);
        }
        Collections.sort(idiomasEncontrados);
        return idiomasEncontrados;
    }

    @Override
    public boolean existeEsteIdioma(Idioma idioma) {
        for (Idioma x : this.idiomas) {
            if (x.verNombre().equals(idioma.verNombre())) {
                return true;
            }
        }
        return false;
    }
}