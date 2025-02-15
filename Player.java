public class Player{
    /**
     *All the data members needed
     */

    private int score;
    private String name;

    /**
     *Constructor that creates a Player object when no parameters are inputted
     */
    public Player(){
        name = "Simon";
        score = 10;
    }


    /**
     *Constructor that creates a Player object when both parameters are inputted
     */
    public Player(String _name, int _score){
        this.name = _name;
        this.score = _score;
    }

    /**
     *Creates a deep copy of the Player object
     */
    public Player(Player other){
        this.name = other.name;
        this.score = other.score;
    }

    /**
     *Returns the score of the player
     */
    public int getScore() {
        return score;
    }
    /**
     *Sets the score of the player
     */
    public void setScore(int _score) {
        score = _score;
    }
    /**
     *Returns the name of the player
     */
    public String getName() {
        return name;
    }
    /**
     *Sets the name of the player
     */
    public void setName(String _name) {
        this.name = _name;
    }


    /**
     *Creates a deep copy clone of the current instance
     * */
    public Player createClone(){
        Player clone = new Player(this);
        return clone;
    }

    /**
     *This returns if the names are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        Player p = (Player) obj;
        return(this.name.equals(p.getName()));
    }

}