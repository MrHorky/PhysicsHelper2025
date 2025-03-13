
import java.awt.*;
import java.awt.event.*;
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
        // GUI Elements Here //
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