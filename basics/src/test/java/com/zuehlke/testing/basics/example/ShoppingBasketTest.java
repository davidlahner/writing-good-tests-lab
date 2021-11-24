package com.zuehlke.testing.basics.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ShoppingBasketTest {

    private final ShoppingBasket testee = new ShoppingBasket();

    @Test
    public void testGetItemCount_ShoppingBasketEmpty_0() {
        // given

        // when
        int count = testee.getItemCount();

        // then
        assertThat("Basket is empty", count, is(equalTo(0)));
    }

    @Test
    public void testGetItemCount_ShoppingBasketHasItem_1() {
        // arrange
        testee.addItem("Book");

        // act
        int count = testee.getItemCount();

        // assert
        assertThat("Basket contains item", count, is(equalTo(1)));
    }

    private static class ShoppingBasket {
        private final List<String> items = new ArrayList<>();

        public void addItem(String item) {
            items.add(item);
        }

        public int getItemCount() {
            return items.size();
        }

    }
}
