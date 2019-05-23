/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

/**
 *
 * @author ThanhTM
 */
public class Validate {
    private boolean isValidate;
    private String reason;
    
    public Validate (boolean isValidate, String reason) {
        this.isValidate = isValidate;
        this.reason = reason;
    }
    public Validate (boolean isValidate) {
        this.isValidate = isValidate;
    }
    
    public void setIsValidate(boolean isValidate){
        this.isValidate = isValidate;
    }
    public boolean getIsValidate(){
        return this.isValidate;
    }
    
    public void setReason(String reason){
        this.reason = this.reason;
    }
    public String getReason(){
        return this.reason;
    }
}
