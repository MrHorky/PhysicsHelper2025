
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* BACK BUTTON 
    JButton back = new JButton("Home");
    back.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            app();
        }
    });
    INSERT PANEL AREA HERE
*/

public class physicsAppGUI extends JFrame { 

    public physicsAppGUI() {
        setSize(500, 281);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        app();
    }

    private void backButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Home");
        backPanel.add(back);
        add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                app();
                revalidate();
                repaint();
            }
        });
    }

    private void app() {
        JPanel homePanel = new JPanel(new BorderLayout());
        JLabel home = new JLabel("Physics Calculator", SwingConstants.CENTER);
        homePanel.add(home, BorderLayout.CENTER);
        add(home);

        JPanel choiceMessage = new JPanel(new BorderLayout());
        JLabel message = new JLabel("Pick an option: ", SwingConstants.CENTER);
        choiceMessage.add(message, BorderLayout.CENTER);
        add(message);

        JPanel buttons = new JPanel(new GridLayout(1, 4, 10, 0));
        JButton calculators = new JButton("Calculators");
        JButton tableGenerator = new JButton("Table Generators");
        JButton practiceProblems = new JButton("Practice Problems");
        JButton exit = new JButton("Exit");
        buttons.add(calculators);
        buttons.add(tableGenerator);
        buttons.add(practiceProblems);
        buttons.add(exit);
        add(buttons);

        calculators.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll(); // remove all elements
                calculators(); // call calculator elements
                revalidate(); // refresh page
                repaint(); // repopulate with calculator elements
            }
        });
        tableGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableGenerator();
            }
        });
        practiceProblems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                practiceProblems();
            }
        });
        exit.addActionListener((ActionEvent e) -> {
            exit();
        });
    }
    
    private void calculators() {
        JPanel calculatorHome = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Calculators", SwingConstants.CENTER);
        calculatorHome.add(title, BorderLayout.CENTER);

        JPanel message = new JPanel(new BorderLayout());
        JLabel equationMessage = new JLabel("Choose an equation to solve: ", SwingConstants.CENTER);
        message.add(equationMessage, BorderLayout.CENTER);
        add(equationMessage);

        JPanel calculatorButton = new JPanel(new GridLayout(1, 4, 10, 0));
        JButton position = new JButton("Position");
        JButton velocity = new JButton("Velocity");
        JButton acceleration = new JButton("Acceleration");
        JButton angularSpeed = new JButton("Angular Speed");
        JButton angleOfMovement = new JButton("Angle of Movement");
        calculatorButton.add(position);
        calculatorButton.add(velocity);
        calculatorButton.add(acceleration);
        calculatorButton.add(angularSpeed);
        calculatorButton.add(angleOfMovement);

        add(calculatorButton);

        backButton();

        position.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            positionGUI();
            revalidate();
            repaint();
        });
        velocity.addActionListener((ActionEvent e) -> {
            getContentPane().removeAll();
            velocityGUI();
            revalidate();
            repaint();
        });
        acceleration.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                accelerationGUI();
                revalidate();
                repaint();
            }
        });
        angularSpeed.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                angularSpeedGUI();
                revalidate();
                repaint();
            }
        });
        angleOfMovement.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                angleOfMovementGUI();
                revalidate();
                repaint();
            }
        });
    }

    private void positionGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Position Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);
        
        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel initPosPrompt = new JLabel("Initial Position: ");
        JTextField initPosNum = new JTextField(6);
        JLabel initVeloPrompt = new JLabel("Initial Velocity: ");
        JTextField initVeloNum = new JTextField(6);
        JLabel timePrompt = new JLabel("Time: ");
        JTextField timeNum = new JTextField(6);
        JLabel accelerationPrompt = new JLabel("Initial Position: ");
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
        add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The current position is: ");
        resultPanel.add(result);
        add(resultPanel);

        backButton();

        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double initPos = Double.parseDouble(initPosNum.getText());
                double initVelo = Double.parseDouble(initVeloNum.getText());
                double time = Double.parseDouble(timeNum.getText()); 
                double acc = Double.parseDouble(accelerationNum.getText());
                double currPos = (initPos) + (initVelo * time) + ((1.0 / 2.0) * acc * Math.pow(time, 2));

                result.setText("The current position is: " + String.format("%.2f", currPos));
            }
        });
    }

    private void velocityGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Velocity Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);
        
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
        add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The current velocity is: ");
        resultPanel.add(result);
        add(resultPanel);

        backButton();

        calculate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double finalPos = Double.parseDouble(finalPosNum.getText());
                double initPos = Double.parseDouble(initPosNum.getText());
                double finalTime = Double.parseDouble(finalTimeNum.getText()); 
                double initTime = Double.parseDouble(initTimeNum.getText());
                double currentVelocity = (finalPos - initPos) / (finalTime - initTime);

                result.setText("The current velocity is: " + String.format("%.2f", currentVelocity));
            }
        });
    }

    private void accelerationGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Acceleration Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);
        
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
        add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The current acceleration is: ");
        resultPanel.add(result);
        add(resultPanel);

        backButton();

        calculate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double finalVelo = Double.parseDouble(finalVeloNum.getText());
                double initVelo = Double.parseDouble(initVeloNum.getText());
                double finalTime = Double.parseDouble(finalTimeNum.getText()); 
                double initTime = Double.parseDouble(initTimeNum.getText());
                double currentVelocity = (finalVelo - initVelo) / (finalTime - initTime);

                result.setText("The acceleration is: " + String.format("%.2f", currentVelocity));
            }
        });
    }

    private void angularSpeedGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Angular Speed Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);
        
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
        add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The angular speed is: ");
        resultPanel.add(result);
        add(resultPanel);

        backButton();

        calculate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double initVelo = Double.parseDouble(initVeloNum.getText());
                double acceleration = Double.parseDouble(accelerationNum.getText());
                double time = Double.parseDouble(timeNum.getText());
                double angularSpeed = initVelo + (acceleration * time);

                result.setText("The angular speed is: " + String.format("%.2f", angularSpeed));
            }
        });
    }

    private void angleOfMovementGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Angle Of Movement Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);
        
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
        add(calculation);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("The angle of movement is: ");
        resultPanel.add(result);
        add(resultPanel);

        backButton();

        calculate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                double initPos = Double.parseDouble(initPosNum.getText());
                double initVelo = Double.parseDouble(initVeloNum.getText());
                double time = Double.parseDouble(timeNum.getText());
                double acceleration = Double.parseDouble(accelerationNum.getText());
                double angleOfMovement = initPos + (initVelo * time) + ((0.5) * acceleration * Math.pow(time, 2));

                result.setText("The angle of movement is: " + String.format("%.2f", angleOfMovement));
            }
        });
    }

    private void tableGenerator() {

    }

    private void practiceProblems() {

    }

    private void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        physicsAppGUI app = new physicsAppGUI();
        app.setVisible(true);
    }
}