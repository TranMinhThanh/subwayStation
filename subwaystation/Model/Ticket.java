/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subwaystation.Model;

import subwaystation.Model.Enum.State;
import subwaystation.Model.Enum.Station;

/**
 *
 * @author ThanhTM
 */
public interface Ticket {
    public Validate isTicketValidate(State state);
    public String getTicketInformation();
    public float getActualFare();
    public void chargeMoney(float money);
    public void updateTicketState(Station station);
}
