package transport.client.tablemodel;

import javax.swing.table.*;
import transport.client.GenericEditor;
import transport.server.TransportFactory;
import transport.logic.Transport;
import transport.client.TransportEditor;
import transport.logic.LogicItem;

/**
 * <p>Title: Festival Logistics System</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ViewTransportByFunctionaryTableModel
    extends GenericTableModel {

  private TransportFactory tf;
  private Transport[] rowData;

  public ViewTransportByFunctionaryTableModel(int id) {
    tf = new TransportFactory();
    rowData = tf.getAllTransportsByFunctionaryID(id);
  }
  public ViewTransportByFunctionaryTableModel() {
      tf = new TransportFactory();
  }

  public void setRowDataCurrent(int id){
    rowData= tf.getAllCurrentTransportsByFunctionaryID(id);

  }
  public void setRowDataFuture(int id){
    rowData= tf.getAllFutureTransportsByFunctionaryID(id);

  }
  public void setRowDataFinished(int id){
    rowData= tf.getAllFinishedTransportsByFunctionaryID(id);

  }
  public GenericEditor getEditor() {
    return new TransportEditor();
  }

  public Object getRowData(int row) {
    return rowData[row];
  }
  public void removeRowData() {
     rowData = null;
   }

  public String getColumnName(int col) {
    switch (col) {
      case 0:
        return "Artists";
      case 1:
        return "Cars";
      case 2:
        return "Functionaries";
      case 3:
        return "Internal";
      case 4:
        return "Waypoints";
      case 5:
        return "Mobile phones";
      case 6:
        return "Start time";
      case 7:
        return "Return time";
      case 8:
        return "Actual return time";
      case 9:
        return "Distance";
      case 10:
        return "Actual return time";
      case 11:
        return "Misc info";
    }

    return "FIXME";
  }

  public int getRowCount() {
    if (rowData!=null){
      return rowData.length;
    }else{
      return 0;
    }
  }

  public int getColumnCount() {
    return 12;
  }

  private String fixString(Object[] o) {
    String s = new String();
    for (int i = 0; i < o.length - 1; i++) {
      s = s + o[i].toString() + ", ";
    }
    if (o.length > 0) {
      s = s + o[o.length - 1].toString();
    }

    return s;
  }

  public Object getValueAt(int row, int col) {
    switch (col) {
      case 0:
        return fixString(rowData[row].getArtists());
      case 1:
        return fixString(rowData[row].getCars());
      case 2:
        return fixString(rowData[row].getFunctionaries());
      case 3:
        if (rowData[row].getInternal()) {
          return "Yes";
        }
        else {
          return "";
        }
      case 4:
        return fixString(rowData[row].getWaypoints());
      case 5:
        return fixString(rowData[row].getMobilePhones());
      case 6:
        return rowData[row].getStartTime();
      case 7:
        return rowData[row].getReturnTime();
      case 8:
        return rowData[row].getActualReturnTime();
      case 9:
        return new Integer(0);
      case 10:
        return rowData[row].getActualReturnTime();
      case 11:
        return rowData[row].getMiscInfo();
    }

    // FIXME: should not happen. Log error if it does.

    return null;
  }

  public boolean isCellEditable(int row, int col) {
    return false;
  }

  public void setValueAt(Object value, int row, int col) {
    fireTableCellUpdated(row, col);
  }

  /**
   * remove
   *
   * @param row int
   */
  public void remove(int row) {
    (new TransportFactory()).deleteTransport( (Transport) getRowData(row));
    Transport[] ar = new Transport[rowData.length - 1];

    int mod = 0;
    for (int i = 0; i < rowData.length; i++) {
      if (i != row) {
        ar[i + mod] = rowData[i];

      }
      else {
        mod = -1;
      }
    }

    rowData = ar;

    fireTableDataChanged();
  }

	/**
	 * resizeArray
	 *
	 * @param len int
	 * @return LogicItem[]
	 */
	protected LogicItem[] resizeArray(int len) {
		return new Transport[len];
	}

	/**
	 * remove
	 *
	 * @param o LogicItem
	 */
	protected void remove(LogicItem o) {
	}

	/**
	 * insert
	 *
	 * @param o LogicItem
	 */
	protected void insert(LogicItem o) {
	}
}
