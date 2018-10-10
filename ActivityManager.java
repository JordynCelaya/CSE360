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
	
	public void editActivityName(String oldName, String newName) {
        for (Activity i : nodeList) {
            if(i.getName() == oldName) { //if the name of the current activity == name
                i.setName(newName); //set new activity name
            }
        }
	}

	public void editActivityDuration(String name, int newDuration) {
        for (Activity i : nodeList) {
            if(i.getName() == name) { //if the name of the current activity == name
                i.setDuration(newDuration); //set new activity duration
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
	
}
	
