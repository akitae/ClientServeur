import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Statement;


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
	public void addStock(String n) throws RemoteException {
		Connexion c = new Connexion();
		c.requeteSql("INSERT INTO `stock`(`id`, `reference`, `famille`, `prix`, `nombre`) VALUES (null,'ref','fam','3','4')");
		
	}
}
