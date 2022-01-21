package com.qa.main.library;

import java.util.ArrayList;
import java.util.List;

import com.qa.main.items.Item;
import com.qa.main.person.*;

public class Library {

	private static int nextMemberNo = 1;

	public List<Item> inventory = new ArrayList<Item>();
	public List<Person> memberList = new ArrayList<Person>();

	public void printInventoryList() {
		for (Item i : inventory) {
			System.out.println(i + "\n");
		}
		System.out.println("Number of items: " + inventory.size() + "\n");
	}

	public void printMemberList() {
		for (Person p : memberList) {
			System.out.print(p + "\n");
		}
		System.out.println("Number of library members: " + memberList.size() + "\n");
	}

	public void register(Person p) {
		memberList.add(p);
		p.setMemberNo(nextMemberNo);
		nextMemberNo++;
		p.setItemsBorrowed(0);
		System.out.println(p.getFirstName() + " " + p.getSurname() + " has been registered.");
		System.out.println("Member Number: " + p.getMemberNo() + "\n");
	}

	public void deleteMember(Person p) {
		memberList.remove(p);
		System.out.println(p + " has been removed.");
		System.out.println("\nMembers remaining:");
		printMemberList();
	}

	public String checkOut(Person p, Item i) {
		if (this.memberList.contains(p) == false) {
			return "Sorry, only members can check out items.";
		} else {
			if (p.getItemsBorrowed() < 5) {
				if (i.getAvailable() == true) {
					i.setAvailable(false);
					p.setItemsBorrowed(1 + p.getItemsBorrowed());
					// make addLoan method cos this is tricky
					p.getLoans().add(i);
					return i.getTitle() + " has been checked out by " + p + ". You have " + (5 - p.getItemsBorrowed())
							+ " loans remaining.";
				} else {
					return "Sorry, this item is unavailable.";
				}
			} else {
				return "Sorry, you have 0 loans remaining. Return an item to check out a new item.";
			}
		}
	}

	public String checkIn(Person p, Item i) {
		if (i.getAvailable() == false) {
			i.setAvailable(true);
			p.setItemsBorrowed(p.getItemsBorrowed() - 1);
			p.getLoans().remove(i);
			return p.getFirstName() + " " + p.getSurname() + " has returned " + i.getTitle() + ".\n"
					+ p.getFirstName() + " " + p.getSurname() + " has " + (5 - p.getItemsBorrowed())
					+ " loans remaining.";
		} else {
			return "This item has not been checked out.";
		}
	}

	public void updateMemFName(Person p, String newFName) {
		p.setFirstName(newFName);
	}

	public void updateMemSName(Person p, String newSName) {
		p.setSurname(newSName);
	}

	public void addItem(Item i) {
		inventory.add(i);
	}

	public void removeItem(Item i) {
		inventory.remove(i);
	}

}
