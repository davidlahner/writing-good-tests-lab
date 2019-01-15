package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class TextTestFixture {

    @Test
    void testGoldenMaster() throws IOException, URISyntaxException {
        //act
        String result = runScenario(5);
        //assert
        String expected = new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource("GoldenMaster.txt").toURI())));
        assertThat(result, is(equalTo(expected)));
    }

    static void main(String[] args) {
        int days = 5;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }
        System.out.println(runScenario(days));
    }

    private static String runScenario(int days) {
        StringBuilder builder = new StringBuilder();
        builder.append("OMGHAI!").append(System.lineSeparator());

        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        for (int i = 0; i < days; i++) {
            builder.append("-------- day ").append(i).append(" --------").append(System.lineSeparator());
            builder.append("name, sellIn, quality").append(System.lineSeparator());
            for (Item item : items) {
                builder.append(item).append(System.lineSeparator());
            }
            builder.append(System.lineSeparator());
            app.updateQuality();
        }
        return builder.toString();
    }

}
