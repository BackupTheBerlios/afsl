package transport.client.tablemodel;

import transport.client.PlaceEditor;
import transport.logic.Place;
import transport.server.PlaceFactory;
import javax.swing.JInternalFrame;

public class PlaceTableModel extends GenericTableModel {
	private PlaceFactory af;
	private Place[] rowData;

	public PlaceTableModel() {
		af=new PlaceFactory();
		rowData=af.getAllPlaces();
	}

	public JInternalFrame getEditor() {
		return (JInternalFrame)new PlaceEditor();
	}

	public Place getRowData(int row) {
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
			return "No of Places";
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
			return new Integer(rowData[row].getNoOfPlaces());
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
