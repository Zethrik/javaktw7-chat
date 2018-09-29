package pl.sdacademy.javaktw7.chat.client;

import pl.sdacademy.javaktw7.chat.model.ChatMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientTerminal implements Runnable {

    private final Socket socket;

    public ClientTerminal() throws IOException {
        socket = new Socket("host", 5567);
    }

    public void run() {
        try {
            ObjectOutputStream connection = new ObjectOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            String username = scanner.nextLine();
            String message = "";

            while (!message.equalsIgnoreCase("exit")) {
                System.out.print("> ");
                message = scanner.nextLine();
                ChatMessage messageToSend = new ChatMessage(username, message);
                connection.writeObject(messageToSend);
                connection.flush();
            }
        } catch (IOException e) {
            System.out.println("Could not prepare object connection, " +
                    "probably server went down");
            System.out.println(e.getMessage());
        }
        System.out.println("Disconnected from chat");
    }
}
