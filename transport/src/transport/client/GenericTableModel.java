package transport.client;

import javax.swing.JInternalFrame;
import javax.swing.table.AbstractTableModel;

public abstract class GenericTableModel extends AbstractTableModel {
	public JInternalFrame getEditor();
}
