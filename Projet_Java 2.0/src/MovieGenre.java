
public enum MovieGenre {
	
    COMEDIE("comedie"),
    ACTION("action"),
    AVENTURE("aventure"),
    DRAME("drame"),
    SUPER_HERO("super_hero"),
    DESSIN_ANIME("dessin_anime"),
    FAMILLE("famille"),FANTASY("fantasy"),
    SCI_FI("sci_fi"),
    HORREUR("horreur");
	
	private String type;
	
	private MovieGenre(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
