package com.example.sebakoempire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private Button buttonSend;
    private ListView listViewChat;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);
        listViewChat = findViewById(R.id.listViewChat);

        // Initialize chat adapter with an empty list
        chatAdapter = new ChatAdapter(new ArrayList<>(), this);
        listViewChat.setAdapter(chatAdapter);

        // Example: Add a message to the chat
        chatAdapter.addMessage(new ChatMessage("Hello!", true));
        chatAdapter.addMessage(new ChatMessage("Hi there!", false));

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String messageText = editTextMessage.getText().toString().trim();
        if (!messageText.isEmpty()) {
            // Create a new message
            ChatMessage message = new ChatMessage(messageText, true);

            // Add the message to the adapter and update the UI
            chatAdapter.addMessage(message);
            scrollListViewToBottom();

            // Clear the message input field
            editTextMessage.getText().clear();

            // In a real app, you would send the message to the server or perform necessary actions
            // For simplicity, we're only adding it to the UI here.
        }
    }

    private void scrollListViewToBottom() {
        listViewChat.post(new Runnable() {
            @Override
            public void run() {
                // Scroll the ListView to the bottom
                listViewChat.setSelection(chatAdapter.getCount() - 1);
            }
        });
    }
}
