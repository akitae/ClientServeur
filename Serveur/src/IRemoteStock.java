import java.rmi.Remote;
import java.rmi.RemoteException;
	
public interface IRemoteStock extends Remote{
	    Stock newStock() throws RemoteException;
}
