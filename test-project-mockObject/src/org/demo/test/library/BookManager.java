package org.demo.test.library;

public interface BookManager {
	Book findBook(String isbn); // ����isbn�����ݿ����ҵ���Ӧ���鼮
	void updateBook(Book book); // �������ݿ����鼮��״̬
}
