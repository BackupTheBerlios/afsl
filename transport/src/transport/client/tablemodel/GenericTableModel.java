package transport.client.tablemodel;

import javax.swing.table.*;
import transport.logic.LogicItem;
import transport.client.*;
import java.util.ArrayList;

public abstract class GenericTableModel extends AbstractTableModel {
	public static final int REFRESH_INSERT=1;
	public static final int REFRESH_UPDATE=2;
	public static final int REFRESH_DELETE=3;

	public abstract GenericEditor getEditor();

	public boolean isCellEditable(int row, int col) {return false;
	}

	public abstract Object getRowData(int row);
	public abstract void remove(int row);

	/**
	 *
	 * @param o LogicItem
	 */

	protected abstract LogicItem[] resizeArray(int len);

	protected LogicItem[] insert(LogicItem o, LogicItem[] rowData) {
		ArrayList ar=new ArrayList();

		for (int i=0;i<rowData.length;i++) {
			ar.add(rowData[i]);
		}

		ar.add(o);
		rowData=resizeArray(rowData.length + 1);
		ar.toArray(rowData);

		return rowData;
	}

	protected void remove(LogicItem a, LogicItem[] rowData) {
		for (int i=0; i < rowData.length; i++) {
			if (rowData[i].getId() == a.getId()) {
				remove(i);
			}
		}
	}

	protected abstract void remove(LogicItem o);
	protected abstract void insert(LogicItem o);

        public abstract void refresh();

	/**
	 * refresh
	 *
	 * @param o Object
	 * @param refreshType int
	 */
	public void refresh(LogicItem o, int refreshType) {
		switch (refreshType) {
		case REFRESH_DELETE:
			remove(o);
			break;
		case REFRESH_INSERT:
			insert(o);
			break;
		}
		fireTableDataChanged();
	}
}
