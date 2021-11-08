package idiomas.modelos;
import interfaces.IGestorIdiomas;
import idiomas.modelos.Idioma;
import java.util.ArrayList;

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

    public ArrayList<Idioma> verIdiomas(){
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
}