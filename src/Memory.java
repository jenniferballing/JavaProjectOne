import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jennifer Balling on 3/10/14.
 */
public class Memory extends JFrame implements ActionListener{
    private JButton YesB, NoB, OKB;
    private JPanel ContainerP, GContainerP, TitleP, ImageP, QuestionP, ButtonP, BonusP,GridP, ScoreP;
    private JLabel Title, Player1L, Player2L, ORImageL, QuestionTF, Player1TF, Player2TF ;
    private ImageIcon OlympicRings, CardBack, Card, Skater3, SnowB, FreestyleSki, Luge, Hockey, SkiJump3, SpeedSkate3, BobSled, Biathlon, Xcontry3;
    private int LENGTH = 500, WIDTH = 500;
    private int GridL, GridW, num, P1ScoreCount, P2ScoreCount;
    private JTextField input;
    private String answer;

    public Memory(){
        GridL=1;
        GridW=1;
        OpeningScreenLayout();
        //GameLayoutScreen();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(LENGTH, WIDTH);
        setVisible(true);
    }
    //OK BUTTON LISTENER
    void OKButtonListener (ActionEvent e){

        num= Integer.parseInt(input.getText());
        if(num==12){
            GridL=3;
            GridW=4;
        }
        else if (num==16){
            GridL=4;
            GridW=4;
        }
        else if( num==20){
            GridL=5;
            GridW=4;
        }
        else{
            System.out.println("Wrong number");
        }
        System.out.println("Length: "+GridL+" Width: "+GridW);

        GameLayoutScreen();
    }

    //YES BUTTON HANDLER
    void YesButtonListener (ActionEvent e){


        ButtonP.removeAll();
        ButtonP.add(OKB);
        QuestionTF.setText("Would you like a 12, 16, or 20 card game?");
        input= new JTextField();
        input.setPreferredSize(new Dimension(50,50));
        QuestionP.add(input);
        input.setEditable(true);

        System.out.println("Inside YesB");

    }
    //NO BUTTON HANDLER
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
        TitleP.setPreferredSize(new Dimension(500, 75));
        TitleP.setBackground(Color.lightGray);
        Title.setText("Olympic Memory Game");
        Title.setForeground(Color.BLACK);
        Title.setFont(Title.getFont().deriveFont(30f));
        TitleP.add(Title);

        //IMAGE PANEL
        ImageP= new JPanel();
        ImageP.setLayout(new FlowLayout(FlowLayout.CENTER));
        ImageP.setPreferredSize(new Dimension(500, 150));
        ImageP.setBackground(Color.white);
        OlympicRings = new ImageIcon(this.getClass().getResource("OlympicRings.png"));
        ORImageL = new JLabel ("", OlympicRings, JLabel.CENTER);
        ImageP.add(ORImageL);

        //QUESTION PANEL
        QuestionP = new JPanel();
        QuestionTF = new JLabel("Would you like to play the Olympic Memory Game?");
        QuestionTF.setFont(QuestionTF.getFont().deriveFont(15f));
        QuestionP.setBackground(Color.white);
        QuestionP.setPreferredSize(new Dimension(500, 100));
        QuestionP.add(QuestionTF);

        //BUTTON PANEL
        OKB= new JButton("OK");
        OKB.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OKButtonListener(e);
            }
        });
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

        //BONUS PANEL
        BonusP = new JPanel();
        BonusP.setPreferredSize(new Dimension(500, 75));
        BonusP.setBackground(Color.lightGray);

        //BACKGROUND PANEL
        ContainerP= new JPanel();
        ContainerP.setBackground(Color.white);
        ContainerP.setPreferredSize(new Dimension(500, 500));
        ContainerP.add(TitleP);
        ContainerP.add(ImageP);
        ContainerP.add(QuestionP);
        ContainerP.add(ButtonP);
        ContainerP.add(BonusP);
        add(ContainerP, BorderLayout.NORTH);

    }

    void GameLayoutScreen(){
        /////////

        Title= new JLabel("Olympic Memory Game");

        //TITLE PANEL
        TitleP= new JPanel();
        TitleP.setLayout(new FlowLayout(FlowLayout.CENTER));
        TitleP.setPreferredSize(new Dimension(500, 75));
        TitleP.setBackground(Color.lightGray);
        Title.setText("Olympic Memory Game");
        Title.setForeground(Color.BLACK);
        Title.setFont(Title.getFont().deriveFont(30f));
        TitleP.add(Title);

        //BONUS PANEL
        BonusP = new JPanel();
        BonusP.setPreferredSize(new Dimension(500, 75));
        BonusP.setBackground(Color.lightGray);

        //GRID PANEL
        GridP= new JPanel();
        JLabel GridLabel= new JLabel("Hello");
        GridLabel.setForeground(Color.CYAN);
        GridP.add(GridLabel);
        GridP.setLayout(new GridLayout(GridL, GridW));
        GridP.setBackground(Color.black);
        GridP.setPreferredSize(new Dimension(100,100));

        //SCORE PANEL
        ScoreP= new JPanel();
        Player1L= new JLabel("Player 1: ");
        Player1TF= new JLabel("0");
        Player2L= new JLabel("Player 2: ");
        Player2TF = new JLabel("0");
        ScoreP.setLayout(new FlowLayout(FlowLayout.RIGHT));
        ScoreP.setBackground(Color.yellow);
        ScoreP.setPreferredSize(new Dimension(50, 50));
        ScoreP.add(Player1L);
        ScoreP.add(Player1TF);
        ScoreP.add(Player2L);
        ScoreP.add(Player2TF);

        //BACKGROUND PANEL
        //ContainerP= new JPanel();
        //ContainerP.setBackground(Color.white);
        //ContainerP.setPreferredSize(new Dimension(500, 500));
        ContainerP.remove(ImageP);
        ContainerP.remove(QuestionP);
        ContainerP.remove(ButtonP);
        //ContainerP.add(TitleP);
        ContainerP.add(GridP);
        ContainerP.add(ScoreP);
        //ContainerP.add(BonusP);
        add(ContainerP, BorderLayout.NORTH);

        ContainerP.update(this.getGraphics());
    }
    @Override
    public void actionPerformed (ActionEvent e){

    }
    public static void main (String []  args){
        Memory temp= new Memory();
        //temp.setContentPane(new Memory());
        //temp.pack();
        //temp.setLocationRelativeTo(null);

    }
}
