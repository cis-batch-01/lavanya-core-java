package com.technocis.Librarian.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import com.technocis.Librarian.model.Librarian;
import com.technocis.Librarian.dao.LibrarianDaoImpl;

public class LibraryManagement {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			LibrarianDaoImpl librarianDaoImpl = new LibrarianDaoImpl();
			char option = 'n';
			do {

				System.out.println(
						"1.List of Librarian \n2.Get a particular Librarian details \n3.Add a Librarian details \n4.Update a Librarian details \n5.Remove a Librarian details");
				int choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1:
					System.out.println("List of Librarians");
					List<Librarian> librarianList = librarianDaoImpl.getAllLibrarian();
					System.out.println(librarianList);
					break;

				case 2:
					System.out.println("Enter the Librarian id to view: ");
					int id = Integer.parseInt(br.readLine());
					Librarian viewLibrarian = librarianDaoImpl.getLibrarian(id);
					System.out.println(viewLibrarian != null ? "Id viewed\n" + viewLibrarian : "Id not found");
					break;

				case 3:
					System.out.println("Enter the Librarian details:  (name,phoneNo,email,password,joinDate,address,areaOfInterest) ");
					String addDetails = br.readLine();
					Librarian newLibrarian = Librarian.createLibrarian(addDetails);
					Librarian librarianNew = librarianDaoImpl.addLibrarian(newLibrarian);
					System.out
							.println(librarianNew != null ? "Librarian details added" : "Librarian details not added");
					break;

				case 4:
					System.out.println("Enter the Librarian id to be updated: ");
					int updateId = Integer.parseInt(br.readLine());
					System.out.println("Enter the Librarian details to be modified ");
					String modifiedDetails = br.readLine();
					Librarian updatedLibrarian = Librarian.createLibrarian(modifiedDetails);
					Librarian modifiedLibrarian = librarianDaoImpl.updateLibrarian(updateId, updatedLibrarian);
					System.out.println(modifiedLibrarian != null ? "Librarian details modified"
							: "Librarian details not modified");
					break;

				case 5:
					System.out.println("Enter the Librarian id to be deleted: ");
					int deleteId = Integer.parseInt(br.readLine());
					Librarian deletedLibrarian = librarianDaoImpl.deleteLibrarian(deleteId);
					System.out.println(deletedLibrarian != null ? "Librarian details deleted\n" + deletedLibrarian
							: "Librarian details not deleted");

					break;
				default:
					System.out.println("Invalid Choice");
					break;
				}
				System.out.println("Do you want to continue (Y/N)");
				option = br.readLine().charAt(0);
			} while (option == 'y' || option == 'Y');

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}