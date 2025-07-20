package Truck;

/**
 * The plus or premium truck, works as a model for truck controller and view
 * 10 storage bins, extra add-ons or shots, different brew types.
 */
public class PlusModel extends TruckModelAbstract{
	/**
	 * Constructor for regular truck.
	 */
	public PlusModel(){
		int i;
		super('P');

		numBins = 10;
		for (i = 0; i < numBins; i++){
			STORAGEBINS.add(new StorageBin());
		}
	}
}