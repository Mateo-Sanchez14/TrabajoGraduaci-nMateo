package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import java.util.ArrayList;

public class GestorPalabrasClaves implements IGestorPalabrasClaves {
    ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();

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

    public ArrayList<PalabraClave> verPalabrasClaves() {
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
}
