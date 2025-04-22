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
        
        // Initialize chat panel
        initChatPanel();
        
        // Add greeting message
        String greeting = physicsVirtualAssistant.getGreeting();
        addMessage("Assistant: " + greeting);
    }
    
    public void initChatPanel() {
        // Create main panel with BorderLayout
        chatPanel = new JPanel(new BorderLayout());
        chatPanel.setBorder(BorderFactory.createTitledBorder("Virtual Assistant"));
        chatPanel.setPreferredSize(new Dimension(800, 150)); // Fixed height for chat panel
        
        // Create chat history area
        chatHistory = new JTextArea(5, 30);
        chatHistory.setEditable(false);
        chatHistory.setLineWrap(true);
        chatHistory.setWrapStyleWord(true);
        
        // Add scroll capability
        scrollPane = new JScrollPane(chatHistory);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Create input field
        inputField = new JTextField(30);
        inputField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputField.getText();
                if (!userInput.trim().isEmpty()) {
                    // Add user message to chat
                    addMessage("You: " + userInput);
                    
                    // Get assistant response
                    String response = physicsVirtualAssistant.getResponse(userInput);
                    addMessage("Assistant: " + response);
                    
                    // Clear input field
                    inputField.setText("");
                }
            }
        });
        
        // Add components to panel
        chatPanel.add(scrollPane, BorderLayout.CENTER);
        chatPanel.add(inputField, BorderLayout.SOUTH);
    }
    
    public JPanel getChatPanel() {
        return chatPanel;
    }
    
    public void addMessage(String message) {
        messages.add(message);
        
        // Ensure we only keep the last MAX_MESSAGES
        while (messages.size() > MAX_MESSAGES) {
            messages.remove(0);
        }
        
        // Update chat history text
        updateChatHistoryText();
    }
    
    public void updateChatHistoryText() {
        StringBuilder chatText = new StringBuilder();
        
        for (String message : messages) {
            chatText.append(message).append("\n\n");
        }
        
        chatHistory.setText(chatText.toString());
        
        // Scroll to the bottom to show the latest message
        chatHistory.setCaretPosition(chatHistory.getDocument().getLength());
    }
}