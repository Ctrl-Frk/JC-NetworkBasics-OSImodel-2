package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8090;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());

                    out.println("Connection successful! Write your name");

                    final String name = in.readLine();
                    out.printf("Hello %s, do you want to make an appointment? \n", name);

                    final String ifWant = in.readLine();
                    if (ifWant.equals("yes")) {
                        out.println("Connecting with administrator *la-la-la* Server is end\n");
                    } else {
                        out.println("Write your phone number, please");
                        final String phoneNumber = in.readLine();
                        out.printf("Your phone number: %s. We will call you soon. Bye! Server is end", phoneNumber);
                    }
                }
            }
        }
    }
}
