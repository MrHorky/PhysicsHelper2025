
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class physicsAppGUI extends JFrame {
    
    
    private physicsAppButtons appButtons;
    private physicsAppCalculators appCalculators;
    private physicsAppTables appTables;
    private physicsAppProblems appProblems;
    private physicsChatBot appAssistant;
    
    private JPanel contentContainer; 
    private JPanel mainContentPanel; 

    public physicsAppGUI() {
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());

        contentContainer = new JPanel(new BorderLayout());
        add(contentContainer, BorderLayout.CENTER);
        
        mainContentPanel = new JPanel(new GridLayout(5, 1));
        contentContainer.add(mainContentPanel, BorderLayout.CENTER);
    
        appAssistant = new physicsChatBot(this);
        JPanel assistantPanel = appAssistant.getChatPanel();
        add(assistantPanel, BorderLayout.SOUTH);
        
        appButtons = new physicsAppButtons(this);
        appCalculators = new physicsAppCalculators(this);
        appTables = new physicsAppTables(this);
        appProblems = new physicsAppProblems(this);
      
        showHomeScreen();
        
        setVisible(true);
    }
    
    @Override
    public Component add(Component comp) {
        return mainContentPanel.add(comp);
    }
    
    public void showHomeScreen() {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        JPanel homePanel = new JPanel(new BorderLayout());
        JLabel home = new JLabel("Physics Calculator", SwingConstants.CENTER);
        homePanel.add(home, BorderLayout.CENTER);
        add(home);

        JPanel choiceMessage = new JPanel(new BorderLayout());
        JLabel message = new JLabel("Pick an option: ", SwingConstants.CENTER);
        choiceMessage.add(message, BorderLayout.CENTER);
        add(message);

        JPanel buttons = new JPanel(new GridLayout(1, 4, 10, 0));
        
        appButtons.addHomeScreenButtons(buttons);
        add(buttons);
        
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    public void showCalculatorsMenu() {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        JPanel calculatorHome = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Calculators", SwingConstants.CENTER);
        calculatorHome.add(title, BorderLayout.CENTER);
        add(title);

        JPanel message = new JPanel(new BorderLayout());
        JLabel equationMessage = new JLabel("Choose an equation to solve: ", SwingConstants.CENTER);
        message.add(equationMessage, BorderLayout.CENTER);
        add(equationMessage);

        JPanel calculatorButton = new JPanel(new GridLayout(1, 5, 10, 0));
        
        appCalculators.addCalculatorButtons(calculatorButton);
        add(calculatorButton);

        appButtons.addHomeButton();
        
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void showTableGeneratorMenu() {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Table Generator", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel selectionPanel = new JPanel(new FlowLayout());
    
        appTables.addTableGeneratorButtons(selectionPanel);
        add(selectionPanel);

        appButtons.addHomeButton();
    
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }

    public void showPracticeProblemsMenu() {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Practice Problems", SwingConstants.CENTER);
        titlePanel.add(title, BorderLayout.CENTER);
        add(titlePanel);

        JPanel problemPanel = new JPanel(new FlowLayout());
        JLabel problemLabel = new JLabel("Choose a problem type");
        problemPanel.add(problemLabel);
        add(problemPanel);

        JPanel selectionPanel = new JPanel(new FlowLayout());
        
        appProblems.addPracticeProblemButtons(selectionPanel);
        add(selectionPanel);

        appButtons.addHomeButton();
        
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    public void showCalculator(String calculatorType) {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        appCalculators.displayCalculator(calculatorType);
        
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    public void showTableGenerator(String tableType) {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        appTables.displayTableGenerator(tableType);
        
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    public void showPracticeProblem(String problemType) {
        mainContentPanel.removeAll();
        mainContentPanel.setLayout(new GridLayout(5, 1));
        
        appProblems.displayPracticeProblem(problemType);
        
        mainContentPanel.revalidate();
        mainContentPanel.repaint();
    }
    
    public static void main(String[] args) {
        new physicsAppGUI();
    }
}