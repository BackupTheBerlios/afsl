package transport.client;

import javax.swing.*;

public abstract class GenericEditor extends JInternalFrame {
	public GenericEditor(Object o) {};
	public abstract void edit(Object o);
	public abstract void editNew();

	/**
	 * GenericEditor
	 */
	public GenericEditor() {
	}
}
