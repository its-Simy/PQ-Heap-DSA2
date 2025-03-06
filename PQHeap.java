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
     * copy Constructor, that creates a deep copy of heap
     */
    public PQHeap(PQHeap pq){
        this.size = pq.size;
        this.data = new Player[2000];
        for(int i = 0; i<pq.size; i++){
            if(pq.data[i] != null){
                this.data[i] = new Player(pq.data[i].createClone());
            }
        }

    }//end of PQheap copy constructor

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
     *Will return the index of the left leaf node
     */
    public int getLeftChildIndex(int index){return (2*index) + 1; }

    /**
     *Will return the index of the right leaf node
     */
    public int getRightChildIndex(int index){return (2*index) + 2; }

    /**
     * This will swap the elements in the array
     */
    private void swap(int index1, int index2){
        Player temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }//end swap method

    /**
     *Will return the player with the highest score in the heap and call for heapify down to properly restructure the heap
     */
    @Override
    public Player getHighestScorePlayer() {
        Player highestScore = data[0]; //root player should be the highest scored player
        data[0] = data[size - 1];//overrides sets the last player to the root node
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
        int parentIndex = getParentIndex(index);

        while(data[index].getScore() > data[parentIndex].getScore()){

            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }//end of while loop
    }//end of heapify up method

    /**
     * Will first take the root node index set it to adjust and compare it with the right child node
     * if the right child node has a greater score than the root node, it will set the adjust int to the right childs index
     * it will then compare the scores between the left and adjust value, lastly it will perform the swap
     * if the value of adjust becomes the same as the index, it means there are no more comparisons to be made
     */
    public void heapify_DOWN(int index){
        while(true) {

            int adjust = index;
            int left = getLeftChildIndex(index);//left leaf
            int right = getRightChildIndex(index);//right leaf

                if (right < size && (data[right].getScore() > data[adjust].getScore()))
                    adjust = right;

                if (left < size && (data[left].getScore() > data[adjust].getScore()))
                    adjust = left;

                if (adjust == index)
                    break;

            swap(index, adjust);
            index = adjust;

        }//end of the while loop
    }//end of the heapify down method


    /**
     * This should print the current heap player names and scores
     */
    public void printHeap(){
        for(int i = 0; i < size; i++){
            if(data[i] != null){
                System.out.println("Player: " + data[i].getName() + " Score: " + data[i].getScore() );
            }
        }
    }

    /**
     *Creates a clone of the current instance of the heap
     */
    public PQHeap createClone(){
        PQHeap pq = new PQHeap();
        for(int i = 0; i < size; i++){
            pq.add(data[i].createClone());
        }
        return pq;
    }

}//end of the pq heap class
