/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author RossEnriquez
 */
public class GoldStatus extends Status{
    public GoldStatus(){
        super("Gold");
    }
    
    @Override
    public String getStatus(){
        /*NOTE HERE: is it necessary to have the status variable in Status class?
        if that's the case, then getStatus() shouldn't be abstract since it would
        return the same variable (status) anyway no matter which Status class is used*/
        return "Gold";
    }
}
