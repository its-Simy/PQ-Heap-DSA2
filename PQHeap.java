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
     * This will find the index of the Parent, will adjust size for index implementation
     */
    public int getParentIndex(int index){
        return (size-1) / 2;
    }

    /**
     * This will swap the elements in the array
     */
    private void swap(int index1, int index2){
        Player temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }//end swap method

    /**
     *Will return the player with the highest score in the Array
     */
    @Override
    public Player getHighestScorePlayer() {
        Player highestScore = data[0];
        
        int index = size-1;
        //first identify the parent index, then gets the data for it
        int parent_index = getParentIndex(size);

        while((index > 0) && (data[index].getScore() < data[parent_index].getScore())){
            swap(index, parent_index);
            index = getParentIndex(index);
            parent_index = getParentIndex(index);
        }//end while loop


        remove_Player(index);

        return highestScore;
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

    /**
     * This removes an element from the array by making it null
     */
    public void remove_Player(int index){
        data[index] = null;
    }
}
