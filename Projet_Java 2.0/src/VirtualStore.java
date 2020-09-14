
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class VirtualStore {
	LinkedList<Transaction> listTransaction = new LinkedList<Transaction>();
	HashMap<String, List<Product>> categories=new HashMap<String, List<Product>>();
	LinkedList<Product> listProduct = new LinkedList<Product>();
	LinkedList<Customer> listCustomer = new LinkedList<Customer>();
	
	public void addCustomer(Customer customer){
		listCustomer.add(customer);
	}
	public void addTransaction(Transaction transaction){
		listTransaction.add(transaction);
	}
	public void addProduct(Product product){
		listProduct.add(product);
	}
	
	
	public List<Product> getListCategories(int id, List<Product> list){
		LinkedList<Product>  sort = new LinkedList<Product>();
		for(Product product : list){
			if(product.idCategory == id){
				sort.add(product);			
			}
		}
		return sort;
	}
	
	
	public List<Customer> getCustomerList(){	
		LinkedList<Customer> copyListCustomer = new LinkedList<Customer>(listCustomer);
		return copyListCustomer;
	}
	public List<Product> getProductList(){	
		LinkedList<Product> copyListProduct = new LinkedList<Product>(listProduct);
		return copyListProduct;
	}
	public List<Product> getTransactionList(){	
		LinkedList<Product> copyListProduct = new LinkedList<Product>(listProduct);
		return copyListProduct;
	}
	
	public void addDvdList(){	
		LinkedList<Product>  dvd = new LinkedList<Product>();
		dvd = (LinkedList<Product>) getListCategories(1,listProduct);
		addCategories("DVDs",dvd);
	}
	
	public void addVideoGamesList(){	
		LinkedList<Product>  games = new LinkedList<Product>();
		games = (LinkedList<Product>) getListCategories(2,listProduct);
		addCategories("VideoGames",games);
	}
	
	public void addCategories(String name,List<Product>listProd){
		categories.put(name,listProd);
	}

	public void addBookList(){	
		LinkedList<Product>  book = new LinkedList<Product>();
		book = (LinkedList<Product>) getListCategories(3,listProduct);
		addCategories("Book",book);
	}
	
	public Product recherche(String name ,List<Product>listProduct){
		for(Product p : listProduct){
			String pname = p.getName();
			if(pname.equals(name)){
				return p;
			}
		}
		return null;
	}
	
	public Customer rechercheCustomer(String name){
		for(Customer c : listCustomer){
			String pname = c.getName();
			if(pname.equals(name)){
				return c;
			}
		}
		return null;
	}

	public void initCateg(){
		addDvdList();
		addVideoGamesList();
		addBookList();
	}
}
