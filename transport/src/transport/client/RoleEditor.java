/*
 * RoleEditor.java
 *
 * Created on June 29, 2004, 11:01 PM
 */

package transport.client;

/**
 *
 * @author  ola
 */
public class RoleEditor extends javax.swing.JInternalFrame {
	
	/** Creates new form RoleEditor */
	public RoleEditor() {
		initComponents();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void initComponents() {//GEN-BEGIN:initComponents
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                shortDescrText = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                longDescrText = new javax.swing.JTextArea();
                jPanel2 = new javax.swing.JPanel();
                okButton = new javax.swing.JButton();
                cancelButton = new javax.swing.JButton();

                setTitle("Role editor");
                jPanel1.setLayout(new java.awt.GridLayout(2, 2));

                jLabel1.setText("Short description");
                jPanel1.add(jLabel1);

                shortDescrText.setText("jTextField1");
                jPanel1.add(shortDescrText);

                jLabel2.setText("Long description");
                jPanel1.add(jLabel2);

                jPanel1.add(longDescrText);

                getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

                okButton.setText("OK");
                jPanel2.add(okButton);

                cancelButton.setText("Cancel");
                jPanel2.add(cancelButton);

                getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

                pack();
        }//GEN-END:initComponents
	
	
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton cancelButton;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JTextArea longDescrText;
        private javax.swing.JButton okButton;
        private javax.swing.JTextField shortDescrText;
        // End of variables declaration//GEN-END:variables
	
}