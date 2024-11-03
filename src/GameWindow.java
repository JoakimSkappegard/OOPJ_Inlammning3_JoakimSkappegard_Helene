import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class GameWindow implements ActionListener {

    JFrame frame=new JFrame("Slide-pussel");
    JPanel panel_options=new JPanel();
    JPanel panel_buttons=new JPanel();
    JLabel label_textfield=new JLabel();
    JButton[] game_buttons=new JButton[16];
    JButton[] option_buttons=new JButton[4];
    Point[] originalPoint=new Point[game_buttons.length-1];
    private Icon[] bilder=new Icon[game_buttons.length-1];
    private int gameBoardSize=4;
    int windowBounds=800;

    GameWindow() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(windowBounds, windowBounds);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //fixar till bordern som syns högst upp, läggs på panel_options längre ner i koden
        label_textfield.setBackground(new Color(200, 200, 200));
        label_textfield.setForeground(new Color(25, 25, 25));
        label_textfield.setFont(new Font("Times New Roman", Font.BOLD, 50));
        label_textfield.setHorizontalAlignment(JLabel.LEFT);
        label_textfield.setText("Options: ");
        label_textfield.setOpaque(true);

        //fixar till option paneln med knapparna högst upp
        panel_options.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel_options.add(label_textfield);
        for (int i=0;i<option_buttons.length;i++) {
            option_buttons[i]=new JButton();
            panel_options.add(option_buttons[i]);
            option_buttons[i].addActionListener(this);
        }
        option_buttons[0].setText("Nytt spel");
        option_buttons[1].setText("Siffror");
        option_buttons[2].setText("Hamster");
        option_buttons[3].setText("Groda");


        panel_buttons.setLayout(new GridLayout(gameBoardSize, gameBoardSize));
        panel_buttons.setBackground(new Color(150, 150, 150));

        for (int i = 0; i < game_buttons.length; i++) {
            game_buttons[i] = new JButton();
            panel_buttons.add(game_buttons[i]);
            //bestämmer att alla knappar förutom den sista ska få en siffra
            if (i!=game_buttons.length-1) {
                game_buttons[i].setText(String.valueOf(i+1));
            }
            else{
                game_buttons[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
                game_buttons[i].setBackground(new Color(225, 225, 235));
            }
            game_buttons[i].setFocusable(false);
            game_buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 120));
            game_buttons[i].addActionListener(this);
        }

        frame.add(panel_options, BorderLayout.NORTH);
        frame.add(panel_buttons);
        panel_buttons.revalidate();
        panel_buttons.repaint();
        frame.revalidate();
        frame.repaint();
        Point[] originalPoint=new Point[game_buttons.length];
        for (int i = 0; i < originalPoint.length; i++) {
            originalPoint[i]=game_buttons[i].getLocation();
        }
        this.originalPoint=originalPoint;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Point blankLocation=game_buttons[15].getLocation();
        JButton button = (JButton) e.getSource();
        if(button.getText().equals("Hamster")) {
            changeImage("hamster");
        }
        if(button.getText().equals("Siffror")) {
            changeImage("siffror");

        }
        if(button.getText().equals("Groda")) {
            changeImage("groda");
        }

        //denna måste vara längst ner i options event, annars buggar blank knappen
        if(button.getText().equals("Nytt spel")) {
            genereraNyttSpel(gameBoardSize);
        }
        else{
            Point buttonLocation=button.getLocation();
            if(arbrevidtom(button)) {        //kan kanske påverkas av layoten? räknar den pixlar från fönstret eller från panel

                button.setLocation(blankLocation);
                game_buttons[game_buttons.length-1].setLocation(buttonLocation);
                Boolean winChecked=winChecker();
                if (winChecked){
                    JOptionPane.showMessageDialog(frame, "Vinnare!");
                }

            }
        }
    }

    public void changeImage(String whichImage){
        panel_buttons.revalidate();
        panel_buttons.repaint();

        //de enskilda ikonerna bör vara 180x158px
        String pathName="";
        if (whichImage.equals("hamster")) {
            pathName="src/bilder/hamster/";}
        if (whichImage.equals("groda")) {
            pathName="src/bilder/groda/";
        }
        if (!whichImage.equals("Siffror")) {
            for (int i = 0; i < bilder.length; i++) {
                String imagePath = pathName + (i + 1) + ".png";
                try {
                    Icon originalIcon = new ImageIcon(imagePath);
                    bilder[i] = originalIcon;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            for (int i = 0; i < game_buttons.length; i++) {
                if (i != game_buttons.length - 1 && bilder[i] != null) {
                    game_buttons[i].setIcon(bilder[i]);
                    game_buttons[i].setText("");
                }
            }
        }
        if (whichImage.equals("siffror")) {
            for (int i = 0; i < game_buttons.length; i++) {
                if (i!=game_buttons.length-1 && bilder[i] != null) {
                    game_buttons[i].setIcon(null);
                    game_buttons[i].setText(String.valueOf(i+1));
                }
            }
        }
    }


    public void genereraNyttSpel(int spelstorlek){
        Random slumpGen = new Random();

        ArrayList<JButton> knappar= new ArrayList();
        for (int i = 0; i < (spelstorlek*spelstorlek); i++) {

            knappar.add(game_buttons[i]);

        }
        for (int i = 0; i < spelstorlek; i++) {
            for (int j = 0; j < spelstorlek; j++) {

                if(!knappar.isEmpty()) {

                    int denUtvalda = slumpGen.nextInt(knappar.size());
                    knappar.get(denUtvalda).setLocation(getPixelKordinatsFromX(i), getPixelKordinatsFromY(j));
                    knappar.remove(denUtvalda);
                }
            }
        }
    }

    public int getPixelKordinatsFromX(int x){
        return game_buttons[15].getSize().width*x;
    }

    public boolean winChecker(){
        for(int i=0;i<game_buttons.length;i++){
            if(!game_buttons[i].getLocation().equals(this.originalPoint[i])){
                return false;
            }
        }
        return true;
    }

    public int getPixelKordinatsFromY(int y){
        return game_buttons[15].getSize().height*y;
    }

    public int geXKoordinatKnapp(JButton button){
        int xKordinat = (button.getX()/button.getSize().width);
        return xKordinat;
    }

    public int geYKoordinatKnapp(JButton button){
        int yKordinat = (button.getY()/button.getSize().height);
        return yKordinat;
    }

    public boolean arbrevidtom(JButton button){
        return ((geXKoordinatKnapp(button)==geXKoordinatKnapp(game_buttons[15]))&& (geYKoordinatKnapp(button)==(geYKoordinatKnapp(game_buttons[15])-1)||geYKoordinatKnapp(button)==(geYKoordinatKnapp(game_buttons[15])+1))) || (geYKoordinatKnapp(button)==(geYKoordinatKnapp(game_buttons[15])) && (geXKoordinatKnapp(button)==(geXKoordinatKnapp(game_buttons[15])-1)||geXKoordinatKnapp(button)==geXKoordinatKnapp(game_buttons[15])+1));
    }

    public static void main(String[] args) {
        GameWindow window=new GameWindow();
    }
}



