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
public class Customer extends User{ //extend User when done
    private int points;
    private Status membership;
    private Cart shoppingCart;
    
    public Customer(String username, String password, int points, Status status){
        
        super(username, password);
        this.points = points;
        this.membership = status;
        this.shoppingCart = new Cart();
    }
    
    public int getPoints(){
        return points;
    }
    
    public String getMembership(){
        return membership.getStatus();
    }
    
    public void setPoints(int p){
        points = p;
    }
    
    public void updatePoints(double price, boolean redeemingPoints){
        int gain = (int)price*10; //price is casted to int to floor value
        int cost = (int)price*100;
        
        //verify the math
        if(redeemingPoints){  
            if(points < cost)
                points = (cost-points)/10;
            else
                points -= cost;
        }
        else
            points += gain;
        
        updateMembership();
    }
    
    public void updateMembership(){
        if(points < 1000 && membership.getStatus().equals("Gold"))
            membership = new SilverStatus(); //downgrade status
        else if(points >= 1000 && membership.getStatus().equals("Silver"))
            membership = new GoldStatus(); //upgrade status
        //don't update if not needed (else)
    }
    
    /*SHOPPING */
    //this method doesn't have to take any parameters, since we can use our Cart object
    //i replaced the parameters with a boolean to determine whether or not we are buying
    //books with points
    public void buyBooks(boolean redeemingPoints){
        double price = shoppingCart.calculateTotalCost();
        updatePoints(price, redeemingPoints);
    }
    
    public Cart getShoppingCart(){
        return shoppingCart; //we might have to clone this
    }
    
    
    @Override
    public String toString(){
        String result = "";
        
        return result;
    }
}
