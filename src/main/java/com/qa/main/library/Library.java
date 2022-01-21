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
		for (int i = 0; i < inventory.size(); i++) {
			System.out.println(inventory.get(i) + "\n");
		}
		System.out.println("Number of items: " + inventory.size());
	}

	public void printMemberList() {
		for (int i = 0; i < memberList.size(); i++) {
			System.out.print(memberList.get(i) + "\n");
		}
		System.out.println("Number of library members: " + memberList.size() + "\n");
	}

	public void register(Person p) {
		memberList.add(p);
		p.setMemberNo(nextMemberNo);
		nextMemberNo++;
		p.setBalanceDue(0);
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

	public void memberCheckOut(Person p, Item i) {
		if (this.memberList.contains(p) == false) {
			System.out.println("Sorry, only members can check out items.");
		}
		if (this.memberList.contains(p)) {
			if (p.getItemsBorrowed() < 5) {
				if (i.getAvailable() == true) {
					i.setAvailable(false);
					p.setItemsBorrowed(1 + p.getItemsBorrowed());
					p.getLoans().add(i);
					System.out.println(i.getTitle() + " has been checked out by " + p);
				} else if (i.getAvailable() == false) {
					System.out.println("Sorry, this item is unavailable.");
				}
			} else if (p.getItemsBorrowed() >= 5) {
				System.out.println("Sorry, you have 0 loans remaining. Return an item to check out a new item.");
			}
		}
	}

	public void memberCheckIn(Person p, Item i) {
		if (i.getAvailable() == false) {
			i.setAvailable(true);
			p.setItemsBorrowed(p.getItemsBorrowed() - 1);
			p.getLoans().remove(i);
			System.out.println(p.getFirstName() + " " + p.getSurname() + " has returned " + i.getTitle() + ".");
			System.out.println(p.getFirstName() + " " + p.getSurname() + " has " + (5 - p.getItemsBorrowed())
					+ " loans remaining.");
		} else if (i.getAvailable() == true) {
			System.out.println("This item has not been checked out.");
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
