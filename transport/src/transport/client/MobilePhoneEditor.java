/*
 * MobilePhoneEditor.java
 *
 * Created on June 29, 2004, 11:00 PM
 */

package transport.client;

import transport.logic.MobilePhone;
import transport.server.MobilePhoneFactory;

/**
 *
 * @author  ola
 */
public class MobilePhoneEditor extends GenericEditor {
	MobilePhone mobilePhone;

	public MobilePhoneEditor() {
		this(new MobilePhone());
	}

	/** Creates new form MobilePhoneEditor */
	public MobilePhoneEditor(MobilePhone mobilePhone) {
		jbInit();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void jbInit() {//GEN-BEGIN:jbInit
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jFormattedTextField1 = new javax.swing.JFormattedTextField();
                jPanel2 = new javax.swing.JPanel();
                okButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();

                setTitle("Mobile phone editor");
                jPanel1.setLayout(new java.awt.GridLayout());

                jLabel1.setText("Number");
                jPanel1.add(jLabel1);

                jFormattedTextField1.setText("jFormattedTextField1");
                jPanel1.add(jFormattedTextField1);

                getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

                okButton.setText("OK");
                jPanel2.add(okButton);

                cancelButton.setText("Cancel");
                jPanel2.add(cancelButton);

                getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

                pack();
        }//GEN-END:jbInit


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cancelButton;
        private javax.swing.JFormattedTextField jFormattedTextField1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JButton okButton;

	/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
	}

	// End of variables declaration//GEN-END:variables

}
