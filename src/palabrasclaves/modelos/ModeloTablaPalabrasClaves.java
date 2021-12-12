package palabrasclaves.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaPalabrasClaves extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<PalabraClave> palabrasClaves = new ArrayList<>();

    public ModeloTablaPalabrasClaves() {
        this.nombresColumnas.add("Nombre");

        GestorPalabrasClaves gestor = GestorPalabrasClaves.instanciar();
        this.palabrasClaves = gestor.verPalabrasClaves();
    }

    @Override
    public int getRowCount() {
        return this.palabrasClaves.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        PalabraClave d = this.palabrasClaves.get(fila);
        switch (columna) {
            case 0 : return d.verNombre();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public void refrescarTabla(List<PalabraClave> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
        this.fireTableDataChanged();
    }

    public PalabraClave verPalabraClave(int fila) {
        return palabrasClaves.get(fila);
    }
}
