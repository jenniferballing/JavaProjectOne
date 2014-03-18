package mem;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.ImageGraphicAttribute;

/**
 * Created by JenniferBalling on 3/12/14.
 */
public class OlympicObj implements MouseListener {

    JPanel panel;
    ImageIcon Olympics;
    ImageIcon Sport;
    boolean isClicked;
    Memory gameBoard;
    boolean check;


    OlympicObj(JPanel panel, ImageIcon Olympics, ImageIcon Sport, boolean isClicked, Memory gameBoard, boolean check){
        this.panel=panel;
        this.Olympics=Olympics;
        this.Sport=Sport;
        this.isClicked= isClicked;
        this.gameBoard=gameBoard;
        this.check=check;

        panel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ImageIcon temp = ((ImageIcon)((JLabel)panel.getComponent(0)).getIcon());

        if(temp.getImage()==Olympics.getImage()){
            ((JLabel)panel.getComponent(0)).setIcon(Sport);
            this.isClicked=true;
        }

        this.gameBoard.checkBoard(this);
    }


    void gotAMatch(OlympicObj Obj){
       if(Obj.check){//has been checked
            if(Obj.isClicked){//has been clicked
                if(Obj!=this){//not itself
                    if(Obj.Sport.getImage()==this.Sport.getImage()){//same image
                        this.MatchFunc();
                        if(gameBoard.p1.turn){
                            String scoreStr= Integer.toString(gameBoard.p1.score);
                            gameBoard.Player1TF.setText(scoreStr);
                        }
                        else {
                            String scoreStr= Integer.toString(gameBoard.p2.score);
                            gameBoard.Player2TF.setText(scoreStr);

                        }
                        gameBoard.done= new ImageIcon(this.getClass().getResource("done.png"));
                        ((JLabel)this.panel.getComponent(0)).setIcon(gameBoard.done);
                        ((JLabel)Obj.panel.getComponent(0)).setIcon(gameBoard.done);
                        this.check=false;
                        Obj.check=false;
                    }
                    else {
                        if(JOptionPane.showConfirmDialog(this.gameBoard, "Not a match. Other player's turn...")==JOptionPane.OK_OPTION){
                            this.Reset();
                            Obj.Reset();
                            gameBoard.p1.switchTurns(gameBoard.p2);
                        }
                        else {
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    void Reset(){
        this.isClicked=false;
        ((JLabel)this.panel.getComponent(0)).setIcon(Olympics);
    }
    void MatchFunc(){
        JOptionPane.showMessageDialog(this.gameBoard, "You got a match! It's your turn again.");
        if(gameBoard.p1.turn){
            gameBoard.p1.addScore();
        }
        else{
            gameBoard.p2.addScore();
        }
        gameBoard.p1.winnerCheck();
    }
}
