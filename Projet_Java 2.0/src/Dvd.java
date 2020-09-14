
public class Dvd extends Product {
	int duration;
	MovieGenre type;
	 
	public Dvd(int id,String name,int idCategory, float price,int stock,MovieGenre type,int duration)
	{
		super(id,name,idCategory,price,stock);
		this.type = type;
		this.duration = duration;
	}

}
