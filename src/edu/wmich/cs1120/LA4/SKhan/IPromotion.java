package edu.wmich.cs1120.LA4.SKhan;

/**
 * This interface was copied from assignment paper (as per instructions)
 * @author Assignment Writer
 *
 */
public interface IPromotion {

	/**
	* This method is called by the getPrice methods for Book
	* and Movie classes.
	* @return promotion value which is 0.8 for Book item
	* and 0.5 for movie item
	*/
	public double salesPromotion(); 
	
}
