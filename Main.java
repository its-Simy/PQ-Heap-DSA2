import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This is the general class that will cause the main functionality
 */
public class Main {
    /**
     * This will sort the heap from highest to lowest
     */
    public static void heapsort(Player[] pa)
    {
        PQHeap heap = new PQHeap();


        for(int i = 0; i < pa.length; i++) {
            if(pa[i] == null) {
                break;
            }
            heap.add(pa[i]);
        }

        int sortedNextOpen = 0;
        while(!heap.isEmpty()) {
            Player highest = heap.getHighestScorePlayer();
            pa[sortedNextOpen] = highest;
            sortedNextOpen++;
        }



    }//end of heapsort method


    public static void main(String[] args) {
        PQHeap pq = new PQHeap();

        try {
            FileReader fileReader = new FileReader("info.txt");
            Scanner infile = new Scanner(fileReader);
            int counter = 0;
            String name;
            int score;


            while(infile.hasNextLine()) {
                name = infile.nextLine();
                counter++;
                if(counter % 2 != 0){
                    score = Integer.parseInt(infile.nextLine());
                    counter++;
                    Player p = new Player(name, score);
                   pq.add(p);


                }
            }
            infile.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        heapsort(pq.getData());

        for(int i = 0; i < pq.getSize(); i++) {
            System.out.println("Player: " + pq.getData()[i].getName() +
                    "\n" + " Score: " + pq.getData()[i].getScore());
        }



    }//end of main method
}//end of main class
