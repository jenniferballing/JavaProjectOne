import javafx.scene.layout.GridPaneBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Jennifer Balling on 3/10/14.
 */
public class Memory extends JFrame implements ActionListener{
    private JButton YesB, NoB, OKB;
    private JPanel ContainerP, TitleP, ImageP, QuestionP, ButtonP, BonusP,GridP, ScoreP, panelHolder[][] ;
    private JLabel Title, Player1L, Player2L, ORImageL, QuestionTF, Player1TF, Player2TF, SkateL, SnowL, FSL, LL, HockL, SJL, SkelL, BSL, BiaL, XCL ;
    private ImageIcon OlympicRings, CardBack, Card, Skater, SnowB, FreestyleSki, Luge, Hockey, SkiJump, Skeleton, BobSled, Biathlon, Xcountry;
    private int LENGTH = 700, WIDTH = 700;
    private int GridL, GridW, num, P1ScoreCount, P2ScoreCount;
    private JTextField input;
    private JLabel PicArr[]= new JLabel[20];


    public Memory(){

        OpeningScreenLayout();

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
        //update(this.getGraphics());
        GameLayoutScreen();

    }

    //YES BUTTON HANDLER
    void YesButtonListener (ActionEvent e){

        ButtonP.removeAll();
        ButtonP.revalidate();
        ButtonP.repaint();
        ButtonP.add(OKB);
        QuestionTF.setText("Would you like a 12, 16, or 20 card game?");
        input= new JTextField();
        input.setPreferredSize(new Dimension(25,25));
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
        ButtonP.setPreferredSize(new Dimension(500, 50));
        ButtonP.setBackground(Color.white);
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
        ContainerP.setPreferredSize(new Dimension(600, 600));
        ContainerP.add(TitleP);
        ContainerP.add(ImageP);
        ContainerP.add(QuestionP);
        ContainerP.add(ButtonP);
        ContainerP.add(BonusP);
        add(ContainerP, BorderLayout.NORTH);

    }

    void GameLayoutScreen(){

        ContainerP.removeAll();
        ContainerP.setSize(new Dimension(700, 700));
        ContainerP.setBackground(Color.WHITE);
        TitleP.setBackground(Color.BLACK);
        Title.setForeground(Color.ORANGE);
        Title.setFont(Title.getFont().deriveFont(35f));
        //GRID PANEL
        GridP= new JPanel();
        //GridP.setLayout(new GridLayout(GridL, GridW));
        GridP.setBackground(Color.black);
        GridP.setPreferredSize(new Dimension((GridL*80),(GridW*80)));
        PlaceCards();

        //SCORE PANEL
        ScoreP= new JPanel();
        Player1L= new JLabel("Player 1:");
        Player1L.setForeground(Color.BLUE);
        Player1L.setFont(Player1L.getFont().deriveFont(16f));
        Player1TF= new JLabel("0");
        Player1TF.setFont(Player1TF.getFont().deriveFont(16f));
        Player2L= new JLabel("Player 2:");
        Player2L.setForeground(Color.RED);
        Player2L.setFont(Player2L.getFont().deriveFont(16f));
        Player2TF = new JLabel("0");
        Player2TF.setFont(Player2TF.getFont().deriveFont(16f));
        ScoreP.setLayout(new FlowLayout(FlowLayout.CENTER));
        ScoreP.setBackground(Color.WHITE);
        ScoreP.setPreferredSize(new Dimension(500, 50));
        ScoreP.add(Player1L);
        ScoreP.add(Player1TF);
        ScoreP.add(Player2L);
        ScoreP.add(Player2TF);

        ContainerP.add(TitleP);
        ContainerP.add(GridP);
        ContainerP.add(ScoreP);
        add(ContainerP, BorderLayout.CENTER);

        ContainerP.update(this.getGraphics());
        ContainerP.revalidate();
        ContainerP.repaint();

    }
    @Override
    public void actionPerformed (ActionEvent e){

    }
    public static void main (String []  args){
        Memory temp= new Memory();
        //temp.setContentPane(new Memory());
        temp.pack();
        temp.setLocationRelativeTo(null);

    }
    public void PlaceCards(){
        int NumCards= GridL*GridW;
        int i=GridL;
        int j=GridW; 
        panelHolder = new JPanel[i][j];
        setLayout(new FlowLayout(FlowLayout.CENTER));
        GridP.setPreferredSize(new Dimension(GridL * 89, GridW * 87));
        //setPreferredSize(new Dimension(100,100));

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
            }
        }
        for(int k=0; k<i; k++){
            for(int l=0; l<j; l++){
                CardBack= new ImageIcon(this.getClass().getResource("Card.png"));
                ORImageL = new JLabel ("", CardBack, JLabel.CENTER);
                panelHolder[k][l].add(ORImageL);//ew ImageIcon(this.getClass().getResource("OlympicRings.png")););
                GridP.add(panelHolder[k][l], new FlowLayout(FlowLayout.CENTER));
            }
        }
        Randomizer();
        update(this.getGraphics());
        revalidate();
        repaint();
    }
    void Randomizer (){

        int count=0;

        while(count < (GridW*GridL)-1){

            Skater= new ImageIcon(this.getClass().getResource("Skater.png"));
            SkateL= new JLabel("", Skater, JLabel.CENTER);
            PicArr[count]=SkateL; count++;
            PicArr[count]=SkateL; count++;

            SnowB= new ImageIcon(this.getClass().getResource("SnowB.png"));
            SnowL= new JLabel("", SnowB, JLabel.CENTER);
            PicArr[count]=SnowL; count++;
            PicArr[count]=SnowL; count++;

            FreestyleSki= new ImageIcon(this.getClass().getResource("upsideSki.png"));
            FSL= new JLabel("", FreestyleSki, JLabel.CENTER);
            PicArr[count]=FSL; count++;
            PicArr[count]=FSL; count++;

            Luge= new ImageIcon(this.getClass().getResource("Luge.png"));
            LL= new JLabel("", Luge, JLabel.CENTER);
            PicArr[count]=LL; count++;
            PicArr[count]=LL; count++;

            Hockey= new ImageIcon(this.getClass().getResource("Hockey.png"));
            HockL= new JLabel("", Hockey, JLabel.CENTER);
            PicArr[count]=HockL; count++;
            PicArr[count]=HockL; count++;

            SkiJump= new ImageIcon(this.getClass().getResource("DownHill.png"));
            SJL= new JLabel("", SkiJump, JLabel.CENTER);
            PicArr[count]=SJL; count++;
            PicArr[count]=SJL; count++;

            BobSled= new ImageIcon(this.getClass().getResource("BobSled.png"));
            BSL= new JLabel("", BobSled, JLabel.CENTER);
            PicArr[count]=BSL; count++;
            PicArr[count]=BSL; count++;

            Biathlon= new ImageIcon(this.getClass().getResource("Biathlon.png"));
            BiaL= new JLabel("", Biathlon, JLabel.CENTER);
            PicArr[count]=BiaL; count++;
            PicArr[count]=BiaL; count++;

            Skeleton= new ImageIcon(this.getClass().getResource("Skeleton.png"));
            SkelL= new JLabel("", Skeleton, JLabel.CENTER);
            PicArr[count]=SkelL; count++;
            PicArr[count]=SkelL; count++;

            Xcountry= new ImageIcon(this.getClass().getResource("XCountry.png"));
            XCL= new JLabel("", Xcountry, JLabel.CENTER);
            PicArr[count]=XCL; count++;
            PicArr[count]=XCL; count++;
        }
        //RANDOMIZE

        int check =0;
        int max= GridL*GridW;
        while(check<max){
            for(int m = 0; m < GridL; m++) {
                for(int n = 0; n < GridW; n++) {

                    double rand= Math.random()*(max);
                    int rand1= (int)rand;
                    panelHolder[m][n].removeAll();
                    panelHolder[m][n].add(PicArr[rand1]);
                    GridP.add(panelHolder[m][n], new FlowLayout(FlowLayout.CENTER));
                    check++;
                }
            }
        }
        update(this.getGraphics());
        revalidate();
        repaint();
    }
}
