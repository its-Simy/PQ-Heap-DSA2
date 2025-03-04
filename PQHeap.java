/**
 * This is the PQheap class that will have methods to be able to function like a normal heap
 * and allow for other things like heap sort
 */
public class PQHeap implements PriorityQueue{
    private Player[] data;
    private int size;

    /**
     * Default Constructor
     */
    public PQHeap(){
        data = new Player[2000];
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

    public int getLeftChildIndex(int index){return (2*index) + 1; }

    public int getRightChildIndex(int index){return (2*index) + 2; }

    /**
     *This will return the array containing the players
     */
    public Player[] getData() { return data; }

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
     * It will also set the right most player as the new root node, and downsize the array
     */
    @Override
    public Player getHighestScorePlayer() {

        Player highestScore = data[0]; //root player should be the highest scored player
        data[0] = data[size-1];//overrides sets the last player to the root node
        data[size-1] = null;
        size--;
        heapify_DOWN(0);
        return highestScore;

    }// end of getHighestScorePlayer method

    /**
     * Will remove all the players within the Array
     */
    @Override
    public void clear() {
        for(int i = 0; i < size; i++){
            if(data[i] == null){
                break;
            }
            data[i] = null;
        }
    }//end of clear method

    /**
     *Will return the size/index of the array Data, not the length
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Will return true if the Array is empty, false if it is not
     */
    @Override
    public boolean isEmpty() { return (size == 0); }

    /**
     *This will compare the parent node, then if it is greater than the parent node, it will continue to swap until
     * it is in the appropriate location
     */
    public void heapify_UP(int index){
        //next will identify the parent index, then gets the data for it
        int parent_index = getParentIndex(index);

        //First will check if this is the first node being implemented into the heap
        if(index == 0)
            return;

        while(data[index].getScore() > data[parent_index].getScore()){
            swap(index, parent_index);
            index = getParentIndex(index);
            parent_index = getParentIndex(index);

        }//end while loop
    }//end of heapify up method

    /**
     * This will be swapping the root node down, and keep swapping if the children nodes have greater scores
     */
    public void heapify_DOWN(int index){
        while(true) {
            //These are the variables that are going to be used to check for leaf nodes and the "Parent" node we want to heapify down
            int adjust = index;
            int left = getLeftChildIndex(index);
            int right = getRightChildIndex(index);

            if((data[left] != null && data[right] != null) && (data[left].getScore() > data[right].getScore()))
                adjust = left;

            else if ((data[left] != null && data[right] != null) && (data[right].getScore() > data[left].getScore()))
                adjust = right;

            else if ((data[right] == null && data[left] != null) && (data[left].getScore() > data[adjust].getScore()))
                adjust = left;

            //if they equal or if left and right are null, it should just break the loop
            if ((adjust == index) || (data[right] == null && data[left] == null))
                break;

            //if one of the leaf nodes are greater than one another, then it should perform the swap
            swap(index, adjust);
            index = adjust;

        }//end of the while loop
    }//end of the heapify down method



}//end of the pq heap class
