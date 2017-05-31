import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
 

public class ProvinceClient {
 
  public static void main(String[] args) {
    try {
    	//Se connecte au serveur et récupère l'objet "stockImplement" envoyé
    	 Registry registry = LocateRegistry.getRegistry(1099);
    	 IRemoteStock iStock = (IRemoteStock) registry.lookup("stockImplement");
//         Stock s = iStock.newStock();
//         System.out.println(s);
//         System.out.println("stock id : " + s.getId());
//         System.out.println("stock famille : " + s.getFamilleComposant());
         
    	 //Ajout d'un stock
         iStock.addStock("cc");
 
    } catch (Exception e) {
      System.out.println(e);
    }	
  }
}