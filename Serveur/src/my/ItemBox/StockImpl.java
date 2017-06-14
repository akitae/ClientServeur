package my.ItemBox;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class StockImpl extends UnicastRemoteObject implements IRemoteStock{
	Stock stock;

	//enregistre un stock pour l'envoyer
	protected StockImpl(Stock s) throws RemoteException {
		super();
		stock = s;
	}
	
	public StockImpl()throws RemoteException {
		super();
	}
	
	//recupere le stock
	public Stock newStock() throws RemoteException {
		return this.stock;
	}
	
	//Ajoute un nouvel objet dans le stock
	public int addStock(String reference,int qte) throws RemoteException {
		Connexion c = new Connexion();
		int nombre= this.getNbrProduit(reference);
		nombre = nombre + qte;
		c.requeteSql("UPDATE stock SET nombre ='" + nombre + "'WHERE reference ='" + reference +"'");
		return nombre;
	}
	
	public int removeStock(String reference,int qte) throws RemoteException {
		Connexion c = new Connexion();
		int nombre= this.getNbrProduit(reference);
		nombre = nombre - qte;
		c.requeteSql("UPDATE stock SET nombre ='" + nombre + "'WHERE reference ='" + reference +"'");
		return nombre;
	}
	
	public ArrayList<String> getFamille() throws RemoteException{
		Connexion c = new Connexion();
		return c.requeteExecuteSql("SELECT DISTINCT famille FROM stock");
	}
	
	public ArrayList<String> getStock(String famille) throws RemoteException{
		Connexion c = new Connexion();
		return c.requeteExecuteSql("SELECT reference FROM stock WHERE famille ='" + famille +"'");
	}
	
	public float getPrixProduit(String reference) throws RemoteException{
		Connexion c = new Connexion();
		ArrayList<String> r = c.requeteExecuteSql("SELECT prix FROM stock WHERE reference ='" + reference +"'");
		if(r!=null){
			return Float.parseFloat(r.get(0));
		}
		return 0;
	}
	
	public int getNbrProduit(String reference) throws RemoteException{
		Connexion c = new Connexion();
		ArrayList<String> r = c.requeteExecuteSql("SELECT nombre FROM stock WHERE reference ='" + reference +"'");
		if(r!=null){
			return Integer.parseInt(r.get(0));
		}
		return 0;
	}
	
	public ArrayList<String> getClients() throws RemoteException{
		Connexion c = new Connexion();
		return c.requeteExecuteSql("SELECT nom, adresse FROM client ORDER BY nom");
	}
	
	public ArrayList<String> getCommandes(String nomClient, String adresse) throws RemoteException{
		Connexion c = new Connexion();
		ArrayList<String> idClients = c.requeteExecuteSql("SELECT id FROM client WHERE nom='"+nomClient+"' AND adresse='"+adresse+"'");
		int idClient;
		if(idClients != null){
			idClient = Integer.parseInt(idClients.get(0));
			c = new Connexion();
			return c.requeteExecuteSql("SELECT prixTotal, modePaiement FROM commande WHERE id_client='"+idClient+"'");
		}
		return null;
	}
	
	public void AjoutClient(String nom, String adresse) throws RemoteException{
		Connexion c = new Connexion();	
		c.requeteSql("INSERT INTO client(id,nom,adresse) VALUES (null,'"+nom+"','"+adresse+"')");
	}

	public void SupprimerClient(String nom, String adresse) throws RemoteException{
		Connexion c = new Connexion();	
		c.requeteSql("DELETE FROM client WHERE nom='"+nom+"' AND adresse='"+adresse+"'");
	}
	
	public void ModifierClient(String nom, String adresse, String newNom, String newAdresse) throws RemoteException{
		Connexion c = new Connexion();	
		c.requeteSql("UPDATE client SET nom ='" + newNom + "', adresse='"+newAdresse+"'WHERE nom ='" + nom +"' AND adresse='"+adresse+"'");
	}
}