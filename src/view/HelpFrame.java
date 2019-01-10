package view;

import javax.swing.*;
import java.awt.*;

public class HelpFrame extends JFrame{
    public HelpFrame() {
        setTitle("Help");
        setSize(325,325);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,2,5,5));
        getContentPane().setBackground(new Color(230,255,230));
        addIcons();
    }

    public void addIcons(){
        JButton designations = new JButton();
        addButton(designations, "images/designations.png");

        JButton cactus = new JButton();
        addButton(cactus, "images/cactus.png");

        JButton harvestIsReady = new JButton();
        addButton(harvestIsReady, "images/harvest_is_ready.png");

        JButton harvestIsReadyLabel = new JButton();
        addButton(harvestIsReadyLabel, "images/harvest_is_ready_label.png");

        JButton gardenBedIsEmpty = new JButton();
        addButton(gardenBedIsEmpty, "images/garden_bed_is_empty.png");

        JButton gardenBedIsEmptyLabel = new JButton();
        addButton(gardenBedIsEmptyLabel, "images/garden_bed_is_empty_label.png");

        JButton lackOFMoisture = new JButton();
        addButton(lackOFMoisture, "images/lack_of_moisture.png");

        JButton lackOFMoistureLabel = new JButton();
        addButton(lackOFMoistureLabel, "images/lack_of_moisture_label.png");

        JButton beetleAttack = new JButton();
        addButton(beetleAttack, "images/beetle_attack.png");

        JButton beetleAttackLabel = new JButton();
        addButton(beetleAttackLabel, "images/beetle_attack_label.png");

        JButton weedAttack = new JButton();
        addButton(weedAttack, "images/weed_attack.png");

        JButton weedAttackLabel = new JButton();
        addButton(weedAttackLabel, "images/weed_attack_label.png");
    }

    public void addButton(JButton newButton, String location){
        newButton.setSize(50,60);
        newButton.setIcon(new ImageIcon(location));
        newButton.setBorderPainted(false);
        newButton.setFocusPainted(false);
        newButton.setContentAreaFilled(false);
        add(newButton);
    }
}
