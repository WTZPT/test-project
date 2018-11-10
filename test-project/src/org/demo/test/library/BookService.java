package org.demo.test.library;

public class BookService {
	private BookManager bookManager;
	
	public BookService(BookManager bookManager){
		this.bookManager = bookManager;
	}
	
	public boolean borrowBook (String isbn){ 
		Book book = bookManager.findBook(isbn);
		if (book != null && book.isInShell()){
			// �鼮���ڲ����������
			book.setInShell(false);
			bookManager.updateBook(book); 
			return true;
		}
		return false;
	}
	public boolean returnBook (String isbn){
		Book book = bookManager.findBook(isbn);
		if (book != null && !book.isInShell()){
			book.setInShell(true);
			return true;
		}
		return false;
	}

}
