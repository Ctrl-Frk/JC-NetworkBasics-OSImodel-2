package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8090;
        Scanner scanner = new Scanner(System.in);

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            while (true) {
                String input = in.readLine();
                System.out.println(input);

                if (input.contains("Server is end")) {
                    break;
                }

                String text = scanner.nextLine();
                out.println(text);
            }
        }
    }
}
