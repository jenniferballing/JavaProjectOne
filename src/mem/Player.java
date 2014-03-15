package mem;

/**
 * Created by JenniferBalling on 3/15/14.
 */
public class Player {
    String name;
    int score;
    int wins;
    boolean turn;

    Player(String name, int score, int wins, boolean turn){
        this.name=name;
        this.score= score;
        this.wins=wins;
        this.turn= turn;
    }
    void switchTurns(Player pObj){
        if(this.turn){
            this.turn=false;
            pObj.turn=true;
        }
        else{
            this.turn=true;
            pObj.turn=false;
        }
    }
    void addScore(){
        this.score+=1;
    }
}
