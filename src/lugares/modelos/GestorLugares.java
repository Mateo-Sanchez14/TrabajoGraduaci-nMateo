package lugares.modelos;

import interfaces.IGestorLugares;
import palabrasclaves.modelos.GestorPalabrasClaves;
import palabrasclaves.modelos.PalabraClave;

import java.util.ArrayList;

public class GestorLugares implements IGestorLugares {
    ArrayList<Lugar> lugars = new ArrayList<>();

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
        if (this.lugars.contains(unLugar))
            return LUGAR_DUPLICADO;
        this.lugars.add(unLugar);
        return EXITO;
    }

    public ArrayList<Lugar> verLugares(){
        return this.lugars;
    }

    public Lugar verLugar(String nombre){
        for (Lugar x : lugars) {
            if (x.verNombre().equals(nombre)){
                return x;
            }
        }
        return null;
    }
}
