/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subwaystation.Controller;

import java.util.List;
import subwaystation.Model.*;
import subwaystation.Model.Enum.Station;
/**
 *
 * @author ThanhTM
 */
public class TicketController {
    private List<Ticket> ticketList;
    public Validate doAction(int ticketID, Station station){
        return null;
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
}
