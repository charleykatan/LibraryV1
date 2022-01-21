package com.qa.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.qa.main.items.*;
import com.qa.main.library.Library;
import com.qa.main.person.Person;

public class TestLibrary {

	Library testLibrary = new Library();
	Books bible = new Books("The Bible", "Anon", "Anon", 0, 1000, "Religious");
	Theses thesisOne = new Theses("A Proof of Light", "Bella", "Little", 2022, "Physics");
	Newspapers theGuardian = new Newspapers("The Guardian", "The", "Guardian", 2021, 1356);
	Person charley = new Person("Charley", "Katan");
	Person bella = new Person("Bella", "Little");
	Person kenan = new Person("Kenan", "Cruz Cilli");
	Person kessem = new Person("Kessem", "Adiv");
	Person laura = new Person("Laura", "Katan");
	
	@Test
	public void testCheckOut() {
		testLibrary.register(bella);
		testLibrary.memberCheckOut(bella, bible);
		assertTrue(bella.getLoans().contains(bible));
	}

	@Test
	public void testCheckIn() {
		testLibrary.register(charley);
		testLibrary.memberCheckOut(charley, bible);
		testLibrary.memberCheckOut(charley, thesisOne);
		testLibrary.memberCheckIn(charley, bible);
		assertFalse(charley.getLoans().contains(bible));
	}

	@Test
	public void testAdd() {
		testLibrary.addItem(thesisOne);
		assertTrue(this.testLibrary.inventory.contains(thesisOne));
	}

	@Test
	public void testRemove() {
		testLibrary.removeItem(bible);
		assertFalse(this.testLibrary.inventory.contains(bible));
	}

	@Test
	public void updateItemTitle() {
		bible.updateTitle("King James Bible");
		assertEquals("King James Bible", bible.getTitle());
	}

	@Test
	public void updateAuthor() {
		bible.updateASur("Melech");
		bible.updateAFir("Hashem");
		assertTrue(bible.toString().contains("Hashem"));
	}

	@Test
	public void registerPerson() {
		testLibrary.register(kenan);
		assertTrue(testLibrary.memberList.contains(kenan));
	}
	
	@Test
	public void deleteMember() {
		testLibrary.register(kessem);
		testLibrary.register(laura);
		testLibrary.deleteMember(laura);
		assertFalse(testLibrary.memberList.contains(charley));
	}
}
