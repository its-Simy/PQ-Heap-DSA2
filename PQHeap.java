public class PQHeap implements PriorityQueue{
    private Player[] data;
    private int size;

    /**
     * Default Constructor
     */
    public PQHeap(){
        data = new Player[100];
        size = 0;
    }

    /**
     * Adds a player to the end of the Array
     */
    @Override
    public void add(Player a) {
        data[size] = a;
        size++;
    }

    /**
     *Will return the player with the highest score in the Array
     */
    @Override
    public Player getHighestScorePlayer() {
        return null;
    }

    /**
     * Will remove all the players within the Array
     */
    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            data[i] = null;
        }
    }

    /**
     *Will return the size (not index) of the Array
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Will return true if the Array is empty, false if it is not
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
}
