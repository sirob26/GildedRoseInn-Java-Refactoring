package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

public class Item
{
	private String name;
	private int sellIn;
	private int quality;

	public Item(String name, int sellIn, int quality)
	{
		this.setName(name);
		this.setSellIn(sellIn);
		this.setQuality(quality);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getSellIn()
	{
		return this.sellIn;
	}

	public void setSellIn(int sellIn)
	{
		this.sellIn = sellIn;
	}

	public int getQuality()
	{
		return this.quality;
	}

	public void setQuality(int quality)
	{
		this.quality = quality;
	}

	@Override
	public String toString() {
		return "[" + name + ", sellIn=" + sellIn + ", quality="
				+ quality + "]";
	}
	
}
