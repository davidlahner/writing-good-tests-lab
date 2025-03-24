package com.zuehlke.testing.basics.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ShoppingBasket2Test {

	private ShoppingBasket shoppingBasket = new ShoppingBasket();

	@Test
	public void testGetItemCount_ShoppingBasketEmpty_0() {
		// given

		// when
		int count = shoppingBasket.getItemCount();

		// then
		assertThat(count).isEqualTo(0);
	}

	@Test
	public void testGetItemCount_ShoppingBasketHasItem_1() {
		// arrange
		shoppingBasket.addItem("Book");

		// act
		// assert
		assertThat(shoppingBasket.getItemCount()).isEqualTo(1);
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
