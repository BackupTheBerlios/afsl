/*
 * Artist.java
 *
 * Created on June 12, 2004, 6:04 PM
 */

package transport.client;

import transport.logic.*;
import transport.server.*;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author  ola
 */
public class ArtistFrame extends javax.swing.JInternalFrame {
	ArtistFactory af;
	
	/** Creates new form Artist */
	public ArtistFrame() {
		af=new ArtistFactory();
		initComponents();
		this.pack();
	}
	
	private AbstractTableModel newTableModel() {
		return new AbstractTableModel() {
			Artist[] rowData=af.getAllArtists();
			
			public String getColumnName(int col) {
				switch (col) {
				case 1:
					return "Name";
				case 2:
					return "Contact name";
				case 3:
					return "Telephone number";
				case 4:
					return "Arrival";
				case 5:
					return "Arrival time";
				case 6:
					return "Hotel";
				case 7:
					return "Departure";
				case 8:
					return "Departure Time";
				case 9:
					return "No of Artists";
				case 10:
					return "No of Crew";
				case 11:
					return "No of Guests";
				}
				
				return "FIXME";
			}

			public int getRowCount() { return rowData.length; }
			public int getColumnCount() { return 11; }
			public Object getValueAt(int row, int col) {
				switch (col) {
				case 1:
					return rowData[row].getName();
				case 2:
					return rowData[row].getContactName();
				case 3:
					return rowData[row].getTelephoneNo();
				case 4:
					return rowData[row].getArrival();
				case 5:
					return rowData[row].getArrivalTime();
				case 6:
					return rowData[row].getHotel();
				case 7:
					return rowData[row].getDeparture();
				case 8:
					return rowData[row].getDepartureTime();
				case 9:
					return new Integer(rowData[row].getNoOfArtists());
				case 10:
					return new Integer(rowData[row].getNoOfCrew());
				case 11:
					return new Integer(rowData[row].getNoOfGuests());
				}
				
				// FIXME: should not happen. Log error if it does.
				
				return null;
			}

			public boolean isCellEditable(int row, int col) { return true; }
			public void setValueAt(Object value, int row, int col) {
				fireTableCellUpdated(row, col);
			}
		};
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void initComponents() {//GEN-BEGIN:initComponents
                jScrollPane1 = new javax.swing.JScrollPane();
                ArtistTable = new javax.swing.JTable();

                setClosable(true);
                setResizable(true);
                setTitle("Listing of artists");
                setAutoscrolls(true);
                ArtistTable.setModel(newTableModel());
                ArtistTable.setToolTipText("Artists");
                jScrollPane1.setViewportView(ArtistTable);

                getContentPane().add(jScrollPane1, java.awt.BorderLayout.NORTH);

                pack();
        }//GEN-END:initComponents
	
	
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JTable ArtistTable;
        private javax.swing.JScrollPane jScrollPane1;
        // End of variables declaration//GEN-END:variables
	
}
