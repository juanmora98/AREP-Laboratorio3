package edu.escuelaing.arep.Calentamiento;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Browser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object
        System.out.println("Ingrese una pagina web");
        String pagina = scanner.nextLine(); // Read user input
        scanner.close();
        try {
            URL paginaWeb = new URL(pagina);
            BufferedReader br = new BufferedReader(new InputStreamReader(paginaWeb.openStream()));
            String input = null;
            FileOutputStream paginahtml = new FileOutputStream("resultado.html");
            while((input = br.readLine()) != null){
                paginahtml.write(input.getBytes());
            }
            paginahtml.flush();
            paginahtml.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }   

}
