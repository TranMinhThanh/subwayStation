/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Model;

import common.Validate;
import common.State;
import common.Station;
import common.StationController;
import common.StationState;

/**
 *
 * @author ThanhTM
 */
public class OneWayTicket implements Ticket {
    private int id;
    private State state;
    private float balance;
    private Station startStation;
    private Station endStation;
    private Station realStartStation;
    private Station realEndStation;
    
    // Constructor
    public OneWayTicket(int id, Station start, Station end){
        this.id = id;
        this.state = State.NEW;
        this.startStation = start;
        this.endStation = end;
        this.balance = StationController.getFare(start, end);
    }
    
    @Override
    public int getTicketID() {
        return id;
    }

    @Override
    public State getTicketState() {
        return state;
    }

    @Override
    public String getTicketInformation() {
        String ticketInfo = new String();
        ticketInfo += "ID: " + id + ", ";
        ticketInfo += "Balance: " + balance;
        return ticketInfo;
    }

    @Override
    public float getActualFare() {
        if (realStartStation == null || realEndStation == null) {
            return 0;
        } 
        else {
            return 5;
        }
    }

    @Override
    public void chargeMoney(float money) {
        balance += money;
    }

    @Override
    public Validate updateTicketState(Station station, StationState stationState) {
        if (state == State.NEW) {
            if (stationState == StationState.ENTER) {
                state = State.IN_STATION;
                realStartStation = station;
                return new Validate(true);
            } 
            // action = exit 
            else {
                return new Validate(false, "Ticket is not used yet");
            }
        }
        else if (state == State.IN_STATION) {
            if (stationState == StationState.EXIT) {
                realEndStation = station;
                if (this.getActualFare() <= balance){
                    state = State.DESTROYED;
                    return new Validate(true);
                } 
                else {
                    return new Validate(false, "Balance is not enough; Expected: " + getActualFare());
                }
            } else {
                return new Validate(false, "Ticket is already used");
            }           
        }
        else {
            return new Validate(false, "Ticket is destroyed");
        }
    }    
}
