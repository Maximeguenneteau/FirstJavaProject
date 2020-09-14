import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	String date;
	int customerId;
	int productId;
	int nbProducts;
	
	public Transaction(int customerId,int productId,int nbProducts){
		this.customerId = customerId;
		this.productId = productId;
		this.nbProducts = nbProducts;
		this.date = getDateNow();
	}
	
	public String getDateNow(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
