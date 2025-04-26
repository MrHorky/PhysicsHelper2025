
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class physicsAppTables {
    private physicsAppGUI mainApp;
    private physicsAppButtons appButtons;
    
    public physicsAppTables(physicsAppGUI app) {
        this.mainApp = app;
        this.appButtons = new physicsAppButtons(app);
    }
    
    public void addTableGeneratorButtons(JPanel panel) {
        JButton regular = new JButton("Regular Table");
        JButton projectileMotion = new JButton("Projectile Motion");
        
        panel.add(regular);
        panel.add(projectileMotion);
        
        regular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showTableGenerator("regular");
            }
        });
        
        projectileMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showTableGenerator("projectileMotion");
            }
        });
    }
    
    public void displayTableGenerator(String tableType) {
        switch (tableType) {
            case "regular" -> displayRegularTableGenerator();
            case "projectileMotion" -> displayProjectileMotionTableGenerator();
        }
    }
    
    private void displayRegularTableGenerator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Regular Table Generator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel secondsPrompt = new JLabel("Seconds: ");
        JTextField secondsNum = new JTextField(6);
        JLabel accelerationPrompt = new JLabel("Acceleration: ");
        JTextField accelerationNum = new JTextField(6);
        JLabel velocityPrompt = new JLabel("Velocity: ");
        JTextField velocityNum = new JTextField(6);
        JLabel positionPrompt = new JLabel("Position: ");
        JTextField positionNum = new JTextField(6);
        JButton write = new JButton("Write");

        calculation.add(secondsPrompt);
        calculation.add(secondsNum);
        calculation.add(accelerationPrompt);
        calculation.add(accelerationNum);
        calculation.add(velocityPrompt);
        calculation.add(velocityNum);
        calculation.add(positionPrompt);
        calculation.add(positionNum);
        calculation.add(write);
        mainApp.add(calculation);
        
        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Table will be written to regularTable.txt");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addTableGeneratorHomeButton();
        appButtons.addHomeButton();

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double seconds = Double.parseDouble(secondsNum.getText());
                    double acceleration = Double.parseDouble(accelerationNum.getText());
                    double velocity = Double.parseDouble(velocityNum.getText());
                    double position = Double.parseDouble(positionNum.getText());

                    try {
                        FileWriter writer = new FileWriter("regularTable.txt");

                        writer.write("Time (s) | Velocity (m/s) | Position (x) \n");
                        writer.write("---------+----------------+-------------\n");

                        for (int i = 0; i <= seconds; i++) {
                            double currentVelo = velocity + (acceleration * i);
                            double currentPos = position + (velocity * i) + (0.5 * acceleration * i * i);

                            String line = String.format("%-9d| %-15.2f| %-12.2f%n", i, currentVelo, currentPos);
                            writer.write(line);
                        }
                        writer.close();
                        result.setText("Table successfully written to regularTable.txt");
                    } 
                    catch (IOException ex) {
                        result.setText("Error writing to file: " + ex.getMessage());
                    }
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
    
    private void displayProjectileMotionTableGenerator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Projectile Motion Table Generator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 5, 10, 0));
        JLabel secondsPrompt = new JLabel("Seconds: ");
        JTextField secondsNum = new JTextField(6);
        JLabel initPosXPrompt = new JLabel("Initial Position X: ");
        JTextField initPosXNum = new JTextField(6);
        JLabel initVeloXPrompt = new JLabel("Initial Velocity X: ");
        JTextField initVeloXNum = new JTextField(6);
        JLabel initPosYPrompt = new JLabel("Initial Position Y: ");
        JTextField initPosYNum = new JTextField(6);
        JLabel initVeloYPrompt = new JLabel("Initial Velocity Y: ");
        JTextField initVeloYNum = new JTextField(6);
        JButton write = new JButton("Write");

        calculation.add(secondsPrompt);
        calculation.add(secondsNum);
        calculation.add(initPosXPrompt);
        calculation.add(initPosXNum);
        calculation.add(initVeloXPrompt);
        calculation.add(initVeloXNum);
        calculation.add(initPosYPrompt);
        calculation.add(initPosYNum);
        calculation.add(initVeloYPrompt);
        calculation.add(initVeloYNum);
        calculation.add(write);
        mainApp.add(calculation);
        
        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Table will be written to projectileMotionTable.txt");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addTableGeneratorHomeButton();
        appButtons.addHomeButton();

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double seconds = Double.parseDouble(secondsNum.getText());
                    double initPosX = Double.parseDouble(initPosXNum.getText());
                    double initVeloX = Double.parseDouble(initVeloXNum.getText());
                    double initPosY = Double.parseDouble(initPosYNum.getText());
                    double initVeloY = Double.parseDouble(initVeloYNum.getText());
                    double GRAVITY = -9.81;

                    try {
                        FileWriter writer = new FileWriter("projectileMotionTable.txt");

                        writer.write("Time (s) | Position (x) | Position (y) \n");
                        writer.write("---------+--------------+-------------\n");

                        for (int i = 0; i <= seconds; i++) {
                            double motionX = initPosX + (initVeloX * i);
                            double motionY = initPosY + (initVeloY * i) + ((0.5) * GRAVITY * Math.pow(i, 2));

                            String line = String.format("%-9d| %-12.2f | %-12.2f%n", i, motionX, motionY);
                            writer.write(line);
                        }
                        writer.close();
                        result.setText("Table successfully written to projectileMotionTable.txt");
                    } 
                    catch (IOException ex) {
                        result.setText("Error writing to file: " + ex.getMessage());
                    }
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
}