package guiPackage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class editTab extends JPanel{
	private JButton edit, delete;
	private Panel p1, cboxpanel;
	
	public editTab(){
		//constructor for edit tab panel
		
		//initialize the private frame variables
		edit = new JButton("Edit Selected");
		delete = new JButton("Delete Selected");
		p1 = new Panel();
		cboxpanel = new Panel();
		
		//add the buttons to panel 1 (default layout is flow layout)
		p1.add(edit);
		p1.add(delete);
		
		//add the buttons and panels to the tab window
		setLayout(new BorderLayout());
		add(cboxpanel, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);
	}
	
	public void addEditCBox(String activity, String dependency, int duration){
		//this function adds a check box to the edit tab, using the input parameters activity, duration, and dependencies
		JCheckBox box1;
		box1 = new JCheckBox("Acvitity: "+activity+"\tDependencies: "+dependency+"\tDuration: "+duration);
		CheckBoxListener boxLis = new CheckBoxListener();
		box1.addItemListener(boxLis);
		cboxpanel.add(box1);
	}
	
	private class CheckBoxListener implements ItemListener{
		//this class listens for when a checkbox is checked and performs an action if the button is pressed as well
	       public void itemStateChanged(ItemEvent event)
	        {
	            //check in here if the button was pressed
	    	   JButton b2 = new JButton("Button");
	    	   p1.add(b2);
	        }
	  } 
	
	//add a button listener function for Edit Selected
	//add a button listener function for Delete Selected
}
