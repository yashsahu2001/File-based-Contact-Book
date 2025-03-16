package com.contacts;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ContactBook contactBook = new ContactBook();

		while (true) {
			System.out.println("\n--- Contact Book Menu ---");
			System.out.println("1. Add Contact");
			System.out.println("2. Delete Contact");
			System.out.println("3. Search Contact");
			System.out.println("4. Display All Contacts");
			System.out.println("5. Exit");
			System.out.print("Choose an option: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // consume the newline character

			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				String name = scanner.nextLine();
				System.out.print("Enter phone number: ");
				String phoneNumber = scanner.nextLine();
				System.out.print("Enter email: ");
				String email = scanner.nextLine();
				Contact newContact = new Contact(name, phoneNumber, email);
				contactBook.addContact(newContact);
				break;
			case 2:
				System.out.print("Enter name of contact to delete: ");
				String deleteName = scanner.nextLine();
				contactBook.deleteContact(deleteName);
				break;
			case 3:
				System.out.print("Enter name of contact to search: ");
				String searchName = scanner.nextLine();
				contactBook.searchContact(searchName);
				break;
			case 4:
				System.out.println("Displaying all contacts:");
				contactBook.displayAllContacts();
				break;
			case 5:
				System.out.println("Exiting the program.");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}