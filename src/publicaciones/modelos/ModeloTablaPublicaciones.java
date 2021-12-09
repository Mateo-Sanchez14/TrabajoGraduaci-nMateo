/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publicaciones.modelos;

import interfaces.IGestorPublicaciones;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ModeloTablaPublicaciones extends AbstractTableModel{
    
    List<String> nombreColumnas=new ArrayList<>();
    List<Publicacion> publiciones=new ArrayList<>();

    public ModeloTablaPublicaciones() {
        nombreColumnas.add("Titulo");
        nombreColumnas.add("Autor");
        nombreColumnas.add("Año");
        IGestorPublicaciones gestor=GestorPublicaciones.instanciar();
        this.publiciones=gestor.verPublicaciones();
    }
      
    @Override
    public int getRowCount() {
        return this.publiciones.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombreColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Publicacion a=this.publiciones.get(fila);
        switch(columna){
            case 0: return a.verTitulo();
            case 1: return a.verMiembroEnGrupo().verAutor();
            default: return a.verFechaPublicacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return this.nombreColumnas.get(column);
    }
    
    public Publicacion Vergrupo(int fila){
        return this.publiciones.get(fila);
    }
    
    public void refrescarDatosDeTabla(){
        IGestorPublicaciones gestor=GestorPublicaciones.instanciar();
        this.publiciones=gestor.verPublicaciones();
        this.fireTableDataChanged();
    }
    
    public void refrescarDatosDeTabla(List<Publicacion> publicaciones){
        this.publiciones=publicaciones;
        this.fireTableDataChanged();
    }
    
    
    
}
