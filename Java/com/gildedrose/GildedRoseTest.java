package com.gildedrose;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GildedRoseTest {

  @Test
  public void qualityDecresesTwiceFastWhenDatePasses() throws Exception {
    Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", -1, 20)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(-2, app.items[0].sellIn);
    assertEquals(18, app.items[0].quality);
  }

  @Test
  public void qualityOfAnItemIsNeverNegative() throws Exception {
    Item[] items = new Item[] {
            new Item("+5 Dexterity Vest", 1, 0),
            new Item("Aged Brie", 1, 0),
            new Item("Sulfuras, Hand of Ragnaros", 1, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 0)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    
    assertTrue(items[0].quality >= 0);
    assertTrue(items[1].quality >= 0);
    assertTrue(items[2].quality >= 0);
    assertTrue(items[3].quality >= 0);

  }

  @Test
  public void agedBrieIncreasesInQualityTheOlderItGets() throws Exception {
    Item[] items = new Item[] {
            new Item("Aged Brie", 1, 1)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertTrue(items[0].quality > 1);
  }

  @Test
  public void BackstagePassesIncreasesInQualityTheOlderItGets() throws Exception {
    Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 20, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10)
    };

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertTrue(items[0].quality == 11);
    assertTrue(items[1].quality == 12);
    assertTrue(items[2].quality == 13);
  }

  @Test
  public void BackstagePassesDropsToZeroQualityAfterConcert() throws Exception {
    Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 30)
    };

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertTrue(items[0].quality == 0);
  }

  @Test
  public void qualityOfAnItemIsNeverMoreThan50() throws Exception {
    Item[] items = new Item[] {
            new Item("Aged Brie", 15, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(50, app.items[0].quality);
    assertEquals(50, app.items[1].quality);

  }

  @Test
  public void sulfurasHasNeverToBeSoldOrDecreasesQuality() throws Exception {
    Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 15, 80)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(80, app.items[0].quality);

  }

  @Test
  public void normal() throws Exception {
    Item[] items = new Item[] {
      new Item("+5 Dexterity Vest", 10, 20),
      new Item("Elixir of the Mongoose", 5, 7)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(9, app.items[0].sellIn);
    assertEquals(19, app.items[0].quality);
    assertEquals(4, app.items[1].sellIn);
    assertEquals(6, app.items[1].quality);
  }

  @Test
  public void agedBrie() throws Exception {
    Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(1, app.items[0].sellIn);
    assertEquals(1, app.items[0].quality);
  }

  @Test
  public void Sulfuras() throws Exception {
    Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(0, app.items[0].sellIn);
    assertEquals(80, app.items[0].quality);
    assertEquals(-1, app.items[1].sellIn);
    assertEquals(80, app.items[1].quality);
  }

  @Test
  public void BackstagePasses() throws Exception {
    Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49)};

    GildedRose app = new GildedRose(items);
    app.updateQuality();

    assertEquals(14, app.items[0].sellIn);
    assertEquals(21, app.items[0].quality);
    assertEquals(9, app.items[1].sellIn);
    assertEquals(50, app.items[1].quality);
    assertEquals(4, app.items[2].sellIn);
    assertEquals(50, app.items[2].quality);
  }

 /* @Test
  public void conjured() {
    Item[] items = new Item[] { new Item("Conjured Mana Cake", 3, 6) };
    GildedRose app = new GildedRose(items);
    app.updateQuality();
    assertEquals(2, app.items[0].sellIn);
    assertEquals(4, app.items[0].quality);
  }*/
}
