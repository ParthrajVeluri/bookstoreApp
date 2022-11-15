/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author parth
 */
public class CustomerCostScreen {
    public Scene getScene(Customer c, Stage primaryStage, Parent nextScene){
        Group g1 = new Group();
        
        String output = "Total Cost: " + c.getShoppingCart().calculateTotalCost() + "\n"
                + "Points: " + c.getPoints() + "\nStatus: " + c.getMembership();
        Text t1 = new Text(output);
        t1.setFont(new Font("verdana", 16));
        t1.setX(50);
        t1.setY(40);
        
        Button b1 = new Button("Logout");
        b1.setFont(new Font("verdana", 12));
        b1.setLayoutX(80);
        b1.setLayoutY(100);
        b1.setOnAction(e -> {
            primaryStage.getScene().setRoot(nextScene);
        });
        
        g1.getChildren().add(t1);
        g1.getChildren().add(b1);
        
        Scene costScreen = new Scene(g1, 200, 150);
        costScreen.windowProperty();
        return costScreen;
    }
}
