package activityPackage;
import java.util.LinkedList;
import java.util.List;

import activityPackage.exceptions.CycleException;
import activityPackage.exceptions.StandaloneNodeException;

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
 *.  <p>Creator: Jordyn Celaya<br>
 *   Date Created: 8 October 2018
 *   Last Modifier: Emily Belt, <br>
 *   Date Modified: 9 October 2018<br>
 *   <p>Approver: Emily Belt, <br>
 *   Date Approved: 9 October 2018<br>
 *  </td>
 *  </tr>
 * </table>
 * </center>
 * 
 * <p>The activity class represents an activity within the graph. It has a name, defined by any string; a duration, defined by
 * an integer; dependencies, defined by other activities; and nexts, defined by other activities.
 * 
 */

public class ActivityManager {
	private LinkedList<Activity> nodeList;
	private LinkedList<Activity> headList;
	private Graph activityGraph; 


	/**
	 * Constructor for the ActivityManager class.
	 * 
	 */
	public ActivityManager() {
		headList = new LinkedList<Activity>();
		nodeList = new LinkedList<Activity>();
	}
	
	/**
	 * Helper method to add head node to head list if node has no dependencies
	 *  
	 * @param name the name of this activity
	 * @param depends the dependencies of this activity
	 * @param duration the duration of this activity
	 */
	private void addHead(String name, List<String> depends, int duration) {
		Activity temp = new Activity(name, depends, duration);
		nodeList.add(temp);
		headList.add(temp);
	}

	public LinkedList<Activity> getNodeList() {
		return nodeList;
	}

	public void setNodeList(LinkedList<Activity> nodeList) {
		this.nodeList = nodeList;
	}

	public LinkedList<Activity> getHeadList() {
		return headList;
	}

	public void setHeadList(LinkedList<Activity> headList) {
		this.headList = headList;
	}

	/**
	 * Creates activity node and adds it to node list
	 * 
	 * @param name the name of this activity
	 * @param depends the dependencies of this activity
	 * @param duration the duration of this activity
	 */
	public void addActivity(String name, List<String> depends, int duration) {
		if (depends.size() == 0) {
			addHead(name, depends, duration);
		}
		else {
			Activity temp = new Activity(name, depends, duration);
			nodeList.add(temp);
		}
	}
	

	/**
	 * Creates a new graph every time to account for edited/deleted nodes. Errors are caught in GUI 
	 * classes and print errors there. 
	 * 
	 * @return a list of strings that will be the paths.
	 * @throws StandaloneNodeException
	 * @throws CycleException
	 */
	public List<String> viewPath() throws StandaloneNodeException, CycleException {
		activityGraph = new Graph(headList, nodeList);
		activityGraph.graphify();
		List<String> output = activityGraph.getPaths();
		return output;
	}
	

	public void editActivityDuration(String name, int newDuration) {
		System.out.println("inside edit.");
        for (Activity i : nodeList) {
            if(i.getName() == name) { //if the name of the current activity == name
                i.setDuration(newDuration); //set new activity duration
            }
        }
        for (Activity j : headList){
        	if(j.getName() == name){
        		j.setDuration(newDuration);
        	}
        }
    }
	
	/* WE DONT NEED THESE
	public void editActivityName(String oldName, String newName) {
        for (Activity i : nodeList) {
            if(i.getName() == oldName) { //if the name of the current activity == name
                i.setName(newName); //set new activity name
            }
        }
	}

	//the deletion of an activity is just the standard "arbitrary deletion" in a linked list
	public void deleteActivity(String name) {
		for (Activity i : nodeList) {
            if(i.getName() == name) { //if the name of the current activity == name
                //get the previous activity of the activity to be deleted - call this "previous"
                //set the next of "previous" to the next of the activity to be deleted

            }
        }
	}
*/
	
}
	
