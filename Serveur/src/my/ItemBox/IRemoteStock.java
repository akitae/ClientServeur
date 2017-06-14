package my.ItemBox;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
	
public interface IRemoteStock extends Remote{
	public ArrayList<String> getFamille() throws RemoteException;
	public ArrayList<String> getStock(String famille) throws RemoteException;
	public float getPrixProduit(String reference) throws RemoteException;
	public int getNbrProduit(String reference) throws RemoteException;
	public int addStock(String reference,int qte) throws RemoteException;
	public int removeStock(String reference,int qte) throws RemoteException;
	public ArrayList<String> getClients() throws RemoteException;
	public ArrayList<String> getCommandes(String nomClient, String adresse) throws RemoteException;
	public void AjoutClient(String nom, String adresse) throws RemoteException;
	public void SupprimerClient(String nom, String adresse) throws RemoteException;
	public void ModifierClient(String nom, String adresse, String newNom, String newAdresse) throws RemoteException;
}
