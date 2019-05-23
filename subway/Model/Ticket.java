/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Model;

import common.Validate;
import common.State;
import common.StationState;

/**
 *
 * @author ThanhTM
 */
public interface Ticket {
    public String getTicketInformation();
    public float getActualFare();
    public void chargeMoney(float money);
    public Validate updateTicketState(Station station, StationState stationState);
    public int getTicketID();
    public State getTicketState();
    public String getBaseInformation();
    public String getTicketType();
}
