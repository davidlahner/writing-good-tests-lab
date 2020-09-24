package com.gildedrose.solutions;

import com.gildedrose.Item;
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
        assertThat(testee.items[0].name).as("name").isEqualTo("A Standard Item");
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(-2);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(8);
    }

    @Test
    void standardItem_SellInPast_QualityOne_QualityDoesntGoBelowZero() {
        //arrange
        createTestee("A Standard Item", -1, 1);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(-2);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(0);
    }

    @Test
    void agedBrie_QualityOne_QualityIncreasesByOne() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, 5, 1);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].name).as("name").isEqualTo(GildedRose.AGED_BRIE);
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(4);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(2);
    }

    @Test
    void agedBrie_QualityFifty_QualityStaysConstant() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, 5, 50);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(4);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(50);
    }

    @Test
    void agedBrie_SellInInPast_QualityIncreasesByTwo() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, -1, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(-2);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(24);
    }

    @Test
    void agedBrie_SellInInPast_QualityIncreasesByTwoButNotOver50() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, -1, 49);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(-2);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(50);
    }

    @Test
    void sulfuras_SellInAndQualityDontChange() {
        //arrange
        createTestee(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 5, 80);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(5);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(80);
    }

    @Test
    void sulfuras_sellInInThePast_SellInAndQualityDontChange() {
        //arrange
        createTestee(GildedRose.SULFURAS_HAND_OF_RAGNAROS, -1, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(-1);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(22);
    }

    @Test
    void backstagePasses_sellIn12_qualityIncreasesByOne() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 12, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(11);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(23);
    }

    @Test
    void backstagePasses_sellIn10_qualityIncreasesByTwo() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 10, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(9);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(24);
    }

    @Test
    void backstagePasses_sellIn9_qualityIncreasesByTwoButNotOverFifty() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 10, 49);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(9);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(50);
    }

    @Test
    void backstagePasses_sellIn5_qualityIncreasesByThree() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 5, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(4);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(25);
    }

    @Test
    void backstagePasses_sellIn5_qualityIncreasesByThreeButNotOverFifty() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 5, 48);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(4);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(50);
    }

    @Test
    void backstagePasses_sellIn0_qualityZero() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 0, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(-1);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(0);
    }

    @Test
    void conjuredStone_sellIn10Quality6_qualityDegradesTwiceAsFast() {
        //arrange
        createTestee("Conjured Stone", 6, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat(testee.items[0].sellIn).as("sell in").isEqualTo(5);
        assertThat(testee.items[0].quality).as("quality").isEqualTo(20);
    }

    private void createTestee(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        testee = new GildedRose(items);
    }

}
