package mem;

import java.awt.*;

/**
 * Created by JenniferBalling on 3/15/14.
 */
public class Player {
    String name;
    int score;
    int wins;
    boolean turn;
    Memory gameBoard;

    Player(String name, int score, int wins, boolean turn, Memory gameBoard){
        this.name=name;
        this.score= score;
        this.wins=wins;
        this.gameBoard= gameBoard;
        this.turn=turn;
    }
    void switchTurns(Player pObj){
        if(pObj.turn){
            this.turn=true;
            pObj.turn=false;
            System.out.println("This's turn");
            gameBoard.Player2L.setFont(gameBoard.Player2L.getFont().deriveFont(20f));
            gameBoard.Player1L.setFont(gameBoard.Player1L.getFont().deriveFont(16f));
        }
        else{
            this.turn=false;
            pObj.turn=true;
            System.out.println("pObj's turn");
            gameBoard.Player2L.setFont(gameBoard.Player2L.getFont().deriveFont(16f));
            gameBoard.Player1L.setFont(gameBoard.Player1L.getFont().deriveFont(20f));
        }
        //gameBoard.update(this.getGraphics());
        gameBoard.revalidate();
        gameBoard.repaint();
    }
    void addScore(){
        this.score+=1;
    }
}
