/*
 * PickDateTimeCombo.java
 *
 * Created on June 26, 2004, 4:31 PM
 */

package transport.client;

import javax.swing.*;
import java.awt.Window;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Point;

/**
 *
 * @author  ola
 */
public class PickDateTimeCombo extends javax.swing.JPanel {
	private PickDateTime pickDateTime;
	private JWindow pdtWin;
	/** Creates new form PickDateTimeCombo */
	public PickDateTimeCombo() {
		pickDateTime=new PickDateTime();
		jbInit();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void jbInit() {//GEN-BEGIN:jbInit
                launchPickDateTime = new javax.swing.JButton();
                dateField = new javax.swing.JFormattedTextField();

                setLayout(new java.awt.BorderLayout());

                launchPickDateTime.setText("...");
    launchPickDateTime.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        launchPickDateTime_mouseClicked(e);
      }
    });
                launchPickDateTime.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                launchPickDateTimeActionPerformed(evt);
                        }
                });

                add(launchPickDateTime, java.awt.BorderLayout.EAST);

                dateField.setEditable(false);
                dateField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
                add(dateField, java.awt.BorderLayout.CENTER);

        }//GEN-END:jbInit

	private void launchPickDateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_launchPickDateTimeActionPerformed
		if (pdtWin==null) {
			PickDateTime pdt=new PickDateTime();
			Window w=(Window)this.getTopLevelAncestor();
			pdtWin=new JWindow(w);
			JPanel contentPane = (JPanel) pdtWin.getContentPane();
			contentPane.setLayout(new BorderLayout());
			contentPane.add(pdt);
			pdtWin.pack();
		}

		if (pdtWin.isVisible()) {
			pdtWin.setVisible(false);
			return;
		}

		Point p=this.getLocationOnScreen();
		pdtWin.setBounds((int)p.getX(),(int)p.getY()+this.getHeight(),300,300);
		pdtWin.setVisible(true);
	}//GEN-LAST:event_launchPickDateTimeActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JFormattedTextField dateField;
        private javax.swing.JButton launchPickDateTime;

		void launchPickDateTime_mouseClicked(MouseEvent e) {
			Window anc=(Window) this.getTopLevelAncestor();
			JWindow pickDateTimeWindow = new JWindow(anc);
			JPanel contentPane = (JPanel) pickDateTimeWindow.getContentPane();
			contentPane.add(pickDateTime);
		}
        // End of variables declaration//GEN-END:variables
}
