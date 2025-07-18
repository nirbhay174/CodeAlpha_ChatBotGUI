import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class ChatBotGUI extends JFrame implements ActionListener {
    JTextArea chatArea;
    JTextField inputField;
    JButton sendButton;

    HashMap<String, String> knowledgeBase;

    public ChatBotGUI() {
        setTitle("AI Chatbot");
        setSize(400, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        sendButton = new JButton("Send");
        sendButton.addActionListener(this);

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        knowledgeBase = new HashMap<>();
        knowledgeBase.put("hi", "Hello! How can I help you josh?");
        knowledgeBase.put("hello", "Hi there! Need any help?");
        knowledgeBase.put("how are you", "I'm just a bot, but I'm doing great!");
        knowledgeBase.put("what is ai", "AI stands for Artificial Intelligence.");
        knowledgeBase.put("bye", "bye! Have a great day! see you soon!");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = inputField.getText().toLowerCase().trim();
        chatArea.append("You: " + userInput + "\n");
        inputField.setText("");

        String response = getResponse(userInput);
        chatArea.append("Bot: " + response + "\n\n");
    }

    private String getResponse(String input) {
        for (String key : knowledgeBase.keySet()) {
            if (input.contains(key)) {
                return knowledgeBase.get(key);
            }
        }
        return "I'm sorry, I don't understand that yet.";
    }

    public static void main(String[] args) {
        new ChatBotGUI();
    }
}
