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
 *  <td valign="top">
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
 * <p>The Graph class represents the activity network as a whole. It creates each of the paths in the activity network
 * and creates the string output with the list of activities and duration for each path. 
 * 
 */

public class Graph {
	 List<Activity> nodes;
	 List<Activity> heads;
	 
	 /**
	  * Constructor for the Graph class
	  * 
	  * @param headList the list containing the heads of activity paths
	  * @param nodes the list containing nodes of activity path
	  */
     Graph(List<Activity> headList, List<Activity> nodes) {
         this.nodes = nodes;
         this.heads = headList;
     }
     
     /**
      * Creates a graph with the node list from ActivityManager. A new graph is created 
      * every time graphify is called. 
      * 
      */
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
     
     /**
      * Depth first traversal, returns list of strings for paths starting from activity heads.
      *	Uses private helper method getPathsUtil()
      * 
      * @return the list of paths
      * @throws CycleException if cycle is found in network
      * @throws StandaloneNodeException if node with no predecessors or next is found
      */
     public List<String> getPaths() throws CycleException, StandaloneNodeException {
    	 System.out.println("GetPaths");
    	 for (Activity h: heads) {
    		 System.out.println(h);
    	 }
    	 List<String> paths = new LinkedList<String>();
    	 for (Activity head: heads) {
    		 getPathsUtil(head, paths, new LinkedList<>());
    	 } 
    	 System.out.println(paths.isEmpty());
    	 return paths;
     }
   
          
     /**
      * Helper method to find each of the paths within the network. It also finds the total duration of a given path. 
      * 
      * @param head the head activity
      * @param paths the list of paths
      * @param currentPath the current path
      * @throws CycleException if cycle is found in network
      * @throws StandaloneNodeException if node with no predecessors or next is found
      */
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
    		 System.out.println(entry.isEmpty());
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
