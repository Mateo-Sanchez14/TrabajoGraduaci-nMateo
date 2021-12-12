package grupos.modelos;

import autores.modelos.Autor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaMiembros extends AbstractTableModel {
    private List<String> nombresColumnas = new ArrayList<>();
    private List<MiembroEnGrupo> miembros = new ArrayList<>();

    public ModeloTablaMiembros() {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");
    }

    public ModeloTablaMiembros(String nombre) {
        this.nombresColumnas.add("Nombre");
        this.nombresColumnas.add("Rol");

        GestorGrupos gestor = GestorGrupos.instanciar();
        this.miembros = gestor.verGrupo(nombre).verMiembros();
    }

    @Override
    public int getRowCount() {
        return this.miembros.size();
    }

    @Override
    public int getColumnCount() {
        return this.nombresColumnas.size();
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        MiembroEnGrupo d = this.miembros.get(fila);
        switch (columna) {
            case 0 : return d.verAutor()  ;
            default: return d.verRol();
        }
    }

    @Override
    public String getColumnName(int columna) {
        return this.nombresColumnas.get(columna);
    }

    public void refrescarTabla(List<MiembroEnGrupo> miembros) {
        this.miembros = miembros;
        this.fireTableDataChanged();
    }

    public Autor verAutor(int fila) {
        return this.miembros.get(fila).verAutor();

    }
}
