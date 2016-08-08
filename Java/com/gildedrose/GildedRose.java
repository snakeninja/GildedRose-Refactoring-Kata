package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

  public void updateQuality(){
    for (Item item : items){
      if(item.name.equals("Sulfuras, Hand of Ragnaros")){
        
      }
      else if(item.name.equals("Aged Brie")){
        item.sellIn = item.sellIn - 1;
        if( item.quality < 50) {
          item.quality = item.quality + 1;
        }
      }
      else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
        if( item.quality < 50) {
          if(item.sellIn > 10)
            item.quality = item.quality + 1;
          if( item.sellIn <= 10 && item.sellIn > 5)
            item.quality = item.quality + 2;
          if( item.sellIn <= 5 && item.sellIn > 0)
            item.quality = item.quality + 3;
          if( item.sellIn <= 0)
            item.quality = 0;
        }
        if (item.quality >50)
          item.quality = 50;
  
        item.sellIn = item.sellIn - 1;
      }
      else {
        if ( item.sellIn < 0 )
          if ( item.quality > 0 )
            item.quality= item.quality - 1;
        
        item.sellIn = item.sellIn - 1;
        if ( item.quality > 0 )
          item.quality= item.quality - 1;
      }
    }
  }

    /*
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
    */
}
