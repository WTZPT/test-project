package org.demo.test.library;


public class Book {
	private String name;
	private String isbn; //书号
	private double price;
	private boolean inShell; // 是否在架上
	
	public Book(){}
	public Book(String name, String isbn, double price, 
			boolean inShell){
		this.name = name;
		this.isbn = isbn;
		this.price = price;
		this.inShell = inShell;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getISBN(){
		return this.isbn;
	}
	public void setISBN(String isbn){
		this.isbn = isbn;
	}
	
	public double getPrice(){
		return this.price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	
	public boolean isInShell(){
		return this.inShell;
	}
	public void setInShell(boolean inShell){
		this.inShell = inShell;
	}
	
}
