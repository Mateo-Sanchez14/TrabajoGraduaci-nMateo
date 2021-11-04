package tipos.modelos;

import interfaces.IGestorTipos;

import java.util.ArrayList;

public class GestorTipos implements IGestorTipos {
    ArrayList<Tipo> tipos = new ArrayList<>();

    private static GestorTipos gestor;

    private GestorTipos () {
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
    public ArrayList<Tipo> verTipos() {
        return tipos;
    }

    public Tipo verTipo(String nombre){
        for (Tipo x : tipos) {
            if (x.verNombre().equals(nombre)) {
                return x;
            }
        }
        return null;
    }
}
