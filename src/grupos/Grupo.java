package grupos;

import java.util.ArrayList;

public class Grupo {
    //Atributos de la clase
    String nombre;
    String descripcion;
    
    //Métodos de la clase
    void mostrar () {
        System.out.println("Grupo{" + "nombre=" + nombre + ", descripcion=" + descripcion + '}');
    }
    
    //Método main
    public static void main(String[] args) {
        Grupo unGrupo1 = new Grupo();
        Grupo unGrupo2 = new Grupo();
        Grupo unGrupo3 = new Grupo();
        Grupo unGrupo4 = new Grupo();
        Grupo unGrupo5 = new Grupo();
        
        unGrupo1.nombre = "Grupo 1";
        unGrupo2.nombre = "Grupo 2";
        unGrupo3.nombre = "Grupo 3";
        unGrupo4.nombre = "Grupo 4";
        unGrupo5.nombre = "Grupo 5";
        unGrupo1.descripcion = "Descripción Grupo 1";
        unGrupo2.descripcion = "Descripción Grupo 2";
        unGrupo3.descripcion = "Descripción Grupo 3";
        unGrupo4.descripcion = "Descripción Grupo 4";
        unGrupo5.descripcion = "Descripción Grupo 5";
        
        
        Grupo[] vec = {unGrupo1, unGrupo2, unGrupo3, unGrupo4, unGrupo5};
        System.out.println("Muestro el vector de objetos");
        for (Grupo k : vec) {
            k.mostrar();
        }
        vec[3].nombre ="Grupo 4 modificado";
        System.out.println("Muestro el vector modificado");
        for (Grupo k : vec) {
            k.mostrar();
        }
        
        ArrayList<Grupo> unaArrayList = new ArrayList<>();
        unaArrayList.add(unGrupo1);
        unaArrayList.add(unGrupo2);
        unaArrayList.add(unGrupo3);
        unaArrayList.add(unGrupo4);
        unaArrayList.add(unGrupo5);
        System.out.println("Muestro la arraylist: ");
        unaArrayList.forEach(x -> x.mostrar());
        
        System.out.println("El arraylist modificado es:");
        unGrupo5.nombre = "Modificado Grupo 5";
        unaArrayList.forEach(x -> x.mostrar());
        
    }
}
