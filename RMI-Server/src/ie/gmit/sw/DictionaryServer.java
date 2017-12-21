package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String[] args) throws IOException {
		DictionaryService ds = new DictionaryServiceImpl();
		ds.loadDictionary();
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dictionaryService", ds);
		System.out.println("Server ready.\n");
		
		//Testing..
		System.out.println(ds.lookup("Nefarious"));
		System.out.println(ds.lookup("\nAsdf"));
	}//Main
}//DictionaryServer