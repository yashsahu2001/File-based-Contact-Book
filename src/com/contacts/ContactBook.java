package com.contacts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContactBook {
	private static final String FILE_NAME = "data/contacts.txt";

	// Constructor to create the file if it does not exist
	public ContactBook() {
		File file = new File(FILE_NAME);
		try {
			// If the file doesn't exist, create it
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file.");
		}
	}

	// Method to add a contact to the file
	public void addContact(Contact contact) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
			writer.write(contact.toString());
			writer.newLine();
			System.out.println("Contact added successfully.");
		} catch (IOException e) {
			System.out.println("An error occurred while adding the contact.");
		}
	}

	// Method to delete a contact by name
	public void deleteContact(String name) {
		File file = new File(FILE_NAME);
		List<String> contacts = new ArrayList<>();
		boolean deleted = false;

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.startsWith(name)) {
					contacts.add(line);
				} else {
					deleted = true;
				}
			}

			if (deleted) {
				try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
					for (String contact : contacts) {
						writer.write(contact);
						writer.newLine();
					}
				}
				System.out.println("Contact deleted successfully.");
			} else {
				System.out.println("Contact not found.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred while deleting the contact.");
		}
	}

	// Method to search for a contact by name
	public void searchContact(String name) {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.startsWith(name)) {
					System.out.println("Contact found: " + line);
					return;
				}
			}
			System.out.println("Contact not found.");
		} catch (IOException e) {
			System.out.println("An error occurred while searching for the contact.");
		}
	}

	// Method to display all contacts
	public void displayAllContacts() {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("An error occurred while displaying the contacts.");
		}
	}
}