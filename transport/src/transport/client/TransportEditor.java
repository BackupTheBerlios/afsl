
/*
 * AddTransport.java
 *
 * Created on June 26, 2004, 3:25 PM
 */

package transport.client;

import transport.logic.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import transport.server.TransportFactory;
import transport.client.tablemodel.GenericTableModel;
/**
 *
 * @author  ola
 */
public class TransportEditor extends GenericEditor {
//public class TransportEditor extends javax.swing.JInternalFrame {
	Transport transport;
	JWindow waypointChooserWindow;
	TransportWaypointChooser waypointChooser;

	public TransportEditor() {
		this(new Transport());
	}

	/** Creates new form AddTransport */
	public TransportEditor(Transport transport) {
		jbInit();
		edit(transport);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void jbInit() { //GEN-BEGIN:jbInit
          ImageIcon frameIcon = new ImageIcon(this.getClass().getResource(
          "../pics/miniAF.png"));
            this.setFrameIcon(frameIcon);

		jPanel2=new javax.swing.JPanel();
		okButton=new javax.swing.JButton();
		cancelButton=new javax.swing.JButton();
		jPanel3=new javax.swing.JPanel();
		jLabel1=new javax.swing.JLabel();
		jLabel2=new javax.swing.JLabel();
		jLabel3=new javax.swing.JLabel();
		jLabel4=new javax.swing.JLabel();
		jLabel5=new javax.swing.JLabel();
		jLabel6=new javax.swing.JLabel();
		jLabel7=new javax.swing.JLabel();
		jLabel8=new javax.swing.JLabel();
		jLabel9=new javax.swing.JLabel();
		jLabel10=new javax.swing.JLabel();
		jLabel11=new javax.swing.JLabel();

		okButton.setMnemonic('O');
		okButton.setText("OK");
		okButton.addActionListener(new TransportEditor_okButton_actionAdapter(this));
		internalBox.setActionCommand("internalBox");
		internalBox.setHorizontalAlignment(SwingConstants.CENTER);
		internalBox.setText("");
		distanceText.setEnabled(false);
		distanceText.setEditable(false);
		distanceText.setText("");
		distanceText.setHorizontalAlignment(SwingConstants.TRAILING);
		miscInfoText.setRequestFocusEnabled(true);
		this.setClosable(true);
		this.setResizable(true);
		cancelButton.addActionListener(new
			TransportEditor_cancelButton_actionAdapter(this));
		waypointsDisplayer.setText("...");
		waypointsDisplayer.addActionListener(new
			TransportEditor_waypointsDisplayer_actionAdapter(this));
		jPanel2.add(okButton);

		cancelButton.setMnemonic('C');
		cancelButton.setText("Cancel");
		jPanel2.add(cancelButton);

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

		jPanel3.setLayout(gridBagLayout1);

		jLabel1.setText("Artists");

		jLabel2.setText("Cars");
		jPanel3.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
			, GridBagConstraints.WEST, GridBagConstraints.NONE,
			new Insets(0, 0, 0, 0), 153, 6));
		jPanel3.add(artistsChooser, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0
			, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 148, -29));
		jPanel3.add(jLabel7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
			, GridBagConstraints.WEST, GridBagConstraints.NONE,
			new Insets(0, 0, 0, 0), 134, 6));
		jPanel3.add(startTimeCombo, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0
			, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 73, 2));
		jPanel3.add(jLabel9, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
			, GridBagConstraints.WEST, GridBagConstraints.NONE,
			new Insets(0, 0, 0, 0), 122, 6));
		jPanel3.add(returnTimeCombo,
					new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0
										   , GridBagConstraints.CENTER,
										   GridBagConstraints.BOTH,
										   new Insets(0, 0, 0, 0), 73, 2));
		jPanel3.add(jLabel2, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0
			, GridBagConstraints.WEST, GridBagConstraints.NONE,
			new Insets(0, 0, 0, 0), 167, 6));
		jPanel3.add(carsChooser, new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0
			, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
			new Insets(0, 0, 0, 0), 148, -29));

		jLabel3.setText("Functionaries");

		jLabel4.setText("Internal");

		jLabel5.setText("Waypoints");

		jLabel6.setText("Mobile phones");

		jLabel7.setText("Start time");

		jLabel8.setText("Distance");

		jLabel9.setText("Return time");

		jLabel10.setText("Actual return time");

		jLabel11.setText("Misc info");


		getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);
		jPanel3.add(jLabel3,   new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 91, 6));
		jPanel3.add(functionariesChooser,  new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 148, -29));
		jPanel3.add(jLabel4,  new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 147, 6));
		jPanel3.add(internalBox,  new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 174, 0));
		jPanel3.add(jLabel5,  new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 130, 6));
		jPanel3.add(jLabel6,  new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 103, 6));
		jPanel3.add(mobilePhonesChooser,  new GridBagConstraints(1, 7, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 148, -29));
		jPanel3.add(jLabel8,  new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 141, 6));
		jPanel3.add(distanceText,  new GridBagConstraints(1, 8, 1, 1, 1.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 191, 2));
		jPanel3.add(jLabel10,  new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 82, 6));
		jPanel3.add(actualReturnTimeCombo,  new GridBagConstraints(1, 9, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 73, 2));
		jPanel3.add(jLabel11,  new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 2, 0), 138, 6));
		jPanel3.add(jScrollPane1,  new GridBagConstraints(1, 10, 1, 1, 1.0, 1.0
            ,GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 2, 0), 192, 3));
    jPanel3.add(waypointsDisplayer, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		jScrollPane1.getViewport().add(miscInfoText, null);

		pack();
	} //GEN-END:jbInit

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JButton okButton;
	MultipleChooser artistsChooser=new MultipleChooser(new Artist());
	MultipleChooser carsChooser=new MultipleChooser(new Car());
	MultipleChooser functionariesChooser=new MultipleChooser(new Functionary());
	JCheckBox internalBox=new JCheckBox();
	MultipleChooser mobilePhonesChooser=new MultipleChooser(new MobilePhone());
	PickDateTimeCombo startTimeCombo=new PickDateTimeCombo();
	PickDateTimeCombo returnTimeCombo=new PickDateTimeCombo();
	JTextField distanceText=new JTextField();
	PickDateTimeCombo actualReturnTimeCombo=new PickDateTimeCombo();
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea miscInfoText=new JTextArea();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JButton waypointsDisplayer = new JButton();

/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
		transport=(Transport)o;

		if (transport.getId() == -1) {
			this.setTitle("Add a transport");
			okButton.setText("New");
			okButton.setMnemonic('N');
		} else {
			this.setTitle("Update a transport");
			okButton.setText("Update");
			okButton.setMnemonic('U');

			artistsChooser.addObjects(transport.getArtists());
			carsChooser.addObjects(transport.getCars());
			functionariesChooser.addObjects(transport.getFunctionaries());
			internalBox.setSelected(transport.getInternal());
			mobilePhonesChooser.addObjects(transport.getMobilePhones());
			startTimeCombo.setDate(transport.getStartTime());
			returnTimeCombo.setDate(transport.getReturnTime());
			actualReturnTimeCombo.setDate(transport.getActualReturnTime());
			miscInfoText.setText(transport.getMiscInfo());
		}

	}

	/**
	 * editNew
	 */
	public void editNew() {
		edit(new Transport());
	}

  void cancelButton_actionPerformed(ActionEvent e) {
	  this.dispose();
  }

  void okButton_actionPerformed(ActionEvent e) {
	  Object[] o;
	  int i;

	  o=artistsChooser.getObjects();

	  Artist[] artists=new Artist[o.length];
	  for (i=0; i < o.length; i++) {
		  artists[i]=(Artist)o[i];
	  }
	  transport.setArtists(artists);

	  o=carsChooser.getObjects();

	  Car[] cars=new Car[o.length];
	  for (i=0; i < o.length; i++) {
		  cars[i]=(Car)o[i];
	  }

	  transport.setCars(cars);

	  o=functionariesChooser.getObjects();

	  Functionary[] func=new Functionary[o.length];
	  for (i=0; i < o.length; i++) {
		  func[i]=(Functionary)o[i];
	  }

	  transport.setFunctionaries(func);
	  transport.setInternal(internalBox.isSelected());

	// TODO: fix fscking waypoints.

	transport.setWaypoints(waypointChooser.getWaypoints());

//	  transport.setWaypoints((TransportWaypoint[])waypointsChooser.getObjects());

	  o=mobilePhonesChooser.getObjects();

	  MobilePhone[] phones=new MobilePhone[o.length];
	  for (i=0; i < o.length; i++) {
		  phones[i]=(MobilePhone)o[i];
	  }

	  transport.setMobilePhones(phones);
	  transport.setStartTime(startTimeCombo.getDate());
	  transport.setReturnTime(returnTimeCombo.getDate());
	  transport.setActualReturnTime(actualReturnTimeCombo.getDate());
	  transport.setMiscInfo(miscInfoText.getText());

	  TransportFactory tf=new TransportFactory();
	  MainFrame mf=(MainFrame)this.getTopLevelAncestor();

	  if (transport.getId() == -1) {
		  tf.newTransport(transport);
		  mf.refreshLists(transport, GenericTableModel.REFRESH_INSERT);
	  } else {
		  tf.updateTransport(transport);
		  mf.refreshLists(transport, GenericTableModel.REFRESH_UPDATE);
	  }

	  this.dispose();
  }

  void waypointsDisplayer_actionPerformed(ActionEvent e) {
	  if (waypointChooserWindow == null) {
		  Window w=(Window)this.getTopLevelAncestor();
		  waypointChooserWindow=new JWindow(w);
		  JPanel contentPane=(JPanel)waypointChooserWindow.getContentPane();
		  contentPane.setLayout(new BorderLayout());
		  waypointChooser=new TransportWaypointChooser(waypointChooserWindow);
		  waypointChooser.addObjects(transport.getWaypoints());
		  contentPane.add(waypointChooser);
		  waypointChooserWindow.pack();
		  Point p=waypointsDisplayer.getLocationOnScreen();
		  waypointChooserWindow.setBounds((int)p.getX(),
										  (int)p.getY() +
										  waypointsDisplayer.getHeight(),
										  500, 300);
	  }

	  if (waypointChooserWindow.isVisible()) {
		  waypointChooser.saveState();
	  }

	  waypointChooserWindow.setVisible(!waypointChooserWindow.isVisible());
  }

}

	// End of variables declaration//GEN-END:variables

class TransportEditor_cancelButton_actionAdapter implements java.awt.event.ActionListener {
  TransportEditor adaptee;

  TransportEditor_cancelButton_actionAdapter(TransportEditor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.cancelButton_actionPerformed(e);
  }
}

class TransportEditor_okButton_actionAdapter implements java.awt.event.ActionListener {
  TransportEditor adaptee;

  TransportEditor_okButton_actionAdapter(TransportEditor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.okButton_actionPerformed(e);
  }
}

class TransportEditor_waypointsDisplayer_actionAdapter implements java.awt.event.ActionListener {
  TransportEditor adaptee;

  TransportEditor_waypointsDisplayer_actionAdapter(TransportEditor adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.waypointsDisplayer_actionPerformed(e);
  }
}
