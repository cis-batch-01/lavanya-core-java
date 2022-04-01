package bookmanagement.daotest;

import bookmanagement.dao.AuthorDao;
import bookmanagement.dao.AuthorDaoImpl;
import bookmanagement.dao.BookDao;
import bookmanagement.dao.BookDaoImpl;

public class BookDaoImplTest {
public static void main(String[] args) {
	
BookDao bookDao=new BookDaoImpl();
	System.out.println(bookDao.getAllBooks());
//System.out.println(bookDao.getAllBooks());
	//AuthorDao authorDao=new AuthorDaoImpl();
	//System.out.println(authorDao.getAllAuthorList("b001"));
	
}

}
