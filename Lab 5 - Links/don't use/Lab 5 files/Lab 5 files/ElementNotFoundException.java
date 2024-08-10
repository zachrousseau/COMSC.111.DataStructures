package jsjf.exceptions;
/**
 * This exception is for when a element cannot be found in a linked binary tree
 * @author gibson
 *
 */
public class ElementNotFoundException extends RuntimeException {
	/**
	 * Construct the exception with the needed message
	 * @param collection
	 */
	public ElementNotFoundException(String collection) {
		super("The element was not found in the " + collection);
	}
}
