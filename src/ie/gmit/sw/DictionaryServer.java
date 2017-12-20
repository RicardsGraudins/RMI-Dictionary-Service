package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String[] args) throws IOException {
		/*
		DictionaryServiceImpl dictionary = new DictionaryServiceImpl();
		dictionary.loadDictionary();
		System.out.println(dictionary.lookup("Nefarious"));
		System.out.println(dictionary.lookup("\nAsdf"));
		*/
		
		DictionaryService dictionary = new DictionaryServiceImpl();
		dictionary.loadDictionary();
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dictionaryService", dictionary);
		System.out.println("Server ready.\n");
		
		System.out.println(dictionary.lookup("Nefarious"));
		System.out.println(dictionary.lookup("\nAsdf"));
	}//Main
}//DictionaryServer