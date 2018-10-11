package activityPackage;
//import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
//import org.junit.jupiter.api.Test;

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
 * <p>The GraphTest class contains test cases for the Graph class. 
 * Error tests are commented out since they throw error messages - uncomment to test them.  
 * Test cover errors and a multiheaded, multipathed graph output
 * 
 */


class GraphTest {
	/**
	 * Tests a multiheaded, multipathed output. 1 -> 2 -> 3 and 0 -> 2 -> 3
	 */
	@Test
	void MultiHeadAndPath() {
		List<Activity> heads = new LinkedList<>();
		List<Activity> nodes = new LinkedList<>();
		
		Activity zero = new Activity("zero", Collections.emptyList(), 5);
		Activity one = new Activity("one", Collections.emptyList(), 3 );
		Activity two = new Activity("two", Arrays.asList("one", "zero"), 2 ); 
		Activity three = new Activity("three", Arrays.asList("two"), 7 );
		Activity four = new Activity("four", Arrays.asList("twoandhalf", "three"), 4 );
		Activity twoandhalf = new Activity("twoandhalf", Arrays.asList("two"), 1 );
		
		heads.add(one);
		heads.add(zero);
		nodes.add(three);
		nodes.add(one);
		nodes.add(two);
		nodes.add(zero);
		nodes.add(four);
		nodes.add(twoandhalf);
		
		Graph g = new Graph(heads, nodes);
		g.graphify();
		try {
			// assert(g.getPaths().contains("one, two, three, Total Duration: 12"));
			for (String s: g.getPaths()) {
				System.out.println(s);
				//assert(s.equals("one, two, three, Total Duration: 12"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Tests a cycle error throw. 1 -> 2 -> 3 -> 1 
	@Test
	void Cycle() {
		List<Activity> heads = new LinkedList<>();
		List<Activity> nodes = new LinkedList<>();
		
		Activity one = new Activity("one", Arrays.asList("three"), 3 );
		Activity two = new Activity("two", Arrays.asList("one"), 2 ); 
		Activity three = new Activity("three", Arrays.asList("two"), 7 );
		
		heads.add(one);
		nodes.add(three);
		nodes.add(one);
		nodes.add(two);
		
		Graph g = new Graph(heads, nodes);
		g.graphify();
		try {
//		 	assert(g.getPaths().contains(" one, two, three, Total Duration: 12"));
			for (String s: g.getPaths()) {
				System.out.println(s);
//			assert(s.equals("one, two, three, Total Duration: 12"));
			}
		} catch (CycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */
	
/*	Tests a standalone activity error throw. 1 -> 2 -> 3, 4
	@Test
	void Cycle() {
		List<Activity> heads = new LinkedList<>();
		List<Activity> nodes = new LinkedList<>();
		
		Activity one = new Activity("one", Collections.emptyList(), 3 );
		Activity two = new Activity("two", Arrays.asList("one"), 2 ); 
		Activity three = new Activity("three", Arrays.asList("two"), 7 );
		Activity four = new Activity("four", Collections.emptyList(), 4 );
		
		heads.add(one);
		heads.add(four);
		nodes.add(three);
		nodes.add(one);
		nodes.add(two);
		nodes.add(four);
		
		Graph g = new Graph(heads, nodes);
		g.graphify();
		try {
//		 	assert(g.getPaths().contains(" one, two, three, Total Duration: 12"));
			for (String s: g.getPaths()) {
				System.out.println(s);
//			assert(s.equals("one, two, three, Total Duration: 12"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */ 

}
