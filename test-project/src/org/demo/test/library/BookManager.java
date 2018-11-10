package org.demo.test.library;

public interface BookManager {
	Book findBook(String isbn); // 根据isbn在数据库中找到相应的书籍
	void updateBook(Book book); // 更新数据库中书籍的状态
}
