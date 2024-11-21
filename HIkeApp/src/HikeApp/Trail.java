package HikeApp;

public class Trail {
	private String name; 
	private String location; 
	private String difficulty; 
	
	Trail(String name, String location, String difficulty){
		this.difficulty = difficulty; 
		this.location = location; 
		this.name = name; 
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location; 
	}
	public String getDifficuly() {
		return difficulty; 
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty; 
	}
	@Override
	public String toString() {
		return name + " - " + location + " (" + difficulty + ")"; 
	}
}
