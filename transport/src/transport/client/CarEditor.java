/*
 * AddCar.java
 *
 * Created on June 26, 2004, 3:25 PM
 */

package transport.client;

import javax.swing.*;

import transport.logic.*;
import transport.server.*;

/**
 *
 * @author  ola
 */
public class CarEditor extends GenericEditor {
	private Car car;

	public CarEditor() {
		this(new Car());
	}

	/** Creates new form AddCar */
	public CarEditor(Car car) {
		jbInit();
		edit(car);
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

		jPanel1=new javax.swing.JPanel();
		jLabel1=new javax.swing.JLabel();
		jLabel2=new javax.swing.JLabel();
		carTypeText=new javax.swing.JTextField();
		jLabel3=new javax.swing.JLabel();
		seatNoText=new javax.swing.JFormattedTextField();
		jLabel4=new javax.swing.JLabel();
		miscInfoText=new javax.swing.JTextField();
		jPanel2=new javax.swing.JPanel();
		okButton=new javax.swing.JButton();
		cancelButton=new javax.swing.JButton();

		jPanel1.setLayout(new java.awt.GridLayout(4, 2));

		jLabel1.setText("Registration number");
		carTypeText.setText("");
		seatNoText.setText("");
		miscInfoText.setSelectionStart(11);
		miscInfoText.setText("");
		regNoText.setText("");
		jPanel1.add(jLabel1);
		jPanel1.add(regNoText, null);

		jLabel2.setText("Car type");
		jPanel1.add(jLabel2);

		carTypeText.setNextFocusableComponent(seatNoText);
		jPanel1.add(carTypeText);

		jLabel3.setText("Number of seats");
		jPanel1.add(jLabel3);

		seatNoText.setNextFocusableComponent(miscInfoText);
		jPanel1.add(seatNoText);

		jLabel4.setText("Misc info");
		jPanel1.add(jLabel4);

		miscInfoText.setNextFocusableComponent(okButton);
		jPanel1.add(miscInfoText);

		getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

		okButton.setMnemonic('O');
		okButton.setText("OK");
		okButton.setNextFocusableComponent(carTypeText);
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});

		jPanel2.add(okButton);

		cancelButton.setMnemonic('C');
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		jPanel2.add(cancelButton);

		seatNoText.setValue(new Integer(5));

		getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);
		getRootPane().setDefaultButton(okButton);

		pack();
	} //GEN-END:jbInit

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_cancelButtonActionPerformed
		this.dispose();
	} //GEN-LAST:event_cancelButtonActionPerformed

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_okButtonActionPerformed
		car.setCarType(carTypeText.getText());
		car.setMiscInfo(miscInfoText.getText());
		car.setRegNo(regNoText.getText());
		car.setNumberOfSeats(Integer.parseInt(seatNoText.getText()));

		CarFactory cf=new CarFactory();
		MainFrame mf=(MainFrame)this.getTopLevelAncestor();

		if (car.getId() == -1) {
			cf.newCar(car);
			mf.refreshLists(car, transport.client.tablemodel.GenericTableModel.REFRESH_INSERT);
		} else {
			cf.updateCar(car);
			mf.refreshLists(car, transport.client.tablemodel.GenericTableModel.REFRESH_UPDATE);
		}
		this.dispose();
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton cancelButton;
	private javax.swing.JTextField carTypeText;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JTextField miscInfoText;
	private javax.swing.JButton okButton;
	private javax.swing.JFormattedTextField seatNoText;
	JTextField regNoText=new JTextField();
	/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
		this.car=(Car)o;

		if (car.getId() == -1) {
			this.setTitle("Add a car");
			okButton.setText("New");
			okButton.setMnemonic('N');
		} else {
			this.setTitle("Update a car");
			okButton.setText("Update");
			okButton.setMnemonic('U');

			carTypeText.setText(car.getCarType());
			seatNoText.setText("" + car.getNumberOfSeats());
			miscInfoText.setText(car.getMiscInfo());
			regNoText.setText(car.getRegNo());
		}
	}

	public void editNew() {
		edit(new Car());
	}

	// End of variables declaration//GEN-END:variables

}
