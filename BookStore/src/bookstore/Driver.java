/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author aktar
 */
public class Driver extends Application{
    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    Owner owner = new Owner("Admin", "Admin");
    
    
    public void read(){
        //Book reader
        try{
            FileReader bookReader = new FileReader("Books.txt");
            BufferedReader bufferedReader = new BufferedReader(bookReader);
            String line1, line2;
            
            while ((line1 = bufferedReader.readLine()) != null){
                
                if((line2 = bufferedReader.readLine()) != null &&
                   (bufferedReader.readLine()) != null){
                    
                    this.getBookList().add(new Book(line1, Double.parseDouble(line2)));
                }
                
            }
            bookReader.close();
            
        }catch(IOException e){
            
            System.out.println("An error occured.");
            e.printStackTrace();
        }catch(NumberFormatException e){
            
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        
        //Customer reader
        try{
            FileReader customerReader = new FileReader("Customers.txt");
            BufferedReader bufferedReader = new BufferedReader(customerReader);
            String line1, line2, line3, line4;
            
            while ( 
                   (line1 = bufferedReader.readLine()) != null &&
                   (line2 = bufferedReader.readLine()) != null &&
                   (line3 = bufferedReader.readLine()) != null &&
                   (line4 = bufferedReader.readLine()) != null &&
                   (bufferedReader.readLine()) != null){
                
                if(line4.equals("Silver")){
                    
                    this.getCustomerList().add(new Customer(line1, line2, Integer.parseInt(line3), new SilverStatus()));
                }else if(line4.equals("Gold")){
                    
                    this.getCustomerList().add(new Customer(line1, line2, Integer.parseInt(line3), new GoldStatus()));
                }else{
                    throw new Exception();
                }
                
            }
            customerReader.close();
            
        }catch(IOException e){
            
            System.out.println("An error occured.");
            e.printStackTrace();
        }catch(NumberFormatException e){
            
            System.out.println("An error occured.");
            e.printStackTrace();
        }catch(Exception e){
            
            System.out.println("An error Occured.");
            e.printStackTrace();
        }
    }
    
    public void write(){
        
        //Book Writer
        try{
            
            FileWriter bookWriter = new FileWriter("Books.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(bookWriter);
            
            
            for(int i=0; i<this.getBookList().size(); i++){
                
                bufferedWriter.write(this.getBookList().get(i).getName() + "\n" + this.getBookList().get(i).getPrice() + "\n" + " \n");
            }
            
            bufferedWriter.close();
            
        }catch(IOException e){
            
            System.out.println("An error occured.");
            e.printStackTrace();
            
        }
        
        //Customer Writer
        try{
            
            FileWriter customerWriter = new FileWriter("Customers.txt", false);
            BufferedWriter bufferedWriter = new BufferedWriter(customerWriter);
            
            for(int i=0; i<this.getCustomerList().size(); i++){
                
                bufferedWriter.write(this.getCustomerList().get(i).getUsername() + "\n" + 
                                     this.getCustomerList().get(i).getPassword() + "\n" +
                                     this.getCustomerList().get(i).getPoints() + "\n" +
                                     this.getCustomerList().get(i).getMembership() + "\n" + " \n");
            }
            
            bufferedWriter.close();
            
        }catch(IOException e){
            
            System.out.println("An error occured.");
            e.printStackTrace();
            
        }
    }
    
    public ArrayList<Book> getBookList(){
        return bookList;
    }
    
    public ArrayList<Customer> getCustomerList(){
        return customerList;
    } 
    // THIS FUNCTION ACTS AS THE MAIN FUNCTION OF THE JAVAFX PROGRAM
    // THIS METHOD RUNS FIRST (see the launch command in main), ALL OTHER OBJECT TYPES WILL BE CREATED WITHIN THIS PROGRAM
    @Override
    public void start(Stage primaryStage) {
        customerList.add(new Customer("User", "Pass", 700, new SilverStatus()));
        LoginScreen login = new LoginScreen();   
        Text t1 = new Text("Customer");
        Text t2 = new Text("Owner");
        
        VBox g1 = new VBox();
        VBox g2 = new VBox();
        g1.getChildren().add(t1);
        g2.getChildren().add(t2);
        
        Scene s1 = login.getScene(customerList,owner, g1, g2,primaryStage);
        
        primaryStage.setScene(s1);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    
    public void showCustomerBookScene(Stage primaryStage, Customer customer){
        
        VBox layout = new VBox();
        Text welcomeMessage = new Text("Hello " + customer.getUsername() + ". You have " + customer.getPoints() + " points. Your status is " + customer.getMembership());
        welcomeMessage.setStyle("--fx-alignment: CENTER;");
        welcomeMessage.setFont(Font.font("verdana", 14));
        layout.setPadding(new Insets(20, 10, 20, 10));
        
        
        TableView<Book> table = new TableView<Book>();
        
        
        TableColumn<Book, String> bookNameColumn = new TableColumn<Book, String>("Book Name");
        bookNameColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        bookNameColumn.setStyle("-fx-alignment: CENTER;");
        
        TableColumn<Book, Number> bookPriceColumn = new TableColumn<Book, Number>("Book Price [$CAD]");
        bookPriceColumn.setCellValueFactory(new PropertyValueFactory<Book, Number>("price"));
        bookPriceColumn.setStyle("-fx-alignment: CENTER;");
        
        
        TableColumn<Book, CheckBox> checkBoxColumn = new TableColumn<Book, CheckBox>("Select");
        checkBoxColumn.setCellValueFactory( new PropertyValueFactory<Book, CheckBox>("checked"));
        checkBoxColumn.setStyle("-fx-alignment: CENTER;");
        
        
        table.getColumns().addAll(bookNameColumn, bookPriceColumn, checkBoxColumn);
        
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        table.getItems().addAll(this.getBookList());
        
        Button buy = new Button("Buy");
        Button buyWithPoints = new Button("BUY With Points");
        Button logout = new Button("Logout");
        
        buy.setOnAction(e -> {
            //Backend inplementation
            
        });
        
        buyWithPoints.setOnAction(e -> {
            //Backend inplementation
            
        });
        
        logout.setOnAction(e -> {
            //Backend inplementation
            
        });
        
        HBox buttons = new HBox(100);
        
        buttons.getChildren().addAll(buy, buyWithPoints, logout);
        layout.getChildren().addAll(welcomeMessage, table, buttons);
        
        layout.setMargin(welcomeMessage, new Insets(0,0,0,100));
        layout.setMargin(table, new Insets(20));
        layout.setMargin(buttons, new Insets(0,0,0,90));
        table.setEditable(false);
        
        Scene testScene = new Scene(layout);
        
        primaryStage.setWidth(600);
        primaryStage.setHeight(450);
        primaryStage.setResizable(false);
        primaryStage.setScene(testScene);
        primaryStage.setTitle("Bookstore Application");
        
        primaryStage.setOnCloseRequest(e ->{
            //backend stuff
        });
        
        primaryStage.show();
    }
    
    public static void main(String[] args){
       launch(args);
       

    }
    
}
