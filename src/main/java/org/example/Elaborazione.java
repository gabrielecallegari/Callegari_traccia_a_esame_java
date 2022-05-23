package org.example;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Locale;

public class Elaborazione extends Thread{

    Socket clientSocket=null;
    ServerSocket serverSocket=null;
    static Elaborazione_Arraylist el;

    Elaborazione(){}

    Elaborazione(Socket clientSocket, ServerSocket serverSocket){
        this.clientSocket=clientSocket;
        this.serverSocket=serverSocket;
    }
    void createEl(){
        el=new Elaborazione_Arraylist();
        el.crea_lista();
    }
    @Override
    public void run(){
        BufferedReader input=null;
        try {
            input=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.out.println("Errore buffered reader\n"+e.toString());
        }
        String messaggio="";
        PrintWriter output=null;
        try {
            output=new PrintWriter(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            System.out.println("Errore printwriter \n"+e.toString());
        }
        output.println("CONNESSO AL SERVER. Comandi disponibili: all, sorted_crescente, sorted_decrescente, more_expensive");

        try {
            while ((messaggio = input.readLine()) != null) {
                output.println(elaborazione_messaggio(messaggio.toLowerCase(Locale.ROOT)));
            }
        }catch(IOException e){
            System.out.println("Errore nella lettura\n"+e.toString());
        }
        System.out.println("Client disconnesso");
    }

    String elaborazione_messaggio(String digitato){
        String result="";
        switch (digitato){
            case "all":
                result=el.all();
                break;
            case "more_expensive":
                result=el.moreExpensive();
                break;
            case "sorted_crescente":
                result=el.sort_crescente();
                break;

            case "sorted_decrescente":
                result=el.sort_decrescente();
                break;
            default:
                result="Comando errato! Comandi disponibili: all, sorted_crescente, sorted_decrescente, more_expensive";
                break;
        }
        return result;
    }






}