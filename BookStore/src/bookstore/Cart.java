package bookstore;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Book> booksInCart = new ArrayList<Book>();
    private double totalCost;
    
    public Cart(){
        totalCost = 0;        
    }
    
    //returns all the books in the cart
    public ArrayList<Book> getBooksInCart(){ 
        return booksInCart;
    }
    
    //adds a specified book into the cart
    public void addBookInCart(Book b){
        booksInCart.add(b);
    }
    
    //returns the sum of the cost of all books in the cart
    public double calculateTotalCost(){
        for(Book n:booksInCart){
            totalCost += n.getPrice();
        }
        return totalCost;
    }
    
    //removes a specified book in cart
    public void removeBookInCart(Book b){
        booksInCart.remove(b);
    }
}
