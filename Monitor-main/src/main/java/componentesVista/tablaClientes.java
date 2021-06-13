package componentesVista;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class tablaClientes implements TableModel{
	private LinkedList<Integer> clientes;
	private LinkedList<Integer> box;
	private LinkedList<String> nombres;
	
	private Class[] types;
	private String[] columnName;
	
	public tablaClientes() {
		this.clientes = new LinkedList<Integer>();
		this.box = new LinkedList<Integer>();
		this.nombres = new LinkedList<String>();
		this.types = new Class[3];
		types[0] = java.lang.Integer.class;
		types[1] = java.lang.Integer.class;
		types[2] = java.lang.String.class;
		this.columnName = new String[3];
		columnName[0] = "Box";
		columnName[1] = "DNI";
		columnName[2] = "Nombre";
	}

	public void addTableModelListener(TableModelListener arg0) {
	}

	public Class<?> getColumnClass(int columna) {
		return types[columna];
	}

	public int getColumnCount() {
		return 3;
	}

	public String getColumnName(int columna) {
		return columnName[columna];
	}

	public int getRowCount() {
		return this.clientes.size();
	}

	public Object getValueAt(int fila, int columna) {
		Object auxObj = null;
		if(!this.clientes.isEmpty() && fila<this.clientes.size()) {
			Integer box = this.box.get(fila);
			Integer dni = this.clientes.get(fila);
			String nombre = this.nombres.get(fila);
			switch(columna) {
				case 0: auxObj = Integer.toString(box);
						break;
				case 1:	auxObj = Integer.toString(dni);
						break;
				case 2: auxObj = nombre;
				        break;
			}
		}
		return auxObj;
	}

	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	public void removeTableModelListener(TableModelListener arg0) {
	}

	public void setValueAt(Object arg0, int arg1, int arg2) {
	}

	public void setClientes(LinkedList<Integer> clientes) {
		this.clientes = clientes;
	}

	public void setBox(LinkedList<Integer> box) {
		this.box = box;
	}
	
	public void setNombres(LinkedList<String> nombres) {
		this.nombres = nombres;
	}

}
