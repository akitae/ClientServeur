import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProvinceServeur {
 
  public static void main(String[] args) {
    try {
    	//Initialisation du registre RMI
    	Registry registry = LocateRegistry.createRegistry(1099);
      
      //Création d'un stock
//    	Stock s = new Stock();
//    	s.setId(6);
//    	s.setFamilleComposant("fammille");
      
//      //Envoi de l'objet stock
//    	StockImpl stockImpl = new StockImpl(s);
//    	registry.rebind("stockImplement", stockImpl);
    	
    	//Donne l'acces au client au methode stockRemote par le RMI
    	StockImpl stockImpl = new StockImpl();
    	registry.rebind("stockImplement", stockImpl);
      
      //Fin de l'initialisation du serveur
    	System.out.println("Serveur ok!!!");
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}