package edu.wmich.cs1120.LA4.SKhan;

/**
 * Objects of this class contain information of multimedia specific to music
 * @author M. Salman Khan
 *
 */
public class Music extends Multimedia {

	private String fileType;
	private String album;

	/**
	 * creates a Music object passing part of the received information to an object of its superclass
	 * @param id receives id of the item
	 * @param title receives title of the item
	 * @param publisher receives publisher of the item
	 * @param description receives description of the item
	 * @param isFree receives true if the item is free; false otherwise
	 * @param price receives price of the item
	 * @param runtime receives runtime of the multimedia
	 * @param fileType receives file type of the music file
	 * @param album receives album of the music file
	 */
	public Music(int id, String title, String publisher, String description, boolean isFree, double price,
			double runtime, String fileType, String album) {
		super(id, title, publisher, description, isFree, price, runtime);
		this.fileType = fileType;
		this.album = album;
	}

	@Override
	public String toString() {
		if (!isFree) {
			return String.format("%sPrice: $%.2f\nFile type: %s\nAlbum: %s\n", super.toString(), price, fileType,
					album);
		} else {
			return String.format("%sPrice: Free\nFile type: %s\nAlbum: %s\n", super.toString(), fileType, album);
		}
	}

}
