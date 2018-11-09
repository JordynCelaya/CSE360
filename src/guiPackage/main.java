package guiPackage;
import javax.swing.*;


//import main.ButtonListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import activityPackage.*;

//import window.java;

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
 * <p>The main class creates the overall GUI for the activity network program. It uses Java Applet to create the GUI
 * and has a menu bar and three tabs for input, edit, and display. 
 * 
 */

public class main extends JApplet {
	private JTabbedPane tPane;
	private inputTab itab;
	private editTab etab;
	private viewTab vtab;
	private JMenuBar menuBar;
	private JMenu menu1, menu2;	//first and second tab of the menu bar
	private JButton reset, exit, about, help, report; //these are submenu items that will drop down from menu1 and menu2
	Frame title;	//will be used to change the title of the applet window
	public ActivityManager manager = new ActivityManager(); 
	
	public void init() {
		//constructor used to create the Java frame and initialize all of the private swing variables
		tPane = new JTabbedPane();
		itab = new inputTab(manager);
		etab = new editTab(manager);
		vtab = new viewTab(manager);
		menuBar = new JMenuBar();
		menu1 = new JMenu("File");
		menu2 = new JMenu("Help");
		reset = new JButton("Reset");
		exit = new JButton("Exit");
		about = new JButton("About this program");
		help = new JButton("Help");
        report = new JButton("Create report");
		
		ButtonListener lis = new ButtonListener();
		reset.addActionListener(lis);
		exit.addActionListener(lis);
		about.addActionListener(lis);
		help.addActionListener(lis);
        report.addActionListener(lis);
		
		//put together the menu bar
		menuBar.add(menu1);	//add menu1 and menu2 to the main menu bar
		menuBar.add(menu2);
		menu1.add(reset);	//add the menu items to the drop down list of menu1 and menu2
		menu1.add(exit);
        menu1.add(report);
		menu2.add(about);
		menu2.add(help);
		
		//add tabs:
		tPane.addTab("Input", itab);
		tPane.addTab("Edit", etab);
		tPane.addTab("View Path", vtab);
		
		//set up the main java Applet window
		title = (Frame)this.getParent().getParent();	//set title to the applet title (applet is frame's grandparent)
		title.setTitle("Activity Manager");	//change title
		setJMenuBar(menuBar);	//add menu bar to the applet
		getContentPane().add(tPane);	//add tabs to the main java frame
		setSize(900,600);	//set applet size (width, height)
		
		
	}//end of constuctor
	
	
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			JFrame f1 = new JFrame();
			f1.setSize(700,400);
			if(event.getSource() == reset){
	        	int n = JOptionPane.showConfirmDialog(f1,"Are you sure you would like to clear all activities?","Reset",JOptionPane.YES_NO_OPTION);
	        	//0 = Yes, 1 = No
	        	if(n == 0){
	        		//reset the whole program 
	        		vtab.clearTArea();
	        		// ActivityManager newManager = new ActivityManager();
	        		// manager = newManager;
	        		manager.setNodeList(new LinkedList<>());
	        		manager.setHeadList(new LinkedList<>());
	        		
	        		
	        		
	        	}
	        	//1 automatically cancels
            }
	        else if(event.getSource() == exit){
	        	int n = JOptionPane.showConfirmDialog(f1,"Are you sure you would like to exit the Activity Manager?","Exit",JOptionPane.YES_NO_OPTION);
	        	//0 = Yes, 1 = No
	        	if(n == 0){
	        		//exit the whole program
	        		System.exit(0);
	        	}
	        	//1 automatically cancels
	        }
            else if(event.getSource() == report){
                //report requirements:
                //Title for the report
                //Date and time of creation
                //List of all activities in alphanumeric order with current duration
                //List of all paths with the activity names and total duration
                
                //pop up a file chooser when the button is pressed
                JFileChooser fc = new JFileChooser();
                int n = fc.showSaveDialog(report.getParent());    //int is for if the user pressed save or cancel
                //0 is user pressed save, 1 is user pressed cancel
                
                
                if(n == 0){
                    String name = fc.getName(); //retrieves the title that the user enters
                    System.out.println( fc.getSelectedFile());
                }
            }
	        else if(event.getSource() == about){
	        	JOptionPane.showMessageDialog(f1, "About this program:"
	        			+ "\n\nPurpose: This program manages multiple activities. This program easily allows a project manager to"
	        			+ "\nset out a project plan for a team and identify the interaction between different tasks and the implications "
	        			+ "\nthese interactions have on the various paths of work necessary for the project’s completion"
	        			+ "\n\nSoftware Developers: Emily Belt, Jordyn Celaya, Ariana Kiaei, Jeremy Lacsa");
	        }
	        else if(event.getSource() == help){
	        	JOptionPane.showMessageDialog(f1, "For specific error messages please see below. Else, please check the User Guide."
	        			+ "\n\nError: Null Activity Name - There is no name entered for the current activity. "
	        			+ "\n\t\tEnter the activity name into the “Enter Activity Name” field. "
	        			+ "\nError: Duration Not An Integer - The number entered into the activity duration is not a valid integer. "
	        			+ "\n\t\tEnter a valid integer into the “Activity Duration” field. "
	        			+ "A valid integer is non-negative with no decimals."
	        			+ "\nError: Null Duration - There is no duration entered for the current activity."
	        			+ "\n\t\tEnter a valid integer into the “Activity Duration” field. "
	        			+ "\nError: Activity Cycle Detected - A loop exists in the activity dependencies. "
	        			+ "\n\t\tCheck activities for any circular-referencing dependencies and edit them."
	        			+ "\nError: Standalone Activity Detected - An activity has no predecessor activity or dependent activity. "
	        			+ "\n\t\tEnsure all activities are either dependent on another activity or have activities dependent on them. ");
	        }
	        	
	             
	         } //end of actionPerformed method
	    } //end of ButtonListener class

}
