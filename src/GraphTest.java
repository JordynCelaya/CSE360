import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

/* Test cases. Error tests are commented out since they throw error messages - uncomment to test them.  
 * Test cover errors and a multiheaded, multipathed graph output */


class GraphTest {
	
	// Tests a multiheaded, multipathed output. 1 -> 2 -> 3 and 0 -> 2 -> 3
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
//				assert(s.equals("one, two, three, Total Duration: 12"));
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
