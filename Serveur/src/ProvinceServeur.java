import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProvinceServeur {
 
  public static void main(String[] args) {
    try {
    	//Initialisation base de donnée 

//    	Class.forName("com.mysql.jdbc.driver");
//    	String url = "jdbc:mysql://localhost:3306/clientserveur";
//    	String username = "root";
//    	String password = "";
//
//    	System.out.println("Connecting database...");
//
//    	try (Connection connection = DriverManager.getConnection(url, username, password)) {
//    	    System.out.println("Database connected!");
//    	} catch (SQLException e) {
//    	    throw new IllegalStateException("Cannot connect the database!", e);
//    	}
    
    	//Create and get reference to rmi registry
    	Registry registry = LocateRegistry.createRegistry(1099);
      
      //Création d'un stock
    	Stock s = new Stock();
    	s.setId(6);
    	s.setFamilleComposant("fammille");
      
      //Envoi de l'objet stock
    	StockImpl stockImpl = new StockImpl(s);
    	registry.rebind("stockImplement", stockImpl);
      
      //Fin de l'initialisation du serveur
    	System.out.println("Serveur ok!!!");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}