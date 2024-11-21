package HikeApp;

import java.time.LocalDate;

public class HIke {
	private Trail trail; 
	private double distance; 
	private LocalDate date; 
	
	 HIke(Trail trail, double distance, LocalDate date) {
		this.date = date; 
		this.trail = trail; 
		this.distance = distance; 
	}
	
	public Trail getTrail() {
		return trail; 
	}
	public void setTrail(Trail trail) {
		this.trail = trail; 
	}
	public void setDistance(double distance) {
		this.distance = distance; 
	}
	public LocalDate getDate() {
		return date; 
	}
	public void setDate(LocalDate date) {
		this.date = date; 
	}
	@Override
	public String toString() {
		return "Hike at " + trail.getName() + "on " + date + " (" + distance + " miles)"; 
	}
}
