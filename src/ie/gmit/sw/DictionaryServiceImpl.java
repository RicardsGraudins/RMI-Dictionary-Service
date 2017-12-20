package ie.gmit.sw;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {
	private static final long serialVersionUID = 1L;
	private String word;
	
	public DictionaryServiceImpl() throws RemoteException {
		super();
	}

	@Override
	public String lookup(String s) throws RemoteException {
		return word;
	}

}//DictionaryService