package Truck;

import StorageBin.*;
/**
 * The regular truck, works as a model for truck controller and view
 * 8 storage bins, no extra add-ons or shots, only standard brew.
 */
public class RegularModel extends TruckModelAbstract{
	/**
	 * Constructor for regular truck.
	 */
	public RegularModel(){
		super('R');
		int i;

		numBins = 8;
		for (i = 0; i < numBins; i++){
			STORAGEBINS.add(new StorageBin());
		}
	}
}