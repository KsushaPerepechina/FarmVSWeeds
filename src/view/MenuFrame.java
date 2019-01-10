package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuFrame extends JFrame {

    public MenuFrame() {
        setTitle("Menu");
        setSize(210,90);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        addIcons();
    }

    private void addIcons() {
        JButton helpButton = new JButton();
        addButton(helpButton, "images/help.png", 20,20,50,50);
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new HelpFrame();
            }
        });

        JButton pauseButton = new JButton();
        addButton(pauseButton,"images/pause.png",80,20,50,50);

        JButton exitButton = new JButton();
        addButton(exitButton, "images/exit.png", 140,20,50,50);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    public void addButton(JButton newButton, String location, int x, int y, int i, int j){
        newButton.setBounds(x,y,i,j);
        newButton.setIcon(new ImageIcon(location));
        newButton.setBorderPainted(false);
        newButton.setFocusPainted(false);
        newButton.setContentAreaFilled(false);
        add(newButton);
    }
}
