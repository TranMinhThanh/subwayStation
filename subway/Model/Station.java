/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subway.Model;

/**
 *
 * @author ThanhTM
 */
public class Station {
    private String name;
    private int position;
    
    public Station(String name, int pos){
        this.name = name;
        this.position = pos;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getPosition(){
        return this.position;
    }
}
