package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;

public class CarTableModel extends GenericTableModel {
	private CarFactory af;
	private Car[] rowData;

	public CarTableModel() {
		af=new CarFactory();
		rowData=af.getAllCars();
	}

	public GenericEditor getEditor() {
		return new CarEditor();
	}

	public Object getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
			case 0:
				return "Registration number";
			case 1:
				return "Car type";
			case 2:
				return "Number of seats";
			case 3:
				return "Misc info";
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
				return rowData[row].getRegNo();
			case 1:
				return rowData[row].getCarType();
			case 2:
				return new Integer(rowData[row].getNumberOfSeats());
			case 3:
				return rowData[row].getMiscInfo();
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
		(new CarFactory()).deleteCar((Car)getRowData(row));
		Car[] ar=new Car[rowData.length - 1];

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
