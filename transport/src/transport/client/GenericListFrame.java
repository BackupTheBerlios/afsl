/*
 * Artist.java
 *
 * Created on June 12, 2004, 6:04 PM
 */

package transport.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import transport.client.tablemodel.*;
import transport.server.*;
import transport.logic.LogicItem;
import transport.logic.Transport;
import transport.logic.TransportHelper;
import java.io.IOException;

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
        private void printCurrent() {
          if(tableModel instanceof TransportTableModel){
            Transport o= (Transport) tableModel.getRowData(objectTable.getSelectedRow());
            String filename = TransportHelper.createHTMLFileFromTransport(o);
            try {
              Runtime runtime = Runtime.getRuntime();
              runtime.exec("explorer "+ filename);
            }
            catch (IOException ioe) {
              System.out.println(ioe);
            }

          }

        }

	private void removeCurrent() {
		LogicItem l=(LogicItem) tableModel.getRowData(objectTable.getSelectedRow());
		tableModel.remove(objectTable.getSelectedRow());
		MainFrame mf=(MainFrame)this.getTopLevelAncestor();
		mf.refreshLists(l, transport.client.tablemodel.GenericTableModel.REFRESH_DELETE);
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
                printButton.setText("Print");
                                printButton.addActionListener(new java.awt.event.ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                printButton_actionPerformed(e);
                                        }
                                });
                                printButton.setMnemonic('P');

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
                if(tableModel instanceof TransportTableModel){
                  jPanel1.add(printButton, null);
                }
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
        JButton printButton=new JButton();
	void editButton_actionPerformed(ActionEvent e) {
		if (objectTable.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this.getTopLevelAncestor(),
										  "No row selected!");
			return;
		}

		editCurrent();
	}
        void printButton_actionPerformed(ActionEvent e) {
                if (objectTable.getSelectedRow() == -1) {
                        JOptionPane.showMessageDialog(this.getTopLevelAncestor(),
                                                                                  "No row selected!");
                        return;
                }

                printCurrent();
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
		if (objectTable.getSelectedRow()==-1) {
			JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "No row selected!");
			return;
		}

		int returnValue = JOptionPane.showConfirmDialog(
			  this.getTopLevelAncestor(), "Are you sure?",
			  "Deletion", JOptionPane.YES_NO_OPTION );

		if (returnValue == 1) {
			return;
		}

		removeCurrent();
	}

    void cancelButton_actionPerformed(ActionEvent e) {
		this.dispose();
    }

	/**
	 * refresh
	 *
	 * @param o Object
	 */
	public void refresh(LogicItem o, int refreshType) {
		tableModel.refresh(o, refreshType);
	}
}

// End of variables declaration//GEN-END:variables
