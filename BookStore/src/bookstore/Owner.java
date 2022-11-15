/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.ArrayList;

/**
 *
 * @author aktar
 */
public class Owner extends User{
    
    Owner(String username, String password){
        super(username, password);
    }
    
    public void addCustomer(ArrayList<Customer> a, Customer c){
        a.add(c);
    }
    
    public void removeCustomer(ArrayList<Customer> a ,Customer c){
        a.remove(c);
    }
    
    public void addBook(ArrayList<Book> b, Book c){
        b.add(c);
    }
    
    public void removeBook(ArrayList<Book> b, Book c){
        b.remove(c);
    }
    
    @Override
    public String getUsername() {
        return username;
    }   

    @Override
    public void setUsername(String u){
        u = username;
    }
    
    @Override
    public String getPassword() {
        return password;
    }
    
    @Override
    public void setPassword(String p){
        p = password;
    }
    
}
