import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class VirtualStoreGUI implements ActionListener {

	static VirtualStore vs = new VirtualStore();
	JTextField nameb = new JTextField();	
	JTextArea area = new JTextArea();
    JButton buy = new JButton("Buy"); 
	String languages[]={"DVDs","VideoGames","Books","All"};
	final JComboBox<Object> ln=new JComboBox<Object>(languages);    
	final JComboBox<String> prod=new JComboBox<String>();
	final JComboBox<Object> customer=new JComboBox<Object>();
	
	Customer CurrentCustomer;
	Product CurrentProduct;

	private JComboBox<Object> combination = new JComboBox<Object>();
	final JLabel label = new JLabel("");   
	private JLabel labelCustomer= new JLabel("");
	
	String type;	 
	private final JComboBox<String> CurrentCustomer_1 = new JComboBox<String>();
	private final JLabel image_amazon = new JLabel("amazon");
	  
	public VirtualStoreGUI() {

		JFrame frame = new JFrame("VirtualStoreGUI");
		frame.setMinimumSize(new Dimension(900, 600));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		buy.setActionCommand("key5");
		buy.addActionListener(this);
		nameb.setColumns(5);
		JPanel centerPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		CurrentCustomer_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		CurrentCustomer_1.setEditable(true);
		CurrentCustomer_1.setActionCommand("key4");
		
		bottomPanel.add(CurrentCustomer_1);
		bottomPanel.add(nameb);
		bottomPanel.add(buy);
		frame.getContentPane().add(centerPanel,BorderLayout.CENTER);
		centerPanel.setLayout(null);
		  centerPanel.add(ln);
		
		  ln.setBounds(563, 47,142,43);
		  
		  ln.setActionCommand("key2");
		  label.setLocation(365, 231);
		  centerPanel.add(label);
		  label.setHorizontalAlignment(SwingConstants.LEFT);
		  label.setSize(635,99); 
		  labelCustomer.setLocation(373, 410);
		  centerPanel.add(labelCustomer);
		  labelCustomer.setHorizontalAlignment(SwingConstants.LEFT);  
		  labelCustomer.setSize(699,94); 
		  centerPanel.add(prod);
		  prod.setBounds(57,231,298,99);	 
		  
		prod.setActionCommand("key3");
		centerPanel.add(customer);
		customer.setBounds(57,410,298,94);
		
		customer.setActionCommand("key4");
		JButton b=new JButton("Show");
		centerPanel.add(b);
		b.setBounds(731,52,102,32);  
		
		JLabel lblNewLabel = new JLabel("PRODUITS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(57, 206, 298, 14);
		centerPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUSTOMER");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(57, 365, 298, 14);
		centerPanel.add(lblNewLabel_1);
		image_amazon.setIcon(new ImageIcon("images-300x164.png"));
		image_amazon.setBounds(57, 11, 309, 164);
		
		centerPanel.add(image_amazon);
		customer.addActionListener(this);
		prod.addActionListener(this);
		  ln.addActionListener(this);
		frame.getContentPane().add(bottomPanel,BorderLayout.SOUTH);	

		frame.pack();
		frame.setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) { 
		
		case "key2": 
			String categ = (String) ln.getItemAt(ln.getSelectedIndex());
        	switch(categ) {
	    		case "All": 
	    			type="All";
	    			LinkedList<Product> lProd = (LinkedList<Product>) vs.getProductList();
	    			for(Product l : lProd){
	    				prod.addItem(l.getName());
	    			}		    			
	    		break;
	    		case "DVDs":
	    			type="DVDs";
				vs.categories.get("DVDs");
	    			for(Product l : vs.categories.get("DVDs")){
	    				prod.addItem(l.getName());
	    			}
	    		break;
	    		case "VideoGames":
	    			type="VideoGames";
	    			LinkedList<Product> lVg = (LinkedList<Product>) vs.categories.get("VideoGames");

	    			for(Product l : lVg){
	    				prod.addItem(l.getName());
	    			}
		    		break;
	    		case "Book":
	    			type="Book";
	    			LinkedList<Product> lBook = (LinkedList<Product>) vs.categories.get("Book");

	    			for(Product l : lBook){
	    				prod.addItem(l.getName());
	    			}
		    		break; 
        	}
		
		break;
	
		case "key3": 
			LinkedList<Product> ltemp = new LinkedList<Product>();
			ltemp.clear();				
			String data = prod.getItemAt(prod.getSelectedIndex())+"";
			if(type=="All"){
				ltemp=(LinkedList<Product>) vs.getProductList();
			}
			else {
				ltemp = (LinkedList<Product>) vs.categories.get(type);
			}	
			
			CurrentProduct = vs.recherche(data, ltemp);
			label.setText(CurrentProduct.toString());
		break;
		
		case "key4": 
			String name = customer.getItemAt(customer.getSelectedIndex())+"";	
			CurrentCustomer = vs.rechercheCustomer(name);
			labelCustomer.setText(CurrentCustomer.toString());			
		break;
		
		case "key5": 
			
			String tmpnb = nameb.getText();
			int namebre = Integer.parseInt(tmpnb);
			if(CurrentProduct.stock >= namebre){
				CurrentProduct.stock = CurrentProduct.stock - namebre;
				new Transaction(CurrentCustomer.getId(),CurrentProduct.getId(),namebre);			
				JOptionPane.showConfirmDialog(null, 
			                "Cliquez sur OK pour commander", "Confirmer la commande", JOptionPane.DEFAULT_OPTION);
			}
			else{
				JOptionPane.showMessageDialog(null,"stock", "Le stock est insuffisant", JOptionPane.OK_OPTION);
			}
		break;
		}
	}
	
	class ItemAction implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	      System.out.println("ActionListener : action sur " + combination.getSelectedItem());
	    }               
	  }
	

	public static void main(String[] args){
		
		Books livre1 =new Books(1,"Le consentement",3,18,7,"Gael Faye",Language.FRANCAIS,200);
		Books livre2 =new Books(2,"Les jumeaux de Piolenc",3,12,5,"Sandrine Destombes ",Language.FRANCAIS,200);
		Books livre3 =new Books(3,"La panthere des neiges",3,18,12,"Sylvain Tesson ",Language.FRANCAIS,200);
		Books livre4 =new Books(4,"A meme la peau",3,15,9,"Lisa Gardner",Language.FRANCAIS,200);

		VideoGames jeu1 = new VideoGames(4,"Luigi's Mansion 3",2,44,17,VideoGamesGenre.ACTION,Plateform.NINTENDO);
		VideoGames jeu2 = new VideoGames(4,"God of War",2,14,8,VideoGamesGenre.AVENTURE,Plateform.PLAYSTATION);
		VideoGames jeu3 = new VideoGames(4,"Star Wars Jedi : Fallen Order",2,39,12,VideoGamesGenre.ACTION,Plateform.XBOX);
		VideoGames jeu4 = new VideoGames(4,"Kingdom Hearts 3",2,16,19,VideoGamesGenre.STRATEGIE,Plateform.NINTENDO);

		Dvd dvd1 = new Dvd(3,"Le Roi Lion",1,1,2,MovieGenre.FAMILLE,80);
		Dvd dvd2 = new Dvd(3,"Alita : Battle Angel",1,1,2,MovieGenre.ACTION,90);
		Dvd dvd3 = new Dvd(3,"Apollo 11",1,1,2,MovieGenre.AVENTURE,120);
		Dvd dvd4 = new Dvd(3,"Ant-Man et la Guepe",1,1,2,MovieGenre.SUPER_HERO,100);

		Customer cl1 =new Customer(1,"brieuc","BERANGER");
		Customer cl2 =new Customer(1,"ahmed","OULDSAMBA");
		Customer cl3 =new Customer(1,"maxime","GUENNETEAU");

		vs.addProduct(livre1);
		vs.addProduct(livre2);
		vs.addProduct(livre3);
		vs.addProduct(livre4);

		vs.addProduct(jeu1);
		vs.addProduct(jeu2);
		vs.addProduct(jeu3);
		vs.addProduct(jeu4);

		vs.addProduct(dvd1);
		vs.addProduct(dvd2);
		vs.addProduct(dvd3);
		vs.addProduct(dvd4);

		vs.initCateg();
		vs.addCustomer(cl1);
		vs.addCustomer(cl2);
		vs.addCustomer(cl3);

		System.out.println("Welcome to Amazoooones");
		new VirtualStoreGUI();
	}
}

