package guiPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class inputTab extends JPanel {
	private JLabel menu, entName, entDep, entDur, message;
		//labels for the menu and Enter activity name/duration/dependencies
	private JTextField names, deps, durs;
		//textfield for entering activity name, dependencies, and durations
	private JButton add;
	private JPanel p1;
	private editTab etab;
	
	
	public inputTab(){
		//constructor for input tab panel
		menu = new JLabel("Menu");
		entName = new JLabel("Enter activity name:");
		entDep = new JLabel("Enter the dependencies, separated by commas:");
		entDur = new JLabel("Enter the activity's duration as an integer:");
		message = new JLabel(""); //leave blank. will be set to something else if an activity is added or an error pops up
		message.setForeground(Color.RED);	//set text color to red
		
		names = new JTextField(25);
		deps = new JTextField(25);
		durs = new JTextField(5);
		
		ButtonListener lis = new ButtonListener(); //listens for when the button is pushed
		add = new JButton("Add Activity");
		add.addActionListener(lis);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout(3,2));	//creates a grid of 3 rows, 2 columns
		p1.add(entName);
		p1.add(names);
		p1.add(entDep);
		p1.add(deps);
		p1.add(entDur);
		p1.add(durs);
		
		
		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(message, BorderLayout.CENTER);
		add(add, BorderLayout.SOUTH);
		
		
	}//end of constructor
	
	//add button listener class for adding an activity
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			//adds some activity information to the path and does error handling
			//extract the information from the textfields
	        	 
	        //Error handling
	        //NEEDS FIXING: need to change null pointer so it only affects empty duration or activity
	        try{
	        	//need to get input from names, deps, and durs
	        	//sooo many errors here
	        	String activity = names.getText();
	         	
	        	String s1 = durs.getText();
	         	int duration = Integer.parseInt(s1);
	         	
	         	String dependencies = deps.getText();
	         	
	     
	         	String strList = "";
	        	 	
	         	//making check boxes and calling addCheckBox method
	    		etab.addEditCBox(activity, dependencies, duration);
	    	 		
	         	//INPUT MORE THINGS HERE:
	    		//add new activity to the path
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
	//connect the info to the edit tab and path functions
	
}
