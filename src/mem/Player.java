package mem;

import javax.swing.*;

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
            gameBoard.Player2L.setFont(gameBoard.Player2L.getFont().deriveFont(16f));
            gameBoard.Player1L.setFont(gameBoard.Player1L.getFont().deriveFont(20f));
        }
        else{
            this.turn=false;
            pObj.turn=true;
            gameBoard.Player2L.setFont(gameBoard.Player2L.getFont().deriveFont(20f));
            gameBoard.Player1L.setFont(gameBoard.Player1L.getFont().deriveFont(16f));
        }
        gameBoard.revalidate();
        gameBoard.repaint();
    }
    void addScore(){
        this.score+=1;
    }
    void winnerCheck(){
        if((gameBoard.p1.score+gameBoard.p2.score==((gameBoard.GridW*gameBoard.GridL)/2))){
        String winner;
        if(gameBoard.p1.score>gameBoard.p2.score) winner = "Player 1";
        else if (gameBoard.p1.score<gameBoard.p2.score) winner= "Player 2";
        else winner = "Both Players! Its a tie!";
        String input= "We have a WINNER! Congratulations "+ winner +"!" + " Would you like to play again?";
        if(JOptionPane.showConfirmDialog(gameBoard, input)==JOptionPane.OK_OPTION);

            gameBoard.dispose();
            new Memory();
        }
    }
}
