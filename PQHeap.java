public class PQHeap implements PriorityQueue{
    private int[] heap;
    private int size;

    /**
     * Default Constructor
     */
    public PQHeap(){
        heap = new int[100];
        size = 0;
    }

    /**
     * Adds a player to the end of the Queue
     */
    @Override
    public void add(Player a) {

    }

    /**
     *Will return the player with the highest score in the queue
     */
    @Override
    public Player getHighestScorePlayer() {
        return null;
    }

    /**
     * Will remove all the players within the queue
     */
    @Override
    public void clear() {
        
    }

    /**
     *Will return the size (not index) of the queue
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Will return true if the queue is empty, false if it is not
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
}
