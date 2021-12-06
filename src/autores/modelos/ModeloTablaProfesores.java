package autores.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaProfesores extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();

    public ModeloTablaProfesores(){
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("Cargo");

        GestorAutores gestor = GestorAutores.instanciar();
        this.profesores = gestor.verProfesores();
    }

    @Override
    public int getRowCount() {
        return this.profesores.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Profesor d = this.profesores.get(fila);
        switch (columna) {
            case 0 : return d.verDni();
            case 1 : return d.verApellidos();
            case 2 : return d.verNombres();
            default: return d.verCargo();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public void refrescarTabla(List<Profesor> profesores) {
        this.profesores = profesores;
        this.fireTableDataChanged();
    }
}
