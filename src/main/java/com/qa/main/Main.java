package com.qa.main;

import java.util.Arrays;

import com.qa.main.items.Books;
import com.qa.main.items.Newspapers;
import com.qa.main.items.Theses;
import com.qa.main.library.Library;
import com.qa.main.person.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Library testLibrary = new Library();
		Books bible = new Books("The Bible", "Anon", "Anon", 0, 1000, "Religious");
		Theses thesisOne = new Theses("A Proof of Light", "Bella", "Little", 2022, "Physics");
		Newspapers theGuardian = new Newspapers("The Guardian", "The", "Guardian", 2021, 1356);	
		Person charley = new Person("Charley", "Katan");
		Person bella = new Person("Bella", "Little");
		
		testLibrary.inventory.addAll(Arrays.asList(bible, thesisOne, theGuardian));
		
		System.out.println(testLibrary.inventory);
		
		testLibrary.memberCheckOut(bella, theGuardian);
		testLibrary.memberCheckOut(bella, thesisOne);
		System.out.println(bella.getLoans());
		testLibrary.memberCheckOut(charley, theGuardian);
		testLibrary.memberCheckIn(bella, theGuardian);
		testLibrary.memberCheckOut(charley, theGuardian);
	}

}
