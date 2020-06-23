package Vista;

import POJO.Trabajador;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TrabajadoresTabla extends AbstractTableModel {
    List<Trabajador> trabajadores;
    String[] columnas = {"Id", "Nombre", "Apellido", "Genero", "Puesto de Trabajo"};

    public TrabajadoresTabla(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return trabajadores.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Trabajador trabajador = trabajadores.get(fila);
        switch (columna) {
            case 0: return trabajador.getId();
            case 1: return trabajador.getNombre();
            case 2: return trabajador.getApellido();
            case 3: return trabajador.getGenero();
            case 4: return trabajador.getPuestoTrabajo();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        if (columna == 0) {
            return false;
        } else {
            return true;
        }
    }

}
