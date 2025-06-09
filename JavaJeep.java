import java.util.ArrayList;

public class JavaJeep{
	private static JavaJeep javaJeepInstance = new JavaJeep();
	private final ArrayList<CoffeeTrucks> TRUCKS;
	private final ArrayList<Location> LOCATIONS;
	private int noOfTrucks;
	private static float combinedSales;

	private JavaJeep(){
		noOfTrucks = 0;
	}

	public static void main(String args[]){

	}

	public static JavaJeep getInstance(){
		return javaJeepInstance;
	}

	public void printTrucksInfo(){

	}

	public boolean createTruck(String location){

	}
}