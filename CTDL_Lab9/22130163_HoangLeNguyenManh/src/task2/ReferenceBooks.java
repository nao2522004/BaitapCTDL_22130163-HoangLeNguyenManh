package task2;

import java.util.List;

public class ReferenceBooks extends Publications {
	private String field;
	private List<Chapter> chapter;


	public ReferenceBooks(String title, int numOfPage, int year, String author, int price, String field,
			List<Chapter> chapter) {
		super(title, numOfPage, year, author, price);
		this.field = field;
		this.chapter = chapter;
	}


	public String getField() {
		return field;
	}


	public List<Chapter> getChapter() {
		return chapter;
	}



	@Override
	public String getType() {
		return "ReferenceBooks";
	}


	@Override
	public int getChapterPageNum() {
		int chapPageNum = 0;
		for (Chapter chapters : chapter) {
			chapPageNum += chapters.getNumOfPage();
		}
		return chapPageNum;
	}
	
	

}
