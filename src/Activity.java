import java.util.List;

// Activity class with node attributes and methods
public class Activity {
	private String name;
	private int duration;
	private List<Activity> dependencies;
	
	Activity(String name, int duration, List<Activity> dependencies) {
		this.name = name;
		this.duration = duration;
		this.dependencies = dependencies; 
	}

	public String getName() {
		return name;
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

	public List<Activity> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Activity> dependencies) {
		this.dependencies = dependencies;
	}
	
}
	
	


