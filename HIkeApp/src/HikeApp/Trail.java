package HikeApp;

/**
 * Represents a hiking trail with a name, location, difficulty level, and a unique ID.
 */
public class Trail {
    private static int idCounter = 0; // Static counter to generate unique IDs
    private int id;                  // Unique identifier for the trail
    private String name;             // Name of the trail
    private String location;         // Location of the trail
    private String difficulty;   // Difficulty level of the trail
    private double distance; 
    private String weather; 

    /**
     * Constructs a Trail object with specified attributes.
     * Automatically assigns a unique ID.
     *
     * @param name       the name of the trail
     * @param location   the location of the trail
     * @param difficulty the difficulty level of the trail
     */
 // Constructor for only the name
    public Trail(String name) {
        this.id = idCounter++;
        this.name = name;
        this.location = "Unknown"; // Default value
        this.difficulty = "Unknown"; // Default value
        this.distance = 0.0; // Default value
        this.weather = "Unknown"; // Default value
    }


    public int getId() {
        return id;
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return name + " - " + location + " (" + difficulty + ")";
    }

	public double getDistance() {
		return distance;
	}

	public String getWeather() {
		return weather; 
	}
	public String getFullDescription() {
	    return "Trail: " + name + "\nLocation: " + location + "\nDifficulty: " + difficulty +
	            "\nDistance: " + distance + " miles\nWeather: " + weather;
	}

}
