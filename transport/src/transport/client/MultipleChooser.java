/*
 * MultipleArtistChooser.java
 *
 * Created on June 28, 2004, 11:25 PM
 */

package transport.client;

import java.awt.Window;
import java.util.ArrayList;
import javax.swing.*;
import transport.logic.*;
import transport.server.*;

/**
 *
 * @author  ola
 */
public class MultipleChooser extends javax.swing.JPanel {
	ArrayList objects=new ArrayList();
	Object type;
	
	/** Creates new form MultipleArtistChooser */
	public MultipleChooser(Object type) {
		this(null, type);
	}
	
	public MultipleChooser(Object[] objects, Object type) {
		this.type=type;
		
		if (objects!=null) {
			for (int i=0;i<objects.length;i++) {
				this.objects.add(objects[i]);
			}
		}
		jbInit();
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void jbInit() {//GEN-BEGIN:jbInit
                addArtist = new javax.swing.JButton();
                artistList = new javax.swing.JList();
                removeArtist = new javax.swing.JButton();

                setLayout(new java.awt.BorderLayout());

                addArtist.setText("+");
                addArtist.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addArtistActionPerformed(evt);
                        }
                });

                add(addArtist, java.awt.BorderLayout.WEST);

                add(artistList, java.awt.BorderLayout.CENTER);

                removeArtist.setText("-");
                add(removeArtist, java.awt.BorderLayout.EAST);

        }//GEN-END:jbInit

	private void addArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addArtistActionPerformed
		// TODO add your handling code here:
		// display all items for chosen type.
		Window w=(Window)this.getTopLevelAncestor();
		//ItemChooser ic=new ItemChooser(w);
		
	}//GEN-LAST:event_addArtistActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton addArtist;
        private javax.swing.JList artistList;
        private javax.swing.JButton removeArtist;
        // End of variables declaration//GEN-END:variables
	
}


