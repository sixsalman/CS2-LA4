package edu.wmich.cs1120.LA4.SKhan;

/**
 * Objects of this class contain information of multimedia specific to movies
 * @author M. Salman Khan
 *
 */
public class Movie extends Multimedia implements IPromotion {

	private String audioLanguage;
	private String category;

	/**
	 * creates a Movie object passing part of the received information to an object of its superclass
	 * @param id receives id of the item
	 * @param title receives title of the item
	 * @param publisher receives publisher of the item
	 * @param description receives description of the item
	 * @param isFree receives true if the item is free; false otherwise
	 * @param price receives price of the item
	 * @param runtime receives runtime of the multimedia
	 * @param audioLanguage receives language of the movie
	 * @param category receives category of the movie
	 */
	public Movie(int id, String title, String publisher, String description, boolean isFree, double price,
			double runtime, String audioLanguage, String category) {
		super(id, title, publisher, description, isFree, price, runtime);
		this.audioLanguage = audioLanguage;
		this.category = category;
	}

	@Override
	public double priceAfterTax() {
		return (getPrice() + getPrice() * 0.25);
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
		if (!isFree) {
			return String.format("%sPrice: $%.2f\nCategory: %s\n AudioLanguage: %s\n", super.toString(), getPrice(),
					category, audioLanguage);
		} else {
			return String.format("%sPrice: Free\nCategory: %s\n AudioLanguage: %s\n", super.toString(), category,
					audioLanguage);
		}
	}

	@Override
	public double salesPromotion() {
		return 0.5;
	}

}
