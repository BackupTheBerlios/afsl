package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;

public class RoleTableModel extends GenericTableModel {
	private RoleFactory af;
	private Role[] rowData;

	public RoleTableModel() {
		af=new RoleFactory();
		rowData=af.getAllRoles();
	}

	public GenericEditor getEditor() {
		return new RoleEditor();
	}

	public Object getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
			case 0:
				return "Short description";
			case 1:
				return "Long description";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 2;
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
			case 0:
				return rowData[row].getShortDescr();
			case 1:
				return rowData[row].getLongDescr();
		}

		// FIXME: should not happen. Log error if it does.

		return null;
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		fireTableCellUpdated(row, col);
	}

	/**
	 * remove
	 *
	 * @param row int
	 */
	public void remove(int row) {
		(new RoleFactory()).deleteRole((Role)getRowData(row));
		fireTableDataChanged();
	}
}
