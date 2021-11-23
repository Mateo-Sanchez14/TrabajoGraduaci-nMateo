package lugares.modelos;

import interfaces.IGestorLugares;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.Tipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorLugares implements IGestorLugares {
    ArrayList<Lugar> lugares = new ArrayList<>();
    private static GestorLugares gestor;

    public static GestorLugares instanciar() {
        if (gestor == null)
            gestor = new GestorLugares();
        return gestor;
    }

    public String nuevoLugar(String nombre){
        Lugar unLugar = new Lugar(nombre);
        if ((nombre == null) || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        if (this.lugares.contains(unLugar))
            return LUGAR_DUPLICADO;
        this.lugares.add(unLugar);
        return EXITO;
    }

    public List<Lugar> verLugares(){
        Collections.sort(lugares);
        return this.lugares;
    }

    public Lugar verLugar(String nombre){
        for (Lugar x : lugares) {
            if (x.verNombre().equals(nombre)){
                return x;
            }
        }
        return null;
    }

    @Override
    public String borrarLugar(Lugar lugar) {
        if (!existeEsteLugar(lugar))
            return LUGAR_INEXISTENTE;
        IGestorPublicaciones gestorPublicaciones = GestorPublicaciones.instanciar();
        if (gestorPublicaciones.hayPublicacionesConEsteLugar(lugar))
            return LUGAR_CON_PUBLICACION;

        this.lugares.remove(lugar);
        return EXITO;
    }

    @Override
    public List<Lugar> buscarLugares(String nombre) {
        List<Lugar> lugaresEncontrados = new ArrayList<>();
        for (Lugar x : this.lugares){
            if (x.verNombre().toLowerCase().contains(nombre.toLowerCase()))
                lugaresEncontrados.add(x);
        }
        Collections.sort(lugaresEncontrados);
        return lugaresEncontrados;
    }

    @Override
    public boolean existeEsteLugar(Lugar lugar) {
        for (Lugar x : this.lugares) {
            if (x.verNombre().equals(lugar.verNombre())) {
                return true;
            }
        }
        return false;
    }
}
