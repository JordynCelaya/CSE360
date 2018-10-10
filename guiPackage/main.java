package guiPackage;
import javax.swing.*;

import java.awt.*;
import java.util.*;
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
	private JMenuItem reset, exit, about, help; //these are submenu items that will drop down from menu1 and menu2
	Frame title;	//will be used to change the title of the applet window
	
	public void init() {
		//constructor used to create the Java frame and initialize all of the private swing variables
		tPane = new JTabbedPane();
		itab = new inputTab();
		etab = new editTab();
		vtab = new viewTab();
		menuBar = new JMenuBar();
		menu1 = new JMenu("File");
		menu2 = new JMenu("Help");
		reset = new JMenuItem("Reset");
		exit = new JMenuItem("Exit");
		about = new JMenuItem("About this program");
		help = new JMenuItem("Help");
		
		//put together the menu bar
		menuBar.add(menu1);	//add menu1 and menu2 to the main menu bar
		menuBar.add(menu2);
		menu1.add(reset);	//add the menu items to the drop down list of menu1 and menu2
		menu1.add(exit);
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
		setSize(800,500);	//set applet size (width, height)
		
		
	}

}
