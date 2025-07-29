package Truck;

import StorageBin.*;
/**
 * The plus or premium truck, works as a model for truck controller and view
 * 10 storage bins, extra add-ons or shots, different brew types.
 */
public class PlusModel extends TruckModelAbstract{
	/**
	 * Constructor for regular truck.
	 */
	public PlusModel(){
		super('P');
		int i;

		numBins = 10;
		for (i = 0; i < numBins; i++){
			STORAGEBINS.add(new StorageBin(i));
		}
	}
}