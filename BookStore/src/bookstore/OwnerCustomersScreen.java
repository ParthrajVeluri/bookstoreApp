/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author RossEnriquez
 */
public class OwnerCustomersScreen {
    public Scene getScene(ArrayList<Customer> customers, Stage primaryStage){
        /*Table of Customers*/
        ObservableList<Customer> customerList = FXCollections.observableList(customers);
        TableView<Customer> customerTable = new TableView();
        customerTable.setEditable(false);
        customerTable.setFixedCellSize(25);
        
        TableColumn usernameCol = new TableColumn("Username");
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        usernameCol.setMinWidth(primaryStage.getWidth()/3);
        TableColumn passwordCol = new TableColumn("Password");
        passwordCol.setCellValueFactory(new PropertyValueFactory<>("password"));
        passwordCol.setMinWidth(primaryStage.getWidth()/3);
        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
        pointsCol.setMinWidth(primaryStage.getWidth()/3);
       
        customerTable.setMaxHeight(primaryStage.getHeight()*3.0/4);
        customerTable.setItems(customerList);
        customerTable.getColumns().addAll(usernameCol, passwordCol, pointsCol);
        
        /*Footer to add more customers*/
        Text txtUsername = new Text("Username:");
        Text txtPassword = new Text("Password:");
        
        TextField txtFieldUsername = new TextField();
        TextField txtFieldPassword = new TextField();
        
        //Add customer button
        Button btnAddCustomer = new Button("Add");
        btnAddCustomer.setMinWidth(50);
        btnAddCustomer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                String addUsername = txtFieldUsername.getText();
                String addPassword = txtFieldPassword.getText();
                
                if(addUsername.isEmpty() || addPassword.isEmpty()){
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter a valid username/password.");
                    alert.showAndWait();
                }
                else{
                    customerList.add(new Customer(addUsername, addPassword, 0, new SilverStatus()));
                }
            }
        });
        
        //Delete customer button
        Button btnDeleteCustomer = new Button("Delete");
        btnDeleteCustomer.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                Customer selectedCustomer = customerTable.getSelectionModel().getSelectedItem();
                customerList.remove(selectedCustomer);
            }
        });
        
        Button btnBack = new Button("Back");
        
        FlowPane footer = new FlowPane();
        footer.setPadding(new Insets(10));
        footer.setMargin(txtFieldUsername, new Insets(0, 20, 0, 5));
        footer.setMargin(txtFieldPassword, new Insets(0, 20,0, 5));
        footer.setMargin(btnAddCustomer, new Insets(0, 40, 0, 0));
        footer.setMargin(btnDeleteCustomer, new Insets(10, 20, 0, 20));
        footer.setMargin(btnBack, new Insets(10, 0, 0, 0));
        footer.getChildren().addAll(txtUsername, txtFieldUsername, 
                txtPassword, txtFieldPassword, btnAddCustomer, btnDeleteCustomer,
                btnBack);
        
        /*root*/
        VBox root = new VBox();
        root.getChildren().addAll(customerTable, footer);
        Scene ownerCustomersScreen = new Scene(root);
        return ownerCustomersScreen;
    }
}
