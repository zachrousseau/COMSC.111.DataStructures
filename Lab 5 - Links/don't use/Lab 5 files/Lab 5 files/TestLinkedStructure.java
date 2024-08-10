package test;

import jsjf.Lab5LinkedStructure;
import jsjf.exceptions.ElementNotFoundException;
import jsjf.exceptions.EmptyCollectionException;

public class TestLinkedStructure {

	public static void main(String[] args) {
		Lab5LinkedStructure<String> linkedStruct = new Lab5LinkedStructure<String>();

		String s;

		/************************ toString **********************/
		//Test 1
		if(!linkedStruct.toString().equals("")) {
			System.out.println("Error with toString in Test 1");
			System.out.println("toString should return an empty string");
			return;
		}

		//Test 2
		for(int i = 68; i >= 65; i--) {	//add  D, C, B, A to the front in that order
			linkedStruct.insertAtFront(((char)i)+"");
		}
		if(!linkedStruct.toString().equals("A B C D")) {
			System.out.println("Error with toString in Test 2");
			System.out.println("toString should return A B C D but returns " + linkedStruct.toString());
			return;
		}

		/************************ getFirst **********************/

		//Test 3
		s = linkedStruct.getFirst();
		if (!linkedStruct.toString().equals("A B C D") || !s.equals("A") || (linkedStruct.getCount() != 4)) {
			System.out.println("Error with getFirst in Test 3");
			System.out.println("the count should be 4 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C D but are " + linkedStruct.toString());
			System.out.println("the return value should be A but is " + s);

			return;
		}

		linkedStruct = new Lab5LinkedStructure<String>();
		//Test 4
		try {
			linkedStruct.getFirst();
			System.out.println("Error with getFirst in Test 4");
			System.out.println("getFirst should throw an EmptyCollectionException");
			return;
		}catch (EmptyCollectionException e) {
			//an exception is correct here
		}

		/************************ insertAtEnd **********************/

		//Test 5
		linkedStruct.insertAtEnd("A");
		if (!linkedStruct.toString().equals("A") || (linkedStruct.getCount() != 1)) {
			System.out.println("Error with insertAtEnd in Test 5");
			System.out.println("the count should be 1 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A but are " + linkedStruct.toString());

			return;
		}

		//Test 6
		linkedStruct.insertAtEnd("B");
		if (!linkedStruct.toString().equals("A B") || (linkedStruct.getCount() != 2)) {
			System.out.println("Error with insertAtEnd in Test 6");
			System.out.println("the count should be 2 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B but are " + linkedStruct.toString());

			return;
		}



		//Test 7
		linkedStruct.insertAtEnd("C");
		if (!linkedStruct.toString().equals("A B C")|| (linkedStruct.getCount() != 3)) {
			System.out.println("Error with insertAtEnd in Test 7");
			System.out.println("the count should be 3 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C but are " + linkedStruct.toString());
			return;
		}

		/************************ deleteFirst **********************/

		//Test 8
		s = linkedStruct.deleteFirst();
		if ((linkedStruct.getCount() != 2) || !linkedStruct.toString().equals("B C") || !s.equals("A")) {
			System.out.println("Error with deleteFirst in Test 8");
			System.out.println("the count should be 2 but is " + linkedStruct.getCount());
			System.out.println("the elements should be B C but are " + linkedStruct.toString());
			System.out.println("the return value should be A but is " + s);

			return;
		}

		//Test 9
		s = linkedStruct.deleteFirst();
		if ((linkedStruct.getCount() != 1) || !linkedStruct.toString().equals("C") || !s.equals("B")) {
			System.out.println("Error with deleteFirst in Test 9");
			System.out.println("the count should be 1 but is " + linkedStruct.getCount());
			System.out.println("the elements should be C but are " + linkedStruct.toString());
			System.out.println("the return value should be B but is " + s);

			return;
		}

		//Test 10
		s = linkedStruct.deleteFirst();
		if ((linkedStruct.getCount() != 0) || !linkedStruct.toString().equals("") || !s.equals("C")) {
			System.out.println("Error with deleteFirst in Test 10");
			System.out.println("the count should be 0 but is " + linkedStruct.getCount());
			System.out.println("the elements should be empty but are " + linkedStruct.toString());
			System.out.println("the return value should be C but is " + s);

			return;
		}


		//Test 11
		try {
			s = linkedStruct.deleteFirst();
			System.out.println("Error with deleteFirst in Test 11");
			System.out.println("deleteFirst should throw an EmptyCollectionException");
			return;
		}catch (EmptyCollectionException e) {
			//an exception is correct here
		}
		/************************ get **********************/

		//Test 12
		try {
			linkedStruct.get(0);
			System.out.println("Error with get in Test 12");
			System.out.println("get should throw an EmptyCollectionException");
			return;
		}catch (ElementNotFoundException e) {
			//an exception is correct here
		}


		for(int i = 68; i >= 65; i--) { //add  D, C, B, A to the front in that order
			linkedStruct.insertAtFront(((char)i)+"");
		}

		//Test 13
		s = linkedStruct.get(1);
		if (!linkedStruct.toString().equals("A B C D") || !s.equals("B") || (linkedStruct.getCount() != 4))  {
			System.out.println("Error with get in Test 13");
			System.out.println("the count should be 4 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C D but are " + linkedStruct.toString());
			System.out.println("the return value should be B but is " + s);	

			return;
		}

		//Test 14
		s = linkedStruct.get(0);
		if (!linkedStruct.toString().equals("A B C D") || !s.equals("A") || (linkedStruct.getCount() != 4))  {
			System.out.println("Error with get in Test 14");
			System.out.println("the count should be 4 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C D but are " + linkedStruct.toString());
			System.out.println("the return value should be A but is " + s);	

			return;
		}

		//Test 15
		s = linkedStruct.get(3);
		if (!linkedStruct.toString().equals("A B C D") || !s.equals("D") || (linkedStruct.getCount() != 4))  {
			System.out.println("Error with get in Test 15");
			System.out.println("the count should be 4 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C D but are " + linkedStruct.toString());
			System.out.println("the return value should be D but is " + s);	

			return;
		}

		//Test 16
		try {
			linkedStruct.get(4);
			System.out.println("Error with get in Test 16");
			System.out.println("get should throw an ElementNotFoundException");
			return;
		}catch (ElementNotFoundException e) {
			//an exception is correct here
		}

		/************************ insertAfter **********************/

		//Test 17
		linkedStruct.insertAfter("E", "C");
		if (!linkedStruct.toString().equals("A B C E D") || (linkedStruct.getCount() != 5)) {
			System.out.println("Error with insertAfter in Test 17");
			System.out.println("the count should be 5 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C G D but are " + linkedStruct.toString());

			return;
		}

		//Test 18
		linkedStruct.insertAfter("F", "D");
		if (!linkedStruct.toString().equals("A B C E D F") || (linkedStruct.getCount() != 6)) {
			System.out.println("Error with insertAfter in Test 18");
			System.out.println("the count should be 6 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B C G D H but are " + linkedStruct.toString());

			return;
		}

		//Test 19
		try {
			linkedStruct.insertAfter("G", "Q");
			System.out.println("Error with insertAfter in Test 19");
			System.out.println("insertAfter should throw an ElementNotFoundException");
			return;
		}catch (ElementNotFoundException e) {
			//an exception is correct here
		}

		linkedStruct = new Lab5LinkedStructure<String>();

		//Test 20
		try {
			linkedStruct.insertAfter("G", "Q");
			System.out.println("Error with insertAfter in Test 20");
			System.out.println("insertAfter should throw an EmptyCollectionException");
			return;
		}catch (EmptyCollectionException e) {			
			//an exception is correct here
		}

		/************************ deleteLast **********************/
		for(int i = 67; i >= 65; i--) { //add  C, B, A to the front in that order
			linkedStruct.insertAtFront(((char)i)+"");
		}
		//Test 21
		s = linkedStruct.deleteLast();
		if ((linkedStruct.getCount() != 2) || !linkedStruct.toString().equals("A B") || !s.equals("C") ) {
			System.out.println("Error with deleteLast in Test 21");
			System.out.println("the count should be 2 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A B but are " + linkedStruct.toString());
			System.out.println("the return value should be C but is " + s);	

			return;
		}

		//Test 22
		s = linkedStruct.deleteLast();
		if ( (linkedStruct.getCount() != 1) || !linkedStruct.toString().equals("A") || !s.equals("B")) {
			System.out.println("Error with deleteLast in Test 22");
			System.out.println("the count should be 1 but is " + linkedStruct.getCount());
			System.out.println("the elements should be A but are " + linkedStruct.toString());
			System.out.println("the return value should be B but is " + s);	

			return;
		}

		//Test 23
		s = linkedStruct.deleteLast();
		if ( (linkedStruct.getCount() != 0) || !linkedStruct.toString().equals("") || !s.equals("A")) {
			System.out.println("Error with deleteLast in Test 23");
			System.out.println("the count should be 0 but is " + linkedStruct.getCount());
			System.out.println("the elements should be empty but are " + linkedStruct.toString());
			System.out.println("the return value should be A but is " + s);	

			return;
		}

		//Test 24
		try {
			s = linkedStruct.deleteLast();
			System.out.println("Error with deleteLast in Test 24");
			System.out.println("get should throw an EmptyCollectionException");
			return;
		}catch (EmptyCollectionException e) {
			//an exception is correct here
		}

		System.out.println("Tests complete");
	}

}
