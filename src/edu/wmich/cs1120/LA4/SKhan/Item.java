package edu.wmich.cs1120.LA4.SKhan;

/**
 * This abstract class serves as a super class to all types of items and contains attributes
 * that they have in common.
 * @author M. Salman Khan
 *
 */
public abstract class Item {

	protected int id;
	private String title;
	private String publisher;
	private String description;
	protected boolean isFree;
	protected double price;

	/**
	 * creates an Item object as a superclass using information received from a subclass
	 * @param id receives id of the item
	 * @param title receives title of the item
	 * @param publisher receives publisher of the item
	 * @param description receives description of the item
	 * @param isFree receives true if the item is free; false otherwise
	 * @param price receives price of the item
	 */
	public Item(int id, String title, String publisher, String description, boolean isFree, double price) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.description = description;
		this.isFree = isFree;
		this.price = price;
	}

	/**
	 * calculates and gets total cost of item
	 * @return price of the item after adding tax
	 */
	public abstract double priceAfterTax();

	/**
	 * gets information from an object of the class in String format
	 * @return a String containing information related to the object
	 */
	@Override
	public String toString() {
		return String.format("\nItem Key: %d\n%s\nPublisher: %s\nDescription:\n%s\n", id, title, publisher,
				description);
	}

}
