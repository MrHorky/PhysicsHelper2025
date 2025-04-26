
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class physicsAppCalculators {
    private physicsAppGUI mainApp;
    private physicsAppButtons appButtons;
    
    public physicsAppCalculators(physicsAppGUI app) {
        this.mainApp = app;
        this.appButtons = new physicsAppButtons(app);
    }
    
    public void addCalculatorButtons(JPanel panel) {
        JButton position = new JButton("Position");
        JButton velocity = new JButton("Velocity");
        JButton acceleration = new JButton("Acceleration");
        JButton angularSpeed = new JButton("Angular Speed");
        JButton angleOfMovement = new JButton("Angle of Movement");
        
        panel.add(position);
        panel.add(velocity);
        panel.add(acceleration);
        panel.add(angularSpeed);
        panel.add(angleOfMovement);
        
        position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculator("position");
            }
        });
        
        velocity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculator("velocity");
            }
        });
        
        acceleration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculator("acceleration");
            }
        });
        
        angularSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculator("angularSpeed");
            }
        });
        
        angleOfMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculator("angleOfMovement");
            }
        });
    }
    
    public void displayCalculator(String calculatorType) {
        switch (calculatorType) {
            case "position" -> displayPositionCalculator();
            case "velocity" -> displayVelocityCalculator();
            case "acceleration" -> displayAccelerationCalculator();
            case "angularSpeed" -> displayAngularSpeedCalculator();
            case "angleOfMovement" -> displayAngleOfMovementCalculator();
        }
    }
    
    private void displayPositionCalculator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Position Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel initPosPrompt = new JLabel("Initial Position: ");
        JTextField initPosNum = new JTextField(6);
        JLabel initVeloPrompt = new JLabel("Initial Velocity: ");
        JTextField initVeloNum = new JTextField(6);
        JLabel timePrompt = new JLabel("Time: ");
        JTextField timeNum = new JTextField(6);
        JLabel accelerationPrompt = new JLabel("Acceleration: ");
        JTextField accelerationNum = new JTextField(6);
        JButton calculate = new JButton("Calculate");
        
        calculation.add(initPosPrompt);
        calculation.add(initPosNum);
        calculation.add(initVeloPrompt);
        calculation.add(initVeloNum);
        calculation.add(timePrompt);
        calculation.add(timeNum);
        calculation.add(accelerationPrompt);
        calculation.add(accelerationNum);
        calculation.add(calculate);
        mainApp.add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The current position is: ");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addCalculatorHomeButton();
        appButtons.addHomeButton();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initPos = Double.parseDouble(initPosNum.getText());
                    double initVelo = Double.parseDouble(initVeloNum.getText());
                    double time = Double.parseDouble(timeNum.getText()); 
                    double acc = Double.parseDouble(accelerationNum.getText());
                    double currPos = (initPos) + (initVelo * time) + ((1.0 / 2.0) * acc * Math.pow(time, 2));

                    result.setText("The current position is: " + String.format("%.2f", currPos));
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
    
    private void displayVelocityCalculator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Velocity Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel finalPosPrompt = new JLabel("Final Position: ");
        JTextField finalPosNum = new JTextField(6);
        JLabel initPosPrompt = new JLabel("Initial Position: ");
        JTextField initPosNum = new JTextField(6);
        JLabel finalTimePrompt = new JLabel("Final Time: ");
        JTextField finalTimeNum = new JTextField(6);
        JLabel initTimePrompt = new JLabel("Initial Time: ");
        JTextField initTimeNum = new JTextField(6);
        JButton calculate = new JButton("Calculate");
        
        calculation.add(finalPosPrompt);
        calculation.add(finalPosNum);
        calculation.add(initPosPrompt);
        calculation.add(initPosNum);
        calculation.add(finalTimePrompt);
        calculation.add(finalTimeNum);
        calculation.add(initTimePrompt);
        calculation.add(initTimeNum);
        calculation.add(calculate);
        mainApp.add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The current velocity is: ");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addCalculatorHomeButton();
        appButtons.addHomeButton();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double finalPos = Double.parseDouble(finalPosNum.getText());
                    double initPos = Double.parseDouble(initPosNum.getText());
                    double finalTime = Double.parseDouble(finalTimeNum.getText()); 
                    double initTime = Double.parseDouble(initTimeNum.getText());
                    double currentVelocity = (finalPos - initPos) / (finalTime - initTime);

                    result.setText("The current velocity is: " + String.format("%.2f", currentVelocity));
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
    
    private void displayAccelerationCalculator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Acceleration Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel finalVeloPrompt = new JLabel("Final Velocity: ");
        JTextField finalVeloNum = new JTextField(6);
        JLabel initVeloPrompt = new JLabel("Initial Velocity: ");
        JTextField initVeloNum = new JTextField(6);
        JLabel finalTimePrompt = new JLabel("Final Time: ");
        JTextField finalTimeNum = new JTextField(6);
        JLabel initTimePrompt = new JLabel("Initial Time: ");
        JTextField initTimeNum = new JTextField(6);
        JButton calculate = new JButton("Calculate");
        
        calculation.add(finalVeloPrompt);
        calculation.add(finalVeloNum);
        calculation.add(initVeloPrompt);
        calculation.add(initVeloNum);
        calculation.add(finalTimePrompt);
        calculation.add(finalTimeNum);
        calculation.add(initTimePrompt);
        calculation.add(initTimeNum);
        calculation.add(calculate);
        mainApp.add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The current acceleration is: ");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addCalculatorHomeButton();
        appButtons.addHomeButton();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double finalVelo = Double.parseDouble(finalVeloNum.getText());
                    double initVelo = Double.parseDouble(initVeloNum.getText());
                    double finalTime = Double.parseDouble(finalTimeNum.getText()); 
                    double initTime = Double.parseDouble(initTimeNum.getText());
                    double acceleration = (finalVelo - initVelo) / (finalTime - initTime);

                    result.setText("The acceleration is: " + String.format("%.2f", acceleration));
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
    
    private void displayAngularSpeedCalculator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Angular Speed Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel initVeloPrompt = new JLabel("Initial Velocity: ");
        JTextField initVeloNum = new JTextField(6);
        JLabel accelerationPrompt = new JLabel("Acceleration: ");
        JTextField accelerationNum = new JTextField(6);
        JLabel timePrompt = new JLabel("Time: ");
        JTextField timeNum = new JTextField(6);
        JButton calculate = new JButton("Calculate");
        
        calculation.add(initVeloPrompt);
        calculation.add(initVeloNum);
        calculation.add(accelerationPrompt);
        calculation.add(accelerationNum);
        calculation.add(timePrompt);
        calculation.add(timeNum);
        calculation.add(calculate);
        mainApp.add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The angular speed is: ");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addCalculatorHomeButton();
        appButtons.addHomeButton();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initVelo = Double.parseDouble(initVeloNum.getText());
                    double acceleration = Double.parseDouble(accelerationNum.getText());
                    double time = Double.parseDouble(timeNum.getText());
                    double angularSpeed = initVelo + (acceleration * time);

                    result.setText("The angular speed is: " + String.format("%.2f", angularSpeed));
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
    
    private void displayAngleOfMovementCalculator() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Angle Of Movement Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel initPosPrompt = new JLabel("Initial Position: ");
        JTextField initPosNum = new JTextField(6);
        JLabel initVeloPrompt = new JLabel("Initial Velocity: ");
        JTextField initVeloNum = new JTextField(6);
        JLabel timePrompt = new JLabel("Time: ");
        JTextField timeNum = new JTextField(6);
        JLabel accelerationPrompt = new JLabel("Acceleration: ");
        JTextField accelerationNum = new JTextField(6);
        JButton calculate = new JButton("Calculate");

        calculation.add(initPosPrompt);
        calculation.add(initPosNum);
        calculation.add(initVeloPrompt);
        calculation.add(initVeloNum);
        calculation.add(timePrompt);
        calculation.add(timeNum);
        calculation.add(accelerationPrompt);
        calculation.add(accelerationNum);
        calculation.add(calculate);
        mainApp.add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The angle of movement is: ");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addCalculatorHomeButton();
        appButtons.addHomeButton();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double initPos = Double.parseDouble(initPosNum.getText());
                    double initVelo = Double.parseDouble(initVeloNum.getText());
                    double time = Double.parseDouble(timeNum.getText());
                    double acceleration = Double.parseDouble(accelerationNum.getText());
                    double angleOfMovement = initPos + (initVelo * time) + ((0.5) * acceleration * Math.pow(time, 2));

                    result.setText("The angle of movement is: " + String.format("%.2f", angleOfMovement));
                } 
                catch (NumberFormatException ex) {
                    result.setText("Please enter valid numbers for all fields");
                }
            }
        });
    }
}