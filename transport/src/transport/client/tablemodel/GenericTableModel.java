package transport.client.tablemodel;

import javax.swing.JInternalFrame;
import javax.swing.table.AbstractTableModel;
import transport.client.GenericEditor;
import javax.swing.ListSelectionModel;

public abstract class GenericTableModel extends AbstractTableModel {
	public abstract GenericEditor getEditor();
	public boolean isCellEditable(int row, int col) { return false; }
}
