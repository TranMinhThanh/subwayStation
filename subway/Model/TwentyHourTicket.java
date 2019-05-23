/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Model;

import common.Validate;
import common.State;
import common.StationState;
import java.util.Date;

/**
 *
 * @author ThanhTM
 */
public class TwentyHourTicket implements Ticket{
    private int id;
    private State state;
    private Date startTime;
    private Date endTime;

    @Override
    public String getTicketInformation() {
        String ticketInfo = new String();
        ticketInfo += "ID: " + id + ", ";
        ticketInfo += "valid until " + endTime;
        return ticketInfo;
    }

    @Override
    public float getActualFare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void chargeMoney(float money) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Validate updateTicketState(Station station, StationState action) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTicketID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getTicketState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getBaseInformation() {
        return "24h tickets: " + state;
    }

    @Override
    public String getTicketType() {
        return "24h ticket";
    }
    
}
