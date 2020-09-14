
public class Category {

	int id;
	String wording;
	String information;
	
	public  String showCategory (){
		return "Numero de Category : " + id + "  name : " + wording + "  information :" + information  ;
	}

	public Category (int id ,String wording,String info){
		this.id = id;
		this.wording = wording;
		this.information = info;
	}

}
