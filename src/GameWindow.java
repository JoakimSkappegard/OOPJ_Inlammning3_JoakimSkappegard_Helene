import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow implements ActionListener {

    JFrame frame=new JFrame("Slide-pussel");
    JPanel panel_options=new JPanel();
    JPanel panel_buttons=new JPanel();
    JLabel label_textfield=new JLabel();
    JButton[] game_buttons=new JButton[16];
    JButton[] option_buttons=new JButton[3];

    GameWindow() {
        int windowBounds=800;
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
        panel_options.setLayout(new FlowLayout(FlowLayout.LEFT));
        for (int i = 0; i < option_buttons.length; i++) {
            option_buttons[i]=new JButton();
            option_buttons[i].setSize(25,15);
        }
        option_buttons[0].setText("Option 1");
        option_buttons[1].setText("Option 2");
        option_buttons[2].setText("Option 3");

        panel_buttons.setLayout(new GridLayout(4, 4));
        panel_buttons.setBackground(new Color(150, 150, 150));


        for (int i = 0; i < game_buttons.length; i++) {
            game_buttons[i] = new JButton();
            panel_buttons.add(game_buttons[i]);
            //bestämmer att alla knappar förutom den sista ska få en siffra
            if (i!=game_buttons.length-1) {
                game_buttons[i].setText(String.valueOf(i+1));
            }
            game_buttons[i].setFocusable(false);
            game_buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 120));
            game_buttons[i].addActionListener(this);
        }

        //lägger på options texten och knapparna på panel_options
        panel_options.add(label_textfield);
        for (JButton optionButton : option_buttons) {
            panel_options.add(optionButton);
        }


        frame.add(panel_options, BorderLayout.NORTH);
        frame.add(panel_buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        GameWindow window=new GameWindow();
    }
}



