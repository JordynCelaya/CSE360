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
    private JPanel lp1, p1, p2, spanel;
    private JLabel l1, l2;
	private static JTextArea area, a2;
	private JScrollPane spane, sp2;
	private JButton b1, cpath;
	public ActivityManager manager; 
	
	/**
	 * Constructor for viewTab panel
	 */
	public viewTab(ActivityManager manager){
		area = new JTextArea(10,10);
		area.setEditable(false);	//prevents the user from inputting anything
		area.setText("No paths to display");
        area.setText("No Paths to Displlay");
        a2 = new JTextArea(10, 10);
        a2.setEditable(false);
        a2.setText("No Critical Path to Display");
        
        sp2 = new JScrollPane(a2);
		spane = new JScrollPane(area);
        
        l1 = new JLabel("Paths:");
        l2 = new JLabel("Critical Path:");
        
		b1 = new JButton("Run");
        cpath = new JButton("Generate Critical Path");
		ButtonListener lis = new ButtonListener();
		b1.addActionListener(lis);
        cpath.addActionListener(lis);
        
		this.manager = manager;
		
        lp1 = new JPanel();
        lp1.setLayout(new GridLayout(1, 2));
        lp1.add(l1);
        
        
        spanel = new JPanel();
        spanel.setLayout(new GridLayout(1, 2));
        spanel.add(spane);
        
        
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(lp1, BorderLayout.NORTH);
        p1.add(spanel, BorderLayout.CENTER);
        
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 2));
        p2.add(b1);
        p2.add(cpath);
        
        setLayout(new BorderLayout());
        
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
	}
	/**
	 * Adds a path and puts it into the text area so it can be displayed to the user
	 */
	
	public static void clearTArea() {
		area.setText("");
	}
	
	private class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(event.getSource() == b1){
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
                }
                catch (StandaloneNodeException e) {
                    area.setText("Error: Standalone Node Detected");
                }
                catch (CycleException e) {
                    area.setText("Error: Cycle Detected");
                }
            }
            else if(event.getSource() == cpath){
                lp1.add(l2);
                spanel.add(sp2);
                a2.setText("No Critical Path to Display");
                revalidate();
            }
			
			
		}
	}

}
