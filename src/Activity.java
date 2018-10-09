import java.util.LinkedList;
import java.util.List;

// Activity class with node attributes and methods
public class Activity {
	private String name;
	private int duration;
	private List<String> dependencies;
	private List<Activity> nexts;
	private boolean visited;
	
	
	Activity(String name, List<String> dependencies, int duration) {
		this.name = name;
		this.duration = duration;
		this.dependencies = dependencies;
		nexts = new LinkedList<Activity>();
		visited = false;
	}

	public String getName() {
		return name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<String> getDependencies() {
		return dependencies;
	}
	
	public List<Activity> getNexts() {
		return nexts;
	}

	public void setNexts(List<Activity> nexts) {
		this.nexts = nexts;
	}

	public void setDependencies(List<String> dependencies) {
		this.dependencies = dependencies;
	}


	@Override
	public String toString() {
		return "Activity: " + name;
	}
	
}
	
	


