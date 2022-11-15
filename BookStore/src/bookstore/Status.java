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
public abstract class Status {
    private String status;
    abstract String getStatus(); //does this need to be abstract? It'll return status anyway 
    //Parthraj: Yea it needs to be abstract because both classes which extend this need to override this method
    
    public Status(String s){
        status = s;
    };
}
