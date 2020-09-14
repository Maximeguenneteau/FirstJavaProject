public class Product {
	int id;
	String nameProduct;
	int idCategory;
	float price;
	int stock;
	

	public Product(int id ,String nameProduct,int idCategory, float price, int stock){
		this.id = id;
		this.nameProduct = nameProduct;
		this.idCategory = idCategory;
		this.price = price;
		this.stock = stock;
	}
	
	public  String toString (){
		return "id du Product : " + id + "  Name : " + nameProduct + "  Category :" +idCategory+ "  Prix :" +price+ " Quantite en Stock "+stock  ;
	}
	
	public int getId(){
		return this.id;
	}

	public String getName(){
		return this.nameProduct;
	}
}
