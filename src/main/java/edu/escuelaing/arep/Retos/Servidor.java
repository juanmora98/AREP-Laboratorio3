package edu.escuelaing.arep.Retos;


import java.io.*;
import java.net.*;
import java.lang.Math;


public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Recibi: " + inputLine);
            if (!in.ready())
                break;
        }

        outputLine = 
          "<!DOCTYPE html>" + 
          "<html>" + 
          "<head>" + 
          "<meta charset=\"UTF-8\">" + 
          "<title>Title of the document</title>\n" + 
          "</head>" + 
          "<body>" + 
          "<h1>Mi propio mensaje</h1>" + 
          "</body>" + 
          "</html>" + inputLine; 
        out.println("HTTP/1.1 200 OK");
        out.println("Content-type: " + "text/html");
        out.println("\r\n");
        out.println(outputLine);
        out.flush();
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}