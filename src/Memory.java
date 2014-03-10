import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jennifer Balling on 3/10/14.
 */
public class Memory extends JFrame implements ActionListener{
    private JButton YesB, NoB;
    private JPanel ContainerP, TitleP, ImageP, QuestionP, ButtonP, GridP, ScoreP;
    private JLabel Title, Player1L, Player2L, ORImageL;
    private JTextField QuestionTF, Player1TF, Player2TF;
    private ImageIcon OlympicRings, CardBack, Card, Skater3, SnowB, FreestyleSki, Luge, Hockey, SkiJump3, SpeedSkate3, BobSled, Biathlon, Xcontry3;
    private int LENGTH = 500, WIDTH = 500;

    public Memory(){
        OpeningScreenLayout();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(LENGTH, WIDTH);
        setVisible(true);
    }


    void YesButtonListener (ActionEvent e){
        OpeningScreenLayout();
        //Go to GameLayoutScreen
    }
    void NoButtonListener (ActionEvent e){
        int NoOption = JOptionPane.showConfirmDialog(null,"Do you want to play?","Are you sure?",JOptionPane.YES_NO_OPTION);
        if (NoOption == JOptionPane.YES_OPTION) {
            YesButtonListener(e);
        }
        else{
            NoButtonListener(e);
        }
    }
    void OpeningScreenLayout (){
        Title= new JLabel("Olympic Memory Game");
        OlympicRings= new ImageIcon(this.getClass().getResource("OlympicRings.png"));

        //TITLE PANEL
        TitleP= new JPanel();
        TitleP.setLayout(new FlowLayout(FlowLayout.CENTER));
        TitleP.setPreferredSize(new Dimension(500, 100));
        TitleP.setBackground(Color.lightGray);
        Title.setText("Olympic Memory Game");
        Title.setForeground(Color.BLUE);
        Title.setFont(Title.getFont().deriveFont(20f));
        TitleP.add(Title);

        //IMAGE PANEL
        ImageP= new JPanel();
        ImageP.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageP.setPreferredSize(new Dimension(400, 200));
        ImageP.setBackground(Color.white);
        OlympicRings = new ImageIcon(this.getClass().getResource("OlympicRings.png"));
        ORImageL = new JLabel ("", OlympicRings, JLabel.CENTER);
        ImageP.add(ORImageL);

        //QUESTION PANEL
        QuestionP = new JPanel();
        QuestionTF = new JTextField("Would you like to play the Olympic Memory Game?");
        QuestionP.setBackground(Color.white);
        QuestionP.setPreferredSize(new Dimension(500, 100));

        //BUTTON PANEL
        ButtonP = new JPanel();
        YesB= new JButton("YES");
        YesB.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                YesButtonListener(e);
            }
        });
        NoB= new JButton("NO");
        NoB.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NoButtonListener(e);
            }
        });
        ButtonP.add(YesB);
        ButtonP.add(NoB);

        //BACKGROUND PANEL
        ContainerP= new JPanel();
        ContainerP.setBackground(Color.white);
        ContainerP.setPreferredSize(new Dimension(500, 500));
        ContainerP.add(TitleP);
        ContainerP.add(ImageP);
        ContainerP.add(QuestionP);
        ContainerP.add(ButtonP);
        add(ContainerP, BorderLayout.NORTH);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main (String []  args){
        Memory temp= new Memory();
        //temp.setContentPane(new Memory());
        //temp.pack();
        //temp.setLocationRelativeTo(null);

    }
}
