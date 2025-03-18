/* A LITTLE NOTE FOR ANY VIEWER */

/*
    * Dear Programmer,
    * When I wrote this code, only God and
    * I knew how it worked
    * Now, only God knows it!
    * 
    * Therefore, if you are trying to optimize
    * this code and it fails (most surely),
    * please increase this counter as a 
    * warning for the next person: 
    * 
    * total hours wasted here = 254
    * 
*/

import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.util.Random;

public class physicsAppGUI extends JFrame {

    private static final Random random = new Random(); 

    public physicsAppGUI() {
        setSize(500, 281);
        setLayout(new GridLayout(5, 1));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        app();
    }

    private void homeButton() {
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

    private void calculatorHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Calculators");
        backPanel.add(back);
        add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                calculators();
                revalidate();
                repaint();
            }
        });
    }

    private void tableGeneratorHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Table Generators");
        backPanel.add(back);
        add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                tableGenerator();
                revalidate();
                repaint();
            }
        });
    }

    private void practiceProblemHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Practice Problems");
        backPanel.add(back);
        add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                practiceProblems();
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
                getContentPane().removeAll();
                tableGenerator();
                revalidate();
                repaint();
            }
        });
        practiceProblems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                practiceProblems();
                revalidate();
                repaint();
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

        homeButton();

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
        acceleration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                accelerationGUI();
                revalidate();
                repaint();
            }
        });
        angularSpeed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                angularSpeedGUI();
                revalidate();
                repaint();
            }
        });
        angleOfMovement.addActionListener(new ActionListener() {
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

        calculatorHomeButton();
        homeButton();

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

        calculatorHomeButton();
        homeButton();

        calculate.addActionListener(new ActionListener() {
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

        calculatorHomeButton();
        homeButton();

        calculate.addActionListener(new ActionListener() {
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

        calculatorHomeButton();
        homeButton();

        calculate.addActionListener(new ActionListener() {
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

        calculatorHomeButton();
        homeButton();

        calculate.addActionListener(new ActionListener() {
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
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Table Generator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel selectionPanel = new JPanel(new FlowLayout());
        JButton regular = new JButton("Regular Table");
        JButton projectileMotion = new JButton("Projectile Motion");
        selectionPanel.add(regular);
        selectionPanel.add(projectileMotion);
        add(selectionPanel);

        homeButton();

        regular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                regularTableGUI();
                revalidate();
                repaint();
            }
        });

        projectileMotion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                projectileMotionGUI();
                revalidate();
                repaint();
            }
        });
    }

    private void regularTableGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
        JLabel secondsPrompt = new JLabel("Seconds: ");
        JTextField secondsNum = new JTextField(6);
        JLabel accelerationPrompt = new JLabel("Acceleration: ");
        JTextField accelerationNum = new JTextField(6);
        JLabel velocityPrompt = new JLabel("Velocity: ");
        JTextField velocityNum = new JTextField(6);
        JLabel positionPrompt = new JLabel("Time: ");
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
        add(calculation);

        tableGeneratorHomeButton();
        homeButton();

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                } 
                catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    private void projectileMotionGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel calculation = new JPanel(new GridLayout(1, 4, 10, 0));
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
        add(calculation);

        tableGeneratorHomeButton();
        homeButton();

        write.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double seconds = Double.parseDouble(secondsNum.getText());
                double initPosX = Double.parseDouble(initPosXNum.getText());
                double initVeloX = Double.parseDouble(initVeloXNum.getText());
                double initPosY = Double.parseDouble(initPosYNum.getText());
                double initVeloY = Double.parseDouble(initVeloYNum.getText());
                final double GRAVITY = -9.18;

                try {
                    FileWriter writer = new FileWriter("projectileMotionTable.txt");

                    writer.write("Time (s) | Position (x) | Position (y) \n");
                    writer.write("---------+--------------+-------------\n");

                    for (int i = 0; i <= seconds; i++) {
                        double motionX = (initPosX + initVeloX) * i;
                        double motionY = ((initPosY + initVeloY) * i) - ((0.5) * GRAVITY * Math.pow(i, 2));

                        String line = String.format("%-9d| %-12.2f| %-12.2f%n", i, motionX, motionY);
                        writer.write(line);
                    }
                    writer.close();
                } 
                catch (IOException ex) {
                    System.out.println(ex);
                }
            }
        });
    }

    private void practiceProblems() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Practice Problems", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel problemPanel = new JPanel(new FlowLayout());
        JLabel problemLabel = new JLabel("Choose a problem type");
        problemPanel.add(problemLabel);
        add(problemPanel);

        JPanel selectionPanel = new JPanel(new FlowLayout());
        JButton position = new JButton("Position");
        JButton velocity = new JButton("Velocity");
        JButton acceleration = new JButton("Acceleration");
        selectionPanel.add(position);
        selectionPanel.add(velocity);
        selectionPanel.add(acceleration);
        add(selectionPanel);

        homeButton();

        position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                positionProblemGUI();
                revalidate();
                repaint();
            }
        });

        velocity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                velocityProblemGUI();
                revalidate();
                repaint();
            }
        });

        acceleration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                accelerationProblemGUI();
                revalidate();
                repaint();
            }
        });
    }

    private void positionProblemGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Position Practice Problem", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel problemPanel = new JPanel(new FlowLayout());
        JLabel problemLabel = new JLabel();
        double initPos = random.nextDouble() * 50;
        double initVelo = random.nextDouble() * 20;
        double time = random.nextDouble() * 10 + 1;
        double acceleration = random.nextDouble() * 10;
        
        final double correctAnswer;
        final String formula;
        int unknown = random.nextInt(4);
        switch (unknown) {
            case 0 -> {
                correctAnswer = initPos + (initVelo * time) + (0.5 * acceleration * time * time);
                problemLabel.setText(String.format("Given x₀ = %.2f, v₀ = %.2f, t = %.2f, a = %.2f, calculate x: ", initPos, initVelo, time, acceleration));
                formula = "x = x₀ + v₀t + 0.5at²";
            }
            case 1 -> {
                correctAnswer = (initVelo * time) + (0.5 * acceleration * time * time);
                problemLabel.setText(String.format("Given x = ?, v₀ = %.2f, t = %.2f, a = %.2f, calculate x₀: ", initVelo, time, acceleration));
                formula = "x₀ = x - v₀t - 0.5at²";
            }
            case 2 -> {
                correctAnswer = (initPos - (0.5 * acceleration * time * time)) / time;
                problemLabel.setText(String.format("Given x = %.2f, x₀ = %.2f, t = %.2f, a = %.2f, calculate v₀: ", initPos, initPos, time, acceleration));
                formula = "v₀ = (x - x₀ - 0.5at²) / t";
            }
            case 3 -> {
                correctAnswer = (initPos - (initVelo * time)) / (0.5 * time * time);
                problemLabel.setText(String.format("Given x = %.2f, x₀ = %.2f, v₀ = %.2f, t = %.2f, calculate a: ", initPos, initPos, initVelo, time));
                formula = "a = 2(x - x₀ - v₀t) / t²";
            }
            default -> {
                correctAnswer = 0;
                formula = "";
                break;
            }
        }
        problemPanel.add(problemLabel);
        add(problemPanel);

        JPanel answerPanel = new JPanel(new FlowLayout());
        JLabel answerPrompt = new JLabel("Your answer: ");
        JTextField answerField = new JTextField(10);
        JButton submit = new JButton("Submit");
        answerPanel.add(answerPrompt);
        answerPanel.add(answerField);
        answerPanel.add(submit);
        add(answerPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Result will appear here");
        resultPanel.add(result);
        add(resultPanel);

        practiceProblemHomeButton();
        homeButton();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double userAnswer = Double.parseDouble(answerField.getText());
                if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                    result.setText("Correct!");
                } 
                else {
                    result.setText(String.format("Incorrect! Correct answer: %.2f. Use formula: %s", correctAnswer, formula));
                }
            }
        });
    }

    private void velocityProblemGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Velocity Practice Problem", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel problemPanel = new JPanel(new FlowLayout());
        JLabel problemLabel = new JLabel();
        double deltaX = random.nextDouble() * 50;
        double deltaT = random.nextDouble() * 10 + 1;
        
        final double correctAnswer;
        final String formula;
        if (random.nextBoolean()) {
            correctAnswer = deltaX / deltaT;
            formula = "v = Δx / Δt";
            problemLabel.setText(String.format("Given Δx = %.2f and Δt = %.2f, calculate v: ", deltaX, deltaT));
        } 
        else {
            correctAnswer = deltaT * (deltaX / deltaT);
            formula = "Δx = v * Δt";
            problemLabel.setText(String.format("Given v = %.2f and Δt = %.2f, calculate Δx: ", deltaX / deltaT, deltaT));
        }
        problemPanel.add(problemLabel);
        add(problemPanel);

        JPanel answerPanel = new JPanel(new FlowLayout());
        JLabel answerPrompt = new JLabel("Your answer: ");
        JTextField answerField = new JTextField(10);
        JButton submit = new JButton("Submit");
        answerPanel.add(answerPrompt);
        answerPanel.add(answerField);
        answerPanel.add(submit);
        add(answerPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Result will appear here");
        resultPanel.add(result);
        add(resultPanel);

        practiceProblemHomeButton();
        homeButton();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double userAnswer = Double.parseDouble(answerField.getText());
                if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                    result.setText("Correct!");
                } 
                else {
                    result.setText(String.format("Incorrect! Correct answer: %.2f. Use formula: %s", correctAnswer, formula));
                }
            }
        });
    }

    private void accelerationProblemGUI() {
        setLayout(new GridLayout(5, 1));

        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Acceleration Practice Problem", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel problemPanel = new JPanel(new FlowLayout());
        JLabel problemLabel = new JLabel();
        double deltaV = random.nextDouble() * 20;
        double deltaT = random.nextDouble() * 10 + 1;
        
        final double correctAnswer;
        final String formula;
        if (random.nextBoolean()) {
            correctAnswer = deltaV / deltaT;
            formula = "a = Δv / Δt";
            problemLabel.setText(String.format("Given Δv = %.2f and Δt = %.2f, calculate a: ", deltaV, deltaT));
        } 
        else {
            correctAnswer = deltaT * (deltaV / deltaT);
            formula = "Δv = a * Δt";
            problemLabel.setText(String.format("Given a = %.2f and Δt = %.2f, calculate Δv: ", deltaV / deltaT, deltaT));
        }
        problemPanel.add(problemLabel);
        add(problemPanel);

        JPanel answerPanel = new JPanel(new FlowLayout());
        JLabel answerPrompt = new JLabel("Your answer: ");
        JTextField answerField = new JTextField(10);
        JButton submit = new JButton("Submit");
        answerPanel.add(answerPrompt);
        answerPanel.add(answerField);
        answerPanel.add(submit);
        add(answerPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Result will appear here");
        resultPanel.add(result);
        add(resultPanel);


        practiceProblemHomeButton();
        homeButton();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double userAnswer = Double.parseDouble(answerField.getText());
                if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                    result.setText("Correct!");
                } 
                else {
                    result.setText(String.format("Incorrect! Correct answer: %.2f. Use formula: %s", correctAnswer, formula));
                }
            }
        });
    }

    private void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        physicsAppGUI app = new physicsAppGUI();
        app.setVisible(true);
    }
}