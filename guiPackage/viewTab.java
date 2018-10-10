package guiPackage;
import java.awt.*;
import javax.swing.*;
import activityPackage.*;
import activityPackage.exceptions.CycleException;
import activityPackage.exceptions.StandaloneNodeException;

import java.awt.event.*;
import java.util.List;
import activityPackage.*;

/**
 * <center>
 * <table cellpadding="5" cellspacing="5">
 *  <tr>
 *  <td valign="top">
 *   Course: CSE 360<br>
 *   Section Line Number: 83222<br>
 *   Project: Activity Network<br>
 *  </td>
 *  
 *   *  <td valign="top">
 *   Contributor: Emily Belt<br>
 *   Ira A. Fulton School of Engineering<br>
 *   Arizona State Univeristy<br>
 *   Email: <a href="mailto:ebelt@asu.edu">ebelt@asu.edu</a><br>
 *   Cell: (480) 480-0471<br>
 *  </td>
 * 
 *  <td valign="top">
 *   Contributor: Jordyn Celaya<br>
 *   Ira A. Fulton School of Engineering<br>
 *   Arizona State Univeristy<br>
 *   Email: <a href="mailto:jccelay1@asu.edu">jccelay1@asu.edu</a><br>
 *   Cell: (520) 425-3998<br>
 *  </td>
 * 
 * <td valign="top">
 *   Contributor: Ariana Kiaei<br>
 *   Ira A. Fulton School of Engineering<br>
 *   Arizona State Univeristy<br>
 *   <a href="mailto:akiaei@asu.edu">akiaei@asu.edu</a><br>
 *   Cell: (480) 316-3073<br>
 *  </td>
 * 
 *  <td valign="top">
 *   Contributor: Jeremy Lacsa<br>
 *   Ira A. Fulton School of Engineering<br>
 *   Arizona State Univeristy<br>
 *   Email: <a href="mailto:jlacsa@asu.edu">jlacsa@asu.edu</a><br>
 *   Cell: (480) 491-1595 <br>
 *  </td>
 *  
 *  <td valign="top”>
 *.  <p>Creator: Ariana Kiaei<br>
 *   Date Created: 7 October 2018
 *   Last Modifier: Emily Belt, <br>
 *   Date Modified: 9 October 2018<br>
 *   <p>Approver: Emily Belt, <br>
 *   Date Approved: 9 October 2018<br>
 *  </td>
 *  </tr>
 * </table>
 * </center>
 * 
 * <p>The viewTab class creates the tab in the GUI that allows the user to view all of the paths they created. 
 * 
 */
public class viewTab extends JPanel{
	//private Panel p1;
	private static JTextArea area;
	private JScrollPane spane;
	private JButton b1;
	public ActivityManager manager; 
	
	/**
	 * Constructor for viewTab panel
	 */
	public viewTab(ActivityManager manager){
		area = new JTextArea(20,40);
		area.setEditable(false);	//prevents the user from inputting anything
		area.setText("No paths to display");
		spane = new JScrollPane(area);
		b1 = new JButton("Run");
		ButtonListener lis = new ButtonListener();
		b1.addActionListener(lis);
		this.manager = manager;
		
		setLayout(new BorderLayout());
		
		add(spane, BorderLayout.CENTER);
		add(b1, BorderLayout.SOUTH);
	}
	/**
	 * Adds a path and puts it into the text area so it can be displayed to the user
	 */
	
	public static void clearTArea() {
		area.setText("");
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			try {
				System.out.println("About to view run");
				List<String> output = manager.viewPath();
				for (String s: output) {
					System.out.println(s);
				}
				String singleOutput = "";
				for (String s: output) {
					singleOutput += s + "\n";  
				}
				area.setText(singleOutput);
				
			} catch (StandaloneNodeException e) {
				area.setText("Error: Standalone Node Detected");
			} catch (CycleException e) {
				area.setText("Error: Cycle Detected");
			}
			
		}
	}

}
