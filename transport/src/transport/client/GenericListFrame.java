/*
 * Artist.java
 *
 * Created on June 12, 2004, 6:04 PM
 */

package transport.client;

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

	public void setTitle(String title) {
		super.setTitle(title);
		this.objectTable.setToolTipText(title);
	}

	private void editCurrent() {
		GenericEditor editor=tableModel.getEditor();
		editor.edit(tableModel.getRowData(objectTable.getSelectedRow()));
		MainFrame w=(MainFrame)this.getTopLevelAncestor();
		w.addToDesktop(editor);
		editor.show();
	}

	private void removeCurrent() {
		tableModel.remove(objectTable.getSelectedRow());
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 */
	private void jbInit() {
          ImageIcon frameIcon = new ImageIcon(this.getClass().getResource(
              "../pics/miniAF.png"));
          this.setFrameIcon(frameIcon);

		jScrollPane1=new javax.swing.JScrollPane();
		objectTable=new javax.swing.JTable();

		objectTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		objectTable.setRowSelectionAllowed(true);
		objectTable.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				objectTable_keyTyped(e);
			}
		});
		objectTable.setCellSelectionEnabled(false);
		objectTable.setColumnSelectionAllowed(false);

		setClosable(true);
    this.setMaximizable(true);
		setResizable(true);

		setAutoscrolls(true);
		objectTable.setModel(tableModel);

		objectTable.setCellSelectionEnabled(true);
		objectTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				objectTableMouseClicked(evt);
			}
		});

		jScrollPane1.setViewportView(objectTable);

		editButton.setText("Edit");
		editButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editButton_actionPerformed(e);
			}
		});
		editButton.setMnemonic('E');

		cancelButton.setText("Close");
	cancelButton.addActionListener(new java.awt.event.ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		cancelButton_actionPerformed(e);
	    }
	});
		cancelButton.setMnemonic('C');

		removeButton.setMnemonic('R');
		removeButton.setText("Remove");
    removeButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        removeButton_actionPerformed(e);
      }
    });
		addButton.setMnemonic('A');
		addButton.setText("Add");
		addButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addButton_actionPerformed(e);
			}
		});
		getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
		this.getContentPane().add(jPanel1, BorderLayout.SOUTH);
		jPanel1.add(addButton, null);
		jPanel1.add(editButton, null);
		jPanel1.add(removeButton, null);
		jPanel1.add(cancelButton, null);

		pack();
	}

	private void objectTableMouseClicked(java.awt.event.MouseEvent evt) {
		if (evt.getClickCount() == 2) {
			editCurrent();
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTable objectTable;
	private javax.swing.JScrollPane jScrollPane1;
	JPanel jPanel1=new JPanel();
	JButton editButton=new JButton();
	JButton cancelButton=new JButton();
	JButton removeButton=new JButton();
	JButton addButton=new JButton();

	void editButton_actionPerformed(ActionEvent e) {
		editCurrent();
	}

	void objectTable_keyTyped(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DELETE) {
			removeCurrent();
		} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			editCurrent();
		}
	}

	void addButton_actionPerformed(ActionEvent e) {
		GenericEditor editor=tableModel.getEditor();
		editor.editNew();
		MainFrame w=(MainFrame)this.getTopLevelAncestor();
		w.addToDesktop(editor);
		editor.show();
	}

	void removeButton_actionPerformed(ActionEvent e) {
		int returnValue = JOptionPane.showConfirmDialog(
			  this.getTopLevelAncestor(), "Are you sure?",
			  "Deletion", JOptionPane.YES_NO_OPTION );

		if (returnValue == 1) {
			return;
		}

		removeCurrent();
		tableModel.fireTableDataChanged();
	}

    void cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
    }
}

// End of variables declaration//GEN-END:variables
