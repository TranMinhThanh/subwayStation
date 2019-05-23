/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Controller;

import java.util.List;
import subway.Model.Ticket;
import common.Validate;
import common.Station;
import common.StationState;
import subway.Model.OneWayTicket;
/**
 *
 * @author ThanhTM
 */
public class TicketController {
    private List<Ticket> ticketList;
    public Validate doAction(int ticketID, Station station, StationState action){
         try {
            if (ticketList.contains(ticketID)){
                Ticket ticket = ticketList.get(ticketID);
                return ticket.updateTicketState(station, action);
            }
            else {
                return new Validate(false, "Ticket not found");
            }
        } catch (Exception e){ 
            // Do nothing, this won't get throw exception
            return new Validate(false, "Ticket not found");
        }
    }
    
    public String getTicketInformation(int ticketID) {
        try {
            if (ticketList.contains(ticketID)){
                Ticket ticket = ticketList.get(ticketID);
                return ticket.getTicketInformation();
            }
            else {
                return "Ticket not found";
            }
        } catch (Exception e){ 
            // Do nothing, this won't get throw exception
            return null;
        }
    }
    
    public float getActualFare(int ticketID) {
        try {
            if (ticketList.contains(ticketID)){
                Ticket ticket = ticketList.get(ticketID);
                return ticket.getActualFare();
            }
            else {
                return -1;
            }
        } catch (Exception e){ 
            // Do nothing, this won't get throw exception
            return -1;
        }
    }
    
    public void chargeMoney(int ticketID, float money) {
        try {
            if (ticketList.contains(ticketID)){
                Ticket ticket = ticketList.get(ticketID);
                ticket.chargeMoney(money);
            }
            else {
                // T.B.D
            }
        } catch (Exception e){ 
            // Do nothing, this won't get throw exception
        }
    }
    
    public TicketController(){
        OneWayTicket ticket1 = new OneWayTicket(12346579, Station.Bercy, Station.CourSaintEmillion);
        OneWayTicket ticket2 = new OneWayTicket(12346579, Station.Bercy, Station.CourSaintEmillion);
        OneWayTicket ticket3 = new OneWayTicket(12346579, Station.Bercy, Station.CourSaintEmillion);
        OneWayTicket ticket4 = new OneWayTicket(12346579, Station.Bercy, Station.CourSaintEmillion);
        
        ticketList.add(ticket1);
        ticketList.add(ticket2);
        ticketList.add(ticket3);
        ticketList.add(ticket4);
    }
}
