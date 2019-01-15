package com.zuehlke.testing.basics.example;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ShoppingBasket2Test {

	private ShoppingBasket shoppingBasket = new ShoppingBasket();

	@Test
	public void testGetItemCount_ShoppingBasketEmpty_0() {
		// given

		// when
		int count = shoppingBasket.getItemCount();

		// then
		assertThat("Basket is empty", count, is(equalTo(0)));
	}

	@Test
	public void testGetItemCount_ShoppingBasketHasItem_1() {
		// arrange
		shoppingBasket.addItem("Book");

		// act
		// assert
		assertThat(shoppingBasket.getItemCount(), is(equalTo(1)));
	}

	private class ShoppingBasket {
		private List<String> items = new ArrayList<>();

		public void addItem(String item) {
			items.add(item);
		}

		public int getItemCount() {
			return items.size();
		}

	}
}
