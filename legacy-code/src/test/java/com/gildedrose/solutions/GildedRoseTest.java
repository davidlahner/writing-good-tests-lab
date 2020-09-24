package com.gildedrose.solutions;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GildedRoseTest {

    private GildedRose testee;

    @Test
    void standardItem_SellInPast_QualityDegradesTwiceAsFast() {
        //arrange
        createTestee("A Standard Item", -1, 10);
        //act
        testee.updateQuality();
        //assert
        assertThat("name", testee.items[0].name, is(equalTo("A Standard Item")));
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(-2)));
        assertThat("quality", testee.items[0].quality, is(equalTo(8)));
    }

    private void createTestee(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        testee = new GildedRose(items);
    }

}
