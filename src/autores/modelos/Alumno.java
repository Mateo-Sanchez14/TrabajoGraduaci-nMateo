package autores.modelos;

public class Alumno {
    //Atributos de la clase
    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;
    private String cx;

    //Métodos de la clase
    public void mostrar() {
        System.out.println("Alumno: \nDNI: " + this.dni + "\nApellidos: " + this.apellidos
        + "\nNombres: " + this.nombres + "\nClave: " + this.clave + "\nCx: " + this.cx);
    }

}
