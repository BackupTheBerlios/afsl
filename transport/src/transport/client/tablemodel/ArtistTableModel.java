package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;
import transport.logic.Artist;
import java.util.ArrayList;

public class ArtistTableModel extends GenericTableModel {
	private ArtistFactory af;
	private Artist[] rowData;

	public ArtistTableModel() {
          af=new ArtistFactory();
          rowData=af.getAllArtists();
	}

	public GenericEditor getEditor() {
		return new ArtistEditor();
	}

	public Object getRowData(int row) {
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
				return "Arrival Time";
                        case 5:
				return "Arrival Flight #";
			case 6:
				return "Hotel";
			case 7:
				return "Departure";
			case 8:
				return "Departure Time";
                        case 9:
				return "Departure Flight #";
                        case 10:
                                return "Stage";
			case 11:
				return "No of Artists";
			case 12:
				return "No of Crew";
			case 13:
				return "No of Guests";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 14;
	}

	public Object getValueAt(int row, int col) {
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
				return rowData[row].getArrivalFlightNo();
			case 6:
				return rowData[row].getHotel();
			case 7:
				return rowData[row].getDeparture();
			case 8:
				return rowData[row].getDepartureTime();
                        case 9:
				return rowData[row].getDepartureFlightNo();
                        case 10:
				return rowData[row].getStage();
			case 11:
				return new Integer(rowData[row].getNoOfArtists());
			case 12:
				return new Integer(rowData[row].getNoOfCrew());
			case 13:
				return new Integer(rowData[row].getNoOfGuests());
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
		(new ArtistFactory()).deleteArtist((Artist)getRowData(row));
		Artist[] ar=new Artist[rowData.length-1];

		int mod=0;
		for (int i=0; i < rowData.length;i++) {
			if (i != row) {
				ar[i+mod]=rowData[i];

			} else{
				mod=-1;
			}
		}

		rowData=ar;

		fireTableDataChanged();
	}

	protected LogicItem[] resizeArray(int len) {
		return new Artist[len];
	}

	public void refresh(LogicItem o, int refreshType) {
		if (o instanceof Artist) {
			super.refresh(o, refreshType);
		}
	}

	/**
	 * insert
	 *
	 * @param o LogicItem
	 */
	protected void insert(LogicItem o) {
		rowData=(Artist[])super.insert(o,rowData);
	}

	/**
	 * remove
	 *
	 * @param o LogicItem
	 */
	protected void remove(LogicItem o) {
		super.remove(o, rowData);
	}

  public void refresh() {
    rowData=af.getAllArtists();
    fireTableDataChanged();
  }
}
