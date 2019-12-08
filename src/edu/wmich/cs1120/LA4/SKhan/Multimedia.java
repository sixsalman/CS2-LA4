package edu.wmich.cs1120.LA4.SKhan;

/**
 * Objects of this class contain information specific to multimedia items
 * @author M. Salman Khan
 *
 */
public class Multimedia extends Item {

	private boolean isPlay;
	private double runtime;

	/**
	 * creates a Multimedia object passing part of the received information to an object of its superclass
	 * @param id receives id of the item
	 * @param title receives title of the item
	 * @param publisher receives publisher of the item
	 * @param description receives description of the item
	 * @param isFree receives true if the item is free; false otherwise
	 * @param price receives price of the item
	 * @param runtime receives runtime of the multimedia
	 */
	public Multimedia(int id, String title, String publisher, String description, boolean isFree, double price,
			double runtime) {
		super(id, title, publisher, description, isFree, price);
		isPlay = false;
		this.runtime = runtime;
	}

	@Override
	public double priceAfterTax() {
		return (price + price * 0.25);
	}

	@Override
	public String toString() {
		return String.format("%sRun time: %.1f\n", super.toString(), runtime);
	}

	/**
	 * prints on screen that the multimedia is playing
	 * @return true indicating that the multimedia is playing
	 */
	public boolean Play() {
		System.out.println("Playing!");
		isPlay = true;
		return isPlay;
	}

}
