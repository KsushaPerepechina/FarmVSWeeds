package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import controller.*;

public class MainFrame extends JFrame {
    private Controller controller;

    private JButton coinsAmountLabel;
    private JButton quantityStrawSeeds;
    private JButton quantityCabbageSeeds;
    private JButton quantityStrawHarvest;
    private JButton quantityCabbageHarvest;
    private JButton costStrawSeeds;
    private JButton costStrawHarvest;
    private JButton costCabbageSeeds;
    private JButton costCabbageHarvest;

    private JButton hoeButton;
    private JButton bucketButton;
    private JButton poisonButton;
    private JButton hoeIcon;
    private JButton bucketIcon;
    private JButton bucketIsFullLabel;
    private JButton poisonIcon;

    private JButton emptinessSign1;
    private JButton emptinessSign2;
    private JButton emptinessSign3;
    private JButton readinessSign1;
    private JButton readinessSign2;
    private JButton readinessSign3;
    private JButton lackOfMoistureSign1;
    private JButton lackOfMoistureSign2;
    private JButton lackOfMoistureSign3;
    private JButton beetleAttackSign1;
    private JButton beetleAttackSign2;
    private JButton beetleAttackSign3;
    private JButton weedAttackSign1;
    private JButton weedAttackSign2;
    private JButton weedAttackSign3;

    public MainFrame(Controller controller) {
        this.controller = controller;

        setTitle("Farm VS Weeds");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        setSize((int) dimension.getWidth() - insets.left - insets.right, (int) dimension.getHeight()
                - insets.top - insets.bottom);
        setLocation(insets.right, insets.top);
        setLayout(null);
        dispose();
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(225, 209, 184));

        addMainFrameButtons();
        addInventoryPanelButtons();
        addSeedsPanelButtons();
        addHarvestPanelButtons();

        Timer labelRefreshingTimer = new Timer();
        labelRefreshingTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                executeLabelRefreshing();
            }
        }, 3000,1000);
    }

    private void addMainFrameButtons() {
        JButton menuLabel = new JButton();
        addButton(menuLabel, "images/menu_icon.png", 8, 5, 90, 20);

        JButton menuButton = new JButton();
        addButton(menuButton, "images/menu.png", 5, 25, 90, 90);
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MenuFrame();
            }
        });

        JButton bankLabel = new JButton();
        addButton(bankLabel, "images/bank.png", 1190, 5, 90, 20);

        JButton moneyLabel = new JButton();
        addButton(moneyLabel, "images/money.png", 1180, 20, 120, 100);

        coinsAmountLabel = new JButton();
        addButton(coinsAmountLabel, "", 1185, 115, 100, 30);

        JButton gardenBedButton1 = new JButton();
        addButton(gardenBedButton1, "images/garden_bed.png", 300, 300, 100, 100);

        gardenBedButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                solveMouseClick(1);
            }
        });

        emptinessSign1 = new JButton();
        addButton(emptinessSign1, "images/garden_bed_is_empty.png",300,250,50,50);

        readinessSign1 = new JButton();
        addButton(readinessSign1, "images/harvest_is_ready.png", 300,250,50,50);

        lackOfMoistureSign1 = new JButton();
        addButton(lackOfMoistureSign1, "images/lack_of_moisture.png", 350,250,50,50);

        beetleAttackSign1 = new JButton();
        addButton(beetleAttackSign1, "images/beetle_attack.png", 300, 400,50,50);

        weedAttackSign1 = new JButton();
        addButton(weedAttackSign1, "images/weed_attack.png", 350, 400,50,50);

        JButton gardenBedButton2 = new JButton();
        addButton(gardenBedButton2, "images/garden_bed.png", 420, 300, 100, 100);

        gardenBedButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gardenBedButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        solveMouseClick(2);
                    }
                });
            }
        });

        emptinessSign2 = new JButton();
        addButton(emptinessSign2, "images/garden_bed_is_empty.png",420,250,50,50);

        readinessSign2 = new JButton();
        addButton(readinessSign2, "harvest_is_ready", 420,250,50,50);

        lackOfMoistureSign2 = new JButton();
        addButton(lackOfMoistureSign2, "images/lack_of_moisture.png", 470,250,50,50);

        beetleAttackSign2 = new JButton();
        addButton(beetleAttackSign2, "images/beetle_attack.png", 420, 400,50,50);

        weedAttackSign2 = new JButton();
        addButton(weedAttackSign2, "images/weed_attack.png", 470, 400,50,50);

        JButton gardenBedButton3 = new JButton();
        addButton(gardenBedButton3, "images/garden_bed.png", 540, 300, 100, 100);

        gardenBedButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gardenBedButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        solveMouseClick(3);
                    }
                });
            }
        });

        emptinessSign3 = new JButton();
        addButton(emptinessSign3, "images/garden_bed_is_empty.png",540,250,50,50);

        readinessSign3 = new JButton();
        addButton(readinessSign3, "harvest_is_ready", 540,250,50,50);

        lackOfMoistureSign3 = new JButton();
        addButton(lackOfMoistureSign3, "images/lack_of_moisture.png", 590,250,50,50);

        beetleAttackSign3 = new JButton();
        addButton(beetleAttackSign3, "images/beetle_attack.png", 540, 400,50,50);

        weedAttackSign3 = new JButton();
        addButton(weedAttackSign3, "images/weed_attack.png", 590, 400,50,50);

        JButton waterStationButton = new JButton();

        addButton(waterStationButton, "images/lake.png",1100,325,150,150);
        waterStationButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent actionEvent){
            if (controller.getBucketExploitation()) {
                controller.setWaterStationExploitation(true);
            }
        }
    });
}

    private void addInventoryPanelButtons() {
        JButton inventoryLabel = new JButton();
        addButton(inventoryLabel, "images/inventory.png", 243, 525, 200, 100);

        hoeButton = new JButton();
        addButton(hoeButton, "images/hoe.png", 180, 600, 100, 100);
        hoeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setHoeExploitation(true);
            }
        });

        hoeIcon = new JButton();
        addButton(hoeIcon, "images/small_hoe.png", 250, 300,50,50);
        hoeIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setHoeExploitation(false);
            }
        });
        hoeIcon.setVisible(false);

        bucketButton = new JButton();
        addButton(bucketButton, "images/bucket.png", 290, 600, 100, 100);
        bucketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setBucketExploitation(true);
            }
        });

        bucketIcon = new JButton();
        addButton(bucketIcon, "images/small_bucket.png", 1050, 400, 50, 50);
        bucketIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setBucketExploitation(false);
            }
        });

        bucketIsFullLabel = new JButton();
        addButton(bucketIsFullLabel, "images/harvest_is_ready.png", 1050, 350, 50, 50);

        poisonButton = new JButton();
        addButton(poisonButton, "images/poison.png", 400, 600, 100, 100);
        poisonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setPoisonExploitation(true);
            }
        });

        poisonIcon = new JButton();
        addButton(poisonIcon, "images/small_poison.png", 250, 350,50,50);
        poisonIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                controller.setPoisonExploitation(false);
            }
        });
    }

    public void addSeedsPanelButtons() {
        seedsLabel = new JButton();
        addButton(seedsLabel, "images/seeds.png", 555, 525, 200, 50);

        JButton strawSeedsButton = new JButton();
        addButton(strawSeedsButton, "images/seeds_packs.png", 550, 600, 100, 100);
        strawSeedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!controller.getCabbageSeedsExploitation()) {
                    if(controller.getStrawSeedsExploitation()){
                        controller.setStrawSeedsExploitation(false);
                        controller.increaseStrawSeedsQuantity();
                    }
                    else{
                        controller.setStrawSeedsExploitation(true);
                        controller.decreaseStrawSeedsQuantity();                    }
                }
                else JOptionPane.showMessageDialog(null, "You can't use several seeds at the same time :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton cabbageSeedsButton = new JButton();
        addButton(cabbageSeedsButton, "images/seeds_packs.png", 660, 600, 100, 100);
        cabbageSeedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!controller.getStrawSeedsExploitation()) {
                    if(controller.getCabbageSeedsExploitation()){
                        controller.setCabbageSeedsExploitation(false);
                        controller.increaseCabbageSeedsQuantity();
                    }
                    else{
                        controller.setCabbageSeedsExploitation(true);
                        controller.decreaseCabbageSeedsQuantity();
                    }
                }
                else JOptionPane.showMessageDialog(null, "You can't use several seeds at the same time :(", "Error!", JOptionPane.ERROR_MESSAGE);

            }
        });

        JButton buyStrawSeeds = new JButton();
        addButton(buyStrawSeeds, "images/buy.png", 560, 705, 25, 25);
        buyStrawSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseOfStrawSeedsIsAvailable()) {
                    controller.purchaseStrawSeeds();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityStrawSeeds = new JButton();
        addButton(quantityStrawSeeds, "",570, 705, 60, 30);

        JButton saleStrawSeeds = new JButton();
        addButton(saleStrawSeeds, "images/coins.png", 620, 705, 25, 25);
        saleStrawSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleOfStrawSeedsIsAvailable()) {
                    controller.saleStrawSeeds();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton buyCabbageSeeds = new JButton();
        addButton(buyCabbageSeeds, "images/buy.png", 670, 705, 25, 25);
        buyCabbageSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseOfCabbageSeedsIsAvailable()) {
                    controller.purchaseCabbageSeeds();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityCabbageSeeds = new JButton();
        addButton(quantityCabbageSeeds, "",680, 705, 60, 30);

        JButton saleCabbageSeeds = new JButton();
        addButton(saleCabbageSeeds, "images/coins.png", 730, 705, 25, 25);
        saleCabbageSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleOfCabbageSeedsIsAvailable()) {
                    controller.saleCabbageSeeds();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        costStrawSeeds = new JButton();
        addButton(costStrawSeeds, "",530, 565, 150, 30);

        costCabbageSeeds = new JButton();
        addButton(costCabbageSeeds, "",640, 565, 150, 30);
    }

    public void addHarvestPanelButtons() {
        JButton harvestLabel = new JButton();
        addButton(harvestLabel, "images/harvest.png", 830, 525, 200, 50);

        JButton strawHarvestButton = new JButton();
        addButton(strawHarvestButton, "images/straw_harvest.png", 820, 600, 100, 100);

        JButton cabbageHarvestButton = new JButton();
        addButton(cabbageHarvestButton, "images/cabbage_harvest.png", 930, 600, 100, 100);

        JButton buyStrawHarvest = new JButton();
        addButton(buyStrawHarvest, "images/buy.png", 830, 705, 25, 25);
        buyStrawHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseOfStrawHarvestIsAvailable()) {
                    controller.purchaseStrawHarvest();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityStrawHarvest = new JButton();
        addButton(quantityStrawHarvest,"", 840, 705, 60, 30);

        JButton saleStrawHarvest = new JButton();
        addButton(saleStrawHarvest, "images/coins.png", 890, 705, 25, 25);
        saleStrawHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleOfStrawHarvestIsAvailable()) {
                    controller.saleStrawHarvest();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton buyCabbageHarvest = new JButton();
        addButton(buyCabbageHarvest, "images/buy.png", 940, 705, 25, 25);
        buyCabbageHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseOfCabbageHarvestIsAvailable()) {
                    controller.purchaseCabbageHarvest();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityCabbageHarvest = new JButton();
        addButton(quantityCabbageHarvest, "", 950, 705, 60, 30);

        JButton saleCabbageHarvest = new JButton();
        addButton(saleCabbageHarvest, "images/coins.png", 1000, 705, 25, 25);
        saleCabbageHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleOfCabbageHarvestIsAvailable()) {
                    controller.saleCabbageHarvest();
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        costStrawHarvest = new JButton();
        addButton(costStrawHarvest,  "",800, 565, 150, 30);

        costCabbageHarvest = new JButton();
        addButton(costCabbageHarvest, "", 905, 565, 150, 30);
    }

    public void addButton(JButton newButton, String location, int x, int y, int i, int j){
        newButton.setBounds(x,y,i,j);
        newButton.setIcon(new ImageIcon(location));
        newButton.setBorderPainted(false);
        newButton.setFocusPainted(false);
        newButton.setContentAreaFilled(false);
        add(newButton);
    }

    public void solveMouseClick(int gb_num){
        controller.solveWeedAttack(gb_num);
        controller.solveLackOfMoisture(gb_num);
        controller.solveBeetleAttack(gb_num);
        controller.solveGardenBedEmptiness(gb_num);
        controller.solveHarvestReadiness(gb_num);
    }

    public void executeLabelRefreshing(){
        hoeButton.setVisible(!controller.getHoeExploitation());
        hoeIcon.setVisible(controller.getHoeExploitation());
        bucketButton.setVisible(!controller.getBucketExploitation());
        bucketIcon.setVisible(controller.getBucketExploitation());
        bucketIsFullLabel.setVisible(controller.getWaterStationExploitation());
        poisonButton.setVisible(!controller.getPoisonExploitation());
        poisonIcon.setVisible(controller.getPoisonExploitation());
        emptinessSign1.setVisible(controller.getGardenBedEmptiness(0));
        emptinessSign2.setVisible(controller.getGardenBedEmptiness(1));
        emptinessSign3.setVisible(controller.getGardenBedEmptiness(2));
        readinessSign1.setVisible(controller.getGardenBedReadiness(0));
        readinessSign2.setVisible(controller.getGardenBedReadiness(1));
        readinessSign3.setVisible(controller.getGardenBedReadiness(2));
        lackOfMoistureSign1.setVisible(controller.getGardenBedLackOfMoisture(0));
        lackOfMoistureSign2.setVisible(controller.getGardenBedLackOfMoisture(1));
        lackOfMoistureSign3.setVisible(controller.getGardenBedLackOfMoisture(2));
        beetleAttackSign1.setVisible(controller.getGardenBedBeetleAttack(0));
        beetleAttackSign2.setVisible(controller.getGardenBedBeetleAttack(1));
        beetleAttackSign3.setVisible(controller.getGardenBedBeetleAttack(2));
        weedAttackSign1.setVisible(controller.getGardenBedWeedAttack(0));
        weedAttackSign2.setVisible(controller.getGardenBedWeedAttack(1));
        weedAttackSign3.setVisible(controller.getGardenBedWeedAttack(2));
        quantityStrawSeeds.setText(controller.getStrawSeedsQuantity());
        quantityStrawHarvest.setText(controller.getStrawHarvestQuantity());
        quantityCabbageSeeds.setText(controller.getCabbageSeedsQuantity());
        quantityCabbageHarvest.setText(controller.getCabbageHarvestQuantity());
        coinsAmountLabel.setText(controller.getCoinsAmount());
        costStrawSeeds.setText("$"+controller.getSaleStrawSeedsPrice()+"/$"+controller.getPurchaseStrawSeedsPrice());
        costStrawHarvest.setText("$"+controller.getSaleStrawHarvestPrice()+"/$"+controller.getPurchaseStrawHarvestPrice());
        costCabbageSeeds.setText("$"+controller.getSaleCabbageSeedsPrice()+"/$"+controller.getPurchaseCabbageSeedsPrice());
        costCabbageHarvest.setText("$"+controller.getSaleCabbageHarvestPrice()+"/$"+controller.getPurchaseCabbageHarvestPrice());
    }
}

