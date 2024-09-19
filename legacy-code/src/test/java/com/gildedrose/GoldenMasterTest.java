package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class GoldenMasterTest {

    private static final String LINE_SEPARATOR = "\n";

    @Test
    void testGoldenMaster() throws IOException, URISyntaxException {
        //act
        String result = runScenario(31);
        //assert
        String expected = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("GoldenMaster.txt").toURI())));
        assertThat(result).isEqualTo(expected);
    }

    public static void main(String[] args) {
        System.out.println(runScenario(31));
    }

    private static String runScenario(int days) {
        StringBuilder builder = new StringBuilder();

        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            builder.append("-------- day ").append(i).append(" --------").append(LINE_SEPARATOR);
            builder.append("name, sellIn, quality").append(LINE_SEPARATOR);
            for (Item item : items) {
                builder.append(item).append(LINE_SEPARATOR);
            }
            builder.append(LINE_SEPARATOR);
            app.updateQuality();
        }
        return builder.toString();
    }

}
