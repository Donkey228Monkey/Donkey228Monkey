/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author redyr
 */
public class Theater {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public ArrayList<String> getTicket() {
        return ticket;
    }

    public void setTicket(ArrayList<String> ticket) {
        this.ticket = ticket;
    }
   
    private String name;
    private String movie;
    private String seat;
    private ArrayList<String> ticket = new ArrayList<>();
    File file = new File(movie+".txt");
    private ArrayList<Integer> takenSeats = new ArrayList<>();
    PrintWriter pwTemp;
    private int max;
    
    public Theater(int max) {
        this.max = max;
    }
    
    public Theater(String name, String movie, String seat) throws IOException{
        this.pwTemp = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(this.file)));
        this.movie = movie;
        this.seat = seat;
        this.name = name;
    }
    
    private Scanner getFile(File file) throws FileNotFoundException{
        
        Scanner scan = new Scanner(file);
        return scan;
        
    }
    
    public ArrayList<Integer> assembleIntArray(Scanner scan) throws FileNotFoundException{
        
        //this was neccessary in order to avoid duplication of the previously created array
        ArrayList<Integer> takenSeatsTemp = new ArrayList<>();
        ArrayList<Integer> theater = new ArrayList<>(this.max);
        
        for(int j = 0; j < this.max; j++){
            theater.add(j+1);
        }
        
        while(scan.hasNext()){
                int i = Integer.parseInt(scan.next());
            try{
                
                takenSeatsTemp.add(i);
                
                scan.nextLine();
                
            }catch(NumberFormatException e){
                System.out.println(e);
                scan.next();
            }
        }
        for(int i = 0; i < takenSeatsTemp.size(); i++){
            for(int j = 0; j < theater.size(); j++){
                    if(theater.get(j) == takenSeatsTemp.get(i)){
                        theater.remove(j);
                    }
            }
        }        
        System.out.println(takenSeatsTemp);
        System.out.println(theater);
        
        this.takenSeats = takenSeatsTemp;
        return this.takenSeats;
        
    }
    
    public void reserveSeat(String name, String movie, String seat) {
        
        Random random = new Random();
        int ticketNum = random.nextInt(100000-10000)+10000;

        int desiredSeat = Integer.parseInt(seat);
        File file = new File(movie+".txt");
        boolean reserved = false;
        int list = 0;
        try{
            
            for(int i = 0; i < this.takenSeats.size(); i++){
                if(desiredSeat == this.takenSeats.get(i)){
                    reserved = true;
                    while(reserved){
                        Scanner input = new Scanner(System.in);
                        System.out.println("Please enter one of the available seats");
                        int compromisedSeat = input.nextInt();
                        if(compromisedSeat != this.takenSeats.get(i)){
                            reserved = false;
                            desiredSeat = compromisedSeat;
                        }
                    }
                }
            }
            
            Scanner scan = new Scanner(file);
            String ticket = desiredSeat + " Ticket#" + ticketNum + " for " + name + " movie: " + movie;
            System.out.println(ticket);
            this.ticket.add(ticket);

            try{
                PrintWriter pw = new PrintWriter(
                                 new BufferedWriter(
                                 new FileWriter(file)));
                for(int i = 0; i < this.ticket.size(); i++){
                    pw.println(this.ticket.get(i));
                }

                pw.close();
            this.assembleIntArray(scan);
                
            }catch(IOException e){
                System.out.println(e);
            }
        }
        catch(FileNotFoundException e){
            
        }
                         
    }
}