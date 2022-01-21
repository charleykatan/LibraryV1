package com.qa.main;

import java.util.Arrays;

import com.qa.main.items.Book;
import com.qa.main.items.Newspaper;
import com.qa.main.items.Thesis;
import com.qa.main.library.Library;
import com.qa.main.person.Person;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Library testLibrary = new Library();
		Book bible = new Book("The Bible", "Anon", "Anon", 0, 1000, "Religious");
		Thesis thesisOne = new Thesis("A Proof of Light", "Bella", "Little", 2022, "Physics");
		Newspaper theGuardian = new Newspaper("The Guardian", "The", "Guardian", 2021, 1356);
		Book tkamb = new Book("To Kill a Mockingbird", "Harper", "Lee", 1954, 600, "Fiction");
		Thesis ckThesis = new Thesis("Retreating from Zion?", "Charley", "Katan", 2021, "Sociology");
		Newspaper theTimes = new Newspaper("The Times", "Rupert", "Murdoch", 2001, 2002);
		Person charley = new Person("Charley", "Katan");
		Person bella = new Person("Bella", "Little");
		Person kenan = new Person("Kenan", "Cruz Cilli");
		Person kessem = new Person("Kessem", "Adiv");
		Person laura = new Person("Laura", "Katan");
		
		testLibrary.inventory.addAll(Arrays.asList(bible, thesisOne, theGuardian, tkamb, ckThesis, theTimes));
		
	}

}
