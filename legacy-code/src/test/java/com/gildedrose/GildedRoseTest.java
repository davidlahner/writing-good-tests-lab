package com.gildedrose;

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

    @Test
    void standardItem_SellInPast_QualityOne_QualityDoesntGoBelowZero() {
        //arrange
        createTestee("A Standard Item", -1, 1);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(-2)));
        assertThat("quality", testee.items[0].quality, is(equalTo(0)));
    }

    @Test
    void agedBrie_QualityOne_QualityIncreasesByOne() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, 5, 1);
        //act
        testee.updateQuality();
        //assert
        assertThat("name", testee.items[0].name, is(equalTo(GildedRose.AGED_BRIE)));
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(4)));
        assertThat("quality", testee.items[0].quality, is(equalTo(2)));
    }

    @Test
    void agedBrie_QualityFifty_QualityStaysConstant() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, 5, 50);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(4)));
        assertThat("quality", testee.items[0].quality, is(equalTo(50)));
    }

    @Test
    void agedBrie_SellInInPast_QualityIncreasesByTwo() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, -1, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(-2)));
        assertThat("quality", testee.items[0].quality, is(equalTo(24)));
    }

    @Test
    void agedBrie_SellInInPast_QualityIncreasesByTwoButNotOver50() {
        //arrange
        createTestee(GildedRose.AGED_BRIE, -1, 49);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(-2)));
        assertThat("quality", testee.items[0].quality, is(equalTo(50)));
    }

    @Test
    void sulfuras_SellInAndQualityDontChange() {
        //arrange
        createTestee(GildedRose.SULFURAS_HAND_OF_RAGNAROS, 5, 80);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(5)));
        assertThat("quality", testee.items[0].quality, is(equalTo(80)));
    }

    @Test
    void sulfuras_sellInInThePast_SellInAndQualityDontChange() {
        //arrange
        createTestee(GildedRose.SULFURAS_HAND_OF_RAGNAROS, -1, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(-1)));
        assertThat("quality", testee.items[0].quality, is(equalTo(22)));
    }

    @Test
    void backstagePasses_sellIn12_qualityIncreasesByOne() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 12, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(11)));
        assertThat("quality", testee.items[0].quality, is(equalTo(23)));
    }

    @Test
    void backstagePasses_sellIn10_qualityIncreasesByTwo() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 10, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(9)));
        assertThat("quality", testee.items[0].quality, is(equalTo(24)));
    }

    @Test
    void backstagePasses_sellIn9_qualityIncreasesByTwoButNotOverFifty() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 10, 49);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(9)));
        assertThat("quality", testee.items[0].quality, is(equalTo(50)));
    }

    @Test
    void backstagePasses_sellIn5_qualityIncreasesByThree() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 5, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(4)));
        assertThat("quality", testee.items[0].quality, is(equalTo(25)));
    }

    @Test
    void backstagePasses_sellIn5_qualityIncreasesByThreeButNotOverFifty() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 5, 48);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(4)));
        assertThat("quality", testee.items[0].quality, is(equalTo(50)));
    }

    @Test
    void backstagePasses_sellIn0_qualityZero() {
        //arrange
        createTestee(GildedRose.BACKSTAGE_PASSES, 0, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(-1)));
        assertThat("quality", testee.items[0].quality, is(equalTo(0)));
    }

    @Test
    void conjuredStone_sellIn10Quality6_qualityDegradesTwiceAsFast() {
        //arrange
        createTestee("Conjured Stone", 6, 22);
        //act
        testee.updateQuality();
        //assert
        assertThat("sell in", testee.items[0].sellIn, is(equalTo(5)));
        assertThat("quality", testee.items[0].quality, is(equalTo(20)));
    }

    private void createTestee(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        testee = new GildedRose(items);
    }

}
