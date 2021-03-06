package mem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Jennifer Balling on 3/10/14.
 */
public class Memory extends JFrame implements ActionListener{
    private JButton YesB, NoB, OKB;
    public JPanel WinsP, ContainerP, TitleP, ImageP, QuestionP, ButtonP, BonusP,GridP, ScoreP, panelHolder[][] ;
    public JLabel p1WinsL, p2WinsL, p1WinsTF, p2WinsTF, Title, Player1L, Player2L, ORImageL, QuestionTF, Player1TF, Player2TF, SkateL, Skate2L, Snow2L, FS2L, L2L, Hock2L, SJ2L,  SnowL, FSL, LL, HockL, SJL, SkelL, BSL, BiaL, XCL, Skel2L, BS2L, Bia2L, XC2L ;
    private ImageIcon OlympicRings, CardBack, Skater, Skater2, SnowB, SnowB2, FreestyleSki, FreestyleSki2, Luge, Luge2, Hockey, Hockey2, SkiJump, SkiJump2, Skeleton, Skeleton2, BobSled, BobSled2, Biathlon, Biathlon2,  Xcountry, Xcountry2;
    private int LENGTH = 700, WIDTH = 700;
    public int GridL, GridW, num;
    private JTextField input;
    private ImageIcon PicArr[]= new ImageIcon[20];
    ArrayList<Integer> list= new ArrayList<Integer>();
    int max;
    ImageIcon GameArr[];
    public int counter, arrCounter;
    public OlympicObj oArr[];
    public Player p1,p2;
    public ImageIcon done;
//WATCH COUNT

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
        p1= new Player("P1", 0, 0, true, this);
        p2= new Player("P2", 0, 0, false, this);


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
        ContainerP.setBackground(Color.white);
        TitleP.setBackground(Color.white);
        Title.setForeground(Color.darkGray);
        Title.setFont(Title.getFont().deriveFont(40f));
        TitleP.setPreferredSize(new Dimension(700, 80));
        Title.setLayout(new FlowLayout(FlowLayout.CENTER));
        TitleP.add(Title);
        //TitleP.add(WinsP);

        //GRID PANEL
        GridP= new JPanel();
        GridP.setLayout(new FlowLayout(FlowLayout.LEFT));
        GridP.setBackground(Color.black);
        GridP.setPreferredSize(new Dimension((GridL*95),(GridW*95)));
        PlaceCards();

        //WINS PANEL
        WinsP= new JPanel();
        WinsP.setBackground(Color.darkGray);
        WinsP.setPreferredSize(new Dimension(600, 40));
        WinsP.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1WinsL= new JLabel("Wins Player 1: ");
        p1WinsL.setForeground(Color.white);
        p1WinsL.setFont(p1WinsL.getFont().deriveFont(16f));
        p1WinsTF= new JLabel("0");
        JLabel SpaceTF= new JLabel("             ");
        p1WinsTF.setFont(p1WinsTF.getFont().deriveFont(16f));
        p1WinsTF.setForeground(Color.white);
        p2WinsL= new JLabel("Wins Player 2: ");
        p2WinsL.setForeground(Color.white);
        p2WinsL.setFont(p2WinsL.getFont().deriveFont(16f));
        p2WinsTF= new JLabel("0");
        p2WinsTF.setFont(p2WinsTF.getFont().deriveFont(16f));
        p2WinsTF.setForeground(Color.white);
        WinsP.add(p1WinsL);
        WinsP.add(p1WinsTF);
        WinsP.add(SpaceTF);
        WinsP.add(p2WinsL);
        WinsP.add(p2WinsTF);

        //SCORE PANEL
        ScoreP= new JPanel();
        Player1L= new JLabel("Player 1:");
        Player1L.setForeground(Color.blue);
        Player1L.setFont(Player1L.getFont().deriveFont(20f));
        Player1TF= new JLabel("0");
        Player1TF.setFont(Player1TF.getFont().deriveFont(16f));
        Player2L= new JLabel("Player 2:");
        Player2L.setForeground(Color.RED);
        Player2L.setFont(Player2L.getFont().deriveFont(16f));
        Player2TF = new JLabel("0");
        Player2TF.setFont(Player2TF.getFont().deriveFont(16f));
        ScoreP.setLayout(new FlowLayout(FlowLayout.CENTER));
        ScoreP.setBackground(Color.WHITE);
        ScoreP.setPreferredSize(new Dimension(600, 50));
        ScoreP.add(Player1L);
        ScoreP.add(Player1TF);
        ScoreP.add(Player2L);
        ScoreP.add(Player2TF);

        ContainerP.add(TitleP);
        ContainerP.add(WinsP);
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
        temp.pack();
        temp.setLocationRelativeTo(null);

    }
    int clickCount=0;
    public void checkBoard(OlympicObj obj){
        if(obj.isClicked){
            clickCount++;
            if (clickCount > 1) {
                for (int g = 0; g < arrCounter; g++) {
                    obj.gotAMatch(oArr[g]);
                }
                clickCount = 0;
            }
        }
    }
    public void PlaceCards(){
        int NumCards= GridL*GridW;
        int i=GridL;
        int j=GridW;
        oArr= new OlympicObj[NumCards];

        panelHolder = new JPanel[i][j];
        setLayout(new FlowLayout(FlowLayout.LEFT));
        GridP.setPreferredSize(new Dimension(GridL * 95, GridW * 95));
        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();

            }
        }
        for(int k=0; k<i; k++){
            for(int l=0; l<j; l++){
                CardBack= new ImageIcon(this.getClass().getResource("Card.png"));
                ORImageL = new JLabel ("", CardBack, JLabel.CENTER);
                panelHolder[k][l].add(ORImageL);
                GridP.add(panelHolder[k][l], new FlowLayout(FlowLayout.CENTER));
            }
        }
        Randomizer();
            arrCounter=0;
            for(i=0; i<GridL; i++){
                for(j=0; j<GridW; j++){
                    boolean isClicked=false;
                    boolean check=true;
                    oArr[arrCounter]=new OlympicObj(panelHolder[i][j], CardBack, GameArr[list.get(arrCounter)], isClicked, this, check);
                    arrCounter++;
                }
            }
        update(this.getGraphics());
        revalidate();
        repaint();
    }

    void Randomizer (){

        int count=0;

        Skater= new ImageIcon(this.getClass().getResource("Skater.png"));
        SkateL= new JLabel("", Skater, JLabel.CENTER);
        PicArr[count]=Skater;
        count++;

        Skater2= new ImageIcon(this.getClass().getResource("Skater.png"));
        Skate2L= new JLabel("", Skater2, JLabel.CENTER);
        PicArr[count]=Skater2;
        count++;

        SnowB= new ImageIcon(this.getClass().getResource("SnowB.png"));
        SnowL= new JLabel("", SnowB, JLabel.CENTER);
        PicArr[count]=SnowB;
        count++;

        SnowB2= new ImageIcon(this.getClass().getResource("SnowB.png"));
        Snow2L= new JLabel("", SnowB2, JLabel.CENTER);
        PicArr[count]=SnowB2;
        count++;

        FreestyleSki= new ImageIcon(this.getClass().getResource("upsideSki.png"));
        FSL= new JLabel("", FreestyleSki, JLabel.CENTER);
        PicArr[count]=FreestyleSki;
        count++;

        FreestyleSki2= new ImageIcon(this.getClass().getResource("upsideSki.png"));
        FS2L= new JLabel("", FreestyleSki2, JLabel.CENTER);
        PicArr[count]=FreestyleSki2;
        count++;

        Luge= new ImageIcon(this.getClass().getResource("Luge.png"));
        LL= new JLabel("", Luge, JLabel.CENTER);
        PicArr[count]=Luge;
        count++;

        Luge2= new ImageIcon(this.getClass().getResource("Luge.png"));
        L2L= new JLabel("", Luge2, JLabel.CENTER);
        PicArr[count]=Luge2;
        count++;

        Hockey= new ImageIcon(this.getClass().getResource("Hockey.png"));
        HockL= new JLabel("", Hockey, JLabel.CENTER);
        PicArr[count]=Hockey;
        count++;

        Hockey2= new ImageIcon(this.getClass().getResource("Hockey.png"));
        Hock2L= new JLabel("", Hockey2, JLabel.CENTER);
        PicArr[count]=Hockey2;
        count++;

        SkiJump= new ImageIcon(this.getClass().getResource("DownHill.png"));
        SJL= new JLabel("", SkiJump, JLabel.CENTER);
        PicArr[count]=SkiJump;
        count++;

        SkiJump2= new ImageIcon(this.getClass().getResource("DownHill.png"));
        SJ2L= new JLabel("", SkiJump2, JLabel.CENTER);
        PicArr[count]=SkiJump2;
        count++;

        BobSled= new ImageIcon(this.getClass().getResource("BobSled.png"));
        BSL= new JLabel("", BobSled, JLabel.CENTER);
        PicArr[count]=BobSled;
        count++;

        BobSled2= new ImageIcon(this.getClass().getResource("BobSled.png"));
        BS2L= new JLabel("", BobSled2, JLabel.CENTER);
        PicArr[count]=BobSled2;
        count++;

        Biathlon= new ImageIcon(this.getClass().getResource("Biathlon.png"));
        BiaL= new JLabel("", Biathlon, JLabel.CENTER);
        PicArr[count]=Biathlon;
        count++;

        Biathlon2= new ImageIcon(this.getClass().getResource("Biathlon.png"));
        Bia2L= new JLabel("", Biathlon2, JLabel.CENTER);
        PicArr[count]=Biathlon2;
        count++;

        Skeleton= new ImageIcon(this.getClass().getResource("Skeleton.png"));
        SkelL= new JLabel("", Skeleton, JLabel.CENTER);
        PicArr[count]=Skeleton;
        count++;

        Skeleton2= new ImageIcon(this.getClass().getResource("Skeleton.png"));
        Skel2L= new JLabel("", Skeleton2, JLabel.CENTER);
        PicArr[count]=Skeleton2;
        count++;

        Xcountry= new ImageIcon(this.getClass().getResource("XCountry.png"));
        XCL= new JLabel("", Xcountry, JLabel.CENTER);
        PicArr[count]=Xcountry;
        count++;

        Xcountry2= new ImageIcon(this.getClass().getResource("XCountry.png"));
        XC2L= new JLabel("", Xcountry2, JLabel.CENTER);
        PicArr[count]=Xcountry2;

        max=GridL*GridW;
        GameArr= new ImageIcon[max];
        int u=0;
        for(u=0; u<max; u++){
            GameArr[u]=PicArr[u];
        }
        //RANDOMIZE
        for(int y=0; y<max; y++){
            list.add(y);
        }
        Collections.shuffle(list);
        counter = 0;
    }
}


