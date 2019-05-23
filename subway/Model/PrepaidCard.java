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
public class PrepaidCard implements Ticket{
    private int id;
    private State state;
    private float balance;
    private Station startStation;
    private Station endStation;
    
    public PrepaidCard (int ID, float balance){
        this.id = ID;
        this.balance = balance;
        this.state = State.NEW;
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
        if (startStation == null || endStation == null) {
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
    public Validate updateTicketState(Station station, StationState action) {        
        if (state == State.NEW) {
            if (action == StationState.EXIT) {
                return new Validate(false, "Ticket is not used yet");
            }
            if (balance <= StationController.BASE_FARE) {
                return new Validate(false, "Balance is not enough");
            }
            else {
                state = State.IN_STATION;
                startStation = station;
                return new Validate(true);
            }
        }
        else if (state == State.IN_STATION) {
            if (action == StationState.ENTER) {
                return new Validate(false, "Ticket is already used");
            }
            endStation = station;
            if (this.getActualFare() <= balance){
                balance -= this.getActualFare();
                state = State.NEW;
                return new Validate(true);
            } 
            else {
                return new Validate(false, "Balance is not enoug");
            }
        }
        else {
            // Not happens
            return new Validate(false, "Ticket is destroyed");
        }
    }    
}
