package guiPackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
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
 * <p>The editTab class creates the GUI for the edit tab in the activity network program. 
 * 
 */

public class editTab extends JPanel{
	private Panel cboxpanel;
	
	/**
	 * Constructor for edit tab panel
	 */
	public editTab(){

		cboxpanel = new Panel();

		
		//add the buttons and panels to the tab window
		setLayout(new BorderLayout());
		add(cboxpanel, BorderLayout.CENTER);
	}
	
	/**
	 * Adds a check box to the edit tab
	 * 
	 * @param activity the name of the activity
	 * @param dependency the dependencies of the activity
	 * @param duration the duration fo the activity
	 */
	public void addAllAct(String activity, String dependency, int duration){
		//this function adds a check box to the edit tab, using the input parameters activity, duration, and dependencies
		JLabel l1;
		l1 = new JLabel("Acvitity: "+activity+"\tDependencies: "+dependency+"\tDuration: "+duration);
		
		cboxpanel.add(l1);
	}

	/**
	 * CheckBoxListener class listens for when a checkbox is checked and performs an action if a button is pressed
	 *
	 */

	
	//add a button listener function for Edit Selected
	//add a button listener function for Delete Selected
}
