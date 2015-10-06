package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GildedRose
{

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
		
		System.out.println(Arrays.toString(items.toArray()));
		updateQualityAndSellInForAllItems();
		System.out.println(Arrays.toString(items.toArray()));

	}
	

	// Pour tous les items : mets à jour la qualité, jours restants, gere peremption
	public static void updateQualityAndSellInForAllItems()
	{
		for (int i = 0; i < items.size(); i++)
		{
			updateQualityForItem(i);
			
			updateSellIn(i);
			
			if (items.get(i).getSellIn() < 0)
			{
				updateQualityForOutdatedItem(i);
			}
		}
	}

	// Met à jour la qualité d'un item périmé en fonction de son nom
	private static void updateQualityForOutdatedItem(int i) {
		if (nameEqualsAgedBrie(i)){
			updateQualityForAgedBrie(i);
		}
		else if (nameEqualsBackstage(i)){
			updateQualityForBackstage(i);
		}
		else if (qualityUpper0(i) && !nameEqualsSulfuras(i)) {
			decreaseQuality(items.get(i));
		}
	}


	// Met à jour la qualité d'un item en fonction de son nom
	private static void updateQualityForItem(int i) {
		if ((nameEqualsAgedBrie(i)) || nameEqualsBackstage(i)) {
			if (qualityLower50(i))
			{
				increaseQuality(items.get(i));

				if (nameEqualsBackstage(i))
				{
					increaseQualityBackstage(i);
				}
			}
		} else {
			if (qualityUpper0(i) && !nameEqualsSulfuras(i)) {
				decreaseQuality(items.get(i));
			}
		}
	}

	
	private static void increaseQualityBackstage(int i) {
		if (items.get(i).getSellIn() < 6)
		{
			updateQualityForAgedBrie(i);
		}
		
		if (items.get(i).getSellIn() < 11)
		{
			updateQualityForAgedBrie(i);
		}
	}
	
	// met à jour la date de péremption
	private static void updateSellIn(int i) {
		if (!nameEqualsSulfuras(i))
		{
			decreaseSellIn(items.get(i));
		}
	}
	
	// Met à jour la qualité de l'item Aged Brie
	private static void updateQualityForAgedBrie(int i) {
		if (qualityLower50(i))
		{
			increaseQuality(items.get(i));
		}
	}
	
	// Met à jour la qualité de l'item Backstage
	private static void updateQualityForBackstage(int i) {
		items.get(i).setQuality(0);
	}
	
	// Vérifie si la qualité est superieur à 0
	private static boolean qualityUpper0(int i) {
		return items.get(i).getQuality() > 0;
	}

	// Vérifie si la qualité est inferieur à 50
	private static boolean qualityLower50(int i) {
		return items.get(i).getQuality() < 50;
	}

	
	private static boolean nameEqualsSulfuras(int i) {
		return "Sulfuras, Hand of Ragnaros".equals(nameItem(i));
	}
	
	
	private static boolean nameEqualsBackstage(int i) {
		return "Backstage passes to a TAFKAL80ETC concert".equals(nameItem(i));
	}


	private static boolean nameEqualsAgedBrie(int i) {
		return "Aged Brie".equals(nameItem(i));
	}


	private static String nameItem(int i) {
		return items.get(i).getName();
	}

	private static void increaseQuality(Item item)
	{
		item.setQuality(item.getQuality() + 1);
	}
	
	
	private static void decreaseQuality(Item item)
	{
		item.setQuality(item.getQuality() - 1);
	}

	
	private static void decreaseSellIn(Item item)
	{
		item.setSellIn(item.getSellIn() - 1);
	}
	
}