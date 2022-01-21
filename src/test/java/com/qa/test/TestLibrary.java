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
	Person ben = new Person("Ben", "Reiff");

	@Test
	public void testCheckOut() {
		testLibrary.register(bella);
		testLibrary.checkOut(bella, bible);
		assertTrue(bella.getLoans().contains(bible));
	}

	@Test
	public void testCheckIn() {
		testLibrary.register(charley);
		testLibrary.checkOut(charley, bible);
		testLibrary.checkOut(charley, thesisOne);
		testLibrary.checkIn(charley, bible);
		assertTrue(bible.getAvailable());
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

	@Test
	public void checkoutNotMember() {
		assertEquals("Sorry, only members can check out items.", testLibrary.checkOut(bella, bible));
	}

	@Test
	public void tooManyLoans() {
		testLibrary.register(kessem);
		testLibrary.checkOut(kessem, bible);
		testLibrary.checkOut(kessem, thesisOne);
		testLibrary.checkOut(kessem, ckThesis);
		testLibrary.checkOut(kessem, theGuardian);
		testLibrary.checkOut(kessem, theTimes);
		assertEquals("Sorry, you have 0 loans remaining. Return an item to check out a new item.",
				testLibrary.checkOut(kessem, theTimes));

	}
	
	@Test
	public void alreadyCheckedOut() {
		testLibrary.register(laura);
		testLibrary.register(charley);
		testLibrary.checkOut(laura, tkamb);
		assertEquals("Sorry, this item is unavailable.", testLibrary.checkOut(charley, tkamb));
	}

	@Test
	public void CheckedInNotCheckedOut() {
		testLibrary.register(ben);
		assertEquals("This item has not been checked out.", testLibrary.checkIn(ben, ckThesis));
	}

	@Test
	public void updateMemberRecord() {
		testLibrary.register(bella);
		assertEquals("Isabella", testLibrary.updateMemFName(bella, "Isabella"));
	}
}
