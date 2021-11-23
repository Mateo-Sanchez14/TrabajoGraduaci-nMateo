package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPalabrasClaves implements IGestorPalabrasClaves {
    List<PalabraClave> palabrasClaves = new ArrayList<>();

    private static GestorPalabrasClaves gestor;

    private GestorPalabrasClaves () {
    }

    public static GestorPalabrasClaves instanciar() {
        if (gestor == null)
            gestor = new GestorPalabrasClaves();
        return gestor;
    }

    public String nuevaPalabraClave(String nombre) {
        PalabraClave unaPalabra = new PalabraClave(nombre);
        if ((nombre == null) || nombre.trim().isEmpty())
            return ERROR_NOMBRE;
        if (this.palabrasClaves.contains(unaPalabra))
            return PALABRA_DUPLICADA;
        this.palabrasClaves.add(unaPalabra);
        return EXITO;
    }

    public List<PalabraClave> verPalabrasClaves() {
        Collections.sort(this.palabrasClaves);
        return this.palabrasClaves;
    }

    public PalabraClave verPalabraClave(String nombre) {
        for (PalabraClave x : palabrasClaves) {
            if (x.verNombre().equals(nombre)){
                return x;
            }
        }
        return null;
    }

    @Override
    public String borrarPalabraClave(PalabraClave palabraClave) {
        if (!existeEstaPalabraClave(palabraClave))
            return PALABRA_INEXISTENTE;
        IGestorPublicaciones gestorPublicaciones = GestorPublicaciones.instanciar();
        if (gestorPublicaciones.hayPublicacionesConEstaPalabraClave(palabraClave))
            return PALABRA_CON_PUBLICACION;
        this.palabrasClaves.remove(palabraClave);
        return EXITO;
    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        List<PalabraClave> palabrasEncontradas = new ArrayList<>();
        for (PalabraClave x : this.palabrasClaves){
            if (x.verNombre().toLowerCase().contains(nombre.toLowerCase()))
                palabrasEncontradas.add(x);
        }
        Collections.sort(palabrasEncontradas);
        return palabrasEncontradas;
    }

    @Override
    public boolean existeEstaPalabraClave(PalabraClave palabraClave) {
        for (PalabraClave x : this.palabrasClaves) {
            if (x.verNombre().equals(palabraClave.verNombre())) {
                return true;
            }
        }
        return false;
    }
}
