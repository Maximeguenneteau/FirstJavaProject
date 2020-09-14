
public class Books extends Product {
	int pages;
	String author;
	Language language;
	
	public Books(int id,String name,int idCategory, float price,int stock,String author,Language language, int pages){
		super(id,name,idCategory,price,stock);
		this.pages =pages;
		this.author = author;
		this.language =language;
	}
}
