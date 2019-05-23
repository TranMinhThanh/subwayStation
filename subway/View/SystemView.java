/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.View;

import common.StationState;
import common.Validate;
import java.util.List;
import java.util.Scanner;
import subway.Controller.StationController;
import subway.Controller.TicketController;

/**
 *
 * @author ThanhTM
 */
public class SystemView {
    TicketController ticketController;
    StationController stationController;
    
    public SystemView(){
        this.stationController = new StationController();
        this.ticketController = new TicketController();
        
        Scanner scan = new Scanner(System.in);
        do {
            String station = selectStation();
            StationState action = selectAction(station);    
            int ticketID = selectTicket();
            Validate result = ticketController.doAction(ticketID, station, action);
            showTicketInformation(ticketID, result, action);
            
        } while(true);
    }
    
      
    // View img 1
    private String selectStation() {
        System.out.flush();
        String keySelect = "";
        char startKey = 'a';
        char endKey = startKey;
        List<String> stationList = stationController.getAllStation();
        do {
            System.out.println("____________________________________________________________________________________________________________");
            System.out.println("These are stations in the line M14 of Paris:");
            
            for (String station: stationList) {
                System.out.println(endKey + ". " + station);
                endKey = (char)(endKey + 1);
            }
            System.out.println("Please provide a letter (from " + startKey + " to " + endKey + ") for choosing a station to start:");
            Scanner scan = new Scanner(System.in);
            keySelect = scan.nextLine();
        } while (keySelect.length() == 0 || keySelect.length() > 1 || keySelect.charAt(0) > endKey || keySelect.charAt(0) < startKey);

        int selectPos = (keySelect.charAt(0) - startKey);
        
        return stationList.get(selectPos);
    }
    
    // Select action and ticket id
    private StationState selectAction(String station) {      
        List<Integer> ticketList = ticketController.getAllTicket();
        int selectTicketID = 0;
        System.out.println("____________________________________________________________________________________________________________");
            System.out.flush();
            System.out.println("These are existing tickets/cards:");
            
            for (int ticketID: ticketList) {
                System.out.println("+) " + ticketID + ": " + ticketController.getBaseInformation(ticketID));
            }
            int keySelect = 0;
            
            Scanner scan = new Scanner(System.in);
            do {
                System.out.println("Available actions: 1-enter station, 2-exit station");
                keySelect = scan.nextInt();
            } while (keySelect != 1 && keySelect != 2);
            
            if (keySelect == 1){
                System.out.println("You entered station " + station + ".");
                return StationState.ENTER;
            } else {
                System.out.println("You exited station " + station + ".");
                return StationState.EXIT;
            }
    }
    
    private int selectTicket(){
        System.out.flush();
        System.out.println("Please input your ticket ID:");
        List<Integer> ticketList = ticketController.getAllTicket();
        Scanner scan = new Scanner(System.in);
        int selectID = scan.nextInt();
        while (!ticketList.contains(selectID)){
            System.out.println("Ticket ID not found. Please input again:");
            selectID = scan.nextInt();
        }
        return selectID;
    }
    
    // Show ticket information
    private void showTicketInformation(int ticketID, Validate validate, StationState action) {
        System.out.flush();
        String actionResult = "";
        if (!validate.getIsValidate()){
            actionResult = "Invalid " + ticketController.getTicketType(ticketID);
        }
        else {
            actionResult = "Opening gate with " + ticketController.getTicketType(ticketID);
        }
        System.out.println(actionResult);
        System.out.println(ticketController.getBaseInformation(ticketID));
        if (!validate.getIsValidate()){
            System.out.println(validate.getReason());
        }
        System.out.println("Press any key to continue...");
        Scanner scan = new Scanner(System.in);
        String selectID = scan.next();
    }
}
