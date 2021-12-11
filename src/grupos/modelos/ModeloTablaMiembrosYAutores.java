package grupos.modelos;

import autores.modelos.Autor;
import autores.modelos.GestorAutores;
import interfaces.IGestorAutores;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeloTablaMiembrosYAutores extends AbstractTableModel {
    List<String> tituloColumnas = new ArrayList<>(Arrays.asList("Nombre", "Rol"));
    List<MiembroEnGrupo> miembrosDisponibles = new ArrayList<>();

    public ModeloTablaMiembrosYAutores() {
        IGestorAutores gestor = GestorAutores.instanciar();
        for (Autor aux : gestor.verAutores()) {
            this.miembrosDisponibles.add(new MiembroEnGrupo(aux, null, null));
        }
    }

    @Override
    public int getRowCount() {
        return this.miembrosDisponibles.size();
    }

    @Override
    public int getColumnCount() {
        return this.tituloColumnas.size();
    }

    @Override
    public String getColumnName(int column) {
        return this.tituloColumnas.get(column);

    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo aux = this.miembrosDisponibles.get(fila);
        switch (columna) {
            case 0:
                return aux.verAutor();
            default:
                return aux.verRol();
        }
    }

    @Override
    public Class getColumnClass(int columna) {
        switch (columna) {
            case 0:
                return Autor.class;
            default:
                return Rol.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columna) {
        if (columna == 1) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object valor, int fila, int columna) {
        MiembroEnGrupo aux = this.miembrosDisponibles.get(fila);
        if (columna == 1) {
            aux.asignarRol((Rol) valor);
        }

    }

    public Autor verAutor(int fila) {
        return this.miembrosDisponibles.get(fila).verAutor();
    }
}
