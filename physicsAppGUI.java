
import java.awt.*;
import java.awt.event.*;
import javax.naming.spi.DirStateFactory;
import javax.swing.*;

public class physicsAppGUI extends JFrame { 

    public physicsAppGUI() {
        setSize(500, 281);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        app();
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
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exit();
            }
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

        position.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                positionGUI();
                revalidate();
                repaint();
            }
        });
        velocity.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                velocityGUI();
                revalidate();
                repaint();
            }
        });
        acceleration.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                accelerationGUI();
                revalidate();
                repaint();
            }
        });
        angularSpeed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                angularSpeedGUI();
                revalidate();
                repaint();
            }
        });
        angleOfMovement.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                angleOfMovementGUI();
                revalidate();
                repaint();
            }
        });
    }

    private void positionGUI() {
        JPanel titlePanel = new JPanel(new GridLayout());
        JLabel title = new JLabel("Position Calculator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);

        // Area for entering values for the position calculator //
        JPanel calculation = new JPanel(new GridLayout(1, 4, 2, 0));

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
        getContentPane().add(calculation);

        JPanel resultPanel = new JPanel();
        JLabel result = new JLabel("The current position is: ");
        resultPanel.add(result);
        getContentPane().add(resultPanel);

        calculate.addActionListener(new ActionListener(){
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
        // GUI Elements Here //
    }

    private void accelerationGUI() {
        // GUI Elements Here //
    }

    private void angularSpeedGUI() {
        // GUI Elements Here //
    }

    private void angleOfMovementGUI() {
        // GUI Elements Here //
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