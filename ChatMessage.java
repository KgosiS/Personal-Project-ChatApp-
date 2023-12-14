package com.example.sebakoempire;

public class ChatMessage {

    private String message;
    private boolean isSentByUser;
    private String timestamp;

    public ChatMessage(String message, boolean isSentByUser) {
        this.message = message;
        this.isSentByUser = isSentByUser;
        this.timestamp = "10:30 AM"; // Example: You can use the actual timestamp logic here
    }

    public String getMessage() {
        return message;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
