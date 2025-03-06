/**
 * This should force the PQHeap class to have these methods in its class
 */
public interface PriorityQueue {

    /**
     *it will be a method that adds a player
     */
    void add(Player a);

    /**
     *It will be a method that returns the highest player in the heap
     */
    public Player getHighestScorePlayer();

    /**
     * This method should clear the heap
     */
    void clear();

    /**
     *This will return the size of the heap
     */
    int getSize();

    /**
     * This will return true if the heap no longer has elements in it
     */
    boolean isEmpty();


}
