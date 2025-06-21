//Kathryn Evans 
//CMSC215 Programming Project 3
//November 27, 2023
//This is the main class which establishes the GUI, 
//takes input from user in GUI, 
//then creates a TripCost object from input 
//and finally populates the Total Trip Cost field in the GUI. 

import javax.swing.ComboBoxModel;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;

public class Project3 extends Application {
    private TextField tfDist = new TextField();
    private TextField tfGasCost = new TextField();
    private TextField tfGasMile = new TextField();
    private TextField tfNumDays = new TextField();
    private TextField tfHotelCost = new TextField();
    private TextField tfFoodCost = new TextField();
    private TextField tfAttractions = new TextField();
    private Button btCalc = new Button("Calculate");
    private TextField tfTotTripCost= new TextField();
    private ComboBox<String> cbDistUnit= new ComboBox<>(); //dist units as miles or km 
    private ComboBox<String> cbCostUnit= new ComboBox<>(); //gas cost as $/gal or $/liter
    private ComboBox<String> cbMileUnit= new ComboBox<>(); //mileage as mile/gal or km/liter

  @Override 
    public void start(Stage primaryStage) {

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5.5); 
        pane.setVgap(5.5); // Set vGap to 5.5px
        
        pane.add(new Label("Distance:"), 0, 0);
        pane.add(tfDist, 1, 0);
        cbDistUnit.getItems().addAll("miles", "kilometers"); 
        cbDistUnit.setValue("miles");
        pane.add(cbDistUnit, 2, 0); 

        pane.add(new Label("Gasoline Cost:"), 0, 1); 
        pane.add(tfGasCost, 1, 1);
        cbCostUnit.getItems().addAll("dollars/gallon", "dollars/liter"); 
        cbCostUnit.setValue("dollars/gallon");
        pane.add(cbCostUnit, 2, 1);  
        
        pane.add(new Label("Gas Mileage:"), 0, 2);
        pane.add(tfGasMile, 1, 2);
        cbMileUnit.getItems().addAll("miles/gallon", "kilometers/liter"); 
        cbMileUnit.setValue("miles/gallon");
        pane.add(cbMileUnit, 2, 2);  

        pane.add(new Label("Number of Days:"), 0, 3);
        pane.add(tfNumDays, 1, 3);
        pane.add(new Label("Hotel Cost:"), 0, 4);
        pane.add(tfHotelCost, 1, 4);
        pane.add(new Label("Food Cost:"), 0, 5);
        pane.add(tfFoodCost, 1, 5);
        pane.add(new Label("Attractions:"), 0, 6);
        pane.add(tfAttractions, 1, 6);
        pane.add(btCalc, 1, 7);

        btCalc.setOnAction(e -> calculateTrip());

        pane.add(new Label("Total Trip Cost:"), 0, 8);
        pane.add(tfTotTripCost, 1, 8);

        // Set properties for UI
        pane.setAlignment(Pos.CENTER);
        tfDist.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfGasMile.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumDays.setAlignment(Pos.BOTTOM_RIGHT);
        tfHotelCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfFoodCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfAttractions.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotTripCost.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotTripCost.setEditable(false);
        GridPane.setHalignment(btCalc, HPos.RIGHT);
        
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Trip Cost Estimator"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
     
    private void calculateTrip() {
        // Get values from text fields

        double distance = Double.parseDouble(tfDist.getText());
        double gasCost= Double.parseDouble(tfGasCost.getText());
        double gasMile = Double.parseDouble(tfGasMile.getText());
        int days= Integer.parseInt(tfNumDays.getText());
        double hotelCost = Double.parseDouble(tfHotelCost.getText());
        double foodCost = Double.parseDouble(tfFoodCost.getText());
        double attractions = Double.parseDouble(tfAttractions.getText());


        TripCost trip= new TripCost(distance,gasCost,gasMile,days, hotelCost, foodCost, attractions); 

        // Display total cost
        tfTotTripCost.setText(String.format("$%.2f", trip.totalTripCost()));
    }

    public static void main(String[] args){
        launch(args);

    }

}
