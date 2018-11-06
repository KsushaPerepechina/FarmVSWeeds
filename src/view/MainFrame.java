package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import controller.*;
import model.*;

public class MainFrame extends JFrame {
    private Controller controller;
    private Coins coins;

    private SeedsAndHarvest strawSeeds;
    private SeedsAndHarvest strawHarvest;
    private SeedsAndHarvest cabbageSeeds;
    private SeedsAndHarvest cabbageHarvest;

    private JButton coinsAmountLabel;
    private JButton quantityStrawSeeds;
    private JButton quantityCabbageSeeds;
    private JButton quantityStrawHarvest;
    private JButton quantityCabbageHarvest;

    private boolean hoeOn;
    private boolean bucketOn;
    private boolean poisonOn;
    private JButton hoeButton;
    private JButton bucketButton;
    private JButton poisonButton;
    private JButton hoeIcon;
    private JButton bucketIcon;
    private JButton bucketIsFullLabel;
    private JButton poisonIcon;

    private boolean strawSeedsOn;
    private boolean cabbageSeedsOn;

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

    private GardenBed gb1;
    private GardenBed gb2;
    private GardenBed gb3;

    private Timer moistureTimer;
    private Timer strawTimer;
    private Timer cabbageTimer;
    private Timer weedAttackTimer;
    private Timer beetleAttackTimer;

    public MainFrame(Controller c) {
        controller = c;
        coins = new Coins(50.00);
        setTitle("Farm VS Weeds");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon.png")));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        setSize((int) dimension.getWidth() - insets.left - insets.right, (int) dimension.getHeight() - insets.top - insets.bottom);
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

        coinsAmountLabel = new JButton('$' + coins.getAmountToString());
        addButton(coinsAmountLabel, "", 1185, 115, 100, 30);

        gb1 = new GardenBed();
        gb2 = new GardenBed();
        gb3 = new GardenBed();

        JButton gardenBedButton1 = new JButton();
        addButton(gardenBedButton1, "images/garden_bed.png", 300, 300, 100, 100);

        weedAttackTimer = new Timer();
        weedAttackTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                weedAttackSign1.setVisible(true);
                weedAttackSign2.setVisible(true);
                weedAttackSign3.setVisible(true);
                gb1.setWeedAttack(true);
                gb2.setWeedAttack(true);
                gb3.setWeedAttack(true);
                weedAttackTimer.cancel();
            }
        }, 2*60*1000);

        beetleAttackTimer = new Timer();
        beetleAttackTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                beetleAttackSign1.setVisible(true);
                beetleAttackSign2.setVisible(true);
                beetleAttackSign3.setVisible(true);
                gb1.setBeetleAttack(true);
                gb2.setBeetleAttack(true);
                gb3.setBeetleAttack(true);
                beetleAttackTimer.cancel();
            }
        }, 5*30*1000);

        moistureTimer = new Timer();
        moistureTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                lackOfMoistureSign1.setVisible(true);
                lackOfMoistureSign2.setVisible(true);
                lackOfMoistureSign3.setVisible(true);
                gb1.setLackOfMoisture(true);
                gb2.setLackOfMoisture(true);
                gb3.setLackOfMoisture(true);
                moistureTimer.cancel();
            }
        }, 8*1000);

        gardenBedButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (hoeOn && gb1.isWeedAttacked()) {
                    gb1.setWeedAttack(false);
                    weedAttackSign1.setVisible(false);
                    hoeOn = false;
                    hoeIcon.setVisible(false);
                    hoeButton.setVisible(true);
                    weedAttackTimer = new Timer();
                    weedAttackTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            weedAttackSign1.setVisible(true);
                            gb1.setWeedAttack(true);
                            weedAttackTimer.cancel();
                        }
                    }, 2*60*1000);
                }
                if (bucketOn && gb1.isLackedOfMoisture()) {
                    gb1.setLackOfMoisture(false);
                    lackOfMoistureSign1.setVisible(false);
                    bucketOn = false;
                    bucketIsFullLabel.setVisible(false);
                    bucketIcon.setVisible(false);
                    bucketButton.setVisible(true);
                    moistureTimer = new Timer();
                    moistureTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            lackOfMoistureSign1.setVisible(true);
                            gb1.setLackOfMoisture(true);
                            moistureTimer.cancel();
                        }
                    }, 8*1000);
                }
                if (poisonOn && gb1.isBeetleAttacked()) {
                    gb1.setBeetleAttack(false);
                    beetleAttackSign1.setVisible(false);
                    poisonOn = false;
                    poisonIcon.setVisible(false);
                    poisonButton.setVisible(true);
                    beetleAttackTimer = new Timer();
                    beetleAttackTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            beetleAttackSign1.setVisible(true);
                            gb1.setBeetleAttack(true);
                            beetleAttackTimer.cancel();
                        }
                    }, 5*30*1000);
                }
                if (strawSeedsOn && gb1.isEmpty()) {
                    gb1.setEmptiness(false);
                    emptinessSign1.setVisible(false);
                    strawSeedsOn = false;
                    gb1.setNameOfPlant(strawSeeds.getName());
                    strawTimer = new Timer();
                    strawTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gb1.setReadiness(true);
                            readinessSign1.setVisible(true);
                            strawTimer.cancel();
                        }
                    }, 15*1000);
                }
                if (cabbageSeedsOn && gb1.isEmpty()) {
                    gb1.setEmptiness(false);
                    emptinessSign1.setVisible(false);
                    cabbageSeedsOn = false;
                    gb1.setNameOfPlant(cabbageSeeds.getName());
                    cabbageTimer = new Timer();
                    cabbageTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gb1.setReadiness(true);
                            readinessSign1.setVisible(true);
                            cabbageTimer.cancel();
                        }
                    }, 20*1000);
                }
                if (gb1.isReady() && gb1.getNameOfPlant().equals(strawSeeds.getName())){
                    gb1.setEmptiness(true);
                    gb1.setReadiness(false);
                    emptinessSign1.setVisible(true);
                    readinessSign1.setVisible(false);
                    strawHarvest.increaseQuantity();
                    quantityStrawHarvest.setText(Integer.toString(strawHarvest.getQuantity()));
                }

                if (gb1.isReady() && gb1.getNameOfPlant().equals(cabbageSeeds.getName())) {
                    gb1.setEmptiness(true);
                    gb1.setReadiness(false);
                    emptinessSign1.setVisible(true);
                    readinessSign1.setVisible(false);
                    cabbageHarvest.increaseQuantity();
                    quantityCabbageHarvest.setText(Integer.toString(cabbageHarvest.getQuantity()));
                }
            }
        });

        emptinessSign1 = new JButton();
        addButton(emptinessSign1, "images/garden_bed_is_empty.png",300,250,50,50);

        readinessSign1 = new JButton();
        addButton(readinessSign1, "images/harvest_is_ready.png", 300,250,50,50);
        readinessSign1.setVisible(false);

        lackOfMoistureSign1 = new JButton();
        addButton(lackOfMoistureSign1, "images/lack_of_moisture.png", 350,250,50,50);
        lackOfMoistureSign1.setVisible(false);

        beetleAttackSign1 = new JButton();
        addButton(beetleAttackSign1, "images/beetle_attack.png", 300, 400,50,50);
        beetleAttackSign1.setVisible(false);

        weedAttackSign1 = new JButton();
        addButton(weedAttackSign1, "images/weed_attack.png", 350, 400,50,50);
        weedAttackSign1.setVisible(false);

        JButton gardenBedButton2 = new JButton();
        addButton(gardenBedButton2, "images/garden_bed.png", 420, 300, 100, 100);

        gardenBedButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (hoeOn && gb2.isWeedAttacked()) {
                    gb2.setWeedAttack(false);
                    weedAttackSign2.setVisible(false);
                    hoeOn = false;
                    hoeIcon.setVisible(false);
                    hoeButton.setVisible(true);
                    weedAttackTimer = new Timer();
                    weedAttackTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            weedAttackSign2.setVisible(true);
                            gb2.setWeedAttack(true);
                            weedAttackTimer.cancel();
                        }
                    }, 2*60*1000);
                }
                if (bucketOn && gb2.isLackedOfMoisture()) {
                    gb2.setLackOfMoisture(false);
                    lackOfMoistureSign2.setVisible(false);
                    bucketOn = false;
                    bucketIsFullLabel.setVisible(false);
                    bucketIcon.setVisible(false);
                    bucketButton.setVisible(true);
                    moistureTimer = new Timer();
                    moistureTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            lackOfMoistureSign2.setVisible(true);
                            gb2.setLackOfMoisture(true);
                            moistureTimer.cancel();
                        }
                    }, 8*1000);
                }
                if (poisonOn && gb2.isBeetleAttacked()) {
                    gb2.setBeetleAttack(false);
                    beetleAttackSign2.setVisible(false);
                    poisonOn = false;
                    poisonIcon.setVisible(false);
                    poisonButton.setVisible(true);
                    beetleAttackTimer = new Timer();
                    beetleAttackTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            beetleAttackSign2.setVisible(true);
                            gb2.setBeetleAttack(true);
                            beetleAttackTimer.cancel();
                        }
                    }, 5*30*1000);
                }
                if (strawSeedsOn && gb2.isEmpty()) {
                    gb2.setEmptiness(false);
                    emptinessSign2.setVisible(false);
                    strawSeedsOn = false;
                    gb2.setNameOfPlant(strawSeeds.getName());
                    strawTimer = new Timer();
                    strawTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gb2.setReadiness(true);
                            readinessSign2.setVisible(true);
                            strawTimer.cancel();
                        }
                    }, 15*1000);
                }
                if (cabbageSeedsOn && gb2.isEmpty()) {
                    gb2.setEmptiness(false);
                    emptinessSign2.setVisible(false);
                    cabbageSeedsOn = false;
                    gb2.setNameOfPlant(cabbageSeeds.getName());
                    cabbageTimer = new Timer();
                    cabbageTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gb2.setReadiness(true);
                            readinessSign2.setVisible(true);
                            cabbageTimer.cancel();
                        }
                    }, 20*1000);
                }
                if (gb2.isReady() && gb2.getNameOfPlant().equals(strawSeeds.getName())){
                    gb2.setEmptiness(true);
                    gb2.setReadiness(false);
                    emptinessSign2.setVisible(true);
                    readinessSign2.setVisible(false);
                    strawHarvest.increaseQuantity();
                    quantityStrawHarvest.setText(Integer.toString(strawHarvest.getQuantity()));
                }

                if (gb2.isReady() && gb2.getNameOfPlant().equals(cabbageSeeds.getName())) {
                    gb2.setEmptiness(true);
                    gb2.setReadiness(false);
                    emptinessSign2.setVisible(true);
                    readinessSign2.setVisible(false);
                    cabbageHarvest.increaseQuantity();
                    quantityCabbageHarvest.setText(Integer.toString(cabbageHarvest.getQuantity()));
                }
            }
        });

        emptinessSign2 = new JButton();
        addButton(emptinessSign2, "images/garden_bed_is_empty.png",420,250,50,50);

        readinessSign2 = new JButton();
        addButton(readinessSign2, "harvest_is_ready", 420,250,50,50);
        readinessSign2.setVisible(false);

        lackOfMoistureSign2 = new JButton();
        addButton(lackOfMoistureSign2, "images/lack_of_moisture.png", 470,250,50,50);
        lackOfMoistureSign2.setVisible(false);

        beetleAttackSign2 = new JButton();
        addButton(beetleAttackSign2, "images/beetle_attack.png", 420, 400,50,50);
        beetleAttackSign2.setVisible(false);

        weedAttackSign2 = new JButton();
        addButton(weedAttackSign2, "images/weed_attack.png", 470, 400,50,50);
        weedAttackSign2.setVisible(false);

        JButton gardenBedButton3 = new JButton();
        addButton(gardenBedButton3, "images/garden_bed.png", 540, 300, 100, 100);

        gardenBedButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (hoeOn && gb3.isWeedAttacked()) {
                    gb3.setWeedAttack(false);
                    weedAttackSign3.setVisible(false);
                    hoeOn = false;
                    hoeIcon.setVisible(false);
                    hoeButton.setVisible(true);
                    weedAttackTimer = new Timer();
                    weedAttackTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            weedAttackSign3.setVisible(true);
                            gb3.setWeedAttack(true);
                            weedAttackTimer.cancel();
                        }
                    }, 2*60*1000);
                }
                if (bucketOn && gb3.isLackedOfMoisture()) {
                    gb3.setLackOfMoisture(false);
                    lackOfMoistureSign3.setVisible(false);
                    bucketOn = false;
                    bucketIsFullLabel.setVisible(false);
                    bucketIcon.setVisible(false);
                    bucketButton.setVisible(true);
                    moistureTimer = new Timer();
                    moistureTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            lackOfMoistureSign3.setVisible(true);
                            gb3.setLackOfMoisture(true);
                            moistureTimer.cancel();
                        }
                    }, 8*1000);
                }
                if (poisonOn && gb3.isBeetleAttacked()) {
                    gb3.setBeetleAttack(false);
                    beetleAttackSign3.setVisible(false);
                    poisonOn = false;
                    poisonIcon.setVisible(false);
                    poisonButton.setVisible(true);
                    beetleAttackTimer = new Timer();
                    beetleAttackTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            beetleAttackSign3.setVisible(true);
                            gb3.setBeetleAttack(true);
                            beetleAttackTimer.cancel();
                        }
                    }, 5*30*1000);
                }
                if (strawSeedsOn && gb3.isEmpty()) {
                    gb3.setEmptiness(false);
                    emptinessSign3.setVisible(false);
                    strawSeedsOn = false;
                    gb3.setNameOfPlant(strawSeeds.getName());
                    strawTimer = new Timer();
                    strawTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gb3.setReadiness(true);
                            readinessSign3.setVisible(true);
                            strawTimer.cancel();
                        }
                    }, 15*1000);
                }
                if (cabbageSeedsOn && gb3.isEmpty()) {
                    gb3.setEmptiness(false);
                    emptinessSign3.setVisible(false);
                    cabbageSeedsOn = false;
                    gb3.setNameOfPlant(cabbageSeeds.getName());
                    cabbageTimer = new Timer();
                    cabbageTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            gb3.setReadiness(true);
                            readinessSign3.setVisible(true);
                            cabbageTimer.cancel();
                        }
                    }, 20*1000);
                }
                if (gb3.isReady() && gb3.getNameOfPlant().equals(strawSeeds.getName())){
                    gb3.setEmptiness(true);
                    gb3.setReadiness(false);
                    emptinessSign3.setVisible(true);
                    readinessSign3.setVisible(false);
                    strawHarvest.increaseQuantity();
                    quantityStrawHarvest.setText(Integer.toString(strawHarvest.getQuantity()));
                }

                if (gb3.isReady() && gb3.getNameOfPlant().equals(cabbageSeeds.getName())) {
                    gb3.setEmptiness(true);
                    gb3.setReadiness(false);
                    emptinessSign3.setVisible(true);
                    readinessSign3.setVisible(false);
                    cabbageHarvest.increaseQuantity();
                    quantityCabbageHarvest.setText(Integer.toString(cabbageHarvest.getQuantity()));
                }
            }
        });

        emptinessSign3 = new JButton();
        addButton(emptinessSign3, "images/garden_bed_is_empty.png",540,250,50,50);

        readinessSign3 = new JButton();
        addButton(readinessSign3, "harvest_is_ready", 540,250,50,50);
        readinessSign3.setVisible(false);

        lackOfMoistureSign3 = new JButton();
        addButton(lackOfMoistureSign3, "images/lack_of_moisture.png", 590,250,50,50);
        lackOfMoistureSign3.setVisible(false);

        beetleAttackSign3 = new JButton();
        addButton(beetleAttackSign3, "images/beetle_attack.png", 540, 400,50,50);
        beetleAttackSign3.setVisible(false);

        weedAttackSign3 = new JButton();
        addButton(weedAttackSign3, "images/weed_attack.png", 590, 400,50,50);
        weedAttackSign3.setVisible(false);

    /* JButton newGardenBedButton = new JButton();
    addButton(newGardenBedButton, "images/new_garden_bed.png", 310, 335, 75, 75);
    //else JOptionPane.showMessageDialog(null, "You have reached the maximum available number of garden beds :(", "Error!", JOptionPane.ERROR_MESSAGE);*/

    JButton lakeButton = new JButton();

    addButton(lakeButton, "images/lake.png",1100,325,150,150);
        lakeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent actionEvent){
            if (bucketIcon.isVisible()) {
                bucketOn = true;
                bucketIsFullLabel.setVisible(true);
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
                hoeOn = true;
                hoeButton.setVisible(false);
                hoeIcon.setVisible(true);
            }
        });

        hoeIcon = new JButton();
        addButton(hoeIcon, "images/small_hoe.png", 250, 300,50,50);
        hoeIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                hoeOn = false;
                hoeIcon.setVisible(false);
                hoeButton.setVisible(true);
            }
        });
        hoeIcon.setVisible(false);

        bucketButton = new JButton();
        addButton(bucketButton, "images/bucket.png", 290, 600, 100, 100);
        bucketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bucketButton.setVisible(false);
                bucketIcon.setVisible(true);
            }
        });

        bucketIcon = new JButton();
        addButton(bucketIcon, "images/small_bucket.png", 1050, 400, 50, 50);
        bucketIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                bucketOn = false;
                bucketIcon.setVisible(false);
                bucketButton.setVisible(true);
                bucketIsFullLabel.setVisible(false);
            }
        });
        bucketIcon.setVisible(false);

        bucketIsFullLabel = new JButton();
        addButton(bucketIsFullLabel, "images/harvest_is_ready.png", 1050, 350, 50, 50);
        bucketIsFullLabel.setVisible(false);

        poisonButton = new JButton();
        addButton(poisonButton, "images/poison.png", 400, 600, 100, 100);
        poisonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                poisonOn = true;
                poisonButton.setVisible(false);
                poisonIcon.setVisible(true);
            }
        });

        poisonIcon = new JButton();
        addButton(poisonIcon, "images/small_poison.png", 250, 350,50,50);
        poisonIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                poisonOn = false;
                poisonIcon.setVisible(false);
                poisonButton.setVisible(true);
            }
        });
        poisonIcon.setVisible(false);
    }

    public void addSeedsPanelButtons() {
        JButton seedsLabel = new JButton();
        addButton(seedsLabel, "images/seeds.png", 555, 525, 200, 50);

        strawSeeds = new SeedsAndHarvest("strawberry",0.55, 0.61, 5);
        JButton strawSeedsButton = new JButton();
        addButton(strawSeedsButton, "images/seeds_packs.png", 550, 600, 100, 100);
        strawSeedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!cabbageSeedsOn) {
                    if(strawSeedsOn){
                        strawSeedsOn = false;
                        strawSeeds.increaseQuantity();
                        quantityStrawSeeds.setText(Integer.toString(strawSeeds.getQuantity()));
                    }
                    else{
                        strawSeedsOn = true;
                        strawSeeds.decreaseQuantity();
                        quantityStrawSeeds.setText(Integer.toString(strawSeeds.getQuantity()));
                    }
                }
                else JOptionPane.showMessageDialog(null, "You can't use several seeds at the same time :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        cabbageSeeds = new SeedsAndHarvest("cabbage",0.48, 0.60, 3);
        JButton cabbageSeedsButton = new JButton();
        addButton(cabbageSeedsButton, "images/seeds_packs.png", 660, 600, 100, 100);
        cabbageSeedsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!strawSeedsOn) {
                    if(cabbageSeedsOn){
                        cabbageSeedsOn = false;
                        cabbageSeeds.increaseQuantity();
                        quantityCabbageSeeds.setText(Integer.toString(cabbageSeeds.getQuantity()));
                    }
                    else {
                        cabbageSeedsOn = true;
                        cabbageSeeds.decreaseQuantity();
                        quantityCabbageSeeds.setText(Integer.toString(cabbageSeeds.getQuantity()));
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
                if (controller.purchaseIsAvailable(strawSeeds, coins)) {
                    controller.purchase(strawSeeds, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityStrawSeeds.setText(String.valueOf(strawSeeds.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityStrawSeeds = new JButton(String.valueOf(strawSeeds.getQuantity()));
        addButton(quantityStrawSeeds, "",570, 705, 60, 30);

        JButton saleStrawSeeds = new JButton();
        addButton(saleStrawSeeds, "images/coins.png", 620, 705, 25, 25);
        saleStrawSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleIsAvailable(strawSeeds, coins)) {
                    controller.sale(strawSeeds, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityStrawSeeds.setText(String.valueOf(strawSeeds.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton buyCabbageSeeds = new JButton();
        addButton(buyCabbageSeeds, "images/buy.png", 670, 705, 25, 25);
        buyCabbageSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseIsAvailable(cabbageSeeds, coins)) {
                    controller.purchase(cabbageSeeds, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityCabbageSeeds.setText(String.valueOf(cabbageSeeds.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityCabbageSeeds = new JButton(String.valueOf(cabbageSeeds.getQuantity()));
        addButton(quantityCabbageSeeds, "",680, 705, 60, 30);

        JButton saleCabbageSeeds = new JButton();
        addButton(saleCabbageSeeds, "images/coins.png", 730, 705, 25, 25);
        saleCabbageSeeds.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleIsAvailable(cabbageSeeds, coins)) {
                    controller.sale(cabbageSeeds, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityCabbageSeeds.setText(String.valueOf(cabbageSeeds.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton costStrawSeeds = new JButton('$'+strawSeeds.getPurchasePriseToString()
                +'/'+ '$'+strawSeeds.getSalePriseToString());
        addButton(costStrawSeeds, "",530, 565, 150, 30);

        JButton costCabbageSeeds = new JButton('$'+cabbageSeeds.getPurchasePriseToString()
                +'/'+ '$'+cabbageSeeds.getSalePriseToString());
        addButton(costCabbageSeeds, "",640, 565, 150, 30);
    }

    public void addHarvestPanelButtons() {
        JButton harvestLabel = new JButton();
        addButton(harvestLabel, "images/harvest.png", 830, 525, 200, 50);

        strawHarvest = new SeedsAndHarvest("strawberry",3.31, 5.64, 4);
        JButton strawHarvestButton = new JButton();
        addButton(strawHarvestButton, "images/straw_harvest.png", 820, 600, 100, 100);

        cabbageHarvest = new SeedsAndHarvest("cabbage",2.98, 4.84, 6);
        JButton cabbageHarvestButton = new JButton();
        addButton(cabbageHarvestButton, "images/cabbage_harvest.png", 930, 600, 100, 100);

        JButton buyStrawHarvest = new JButton();
        addButton(buyStrawHarvest, "images/buy.png", 830, 705, 25, 25);
        buyStrawHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseIsAvailable(strawHarvest, coins)) {
                    controller.purchase(strawHarvest, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityStrawHarvest.setText(String.valueOf(strawHarvest.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityStrawHarvest = new JButton(String.valueOf(strawHarvest.getQuantity()));
        addButton(quantityStrawHarvest,"", 840, 705, 60, 30);

        JButton saleStrawHarvest = new JButton();
        addButton(saleStrawHarvest, "images/coins.png", 890, 705, 25, 25);
        saleStrawHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleIsAvailable(strawHarvest, coins)) {
                    controller.sale(strawHarvest, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityStrawHarvest.setText(String.valueOf(strawHarvest.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton buyCabbageHarvest = new JButton();
        addButton(buyCabbageHarvest, "images/buy.png", 940, 705, 25, 25);
        buyCabbageHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.purchaseIsAvailable(cabbageHarvest, coins)) {
                    controller.purchase(cabbageHarvest, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityCabbageHarvest.setText(String.valueOf(cabbageHarvest.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough coins :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        quantityCabbageHarvest = new JButton(String.valueOf(cabbageHarvest.getQuantity()));
        addButton(quantityCabbageHarvest, "", 950, 705, 60, 30);

        JButton saleCabbageHarvest = new JButton();
        addButton(saleCabbageHarvest, "images/coins.png", 1000, 705, 25, 25);
        saleCabbageHarvest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.saleIsAvailable(cabbageHarvest, coins)) {
                    controller.sale(cabbageHarvest, coins);
                    coinsAmountLabel.setText('$'+coins.getAmountToString());
                    quantityCabbageHarvest.setText(String.valueOf(cabbageHarvest.getQuantity()));
                }
                else JOptionPane.showMessageDialog(null, "You haven't enough items :(", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton costStrawHarvest = new JButton('$'+strawHarvest.getPurchasePriseToString()
                +'/'+ '$'+strawHarvest.getSalePriseToString());
        addButton(costStrawHarvest,  "",800, 565, 150, 30);

        JButton costCabbageHarvest = new JButton('$'+cabbageHarvest.getSalePriseToString()
                +'/'+ '$'+cabbageHarvest.getPurchasePriseToString());
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
}