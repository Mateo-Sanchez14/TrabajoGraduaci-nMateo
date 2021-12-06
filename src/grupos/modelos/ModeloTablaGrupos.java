package grupos.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaGrupos extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<Grupo> grupos = new ArrayList<>();

    public ModeloTablaGrupos() {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Descripción");

        GestorGrupos gestor = GestorGrupos.instanciar();
        this.grupos = gestor.verGrupos();
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
        Grupo d = this.grupos.get(fila);
        switch (columna) {
            case 0 : return d.verNombre();
            default: return d.verDescripcion();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public void refrescarTabla(List<Grupo> grupos) {
        this.grupos = grupos;
        this.fireTableDataChanged();
    }
}
