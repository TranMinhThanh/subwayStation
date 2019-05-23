/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Controller;

import java.util.ArrayList;
import java.util.List;
import subway.Model.Station;

/**
 *
 * @author ThanhTM
 */
public class StationController {
    private static List<Station> stationList;
      
    // Controller
    public StationController() {
        this.stationList = new ArrayList<>();
        Station station;
        station = new Station("Saint Lazare", 1);
        stationList.add(station);
        station = new Station("Madeleine", 2);
        stationList.add(station);
        station = new Station("Pyramides", 3);
        stationList.add(station);
        station = new Station("Chatelet", 4);
        stationList.add(station);
        station = new Station("Gare De Lyon", 5);
        stationList.add(station);
        station = new Station("Bercy", 6);
        stationList.add(station);
        station = new Station("Cour Saint Emillion", 7);
        stationList.add(station);
        station = new Station("Bibliotheque Francois Mitterrand", 8);
        stationList.add(station);
        station = new Station("Olympiades", 9);
        stationList.add(station);
    }
    
    public static float getFare(Station start, Station end) {
        int distance = Math.abs(end.getPosition()- start.getPosition());
        double dFare = distance * 1.9;
        float fFare = (float)dFare;
        return fFare;
    }
    
    public static boolean isBetween(Station curStation, Station start, Station end) {
        if ( start.getPosition() >= end.getPosition() && curStation.getPosition() <= start.getPosition() && curStation.getPosition() >= end.getPosition() ) {
            return true;
        }
        else return start.getPosition() <= end.getPosition() && curStation.getPosition() >= start.getPosition() && curStation.getPosition() <= end.getPosition();
    }
    
    public static List<String> getAllStation() {
        List<String> stationName = new ArrayList<>();
        for (Station station: stationList) {
            stationName.add(station.getName());
        } 
        return stationName;
    }
    
    public static Station getStationByName(String name) {
        for (Station station: stationList) {
            if (station.getName() == name) {
                return station;
            }
        }
        return null;
    }
    
    public static float BASE_FARE = (float) 1.9;
}
