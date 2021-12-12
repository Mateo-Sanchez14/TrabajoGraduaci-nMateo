package autores.modelos;

import grupos.modelos.GestorGrupos;
import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaGruposAutor extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> grupos = new ArrayList<>();

    public ModeloTablaGruposAutor() {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Descripción");
    }

    public ModeloTablaGruposAutor(int dni) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Descripción");

        GestorAutores gestorAutores = GestorAutores.instanciar();
        this.grupos = gestorAutores.verAutor(dni).verGrupo();
    }

    @Override
    public int getRowCount() {
        return this.grupos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo d = this.grupos.get(fila);
        switch (columna) {
            case 0 : return d.verGrupo().verNombre();
            default: return d.verGrupo().verDescripcion();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public void refrescarTabla(List<MiembroEnGrupo> grupos) {
        this.grupos = grupos;
        this.fireTableDataChanged();
    }
}
