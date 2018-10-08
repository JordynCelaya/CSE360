import java.awt.*;
import javax.swing.*;

public class viewTab extends JPanel{
	//private Panel p1;
	private JTextArea area;
	private JScrollPane spane;
	
	public viewTab(){
		//constructor for viewTab panel
		area = new JTextArea(20,40);
		area.setEditable(false);	//prevents the user from inputting anything
		area.setText("No paths to display");
		spane = new JScrollPane(area);
		
		add(spane);
	}
	
	public void addPath(){
		//this function adds a path and puts it into the textarea so it can be displayed to the user
	}

}
