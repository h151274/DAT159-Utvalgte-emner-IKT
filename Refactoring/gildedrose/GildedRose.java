package dat159.gildedrose;

class GildedRose {
	Item[] items;
	public final static String SULFURAS = "Sulfuras, Hand of Ragnaros";
	public final static String BRIE = "Aged Brie";
	public final static String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public final static String CONJURED_ITEM = "Conjured";

	public GildedRose(Item[] items) {
		this.items = items;

	}

	public void updateQuality() {
		for (Item item : items) {
			if (!specialItem(item) && item.quality > 0) {
				item.quality = item.quality - 1;
			} else if (item.quality < 50) {
				item.quality = item.quality + 1;
				
				if (item.name.equals(BACKSTAGE_PASSES)) {
					backstagePassQualityUpdate(item);
				}
			}
			updateSellIn(item);
		}
	}

	// checks if Item is Brie, Backstage Pass or Sulfuras
	public boolean specialItem(Item item) {
		return (item.name.equals(BRIE) || item.name.equals(BACKSTAGE_PASSES) || item.name.equals(SULFURAS));

	}

	// Updates quality on Backstage Passes
	public void backstagePassQualityUpdate(Item item) {
		if (item.sellIn < 11 && item.quality < 50) {
			item.quality = item.quality + 1;
		} else if (item.sellIn < 6 && item.quality < 50) {
			item.quality = item.quality + 1;
		}
	}

	// updating quality and sellIn
	public void updateSellIn(Item item) {
		if (!item.name.equals(SULFURAS)) {
			item.sellIn = item.sellIn - 1;
		}

		if (item.sellIn < 0) {
			if (!specialItem(item) && item.quality > 0) {
				item.quality = item.quality - 1;
			}
			if (item.name.equals(BRIE) && item.quality < 50) {
				item.quality = item.quality + 1;
			}
			if (item.name.equals(BACKSTAGE_PASSES)) {
				item.quality = item.quality - item.quality;
			}
		}
	}
}