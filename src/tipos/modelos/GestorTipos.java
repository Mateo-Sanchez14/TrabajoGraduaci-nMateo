package tipos.modelos;

import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import publicaciones.modelos.GestorPublicaciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GestorTipos implements IGestorTipos {
    List<Tipo> tipos = new ArrayList<>();

    private static GestorTipos gestor;

    private GestorTipos() {
    }

    public static GestorTipos instanciar() {
        if (gestor == null)
            gestor = new GestorTipos();
        return gestor;
    }

    public String nuevoTipo(String nombre) {
        Tipo unTipo = new Tipo(nombre);
        if ((nombre == null) || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        if (this.tipos.contains(unTipo))
            return TIPOS_DUPLICADOS;
        this.tipos.add(unTipo);
        return EXITO;
    }

    public List<Tipo> verTipos() {
        Collections.sort(tipos);
        return tipos;
    }

    public Tipo verTipo(String nombre) {
        for (Tipo x : tipos) {
            if (x.verNombre().equals(nombre)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public String borrarTipo(Tipo tipo) {
        if (!existeEsteTipo(tipo))
            return TIPO_INEXISTENTE;
        IGestorPublicaciones gestorPublicaciones = GestorPublicaciones.instanciar();
        if (gestorPublicaciones.hayPublicacionesConEsteTipo(tipo))
            return TIPO_CON_PUBLICACION;

        this.tipos.remove(tipo);
        return EXITO;
    }

    @Override
    public List<Tipo> buscarTipos(String nombre) {
        List<Tipo> tiposEncontrados = new ArrayList<>();
        for (Tipo x : this.tipos){
            if (x.verNombre().toLowerCase().contains(nombre.toLowerCase()))
                tiposEncontrados.add(x);
        }
        Collections.sort(tiposEncontrados);
        return tiposEncontrados;
    }

    @Override
    public boolean existeEsteTipo(Tipo tipo) {
        for (Tipo x : tipos) {
            if (x.verNombre().equals(tipo.verNombre())) {
                return true;
            }
        }
        return false;
    }
}