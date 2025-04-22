
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class physicsAppButtons {
    private physicsAppGUI mainApp;
    
    public physicsAppButtons(physicsAppGUI app) {
        this.mainApp = app;
    }
    
    public void addHomeScreenButtons(JPanel panel) {
        JButton calculators = new JButton("Calculators");
        JButton tableGenerator = new JButton("Table Generators");
        JButton practiceProblems = new JButton("Practice Problems");
        JButton exit = new JButton("Exit");
        
        panel.add(calculators);
        panel.add(tableGenerator);
        panel.add(practiceProblems);
        panel.add(exit);
        
        calculators.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculatorsMenu();
            }
        });
        
        tableGenerator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showTableGeneratorMenu();
            }
        });
        
        practiceProblems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPracticeProblemsMenu();
            }
        });
        
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void addHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Home");
        backPanel.add(back);
        mainApp.add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showHomeScreen();
            }
        });
    }
    
    public void addCalculatorHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Calculators");
        backPanel.add(back);
        mainApp.add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showCalculatorsMenu();
            }
        });
    }
    
    public void addTableGeneratorHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Table Generators");
        backPanel.add(back);
        mainApp.add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showTableGeneratorMenu();
            }
        });
    }
    
    public void addPracticeProblemHomeButton() {
        JPanel backPanel = new JPanel(new FlowLayout());
        JButton back = new JButton("Practice Problems");
        backPanel.add(back);
        mainApp.add(backPanel);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainApp.showPracticeProblemsMenu();
            }
        });
    }
}