package program;

import java.util.ArrayList;

public class BookStore {
	private ArrayList<Book> Books;
	
	
	public BookStore(){
		this.Books=new ArrayList<>();
		
	}
	
	
	public double sell(int index) {
		double price= this.Books.get(index).getPrice();
		this.Books.remove(index);
		
		//returns profit
		return price;
		
		
		
		
	}
	
	public void add(Book b) {
		
		this.Books.add(b);
	}
	
	
	

}
