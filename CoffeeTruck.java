import java.util.ArrayList;

public class CoffeeTruck(){
	private char truckType;
	private String truckLocation;
	private float moneyEarned;
	private final ArrayList<Transaction> TRANSACTIONS;
	private final ArrayList<StorageBin> STORAGEBINS;

	public CoffeeTruck(String location){
		this.truckLocation = location.toString();
		this.moneyEarned = 0;
	}

	public boolean fillStorageBin(){
		if(STORAGEBINS.isEmpty()) // not sure about this
			return true;

		else
			return false;
	}

	public void simulateSale(){
		/*
		Example:
		>>> Preparing Medium Cup...
		>>> Brewing Standard espresso - 1.49 grams of coffee...
		>>> Adding Milk...
		>>> Cappuccino Done!
		 */
	}

	public void printTruckInfo(){
		System.out.println("Truck Type: " + truckType);
	        System.out.println("Truck Location: " + truckLocation);
	        System.out.println("Money Earned: $" + moneyEarned);
	}
}
