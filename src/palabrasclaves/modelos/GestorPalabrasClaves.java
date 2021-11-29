package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.GestorTipos;
import tipos.modelos.Tipo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorPalabrasClaves implements IGestorPalabrasClaves {
    List<PalabraClave> palabrasClaves = new ArrayList<>();

    private static GestorPalabrasClaves gestor;

    private GestorPalabrasClaves() {
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
        escribirArchivo();
        return EXITO;
    }

    public List<PalabraClave> verPalabrasClaves() {
        this.leerArchivo();
        Collections.sort(this.palabrasClaves);
        return this.palabrasClaves;
    }

    public PalabraClave verPalabraClave(String nombre) {
        for (PalabraClave x : palabrasClaves) {
            if (x.verNombre().equals(nombre)) {
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
        this.escribirArchivo();
        return EXITO;
    }

    @Override
    public List<PalabraClave> buscarPalabrasClaves(String nombre) {
        List<PalabraClave> palabrasEncontradas = new ArrayList<>();
        for (PalabraClave x : this.palabrasClaves) {
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

    private void leerArchivo() {
        palabrasClaves.removeAll(palabrasClaves);
        BufferedReader br = null;
        File file = new File(TEXTO);

        if (file.exists()) {
            try {
                FileReader fr = new FileReader(file);
                br = new BufferedReader(fr);
                String cadena;
                while((cadena = br.readLine()) != null) {
                    this.nuevaPalabraClave(cadena);
                }
            }
            catch (IOException ioe) {
                System.out.println("No se pudo leer el archivo de texto");
            }
            finally {
                if (br != null) {
                    try {
                        br.close();
                    }
                    catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
        }
    }

    private void escribirArchivo() {
        BufferedWriter bw = null;
        File file = new File(TEXTO);

        try {
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for(int i = 0; i < this.palabrasClaves.size(); i++) {
                PalabraClave unaPalabra = this.palabrasClaves.get(i);
                String cadena = unaPalabra.verNombre();

                bw.write(cadena);
                if (i < this.palabrasClaves.size() - 1)
                    bw.newLine();
            }
        }
        catch (IOException ioe) {
            System.out.println("Error al escribir el archivo");
        }
        finally {
            if (bw != null) {
                try {
                    bw.close();
                }
                catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }
}
