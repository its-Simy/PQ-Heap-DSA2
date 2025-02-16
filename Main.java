import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
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
                    //pq.add(p);
                }
            }
            infile.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //public static void heapsort(Player[] pqh)
    }
}
