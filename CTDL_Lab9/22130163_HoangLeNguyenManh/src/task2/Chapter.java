package task2;

public class Chapter {
	private String title;
	private int numOfPage;

	public Chapter(String title, int numOfPage) {
		super();
		this.title = title;
		this.numOfPage = numOfPage;
	}

	public String getTitle() {
		return title;
	}

	public int getNumOfPage() {
		return numOfPage;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNumOfPage(int numOfPage) {
		this.numOfPage = numOfPage;
	}

}
