package edu.escuelaing.arep.Calentamiento;

import java.io.*;
import java.net.*;

public class Ejercicio1 {

    public static void main(String[] args) {
        URL google;
        try {
            google = new URL("https://www.eltiempo.com/");
            System.out.println(google.getProtocol() + " protocolo");
            System.out.println(google.getAuthority() + " Autoridad");
            System.out.println(google.getHost() + " Host");
            System.out.println(google.getPort() + " Port");
            System.out.println(google.getPath() + " Path");
            System.out.println(google.getQuery() + " Query");
            System.out.println(google.getFile() + " File");
            System.out.println(google.getRef() + " Ref");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
    }






}