package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;
import java.util.ArrayList;

public class TransportTableModel extends GenericTableModel {
	private TransportFactory tf;
	private Transport[] rowData;

	public TransportTableModel() {
		tf=new TransportFactory();
		rowData=tf.getAllTransports();
	}

	public GenericEditor getEditor() {
		return new TransportEditor();
	}

	public Object getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
                case 0:
                       return "Direction";
		case 1:
			return "Artists";
		case 2:
			return "Cars";
		case 3:
			return "Functionaries";
		case 4:
			return "Internal";
		case 5:
			return "Waypoints";
		case 6:
			return "Mobile phones";
		case 7:
			return "Start time";
		case 8:
			return "Return time";
		case 9:
			return "Actual return time";
		case 10:
			return "Distance";
		case 11:
			return "Actual return time";
		case 12:
			return "Misc info";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 13;
	}

	private String fixString(Object[] o) {
		String s=new String();
		for (int i=0; i < o.length - 1; i++) {
			s=s + o[i].toString() + ", ";
		}
		if (o.length > 0) {
			s=s + o[o.length - 1].toString();
		}

		return s;
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
                        case 0:
				return rowData[row].getDirection();
			case 1:
				return fixString(rowData[row].getArtists());
			case 2:
				return fixString(rowData[row].getCars());
			case 3:
				return fixString(rowData[row].getFunctionaries());
			case 4:
				if (rowData[row].getInternal()) {
					return "Yes";
				} else {
					return "";
				}
			case 5:
				return fixString(rowData[row].getWaypoints());
			case 6:
				return fixString(rowData[row].getMobilePhones());
			case 7:
				return rowData[row].getStartTime();
			case 8:
				return rowData[row].getReturnTime();
			case 9:
				return rowData[row].getActualReturnTime();
			case 10:
				return new Integer(0);
			case 11:
				return rowData[row].getActualReturnTime();
			case 12:
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
		(new TransportFactory()).deleteTransport((Transport)getRowData(row));
		Transport[] ar=new Transport[rowData.length - 1];

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

	protected LogicItem[] resizeArray(int len) {
		return new Transport[len];
	}

	public void refresh(LogicItem o, int refreshType) {
		if (o instanceof Transport) {
			super.refresh(o, refreshType);
		}
	}

	/**
	 * remove
	 *
	 * @param o LogicItem
	 */
	protected void remove(LogicItem o) {
		super.remove(o, rowData);
	}

	/**
	 * insert
	 *
	 * @param o LogicItem
	 */
	protected void insert(LogicItem o) {
		rowData=(Transport[])super.insert(o,rowData);
	}

        public void refresh() {
          rowData=tf.getAllTransports();
          fireTableDataChanged();
        }
}
