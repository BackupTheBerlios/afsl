/*
 * AddFunctionary.java
 *
 * Created on June 26, 2004, 3:25 PM
 */

package transport.client;

import java.awt.event.*;

import transport.logic.*;
import transport.server.*;
import javax.swing.ImageIcon;

/**
 *
 * @author  ola
 */

// fulhack galore
//public class FunctionaryEditor extends JInternalFrame {
public class FunctionaryEditor extends GenericEditor {
	Functionary functionary;

	public FunctionaryEditor() {
		this(new Functionary());
	}

	/** Creates new form AddFunctionary */
	public FunctionaryEditor(Functionary functionary) {
		jbInit();
		edit(functionary);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void jbInit() { //GEN-BEGIN:jbInit
          ImageIcon frameIcon = new ImageIcon(this.getClass().getResource(
          "../pics/miniAF.png"));
      this.setFrameIcon(frameIcon);

		jPanel1=new javax.swing.JPanel();
		jLabel1=new javax.swing.JLabel();
		nameField=new javax.swing.JTextField();
		jLabel2=new javax.swing.JLabel();
		roleCombo=new javax.swing.JComboBox();
		jLabel3=new javax.swing.JLabel();
		jLabel4=new javax.swing.JLabel();
		jPanel2=new javax.swing.JPanel();
		okButton=new javax.swing.JButton();
		cancelButton=new javax.swing.JButton();

		jPanel1.setLayout(new java.awt.GridLayout(4, 2));

		jLabel1.setText("Name");
		nameField.setText("");
		okButton.addActionListener(new FunctionaryEditor_okButton_actionAdapter(this));
		cancelButton.addActionListener(new
			FunctionaryEditor_cancelButton_actionAdapter(this));
		this.setResizable(true);
		jPanel1.add(jLabel1);

		jPanel1.add(nameField);

		jLabel2.setText("Role");
		jPanel1.add(jLabel2);

		jPanel1.add(roleCombo);

		jLabel3.setText("Begins working");
		jPanel1.add(jLabel3);
		jPanel1.add(beginTime, null);
		jPanel1.add(jLabel4);
		jPanel1.add(stopTime, null);

		jLabel4.setText("Stops working");

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		okButton.setMnemonic('O');
		okButton.setText("OK");
		jPanel2.add(okButton);

		cancelButton.setMnemonic('C');
		cancelButton.setText("Cancel");
		jPanel2.add(cancelButton);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
		getRootPane().setDefaultButton(okButton);

		pack();
	} //GEN-END:jbInit

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton okButton;
	private javax.swing.JButton cancelButton;
	private javax.swing.JComboBox roleCombo;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField nameField;
	PickDateTimeCombo beginTime=new PickDateTimeCombo();
	PickDateTimeCombo stopTime=new PickDateTimeCombo();

	/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
		this.functionary=(Functionary)o;
		RoleFactory rf=new RoleFactory();
		Role[] roles=rf.getAllRoles();

		for (int i=0; i < roles.length; i++) {
			roleCombo.addItem(roles[i]);
		}
		if (functionary.getId() == -1) {
			this.setTitle("Add a functionary");
			okButton.setText("New");
			okButton.setMnemonic('N');
		} else {
			this.setTitle("Update a functionary");
			okButton.setText("Update");
			okButton.setMnemonic('U');

			beginTime.setDate(functionary.getBeginsWork());
			nameField.setText(functionary.getName());

			for (int i=0; i < roles.length; i++) {
				if (roles[i].getId()==functionary.getRole().getId()) {
					roleCombo.setSelectedItem(roles[i]);
					break;
				}
			}

			stopTime.setDate(functionary.getStopsWork());
		}

	}

	public void editNew() {
		edit(new Functionary());
	}

	void okButton_actionPerformed(ActionEvent e) {
		functionary.setBeginsWork(beginTime.getDate());
		functionary.setName(nameField.getText());
		functionary.setRole((Role)roleCombo.getSelectedItem());
		functionary.setStopsWork(stopTime.getDate());

		FunctionaryFactory ff=new FunctionaryFactory();
		MainFrame mf=(MainFrame)this.getTopLevelAncestor();

		if (functionary.getId() == -1) {
			ff.newFunctionary(functionary);
			mf.refreshLists(functionary, transport.client.tablemodel.GenericTableModel.REFRESH_INSERT);
		} else {
			ff.updateFunctionary(functionary);
			mf.refreshLists(functionary, transport.client.tablemodel.GenericTableModel.REFRESH_UPDATE);
		}

		this.dispose();
	}

	void cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// End of variables declaration//GEN-END:variables

}

class FunctionaryEditor_okButton_actionAdapter implements java.awt.event.
	ActionListener {
	FunctionaryEditor adaptee;

	FunctionaryEditor_okButton_actionAdapter(FunctionaryEditor adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.okButton_actionPerformed(e);
	}
}

class FunctionaryEditor_cancelButton_actionAdapter implements java.awt.event.
	ActionListener {
	FunctionaryEditor adaptee;

	FunctionaryEditor_cancelButton_actionAdapter(FunctionaryEditor adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.cancelButton_actionPerformed(e);
	}
}
