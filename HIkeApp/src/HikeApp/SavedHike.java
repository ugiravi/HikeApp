package HikeApp;

import edu.princeton.cs.algs4.Queue;

/**
 * Manages a queue of saved hikes for the user, using Princeton's Queue class.
 */
public class SavedHike {
    private Queue<Hike> savedHikes;

    /**
     * Constructs a SavedHike object with an empty queue of hikes.
     */
    public SavedHike() {
        this.savedHikes = new Queue<>();
    }

    /**
     * Adds a hike to the saved queue.
     *
     * @param hike the hike to be saved
     */
    public void saveHike(Hike hike) {
        if (hike != null) {
            savedHikes.enqueue(hike);
            System.out.println("Hike added to saved hikes: " + hike);
        } else {
            System.out.println("Cannot save a null hike.");
        }
    }

    /**
     * Retrieves and removes the next hike from the saved queue.
     *
     * @return the next hike in the queue, or null if the queue is empty
     */
    public Hike getNextHike() {
        if (savedHikes.isEmpty()) {
            System.out.println("No saved hikes available.");
            return null;
        }
        Hike nextHike = savedHikes.dequeue();
        System.out.println("Next saved hike retrieved: " + nextHike);
        return nextHike;
    }

    /**
     * Displays all hikes in the saved queue.
     */
    public void displaySavedHikes() {
        if (savedHikes.isEmpty()) {
            System.out.println("No saved hikes to display.");
        } else {
            System.out.println("Saved Hikes:");
            for (Hike hike : savedHikes) {
                System.out.println(hike);
            }
        }
    }

    /**
     * Checks if the saved queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return savedHikes.isEmpty();
    }

    /**
     * Clears all hikes from the saved queue.
     */
    public void clearSavedHikes() {
        while (!savedHikes.isEmpty()) {
            savedHikes.dequeue();
        }
        System.out.println("All saved hikes have been cleared.");
    }

    /**
     * Gets the count of saved hikes in the queue.
     *
     * @return the number of hikes in the queue
     */
    public int getSavedHikeCount() {
        return savedHikes.size();
    }
}