import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProvinceServeur {
 
  public static void main(String[] args) {
    try {
    	//Initialisation base de donnée 

    	String url = "jdbc:mysql://localhost/clientserveur";
    	String username = "root";
    	String password = "";
    	Statement st = null;
    	Connection connection = null;
    	System.out.println("Connecting database...");

    	try {
    		//Connexion à la base de donnée
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection(url, username, password);
    	    System.out.println("Database connected!");
    	    
    	    //Création d'une demande
    	    st = connection.createStatement();
    	    String sql = "INSERT INTO `client` (`nom`) VALUES ('personne')";
    	    st.execute(sql);
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	} catch (ClassNotFoundException e){
    		e.printStackTrace();
    	} finally{
    		//fin de la connection
    		try{
    			connection.close();
    			st.close();
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    	}
    
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