package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;

public class MobilePhoneTableModel extends GenericTableModel {
	private MobilePhoneFactory af;
	private MobilePhone[] rowData;

	public MobilePhoneTableModel() {
		af=new MobilePhoneFactory();
		rowData=af.getAllMobilePhones();
	}

	public GenericEditor getEditor() {
		return new MobilePhoneEditor();
	}

	public Object getRowData(int row) {
		return rowData[row];
	}

	public String getColumnName(int col) {
		switch (col) {
			case 0:
				return "Number";
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
				return rowData[row].getNumber();
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
