package task2;

public class Magazine extends Publications {
	private String name;

	public Magazine(String title, int numOfPage, int year, String author, int price, String name) {
		super(title, numOfPage, year, author, price);
		this.name = name;
	}
	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String getType() {
		return "Magazine";
	}


	
	
	
}
