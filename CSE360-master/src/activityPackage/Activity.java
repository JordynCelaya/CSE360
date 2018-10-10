package activityPackage;
import java.io.FileNotFoundException;
import java.util.LinkedList;
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

public class Activity {
	private String name;
	private int duration;
	private List<String> dependencies;
	private List<Activity> nexts;
	private boolean visited;
	
    /**
     * Constructor for the Activity class.  
     *
     * @param name the name of the activity
     * @param dependencies the list of dependent activites
     * @param duration the duration of the activity
     */
	Activity(String name, List<String> dependencies, int duration) {
		this.name = name;
		this.duration = duration;
		this.dependencies = dependencies;
		nexts = new LinkedList<Activity>();
		visited = false;
	}

    /**
     * Return the name of this activity
     *
     * @return the name of this activity
     */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the activity
	 * 
	 * @param name the name of the activity
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the duration of this activity
	 * 
	 * @return the duration of this activity
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * Sets the duration of the activity
	 * 
	 * @param duration the duration of the activity
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * Return the list of dependencies of this activity
	 * 
	 * @return the list of dependencies of this activity
	 */
	public List<String> getDependencies() {
		return dependencies;
	}
	
	/**
	 * Sets the list of dependencies for this activity
	 * 
	 * @param dependencies the list of dependencies for this activity
	 */
	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}
	
	/**
	 * Return the list of nexts for this activity
	 * 
	 * @return the list of nexts for this activity
	 */
	public List<Activity> getNexts() {
		return nexts;
	}

	/**
	 * Sets the list of nexts for this activity
	 * 
	 * @param nexts the list of nexts for this activity
	 */
	public void setNexts(List<Activity> nexts) {
		this.nexts = nexts;
	}

    /**
     * Determines if an activity has been visited. A visited activity has already had all children visited.  
     *
     * @return true if activity has been visited
     */
	public boolean isVisited() {
		return visited;
	}
	
	/**
	 * Sets the state of an activity to either unvisited or visited. 
	 * 
	 * @param visited the boolean visited state of an activity
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Returns the name of this activity as a string. 
	 * 
	 * @return the name of this activity as a string
	 */
	@Override
	public String toString() {
		return "Activity: " + name;
	}
	
}
	
	


