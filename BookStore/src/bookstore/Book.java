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
import java.util.Objects;
import javafx.scene.control.CheckBox;

public class Book {
    private String name; 
    private double price;
    private CheckBox isChecked; 
    
    Book(String name, double price){
        this.name = name;
        this.price = price;
        isChecked = new CheckBox();
    }
    
    //Setters and Getters
    
    public CheckBox getChecked(){
        return isChecked;
    }
    
    public void setChecked(Boolean value){
        
        isChecked.setSelected(value);
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public double getPrice(){
        return price;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    //comparision method for books
    @Override
    public boolean equals(Object b){
        if(this == b)
            return true;
        if(b instanceof Book){
            Book a = (Book)b;
            if(this.getName().equals(a.getName()) && this.getPrice() == a.getPrice()){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 83 * hash + (this.isChecked.isSelected() ? 1 : 0);
        return hash;
    }
    
}
