package mem;

import javax.swing.*;
import java.awt.*;
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
        if(Obj.check){
        if(Obj.isClicked){
            if(Obj!=this){
                if(Obj.Sport.getImage()==this.Sport.getImage()){
                    this.MatchFunc();
                    ImageIcon done= new ImageIcon(this.getClass().getResource("done.png"));
                    ((JLabel)this.panel.getComponent(0)).setIcon(done);
                    ((JLabel)Obj.panel.getComponent(0)).setIcon(done);
                    this.check=false;
                    Obj.check=false;
                }
                else {
                    if(JOptionPane.showConfirmDialog(this.gameBoard, "Not a match. Next Player's turn...")==JOptionPane.OK_OPTION){
                        this.Reset();
                        Obj.Reset();
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
    }
}
