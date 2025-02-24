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
     * Adds a player to the end of the Array, then will attempt to heapify up if it is applicable
     */
    @Override
    public void add(Player a) {
        data[size] = a;
        heapify_UP(size);
        size++;
    }

    /**
     * This will find the index of the Parent, will adjust size for index implementation
     */
    public int getParentIndex(int index){ return (index-1) / 2; }

    /**
     * This will swap the elements in the array
     */
    private void swap(int index1, int index2){
        Player temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }//end swap method

    /**
     *Will return the player with the highest score in the Array, which should be the first
     */
    @Override
    public Player getHighestScorePlayer() {

        Player highestScore = data[0]; //root player should be the highest scored player
        heapify_DOWN(size);
        size--;
        return highestScore;

    }// eng of getHighestScorePlayer method

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
    public void remove_Player(Player r){
        for(int i = 0; i < size-1; i++){
            if(data[i].equals(r)){
                //should be a for loop that calls for the swap
                data[i] = data[i+1];
            }
        }
    }

    public void heapify_UP(int index){
        //First will check if this is the first node being implemented into the heap
        if(index == 0){
            return;
        }
        //next will identify the parent index, then gets the data for it
        int parent_index = getParentIndex(index);

        while(data[index].getScore() > data[parent_index].getScore()){
            swap(index, parent_index);
            index = getParentIndex(index);
            parent_index = getParentIndex(index);
        }//end while loop
    }//end of heapify up method

    public void heapify_DOWN(int index){
        Player highest = data[0];
        int rightMostElement = index;

        data[0] = data[rightMostElement];//sets the root node to the latest addition to the array

        while(data[0].getScore() < data[rightMostElement].getScore()){
            swap(0, rightMostElement);
            //highestScore = data[rightMostElement];
        }

    }

    public Player[] getData() {
        return data;
    }
}
