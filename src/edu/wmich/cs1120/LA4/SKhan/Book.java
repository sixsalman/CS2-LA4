package edu.wmich.cs1120.LA4.SKhan;

/**
 * Objects of this class contain information of an item specific to books
 * @author M. Salman Khan
 *
 */
public class Book extends Item implements IPromotion {

	public int pages;
	public String writerName;
	public String iSBN;
	public String[] language;

	/**
	 * creates a Book object passing part of the received information to an object of its superclass
	 * @param id receives id of the item
	 * @param title receives title of the item
	 * @param publisher receives publisher of the item
	 * @param description receives description of the item
	 * @param isFree receives true if the item is free; false otherwise
	 * @param price receives price of the item
	 * @param pages receives no. of pages in the book
	 * @param writerName receives name of the book writer
	 * @param iSBN receives ISBN no. of the book
	 * @param language receives languages in which the book is available
	 */
	public Book(int id, String title, String publisher, String description, boolean isFree, double price, int pages,
			String writerName, String iSBN, String[] language) {
		super(id, title, publisher, description, isFree, price);
		this.pages = pages;
		this.writerName = writerName;
		this.iSBN = iSBN;
		this.language = language;
	}

	@Override
	public double priceAfterTax() {
		return (getPrice() + getPrice() * 0.2);
	}

	/**
	 * gets price
	 * @return price after applying sale promotion
	 */
	public double getPrice() {
		return (price - price * salesPromotion());
	}

	@Override
	public String toString() {

		StringBuilder langs = new StringBuilder("");
		for (int i = 0; i < language.length; i++) {
			langs.append(language[i] + ",");
		}
		if (!isFree) {
			return String.format("%sPrice: $%.2f\nISBN: %s\nPages: %d\nWriter Name: %s\nLanguages: %s\n",
					super.toString(), getPrice(), iSBN, pages, writerName, langs);
		} else {
			return String.format("%sPrice: Free\nISBN: %s\nPages: %d\nWriter Name: %s\nLanguages: %s\n",
					super.toString(), iSBN, pages, writerName, langs);
		}

	}

	@Override
	public double salesPromotion() {
		return 0.8;
	}

}
