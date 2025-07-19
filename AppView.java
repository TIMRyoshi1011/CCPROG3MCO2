/**
 * View for the main app interface
 */
public class AppView {

	/**
  	 * Prints the info of all trucks.
    	 */
	public void printTrucksInfo(ArrayList<CoffeeTruck> TRUCKS TRUCKS){
		for (CoffeeTruck truck : TRUCKS) {
	            truck.printTruckInfo();
	        }
	}

	/**
	 * Prints the main menu of the app.
	 */
	public void printMain(){
		clear();
		System.out.println("Welcome to JavaJeeps!\n");
		System.out.println("Select an Option:");
		System.out.println("1 - Create a coffee truck");
		System.out.println("2 - Simulate a coffee truck");
		System.out.println("3 - Dashboard");
		System.out.println("4 - Exit");
		System.out.println("");
		System.out.print(">> ");
	}

	public void printFeedback(String feedback){
		System.out.println(feedback);
	}

	/**
	 * Clears the console, for clarity purposes.
	 */
	public static void clear(){
		try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console: " + e.getMessage());
        }
	}
}