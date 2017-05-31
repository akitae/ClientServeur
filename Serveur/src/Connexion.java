import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Connexion {

	String url = "jdbc:mysql://localhost/clientserveur";
	String username = "root";
	String password = "";
	Statement st = null;
	Connection connection = null;
	
	public Connexion(){
		//Initialisation base de donnée 
		System.out.println("Connecting database...");
		
		try {
			//Connexion à la base de donnée
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		    System.out.println("Database connected!");
		
		} catch (SQLException e) {
    	    e.printStackTrace();
    	} catch (ClassNotFoundException e){
    		e.printStackTrace();
    	}
	}
	
	public void requeteSql(String sql){
		//creation et envoie de la requete
		try{
			st = connection.createStatement();
		    st.execute(sql);
		} catch (SQLException e) {
    	    e.printStackTrace();
    	} finally{
//    		fin de la connection
    		try{
    			connection.close();
    			st.close();
    		}catch(SQLException e){
    			e.printStackTrace();
    		}
    	}
	}


	
	
}
