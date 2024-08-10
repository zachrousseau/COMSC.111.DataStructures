package jsjf;

import jsjf.exceptions.*;

/**
 * A linear linked structure for practicing with links.
 *
 * @author Sonya Cates
 */

public class Lab5LinkedStructure<T>{


	private int count;  
	private LinearNode<T> head;

	/**
	 * Creates an empty linear linked structure.
	 */
	public Lab5LinkedStructure()
	{
		count = 0;
		head = null;
	}

	/**
	 * Adds the specified element to the front.
	 * @param element element to be added
	 */
	public void insertAtFront(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);



		newNode.setNext(head);


		head = newNode;
		count++;
	}

	/**
	 * Adds the specified element to the end.
	 * @param element element to be added
	 */
	public void insertAtEnd(T element)
	{	

		LinearNode<T> temp = new LinearNode<T>(element);
		count++; 
		temp.setNext(null);
		
		if(head == null){
			head = temp;
			return;
		}
		if(count == 1) {
			head.setNext(temp);
			return;
		}
		else{
			LinearNode<T> tempPtr = head;
			while(tempPtr.getNext() != null) {
				tempPtr = tempPtr.getNext();
			}
			tempPtr.setNext(temp);
		}
		
	}


	/**
	 * Adds the specified element after the target element.
	 * @param element element to be added
	 * @param target element to add after
	 */
	public void insertAfter(T element, T target) throws EmptyCollectionException, ElementNotFoundException
	{
		if(head == null)
			throw new EmptyCollectionException("Lab5 Linked List");

		LinearNode<T> tempPtr = head;
		LinearNode<T> newNode = new LinearNode<T>(element);

		while(tempPtr.getNext() != null){
			
			System.out.println(tempPtr.getElement());
			if(tempPtr.getElement().equals(target)){
				newNode.setNext(tempPtr.getNext());
				tempPtr.setNext(newNode);
				count++;
				return;
			}
			tempPtr = tempPtr.getNext();
		}
		if(tempPtr.getElement().equals(target)){
			newNode.setNext(tempPtr.getNext());
			tempPtr.setNext(newNode);
			count++;
			return;
		}

		throw new ElementNotFoundException("Lab5 Linked List");
	}


	/**
	 * Adds the specified element at index idx.
	 * @param element element to be added
	 * @param idx index to add at
	 * @throws ElementNotFoundException if the structure does not have idx elements

	 */
	public void insertAt(T element, int idx) throws ElementNotFoundException
	{
		if(idx > count || idx < 0) {
			throw new ElementNotFoundException("Lab5 Linked List");
		}

		LinearNode<T> newNode = new LinearNode<T>(element);

		if (idx == 0) {
			newNode.setNext(head);
			head = newNode;
		}else {
			LinearNode<T> tempPtr = head;
			for(int i = 1; i < idx; i++) {
				tempPtr = tempPtr.getNext();
			}
			newNode.setNext(tempPtr.getNext());
			tempPtr.setNext(newNode);

		}
		count++;



	}

	/**
	 * Return the first element.
	 * @return element from front
	 * @throws EmptyCollectionException if the structure is empty
	 */
	public T getFirst() throws EmptyCollectionException
	{
		if(getCount() == 0)
			throw new EmptyCollectionException("Lab5 Linked List");

		return head.getElement();
	}


	/**
	 * Return the last element.
	 * @return element from end
	 * @throws EmptyCollectionException if the structure is empty
	 */
	public T getLast() throws EmptyCollectionException
	{
		if (head == null) // or count == 0
			throw new EmptyCollectionException("Lab5 Linked List");

		if(count == 1) {
			return head.getElement();
		}else{
			LinearNode<T> tempPtr = head;
			while(tempPtr.getNext() != null) {
				tempPtr = tempPtr.getNext();
			}
			return tempPtr.getElement();
		}
	}

	/**
	 * Return the ith element.
	 * @param idx index of element to be returned
	 * @return element at position idx
	 * @throws ElementNotFoundException if the structure does not contain idx elements
	 */
	public T get(int idx) throws ElementNotFoundException, EmptyCollectionException 
	{

		if(head == null)
			throw new ElementNotFoundException("Lab5 Linked List");
		if(count <= idx)
			throw new ElementNotFoundException("Lab5 Linked List");

		LinearNode<T> tempPtr = head;
		int tempCount = 0;
		while(tempPtr.getNext() != null) {
			if(tempCount == idx){
				return tempPtr.getElement(); 
			}
			tempCount ++;
			tempPtr = tempPtr.getNext();
		}

		return getLast();
	}

	/**
	 * Removes the first element and returns a reference to it. 
	 * @return element from front
	 * @throws EmptyCollectionException if the structure is empty
	 */
	public T deleteFirst() throws EmptyCollectionException
	{
		if (head == null) // or count == 0
			throw new EmptyCollectionException("Lab5 Linked List");

		T result = head.getElement();
		head = head.getNext();
		count--;

		return result;

	}


	/**
	 * Removes the last element and returns a reference to it. 
	 * @return element from end
	 * @throws EmptyCollectionException if the structure is empty
	 */
	public T deleteLast() throws EmptyCollectionException
	{
		if (head == null) // or count == 0
			throw new EmptyCollectionException("Lab5 Linked List");


		int tempCount = -1;

		LinearNode<T> tempPtr = head;
		LinearNode<T> tempPtr2 = head;

		while(tempPtr.getNext() != null){
			tempPtr = tempPtr.getNext();
			tempCount++;
		}
		for(int i = 0; i<tempCount; i++){
			tempPtr2 = tempPtr2.getNext();
		}
		tempPtr2.setNext(null);
		
		if (count == 1)
			head = null;

		count--;
		return tempPtr.getElement();

	}



	/**
	 * Removes the element at a given index and returns a reference to it. 
	 * @param idx index of element to be removed
	 * @return element at position idx
	 * @throws ElementNotFoundException if the structure does not have idx elements
	 */
	public T delete(int idx) throws ElementNotFoundException 
	{
		if(idx >= count || idx < 0) {
			throw new ElementNotFoundException("Lab5 Linked List");
		}

		T result;
		if(idx == 0) {
			result = head.getElement();
			head = head.getNext();
		}


		else{


			LinearNode<T> prevPtr = head;
			LinearNode<T> tempPtr = head.getNext();

			for(int i = 1; i < idx; i++) {
				tempPtr = tempPtr.getNext();
				prevPtr = prevPtr.getNext();
			}

			result = tempPtr.getElement();
			prevPtr.setNext(tempPtr.getNext());

		}
		count--;
		return result;
	}
	
    /**
     * Returns the node count
     * @return count
     */
	public int getCount() {
		return count;
	}

    /**
     * Returns a string representation of the linked structure. 
     * @return string representation of the linked structure
     */
	@Override
	public String toString()
	{
		String output = "";

        LinearNode<T> current = head;

        while(current != null){
			if(output.length() == 0)
            	output = current.getElement().toString();
			else 
				output = output + " " + current.getElement().toString();

            current = current.getNext();
        }

        return output;

	}
}
