import java.util.LinkedList;
import java.util.List;

public class Graph {
	 List<Activity> nodes;
	 List<Activity> heads;
	 
     Graph(List<Activity> headList, List<Activity> nodes) {
         this.nodes = nodes;
         this.heads = headList;
     }
     
     /* Creates a graph with the node list from ActivityManager. A new graph is created every time it is called, which 
      I was thinking is every time create paths in the GUI is called. This makes editing/deleting activities simpler - 
      they can be changed in the activity manager list without worrying about pointers, and then a new graph will be created
     when they tab to the path screen. */ 
     public void graphify() {
    	 // Clear next lists for for new graph
    	 for (Activity n: nodes) {
    		 n.setNexts(new LinkedList<Activity>());
    	 }
    	 
    	 // Hook up nexts to proper nodes
    	 for (Activity n: nodes) {
    		 for (String d: n.getDependencies()) {
    			 for (Activity activity: nodes) {
    				 if (activity.getName().equals(d)) {
    					 activity.getNexts().add(n);
    					 break;
    				 }
    			 }
    		 }
    	 }
     }
     
     /* Depth first traversal, returns list of strings for paths starting from activity heads.
     Uses private helper method getPathsUtil()*/
     public List<String> getPaths() throws CycleException, StandaloneNodeException {
    	 List<String> paths = new LinkedList<String>();
    	 for (Activity head: heads) {
    		 getPathsUtil(head, paths, new LinkedList<>());
    	 } 
    	 return paths;
     }
     
     private void getPathsUtil(Activity head, List<String> paths, List<Activity> currentPath) throws CycleException, StandaloneNodeException {
    	 head.setVisited(true);
    	 currentPath.add(head);
    	 if (head.getNexts().isEmpty()) {
    		 // check if node has no next nodes and no dependencies
    		 if (currentPath.size() == 1) {
    			 throw new StandaloneNodeException();
    		 }
    		 String entry = "";
    		 int totalDuration = 0; 
    		 for (Activity a: currentPath) {
    			 entry += a.getName() + ", ";
    			 totalDuration += a.getDuration();
    		 }
    		 entry += "Total Duration: " + totalDuration;
    		 paths.add(entry);
    	 }
    	 for (Activity child: head.getNexts()) {
    		 if (!child.isVisited()) {
    			 getPathsUtil(child, paths, currentPath); 
    			 // Reset visited boolean to false for future child traversals 
            	 for (Activity n: nodes) {
            		 n.setVisited(false);
            	 }
    		 }
    		 else {
    			 throw new CycleException();
    		 }
    	 }
    	 currentPath.remove(currentPath.size() - 1);
     }	 
}
