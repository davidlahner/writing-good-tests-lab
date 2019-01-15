package com.zuehlke.testing.coverage.vendingmachine;

/**
 * A vending machine for bottles. The prize per bottle and the discount each Xth
 * bottle that is for free can be set by its public setters. The main method is
 * for calculating the change depending on the amount of money that is entered
 * and the number of bottles the client wants.
 * 
 * @author brt
 */
public class VendingMachine {

	// How much is one bottle?
	private int pricePerBottle;

	// Each Xth bottle is for free
	private int eachXthBottleForFree;

	// How many coins of 1 CHF are still in the machine?
	private int nof1CHFCoins;

	public VendingMachine(int nof1CHFCoins, int pricePerBottle, int eachXthBottleForFree) {

		this.nof1CHFCoins = nof1CHFCoins;
		this.pricePerBottle = pricePerBottle;
		this.eachXthBottleForFree = eachXthBottleForFree;
	}

	/**
	 * Method to calculate the change given by the vending machine
	 * 
	 * @param nofBottles
	 *            The number of bottles the customer wants to buy
	 * @param moneyEntered
	 *            How much money i.e. how many coins did the customer put into the
	 *            slot
	 * @return
	 * @throws NoMoreChangeException
	 * @throws NotEnoughMoneyException
	 */
	public int calculateChange(int nofBottles, int moneyEntered) throws NoMoreChangeException, NotEnoughMoneyException {

		int change = 0;

		// was enough money entered?
		if (moneyEntered > calculatePrice(nofBottles)) {

			// was more than just enough money entered
			int tooMuchPaid = (moneyEntered - calculatePrice(nofBottles));

			// Is there still enough change?
			if (tooMuchPaid > nof1CHFCoins) {
				throw new NoMoreChangeException("No More Change: Vending machine ran out of 1CHF coins");
			} else {
				// calculate the change
				change = tooMuchPaid;
			}
		} else {
			throw new NotEnoughMoneyException(
					"Not enough money: Paid: " + moneyEntered + ", required: " + calculatePrice(nofBottles));
		}
		return change;
	}

	/**
	 * Private method for calculating the price of the bottles depending on the
	 * discount.
	 * 
	 * @param nofBottles
	 * @return
	 */
	private int calculatePrice(int nofBottles) {
		int nofBottlesForFree = nofBottles % eachXthBottleForFree;
		return (nofBottles - nofBottlesForFree) * pricePerBottle;

	}

	/**
	 * Method to reduce the price per bottle
	 * 
	 * @param reduction
	 */
	public void reducePricePerBottle(int reduction) {
		if (pricePerBottle > reduction) {
			pricePerBottle -= reduction;
		}
	}

	/**
	 * Method to set the discount, how many bottles have to be bought in order to
	 * get one for free
	 * 
	 * @param each
	 *            xth bottle for free
	 */
	public void setEachXthBottleForFree(int eachXthBottleForFree) {
		this.eachXthBottleForFree = eachXthBottleForFree;
	}
}
