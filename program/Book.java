package program;

import java.util.ArrayList;

public class Book{

private String title;

private String author;

private double price;

private int ID;

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public String getTitle() {
	return title;
}

public String getAuthor() {
	return author;
}

public int getID() {
	return ID;
}

public Book(String title, String author,double price, int ID) {
	this.title=title;
	this.author=author;
	this.price=price;
	this.ID=ID;
	
}

public String toString() {
	return title+" by:"+author+" $"+price+" ID:"+ID;
	
}

public boolean equal(Book b) {
	return this.title.equals(b.getTitle())&&this.author.equals(b.getAuthor());
	
}













}