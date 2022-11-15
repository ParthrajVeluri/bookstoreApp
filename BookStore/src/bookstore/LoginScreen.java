/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 *
 * @author parth
 */
public class LoginScreen {
    public Scene getScene(ArrayList <Customer> customers, Owner o, Parent customerScreen, Parent ownerScreen, Stage primaryStage){
        Group g1 = new Group(); 
        
        Text t1 = new Text("Password:");
        t1.setLayoutX(50);
        t1.setLayoutY(145);
        t1.setFont(new Font("verdana",14));
        
        Text t2 = new Text("Username:");
        t2.setLayoutX(50);
        t2.setLayoutY(115);
        t2.setFont(new Font("verdana",14));
        
        Text welcome = new Text("Welcome to the BookStore App");
        welcome.setLayoutX(50);
        welcome.setLayoutY(50);
        welcome.setFont(new Font("verdana",14));
        
        PasswordField pass = new PasswordField();
        pass.setMaxWidth(200);
        pass.setLayoutX(200);
        pass.setLayoutY(130);
        
        TextField user = new TextField();
        user.setMaxWidth(200);
        user.setLayoutX(200);
        user.setLayoutY(100);
        
        Button b1 = new Button("Login");
        b1.setLayoutX(175);
        b1.setLayoutY(200);
        b1.setFont(new Font("verdana",14));
        b1.setOnAction(e->{
            String username = user.getText();
            String password = pass.getText();
            for(Customer c : customers){
                if(c.getPassword().equals(password) && c.getUsername().equals(username)){
                    primaryStage.getScene().setRoot(customerScreen);
                }
            }
            if(o.getPassword().equals(password) && o.getUsername().equals(username)){
                primaryStage.getScene().setRoot(ownerScreen);
            }
        });
        
        g1.getChildren().add(pass);
        g1.getChildren().add(user);
        g1.getChildren().add(b1);
        g1.getChildren().add(t1);
        g1.getChildren().add(t2);
        g1.getChildren().add(welcome);
        Scene loginPg = new Scene(g1, 400, 250);
        
        return loginPg; 
    }
}
