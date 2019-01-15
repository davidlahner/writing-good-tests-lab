package com.zuehlke.testing.coverage.vendingmachine.solution;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.zuehlke.testing.coverage.vendingmachine.NoMoreChangeException;
import com.zuehlke.testing.coverage.vendingmachine.NotEnoughMoneyException;

class VendingMachineTest {

	@Test
	void calculateChange_orderFiveBottlesWithoutEnoughMoney_throwsNotEnoughMoneyException() {
		// arrange
		VendingMachine testee = new VendingMachine(100, 5, 10);

		// act
		NotEnoughMoneyException exception = assertThrows(NotEnoughMoneyException.class, () -> testee.calculateChange(1, 4));

		//assert
		assertThat(exception.getMessage(), is(equalTo("Not enough money: Paid: 4, required: 5")));
	}

	@Test
	void calculateChange_orderOneBottleWithExactChange_returns0Change()
			throws NoMoreChangeException, NotEnoughMoneyException {
		// arrange
		VendingMachine testee = new VendingMachine(100, 5, 10);

		// act
		int change = testee.calculateChange(1, 5);

		// assert
		assertThat(change, is(equalTo(0)));
	}

	@Test
	void calculateChange_orderOneBottlePayingTooMuchMachineDoesntHaveChange_throwsNoMoreChangeException() {
		// arrange
		VendingMachine testee = new VendingMachine(1, 5, 10);

		// act
		NoMoreChangeException exception = assertThrows(NoMoreChangeException.class, () -> testee.calculateChange(1, 7));

		//assert
		assertThat(exception.getMessage(), is(equalTo("No More Change: Vending machine ran out of 1CHF coins")));
	}

	@Test
	void setEachXthBottleForFree_everyBottleFree_getTwoBottlesForFree()
			throws NoMoreChangeException, NotEnoughMoneyException {
		// arrange
		VendingMachine testee = new VendingMachine(100, 5, 10);

		// act
		testee.setEachXthBottleForFree(1);
		int change = testee.calculateChange(2, 0);

		// assert
		assertThat(change, is(equalTo(0)));
	}

	@Test
	void reducePricePerBottle_reduceTo1_priceAdjusted_buyTwoBottlesFor2()
			throws NoMoreChangeException, NotEnoughMoneyException {
		// arrange
		VendingMachine testee = new VendingMachine(100, 5, 10);

		// act
		testee.reducePricePerBottle(4);
		int change = testee.calculateChange(2, 2);

		// assert
		assertThat(change, is(equalTo(0)));
	}

	@Test
	void reducePricePerBottle_reduceTo0_buyTwoBottlesFor0_throwsNotEnoughMoneyException() {
		// arrange
		VendingMachine testee = new VendingMachine(100, 5, 10);

		// act
		testee.reducePricePerBottle(5);
		NotEnoughMoneyException exception = assertThrows(NotEnoughMoneyException.class, () -> testee.calculateChange(2, 0));

		//assert
		assertThat(exception.getMessage(), is(equalTo("Not enough money: Paid: 0, required: 10")));
	}

}
