package HikeApp;

public class Hike {
    private Trail trail;
    private String date;

    // Constructor to create a hike with a trail
    public Hike(Trail trail) {
        this.trail = trail;
        this.date = "2024-12-01"; // For simplicity, using a static date. You can update this to the current date.
    }

    public Trail getTrail() {
        return trail;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Hike on " + trail.getName() + " at " + date;
    }
}

