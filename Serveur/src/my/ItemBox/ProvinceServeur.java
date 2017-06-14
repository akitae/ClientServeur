package my.ItemBox;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ProvinceServeur {
 
  public static void main(String[] args) {
    try {
    	
    	//Initialisation du registre RMI
    	Registry registry = LocateRegistry.createRegistry(1099);
    	
    	System.setProperty("java.security.policy", "AllPermission.policy");
    	
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