/*
 * ItemChooser.java
 *
 * Created on June 29, 2004, 12:19 AM
 */

package transport.client;

import transport.logic.*;
import transport.server.*;
/**
 *
 * @author  ola
 */
public class ItemChooser extends javax.swing.JDialog {
	Object[] objects;
	
	/** Creates new form ItemChooser */
	public ItemChooser(java.awt.Frame parent) {
		
		// always modal.
		super(parent, true);
		
		initComponents();		

	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void initComponents() {//GEN-BEGIN:initComponents
                itemList = new javax.swing.JList();
                buttonPanel = new javax.swing.JPanel();
                addButton = new javax.swing.JButton();
                Cancel = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                setModal(true);
                getContentPane().add(itemList, java.awt.BorderLayout.CENTER);

                addButton.setMnemonic('A');
                addButton.setText("Add");
                buttonPanel.add(addButton);

                Cancel.setMnemonic('C');
                Cancel.setText("Cancel");
                buttonPanel.add(Cancel);

                getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

                pack();
        }//GEN-END:initComponents
	
	public Object[] chooseItems(Object type) {
		// FIXME: type is an ugly HACK which reverberates through the 
		// entire call hierarchy
		
		if (type instanceof Artist) {
			ArtistFactory af=new ArtistFactory();
			objects=af.getAllArtists();
		}
		
		itemList.setListData(objects);
		this.pack();
		this.show();
		
		return null;
	}
	
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton Cancel;
        private javax.swing.JButton addButton;
        private javax.swing.JPanel buttonPanel;
        private javax.swing.JList itemList;
        // End of variables declaration//GEN-END:variables
	
}