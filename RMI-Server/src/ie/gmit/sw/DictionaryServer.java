package ie.gmit.sw;

/* DictionaryServer is responsible for creating an instance of the remote object
 * (DictionaryServerImpl) and binding it to a naming server using the RMI Registry
 * with a human-readable name i.e. rmi://127.0.0.1:1099/dictionaryService.
 */
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String[] args) throws IOException {
		//Create an instance of a DictionaryService. Since DictionaryServiceImpl
		//implements the DictionaryService interface, it can be referred to as
		//a DictionaryService type.
		DictionaryService ds = new DictionaryServiceImpl();
		
		//Invoke the loadDictionary method which loads the dictionary data
		//from a file.
		ds.loadDictionary();
		
		//Start the RMI registry on port 1099
		//which is the default port for RMI
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable
		//name "dictionaryService".
		Naming.rebind("dictionaryService", ds);
		
		System.out.println("Server ready.\n");
		
		//Quick test to ensure everything is working correctly.
		//System.out.println(ds.lookup("Nefarious"));
		//System.out.println(ds.lookup("\n Asdf"));
	}//Main
}//DictionaryServer