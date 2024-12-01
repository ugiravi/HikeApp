package HikeApp;

import java.time.LocalDate;

/**
 * Represents a review for a trail, including a rating, comment, associated user, and trail.
 * Each review has a unique ID assigned when it is created.
 * 
 * @author Tayden Behunin
 */
public class Review {
    private int id;              // Unique ID for the review
    private float rating;        // Rating given by the user
    private String comment;      // Comment provided by the user
    private User user;           // The user who submitted the review
    private Trail trail;         // The trail being reviewed
    private LocalDate date;      // The date the review was created

    /**
     * Constructs a Review object with specified details.
     * 
     * @param id      the unique ID for the review
     * @param rating  the rating given by the user
     * @param comment the comment provided by the user
     * @param user    the user who submitted the review
     * @param trail   the trail being reviewed
     * @param date    the date the review was created
     */
    public Review(int id, float rating, String comment, User user, Trail trail, LocalDate date) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.user = user;
        this.trail = trail;
        this.date = date;
    }

    /**
     * Gets the unique ID of the review.
     * 
     * @return the unique ID of the review
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique ID of the review.
     * 
     * @param id the new unique ID for the review
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the rating of the review.
     * 
     * @return the rating given by the user
     */
    public float getRating() {
        return rating;
    }

    /**
     * Sets the rating of the review.
     * 
     * @param rating the new rating for the review
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Gets the comment of the review.
     * 
     * @return the comment provided by the user
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment of the review.
     * 
     * @param comment the new comment for the review
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the user who submitted the review.
     * 
     * @return the user who submitted the review
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user who submitted the review.
     * 
     * @param user the new user for the review
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the trail being reviewed.
     * 
     * @return the trail being reviewed
     */
    public Trail getTrail() {
        return trail;
    }

    /**
     * Sets the trail being reviewed.
     * 
     * @param trail the new trail for the review
     */
    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    /**
     * Gets the date the review was created.
     * 
     * @return the creation date of the review
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets the date the review was created.
     * 
     * @param date the new creation date for the review
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns a string representation of the review.
     * 
     * @return a string containing the review's details
     */
    @Override
    public String toString() {
        return "Review [id=" + id + ", rating=" + rating + ", comment=" + comment + ", user=" + user.getName() 
               + ", trail=" + trail.getName() + ", date=" + date + "]";
    }
}