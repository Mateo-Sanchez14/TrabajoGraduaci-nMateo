package principal.controladores;

import autores.modelos.Alumno;
import autores.modelos.Profesor;
import grupos.modelos.Grupo;
import idiomas.modelos.Idioma;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

import java.util.ArrayList;

public class ControladorPrincipal {
    public static void main(String[] args) {
        /*
        //Creación de las ArrayList de las clases
        ArrayList<Alumno> listaAlumnos= new ArrayList<>();
        ArrayList<Profesor> listaProfesores= new ArrayList<>();
        ArrayList<Idioma> listaIdiomas= new ArrayList<>();
        ArrayList<Lugar> listaLugares = new ArrayList<>();
        ArrayList<PalabraClave> listaPalabras = new ArrayList<>();
        ArrayList<Tipo> listaTipos = new ArrayList<>();
        ArrayList<Grupo> listaGrupos = new ArrayList<>();

        Alumno unAlumno1 = new Alumno(123,"Andrada", "Luis Elian", "contra1","123");
        Alumno unAlumno2 = new Alumno(124,"Sanchez", "Mateo", "contra2","124");
        Alumno unAlumno3 = new Alumno(125,"Carrizo", "Agustin", "contra3","125");
        Alumno unAlumno4 = new Alumno(126,"Cascales", "Benjamin", "contra4","126");
        Alumno unAlumno5 = new Alumno(127,"Gimenez Canepa", "Ignacio", "contra5","127");
        listaAlumnos.add(unAlumno1);
        listaAlumnos.add(unAlumno2);
        listaAlumnos.add(unAlumno3);
        listaAlumnos.add(unAlumno4);
        listaAlumnos.add(unAlumno5);

        Profesor unProfesor1 = new Profesor(001, "Sémola", "Enzo", "clave1", "JTP");
        Profesor unProfesor2 = new Profesor(001, "Sanchez", "Mariana", "clave2", "Jefa Suprema");
        Profesor unProfesor3 = new Profesor(001, "Younes", "José", "clave3", "Adjunto");
        Profesor unProfesor4 = new Profesor(001, "Nieto", "Luis", "clave4", "Adjunto");
        Profesor unProfesor5 = new Profesor(001, "Guzmán", "María Fernanda", "clave5", "Secretaria Académica");
        listaProfesores.add(unProfesor1);
        listaProfesores.add(unProfesor2);
        listaProfesores.add(unProfesor3);
        listaProfesores.add(unProfesor4);
        listaProfesores.add(unProfesor5);

        Idioma unIdioma1 = new Idioma("Español");
        Idioma unIdioma2 = new Idioma("Inglés");
        Idioma unIdioma3 = new Idioma("Portugués");
        Idioma unIdioma4 = new Idioma("Italiano");
        Idioma unIdioma5 = new Idioma("Francés");
        listaIdiomas.add(unIdioma1);
        listaIdiomas.add(unIdioma2);
        listaIdiomas.add(unIdioma3);
        listaIdiomas.add(unIdioma4);
        listaIdiomas.add(unIdioma5);

        Lugar unLugar1 = new Lugar("Aula 1");
        Lugar unLugar2 = new Lugar("Aula 2");
        Lugar unLugar3 = new Lugar("Aula 3");
        Lugar unLugar4 = new Lugar("Aula 4");
        Lugar unLugar5 = new Lugar("Aula 5");
        listaLugares.add(unLugar1);
        listaLugares.add(unLugar2);
        listaLugares.add(unLugar3);
        listaLugares.add(unLugar4);
        listaLugares.add(unLugar5);

        PalabraClave unaPalabra1 = new PalabraClave("Alambre de Pua");
        PalabraClave unaPalabra2 = new PalabraClave("Dulce de leche");
        PalabraClave unaPalabra3 = new PalabraClave("Perro");
        PalabraClave unaPalabra4 = new PalabraClave("Gato");
        PalabraClave unaPalabra5 = new PalabraClave("Tanque Beutepanzer ");
        listaPalabras.add(unaPalabra1);
        listaPalabras.add(unaPalabra2);
        listaPalabras.add(unaPalabra3);
        listaPalabras.add(unaPalabra4);
        listaPalabras.add(unaPalabra5);

        Tipo unTipo1 = new Tipo("Tipo 1");
        Tipo unTipo2 = new Tipo("Tipo 2");
        Tipo unTipo3 = new Tipo("Tipo 3");
        Tipo unTipo4 = new Tipo("Tipo 4");
        Tipo unTipo5 = new Tipo("Tipo 5");
        listaTipos.add(unTipo1);
        listaTipos.add(unTipo2);
        listaTipos.add(unTipo3);
        listaTipos.add(unTipo4);
        listaTipos.add(unTipo5);

        Grupo unGrupo1 = new Grupo("Grupo 1", "Descripción 1");
        Grupo unGrupo2 = new Grupo("Grupo 2", "Descripción 2");
        Grupo unGrupo3 = new Grupo("Grupo 3", "Descripción 3");
        Grupo unGrupo4 = new Grupo("Grupo 4", "Descripción 4");
        Grupo unGrupo5 = new Grupo("Grupo 5", "Descripción 5");
        listaGrupos.add(unGrupo1);
        listaGrupos.add(unGrupo2);
        listaGrupos.add(unGrupo3);
        listaGrupos.add(unGrupo4);
        listaGrupos.add(unGrupo5);

        //Recorro las distintas ArrayList
        listaAlumnos.forEach(x -> x.mostrar());
        listaProfesores.forEach(x -> x.mostrar());
        listaGrupos.forEach(x -> x.mostrar());
        listaIdiomas.forEach(x ->
                System.out.println(x.toString())
        );
        listaPalabras.forEach(x ->
                System.out.println(x.toString())
        );
        listaTipos.forEach(x ->
                System.out.println(x.toString())
        );
        listaLugares.forEach(x ->
                System.out.println(x.toString())
        );

        //Modifico atributos
        unGrupo1.asignarNombre("Grupo 1 modificado");

        //Recorro las distintas ArrayList
        listaAlumnos.forEach(x -> x.mostrar());
        listaProfesores.forEach(x -> x.mostrar());
        listaGrupos.forEach(x -> x.mostrar());
        listaIdiomas.forEach(x ->
                System.out.println(x.toString())
        );
        listaPalabras.forEach(x ->
                System.out.println(x.toString())
        );
        listaTipos.forEach(x ->
                System.out.println(x.toString())
        );
        listaLugares.forEach(x ->
                System.out.println(x.toString())
        );
        */


    }
}
