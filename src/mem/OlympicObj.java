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

    OlympicObj(JPanel panel, ImageIcon Olympics, ImageIcon Sport, boolean isClicked, Memory gameBoard){
        this.panel=panel;
        this.Olympics=Olympics;
        this.Sport=Sport;
        this.isClicked= isClicked;
        this.gameBoard=gameBoard;

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
        if(Obj.isClicked){
            if(Obj!=this){
                if(Obj.Sport==this.Sport){
                    System.out.println("We have a Winner!!!");//Winner and reset function calls
                }
                else {
                    System.out.println("We need to reset");//this.reset function
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
}
