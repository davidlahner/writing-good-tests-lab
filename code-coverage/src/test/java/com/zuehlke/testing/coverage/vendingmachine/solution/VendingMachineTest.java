package com.zuehlke.testing.coverage.vendingmachine.solution;

import com.zuehlke.testing.coverage.vendingmachine.NoMoreChangeException;
import com.zuehlke.testing.coverage.vendingmachine.NotEnoughMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VendingMachineTest {

    @Test
    void calculateChange_orderFiveBottlesWithoutEnoughMoney_throwsNotEnoughMoneyException() {
        // arrange
        VendingMachine testee = new VendingMachine(100, 5, 10);

        // act
        NotEnoughMoneyException exception = assertThrows(NotEnoughMoneyException.class, () -> testee.calculateChange(1, 4));

        //assert
        assertThat(exception).hasMessage("Not enough money: Paid: 4, required: 5");
    }

    //No Change returned
    @Test
    void calculateChange_orderOneBottleWithExactChange_returns0Change()
            throws NoMoreChangeException, NotEnoughMoneyException {
        // arrange
        VendingMachine testee = new VendingMachine(100, 5, 10);
        // act
        int change = testee.calculateChange(1, 5);
        // assert
        assertThat(change).isEqualTo(0);
    }

    //Some Change returned
    @Test
    void calculateChange_orderOneBottleOverpaying_returnsChange()
            throws NoMoreChangeException, NotEnoughMoneyException {
        // arrange
        VendingMachine testee = new VendingMachine(100, 5, 10);
        // act
        int change = testee.calculateChange(1, 6);
        // assert
        assertThat(change).isEqualTo(1);
    }

    @Test
    void calculateChange_orderOneBottlePayingTooMuchMachineDoesntHaveChange_throwsNoMoreChangeException() {
        // arrange
        VendingMachine testee = new VendingMachine(1, 5, 10);
        // act
        NoMoreChangeException exception = assertThrows(NoMoreChangeException.class,
                () -> testee.calculateChange(1, 7));
        //assert
        assertThat(exception).hasMessage("No More Change: Vending machine ran out of 1CHF coins");
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
        assertThat(change).isEqualTo(0);
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
        assertThat(change).isEqualTo(0);
    }

    @Test
    void reducePricePerBottle_reduceTo0_buyTwoBottlesFor0_throwsNotEnoughMoneyException() {
        // arrange
        VendingMachine testee = new VendingMachine(100, 5, 10);

        // act
        testee.reducePricePerBottle(5);
        NotEnoughMoneyException exception = assertThrows(NotEnoughMoneyException.class, () -> testee.calculateChange(2, 0));

        //assert
        assertThat(exception).hasMessage("Not enough money: Paid: 0, required: 10");
    }

}
