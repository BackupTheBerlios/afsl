package transport.client;

public abstract class GenericEditor extends javax.swing.JInternalFrame {
	public GenericEditor(Object o) {};
	public abstract void edit(Object o);

	public abstract void editNew();

	/**
	 * GenericEditor
	 */
	public GenericEditor() {
	}

}
