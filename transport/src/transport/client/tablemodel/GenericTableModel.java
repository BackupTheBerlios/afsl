package transport.client.tablemodel;

import javax.swing.table.*;

import transport.client.*;

public abstract class GenericTableModel extends AbstractTableModel {
	public abstract GenericEditor getEditor();

	public boolean isCellEditable(int row, int col) {return false;
	}

	public abstract Object getRowData(int row);
	public abstract void remove(int row);
}
