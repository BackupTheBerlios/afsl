package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;

public class FunctionaryTableModel extends GenericTableModel {
	private FunctionaryFactory af;
	private Functionary[] rowData;

	public FunctionaryTableModel() {
		af=new FunctionaryFactory();
		rowData=af.getAllFunctionaries();
	}

	public GenericEditor getEditor() {
		return new FunctionaryEditor();
	}

	public Object getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
			case 0:
				return "Name";
			case 1:
				return "Role";
			case 2:
				return "Begins working";
			case 3:
				return "Stops working";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 4;
	}

	public Object getValueAt(int row, int col) {

		switch (col) {
			case 0:
				return rowData[row].getName();
			case 1:
				return rowData[row].getRole();
			case 2:
				return rowData[row].getBeginsWork();
			case 3:
				return rowData[row].getStopsWork();
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
		(new FunctionaryFactory()).deleteFunctionary((Functionary)getRowData(row));
		Functionary[] ar=new Functionary[rowData.length-1];

		int mod=0;
		for (int i=0; i < rowData.length; i++) {
			if (i != row) {
				ar[i + mod]=rowData[i];

			} else {
				mod= -1;
			}
		}

		rowData=ar;

		fireTableDataChanged();
	}
}
