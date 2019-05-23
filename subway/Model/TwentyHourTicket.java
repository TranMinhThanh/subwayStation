/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Model;

import common.Validate;
import common.State;
import common.StationState;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ThanhTM
 */
public class TwentyHourTicket implements Ticket{
    private int id;
    private State state;
    private Date startTime;
    private DateFormat dateFormat;

    public TwentyHourTicket(int id) {
        this.id = id;
        this.state = State.NEW;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    }
    
    private Date getEndTime(){
        if (startTime == null) {
            return null;
        } else {
            Date endTime = new Date(startTime.getTime() + 1*24*60*60*1000);
            return endTime;
        }
    }
    
    @Override
    public String getTicketInformation() {
        String ticketInfo = new String();
        ticketInfo += "ID: " + id;
        if (startTime != null) {    
            ticketInfo += ", valid until " + dateFormat.format(getEndTime());
        }
        return ticketInfo;
    }

    @Override
    public float getActualFare() {
        // DO nothing
        return -1;
    }

    @Override
    public void chargeMoney(float money) {
        // Do nothing
    }

    @Override
    public Validate updateTicketState(Station station, StationState action) {
        if (state == State.NEW) {
            if (action == StationState.EXIT) {
                return new Validate(false, "Ticket is not used yet");
            }
            if (startTime != null) {
                long currentTime = System.currentTimeMillis();
                if (getEndTime().getTime() >= currentTime) {
                    state = State.IN_STATION;
                    return new Validate(true);
                }
                else {
                    return new Validate(false, "Expired: Try to enter at " + dateFormat.format(new Date(currentTime)));
                }
            } 
            else {
                state = State.IN_STATION;
                startTime = new Date(System.currentTimeMillis());
                return new Validate(true);
            }
        }
        else if (state == State.IN_STATION) {
            if (action == StationState.ENTER) {
                return new Validate(false, "Ticket is already used");
            }
            else if (System.currentTimeMillis() < getEndTime().getTime()){
                state = State.NEW;
                return new Validate(true);
            } 
            else {
                state = State.DESTROYED;
                return new Validate(true);
            }
        }
        else {
            return new Validate(false, "Ticket is destroyed");
        }
    }

    @Override
    public int getTicketID() {
        return this.id;
    }

    @Override
    public State getTicketState() {
        if (System.currentTimeMillis() < getEndTime().getTime()){
            state = State.DESTROYED;
        }
        return state;
    }

    @Override
    public String getBaseInformation() {
        if (state == State.NEW) {
            return "24h tickets: " + state;
        }
        else {
            return "24h tickets: Valid util " + dateFormat.format(getEndTime());
        }
    }

    @Override
    public String getTicketType() {
        return "24h ticket";
    }
    
}
