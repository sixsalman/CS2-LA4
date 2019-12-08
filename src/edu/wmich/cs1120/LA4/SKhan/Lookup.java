package edu.wmich.cs1120.LA4.SKhan;

/**
 * This class was copied from assignment paper (as per instructions) and code was added to several methods.
 * It's objects store information of user accounts and items in store.
 * @author Assignment Writer and M. Salman Khan
 *
 */
public class Lookup {

	public User[] userList;
	public Item[] storeItemList;

	/**
	 * creates a Lookup object and calls appropriate methods to assign
	 * values to userList and storeItemList
	 */
	public Lookup() {
		userList = createUsers();
		storeItemList = loadItems();
	}

	/**
	 * checks whether received information matches with any of userList's elements
	 * @param userName
	 * @param password
	 * @return Return the user object it it exist
	 */
	public User checkLoginAuth(String userName, String password) {
		for (int i = 0; i < userList.length; i++) {
			if (userName.equals(userList[i].username)) {
				if (password.equals(userList[i].password)) {
					return userList[i];
				}
				return null;
			}
		}
		return null;
	}

	/**
	 * gets userList
	 * @return userList array
	 */
	public User[] getUserList() {
		return userList;
	}

	/**
	 * sets userList
	 * @param userList receives an array containing objects of User type
	 */
	public void setUserList(User[] userList) {
		this.userList = userList;
	}

	/**
	 * gets storeItemList
	 * @return storeItemList array
	 */
	public Item[] getStoreItemList() {
		return storeItemList;
	}

	/**
	 * sets storeItemList
	 * @param mStoreItemList receives an array containing objects of Item type
	 */
	public void setStoreItemList(Item[] mStoreItemList) {
		this.storeItemList = mStoreItemList;
	}

	/**
	 * This method adds two users to the user list, "You should not change these
	 * users, but you can add new users
	 */
	public User[] createUsers() {
		User[] list = new User[2];
		list[0] = new User(1, "john", "123");
		list[1] = new User(2, "Ira", "321");
		return list;
	}

	/**
	 * This method load data to the item list, this list has all the items in your
	 * application "You should not change these data but you can add new items".
	 *
	 */
	public Item[] loadItems() {
		Item[] itemList = new Item[5];
		String[] languages = new String[2];
		languages[0] = "English";
		languages[1] = "Arabic";
		itemList[0] = new Book(1, "Engineering Analysis with SOLIDWORKS Simulation 2017", "SDC Publications",
				"\tEngineering Analysis with SOLIDWORKS Simulation 2017"
						+ " \n\tgoes beyond the standard software manual."
						+ " \n\tIts unique approach concurrently introduces you to the SOLIDWORKS"
						+ " \n\tSimulation 2017 software and the fundamentals of Finite Element Analysis"
						+ " \n\t(FEA) through hands-on exercises. A number of projects are presented"
						+ " \n\tusing commonly used parts to illustrate the analysis features of "
						+ "\n\tSOLIDWORKS Simulation. Each chapter is designed to build on the skills, "
						+ "\n\texperiences and understanding gained from the previous chapters.",
				false, 10, 578, "Paul Kurowski", "9781630570767", languages);

		itemList[1] = new Book(2, "SQL Queries for Mere Mortals", "Addison-Wesley Professional",
				"\tSQL Queries for Mere Mortals � has earned worldwide praise "
						+ "\n\tas the clearest, simplest tutorial on writing effective SQL queries."
						+ "\n\tThe authors have updated this hands-on classic to reflect new "
						+ "\n\tSQL standards and database applications and teach valuable new techniques."
						+ "\n\tStep by step, John L. Viescas and Michael J. Hernandez guide you through "
						+ "\n\tcreating reliable queries for virtually any modern SQL-based database. "
						+ "\n\tThey demystify all aspects of SQL query writing, from simple data selection"
						+ "\n\tand filtering to joining multiple tables and modifying sets of data.",
				true, 0, 792, "John L. ViescasMichael J. Hernandez", "9780133824841", languages);
		itemList[2] = new Movie(101, "Smurfs: The Lost Village", "Dupuis",
				"\tFully animated with new characters looking like the original"
						+ "\n\tPeyo's animation. This film will answer all of the questions "
						+ "\n\tof the Smurfs such as \"Why do the Smurfs live in "
						+ "\n\tsara mushrooms?\" and \"Why don't the Smurfs wear shirts?\"",
				false, 20, 89, "English", "Animation");
		itemList[3] = new Movie(101, "Black Panther", "Ryan Coogler",
				"\tAfter the death of his father, the king of Wakanda,"
						+ "\n\tyoung T�Challa returns home to the isolated hightech "
						+ "\n\tAfrican nation to succeed to the throne and take his rightful"
						+ "\n\tplace as king. But when a powerful enemy reappears,"
						+ "\n\tT�Challa�s mettle as king � and Black Panther � is tested when"
						+ "\n\the�s drawn into a formidable conflict that puts the fate of"
						+ "\n\tWakanda and the entire world at risk.",
				false, 20, 89, "English", "Action & Adventure");

		itemList[4] = new Music(201, "Le rossignol", "Modest Mussorgsky",
				"\r1-The Nutcracker (Suite), Op.71a: 3. Waltz of the Flowers"
						+ "\r\n2- The Nutcracker (Suite), Op.71a: 2b. Dance of the Sugar Plum Fairy"
						+ "\r\n3- Prelude in C Major, Op. 12, No. 7",
				false, 2, 4, "MP3", "Russian Album");
		return itemList;
	}

	/**
	 * Print Movie list from storeItemList
	 */
	public void printMovieList() {
		System.out.println("**************Movie Store**************");
		for (int i = 0; i < storeItemList.length; i++) {
			if (storeItemList[i] instanceof Movie) {
				System.out.print(storeItemList[i] + "--------------------------\n");
			}
		}
		System.out.println("***************************************");
	}

	/**
	 * Print Books list from storeItemList
	 */
	public void printBookList() {
		System.out.println("**************Book Store**************");
		for (int i = 0; i < storeItemList.length; i++) {
			if (storeItemList[i] instanceof Book) {
				System.out.print(storeItemList[i] + "--------------------------\n");
			}
		}
		System.out.println("***************************************");
	}

	/**
	 * Print Music list from storeItemList
	 */
	public void printMusicList() {
		System.out.println("**************Music Store**************");
		for (int i = 0; i < storeItemList.length; i++) {
			if (storeItemList[i] instanceof Music) {
				System.out.print(storeItemList[i] + "--------------------------\n");
			}
		}
		System.out.println("***************************************");
	}

	/**
	 * This method searches for the item by its key and then return the item object
	 * if the item exist else return null
	 */
	public Item getItemById(int key) {
		return storeItemList[key];
	}

}
