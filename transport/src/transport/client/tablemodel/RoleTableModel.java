package transport.client.tablemodel;

import transport.client.*;
import transport.logic.*;
import transport.server.*;
import java.util.ArrayList;
import transport.client.editor.*;

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
                        case 2:
                                return "Initial";
		}

		return "FIXME";
	}

	public int getRowCount() {
		return rowData.length;
	}

	public int getColumnCount() {
		return 3;
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
			case 0:
				return rowData[row].getShortDescr();
			case 1:
				return rowData[row].getLongDescr();
                        case 2:
                                return rowData[row].getInitial();
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
		Role[] ar=new Role[rowData.length - 1];

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
		return new Role[len];
	}

	public void refresh(LogicItem o, int refreshType) {
		if (o instanceof Role) {
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
		rowData=(Role[])super.insert(o,rowData);
	}
        public void refresh() {
          rowData=af.getAllRoles();
          fireTableDataChanged();
        }
}
