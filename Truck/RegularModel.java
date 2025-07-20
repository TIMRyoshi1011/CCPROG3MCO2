package Truck;

/**
 * The regular truck, works as a model for truck controller and view
 * 8 storage bins, no extra add-ons or shots, only standard brew.
 */
public class RegularTruck extends TruckModelAbstract{
	/**
	 * Constructor for regular truck.
	 */
	public RegularTruck(){
		int i;
		super('R');

		numBins = 8;
		for (i = 0; i < numBins; i++){
			STORAGEBINS.add(new StorageBin());
		}
	}
}