import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This is the general class that will invoke the main functionality of the heapsort and main methods
 */
public class Main {

    /**
     * This will sort the heap from highest to lowest
     */
    public static void heapsort(Player[] pa)
    {
        PQHeap heap = new PQHeap();

        //This will copy every Player from the original array, into the heap
        for(int i = 0; i < pa.length; i++) {
            if(pa[i] != null)
                heap.add(pa[i]);
            else
                break;
        }

        int sortedNextOpen = 0;
        while(!heap.isEmpty()) {
            Player highest = heap.getHighestScorePlayer();
            pa[sortedNextOpen] = highest;
            sortedNextOpen++;
        }



    }//end of heapsort method

    /**
     * This will demonstrate all the file reading, printing of the array before and after heapsort, proof of copy constructor working
     * along with proof of the cloned player method working properly creating deep copies
     */
    public static void main(String[] args) {

        Player[] pa = new Player[2000];

        try {
            FileReader fileReader = new FileReader("info.txt");
            Scanner infile = new Scanner(fileReader);
            int counter = 0;
            int track = 0;
            String name;
            int score;


            while(infile.hasNextLine()) {
                name = infile.nextLine();
                counter++;
                if(counter % 2 != 0){
                    score = Integer.parseInt(infile.nextLine());
                    counter++;
                    Player p = new Player(name, score);
                        pa[track] = p;
                        track++;

                }
            }
            infile.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Unsorted Players: \n");
        for(int i = 0; i < pa.length; i++) {
            if(pa[i] != null)
                System.out.println("Player: " + pa[i].getName() + "\nScore: " + pa[i].getScore());
            else{
                System.out.println("\n");
                break;
            }
        }//end of print for loop


        heapsort(pa);


        System.out.println("Sorted Players: \n");

        for(int i = 0; i < pa.length; i++) {
            if(pa[i] != null)
            System.out.println("Player: " + pa[i].getName() + "\nScore: " + pa[i].getScore());
            else
                break;
        }



        //Demonstration of PQHeap Copy Constructor
        PQHeap originalHeap = new PQHeap();
        originalHeap.add(new Player("Alice", 50));
        originalHeap.add(new Player("Bob", 80));
        originalHeap.add(new Player("Charlie", 30));

        System.out.println("\nOriginal PQHeap before modification:");
        originalHeap.printHeap();

        // Create a deep copy using the copy constructor
        PQHeap copiedHeap = new PQHeap(originalHeap);

        System.out.println("\nCopied Heap:");
        copiedHeap.printHeap();

        // Modify the original heap and check if the copy remains unchanged
        originalHeap.add(new Player("David", 90)); // Add a new player

        System.out.println("\nOriginal PQHeap after modification:");
        originalHeap.printHeap();

        System.out.println("\nCopied Heap after original was modified:");
        copiedHeap.printHeap();

        //Demonstration of Copy player
        Player orignialPlayer = new Player("Messi", 10);
        Player copiedPlayer = orignialPlayer.createClone();

        System.out.println("\nOriginal Player before modification: " + orignialPlayer.getName() + " Score: " + orignialPlayer.getScore());
        System.out.println("\nCopied Player before modification: " + copiedPlayer.getName() + " Score: " + copiedPlayer.getScore());

        orignialPlayer.setName("Ronaldo");
        orignialPlayer.setScore(7);

        System.out.println("\nOriginal Player after modification: " + orignialPlayer.getName() + " Score: " + orignialPlayer.getScore());
        System.out.println("\nCopied Player after modification: " + copiedPlayer.getName() + " Score: " + copiedPlayer.getScore());











    }//end of main method
}//end of main class
