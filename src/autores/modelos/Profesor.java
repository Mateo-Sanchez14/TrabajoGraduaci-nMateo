package autores.modelos;

public class Profesor {
    //Atributos de la clase
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private String cargo;

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Profesor: \nDNI: " + this.dni + "\nApellidos: " + this.apellidos
                + "\nNombres: " + this.nombres + "\nClave: " + this.clave + "\nCargo: " + this.cargo);
    }
}
