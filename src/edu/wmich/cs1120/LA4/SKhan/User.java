package edu.wmich.cs1120.LA4.SKhan;

import java.util.ArrayList;

/**
 * Objects of this class contain information of a user's account
 * @author M. Salman Khan
 *
 */
public class User {

	private int id;
	protected String username;
	protected String password;
	protected ArrayList<Item> library;

	/**
	 * creates a User object
	 * @param id receives id of the user
	 * @param username receives username of the user
	 * @param password receives password of the user
	 */
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		library = new ArrayList<>();
	}

	/**
	 * adds the receives item to the user's library array
	 * @param item receives an object of Item type
	 */
	public void addItemToTheLibrary(Item item) {
		library.add(item);
	}

}
