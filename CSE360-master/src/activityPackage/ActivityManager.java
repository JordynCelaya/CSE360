package activityPackage;
import java.util.LinkedList;
import java.util.List;


public class ActivityManager {
	private LinkedList<Activity> nodeList;
	private LinkedList<Activity> headList;
	private Graph activityGraph; 

	
	ActivityManager() {
		headList = new LinkedList<Activity>();
		nodeList = new LinkedList<Activity>();
	}
	
	
	// Helper method to add head node to head list if node has no dependencies
	private void addHead(String name, LinkedList<String> depends, int duration) {
		Activity temp = new Activity(name, depends, duration);
		nodeList.add(temp);
		headList.add(temp);
	}

	// Creates activity node and adds it to list
	public void addActivity(String name, LinkedList<String> depends, int duration) {
		if (depends.size() == 0) {
			addHead(name, depends, duration);
		}
		else {
			Activity temp = new Activity(name, depends, duration);
			nodeList.add(temp);
		}
	}
	
	/* Creates a new graph every time to account for edited/deleted nodes
	 * and will return a List of Strings that will be the paths. Check tests for output example. 
	 * Will throw an error exception for either stand-alone node or cycling. You can catch these
	 * in the GUI and print the error based on that. 
	 */
	public List<String> viewPath() throws StandaloneNodeException, CycleException {
		activityGraph = new Graph(headList, nodeList);
		activityGraph.graphify();
		return activityGraph.getPaths();
	}
	
	// TO DO - see comment on graphify in Graph class
	public void editActivity() {
		
	}
	
	// TO DO
	public void deleteActivity() {
		
	}
	
}
	
