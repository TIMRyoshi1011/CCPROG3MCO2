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
		this.STORAGEBINS = new ArrayList<>();
	        this.TRANSACTIONS = new ArrayList<>();
	
	        for (int i = 0; i < 3; i++) {
	            STORAGEBINS.add(new StorageBin());
	        }
	}

	public boolean fillStorageBin(int storageBinIndx){
		if (index >= 0 && index < STORAGEBINS.size()) {
	            return STORAGEBINS.get(storageBinIndx).setBin("coffee", 100);
	        }
	
	        return false;
	}

	public boolean setType(char type) {
		TRUCK_TYPE = type;
		return true;
    	}

	public boolean setLocation(String location) {
		this.truckLocation = location;
		return true;
	}
	
	public ArrayList<Character> returnMenu() {
		return menu;
	}
	
	public void simulateSale() {
		Transaction t = new Transaction("Latte", 'M');
		moneyEarned += t.getPrice();
		TRANSACTIONS.add(t);
	}
	
	public void printTruckInfo() {
		System.out.println("Truck at: " + truckLocation + " | Earned: " + moneyEarned);
	}
}
