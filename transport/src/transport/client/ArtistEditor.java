/*
 * AddArtist.java
 *
 * Created on June 15, 2004, 12:33 AM
 */

package transport.client;

import transport.logic.*;
import transport.server.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author  ola
 */
public class ArtistEditor extends GenericEditor {
//public class ArtistEditor extends javax.swing.JInternalFrame {
	Place[] allPlaces;

	private Artist artist;

	public ArtistEditor() {
		this(new Artist());
	}

	/** Creates new form AddArtist */
	public ArtistEditor(Artist artist) {
		jbInit();
		edit(artist);
	}

	private void fixCombos() {
		allPlaces=(new PlaceFactory()).getAllPlaces();

		for (int i=0; i < allPlaces.length; i++) {
			arrivalCombo.addItem(allPlaces[i]);
			hotelCombo.addItem(allPlaces[i]);
			departureCombo.addItem(allPlaces[i]);
		}
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

		infoPanel=new javax.swing.JPanel();
		jLabel1=new javax.swing.JLabel();
		nameText=new javax.swing.JTextField();
		jLabel2=new javax.swing.JLabel();
		contactNameText=new javax.swing.JTextField();
		jLabel6=new javax.swing.JLabel();
		phoneNumberText=new javax.swing.JFormattedTextField();
		jLabel3=new javax.swing.JLabel();
		arrivalCombo=new javax.swing.JComboBox();
		jLabel4=new javax.swing.JLabel();
		arrivalTimeCombo=new transport.client.PickDateTimeCombo();
		jLabel5=new javax.swing.JLabel();
		hotelCombo=new javax.swing.JComboBox();
		jLabel7=new javax.swing.JLabel();
		departureCombo=new javax.swing.JComboBox();
		jLabel8=new javax.swing.JLabel();
		departureTimeCombo=new transport.client.PickDateTimeCombo();
		jLabel9=new javax.swing.JLabel();
		numberOfArtistsText=new javax.swing.JFormattedTextField();
		jLabel10=new javax.swing.JLabel();
		numberOfCrewText=new javax.swing.JFormattedTextField();
		labelGuests=new javax.swing.JLabel();
		numberOfGuestsText=new javax.swing.JFormattedTextField();
		jLabel11=new javax.swing.JLabel();
		extraInfoText=new javax.swing.JTextArea();
                jLabel20=new javax.swing.JLabel();
                jLabel21=new javax.swing.JLabel();
                jLabel22=new javax.swing.JLabel();
                jLabel23=new javax.swing.JLabel();
                flightNoArrival=new javax.swing.JFormattedTextField();
                flightNoDeparture=new javax.swing.JFormattedTextField();
                stage=new javax.swing.JFormattedTextField();
                bookedBy=new javax.swing.JFormattedTextField();
		buttonPanel=new javax.swing.JPanel();
		okButton=new javax.swing.JButton();
		cancelButton=new javax.swing.JButton();

		setClosable(true);
		setResizable(true);
		setTitle("Add an artist");
        this.addFocusListener(new java.awt.event.FocusAdapter() {
          public void focusGained(FocusEvent e) {
            this_focusGained(e);
          }
    });
        this.getContentPane().setLayout(borderLayout2);
		infoPanel.setLayout(new java.awt.GridLayout(16, 2));

		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel1.setText("Name");

        infoPanel.add(jLabel1);
        infoPanel.add(nameText);
        infoPanel.add(jLabel2);
        infoPanel.add(contactNameText);
        infoPanel.add(jLabel6);
        infoPanel.add(phoneNumberText);
        infoPanel.add(jLabel3);
        infoPanel.add(arrivalCombo);
        infoPanel.add(jLabel4);
        infoPanel.add(arrivalTimeCombo);
        infoPanel.add(jLabel20);
        infoPanel.add(flightNoArrival);
        infoPanel.add(jLabel5);
        infoPanel.add(hotelCombo);
        infoPanel.add(jLabel7);
        infoPanel.add(departureCombo);
        infoPanel.add(jLabel8);
        infoPanel.add(departureTimeCombo);
        infoPanel.add(jLabel21);
        infoPanel.add(flightNoDeparture);
        infoPanel.add(jLabel22);
        infoPanel.add(stage);
        infoPanel.add(jLabel9);
        infoPanel.add(numberOfArtistsText);
        infoPanel.add(jLabel10);
        infoPanel.add(numberOfCrewText);
        infoPanel.add(labelGuests);
        infoPanel.add(numberOfGuestsText);
        infoPanel.add(jLabel23);
        infoPanel.add(bookedBy);
        infoPanel.add(jLabel11);
        infoPanel.add(extraInfoText);
    this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel2.setText("Contact name");

		contactNameText.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				contactNameTextActionPerformed(evt);
			}
		});


		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel6.setText("Phone number");


		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel3.setText("Arrival");


		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel4.setText("Arrival time");


		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel5.setText("Hotel");


		jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel7.setText("Departure");


		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel8.setText("Departure time");


		jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel9.setText("Performers");


		jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel10.setText("Crew");


		labelGuests.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		labelGuests.setText("Guests");


		jLabel11.setText("Extra info");
                jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel20.setText("Flight No Arrival");
                jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel21.setText("Flight No Departure");
                jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel22.setText("Stage");
                jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel23.setText("Booked By");


		okButton.setMnemonic('O');
		okButton.setText("OK");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});


		cancelButton.setMnemonic('C');
		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
    this.getContentPane().add(infoPanel, BorderLayout.NORTH);

		numberOfArtistsText.setValue(new Integer(0));
		numberOfCrewText.setValue(new Integer(0));
		numberOfGuestsText.setValue(new Integer(0));

		okButton.setDefaultCapable(true);
		getRootPane().setDefaultButton(okButton);

		pack();
	} //GEN-END:jbInit

	private void contactNameTextActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_contactNameTextActionPerformed
		// TODO add your handling code here:
	} //GEN-LAST:event_contactNameTextActionPerformed

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_cancelButtonActionPerformed
		this.dispose();
	} //GEN-LAST:event_cancelButtonActionPerformed

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) { //GEN-FIRST:event_okButtonActionPerformed
		// FIXME add error checking

		ArtistFactory af=new ArtistFactory();

		artist.setName(nameText.getText());
		artist.setContactName(contactNameText.getText());
		artist.setTelephoneNo(phoneNumberText.getText());
		artist.setArrivalTime(arrivalTimeCombo.getDate());
		artist.setArrival((Place)arrivalCombo.getSelectedItem());
		artist.setHotel((Place)hotelCombo.getSelectedItem());
		artist.setDepartureTime(departureTimeCombo.getDate());
		artist.setDeparture((Place)departureCombo.getSelectedItem());
		artist.setNoOfArtists(Integer.parseInt(numberOfArtistsText.getText()));
		artist.setNoOfCrew(Integer.parseInt(numberOfCrewText.getText()));
		artist.setNoOfGuests(Integer.parseInt(numberOfGuestsText.getText()));
		artist.setExtraInfo(extraInfoText.getText());
                artist.setStage(stage.getText());
                artist.setBookedBy(bookedBy.getText());
                artist.setArrivalFlightNo(flightNoArrival.getText());
                artist.setDepartureFlightNo(flightNoDeparture.getText());
                MainFrame mf=(MainFrame)this.getTopLevelAncestor();

		if (artist.getId() == -1) {
			af.newArtist(artist);
			mf.refreshLists(artist, transport.client.tablemodel.GenericTableModel.REFRESH_INSERT);
		} else {
			af.updateArtist(artist);
			mf.refreshLists(artist, transport.client.tablemodel.GenericTableModel.REFRESH_UPDATE);
		}




		this.dispose();
	} //GEN-LAST:event_okButtonActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JComboBox arrivalCombo;
	private transport.client.PickDateTimeCombo arrivalTimeCombo;
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton cancelButton;
	private javax.swing.JTextField contactNameText;
	private javax.swing.JComboBox departureCombo;
	private transport.client.PickDateTimeCombo departureTimeCombo;
	private javax.swing.JTextArea extraInfoText;
	private javax.swing.JComboBox hotelCombo;
	private javax.swing.JPanel infoPanel;
	private javax.swing.JFormattedTextField numberOfArtistsText;
	private javax.swing.JFormattedTextField numberOfGuestsText;
	private javax.swing.JFormattedTextField numberOfCrewText;
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
        private javax.swing.JLabel jLabel20;
        private javax.swing.JLabel jLabel21;
        private javax.swing.JLabel jLabel22;
        private javax.swing.JLabel jLabel23;
        private javax.swing.JTextField flightNoArrival;
        private javax.swing.JTextField flightNoDeparture;
        private javax.swing.JTextField stage;
        private javax.swing.JTextField bookedBy;
	private javax.swing.JLabel labelGuests;
	private javax.swing.JTextField nameText;
	private javax.swing.JButton okButton;
	private javax.swing.JFormattedTextField phoneNumberText;
        BorderLayout borderLayout2 = new BorderLayout();

	public Place getPlace(Place p) {
		for (int i=0;i<allPlaces.length;i++){
			if (p.getId()==allPlaces[i].getId()) {
				return allPlaces[i];
			}
		}
		// AIEH!
		return null;
	}

	/**
	 * edit
	 *
	 * @param o Object
	 */
	public void edit(Object o) {
		artist=(Artist)o;

		fixCombos();

		if (artist.getId() == -1) {
			this.setTitle("Add an artist");
			okButton.setText("New");
			okButton.setMnemonic('N');
		} else {
			this.setTitle("Update an artist");
			okButton.setText("Update");
			okButton.setMnemonic('U');

			nameText.setText(artist.getName());
			contactNameText.setText(artist.getContactName());
			phoneNumberText.setText(artist.getTelephoneNo());
			arrivalCombo.setSelectedItem(getPlace(artist.getArrival()));
			departureCombo.setSelectedItem(getPlace(artist.getDeparture()));
			hotelCombo.setSelectedItem(getPlace(artist.getHotel()));
			arrivalTimeCombo.setDate(artist.getArrivalTime());
			departureTimeCombo.setDate(artist.getDepartureTime());
			numberOfArtistsText.setText(""+artist.getNoOfArtists());
			numberOfCrewText.setText(""+artist.getNoOfCrew());
			numberOfGuestsText.setText(""+artist.getNoOfGuests());
			extraInfoText.setText(artist.getExtraInfo());
                        stage.setText(artist.getStage());
                        bookedBy.setText(artist.getBookedBy());
                        flightNoDeparture.setText(artist.getDepartureFlightNo());
                        flightNoArrival.setText(artist.getArrivalFlightNo());
		}
	}

	public void editNew() {
		edit(new Artist());
	}

	// workaround hack.
    void this_focusGained(FocusEvent e) {
		getRootPane().setDefaultButton(okButton);
    }

}
