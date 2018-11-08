package guiPackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import activityPackage.*;
//import guiPackage.inputTab.ButtonListener;

import java.util.*;
import java.util.List;

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
	private JLabel menu, entName, entDur, message; //label for Enter activity name
	private JTextField name, dur; //text field for entering activity name
	
	private static JPanel cboxpanel;
	private JButton editButton;
	public ActivityManager manager; 
	
	/**
	 * Constructor for edit tab panel
	 */
	public editTab(ActivityManager manager){
		menu = new JLabel("Menu");
		entName = new JLabel("Enter name of activity to edit:");
		entDur = new JLabel("Enter new duration for activity:");
		message = new JLabel(""); //leave blank. will be set to something else if an activity is added or an error pops up
		message.setForeground(Color.RED);	//set text color to red
		
		name = new JTextField(25);
		dur = new JTextField(25);
		
		ButtonListener lis = new ButtonListener(); //listens for when the button is pushed
		editButton = new JButton("Edit Activity");
		editButton.addActionListener(lis);
		
		cboxpanel = new JPanel();
		cboxpanel.setLayout(new GridLayout(2,2));
		cboxpanel.add(entName);
		cboxpanel.add(name);
		cboxpanel.add(entDur);
		cboxpanel.add(dur);
		
		//add the buttons and panels to the tab window
		setLayout(new BorderLayout());
		add(cboxpanel, BorderLayout.NORTH);
		add(editButton, BorderLayout.SOUTH);
		add(message, BorderLayout.CENTER);
		this.manager = manager;
		
	}
	/*
	/**
	 * Adds an activity to the list of all activities
	 * 
	 * @param activity the name of the activity
	 * @param dependency the dependencies of the activity
	 * @param duration the duration fo the activity
	 *
	public static void addAllAct(String activity, String dependency, int duration){
		//this function adds a check box to the edit tab, using the input parameters activity, duration, and dependencies
		JLabel l1;
		l1 = new JLabel("Acvitity: "+activity+"\tDependencies: "+dependency+"\tDuration: "+duration);
				
		cboxpanel.add(l1);
	}
*/
	
	//add a button listener function for Edit Selected
	/**
	 * The ButtonListener class 
	 * 
	 *
	 */
	private class ButtonListener implements ActionListener{
		
		/**
		 * Edits an activity's duration and performs error handling. 
		 * 
		 * @param event when a user clicks on the button
		 */
		public void actionPerformed(ActionEvent event){
			//adds some activity information to the path and does error handling
			//extract the information from the text fields
	        	 
	        try{
	        	//need to get input from names, deps, and durs
	        	String activity = name.getText();
	        	String s1 = dur.getText();
	         	int duration = Integer.parseInt(s1);
	         	
	         	System.out.println("before edit");
	         	manager.editActivityDuration(activity, duration);
	         	System.out.println("after edit");
	         	
	         	//clearing input fields
	         	JTextField ctrl = (JTextField) name;
	            ctrl.setText("");
	            JTextField ctrl2 = (JTextField) dur;
	            ctrl2.setText("");
	        	 	
	         	message.setText("Activity edited");
	         	
	         }
	        //catch exception for when a non-integer value is entered for duration
	         catch(NumberFormatException ex){
	        	 message.setText("Please enter an integer for the activity duration");
	         }
	        //catch exception for when one field does not have a value entered   
	        catch(NullPointerException b){
       		 message.setText("Please enter all fields");
       	 	}
	             
	         } //end of actionPerformed method
	    } //end of ButtonListener class
	
		
}
