package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Profesor;
import autores.vistas.VentanaAMAlumno;
import autores.vistas.VentanaAMProfesor;
import grupos.modelos.Grupo;
import grupos.vistas.VentanaAMGrupo;
import idiomas.modelos.Idioma;
import idiomas.vistas.VentanaAIdioma;
import lugares.modelos.Lugar;
import lugares.vistas.VentanaALugar;
import palabrasclaves.modelos.PalabraClave;
import palabrasclaves.vistas.VentanaAPalabraClave;
import tipos.modelos.Tipo;
import tipos.vistas.VentanaATipo;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ControladorPrincipal {
    public static void main(String[] args) {
        /*
        //Declaro los arralist de las clases
        ArrayList<Alumno> losAlumnos = new ArrayList<>();
        ArrayList<Profesor> losProfesores = new ArrayList<>();
        ArrayList<Grupo> losGrupos = new ArrayList<>();
        ArrayList<Idioma> losIdiomas = new ArrayList<>();
        ArrayList<Lugar> losLugares = new ArrayList<>();
        ArrayList<PalabraClave> lasPalabrasClave = new ArrayList<>();
        ArrayList<Tipo> losTipos = new ArrayList<>();

        //Instancio todos los objetos
        //Tipo alumno
        Alumno alumno1=new Alumno(433,"Andrada","Luis Elian","789","433");
        Alumno alumno2=new Alumno(432,"Sanchez","Mateo Jesus","101","432");
        Alumno alumno3=new Alumno(431,"Lencina","Maria Luciana","121","431");
        Alumno alumno4=new Alumno(430,"Aguirre","Ana Paula","131","430");
        Alumno alumno5=new Alumno(429,"Andrada","Maria Morena","141","429");
        //Tipo profesor
        Profesor profesor1=new Profesor(987,"Sanchez","Mariana","123","Asociado");
        Profesor profesor2=new Profesor(986,"Nieto","Luis","124","Titular");
        Profesor profesor3=new Profesor(985,"Semola","Enzo","125","JTP");
        Profesor profesor4=new Profesor(984,"Guzman","Fernanda","126","Titular");
        Profesor profesor5=new Profesor(983,"Younes","Jose","127","Asociado");
        //Tipo grupos
        Grupo grupo1=new Grupo("Grupo1","Computacion");
        Grupo grupo2=new Grupo("Grupo2","Electronica");
        Grupo grupo3=new Grupo("Grupo3","Biomedica");
        Grupo grupo4=new Grupo("Grupo4","Mecanica");
        Grupo grupo5=new Grupo("Grupo5","Civil");
        //Tipo idioma
        Idioma idioma1=new Idioma("Ingles");
        Idioma idioma2=new Idioma("Portugués");
        Idioma idioma3=new Idioma("Francés");
        Idioma idioma4=new Idioma("Ruso");
        Idioma idioma5=new Idioma("Español");
        //Tipo lugar
        Lugar lugar1=new Lugar("Facultad");
        Lugar lugar2=new Lugar("Congreso");
        Lugar lugar3=new Lugar("Revista científica");
        Lugar lugar4=new Lugar("Libro");
        Lugar lugar5=new Lugar("Paper");
        //Tipo palabras claves
        PalabraClave palabraClave1=new PalabraClave("Enlance");
        PalabraClave palabraClave2=new PalabraClave("Ingenieria");
        PalabraClave palabraClave3=new PalabraClave("Java");
        PalabraClave palabraClave4=new PalabraClave("Facultad");
        PalabraClave palabraClave5=new PalabraClave("Aula");
        //Tipo tipo
        Tipo tipo1=new Tipo("Trabajo en el congreso");
        Tipo tipo2=new Tipo("Capitulo de libro");
        Tipo tipo3=new Tipo("Tesis");
        Tipo tipo4=new Tipo("Libro");
        Tipo tipo5=new Tipo("Anexo");

        //Agrego los objetos a las arraylist
        losAlumnos.add(alumno1);
        losAlumnos.add(alumno2);
        losAlumnos.add(alumno3);
        losAlumnos.add(alumno4);
        losAlumnos.add(alumno5);
        losProfesores.add(profesor1);
        losProfesores.add(profesor2);
        losProfesores.add(profesor3);
        losProfesores.add(profesor4);
        losProfesores.add(profesor5);
        losGrupos.add(grupo1);
        losGrupos.add(grupo2);
        losGrupos.add(grupo3);
        losGrupos.add(grupo4);
        losGrupos.add(grupo5);
        losIdiomas.add(idioma1);
        losIdiomas.add(idioma2);
        losIdiomas.add(idioma3);
        losIdiomas.add(idioma4);
        losIdiomas.add(idioma5);
        losLugares.add(lugar1);
        losLugares.add(lugar2);
        losLugares.add(lugar3);
        losLugares.add(lugar4);
        losLugares.add(lugar5);
        lasPalabrasClave.add(palabraClave1);
        lasPalabrasClave.add(palabraClave2);
        lasPalabrasClave.add(palabraClave3);
        lasPalabrasClave.add(palabraClave4);
        lasPalabrasClave.add(palabraClave5);
        losTipos.add(tipo1);
        losTipos.add(tipo2);
        losTipos.add(tipo3);
        losTipos.add(tipo4);
        losTipos.add(tipo5);

        //Recorro y muestro los ArrayList

        for(Alumno i:losAlumnos){i.mostrar();}
        for(Profesor i:losProfesores){i.mostrar();}
        for(Grupo i:losGrupos){i.mostrar();}
        for(Idioma i:losIdiomas){
            System.out.println(i);
        }
        for(Lugar i:losLugares){
            System.out.println(i);
        }
        for(PalabraClave i: lasPalabrasClave){
            System.out.println(i);
        }
        for(Tipo i: losTipos){
            System.out.println(i);
        }

       ( losAlumnos(1).nombres="Ernesto";
        No se puede ya que nombres es un atributo privado

        Para realizar modificaciones en los atributos tengo que hacerlo con el método set, en nuestro caso llamamos asignar)

        alumno1.asignarApellidos("Figueroa");
        alumno2.asignarNombres("Juan");
        profesor1.asignarCargo("Titular");
        profesor3.asignarNombres("Sofia");
        grupo4.asignarNombre("Grupo 20");
        grupo5.asignarDescripcion("Licenciatura en física");
        idioma2.asignarNombre("Alemán");
        lugar5.asignarNombre("Internet");
        palabraClave2.asignarNombre("Procesadores");
        tipo1.asignarNombre("Libro digital");

        //Muestro los ArrayList modificados
        for(Alumno i:losAlumnos){i.mostrar();}
        for(Profesor i:losProfesores){i.mostrar();}
        for(Grupo i:losGrupos){i.mostrar();}
        for(Idioma i:losIdiomas){
            System.out.println(i);
        }
        for(Lugar i:losLugares){
            System.out.println(i);
        }
        for(PalabraClave i: lasPalabrasClave){
            System.out.println(i);
        }
        for(Tipo i: losTipos){
            System.out.println(i);
        }






        (Se agrego los paquetes autores.vistas, grupos.vistas, idiomas.vistas, lugares.vistas, palabrasclaves.vistas
        y tipos.vistas donde se coloco VentanaA de cada uno

        Para poder utilizar esto ultimo debemos hacer algunas modificaciones)

        */
        asignarLookAndFeel("Nimbus");
        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
        ventanaAlumno.setVisible(true); //se hace visible la ventana

        asignarLookAndFeel("Nimbus");
        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
        ventanaProfesor.setVisible(true); //se hace visible la ventana

        asignarLookAndFeel("Nimbus");
        VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
        ventanaGrupo.setVisible(true); //se hace visible la ventana

        asignarLookAndFeel("Nimbus");
        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
        ventanaIdioma.setVisible(true); //se hace visible la ventana

        asignarLookAndFeel("Nimbus");
        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
        ventanaLugar.setVisible(true); //se hace visible la ventana

        asignarLookAndFeel("Nimbus");
        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
        ventanaPalabraClave.setVisible(true); //se hace visible la ventana

        asignarLookAndFeel("Nimbus");
        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
        ventanaTipo.setVisible(true); //se hace visible la ventana
    }

    public static void asignarLookAndFeel(String laf) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (laf.equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                }
            }
        } catch (Exception e) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }
            catch (Exception e2) {
                System.exit(0);
            }
        }
    }
}
