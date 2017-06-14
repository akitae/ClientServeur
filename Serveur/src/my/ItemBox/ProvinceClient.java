package my.ItemBox;
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
       //  iStock.addStock("cc");
         
    	 //iStock.getFamille(); Lister toute les familles
    	 //iStock.getStock("fam") Lister tous les stocks qui appartienne a la famille
//         System.out.println(iStock.getStock("ordinateur"));
//         System.out.println(iStock.getPrixProduit("F02"));
//         System.out.println(iStock.getNbrProduit("F02"));
//         System.out.println(iStock.addStock("F02", 3));
//         System.out.println(iStock.removeStock("F02", 1));
//         System.out.println(iStock.getClients());
         System.out.println(iStock.getCommandes("Dupont Jean", "23 rue loin"));
         iStock.AjoutClient("Jazer Truc", "26 rue perdu");
         iStock.SupprimerClient("Dazed Paul", "26 rue ici");
         iStock.ModifierClient("Jazer Truc", "26 rue perdu","Machin truc","2 rue loin");

 
    } catch (Exception e) {
      System.out.println(e);
    }	
  }
}