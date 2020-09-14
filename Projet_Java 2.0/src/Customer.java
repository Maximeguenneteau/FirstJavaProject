
public class Customer {
	int id;
	String name;
	String adress;


	public Customer (int id ,String name,String adress){
		this.id = id;
		this.name = name;
		this.adress = adress;
	}
	
	public  String toString (){
		return "Numero de customer : " + id + "  name : " + name + "  information :" + adress  ;
	}

	public String getAdresse(){
		return this.adress;
	}

	public String getName(){
		return this.name;
	}

	public int getId(){
		return this.id;
	}

}
