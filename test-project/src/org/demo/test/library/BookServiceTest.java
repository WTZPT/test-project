package org.demo.test.library;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.*;

import org.demo.test.account.AccountManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookServiceTest {
	
	private BookManager bookManager;
	private BookService bookService;
	
	@Before
	public void setUp() throws Exception {
		bookManager = createMock("bookManager",BookManager.class);
		
		bookService = new BookService(bookManager);
		
	}

	@Test
	public void testBorrowBook() {
		Book book1 = new Book("Java","123",20.2,true);
		Book book2 = new Book("Web","124",20.9,false);
		Book book3 = new Book("JavaScript","125",20.9,false);
		
		bookManager.updateBook(book1);
		bookManager.updateBook(book2);
		
		/**
		 * 定义查询接口返回值
		 */
		expect(bookManager.findBook("123")).andReturn(book1);
		expect(bookManager.findBook("124")).andReturn(book2);
		expect(bookManager.findBook("126")).andReturn(null);
		
		/**
		 * 
		 */
		replay(bookManager);
		
		/**
		 * 执行测试
		 */
		bookService.borrowBook("123");
		bookService.borrowBook("124");
		bookService.borrowBook("126");
		
		assertEquals(false, book1.isInShell());
		assertEquals(false, book2.isInShell());
	}

	

	@Test
	public void testReturnBook() {
		Book book1 = new Book("Java","123",20.2,true);
		Book book2 = new Book("Web","124",20.9,false);
		
		bookManager.updateBook(book1);
		bookManager.updateBook(book2);
		
		expect(bookManager.findBook("123")).andReturn(book1);
		expect(bookManager.findBook("124")).andReturn(book2);
		expect(bookManager.findBook("126")).andReturn(null);
		
		replay(bookManager);
		
		bookService.returnBook("123");
		bookService.returnBook("124");
		bookService.returnBook("126");
		
		assertEquals(true, book1.isInShell());
		assertEquals(true, book2.isInShell());
				
	}

}
