
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

public class physicsAppProblems {
    private physicsAppGUI mainApp;
    private physicsAppButtons appButtons;
    private static final Random random = new Random();
    
    public physicsAppProblems(physicsAppGUI app) {
        this.mainApp = app;
        this.appButtons = new physicsAppButtons(app);
    }
    
    public void addPracticeProblemButtons(JPanel panel) {
        JButton position = new JButton("Position");
        JButton velocity = new JButton("Velocity");
        JButton acceleration = new JButton("Acceleration");
        
        panel.add(position);
        panel.add(velocity);
        panel.add(acceleration);
        
        position.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPracticeProblem("position");
            }
        });
        
        velocity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPracticeProblem("velocity");
            }
        });
        
        acceleration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPracticeProblem("acceleration");
            }
        });
    }
    
    public void displayPracticeProblem(String problemType) {
        switch (problemType) {
            case "position":
                displayPositionProblem();
                break;
            case "velocity":
                displayVelocityProblem();
                break;
            case "acceleration":
                displayAccelerationProblem();
                break;
        }
    }
    
    private void displayPositionProblem() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Position Practice Problem", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);

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
            }
        }
        problemPanel.add(problemLabel);
        mainApp.add(problemPanel);

        JPanel answerPanel = new JPanel(new FlowLayout());
        JLabel answerPrompt = new JLabel("Your answer: ");
        JTextField answerField = new JTextField(10);
        JButton submit = new JButton("Submit");
        answerPanel.add(answerPrompt);
        answerPanel.add(answerField);
        answerPanel.add(submit);
        mainApp.add(answerPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Result will appear here");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addPracticeProblemHomeButton();
        appButtons.addHomeButton();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double userAnswer = Double.parseDouble(answerField.getText());
                    if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                        result.setText("Correct!");
                    } 
                    else {
                        result.setText(String.format("Incorrect! Correct answer: %.2f. Use formula: %s", correctAnswer, formula));
                    }
                } catch (NumberFormatException ex) {
                    result.setText("Please enter a valid number");
                }
            }
        });
    }
    
    private void displayVelocityProblem() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Velocity Practice Problem", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);

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
        mainApp.add(problemPanel);

        JPanel answerPanel = new JPanel(new FlowLayout());
        JLabel answerPrompt = new JLabel("Your answer: ");
        JTextField answerField = new JTextField(10);
        JButton submit = new JButton("Submit");
        answerPanel.add(answerPrompt);
        answerPanel.add(answerField);
        answerPanel.add(submit);
        mainApp.add(answerPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Result will appear here");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addPracticeProblemHomeButton();
        appButtons.addHomeButton();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double userAnswer = Double.parseDouble(answerField.getText());
                    if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                        result.setText("Correct!");
                    } 
                    else {
                        result.setText(String.format("Incorrect! Correct answer: %.2f. Use formula: %s", correctAnswer, formula));
                    }
                } catch (NumberFormatException ex) {
                    result.setText("Please enter a valid number");
                }
            }
        });
    }
    
    private void displayAccelerationProblem() {
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Acceleration Practice Problem", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        mainApp.add(titlePanel);

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
        mainApp.add(problemPanel);

        JPanel answerPanel = new JPanel(new FlowLayout());
        JLabel answerPrompt = new JLabel("Your answer: ");
        JTextField answerField = new JTextField(10);
        JButton submit = new JButton("Submit");
        answerPanel.add(answerPrompt);
        answerPanel.add(answerField);
        answerPanel.add(submit);
        mainApp.add(answerPanel);

        JPanel resultPanel = new JPanel(new FlowLayout());
        JLabel result = new JLabel("Result will appear here");
        resultPanel.add(result);
        mainApp.add(resultPanel);

        appButtons.addPracticeProblemHomeButton();
        appButtons.addHomeButton();

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double userAnswer = Double.parseDouble(answerField.getText());
                    if (Math.abs(userAnswer - correctAnswer) < 0.01) {
                        result.setText("Correct!");
                    } 
                    else {
                        result.setText(String.format("Incorrect! Correct answer: %.2f. Use formula: %s", correctAnswer, formula));
                    }
                } catch (NumberFormatException ex) {
                    result.setText("Please enter a valid number");
                }
            }
        });
    }
}