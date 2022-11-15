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
public class SilverStatus extends Status{
    public SilverStatus(){
        super("Silver");
    }
    
    @Override
    public String getStatus(){
        /*NOTE HERE: is it necessary to have the status variable in Status class?
        if that's the case, then getStatus() shouldn't be abstract since it would
        return the same variable (status) anyway no matter which Status class is used*/
       
        /*Parthraj: No it wouldnt return the same variable because remember everytime u create a SilverStatus, there will be a unique 
        status class associated with silverStatus thats created. When u create goldStatus the same thing happens. So the Status associated with gold superclass 
        is different than the Status associated with silverStatus.Also when u return, return the Status variable not the raw String value as returning just the 
        String defeats the whole purpose of having the abstract class. */ 
        return "Silver";
    }
}
