package ie.gmit.sw;

import java.rmi.Remote;
import java.rmi.RemoteException;
/* DictionaryService represents the Remote Interface. DictionaryService is an
 * abstraction that defines what an implementing class must do, but not how it will
 * do it. Our remote interface here exposes the public service methods that may be
 * invoked by a remote object.
 * 
 * All remote methods must throw a RemoteException for a variety of reasons
 * e.g. connection error, poor design/implementation etc. In RMI, the class
 * that implements a remote interface is called a Remote Object i.e. 
 * DictionaryServiceImpl is a remote object.
 */
public interface DictionaryService extends Remote {
	public String lookup(String s) throws RemoteException;
	public void loadDictionary() throws RemoteException;
	public void addWord(String word, String definition) throws RemoteException;
	public void deleteWord(String word, String definition) throws RemoteException;
}//DictionaryService