package com.zuehlke.testing.basics.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketTest {

    private final ShoppingBasket testee = new ShoppingBasket();

    @Test
    public void testGetItemCount_ShoppingBasketEmpty_0() {
        // given

        // when
        int count = testee.getItemCount();

        // then
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void testGetItemCount_ShoppingBasketHasItem_1() {
        // arrange
        testee.addItem("Book");

        // act
        int count = testee.getItemCount();

        // assert
        assertThat(count).isEqualTo(1);
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
