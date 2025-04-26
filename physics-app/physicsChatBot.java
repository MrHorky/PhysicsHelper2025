import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class physicsChatBot {
    public physicsAppGUI mainApp;
    public JPanel chatPanel;
    public JTextField inputField;
    public JTextArea chatHistory;
    public JScrollPane scrollPane;
    public List<String> messages;
    public final int MAX_MESSAGES = 10;
    
    public physicsChatBot(physicsAppGUI app) {
        this.mainApp = app;
        this.messages = new ArrayList<>();
        
        initChatPanel();

        String greeting = physicsVirtualAssistant.getGreeting();
        addMessage("Assistant: " + greeting);
    }
    
    public void initChatPanel() {
        chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBorder(BorderFactory.createTitledBorder("Virtual Assistant"));
        chatPanel.setPreferredSize(new Dimension(800, 150));

        chatHistory = new JTextArea(5, 30);
        chatHistory.setEditable(false);
        chatHistory.setLineWrap(true);
        chatHistory.setWrapStyleWord(true);
        
        scrollPane = new JScrollPane(chatHistory);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    
        inputField = new JTextField(30);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                if (!userInput.trim().isEmpty()) {
                    addMessage("You: " + userInput);
                    
                    String response = physicsVirtualAssistant.getResponse(userInput);
                    addMessage("Assistant: " + response);
                    
                    inputField.setText("");
                }
            }
        });
        
        chatPanel.add(scrollPane, BorderLayout.CENTER);
        chatPanel.add(inputField, BorderLayout.SOUTH);
    }
    
    public JPanel getChatPanel() {
        return chatPanel;
    }
    
    public void addMessage(String message) {
        messages.add(message);
        
        while (messages.size() > MAX_MESSAGES) {
            messages.remove(0);
        }
        
        updateChatHistoryText();
    }
    
    public void updateChatHistoryText() {
        StringBuilder chatText = new StringBuilder();
        
        for (String message : messages) {
            chatText.append(message).append("\n\n");
        }
        
        chatHistory.setText(chatText.toString());
        
        chatHistory.setCaretPosition(chatHistory.getDocument().getLength());
    }
}