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

    OlympicObj(JPanel panel, ImageIcon Olympics, ImageIcon Sport){
        this.panel=panel;
        this.Olympics=Olympics;
        this.Sport=Sport;


        panel.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ImageIcon temp = ((ImageIcon)((JLabel)panel.getComponent(0)).getIcon());

        if( temp.getImage()==Olympics.getImage()){
            ((JLabel)panel.getComponent(0)).setIcon(Sport);
        }
    }
    void gotAMatch(OlympicObj Obj){
        Icon temp = ((JLabel) Obj.panel.getComponent(0)).getIcon();
        if(temp == Sport){
            boolean match;
            if(Obj.Sport==this.Sport){
                match= true;
            }
            else match = false;
            if(match){
                System.out.println("We have a Winner!!!");
            }
            else{
                System.out.println("We need to reset");
            }
        }
    }
    boolean isClicked (){
        ImageIcon temp = ((ImageIcon)((JLabel)panel.getComponent(0)).getIcon());
        if(temp.getImage()==Sport.getImage()){
            return true;
        }
        else return false;
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
