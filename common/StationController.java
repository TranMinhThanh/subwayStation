/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author thanhtm
 */
public class StationController {
    public static float getFare(Station start, Station end) {
        int distance = Math.abs(end.ordinal() - start.ordinal());
        double dFare = distance * 1.9;
        float fFare = (float)dFare;
        return fFare;
    }
    
    public static boolean isBetween(Station curStation, Station start, Station end) {
        if ( start.ordinal() >= end.ordinal() && curStation.ordinal() <= start.ordinal() && curStation.ordinal() >= end.ordinal() ) {
            return true;
        }
        else if ( start.ordinal() <= end.ordinal() && curStation.ordinal() >= start.ordinal() && curStation.ordinal() <= end.ordinal()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static float BASE_FARE = (float) 1.9;
}
