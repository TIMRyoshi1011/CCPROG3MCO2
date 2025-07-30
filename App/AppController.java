package App;

import Truck.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/**
 * Controller for the main app interface.
 */
public class AppController {
    /** Model for main app interface. */
    private AppModel model;
    /** View for main app interface. */
    private AppView view;
    /** Scanner to be used throughout the whole app implementation. */
    private Scanner scan = new Scanner(System.in);

    /** A temporary truck used when making a new truck. */
    private TruckController tempTruck;
    /** Boolean used within checking of lambda expressions */
    private boolean success;

    /**
     * Constructor for the AppController.
     * @param model The model of the controller.
     * @param view the view of the controller.
     */
    public AppController (AppModel model, AppView view){
        this.model = model;
        this.view = view;
    }

    /**
     * The main menu of the whole app. It lets the user pick between the different app functions.
     */
    public void mainMenu(){
        ActionListener[] actions = new ActionListener[4];

        actions[0] = e -> createTruck(); 
        actions[1] = e -> simulateTruck(); 
        actions[2] = e -> dashboard(); 
        actions[3] = e -> {
            view.setOutput("Thank you for using JavaJeeps!");
            System.exit(0); 
        };

        view.showMainMenu(actions); 
    }

    /**
     * Called when the user wants to create a new truck.
     */
    public void createTruck(){
        String choice; int intChoice;
        boolean success = false, inptCheck, end;

        /* Set truck type */
        ActionListener[] actions = new ActionListener[2];

        actions[0] = e -> {
            setTruckType('P');
            setTruckLocation(tempTruck);
            tempTruck.setBins();
        };
        actions[1] = e -> {
            setTruckType('R');
            setTruckLocation(tempTruck);
            tempTruck.setBins();
        };

        view.showSetType(actions);
        
    }

    /**
     * Simulates a truck. When choosing to simulate a truck, the user can: 
     * - Simulate a sale
     * - View truck informaiton
     * - Restock bins and perform maintenance.
     */
    public void simulateTruck(){
        String choice;
        boolean end = false, exitTruck = true;
        int truckIndx, intChoice;

        do{
            /* Selecting a truck to simulate */
            view.printTruckOptions(model.getTrucks());
            choice = scan.nextLine();
            truckIndx = model.toInt(choice) - 1;

            if (choice.equalsIgnoreCase("END")) end = true;
            else if (truckIndx < 0) view.printFeedback("Please check your input!");
            else exitTruck = false;

            while (!exitTruck){

                /* Selecting what to do with chosen truck. */
                view.printSimulateOptions();
                choice = scan.nextLine();
                intChoice = model.toInt(choice);

                switch(intChoice){
                    case 1:
                        model.getTruck(truckIndx).simulateSale();
                        break;
                    case 2:
                        // print info
                        model.getTruck(truckIndx).truckFullInfo();
                        scan.nextLine();
                        break;
                    case 3:
                        // restock storage bins
                        model.getTruck(truckIndx).setBins();
                        break;
                    case 4:
                        // set maintenance
                        truckMaintenance(model.getTruck(truckIndx));
                        break;
                    case 5:
                        // exit
                        exitTruck = true;
                        break;
                    default:
                        view.printFeedback("Please check your input!");
                }

            }
        } while(!end);
    }

    /**
     * Provides a birds-eye view of all trucks.
     */
    public void dashboard(){
        boolean end = false;
        String choice;
        int truckIndx, i;

        do {
            view.printDashboard(model.getTrucks(), model.getTotalIngredients(), 
                model.getTotalEarnings(), model.getTotalTransactionTypes());

            view.printFeedback("Is there a specific truck you'd like to see? (y/n)");
            choice = scan.nextLine();

            switch(choice.toLowerCase().charAt(0)){
                case 'y': 
                    view.printTruckOptions(model.getTrucks());
                    choice = scan.nextLine();
                    truckIndx = model.toInt(choice);

                    if (truckIndx >= 0 && truckIndx < model.getNumTrucks()){
                        model.getTruck(truckIndx).truckFullInfo(); scan.nextLine();
                    }
                    else view.printFeedback("Truck index is not valid.");
                    
                case 'n': end = true; break;
                default: {view.printFeedback("Please check your input"); scan.nextLine(); break;}
            }
        } while (!end);

    }

    /**
     * Initializes tempTruck and sets its location
     * @param type The type of the truck.
     */
    public void setTruckType(char type){
        tempTruck = new TruckController(type, view);
    }

    /**
     * Sets the location of a truck
     * @param truck truck being edited
     */
    public void setTruckLocation(TruckController truck){
        view.showSetLocation(e -> {
            JButton source = (JButton) e.getSource();
            String location = (String) source.getClientProperty("location");

            success = model.setLocation(truck, location);
            if (!success) {
                view.setOutput("There's already a truck here!");
            }
            else view.setOutput("Truck location set to: " + location);
        });
    }

    /**
     * Controls the app when the prices are being edited.
     */
    public void editPrices(){
        String choice, choice2;
        float floatChoice;
        boolean success, end = false;

        while (!end){
            view.printSetPrice();
            choice = scan.nextLine();

            if (choice.toUpperCase().equals("END")) end = true;
            else{
                view.printFeedback("Enter the new price: (THIS IS EFFECTIVE FOR ALL TRUCKS)");
                choice2 = scan.nextLine();
                floatChoice = model.toFloat(choice2);
                success = model.setPrice(choice, floatChoice);

                if (success) view.printFeedback("Price successfully changed!");
                else view.printFeedback("Please check your input...");

                scan.nextLine();
            }
        }   
    }

    /**
     * Maintain the truck. Change it's location or prices.
     * @param truck truck being maintained
     */
    public void truckMaintenance(TruckController truck){
        boolean end = false;
        String choice; int intChoice;

        while (!end){
            view.printMaintenanceSelect();
            choice = scan.nextLine();

            intChoice = AppModel.toInt(choice);
            if (intChoice == 1) setTruckLocation(truck);
            else if (intChoice == 2) editPrices();
            else if (intChoice == 3) end = true;
            else view.printFeedback("Please check your input.");
        }
    }
}