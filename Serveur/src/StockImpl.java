import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class StockImpl extends UnicastRemoteObject implements IRemoteStock{
	Stock stock;

	//enregistre un stock pour l'envoyer
	protected StockImpl(Stock s) throws RemoteException {
		super();
		stock = s;
	}
	 
	//recupere le stock
	public Stock newStock() throws RemoteException {
		return this.stock;
	}
}
