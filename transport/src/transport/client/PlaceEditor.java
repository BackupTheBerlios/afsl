/*
 * PlaceEditor.java
 *
 * Created on June 29, 2004, 11:01 PM
 */

package transport.client;

import transport.logic.*;
import java.awt.event.*;
import transport.server.PlaceFactory;

/**
 *
 * @author  ola
 */
public class PlaceEditor extends GenericEditor {
//public class PlaceEditor extends javax.swing.JInternalFrame {
	Place place;

	public PlaceEditor() {
		this(new Place());
	}

	/** Creates new form PlaceEditor */
	public PlaceEditor(Place place) {
		jbInit();
		edit(place);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void jbInit() { //GEN-BEGIN:jbInit
		jPanel1=new javax.swing.JPanel();
		jLabel1=new javax.swing.JLabel();
		nameText=new javax.swing.JTextArea();
		jPanel2=new javax.swing.JPanel();
		okButton=new javax.swing.JButton();
		cancelButton=new javax.swing.JButton();

		setTitle("Place editor");
		jPanel1.setLayout(new java.awt.GridLayout());

		jLabel1.setText("Name");
		okButton.addActionListener(new PlaceEditor_okButton_actionAdapter(this));
    cancelButton.addActionListener(new PlaceEditor_cancelButton_actionAdapter(this));
    jPanel1.add(jLabel1);

		jPanel1.add(nameText);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		okButton.setText("OK");
		jPanel2.add(okButton);

		cancelButton.setText("Cancel");
		jPanel2.add(cancelButton);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

		pack();
	} //GEN-END:jbInit

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextArea nameText;
	private javax.swing.JButton okButton;

	/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
		place=(Place)o;

		if (place.getId() == -1) {
			this.setTitle("Add a place");
			okButton.setText("New");
			okButton.setMnemonic('N');
		} else {
			this.setTitle("Update a place");
			okButton.setText("Update");
			okButton.setMnemonic('U');
			nameText.setText(place.getName());
		}
	}

	/**
	 * editNew
	 */
	public void editNew() {
		edit(new Place());
	}

	void okButton_actionPerformed(ActionEvent e) {

		place.setName(nameText.getText());

		PlaceFactory pf=new PlaceFactory();

		if (place.getId() == -1) {
			pf.newPlace(place);
		} else {
			pf.updatePlace(place);
		}

		this.dispose();
	}

	void cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}


	// End of variables declaration//GEN-END:variables

}

class PlaceEditor_okButton_actionAdapter implements java.awt.event.ActionListener {
  PlaceEditor adaptee;

  PlaceEditor_okButton_actionAdapter(PlaceEditor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.okButton_actionPerformed(e);
  }
}

class PlaceEditor_cancelButton_actionAdapter implements java.awt.event.ActionListener {
  PlaceEditor adaptee;

  PlaceEditor_cancelButton_actionAdapter(PlaceEditor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cancelButton_actionPerformed(e);
  }
}
