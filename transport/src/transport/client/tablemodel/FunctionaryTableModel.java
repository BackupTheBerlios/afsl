package transport.client.tablemodel;

import transport.logic.Functionary;
import transport.server.FunctionaryFactory;
import javax.swing.JInternalFrame;
import transport.client.FunctionaryEditor;

public class FunctionaryTableModel extends GenericTableModel {
	private FunctionaryFactory af;
	private Functionary[] rowData;

	public FunctionaryTableModel() {
		af=new FunctionaryFactory();
		rowData=af.getAllFunctionaries();
	}

	public JInternalFrame getEditor() {
		return (JInternalFrame)new FunctionaryEditor();
	}

	public Functionary getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
		case 0:
			return "Name";
		case 1:
			return "Contact name";
		case 2:
			return "Telephone number";
		case 3:
			return "Arrival";
		case 4:
			return "Arrival time";
		case 5:
			return "Hotel";
		case 6:
			return "Departure";
		case 7:
			return "Departure Time";
		case 8:
			return "No of Functionaries";
		case 9:
			return "No of Crew";
		case 10:
			return "No of Guests";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 11;
	}

	public Object getValueAt(int row, int col) {
		/*
		switch (col) {
		case 0:
			return rowData[row].getName();
		case 1:
			return rowData[row].getContactName();
		case 2:
			return rowData[row].getTelephoneNo();
		case 3:
			return rowData[row].getArrival();
		case 4:
			return rowData[row].getArrivalTime();
		case 5:
			return rowData[row].getHotel();
		case 6:
			return rowData[row].getDeparture();
		case 7:
			return rowData[row].getDepartureTime();
		case 8:
			return new Integer(rowData[row].getNoOfFunctionarys());
		case 9:
			return new Integer(rowData[row].getNoOfCrew());
		case 10:
			return new Integer(rowData[row].getNoOfGuests());
		}
		*/

		// FIXME: should not happen. Log error if it does.

		return null;
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void setValueAt(Object value, int row, int col) {
		fireTableCellUpdated(row, col);
	}
}
