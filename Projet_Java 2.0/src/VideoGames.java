
public class VideoGames extends Product{
	Plateform plateforme;
	VideoGamesGenre type;
	
	public VideoGames(int id,String name,int idCategory, float price,int stock,VideoGamesGenre type,Plateform plateforme){
		super(id,name,idCategory,price,stock);
		this.type = type;
		this.plateforme = plateforme;
	}

}
