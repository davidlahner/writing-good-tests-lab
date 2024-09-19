package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GildedRoseTest {

    private GildedRose testee;

    @Test
    void standardItem_SellInPast_QualityDegradesTwiceAsFast() {
        //arrange
        createTestee("A Standard Item", -1, 10);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].name).describedAs("name").isEqualTo("A Standard Item");
        assertThat(testee.items[0].sellIn).describedAs("sell in").isEqualTo(-2);
        assertThat(testee.items[0].quality).describedAs("quality").isEqualTo(8);
    }

    private void createTestee(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        testee = new GildedRose(items);
    }

}
