package autores.modelos;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaAlumnos extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<Alumno> alumnos = new ArrayList<>();

    public ModeloTablaAlumnos() {
        this.nombresColumnas.add("DNI");
        this.nombresColumnas.add("Apellidos");
        this.nombresColumnas.add("Nombres");
        this.nombresColumnas.add("CX");

        GestorAutores gestor = GestorAutores.instanciar();
        this.alumnos = gestor.verAlumnos();
    }

    @Override
    public int getRowCount() {
        return this.alumnos.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Alumno d = this.alumnos.get(fila);
        switch (columna) {
            case 0 : return d.verDni();
            case 1 : return d.verApellidos();
            case 2 : return d.verNombres();
            default: return d.verCx();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public void refrescarTabla(List<Alumno> alumnos) {
        this.alumnos = alumnos;
        this.fireTableDataChanged();
    }
}
