package transport.client.tablemodel;

import transport.logic.*;
import transport.server.TransportFactory;
import javax.swing.JInternalFrame;
import transport.client.TransportEditor;

public class TransportTableModel extends GenericTableModel {
	private TransportFactory tf;
	private Transport[] rowData;

	public TransportTableModel() {
		tf=new TransportFactory();
		rowData=tf.getAllTransports();
	}

	public JInternalFrame getEditor() {
		return (JInternalFrame)new TransportEditor();
	}

	public Transport getRowData(int row) {
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
			return "No of Transports";
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
		switch (col) {
		case 0:
			Artist[] a=rowData[row].getArtists();
			String s=new String();
			for (int i=0;i<a.length-1;i++) {
				s=s + a.toString() + ", ";
			}
			s=s + a[a.length-1];

			return a;
		case 1:
			Car[] c=rowData[row].getCars();
			String s2=new String();
			for (int i=0;i<c.length-1;i++) {
				s2=s2 + c.toString() + ", ";
			}
			s2=s2 + c[c.length-1];

			return s2;
		case 2:
			Functionary[] f=rowData[row].getFunctionaries();
			String s3=new String();
			for (int i=0;i<f.length-1;i++) {
				s3=s3+f.toString() + ", ";
			}
			s3=s3 + f[f.length-1];
			return s3;
			/*
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
			return new Integer(rowData[row].getNoOfTransports());
		case 9:
			return new Integer(rowData[row].getNoOfCrew());
		case 10:
			return new Integer(rowData[row].getNoOfGuests());
				*/
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
}
