package pl.sdacademy.javaktw7.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {
    private String author;
    private String message;
    public static final long serialVersionUID = 1L;

    public ChatMessage() {
    }

    public ChatMessage(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
