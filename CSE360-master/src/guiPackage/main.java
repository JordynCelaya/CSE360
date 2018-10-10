package guiPackage;
import javax.swing.*;

import java.awt.*;
import java.util.*;
//import window.java;


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
