package edu.wmich.cs1120.LA4.SKhan;

import java.util.Scanner;

/**
 * 23rd October 2019
 * CS1120-545 LA4
 * This program asks user for his/her credentials, if they match with stored accounts, a menu is shown
 * navigating through which books, movies and music can be bought and added to the user's library in his/her account
 * @author M. Salman Khan
 *
 */
public class StoreClass {

	private static User sUser;
	private static Scanner kbdTxt = new Scanner(System.in);
	private static Scanner kbdNum = new Scanner(System.in);
	private static boolean isValid;
	private static int opt;

	/**
	 * asks user for his/her credential. if they match a record then menu is shown.
	 * otherwise, the user is asked again
	 * @param args is not used
	 */
	public static void main(String[] args) {

		String userName;
		String pass;

		Lookup lookup = new Lookup();

		while (true) {
			System.out.println("Enter your UserName:");
			userName = kbdTxt.nextLine();
			System.out.println("Enter your Password:");
			pass = kbdTxt.nextLine();
			sUser = lookup.checkLoginAuth(userName, pass);
			if (sUser != null) {
				System.out.println("Login Successful!");
				mainMenu(lookup);
			} else {
				System.out.println("Incorrect username or password");
			}
		}

	}

	/**
	 * displays books in stock and a menu, obtains user choice, validates it and acts accordingly
	 * @param lookup receives a lookup object containing user and item info
	 */
	public static void bookMenu(Lookup lookup) {
		lookup.printBookList();
		while (true) {
			isValid = false;
			System.out.println("1- Download book\n2- Return to Stores list menu\nSelect one of these options:");
			opt = kbdNum.nextInt();
			switch (opt) {
			case 1:
				while (!isValid) {
					System.out.println("Enter Book Key:");
					opt = kbdNum.nextInt();
					for (int i = 0; i < lookup.storeItemList.length; i++) {
						if ((lookup.storeItemList[i] instanceof Book) && (lookup.storeItemList[i].id == opt)) {
							if (lookup.storeItemList[i].isFree) {
								sUser.addItemToTheLibrary(lookup.storeItemList[i]);
								System.out.println("Download Successfully Completed");
								isValid = true;
								break;
							} else {
								System.out.printf(
										"This item is not free, the total cost after taxes = $%.2f // i.e. price plus tax\n",
										lookup.storeItemList[i].priceAfterTax());
								while (!isValid) {
									System.out.println("Enter the price to contnue or 0 to exit");
									double entry = kbdNum.nextDouble();
									if (entry == lookup.storeItemList[i].priceAfterTax()) {
										sUser.addItemToTheLibrary(lookup.storeItemList[i]);
										System.out.println("Download Successfully Completed");
										isValid = true;
									} else if (entry == 0) {
										kbdNum.close();
										kbdTxt.close();
										System.exit(0);
									} else {
										System.out.println("This option is not existing");
									}
								}
								break;
							}
						}
					}
					if (!isValid) {
						System.out.println("This item is not existing");
					}
				}
				break;
			case 2:
				mainMenu(lookup);
				break;
			default:
				System.out.println("This option is not existing");
			}
		}
	}

	/**
	 * displays movies or books in stock and a menu, obtains user choice, validates it and acts accordingly
	 * @param storeType receives an identifier that distinguishes between a movies and music
	 * @param lookup lookup receives a lookup object containing user and item info
	 */
	public static void multiMediaMenu(int storeType, Lookup lookup) {
		if (storeType == 2) {
			lookup.printMusicList();
			while (true) {
				isValid = false;
				System.out.println(
						"1- Play or Purchase Music\n0- Return to Store list menu\nSelect one of these options:");
				opt = kbdNum.nextInt();
				switch (opt) {
				case 1:
					while (!isValid) {
						System.out.println("Enter Music Key:");
						opt = kbdNum.nextInt();
						for (int i = 0; i < lookup.storeItemList.length; i++) {
							if ((lookup.storeItemList[i] instanceof Music) && (lookup.storeItemList[i].id == opt)) {
								if (lookup.storeItemList[i].isFree) {
									((Multimedia)lookup.storeItemList[i]).Play();
									isValid = true;
									break;
								} else {
									System.out.printf("This item is not free, the total cost after taxes = $%.2f\n",
											lookup.storeItemList[i].priceAfterTax());
									while (!isValid) {
										System.out.println("Enter the price to contnue or 0 to exit");
										double entry = kbdNum.nextDouble();
										if (entry == lookup.storeItemList[i].priceAfterTax()) {
											sUser.addItemToTheLibrary(lookup.storeItemList[i]);
											((Multimedia)lookup.storeItemList[i]).Play();
											isValid = true;
										} else if (entry == 0) {
											kbdNum.close();
											kbdTxt.close();
											System.exit(0);
										} else {
											System.out.println("This option is not existing");
										}
									}
									break;
								}
							}
						}
						if (!isValid) {
							System.out.println("This item is not existing");
						}
					}
					break;
				case 0:
					mainMenu(lookup);
					break;
				default:
					System.out.println("This option is not existing");
				}
			}
		} else if (storeType == 3) {
			lookup.printMovieList();
			while (true) {
				isValid = false;
				System.out.println(
						"1- Play or Purchase Movie\n0- Return to Store list menu\nSelect one of these options:");
				opt = kbdNum.nextInt();
				switch (opt) {
				case 1:
					while (!isValid) {
						System.out.println("Enter Movie Key:");
						opt = kbdNum.nextInt();
						for (int i = 0; i < lookup.storeItemList.length; i++) {
							if ((lookup.storeItemList[i] instanceof Movie) && (lookup.storeItemList[i].id == opt)) {
								if (lookup.storeItemList[i].isFree) {
									((Multimedia)lookup.storeItemList[i]).Play();
									isValid = true;
									break;
								} else {
									System.out.printf("This item is not free, the total cost after taxes = $%.2f\n",
											lookup.storeItemList[i].priceAfterTax());
									while (!isValid) {
										System.out.println("Enter the price to contnue or 0 to exit");
										double entry = kbdNum.nextDouble();
										if (entry == lookup.storeItemList[i].priceAfterTax()) {
											sUser.addItemToTheLibrary(lookup.storeItemList[i]);
											((Multimedia)lookup.storeItemList[i]).Play();
											isValid = true;
										} else if (entry == 0) {
											kbdNum.close();
											kbdTxt.close();
											System.exit(0);
										} else {
											System.out.println("This option is not existing");
										}
									}
									break;
								}
							}
						}
						if (!isValid) {
							System.out.println("This item is not existing");
						}
					}
					break;
				case 0:
					mainMenu(lookup);
					break;
				default:
					System.out.println("This option is not existing");
				}
			}
		}
	}

	/**
	 * displays a menu, obtains user choice, validates it and shows information and/or another
	 * menu based on user's choice 
	 * @param lookup receives a lookup object containing user and item info
	 */
	public static void mainMenu(Lookup lookup) {
		while (true) {
			System.out.println(
					"Store List Menu:\n1- Book Store\n2- Music Store\n3- Movie Store\n4- My Library\n0- Quit\n Select one of these options:");
			opt = kbdNum.nextInt();
			switch (opt) {
			case 1:
				bookMenu(lookup);
				break;
			case 2:
				multiMediaMenu(2, lookup);
				break;
			case 3:
				multiMediaMenu(3, lookup);
				break;
			case 4:
				System.out.println("*************User Library*************");
				for (int i = 0; i < sUser.library.size(); i++) {
					System.out.print(sUser.library.get(i));
					if (i != sUser.library.size() - 1) {
						System.out.println("************************************");
					} else {
						System.out.print("\n");
					}
				}
				break;
			case 0:
				kbdNum.close();
				kbdTxt.close();
				System.exit(0);
				break;
			default:
				System.out.println("This option is not existing");
			}
		}
	}

}
