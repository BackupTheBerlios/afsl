package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;

public class PlaceTableModel extends GenericTableModel {
	private PlaceFactory af;
	private Place[] rowData;

	public PlaceTableModel() {
		af=new PlaceFactory();
		rowData=af.getAllPlaces();
	}

	public GenericEditor getEditor() {
		return new PlaceEditor();
	}

	public Object getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
			case 0:
				return "Name";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 1;
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
			case 0:
				return rowData[row].getName();
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
		(new PlaceFactory()).deletePlace((Place)getRowData(row));
		fireTableDataChanged();
	}
}
