package com.gildedrose;

class GildedRose {


    public enum Product {
        AGED_BRIE,
        SULFURAS_HAND_OF_RAGNAROS,
        BACKSTAGE_PASSES,
        CONJURED_ITEM,
        OTHER_ITEM;
    }

    private static final int MAXIMUM_QUALITY = 50;
    static final String AGED_BRIE = "Aged Brie";
    static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            Product product = determineProduct(item.name);
            if (product == Product.AGED_BRIE || product == Product.BACKSTAGE_PASSES) {
                increaseQualityForAgedBrieAndBackstagePasses(item, product);
            } else {
                if (item.quality > 0) {
                    switch (product) {
                        case OTHER_ITEM:
                            item.quality = item.quality - 1;
                            break;
                        case CONJURED_ITEM:
                            item.quality = item.quality - 2;
                            break;
                    }
                }
            }

            if (product != Product.SULFURAS_HAND_OF_RAGNAROS) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                switch (product) {
                    case AGED_BRIE:
                        if (item.quality < MAXIMUM_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                        break;
                    case BACKSTAGE_PASSES:
                        item.quality = 0;
                        break;
                    case SULFURAS_HAND_OF_RAGNAROS:
                        //Quality doesn't change
                        break;
                    default:
                        if (item.quality > 0) {
                            item.quality = item.quality - 1;
                        }
                }
            }
        }
    }

    private void increaseQualityForAgedBrieAndBackstagePasses(Item item, Product product) {
        if (item.quality < MAXIMUM_QUALITY) {
            item.quality = item.quality + 1;

            if (product == Product.BACKSTAGE_PASSES) {
                if (item.sellIn < 11) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }

                if (item.sellIn < 6) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private Product determineProduct(String name) {
        if (name.startsWith("Conjured")) {
            return Product.CONJURED_ITEM;
        }
        switch (name) {
            case AGED_BRIE:
                return Product.AGED_BRIE;
            case SULFURAS_HAND_OF_RAGNAROS:
                return Product.SULFURAS_HAND_OF_RAGNAROS;
            case BACKSTAGE_PASSES:
                return Product.BACKSTAGE_PASSES;
            default:
                return Product.OTHER_ITEM;
        }
    }
}