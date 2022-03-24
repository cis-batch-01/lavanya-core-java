package com.technocis.Librarian.dao;

import java.util.List;

import com.technocis.Librarian.model.Librarian;

public interface LibrarianDao {

	public List<Librarian> getAllLibrarian();

	public Librarian getLibrarian(int id);

	public Librarian addLibrarian(Librarian librarian);

	public Librarian updateLibrarian(int id,Librarian librarian);

	public Librarian deleteLibrarian(int id);
}
