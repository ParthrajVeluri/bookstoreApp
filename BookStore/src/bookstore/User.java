/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

/**
 *
 * @author aktar
 */
public abstract class User{
    String username;
    String password;
    User(String username, String password){
        this.username = username;
        this.password = password;
    }
    public String getUsername(){
        
        return username;
    }
    public void setUsername(String s){
    this.username = s;}
    public String getPassword(){
        
        return password;
    }
    public void setPassword(String s){
    
        this.password = s;
    }    
    
}
