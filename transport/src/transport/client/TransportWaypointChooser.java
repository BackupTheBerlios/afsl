/*
 * TransportDropoff.java
 *
 * Created on June 12, 2004, 6:07 PM
 */

package transport.client;

import java.awt.*;
import javax.swing.*;
import java.beans.*;
import java.awt.event.*;
import transport.logic.TransportWaypoint;
import transport.server.PlaceFactory;
import transport.logic.Place;
import java.util.Enumeration;
import javax.swing.event.*;

/**
 *
 * @author  ola
 */
public class TransportWaypointChooser extends javax.swing.JPanel {
	BorderLayout borderLayout1=new BorderLayout();
	JPanel jPanel1=new JPanel();
	JButton cancelButton=new JButton();
	JButton okButton=new JButton();
	JScrollPane jScrollPane1=new JScrollPane();
	JPanel jPanel2=new JPanel();
	JPanel jPanel3=new JPanel();
	JComboBox placesBox=new JComboBox();
	PickDateTimeCombo timeCombo=new PickDateTimeCombo();
	JButton addButton=new JButton();
	JButton removeButton=new JButton();
	JList waypointList=new JList();
	GridBagLayout gridBagLayout1=new GridBagLayout();
	JButton updateButton=new JButton();
	DefaultListModel listModel=new DefaultListModel();
	JWindow window;
	TransportWaypoint[] currentWaypoints;
	boolean updating=false;

	/** Creates new form TransportDropoff */
	public TransportWaypointChooser(JWindow window) {
		jbInit();
		this.window=window;
		PlaceFactory pf=new PlaceFactory();
		Place[] p=pf.getAllPlaces();

		currentWaypoints=new TransportWaypoint[0];

		for (int i=0; i < p.length; i++) {
			placesBox.addItem(p[i]);
		}
	}

	public void addObjects(TransportWaypoint[] tw) {
		for (int i=0;i<tw.length;i++) {
			insertObject(tw[i]);
		}
		currentWaypoints=tw;
	}

	private void jbInit() {
		this.setLayout(borderLayout1);
		cancelButton.setMnemonic('C');
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new
			TransportWaypointChooser_cancelButton_actionAdapter(this));
		okButton.setMnemonic('O');
		okButton.setText("OK");
    okButton.addActionListener(new TransportWaypointChooser_okButton_actionAdapter(this));
		jPanel3.setLayout(gridBagLayout1);
		jPanel3.setDebugGraphicsOptions(0);
		jPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		addButton.setMnemonic('A');
		addButton.setText("+");
		addButton.addActionListener(new
			TransportWaypointChooser_addButton_actionAdapter(this));
		removeButton.setMnemonic('R');
		removeButton.setText("-");
		removeButton.addActionListener(new
			TransportWaypointChooser_removeButton_actionAdapter(this));
		updateButton.setEnabled(false);
		updateButton.setMnemonic('U');
		updateButton.setText("Uptime time");
		updateButton.addActionListener(new
			TransportWaypointChooser_updateButton_actionAdapter(this));
		timeCombo.addPropertyChangeListener(new
			TransportWaypointChooser_timeCombo_propertyChangeAdapter(this));
		waypointList.addListSelectionListener(new TransportWaypointChooser_waypointList_listSelectionAdapter(this));
    this.add(jPanel1, BorderLayout.SOUTH);
		jPanel1.add(okButton, null);
		jPanel1.add(cancelButton, null);
		this.add(jScrollPane1, BorderLayout.CENTER);
		jScrollPane1.getViewport().add(waypointList, null);
		this.add(jPanel2, BorderLayout.NORTH);
		jPanel2.add(placesBox, null);
		jPanel2.add(timeCombo, null);
		jPanel2.add(updateButton, null);
		this.add(jPanel3, BorderLayout.EAST);
		jPanel3.add(addButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
			, GridBagConstraints.CENTER, GridBagConstraints.NONE,
			new Insets(5, 5, 0, 5), 7, 0));
		jPanel3.add(removeButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
			, GridBagConstraints.CENTER, GridBagConstraints.NONE,
			new Insets(0, 5, 0, 5), 9, 0));

		waypointList.setModel(listModel);
	}

	void timeCombo_propertyChange(PropertyChangeEvent e) {
		if (waypointList.getSelectedIndex()!=-1) {
			updateButton.setEnabled(true);
		}
	}

	void updateButton_actionPerformed(ActionEvent e) {
		updating=true;
		TransportWaypoint tw=(TransportWaypoint)listModel.get(waypointList.getSelectedIndex());
		listModel.removeElement(tw);
		insertObject(new TransportWaypoint(tw.getPlace(),timeCombo.getDate()));
		updating=false;
		updateButton.setEnabled(false);
	}

	private void insertObject(TransportWaypoint tw) {
		for (int i=0; i < listModel.size(); i++) {
			if (((TransportWaypoint)listModel.get(i)).getTime().after(timeCombo.
				getDate())) {
				listModel.insertElementAt(tw, i);
				return;
			}
		}

		listModel.addElement(tw);
	}

	void addButton_actionPerformed(ActionEvent e) {
		insertObject(new TransportWaypoint((Place)placesBox.getSelectedItem(),timeCombo.getDate()));
	}

	void removeButton_actionPerformed(ActionEvent e) {
		if (waypointList.getSelectedIndex()!=-1) {
			listModel.removeElementAt(waypointList.getSelectedIndex());
		}
	}

	void cancelButton_actionPerformed(ActionEvent e) {
		listModel.clear();

		for (int i=0;i<currentWaypoints.length;i++) {
			listModel.addElement(currentWaypoints[i]);
		}

		window.setVisible(false);
	}


	public void saveState() {
		TransportWaypoint[] ar=new TransportWaypoint[listModel.size()];
		int i=0;
		java.util.Enumeration enum=listModel.elements();

		while (enum.hasMoreElements()) {
			ar[i++]=(TransportWaypoint)enum.nextElement();
		}
		currentWaypoints=ar;

	}

	void okButton_actionPerformed(ActionEvent e) {
		saveState();

		window.setVisible(false);
	}

	public TransportWaypoint[] getWaypoints() {
		return currentWaypoints;
	}

  void waypointList_valueChanged(ListSelectionEvent e) {
	  if (updating) {
		  return;
	  }

	  timeCombo.setDate(((TransportWaypoint)listModel.get(waypointList.getSelectedIndex())).getTime());
	  updateButton.setEnabled(true);
  }
}

class TransportWaypointChooser_timeCombo_propertyChangeAdapter implements java.
	beans.PropertyChangeListener {
	TransportWaypointChooser adaptee;

	TransportWaypointChooser_timeCombo_propertyChangeAdapter(
		TransportWaypointChooser adaptee) {
		this.adaptee=adaptee;
	}

	public void propertyChange(PropertyChangeEvent e) {
		adaptee.timeCombo_propertyChange(e);
	}
}

class TransportWaypointChooser_updateButton_actionAdapter implements java.awt.
	event.ActionListener {
	TransportWaypointChooser adaptee;

	TransportWaypointChooser_updateButton_actionAdapter(
		TransportWaypointChooser adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.updateButton_actionPerformed(e);
	}
}

class TransportWaypointChooser_addButton_actionAdapter implements java.awt.
	event.ActionListener {
	TransportWaypointChooser adaptee;

	TransportWaypointChooser_addButton_actionAdapter(TransportWaypointChooser
		adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.addButton_actionPerformed(e);
	}
}

class TransportWaypointChooser_removeButton_actionAdapter implements java.awt.
	event.ActionListener {
	TransportWaypointChooser adaptee;

	TransportWaypointChooser_removeButton_actionAdapter(
		TransportWaypointChooser adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.removeButton_actionPerformed(e);
	}
}

class TransportWaypointChooser_cancelButton_actionAdapter implements java.awt.
	event.ActionListener {
	TransportWaypointChooser adaptee;

	TransportWaypointChooser_cancelButton_actionAdapter(
		TransportWaypointChooser adaptee) {
		this.adaptee=adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.cancelButton_actionPerformed(e);
	}
}

class TransportWaypointChooser_okButton_actionAdapter implements java.awt.event.ActionListener {
  TransportWaypointChooser adaptee;

  TransportWaypointChooser_okButton_actionAdapter(TransportWaypointChooser adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.okButton_actionPerformed(e);
  }
}

class TransportWaypointChooser_waypointList_listSelectionAdapter implements javax.swing.event.ListSelectionListener {
  TransportWaypointChooser adaptee;

  TransportWaypointChooser_waypointList_listSelectionAdapter(TransportWaypointChooser adaptee) {
    this.adaptee = adaptee;
  }
  public void valueChanged(ListSelectionEvent e) {
    adaptee.waypointList_valueChanged(e);
  }
}
