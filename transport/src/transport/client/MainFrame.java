/*
 * MainFrame.java
 *
 * Created on June 12, 2004, 5:32 PM
 */

package transport.client;

/**
 *
 * @author  ola
 */
public class MainFrame extends javax.swing.JFrame {
	
	/** Creates new form MainFrame */
	public MainFrame() {
		initComponents();
		this.setSize(800,600);
	}
	
	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
        private void initComponents() {//GEN-BEGIN:initComponents
                desktopPane = new javax.swing.JDesktopPane();
                MenuBar = new javax.swing.JMenuBar();
                FileMenu = new javax.swing.JMenu();
                MenuExit = new javax.swing.JMenuItem();
                EditMenu = new javax.swing.JMenu();
                ArtistEditMenuItem = new javax.swing.JMenuItem();
                CarEditMenuItem = new javax.swing.JMenuItem();
                FunctionaryEditMenuItem = new javax.swing.JMenuItem();
                MobilePhoneEditMenuItem = new javax.swing.JMenuItem();
                PlaceEditMenuItem = new javax.swing.JMenuItem();
                RoleEditMenuItem = new javax.swing.JMenuItem();
                TransportEditMenuItem = new javax.swing.JMenuItem();
                AddThingsMenu = new javax.swing.JMenu();
                ArtistAddMenuItem = new javax.swing.JMenuItem();
                CarAddMenuItem = new javax.swing.JMenuItem();
                FunctionaryAddMenuItem = new javax.swing.JMenuItem();
                MobilePhoneAddMenuItem = new javax.swing.JMenuItem();
                PlaceAddMenuItem = new javax.swing.JMenuItem();
                RoleAddMenuItem = new javax.swing.JMenuItem();
                TransportAddMenuItem = new javax.swing.JMenuItem();
                ViewMenu = new javax.swing.JMenu();
                ViewFunctionaryScheduleMenuItem = new javax.swing.JMenuItem();
                ViewCarScheduleMenuItem = new javax.swing.JMenuItem();

                setTitle("Arvikafestivalen Booking System");
                setName("MainFrame");
                addWindowListener(new java.awt.event.WindowAdapter() {
                        public void windowClosing(java.awt.event.WindowEvent evt) {
                                exitForm(evt);
                        }
                });

                desktopPane.setAutoscrolls(true);
                getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

                FileMenu.setMnemonic('F');
                FileMenu.setText("File");
                FileMenu.setToolTipText("File menu");
                MenuExit.setMnemonic('E');
                MenuExit.setText("Exit");
                MenuExit.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                menuExitHandler(evt);
                        }
                });

                FileMenu.add(MenuExit);

                MenuBar.add(FileMenu);

                EditMenu.setMnemonic('E');
                EditMenu.setText("Edit");
                ArtistEditMenuItem.setText("Artists");
                ArtistEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ArtistEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(ArtistEditMenuItem);

                CarEditMenuItem.setText("Cars");
                CarEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                CarEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(CarEditMenuItem);

                FunctionaryEditMenuItem.setText("Functionaries");
                FunctionaryEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                FunctionaryEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(FunctionaryEditMenuItem);

                MobilePhoneEditMenuItem.setText("Mobile phones");
                MobilePhoneEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                MobilePhoneEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(MobilePhoneEditMenuItem);

                PlaceEditMenuItem.setText("Places");
                PlaceEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                PlaceEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(PlaceEditMenuItem);

                RoleEditMenuItem.setText("Roles");
                RoleEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                RoleEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(RoleEditMenuItem);

                TransportEditMenuItem.setText("Transports");
                TransportEditMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                TransportEditMenuItemActionPerformed(evt);
                        }
                });

                EditMenu.add(TransportEditMenuItem);

                MenuBar.add(EditMenu);

                AddThingsMenu.setMnemonic('A');
                AddThingsMenu.setText("Add");
                ArtistAddMenuItem.setText("Add Artist");
                ArtistAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                ArtistAddMenuItemActionPerformed(evt);
                        }
                });
                ArtistAddMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                displayArtistFrame(evt);
                        }
                });

                AddThingsMenu.add(ArtistAddMenuItem);

                CarAddMenuItem.setMnemonic('C');
                CarAddMenuItem.setText("Add Car");
                CarAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                CarAddMenuItemActionPerformed(evt);
                        }
                });

                AddThingsMenu.add(CarAddMenuItem);

                FunctionaryAddMenuItem.setMnemonic('F');
                FunctionaryAddMenuItem.setText("Add Functionary");
                FunctionaryAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                FunctionaryAddMenuItemActionPerformed(evt);
                        }
                });

                AddThingsMenu.add(FunctionaryAddMenuItem);

                MobilePhoneAddMenuItem.setText("Add mobile phone");
                MobilePhoneAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                MobilePhoneAddMenuItemActionPerformed(evt);
                        }
                });

                AddThingsMenu.add(MobilePhoneAddMenuItem);

                PlaceAddMenuItem.setText("Add place");
                PlaceAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                PlaceAddMenuItemActionPerformed(evt);
                        }
                });

                AddThingsMenu.add(PlaceAddMenuItem);

                RoleAddMenuItem.setText("Add role");
                RoleAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                RoleAddMenuItemActionPerformed(evt);
                        }
                });

                AddThingsMenu.add(RoleAddMenuItem);

                TransportAddMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_INSERT, 0));
                TransportAddMenuItem.setText("Add transport");
                TransportAddMenuItem.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                TransportAddMenuItemActionPerformed(evt);
                        }
                });

                AddThingsMenu.add(TransportAddMenuItem);

                MenuBar.add(AddThingsMenu);

                ViewMenu.setMnemonic('V');
                ViewMenu.setText("View");
                ViewFunctionaryScheduleMenuItem.setText("Functionary schedule");
                ViewMenu.add(ViewFunctionaryScheduleMenuItem);

                ViewCarScheduleMenuItem.setText("Car schedule");
                ViewMenu.add(ViewCarScheduleMenuItem);

                MenuBar.add(ViewMenu);

                setJMenuBar(MenuBar);

                pack();
        }//GEN-END:initComponents

	private void TransportEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransportEditMenuItemActionPerformed
		desktopPane.add(new TransportFrame());
	}//GEN-LAST:event_TransportEditMenuItemActionPerformed

	private void RoleEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleEditMenuItemActionPerformed
		desktopPane.add(new RoleFrame());
	}//GEN-LAST:event_RoleEditMenuItemActionPerformed

	private void PlaceEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceEditMenuItemActionPerformed
		desktopPane.add(new PlaceFrame());
	}//GEN-LAST:event_PlaceEditMenuItemActionPerformed

	private void MobilePhoneEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobilePhoneEditMenuItemActionPerformed
		desktopPane.add(new MobilePhoneFrame());
	}//GEN-LAST:event_MobilePhoneEditMenuItemActionPerformed

	private void FunctionaryEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FunctionaryEditMenuItemActionPerformed
		desktopPane.add(new FunctionaryFrame());
	}//GEN-LAST:event_FunctionaryEditMenuItemActionPerformed

	private void CarEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarEditMenuItemActionPerformed
		desktopPane.add(new CarFrame());
	}//GEN-LAST:event_CarEditMenuItemActionPerformed

	private void TransportAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransportAddMenuItemActionPerformed
		desktopPane.add(new TransportEditor());
	}//GEN-LAST:event_TransportAddMenuItemActionPerformed

	private void RoleAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleAddMenuItemActionPerformed
		desktopPane.add(new RoleEditor());
	}//GEN-LAST:event_RoleAddMenuItemActionPerformed

	private void PlaceAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceAddMenuItemActionPerformed
		desktopPane.add(new PlaceEditor());
	}//GEN-LAST:event_PlaceAddMenuItemActionPerformed

	private void MobilePhoneAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MobilePhoneAddMenuItemActionPerformed
		desktopPane.add(new MobilePhoneEditor());
	}//GEN-LAST:event_MobilePhoneAddMenuItemActionPerformed

	private void FunctionaryAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FunctionaryAddMenuItemActionPerformed
		desktopPane.add(new FunctionaryEditor());
	}//GEN-LAST:event_FunctionaryAddMenuItemActionPerformed

	private void CarAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarAddMenuItemActionPerformed
		desktopPane.add(new CarEditor());
	}//GEN-LAST:event_CarAddMenuItemActionPerformed

	private void ArtistEditMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistEditMenuItemActionPerformed
		// TODO add your handling code here:
		desktopPane.add(new ArtistFrame());
	}//GEN-LAST:event_ArtistEditMenuItemActionPerformed

	private void menuExitHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitHandler
		// TODO add your handling code here:
		System.exit(0);
	}//GEN-LAST:event_menuExitHandler

	private void ArtistAddMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistAddMenuItemActionPerformed
		desktopPane.add(new ArtistEditor());
	}//GEN-LAST:event_ArtistAddMenuItemActionPerformed

	private void displayArtistFrame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayArtistFrame
		//desktopPane.add(new ArtistFrame());
	}//GEN-LAST:event_displayArtistFrame
	
	/** Exit the Application */
	private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
		System.exit(0);
	}//GEN-LAST:event_exitForm
	
	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		new MainFrame().show();
	}
	
        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JMenu AddThingsMenu;
        private javax.swing.JMenuItem ArtistAddMenuItem;
        private javax.swing.JMenuItem ArtistEditMenuItem;
        private javax.swing.JMenuItem CarAddMenuItem;
        private javax.swing.JMenuItem CarEditMenuItem;
        private javax.swing.JMenu EditMenu;
        private javax.swing.JMenu FileMenu;
        private javax.swing.JMenuItem FunctionaryAddMenuItem;
        private javax.swing.JMenuItem FunctionaryEditMenuItem;
        private javax.swing.JMenuBar MenuBar;
        private javax.swing.JMenuItem MenuExit;
        private javax.swing.JMenuItem MobilePhoneAddMenuItem;
        private javax.swing.JMenuItem MobilePhoneEditMenuItem;
        private javax.swing.JMenuItem PlaceAddMenuItem;
        private javax.swing.JMenuItem PlaceEditMenuItem;
        private javax.swing.JMenuItem RoleAddMenuItem;
        private javax.swing.JMenuItem RoleEditMenuItem;
        private javax.swing.JMenuItem TransportAddMenuItem;
        private javax.swing.JMenuItem TransportEditMenuItem;
        private javax.swing.JMenuItem ViewCarScheduleMenuItem;
        private javax.swing.JMenuItem ViewFunctionaryScheduleMenuItem;
        private javax.swing.JMenu ViewMenu;
        private javax.swing.JDesktopPane desktopPane;
        // End of variables declaration//GEN-END:variables
	
}
