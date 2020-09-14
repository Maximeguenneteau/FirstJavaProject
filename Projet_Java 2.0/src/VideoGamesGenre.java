
public enum VideoGamesGenre {
	ARCADE,AVENTURE,ROLE,COURSE,FPS,MULTI_JOUEURS,EDUCATIFS,MMORPG,STRATEGIE,ACTION;


	private String type;

	private VideoGamesGenre(String type){
		this.setType(type);
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}
}

