/*
 * ViewFunctionarySchedule.java
 *
 * Created on June 30, 2004, 1:14 AM
 */

package transport.client;

import transport.logic.Functionary;
import transport.server.FunctionaryFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import transport.client.tablemodel.ViewTransportByFunctionaryTableModel;

/**
 *
 * @author  ola
 */
public class ViewFunctionarySchedule
    extends javax.swing.JInternalFrame {
  private Functionary[] rowData;
  private FunctionaryFactory af;
  JPanel jPanel1 = new JPanel();
  afslComboBox comboSelectFunctionary = new afslComboBox();
  JButton buttonClose = new JButton();
  GridLayout gridLayout1 = new GridLayout();
  ViewTransportByFunctionaryTableModel tableModelAll = new
      ViewTransportByFunctionaryTableModel();
  ViewTransportByFunctionaryTableModel tableModelCurrent = new
      ViewTransportByFunctionaryTableModel();
  ViewTransportByFunctionaryTableModel tableModelFuture = new
      ViewTransportByFunctionaryTableModel();
  ViewTransportByFunctionaryTableModel tableModelFinished = new
      ViewTransportByFunctionaryTableModel();
  /** Creates new form ViewFunctionarySchedule */
  JTabbedPane jTabbedPane1 = new JTabbedPane();
  JTable objectTableAll;
  JTable objectTableCurrent;
  JTable objectTableFuture;
  JTable objectTableFinished;
  JScrollPane paneShowAll = new JScrollPane();
  JScrollPane panelShowCurrent = new JScrollPane();
  JScrollPane oaneShowFuture = new JScrollPane();
  JScrollPane paneShowFinished = new JScrollPane();
  public ViewFunctionarySchedule() {
    af = new FunctionaryFactory();
    rowData = af.getAllFunctionaries();
    System.out.print("Number of Functionaries:" + rowData.length);
    jbInit();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  private void jbInit() { //GEN-BEGIN:jbInit
    this.setTitle("View Schedule By Functionary");
    ImageIcon frameIcon = new ImageIcon(this.getClass().getResource(
        "../pics/miniAF.png"));
    objectTableAll = new javax.swing.JTable();
    objectTableCurrent = new javax.swing.JTable();
    objectTableFinished = new javax.swing.JTable();
    objectTableFuture = new javax.swing.JTable();
    paneShowAll = new javax.swing.JScrollPane();
    this.setFrameIcon(frameIcon);
    this.setResizable(true);
    this.setPreferredSize(new Dimension(400, 400));

    pack();
    buttonClose.setText("Close");
    buttonClose.addActionListener(new
        ViewFunctionarySchedule_buttonClose_actionAdapter(this));
    jPanel1.setLayout(gridLayout1);
    comboSelectFunctionary.addActionListener(new
        ViewFunctionarySchedule_comboSelectFunctionary_actionAdapter(this));

    this.getContentPane().add(jPanel1, BorderLayout.NORTH);
    jPanel1.add(comboSelectFunctionary, null);
    this.getContentPane().add(buttonClose, BorderLayout.SOUTH);
    comboSelectFunctionary.fillCombo(rowData);
    initTableAll();
    initTableCurrent();
    initTableFuture();
    initTableFinished();
    paneShowAll.setViewportView(objectTableAll);
    panelShowCurrent.setViewportView(objectTableCurrent);
    paneShowFinished.setViewportView(objectTableFinished);
    oaneShowFuture.setViewportView(objectTableFuture);
    jTabbedPane1.add(panelShowCurrent, "Current");
    jTabbedPane1.add(oaneShowFuture, "Future");
    jTabbedPane1.add(paneShowFinished, "Finished");
    jTabbedPane1.add(paneShowAll, "All");

  }

  void buttonClose_actionPerformed(ActionEvent e) {
    this.dispose();
  } //GEN-END:jbInit

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
  private void initTableAll() {
    objectTableAll = new javax.swing.JTable();
    objectTableAll.setRowSelectionAllowed(true);
    objectTableAll.setCellSelectionEnabled(false);
    objectTableAll.setColumnSelectionAllowed(false);
    tableModelAll = new ViewTransportByFunctionaryTableModel(
        getCurrentFunctionaryID());
    objectTableAll.setModel(tableModelAll);
    objectTableAll.setCellSelectionEnabled(true);
    objectTableAll.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    objectTableAll.setCellSelectionEnabled(false);
    setClosable(true);
    this.setMaximizable(true);
    setResizable(true);

    setAutoscrolls(true);

    this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
    paneShowAll.setViewportView(objectTableAll);

  }

  private void initTableCurrent() {
    objectTableCurrent = new javax.swing.JTable();
    objectTableCurrent.setRowSelectionAllowed(true);
    objectTableCurrent.setCellSelectionEnabled(false);
    objectTableCurrent.setColumnSelectionAllowed(false);
    tableModelCurrent = new ViewTransportByFunctionaryTableModel();
    tableModelCurrent.setRowDataCurrent(getCurrentFunctionaryID());
    objectTableCurrent.setModel(tableModelCurrent);
    objectTableCurrent.setCellSelectionEnabled(true);
    objectTableCurrent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    objectTableCurrent.setCellSelectionEnabled(false);
    setClosable(true);
    this.setMaximizable(true);
    setResizable(true);

    setAutoscrolls(true);

    this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
    panelShowCurrent.setViewportView(objectTableCurrent);

  }

  private void initTableFuture() {
    objectTableFuture = new javax.swing.JTable();
    objectTableFuture.setRowSelectionAllowed(true);
    objectTableFuture.setCellSelectionEnabled(false);
    objectTableFuture.setColumnSelectionAllowed(false);
    tableModelFuture = new ViewTransportByFunctionaryTableModel();
    tableModelFuture.setRowDataFuture(getCurrentFunctionaryID());
    objectTableFuture.setModel(tableModelFuture);
    objectTableFuture.setCellSelectionEnabled(true);
    objectTableFuture.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    objectTableFuture.setCellSelectionEnabled(false);
    setClosable(true);
    this.setMaximizable(true);
    setResizable(true);

    setAutoscrolls(true);

    this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
    oaneShowFuture.setViewportView(objectTableFuture);

  }

  private void initTableFinished() {
    objectTableFinished = new javax.swing.JTable();
    objectTableFinished.setRowSelectionAllowed(true);
    objectTableFinished.setCellSelectionEnabled(false);
    objectTableFinished.setColumnSelectionAllowed(false);
    tableModelFinished = new ViewTransportByFunctionaryTableModel();
    tableModelFinished.setRowDataFinished(getCurrentFunctionaryID());
    objectTableFinished.setModel(tableModelFinished);
    objectTableFinished.setCellSelectionEnabled(true);
    objectTableFinished.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    objectTableFinished.setCellSelectionEnabled(false);
    setClosable(true);
    this.setMaximizable(true);
    setResizable(true);

    setAutoscrolls(true);

    this.getContentPane().add(jTabbedPane1, BorderLayout.CENTER);
    paneShowFinished.setViewportView(objectTableFinished);

  }

  private int getCurrentFunctionaryID() {

    return ( (Functionary) comboSelectFunctionary.
            getSelectedItem()).getId();
  }

  void comboSelectFunctionary_actionPerformed(ActionEvent e) {
    initTableAll();
    initTableCurrent();
    initTableFinished();
    initTableFuture();
  }

}

class ViewFunctionarySchedule_buttonClose_actionAdapter
    implements java.awt.event.ActionListener {
  ViewFunctionarySchedule adaptee;

  ViewFunctionarySchedule_buttonClose_actionAdapter(ViewFunctionarySchedule
      adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.buttonClose_actionPerformed(e);
  }
}

class ViewFunctionarySchedule_comboSelectFunctionary_actionAdapter
    implements java.awt.event.ActionListener {
  ViewFunctionarySchedule adaptee;

  ViewFunctionarySchedule_comboSelectFunctionary_actionAdapter(
      ViewFunctionarySchedule adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.comboSelectFunctionary_actionPerformed(e);
  }
}