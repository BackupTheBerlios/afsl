/*
 * Artist.java
 *
 * Created on June 12, 2004, 6:04 PM
 */

package transport.client;

import transport.logic.*;
import transport.server.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import transport.client.tablemodel.*;

/**
 *
 * @author  ola
 */
public class GenericListFrame extends javax.swing.JInternalFrame {
	ArtistFactory af;
	GenericTableModel tableModel;

	/** Creates new form Artist */
	public GenericListFrame(GenericTableModel tableModel) {
		af=new ArtistFactory();
		this.tableModel=tableModel;
		jbInit();
	}

        public void setTitle(String title){
          super.setTitle(title);
          this.artistTable.setToolTipText(title);
        }
	private void editCurrent() {
//		tableModel.get
	}

	private void removeCurrent() {
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 */
	private void jbInit() {
		jScrollPane1=new javax.swing.JScrollPane();
		artistTable=new javax.swing.JTable();

		artistTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		artistTable.setRowSelectionAllowed(true);
		artistTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				artistTable_keyTyped(e);
			}
		});
		artistTable.setCellSelectionEnabled(false);
		artistTable.setColumnSelectionAllowed(false);

		setClosable(true);
		setResizable(true);

		setAutoscrolls(true);
		artistTable.setModel(tableModel);

		artistTable.setCellSelectionEnabled(true);
		artistTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				artistTableMouseClicked(evt);
			}
		});

		jScrollPane1.setViewportView(artistTable);

		editButton.setText("Edit");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton_actionPerformed(e);
			}
		});
		editButton.setMnemonic('E');

		cancelButton.setText("Close");
		cancelButton.setMnemonic('C');

		removeButton.setMnemonic('R');
		removeButton.setText("Remove");
        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
		this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
		jPanel1.add(editButton, null);
		jPanel1.add(removeButton, null);
		jPanel1.add(cancelButton, null);

		pack();
	}

	private void artistTableMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			//ArtistEditor ae=new ArtistEditor(artistTable.getModel().getRowData(artistTable.getSelectedRow()));
			JInternalFrame jit=tableModel.getEditor();

		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTable artistTable;
	private javax.swing.JScrollPane jScrollPane1;
	JPanel jPanel1=new JPanel();
	JButton editButton=new JButton();
	JButton cancelButton=new JButton();
	JButton removeButton=new JButton();

	void editButton_actionPerformed(ActionEvent e) {
		editCurrent();
	}

	void artistTable_keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			removeCurrent();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			editCurrent();
		}
	}
}

// End of variables declaration//GEN-END:variables
