package transport.client;

import javax.swing.JInternalFrame;
import javax.swing.table.AbstractTableModel;
import javax.swing.ListSelectionModel;

public abstract class GenericTableModel extends AbstractTableModel {
	public abstract JInternalFrame getEditor();
	public boolean isCellEditable(int row, int col) { return false; }
}
