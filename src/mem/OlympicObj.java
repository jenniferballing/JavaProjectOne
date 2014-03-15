package mem;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

    Player p1, p2;




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

        if( temp.getImage()==Olympics.getImage()){
            ((JLabel)panel.getComponent(0)).setIcon(Sport);
            this.isClicked=true;
        }
        this.gameBoard.checkBoard(this);
    }
    void gotAMatch(OlympicObj Obj){
        p1= new Player("P1", 0, 0, true);
        p2= new Player("P2", 0, 0, false);

        if(Obj.check){//has been checked
            if(Obj.isClicked){//has been clicked
                if(Obj!=this){//not itself
                    if(Obj.Sport.getImage()==this.Sport.getImage()){//same image
                        this.MatchFunc();
                        ImageIcon done= new ImageIcon(this.getClass().getResource("done.png"));
                        ((JLabel)this.panel.getComponent(0)).setIcon(done);
                        ((JLabel)Obj.panel.getComponent(0)).setIcon(done);
                        this.check=false;
                        Obj.check=false;
                    }
                    else {
                        if(JOptionPane.showConfirmDialog(this.gameBoard, "Not a match. Other player's turn...")==JOptionPane.OK_OPTION){
                            this.Reset();
                            Obj.Reset();
                            p1.switchTurns(p2);
                            if(p1.turn){
                                String scoreStr= Integer.toString(p1.score);
                                gameBoard.Player1TF.setText(scoreStr);
                                gameBoard.Player2L.setFont(gameBoard.Player2L.getFont().deriveFont(16f));
                                gameBoard.Player1L.setFont(gameBoard.Player1L.getFont().deriveFont(20f));
                            }
                            else{
                                String scoreStr= Integer.toString(p2.score);
                                gameBoard.Player2TF.setText(scoreStr);
                                gameBoard.Player2L.setFont(gameBoard.Player2L.getFont().deriveFont(20f));
                                gameBoard.Player1L.setFont(gameBoard.Player1L.getFont().deriveFont(16f));
                            }

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
        if(p1.turn){
            p1.addScore();
        }
        else{
            p2.addScore();
        }
    }
}
