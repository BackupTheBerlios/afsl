/*
 * RoleEditor.java
 *
 * Created on June 29, 2004, 11:01 PM
 */

package transport.client;

import java.awt.event.*;

import transport.logic.*;
import transport.server.*;
import javax.swing.ImageIcon;
import javax.swing.event.*;

/**
 *
 * @author  ola
 */
public class RoleEditor extends GenericEditor {
//public class RoleEditor extends javax.swing.JInternalFrame {
	Role role;

	public RoleEditor() {
		this(new Role());
	}

	/** Creates new form RoleEditor */
	public RoleEditor(Role role) {
		jbInit();
		edit(role);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void jbInit() { //GEN-BEGIN:jbInit
          ImageIcon frameIcon = new ImageIcon(this.getClass().getResource(
          "../pics/miniAF.png"));
      this.setClosable(true);
    this.setFrameIcon(frameIcon);
    this.setResizable(true);

		jPanel1=new javax.swing.JPanel();
		jLabel1=new javax.swing.JLabel();
		shortDescrText=new javax.swing.JTextField();
		jLabel2=new javax.swing.JLabel();
		longDescrText=new javax.swing.JTextArea();
		jPanel2=new javax.swing.JPanel();
		okButton=new javax.swing.JButton();
		cancelButton=new javax.swing.JButton();
                jLabel3=new javax.swing.JLabel();
                initialText= new javax.swing.JTextField();
		setTitle("Role Editor");
		jPanel1.setLayout(new java.awt.GridLayout(3, 2));

		jLabel1.setText("Short description");
		okButton.addActionListener(new RoleEditor_okButton_actionAdapter(this));
		cancelButton.addActionListener(new
									   RoleEditor_cancelButton_actionAdapter(this));
		jPanel1.add(jLabel1);

		shortDescrText.setText("");
		jPanel1.add(shortDescrText);

		jLabel2.setText("Long description");
		jPanel1.add(jLabel2);
		jPanel1.add(longDescrText);
    jPanel1.add(jLabel3);

                jLabel3.setText("Initial");
                jPanel1.add(initialText);
		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		okButton.setText("OK");
		jPanel2.add(okButton);

		cancelButton.setText("Cancel");
		jPanel2.add(cancelButton);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
		getRootPane().setDefaultButton(okButton);

		pack();
	} //GEN-END:jbInit

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextArea longDescrText;
	private javax.swing.JButton okButton;
	private javax.swing.JTextField shortDescrText;
        private javax.swing.JTextField initialText;
	/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
		this.role=(Role)o;

		if (role.getId() == -1) {
			this.setTitle("Add a role");
			okButton.setText("New");
			okButton.setMnemonic('N');
		} else {
			this.setTitle("Update a role");
			okButton.setText("Update");
			okButton.setMnemonic('U');
			shortDescrText.setText(role.getShortDescr());
			longDescrText.setText(role.getLongDescr());
                        initialText.setText(role.getInitial());
		}
	}

	public void editNew() {
		edit(new Role());
	}

	void okButton_actionPerformed(ActionEvent e) {
		role.setShortDescr(shortDescrText.getText());
		role.setLongDescr(longDescrText.getText());
                role.setInitial(initialText.getText());
		RoleFactory rf=new RoleFactory();
		MainFrame mf=(MainFrame)this.getTopLevelAncestor();

		if (role.getId() == -1) {
			rf.newRole(role);
			mf.refreshLists(role, transport.client.tablemodel.GenericTableModel.REFRESH_INSERT);
		} else {
			rf.updateRole(role);
			mf.refreshLists(role, transport.client.tablemodel.GenericTableModel.REFRESH_UPDATE);
		}
		this.dispose();
	}

	void cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// End of variables declaration//GEN-END:variables

}

class RoleEditor_okButton_actionAdapter implements java.awt.event.
	ActionListener {
	RoleEditor adaptee;

	RoleEditor_okButton_actionAdapter(RoleEditor adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.okButton_actionPerformed(e);
	}
}

class RoleEditor_cancelButton_actionAdapter implements java.awt.event.
	ActionListener {
	RoleEditor adaptee;

	RoleEditor_cancelButton_actionAdapter(RoleEditor adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.cancelButton_actionPerformed(e);
	}
}
