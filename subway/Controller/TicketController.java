/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Controller;

import java.util.List;
import subway.Model.Ticket;
import common.Validate;
import common.StationState;
import java.util.ArrayList;
import subway.Model.OneWayTicket;
import subway.Model.PrepaidCard;
import subway.Model.Station;
import subway.Model.TwentyHourTicket;
/**
 *
 * @author ThanhTM
 */
public class TicketController {
    private List<Ticket> ticketList;
    
    public List<Integer> getAllTicket(){
        List<Integer> ticketIds = new ArrayList<>();
        for (Ticket ticket: ticketList) {
            ticketIds.add(ticket.getTicketID());
        } 
        return ticketIds;
    }
    
    public Validate doAction(int ticketID, String stationName, StationState action){
        Station station = StationController.getStationByName(stationName);
        if (station == null) {
            return new Validate(false, "Station not found");
        }
        
        for (Ticket ticket: ticketList) {
            if (ticket.getTicketID() == ticketID) {
                return ticket.updateTicketState(station, action);
            }
        } 
        return new Validate(false, "Ticket not found");
    }
    
    public String getTicketInformation(int ticketID) {
        for (Ticket ticket: ticketList) {
            if (ticket.getTicketID() == ticketID) {
                return ticket.getTicketInformation();
            }
        } 
        return "Ticket not found";
    }
    
    public String getTicketType(int ticketID){
       for (Ticket ticket: ticketList) {
            if (ticket.getTicketID() == ticketID) {
                return ticket.getTicketType();
            }
        } 
        return "Ticket not found"; 
    }
    
    public void chargeMoney(int ticketID, float money) {
        for (Ticket ticket: ticketList) {
            if (ticket.getTicketID() == ticketID) {
                ticket.chargeMoney(money);
            }
        }
    }
    
    public String getBaseInformation(int ticketID){
        for (Ticket ticket: ticketList) {
            if (ticket.getTicketID() == ticketID) {
                return ticket.getBaseInformation();
            }
        } 
        return "Ticket not found";
    }
    
    public TicketController(){
        this.ticketList = new ArrayList<>();
        List<String> stations = StationController.getAllStation();
        OneWayTicket ticket1 = new OneWayTicket(12346579, StationController.getStationByName(stations.get(0)), StationController.getStationByName(stations.get(1)));
        TwentyHourTicket ticket2 = new TwentyHourTicket(11111111);
        PrepaidCard ticket3 = new PrepaidCard(22222222, 8);
        OneWayTicket ticket4 = new OneWayTicket(33333333, StationController.getStationByName(stations.get(3)), StationController.getStationByName(stations.get(6)));
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
        ticketList.add(ticket4);
    }
}
