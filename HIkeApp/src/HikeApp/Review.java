package HikeApp;

import java.time.LocalDate;

public class Review {
	private float rating; 
	private String comment; 
	private User user; 
	private Trail trail; 
	private LocalDate date; 
	
	//Add user to constructor once class user is created
	public Review(float rating, String comment,User user, Trail trail, LocalDate date) {
		this.rating = rating; 
		this.comment = comment; 
		this.user = user; 
		this.trail = trail; 
		this.date = date; 
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user; 
	}
	public void setUser(User user) {
		this.user = user; 
	}
	public Trail getTrail() {
		return trail; 
	}
	public void setTrail(Trail trail) {
		this.trail = trail; 
	}
	public LocalDate getDate() {
		return date; 
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getReview() {
		return "Review by" + user.getName() + " on " + date + ": " + comment; 
	}
	public float getRatingValue() {
		return rating; 
	}
	@Override
	public String toString() {
		return "Review [rating=" + rating + ", comment=" + comment + ", user=" + user.getName() + ", trail=" + trail.getName() +", date=" + date + "]"; 
	}
	
}
