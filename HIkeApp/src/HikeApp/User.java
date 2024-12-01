package HikeApp;

import java.util.ArrayList;
import java.util.List;
import edu.princeton.cs.algs4.ST;

/**
 * Represents a user with their information and submitted reviews.
 * The user has a name, email, and a collection of reviews stored in a symbol table (ST).
 * Reviews are identified by unique integer IDs.
 * 
 * @author Tayden Behunin
 */
public class User {
    private String name;
    private String email;
    private ST<Integer, Review> reviews; // Symbol table for storing reviews by ID
    private int reviewIdCounter; // Counter for generating unique review IDs

    /**
     * Constructs a User object with the specified name and email.
     * Initializes an empty symbol table of reviews.
     * 
     * @param name  the name of the user
     * @param email the email address of the user
     */
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.reviews = new ST<>();
        this.reviewIdCounter = 0;
    }

    /**
     * Gets the name of the user.
     * 
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name the new name of the user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the email address of the user.
     * 
     * @return the email address of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the user.
     * 
     * @param email the new email address of the user
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the collection of reviews submitted by the user.
     * 
     * @return an iterable collection of all reviews
     */
    public Iterable<Review> getReviews() {
        List<Review> reviewList = new ArrayList<>();
        for (int reviewId : reviews.keys()) {
            reviewList.add(reviews.get(reviewId));
        }
        return reviewList;
    }


    /**
     * Adds a new review to the user's collection of reviews.
     * Assigns a unique ID to the review.
     * 
     * @param review the review to be added
     * @return the unique ID of the added review
     */
    public int addReview(Review review) {
        int reviewId = reviewIdCounter++;
        reviews.put(reviewId, review);
        return reviewId;
    }

    /**
     * Removes a review from the user's collection of reviews by its ID.
     * 
     * @param reviewId the ID of the review to be removed
     * @return the removed review, or null if no review exists with the given ID
     */
    public Review removeReview(int reviewId) {
        if (!reviews.contains(reviewId)) {
            return null; // Review with the given ID does not exist
        }

        // Retrieve the review to be removed
        Review removedReview = reviews.get(reviewId);

        // Create a new symbol table to hold remaining entries
        ST<Integer, Review> newReviews = new ST<>();
        for (int id : reviews.keys()) {
            if (id != reviewId) {
                newReviews.put(id, reviews.get(id));
            }
        }

        // Replace the old reviews table with the new one
        reviews = newReviews;

        return removedReview;
    }


    /**
     * Gets a specific review by its ID.
     * 
     * @param reviewId the ID of the review to retrieve
     * @return the review with the given ID, or null if no such review exists
     */
    public Review getReviewById(int reviewId) {
        return reviews.get(reviewId);
    }

    /**
     * Gets the total number of reviews submitted by the user.
     * 
     * @return the number of reviews in the collection
     */
    public int getReviewCount() {
        return reviews.size();
    }

    /**
     * Returns a string representation of the user, including their name and email.
     * 
     * @return a string representation of the user
     */
    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + "]";
    }
}
